/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5220.java
 * @brief 임차시설물 복구비용 추정 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
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
import com.encocns.ia.dao.IA5220DAO;
import com.encocns.ia.dto.IA522001DTO;
import com.encocns.ia.service.svo.IA522001IN;
import com.encocns.ia.service.svo.IA522001OUT;
import com.encocns.ia.service.svo.IA522002IN;
import com.encocns.ia.service.svo.IA522002OUT;
import com.encocns.ia.service.svo.IA522003IN;
import com.encocns.ia.service.svo.IA522003OUT;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 임차시설물 복구비용 추정 Service
 * @details 임차시설물 복구비용 추정 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
@Service
public class IA5220 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5220.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5220DAO daoIA5220;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 임차시설물 복구비용 추정 조회
     * @details 임차시설물 복구비용 추정 조회
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA522001IN
     * @return IA522001OUT
     */
	public IA522001OUT selectListRcvrCostEsti(IA522001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLnrnGrmnPsvl -----");

		IA522001OUT outParamList = new IA522001OUT();

	    List<IA522001DTO> list = null;

	    list =  daoIA5220.selectListRcvrCostEsti(inParam);

	    outParamList.setList(list);

	   	// 마감정보 표시
	   	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParamList.setClsnCtnt("미마감");
	   	}else {
	   		outParamList.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}

		return outParamList;

	}

    /**
     * @brief 임차시설물 복구비용 추정 등록 및 수정
     * @details 임차시설물 복구비용 추정 등록 및 수정
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA522002IN
     * @return IA522002OUT
     */
	public IA522002OUT mergeRcvrCostEsti(IA522002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRcvrCostEsti -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());


        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm"      , new RequiredRule(true));
        ruleSet.addRule("areRcost"    , new RequiredRule(true));
        ruleSet.addRule("prceIrrt"    , new RequiredRule(true));
        ruleSet.addRule("rentTrmCnt"  , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt12"  , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt24"  , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt36"  , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt48"  , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt60"  , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt72"  , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt84"  , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt96"  , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt108" , new RequiredRule(true));
        ruleSet.addRule("rcvrDcrt120" , new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;
        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIA5220.insertRcvrCostEsti(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
        		//업데이트 처리
        		iResult = daoIA5220.updateRcvrCostEsti(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IA522002OUT outParam = new IA522002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 임차시설물 복구비용 추정 삭제
     * @details 임차시설물 복구비용 추정 삭제
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA522003IN
     * @return IA522003OUT
     */
	public IA522003OUT deleteRcvrCostEsti(IA522003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcvrCostEsti -----");


        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IA522003OUT outParam = new IA522003OUT();
		outParam.setiResult(daoIA5220.deleteRcvrCostEsti(inParam));

		return outParam;
	}

}
