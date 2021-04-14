/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6080.java
 * @brief 기타포괄손익 공정가치자산내역 관리 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 18. | First Created
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
import com.encocns.ia.dao.IA6080DAO;
import com.encocns.ia.dto.IA608001DTO;
import com.encocns.ia.service.svo.IA608001IN;
import com.encocns.ia.service.svo.IA608001OUT;
import com.encocns.ia.service.svo.IA608002IN;
import com.encocns.ia.service.svo.IA608002OUT;
import com.encocns.ia.service.svo.IA608003IN;
import com.encocns.ia.service.svo.IA608003OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 기타포괄손익 공정가치자산내역 서비스
 * @details 기타포괄손익 공정가치자산내역 서비스입니다.
 * @author : 차상길
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
@Service
public class IA6080 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6080.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA6080DAO daoIA6080;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 기타포괄손익 공정가치자산내역 조회
     * @details 기타포괄손익 공정가치자산내역을 조회한다.
     * @author : 차상길
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA608001IN
     * @return IA608001OUT
     */
	public IA608001OUT selectIcsPflsFvList(IA608001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectIcsPflsFvList -----");

	    List<IA608001DTO> arrList = daoIA6080.selectIcsPflsFvList(inParam);

		IA608001OUT outParam = new IA608001OUT();
		outParam.setArrList(arrList);

		// 마감 정보 조회
    	IA900002IN inIA900002IN =  new IA900002IN() ;
	   	inIA900002IN.setBaseYm(inParam.getBaseYm());

	   	IA900002OUT outIA900002OUT = iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setPbnfCtnt("미마감");
	   	}else {
	   		outParam.setPbnfCtnt(outIA900002OUT.getPbnfCtnt());
	   	}

		return outParam;

	}

    /**
     * @brief 기타포괄손익 공정가치자산내역 등록 및 수정
     * @details 기타포괄손익 공정가치자산내역을 등록 및 수정한다.
     * @author : 차상길
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA608002IN
     * @return IA608002OUT
     */
	public IA608002OUT mergeIcsPflsFv(IA608002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeIcsPflsFv -----");

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getBaseYm());
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        calliA9000selectPbnfClsnIqry(inIA900001IN);

        // 값 검증
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("baseYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // 등록 및 수정
        iResult = daoIA6080.mergeIcsPflsFv(inParam);

		IA608002OUT outParam = new IA608002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 기타포괄손익 공정가치자산내역 삭제
     * @details 기타포괄손익 공정가치자산내역을 삭제한다.
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA608003IN
     * @return IA608003OUT
     */
	public IA608003OUT deleteIcsPflsFv(IA608003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIcsPflsFv -----");

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getBaseYm());
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        calliA9000selectPbnfClsnIqry(inIA900001IN);

        // 값 검증
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("baseYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;

        // 삭제
        iResult = daoIA6080.deleteIcsPflsFv(inParam);

		IA608003OUT outParam = new IA608003OUT();
		outParam.setiResult(iResult);

		return outParam;
	}


    /**
     * @brief 기타포괄손익 공정가치자산내역 기초생성
     * @details 기타포괄손익 공정가치자산내역 기초를 생성한다.
     * @author : 차상길
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA608002IN
     * @return IA608002OUT
     */
	public IA608002OUT insertIcsPflsFvBass(IA608002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeIcsPflsFv -----");

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getBaseYm());
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        calliA9000selectPbnfClsnIqry(inIA900001IN);

        // 값 검증
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("baseYm", new RequiredRule(true));
        ruleSet.addRule("searchFrtrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // 기존 데이터 삭제
        daoIA6080.deleteIcsPflsFvBass(inParam);

        // 기초 생성
        iResult = daoIA6080.insertIcsPflsFvBass(inParam);

		IA608002OUT outParam = new IA608002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 마감여부  검증
     * @details 마감여부 확인 검증
	 * @author : 이동겸
	 * @date : 2020. 10. 26.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */
	private boolean calliA9000selectPbnfClsnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		boolean outParam = false;

		outParam = iA9000.selectPbnfClsnIqry(inParam);

		if(!outParam) {
			throw new EnfraBusinessException("E000033"); // 마감정보 확인바랍니다.
		}
		return outParam;
	}

}
