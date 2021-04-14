/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SourceGenBean.java
 * @brief 
 * \~english 영어로 간략 설명을 작성한다.
 * \~korean 한글로 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - HONG, GIL-DONG | 2019. 9. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.velocity
 * @brief 
 */
package com.encocns.fw.velocity;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @brief 
 * \~english 영어로 간략 설명을 작성한다.
 * \~korean 한글로 간략 설명을 작성한다.
 * @details 
 * <pre>
 * \~english 영어로 상세 설명을 작성한다.
 * \~korean 한글로 상세 설명을 작성한다.
 * </pre>
 * @author : HONG, GIL-DONG
 * @date : 2019. 9. 26.
 * @version : 1.0.0
 */
@Component
public class SourceGenBean extends VelocityEngine {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SourceGenBean.class);
    
    private String preFilePath; 
    
    @Value("#{globalContext}")
    protected Properties globalContextProp;
    
    public void init(){
        this.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        this.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        preFilePath = globalContextProp.getProperty("PROJECT_PATH");
        super.init();
    }
    
    public void setGetTemplateGen( DTODescription desc ){
        String templateFile = "com/encocns/fw/velocity/DTOTemplet.vm";
        
        createFile(getVelocityCtx( "dto", desc ), preFilePath + "/src/" + desc.getFilePath(), desc.getFileNm()+".java", templateFile);
    }
    

    public void daoTemplateGen( DAODescription desc ){
        String templateFile = "com/encocns/fw/velocity/DAOTemplet.vm";
        
        createFile(getVelocityCtx( "dao", desc ), preFilePath + "/src/" + desc.getFilePath(), desc.getFileNm()+".java", templateFile);
    }
    
    public void mapperTemplateGen( MapperDescription desc ){
        String templateFile = "com/encocns/fw/velocity/MapperTemplet.vm";

        System.out.println(preFilePath);
        
        createFile(getVelocityCtx( "mapper", desc ), preFilePath + "/src/" + desc.getFilePath(), desc.getFileNm()+".xml", templateFile);
    }
    
    public void serviceTemplateGen( ServiceDescription desc ){
        String templateFile = "com/encocns/fw/velocity/ServiceTemplet.vm";
        
        createFile(getVelocityCtx( "service", desc ), preFilePath + "/src/" + desc.getFilePath(), desc.getFileNm()+".java", templateFile);
    }
    
    
    public void javaScriptTemplateGen( JavaScriptDescription desc ){
        String templateFile = "com/encocns/fw/velocity/JavaScriptTemplet.vm";
        
        createFile(getVelocityCtx( "script", desc ), preFilePath + "/" + desc.getFilePath(), desc.getFileNm()+".js", templateFile);
    }
    
    public void jspTemplateGen( JspDescription desc, String popYyn ){
        
        String templateFile = "com/encocns/fw/velocity/JspTemplet.vm";
        if( "Y".equals(popYyn) ) templateFile = "com/encocns/fw/velocity/JspPopupTemplet.vm";
        
        createFile(getVelocityCtx( "screen", desc ), preFilePath + "/" + desc.getFilePath(), desc.getFileNm()+".jsp", templateFile);
    }
    
    public VelocityContext getVelocityCtx( String type, Object desc ){
        VelocityContext context = new VelocityContext();
        context.put(type, desc);
        return context;
    }
    
    public void createFile( VelocityContext context, String path, String fileNm, String templateFile ) {
        
        try {
            Template template = this.getTemplate(templateFile, "UTF-8");
            
            String file  = path.replaceAll("\\.", "/") + "/" + fileNm;
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

            template.merge(context, writer);

            writer.flush();
            writer.close();
        }
        catch( Exception e ) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }
    }
    
}
