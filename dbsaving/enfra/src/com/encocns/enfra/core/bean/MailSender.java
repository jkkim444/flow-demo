/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file MailSender.java
 * @brief 
 * 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - 홍길동 | 2019. 11. 11. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.enfra.core.bean
 * @brief 
 */
package com.encocns.enfra.core.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @brief 
 * 메일전송Bean
 * @details 
 * <pre>
 * 메일전송Bean
 * </pre>
 * @author : 이좌형
 * @date : 2019. 11. 11.
 * @version : 1.0.0
 */
public class MailSender extends JavaMailSenderImpl{
    
    private String subjectEncoding;
    private String serverUrl;
    private String contextPath;
    private String fileUploadPath;
    
    public Multipart setMessage( MimeMessage message, String content ) throws Exception {
        
        Multipart mp = new MimeMultipart();
        
        MimeBodyPart contentPart = new MimeBodyPart();
        
        String[] imgs = content.split("<");
        
        List<Map<String,String>> imgList = new ArrayList<Map<String,String>>();
        
        
        String urlFilePath = serverUrl + contextPath + "/dextImgDownload.dx"; 
        
        int idx = 0;
        for( String img : imgs ) {
            
            Map<String, String> imgMap = new HashMap<String,String>();
            
            String pre = "<";
            
            if( img.indexOf("img")<0 ) continue;
            
            String tag = pre + img.substring(0, img.indexOf(">"));
//            System.out.println(tag);
            //src 경로 추출
            
            String cid = "_img"+(idx+1);
            String filePath = tag.substring(tag.indexOf("src=\"")+5).replace("\"", "");
            String fileName = filePath.substring( filePath.lastIndexOf("/")+1);
            String oldChar = tag+">";
            String newChar = tag.replace(filePath, "cid:"+cid) + ">";
            filePath = filePath.replace(urlFilePath, fileUploadPath+"/dext5editor");
            
//            System.out.println("==============================================");
//            System.out.println(cid);
//            System.out.println(filePath);
//            System.out.println(oldChar);
//            System.out.println(newChar);
            
            imgMap.put("cid", cid);
            imgMap.put("filePath", filePath);
            imgMap.put("fileName", fileName);
//            imgMap.put("oldChar", oldChar);
//            imgMap.put("newChar", newChar);
            
            content = content.replace(oldChar, newChar);
            
            imgList.add(imgMap);
            
            idx++;
            
        }//for
        
        
//        System.out.println("===========================================================================");
//        System.out.println(content);
        //set message
        contentPart.setContent(content, "text/html;charset=UTF-8");
        mp.addBodyPart(contentPart);
        
        MimeBodyPart mbp;
        FileDataSource fds;

        //image mutlipart body 정보
        for( Map<String,String> imgMap : imgList ) {
            
            String cid = imgMap.get("cid");
            String file = imgMap.get("filePath");
            String fileName = imgMap.get("fileName");
            
            mbp = new MimeBodyPart();
            fds = new FileDataSource(file);
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(MimeUtility.encodeText(fileName, "euc-kr", "B"));
            mbp.setHeader("Content-ID", cid);
            
            mp.addBodyPart(mbp);
            
            message.setContent(mp);
            
        }//for
        
        message.setContent(mp);
        
        return mp;
        
    }
    
