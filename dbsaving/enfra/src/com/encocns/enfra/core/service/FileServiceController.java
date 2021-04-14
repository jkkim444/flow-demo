package com.encocns.enfra.core.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.encocns.enfra.core.bean.ServiceBeanManager;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.component.vo.FileVO;
import com.encocns.enfra.core.util.JsonUtil;
import com.encocns.enfra.db.dao.CCO_M_ATCHFILE_DAO;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.transaction.TransactionVO;
import com.encocns.enfra.util.VOUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class FileServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceController.class);

    @Autowired
    private ObjectProvider<ServiceBeanManager> sbmProvider;

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private CCO_M_ATCHFILE_DAO daoCCO_M_ATCHFILE;

	@Value("#{globalContext}")
	protected Properties globalContextProp;

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> fileUpload( HttpServletRequest request, HttpServletResponse response, Model model ) throws EnfraBusinessException, UnsupportedEncodingException
	{

		if(LOGGER.isDebugEnabled()) LOGGER.debug("##### fileUpload Start!");

		LOGGER.debug("PRAM: " +  request.getParameter("bizCd") );
		LOGGER.debug("PRAM: " +  request.getParameter("scrnId") );
		LOGGER.debug("PRAM: " +  request.getParameter("fileCompId") );




		HttpHeaders responseHeaders = new HttpHeaders();
		request.setCharacterEncoding("UTF-8");


		FileVO fileVO = new FileVO();

		BufferedOutputStream stream = null;

		String filePath = globalContextProp.getProperty("FILE_UPLOAD_PATH");

		ServiceBeanManager sbm = sbmProvider.getObject();

		TransactionVO transactionVO = new TransactionVO();
        transactionVO.setService("FileUpload");
        transactionVO.setMethod("fileUpload");

        sbm.setTransactionVO(transactionVO);


        LOGGER.debug("1111=============================================================");

		try
		{
			//getFileInfo
			MultipartHttpServletRequest mphsRequest = (MultipartHttpServletRequest)request;
			MultipartFile file = mphsRequest.getFile("fileData");

			String fileName = file.getOriginalFilename();

//			if(System.getProperty("os.name").startsWith("Win")) {
//				fileName =  new String(file.getOriginalFilename().getBytes("8859_1"),"UTF-8");
//			}

//			System.out.println(fileName);

			String currentYear = DateFormatUtils.format(new Date(), "yyyy");

			fileVO.setBiz_lcls_cd( request.getParameter("bizCd") );
			fileVO.setScr_id( request.getParameter("scrnId") );
			fileVO.setFile_cpnt_id( request.getParameter("fileCompId") );
			fileVO.setFile_size(file.getSize());
			fileVO.setUpload_path(filePath);
			fileVO.setYear(currentYear);
			fileVO.setSession_id(serviceComponent.getSessionVO().getUserId());
			fileVO.setFile_nm(fileName);
			fileVO.setFile_seq(daoCCO_M_ATCHFILE.selFileSeq(fileVO));

			//print file vo
			if(LOGGER.isDebugEnabled())  VOUtil.printLogVO(fileVO, LOGGER);

			LOGGER.debug("2222=============================================================");


			String fileFullPath = globalContextProp.getProperty("FILE_UPLOAD_PATH") + "/" + request.getParameter("scrnId") + "/" + currentYear;

			File uploadPath = new File(fileFullPath);

			// 업로드 디렉토리에 파일 생성
			if(!uploadPath.exists()) {
				uploadPath.mkdirs();
			}

			//중복된 파일이 있는 경우 숫자를 붙여준다.
			boolean isDuplicate = true;
			int iCount = 1;

			String filename_name = fileName.substring(0, fileName.lastIndexOf("."));
			String filename_ext = fileName.substring(fileName.lastIndexOf(".")+1);

			// 확장자 체크
			String sValidationExtList = globalContextProp.getProperty("FILE_UPLOAD_EXT_LIST");
			String[] arrValidationExtList = sValidationExtList.split(",");

			boolean isValidataionExt = false;

			for(String ext : arrValidationExtList) {
				if(ext.equals(filename_ext.toLowerCase())) {
					isValidataionExt = true;
					break;
				}
			}

			if(!isValidataionExt) {
				throw new EnfraBusinessException("E000008", sValidationExtList);
			}

			// 용량 체크
			int iValidationMaxSize = Integer.parseInt(globalContextProp.getProperty("FILE_UPLOAD_MAX_SIZE"));

			iValidationMaxSize = iValidationMaxSize * 1024 * 1024;

			if(file.getSize() > iValidationMaxSize) {
				throw new EnfraBusinessException("E000006", iValidationMaxSize+" Mb");
			}

			String tempFileName = fileName;

			File serverFile = null;

			while(isDuplicate) {
				serverFile  = new File(fileFullPath + "/" + tempFileName );

				if (serverFile.isFile()) {
					tempFileName = filename_name + "(" + iCount  + ")." + filename_ext;
					iCount++;
				} else {
					isDuplicate = false;
				}
			}

			fileVO.setFile_real_nm(tempFileName); //변경된 최종 파일명 SET
			fileVO.setFile_path_cntn(fileFullPath + "/" + tempFileName); //파일 PATH 내용 SET

			LOGGER.debug("3333=============================================================");


			stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(file.getBytes());

			daoCCO_M_ATCHFILE.insAtchFile( fileVO );

			LOGGER.debug("4444=============================================================");

			fileVO.setFile_path_cntn("");
			fileVO.setUpload_path("");

			fileVO.setFile_nm(URLEncoder.encode(fileVO.getFile_nm(), "UTF-8").replaceAll("\\+"," "));
			fileVO.setFile_real_nm(URLEncoder.encode(fileVO.getFile_real_nm(), "UTF-8").replaceAll("\\+"," "));

			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("fileVO :" + fileVO.toString());
//				LOGGER.debug("JSONObject.fromObject(fileVO).toString() : " + JSONObject.fromObject(fileVO).toString());
			}

			stream.close();
		}
		catch( EnfraBusinessException ex )
		{
			LOGGER.debug("fileError2222!!!!");
			LOGGER.debug(ex.getMessage());
			throw ex;
		}
		catch( Exception e )
		{
			LOGGER.debug("fileError!!!!!");
			LOGGER.debug(e.getMessage());
			e.printStackTrace();
		}


		ArrayList<FileVO> selectFileList = daoCCO_M_ATCHFILE.selAtchFileList(fileVO);

		for( FileVO f : selectFileList )
		{
		    f.setFile_nm(URLEncoder.encode(f.getFile_nm(), "UTF-8").replaceAll("\\+"," "));
//		    f.setFile_path_cntn(URLEncoder.encode(f.getFile_path_cntn(), "UTF-8"));
		    f.setFile_path_cntn("");
		}

		FileVO outputFile = daoCCO_M_ATCHFILE.selAtchFile(fileVO);

		outputFile.setFile_nm(URLEncoder.encode(outputFile.getFile_nm(), "UTF-8").replaceAll("\\+"," "));
		outputFile.setFile_path_cntn(URLEncoder.encode(outputFile.getFile_path_cntn(), "UTF-8").replaceAll("\\+"," "));


		LOGGER.debug("file갯수 :" + selectFileList.size());
