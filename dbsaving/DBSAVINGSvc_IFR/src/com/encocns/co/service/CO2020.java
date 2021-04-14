/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2020.java
 * @brief 화면 관리 Service
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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO2020DAO;
import com.encocns.co.dto.CO202001DTO;
import com.encocns.co.service.svo.CO202001IN;
import com.encocns.co.service.svo.CO202001OUT;
import com.encocns.co.service.svo.CO202002IN;
import com.encocns.co.service.svo.CO202002OUT;
import com.encocns.co.service.svo.CO202003IN;
import com.encocns.co.service.svo.CO202003OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.MaxLengthRule;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;

/**
 * @brief 화면 관리 Service
 * @details 화면 관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class CO2020 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CO2020.class);

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
    private CO2020DAO daoCO2020;

    /**
     * @brief 화면 목록 조회
     * @details 화면 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO202001IN
     * @return CO202001OUT
     */
    public CO202001OUT selectScreenList(CO202001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectScreenList -----");

        List<CO202001DTO> arrList = daoCO2020.selectScreenList(inParam);

        CO202001OUT outParam = new CO202001OUT();
        outParam.setArrList(arrList);

        return outParam;
    }

    /**
     * @brief 화면 등록 및 수정
     * @details 화면 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO202002IN
     * @return CO202002OUT
     * @throws EnfraBusinessException
     */
    public CO202002OUT mergeScreen(CO202002IN inParam) throws EnfraBusinessException {
        //Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("bizLclsCd", new RequiredRule(true));
        ruleSet.addRule("scrId", new RequiredRule(true));
        ruleSet.addRule("scrNm", new RequiredRule(), new MaxLengthRule(60));
        ruleSet.addRule("popYn", new RequiredRule());

        Validator.validation(inParam, ruleSet);

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // 처리 건수 초기화
        int iResult = 0;

        // insert
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoCO2020.insertScreen(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }
        // update
        else if("U".equals(inParam.getJobDivCd())) {
        	// 업데이트 처리
    		iResult = daoCO2020.updateScreen(inParam);
        }
        else {
    		// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

        CO202002OUT outParam = new CO202002OUT();
        outParam.setiResult(iResult);

        return outParam;
    }

    /**
     * @brief 화면 삭제
     * @details 화면 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO202003IN
     * @return CO202003OUT
     */
    public CO202003OUT deleteScreen(CO202003IN inParam) {
        //Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("bizLclsCd", new RequiredRule(true));
        ruleSet.addRule("scrId", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        int iResult = daoCO2020.deleteScreen(inParam);

        CO202003OUT outParam = new CO202003OUT();
        outParam.setiResult(iResult);

        return outParam;
    }

}
