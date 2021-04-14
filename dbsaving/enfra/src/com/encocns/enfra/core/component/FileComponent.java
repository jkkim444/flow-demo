package com.encocns.enfra.core.component;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.encocns.enfra.core.component.vo.FileVO;
import com.encocns.enfra.core.service.ServiceConst;
import com.encocns.enfra.core.session.SessionVO;
import com.encocns.enfra.db.dao.CCO_M_ATCHFILE_DAO;

@Component
public class FileComponent {

	private ArrayList<FileVO> fileArr;

	@Value("#{globalContext}")
	protected Properties globalContextProp;

	@Autowired
	private CCO_M_ATCHFILE_DAO daoCCO_M_ATCHFILE;

	public FileComponent(){}

	//업로드여부
	public boolean isUploadFiles()
	{
		if( null == fileArr )
		{
			return false;
		}
		else if( fileArr.size()==0 )
		{
			return false;
		}

		return true;
	}

	//업로드
	public void uploadFiles() throws Exception
	{
		if(!isUploadFiles())
		{
			throw new Exception("");
		}
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = sra.getRequest();

		SessionVO sessionVO = (SessionVO)request.getSession().getAttribute(ServiceConst.SERVICE_CONTEXT_KEY);

		//file upload
		for( FileVO fileVO : fileArr )
		{
			File serverFile = null;
			File tempServerFile = null;

			File dir = new File(fileVO.getUpload_path());
			if (!dir.exists()) dir.mkdirs();

			try
			{
				serverFile = new File(fileVO.getFile_path_cntn());
				//// 임시 업로드 디렉토리에 파일 지정
				tempServerFile = new File( globalContextProp.getProperty("FILE_UPLOAD_TEMP_PATH") + "/" + fileVO.getFile_nm() );

				//move File
				tempServerFile.renameTo( serverFile );

				//file info insert
				fileVO.setSession_id(sessionVO.getUserId());
				fileVO.setFile_seq(daoCCO_M_ATCHFILE.selFileSeq(fileVO));

				daoCCO_M_ATCHFILE.insAtchFile( fileVO );
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
	}//upload

	//TODO : 2020.12.17 차상길 수정 ( 동부저축은행, 파일테이블 화면ID 제거 )
//	public HashMap<String, ArrayList<FileVO>> getAttachFileList( String scrnId )
//	{
//		ArrayList<FileVO> fCompList = daoCCO_M_ATCHFILE.selAtchFileComp( scrnId );
//
//		HashMap<String, ArrayList<FileVO>> fileMap = new HashMap<String, ArrayList<FileVO>>();
//
//		for( FileVO fileVO : fCompList )
//		{
//			ArrayList<FileVO> fileList = daoCCO_M_ATCHFILE.selAtchFileList( fileVO );
//			fileMap.put(fileVO.getFile_cpnt_id().replace(fileVO.getScr_id()+"_", ""), fileList);
//		}
//
//		return fileMap;
//	}

	public ArrayList<FileVO> getAttachFileList(String scrnId, String fileCpntId) {
		FileVO fileVO = new FileVO();

		fileVO.setScr_id(scrnId);
		fileVO.setFile_cpnt_id(fileCpntId);

		ArrayList<FileVO> fileList = daoCCO_M_ATCHFILE.selAtchFileList(fileVO);

		for(FileVO row : fileList) {

			try {
                row.setFile_nm(URLEncoder.encode(row.getFile_nm(), "UTF-8").replaceAll("\\+"," "));
            } catch (UnsupportedEncodingException e) {
            }
			row.setYear(row.getFile_path_cntn().substring(row.getFile_path_cntn().lastIndexOf("/")-4, row.getFile_path_cntn().lastIndexOf("/")));
//			row.setStr_file_size(str_file_size);

			//보안상 파일경로는 반환하지 않는다.
			row.setFile_path_cntn("");
		}

		return fileList;
	}

    public int deleteFileList(String scrnId, String fileCpntId, int fileSeq){
        FileVO fileVO = new FileVO();
        int iResult = 0;
        File file;

        fileVO.setScr_id(scrnId);
        fileVO.setFile_cpnt_id(fileCpntId);
        fileVO.setFile_seq(fileSeq);

        ArrayList<FileVO> fileList = daoCCO_M_ATCHFILE.selAtchFileList(fileVO);

        for(FileVO row : fileList) {
            if( -1 == fileSeq || fileSeq == row.getFile_seq()){
                iResult = iResult + daoCCO_M_ATCHFILE.delAtchFile(row);
                file = new File(row.getFile_path_cntn());
                if(file.exists()){
                    file.delete();
                }
            }
        }

        return iResult;
    }

	//setter/getter
	public ArrayList<FileVO> getFileArr() {
		return fileArr;
	}

	public void setFileArr(ArrayList<FileVO> fileArr) {
		this.fileArr = fileArr;
	}
}
