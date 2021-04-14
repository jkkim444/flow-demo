/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FileDownloadView.java
 * @brief File Download View
 */
/**
 * @namespace com.encocns.fw.view
 * @brief View Package
 */
package com.encocns.fw.view;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.encocns.enfra.exception.EnfraDownloadException;

/**
 * @brief
 * \~english 파일 다운로드에 사용되는 View
 * \~korean 파일 다운로드에 사용되는 View
 * @details
 * \~english 파일 다운로드에 사용되는 View
 * \~korean 파일 다운로드에 사용되는 View
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 10. 27.
 * @version : 1.0.0
 */
public class FileDownloadView extends AbstractView {

    public FileDownloadView() {
        setContentType("applicaiton/download;charset=utf-8");
    }

    /**
     * @brief
     * \~english FileDownloadView
     * \~korean FileDownloadView
     * @details
     * <pre>
     * \~english 파일 다운로드를 한다.
     * \~korean 파일 다운로드를 한다.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 27.
     * @see org.springframework.web.servlet.view.AbstractView#renderMergedOutputModel(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * @param model
     * <pre>
     * filePath         : 파일경로
     * fileName         : 파일명
     * </pre>
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        if(model.get("errorMessage") != null) {
            String sErrorMessage = String.valueOf(model.get("errorMessage"));
            
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println("<html><head><meta charset=\"utf-8\" /></head><body><script type='text/javascript'>");
            writer.println("alert('" + sErrorMessage + "');");
            writer.println("</script></body></html>");
            writer.flush();
            writer.close();
            return;
        }

        String filePath = (String)model.get("filePath");
        String fileName = (String)model.get("fileName");
        File file = new File(filePath + '/' + fileName);

        if( file.exists() && file.isFile() ) {
            response.setContentType(getContentType());
            response.setContentLength((int)file.length());

            String sExportFileName = String.valueOf(model.get("exportFileName"));
            
            if(model.get("exportFileName") != null) {
                fileName = sExportFileName;
            }
            
            String excelFileNm = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name()).replaceAll("\\+"," ");

            response.setContentType("application/octet-stream; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + excelFileNm + "\";");
            response.setHeader("Content-Transfer-Encoding", "binary");
            if (request.isSecure()) {
                response.setHeader("Cache-Control", "public");
                response.setHeader("Pragma", "public");
            }

            setCookie(response,"fileDownload=true; path=/");
            
            OutputStream os = response.getOutputStream();
            
            try(InputStream is = Files.newInputStream(Paths.get(filePath + '/' + fileName))) {
                FileCopyUtils.copy(is, os);
                os.flush();
            } catch(Exception e){
                if(logger.isErrorEnabled()) logger.error(e.getMessage(), e);
//                throw new EnfraBusinessException();
                throw new EnfraDownloadException();
            }
            
//            FileInputStream fis = null;

//            try {
//                fis = new FileInputStream(file);
//                FileCopyUtils.copy(fis, out);
//                out.flush();
//            } catch(Exception e){
//                if(logger.isErrorEnabled()) logger.error(e.getMessage(), e);
//                throw new EnfraBusinessException();
//            }finally{
//                if(fis != null){
//                    try{
//                        fis.close();
//                    }catch(Exception e){}
//                }
//            }// try end;
//
//            if(model.containsKey("isPBNF")) {
//                file.delete();
//                File targetDir = new File(filePath);
//                FileUtils.deleteDirectory(targetDir);
//            }
        } else {
            if(logger.isErrorEnabled()) logger.error("Fil not found.");
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("text/html; charset=UTF-8");
//            
//            PrintWriter writer = response.getWriter();
//            writer.println("<html><head><meta charset=\"utf-8\" /></head><body>");
//            writer.println("<script type='text/javascript'>");
//            writer.println("parent.Dialog.alert( \"E000026\", function(){});");
//            writer.println("</script></body></html>");
//            writer.flush();
//            writer.close();
            setCookie(response,"fileDownload=notexistfile; path=/");
            
            return;
        }
    }
    
    private void setCookie( HttpServletResponse response, String cookieCntn ) {
        response.setHeader("Set-Cookie", cookieCntn);
    }
}
