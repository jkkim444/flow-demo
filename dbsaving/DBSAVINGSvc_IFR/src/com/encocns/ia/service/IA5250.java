/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5250.java
 * @brief 수익증권합계잔액시산표 Service
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 9. 21. | First Created
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
import com.encocns.ia.dao.IA5250DAO;
import com.encocns.ia.dto.IA525001DTO;
import com.encocns.ia.service.svo.IA525001IN;
import com.encocns.ia.service.svo.IA525001OUT;
import com.encocns.ia.service.svo.IA525002IN;
import com.encocns.ia.service.svo.IA525002OUT;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 수익증권합계잔액시산표 내역 관리 Service
 * @details 수익증권합계잔액시산표 내역 관리 서비스입니다.
 * @author : 이미래
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
@Service
public class IA5250 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5250.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5250DAO daoIA5250;

    @Autowired
	private IA9000 iA9000;


    /**
     * @brief 수익증권합계잔액시산표 내역 조회
     * @details 수익증권합계잔액시산표 내역 조회
     * @author : 이미래
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA525001IN
     * @return IA525001OUT
     */
	public IA525001OUT selectListBncfBalTrbs(IA525001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBncfBalTrbs -----");


		IA525001OUT outParamList = new IA525001OUT();

	    List<IA525001DTO> list = null;

	    list =  daoIA5250.selectListBncfBalTrbs(inParam);

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
     * @brief 수익증권합계잔액시산표 내역 저장
     * @details 수익증권합계잔액시산표 내역 저장
     * @author : 이미래
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA525002IN
     * @return IA525002OUT
     */
	public IA525002OUT mergeBncfBalTrbs(IA525002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeBncfBalTrbs -----");



        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("arrGridData", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;

        /* 기준일자에 해당하는 데이타 삭제 처리*/
        /* 첫번째 열의 기준년월 기준임 */
        iResult = daoIA5250.deleteBncfBalTrbs(inParam.getArrGridData().get(0));

        /**
         *  1.계정과목 코드 존재 여부 검증
         *     입력 계정과목코드 검증
         */
		for(IA525001DTO iA525001DTO : inParam.getArrGridData()) {
			//계정코드 있는 것들만 등록된 계정코드인지 확인
			if(iA525001DTO.getIfrsAccCd() != null) {
//				if(daoIA5250.selectacctExisYn(iA525001DTO) == null) {
//					throw new EnfraBusinessException("E000028"); // 미등록계정입니다
//				}
			}
			iA525001DTO.setUsrId(serviceComponent.getSessionVO().getUserId());
			iResult += daoIA5250.insertBncfBalTrbs(iA525001DTO);

		}
		IA525002OUT outParam = new IA525002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}
}
