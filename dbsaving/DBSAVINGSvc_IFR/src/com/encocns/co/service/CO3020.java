/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO3020.java
 * @brief 메시지 코드 관리 service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service
 * @brief Common Service Package
 */
package com.encocns.co.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO3020DAO;
import com.encocns.co.dto.CO302001DTO;
import com.encocns.co.service.svo.CO302001IN;
import com.encocns.co.service.svo.CO302001OUT;
import com.encocns.co.service.svo.CO302002IN;
import com.encocns.co.service.svo.CO302002OUT;
import com.encocns.co.service.svo.CO302003IN;
import com.encocns.co.service.svo.CO302003OUT;
import com.encocns.co.service.svo.CO302004IN;
import com.encocns.co.service.svo.CO302004OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.FixedLengthRule;
import com.encocns.enfra.validator.rule.MaxLengthRule;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;

/**
 * @brief 메시지 코드 관리 Service
 * @details 메시지 코드 관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class CO3020 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CO3020.class);

    @Value("#{globalContext}")
    protected Properties globalContextProp;

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
    private CO3020DAO daoMsgCd;

    @Autowired
    private Environment env;


    /**
     * @brief 메시지 코드 조회
     * @details 메시지 코드 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO302001IN
     * @return CO302001OUT
     */
    public CO302001OUT selectMessageCodeList( CO302001IN inParam )
    {
        List<CO302001DTO> arrList = daoMsgCd.selectMessageCodeList(inParam);

        CO302001OUT outParam = new CO302001OUT();
        outParam.setArrList(arrList);

        return outParam;
    }

    /**
     * @brief 메시지 코드 등록 및 수정
     * @details 메시지 코드 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO302002IN
     * @return CO302002OUT
     */
    public CO302002OUT mergeMessageCode( CO302002IN inParam )
    {
        //Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("msgTcd", new RequiredRule(true), new FixedLengthRule(1));
        ruleSet.addRule("msgCd", new RequiredRule(true), new FixedLengthRule(7));
        ruleSet.addRule("msgCntn", new MaxLengthRule(160));

        Validator.validation(inParam, ruleSet);

        //UserId Bind
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0;
        iResult = daoMsgCd.mergeMessageCode(inParam);

        CO302002OUT outParam = new CO302002OUT();
        outParam.setiResult(iResult);

        return outParam;
    }

    /**
     * @brief 메시지 코드 삭제
     * @details 메시지 코드 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO302003IN
     * @return CO302003OUT
     */
    public CO302003OUT deleteMessageCode( CO302003IN inParam )
    {
        CO302003OUT outParam = new CO302003OUT();

        outParam.setiResult(daoMsgCd.deleteMessageCode(inParam));

        return outParam;
    }

    /**
     * @brief 메시지 파일 생성
     * @details 메시지 파일 생성
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO302004IN
     * @return CO302004OUT
     */
    public CO302004OUT createMessageFile( CO302004IN inParam ) {
        int iFileCreateFailCount = 0;
        boolean isFileCreateSuccess = false;

        String[] arrLocale = null;

        if( globalContextProp.getProperty("LOCALE_LIST")!=null ) {
            arrLocale = globalContextProp.getProperty("LOCALE_LIST").split(",");
        }

        List<CO302001DTO> arrList = null;
        CO302001IN inMsgCd2 = new CO302001IN();

        if( arrLocale!=null ) {
            for(String locale : arrLocale) {
                inMsgCd2.setLclCd(locale);
                inMsgCd2.setSortSeq("ASC");

                arrList = daoMsgCd.selectMessageCodeList(inMsgCd2);

                String msgFilePath = globalContextProp.getProperty("MSG_FILE_PATH1") + "/" + globalContextProp.getProperty("MSG_FILE_NAME") + ".properties";
                isFileCreateSuccess = msgFileCreate(msgFilePath, arrList, locale);

                String[] envs = env.getActiveProfiles();
//                if( "product".equals(envs[0]) ) {
//                    msgFilePath = globalContextProp.getProperty("MSG_FILE_PATH2") + "/" + globalContextProp.getProperty("MSG_FILE_NAME") + ".properties";
//                    isFileCreateSuccess = msgFileCreate(msgFilePath, arrList, locale);
//                }

                if(!isFileCreateSuccess) iFileCreateFailCount++;
            }
        }

        CO302004OUT outParam = new CO302004OUT();

        if(iFileCreateFailCount > 0 ) {
        	outParam.setSuccess(false);
        } else {
        	outParam.setSuccess(true);
        }

        return outParam;
    }

    /**
     * @brief 메시지 파일 생성
     * @details 메시지 파일 생성
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param arrList
     * @param locale
     * @return boolean File creation completed (true or false)
     */
    private boolean  msgFileCreate(String filePath, List<CO302001DTO> arrList, String locale) {
        FileOutputStream fos = null;
        boolean isSuccess = true;

        try {
            File file = new File(filePath);

            if(file.exists()) {
                file.delete();
            }

            fos = new FileOutputStream(file);

            for( CO302001DTO dtoMsg : arrList ) {
                String cntn = dtoMsg.getMsgCd() + "=" + dtoMsg.getMsgCntn() + "\n";
                fos.write(cntn.getBytes("UTF-8"));
            }

        } catch(Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            isSuccess = false;
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error(e.getMessage());
                }
                isSuccess = false;
            }
        }

        return isSuccess;
    }

}
