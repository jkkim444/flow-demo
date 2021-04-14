/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file MessageWriter.java
 * @brief
 * \~english Generate MessageProperty File
 * \~korean 메세지 프로퍼티 파일 생성
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 9. 2. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ifrs.co.message
 * @brief Common Message Package
 */
package com.encocns.ifrs.co.message;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

/**
 * @brief
 * \~english Generate MessageProperty File
 * \~korean 메세지 프로퍼티 파일 생성
 * @details
 * \~english Generate MessageProperty File
 * \~korean 메세지 프로퍼티 파일 생성
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 9. 2.
 * @version : 1.0.0
 */
public class MessageWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageWriter.class);

    /**
     * @brief
     * \~english Main method
     * \~korean Main method
     * @details
     * <pre>
     * \~english Main 메소드
     * \~korean Main 메소드
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 9. 2.
     * @param args
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("/spring/context/context-*.xml");

        try {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("===== Start message code generation. =====");
            }
            
//            String[] arrLocale = commonProperties.getProperty("LOCALE_LIST").split(",");
            
            LocaleContextHolder.setLocale(Locale.ENGLISH);

            Properties commonProperties = (Properties)appContext.getBean("common");

            SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) appContext.getBean("sqlSessionTemplate");

            try {
                String[] localeList = commonProperties.getProperty("LOCALE_LIST").split(",");
                List<Map<String, String>> msgCdList = sqlSessionTemplate.selectList("common.selectMsgCdList");
                
                if(localeList.length > 0) {
                    String localeLanguage = "";
                    
                    for (String locale : localeList) {
                        localeLanguage = locale.substring(0, locale.indexOf('_'));
                        
                        File file = new File(commonProperties.getProperty("MESSAGE_PATH") + "_" + localeLanguage + ".properties");
                        
                        if(file.exists()) file.delete();
                        
                        try(BufferedWriter wr = Files.newBufferedWriter(Paths.get(commonProperties.getProperty("MESSAGE_PATH") + '_' + localeLanguage + ".properties"), StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
                            for (Map<String, String> msgCd : msgCdList) {
                                if(msgCd.get("LCL_CD").equals(locale)) {
                                    wr.write(msgCd.get("MSG_CD") + "=" + msgCd.get("MSG_CNTN") + "\r\n");
                                }
                            }

                            wr.flush();
                            wr.close();
                        }
                        
                        if(LOGGER.isDebugEnabled()) {
                            String result = commonProperties.getProperty("MESSAGE_PATH") + "_" + locale + ".properties ---> SUCCESS!";
                            LOGGER.debug(result);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("===== End message code generation. =====");
            }
        } catch (BeansException e) {
            e.printStackTrace();
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }

    }

}