    public void setMessage( MimeMessage message, String content, Map<String,File> contentsMap ) throws Exception {
        
        Multipart mp = setMessage( message, content );
        
        MimeBodyPart mbp;
        FileDataSource fds;
        File file;
        
        Set<String> contensIDKeys = contentsMap.keySet();
        
        Iterator<String> itaID = contensIDKeys.iterator();
        
        String contentID;
        while( itaID.hasNext() )
        {
            contentID = itaID.next();
            
            file = contentsMap.get(contentID);
            
            mbp = new MimeBodyPart();
            fds = new FileDataSource(file.getAbsoluteFile());
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(MimeUtility.encodeText(file.getName(), "euc-kr", "B"));
            mbp.setHeader("Content-ID", "test");
            
            
            mp.addBodyPart(mbp);
            
            message.setContent(mp);
        }
    }
    
    
    public void setMessage( MimeMessage message, String content, File... files ) throws Exception {
        
        Multipart mp = setMessage( message, content );
        
        MimeBodyPart mbp;
        FileDataSource fds;
        
        for( File file : files )
        {
            mbp = new MimeBodyPart();
            fds = new FileDataSource(file.getAbsoluteFile());
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(MimeUtility.encodeText(file.getName(), "euc-kr", "B"));
            mp.addBodyPart(mbp);
        }
        
        message.setContent(mp);
    }
    
    
    public void setMessage( MimeMessage message, String content, Map<String,File> contentsMap, File... files ) throws Exception {
        
        Multipart mp = setMessage( message, content );
        
        MimeBodyPart mbp;
        FileDataSource fds;
        
        //setContent ID
        Set<String> contensIDKeys = contentsMap.keySet();
        Iterator<String> itaID = contensIDKeys.iterator();
        
        String contentID;
        while( itaID.hasNext() )
        {
            contentID = itaID.next();
            
            File file = contentsMap.get(contentID);
            
            mbp = new MimeBodyPart();
            fds = new FileDataSource(file.getAbsoluteFile());
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(MimeUtility.encodeText(file.getName(), "euc-kr", "B"));
            mbp.setHeader("Content-ID", "test");
            
            mp.addBodyPart(mbp);
        }
        
        //setAttachFile
        for( File file : files )
        {
            mbp = new MimeBodyPart();
            fds = new FileDataSource(file.getAbsoluteFile());
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(MimeUtility.encodeText(file.getName(), "euc-kr", "B"));
            
            mp.addBodyPart(mbp);
        }
        
        message.setContent(mp);
    }
    
    public String getSubjectEncoding() {
        return subjectEncoding;
    }

    public void setSubjectEncoding(String subjectEncoding) {
        this.subjectEncoding = subjectEncoding;
    }
    
    
    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public static void main(String[] args) {
        
        String html = "<p style=\"line-height: 1.2; font-family: 굴림; font-size: 12pt; margin-top: 0px; margin-bottom: 0px;\"><img style=\"width: 382px; height: 107px;\" src=\"http://localhost:6060/ad/dextImgDownload.dx/2020/01/20200129_235608581_29177.jpeg\"><br></p>";
        
        
//        System.out.println( html.split("<img") );
        
//        System.out.println(html);
        
        //<img src=\"cid:image\">";
        
        String[] imgs = html.split("<");
//        
        System.out.println(imgs.length);
        
        //conentid, filepath, olchar, new char
        List<Map<String,String>> imgList = new ArrayList<Map<String,String>>();
        
        String urlFilePath = "http://localhost:6060" + "/ad" + "/dextImgDownload.dx"; 
        String fileUploadPath = "F:/KPMG_Project/dext/el";
        
        int idx = 0;
        for( String img : imgs ) {
            
//            System.out.println("======================================");
//            System.out.println(img);
            
            Map<String, String> imgMap = new HashMap<String,String>();
            
            String pre = "<";
            
            if( img.indexOf("img")<0 ) continue;
            
            String tag = pre + img.substring(0, img.indexOf(">"));
//            System.out.println(tag);
            
            //src 경로 추출

            
            String cid = "_img"+(idx+1);
            String filePath = tag.substring(tag.indexOf("src=\"")+5).replace("\"", "");
            String fileName = filePath.substring( filePath.lastIndexOf("/")+1); 
            String oldChar = tag+">";
            String newChar = tag.replace(filePath, "cid:"+cid) + ">";
            filePath = filePath.replace(urlFilePath, fileUploadPath);
            
            System.out.println("==============================================");
            System.out.println(cid);
            System.out.println(filePath);
            System.out.println(fileName);
            
            System.out.println(oldChar);
            System.out.println(newChar);
            
//            imgMap.put("cid", cid);
//            imgMap.put("filePath", filePath);
//            imgMap.put("oldChar", oldChar);
//            imgMap.put("newChar", newChar);
            
            html = html.replace(oldChar, newChar);
            
            imgList.add(imgMap);
            
            idx++;
            
        }//for
//        
        System.out.println(html);
        
//        for( Map<String,String> imgMap : imgList ) {
//            
//            String oldChar = imgMap.get("oldChar");
//            String newChar = imgMap.get("newChar");
//            
//            html = html.replace(oldChar, newChar);
//            
//            
//            //mutlipart body 정보 
//        }
//        
//        
//        System.out.println(html);
        
        
        
    }

}
