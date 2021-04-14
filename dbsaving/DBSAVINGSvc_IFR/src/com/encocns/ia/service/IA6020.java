/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6020.java
 * @brief 임대차보증금 현재가치 산출내역 관리 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service
 * @brief Common Service Package
 */
package com.encocns.ia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.dao.IA6020DAO;
import com.encocns.ia.dto.IA602001DTO;
import com.encocns.ia.service.svo.IA602001IN;
import com.encocns.ia.service.svo.IA602001OUT;
import com.encocns.ia.service.svo.IA602002IN;
import com.encocns.ia.service.svo.IA602002OUT;
import com.encocns.ia.service.svo.IA602003IN;
import com.encocns.ia.service.svo.IA602003OUT;

/**
 * @brief 임대차보증금 현재가치 산출내역 관리 Service
 * @details 임대차보증금 현재가치 산출내역 관리 서비스입니다.
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA6020 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6020.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA6020DAO daoIA6020;

    /**
     * @brief 임대차보증금 현재가치 산출내역 조회
     * @details 임대차보증금 현재가치 산출내역 조회
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA602001IN
     * @return IA602001OUT
     */
	public IA602001OUT selectTnasetchgList(IA602001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectTnasetchgList -----");

	    List<IA602001DTO> arrList = daoIA6020.selectTnasetchgList(inParam);

		IA602001OUT outParam = new IA602001OUT();

    	outParam.setArrList(arrList);

		return outParam;

	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 저장 
     * @details 임대차보증금 현재가치 산출내역 저장
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA602002IN
     * @return IA602002OUT
     */
	public IA602002OUT mergeTnasetchg(IA602002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeTnasetchg -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("baseDt", new RequiredRule(true));
        ruleSet.addRule("acqsDspslDivCd", new RequiredRule(true));
        ruleSet.addRule("tnasetDivCd", new RequiredRule(true));
        ruleSet.addRule("asetNm", new RequiredRule(true));
        ruleSet.addRule("acqsDspslAmt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0 ;

        if("".equals(inParam.getAsetCd())) {
            iResult = daoIA6020.insertTnasetchg(inParam);
        }
        else {
    		iResult = daoIA6020.updateTnasetchg(inParam);
        }

		IA602002OUT outParam = new IA602002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 저장
     * @details 임대차보증금 현재가치 산출내역 저장
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA602002IN
     * @return IA602002OUT
     */
	public IA602002OUT insertTnasetchgExcel(IA602002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertTnasetchgExcel -----");

        int iResult = 0 ;

        try {
            for(IA602001DTO dtoParam : inParam.getArrList()) {
            	dtoParam.setUsrId(serviceComponent.getSessionVO().getUserId());
                iResult += daoIA6020.insertTnasetchgExcel(dtoParam);
            }
        }
        catch(Exception e){
    		// 오류 메시지 출력
            throw new EnfraBusinessException("E000025");
        }

		IA602002OUT outParam = new IA602002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 삭제
     * @details 임대차보증금 현재가치 산출내역 삭제
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA602003IN
     * @return IA602003OUT
     */
	public IA602003OUT deleteTnasetchg(IA602003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteTnasetchg -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("baseDt", new RequiredRule(true));
        ruleSet.addRule("tnasetDivCd", new RequiredRule(true));
        ruleSet.addRule("acqsDspslDivCd", new RequiredRule(true));
        ruleSet.addRule("asetCd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IA602003OUT outParam = new IA602003OUT();
		outParam.setiResult(daoIA6020.deleteTnasetchg(inParam));

		return outParam;
	}

}
