/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5290.java
 * @brief IFRS 계정코드 관리 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.dao.IA5290DAO;
import com.encocns.ia.dto.IA529001DTO;
import com.encocns.ia.service.svo.IA529001IN;
import com.encocns.ia.service.svo.IA529001OUT;
import com.encocns.ia.service.svo.IA529002IN;
import com.encocns.ia.service.svo.IA529002OUT;
import com.encocns.ia.service.svo.IA529003IN;
import com.encocns.ia.service.svo.IA529003OUT;

/**
 * @brief IFRS 마감정보관리 Service
 * @details IFRS 마감정보관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020.10. 15.
 * @version : 1.0.0
 */
@Service
public class IA5290 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5290.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5290DAO daoIA5290;

    /**
     * @brief IFRS 마감정보관리 조회
     * @details IFRS 마감정보관리 조회
	 * @author : 이동겸
	 * @date : 2020.10. 15.
	 * @version : 1.0.0
     * @param IA529001IN
     * @return IA529001OUT
     */
	public IA529001OUT selectListIfrsAccd(IA529001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsAccd -----");

		IA529001OUT outIfrsList = new IA529001OUT();

	    List<IA529001DTO> list = null;

	    list =  daoIA5290.selectListClsnInfoMgmt(inParam);
	    outIfrsList.setList(list);

		return outIfrsList;

	}


    /**
     * @brief IFRS 마감정보관리 등록 및 수정
     * @details IFRS 마감정보관리 등록 및 수정
	 * @author : 이동겸
	 * @date : 2020.10. 15.
	 * @version : 1.0.0
	 * @param IA529002IN
     * @return IA529002OUT
     */
	public IA529002OUT mergeIfrsAccd(IA529002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeIfrsAccd -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("baseYm", new RequiredRule(true));
        ruleSet.addRule("bassCrtn1Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn2Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn3Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn4Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn5Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn6Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn7Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn8Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn9Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn10Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn11Yn", new RequiredRule(true));
        ruleSet.addRule("bassCrtn12Yn", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

		int iResult  = 0 ;

		/**
		 * 입력 값이 비어 있을 경우 NULL 값으로 파라미터 값을 셋팅
		 */
		String adjsClsnDtm = inParam.getAdjsClsnDtm();
		String fnstClsnDtm = inParam.getFnstClsnDtm();
		String icsClsnDtm  = inParam.getIcsClsnDtm();
		String pbnfClsnDtm = inParam.getPbnfClsnDtm();
		if("".equals(adjsClsnDtm) || adjsClsnDtm.isEmpty()) {
			inParam.setAdjsClsnDtm(null);
		}if("".equals(fnstClsnDtm) || fnstClsnDtm.isEmpty()) {
			inParam.setFnstClsnDtm(null);
		}if("".equals(icsClsnDtm) || icsClsnDtm.isEmpty()) {
			inParam.setIcsClsnDtm(null);
		}if("".equals(pbnfClsnDtm) || pbnfClsnDtm.isEmpty()) {
			inParam.setPbnfClsnDtm(null);
		}

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIA5290.insertClsnInfoMgmt(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
        		iResult = daoIA5290.updateClsnInfoMgmt(inParam);
        }else {
        	// 오류 메시지 출력
        	throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IA529002OUT outIfrs = new IA529002OUT();
		outIfrs.setiResult(iResult);

		return outIfrs;
	}

    /**
     * @brief IFRS 마감정보 삭제
     * @details IFRS 마감정보 삭제
     * @author : 이동겸
	 * @date : 2020.10. 15.
	 * @version : 1.0.0
     * @param IA529003IN
     * @return IA529003OUT
     */
	public IA529003OUT deleteIfrsAccd(IA529003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIfrsAccd -----");

        // Parameter validation
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        System.out.println(inParam.getBassCrtn1Yn());
        // 값이 존재할시 삭제를 할 수 없게 예외 처리한다.
        if(inParam.getAdjsClsnDtm().isEmpty()&&inParam.getFnstClsnDtm().isEmpty()&&inParam.getIcsClsnDtm().isEmpty()&&
        		inParam.getBassCrtn1Yn()=="false"&&inParam.getBassCrtn2Yn()=="false"&&inParam.getBassCrtn3Yn()=="false"&&inParam.getBassCrtn4Yn()=="false"&&
        		inParam.getBassCrtn5Yn()=="false"&&inParam.getBassCrtn6Yn()=="false"&&inParam.getBassCrtn7Yn()=="false"&&inParam.getBassCrtn8Yn()=="false"&&
        		inParam.getBassCrtn9Yn()=="false"&&inParam.getBassCrtn10Yn()=="false"&&inParam.getBassCrtn11Yn()=="false"&&inParam.getBassCrtn12Yn()=="false")
        {
        }else {
        	// 오류 메시지 출력
        	throw new EnfraBusinessException("E000032"); // 값이 존재하여 삭제할 수 없습니다.
        }
        IA529003OUT outParam = new IA529003OUT();
		outParam.setiResult(daoIA5290.deleteClsnInfoMgmt(inParam));

		return outParam;
	}

}