//		LOGGER.debug("outpu file :" + JSONObject.fromObject(outputFile).toString());


//        ArrayList<FileVO> outputFile = daoCCO_M_ATCHFILE.selAtchFileList(fileVO);
//
//        for(FileVO row : outputFile) {
//            row.setFile_nm(URLEncoder.encode(row.getFile_nm(), "UTF-8"));
////            row.setYear(row.getFile_path_cntn().substring(row.getFile_path_cntn().lastIndexOf("/")-4, row.getFile_path_cntn().lastIndexOf("/")));
//            //보안상 파일경로는 반환하지 않는다.
//            row.setFile_path_cntn("");
//        }
//
//        LOGGER.debug("outpu file :" + JSONArray.fromObject(outputFile).toString());

		return new ResponseEntity<String>(JsonUtil.toJsonObject(outputFile).toString(), responseHeaders, HttpStatus.OK);
//		return new ResponseEntity<String>(JSONArray.fromObject(outputFile).toString(), responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/fileDelete", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> fileDelete( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception
	{

	    LOGGER.debug("fileDelete:");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

		request.setCharacterEncoding("UTF-8");

//		JSONArray deleteList = JSONArray.fromObject(request.getParameter("fileData"));
		JsonArray deleteList = JsonUtil.toJsonArray(request.getParameter("fileData"));

		FileVO selfileVO = null;

		LOGGER.debug("deleteList : " + deleteList.toString());

		for( int i=0; i<deleteList.size(); i++ ){

//		    JSONObject file = JSONObject.fromObject(deleteList.get(i));
		    JsonObject file = JsonUtil.toJsonObject(deleteList.get(i));

	        FileVO fileVO = new FileVO();
//	        fileVO.setScr_id(file.getString("scr_id"));
//	        fileVO.setFile_cpnt_id(file.getString("file_cpnt_id"));
//	        fileVO.setFile_seq(Integer.parseInt(file.getString("file_seq")));

	        fileVO.setScr_id(file.get("scr_id").getAsString());
	        fileVO.setFile_cpnt_id(file.get("file_cpnt_id").getAsString());
	        fileVO.setFile_seq(Integer.parseInt(file.get("file_seq").getAsString()));

	        selfileVO  = daoCCO_M_ATCHFILE.selAtchFile(fileVO);

	        try
	        {
	            File _file = new File(selfileVO.getFile_path_cntn());

	            if( _file.isFile() )
	            {
	                _file.delete();
	            }

	            FileVO vo = new FileVO();

	            vo.setScr_id(selfileVO.getScr_id());
	            vo.setFile_cpnt_id(selfileVO.getFile_cpnt_id());
	            vo.setFile_seq(selfileVO.getFile_seq());

	            daoCCO_M_ATCHFILE.delAtchFile(vo);
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }

		}

		ArrayList<FileVO> selectFileList = daoCCO_M_ATCHFILE.selAtchFileList(selfileVO);

        for( FileVO f : selectFileList )
        {
            f.setFile_nm(URLEncoder.encode(f.getFile_nm(), "UTF-8").replaceAll("\\+"," "));
            f.setFile_path_cntn(URLEncoder.encode(f.getFile_path_cntn(), "UTF-8").replaceAll("\\+"," "));
        }

//        ArrayList<FileVO> tmp = new ArrayList<FileVO>();
//        tmp.add(selfileVO);
//        tmp.add(selfileVO);

//        JSONArray res = new JSONArray();
        JsonArray res = new JsonArray();

        if(selectFileList.size()==0){
//            res = new JSONArray();
            res = new JsonArray();
//            res = JSONArray.fromObject(tmp);
        }else {
//            res = JSONArray.fromObject(selectFileList);
            res = JsonUtil.toJsonArray(selectFileList);
        }

        LOGGER.debug("out deleteList : " + res.toString());

		return new ResponseEntity<String>(res.toString(), responseHeaders, HttpStatus.OK);
	}

    @RequestMapping(value = "/fileAllDelete", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> fileAllDelete( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception
    {

        LOGGER.debug("fileAllDelete:");

        HttpHeaders responseHeaders = new HttpHeaders();
        request.setCharacterEncoding("UTF-8");

//        JSONArray deleteList = JSONArray.fromObject(request.getParameter("fileData"));
        JsonArray deleteList = JsonUtil.toJsonArray(request.getParameter("fileData"));

        LOGGER.debug("deleteList : " + deleteList.toString());

        for( int i=0; i<deleteList.size(); i++ ){

//            JSONObject file = JSONObject.fromObject(deleteList.get(i));
            JsonObject file = JsonUtil.toJsonObject(deleteList.get(i));

            FileVO fileVO = new FileVO();
            fileVO.setFile_cpnt_id(file.get("file_cpnt_id").getAsString());
            fileVO.setScr_id(file.get("scr_id").getAsString());

            ArrayList<FileVO> selectFileList = daoCCO_M_ATCHFILE.selAtchFileList(fileVO);

            for( FileVO f : selectFileList )
            {
                try
                {
                    File _file = new File(f.getFile_path_cntn());

                    if( _file.isFile() )
                    {
                        _file.delete();
                    }

                    FileVO vo = new FileVO();

                    vo.setScr_id(f.getScr_id());
                    vo.setFile_cpnt_id(f.getFile_cpnt_id());
                    vo.setFile_seq(f.getFile_seq());
                    daoCCO_M_ATCHFILE.delAtchFile(vo);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }//delete list

//        JSONObject res = new JSONObject();
        JsonObject res = new JsonObject();

        return new ResponseEntity<String>(res.toString(), responseHeaders, HttpStatus.OK);
    }


	@RequestMapping(value = "/fileDownload", method = RequestMethod.POST)
	public String fileDownload( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception
	{

	    FileVO fileVO = new FileVO();
	    fileVO.setFile_cpnt_id(request.getParameter("file_cpnt_id"));
	    fileVO.setFile_seq(Integer.parseInt(request.getParameter("file_seq")));
	    fileVO.setScr_id(request.getParameter("scr_id"));

	    FileVO selfileVO  = daoCCO_M_ATCHFILE.selAtchFile(fileVO);

		String filePath = "";
        String fileName = "";

		if( null != selfileVO )
		{
		    filePath = selfileVO.getFile_path_cntn().substring(0,selfileVO.getFile_path_cntn().lastIndexOf("/"));
		    fileName = URLDecoder.decode(selfileVO.getFile_nm(), "UTF-8");
		}
		model.addAttribute("filePath", filePath);
		model.addAttribute("fileName", fileName);

		return "fileDownloadView";
	}

    @RequestMapping(value = "/fileSelect", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> fileSelect( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception
    {
        HttpHeaders responseHeaders = new HttpHeaders();
        request.setCharacterEncoding("UTF-8");


        FileVO fileVO = new FileVO();

        fileVO.setScr_id(request.getParameter("scr_id"));
        fileVO.setFile_cpnt_id(request.getParameter("file_cpnt_id"));

        ArrayList<FileVO> fileList = daoCCO_M_ATCHFILE.selAtchFileList(fileVO);

        for(FileVO row : fileList) {
            row.setFile_nm(URLEncoder.encode(row.getFile_nm(), "UTF-8").replaceAll("\\+"," "));
            row.setYear(row.getFile_path_cntn().substring(row.getFile_path_cntn().lastIndexOf("/")-4, row.getFile_path_cntn().lastIndexOf("/")));
            //보안상 파일경로는 반환하지 않는다.
            row.setFile_path_cntn("");
        }


//        return new ResponseEntity<String>(JSONArray.fromObject(fileList).toString(), responseHeaders, HttpStatus.OK);
        return new ResponseEntity<String>(JsonUtil.toJsonArray(fileList).toString(), responseHeaders, HttpStatus.OK);

    }



}

