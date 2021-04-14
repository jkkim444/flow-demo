/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5090.java
 * @brief 연결현금흐름표 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
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
import com.encocns.ia.dao.IA5090DAO;
import com.encocns.ia.dto.IA509001DTO;
import com.encocns.ia.service.svo.IA509001IN;
import com.encocns.ia.service.svo.IA509001OUT;
import com.encocns.ia.service.svo.IA509002IN;
import com.encocns.ia.service.svo.IA509002OUT;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief IFRS연결현금흐름표 내역 Service
 * @details It is IFRS연결현금흐름표 내역 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
@Service
public class IA5090 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5090.class);

    @Autowired
    private ServiceComponent serviceComponent;


	@Autowired
	private IA5090DAO daoIA5090;

    @Autowired
	private IA9000 iA9000;


    /**
     * @brief IFRS연결현금흐름표 내역 조회
     * @details IFRS연결현금흐름표 내역 조회
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA509001IN
     * @return IA509001OUT
     */
	public IA509001OUT selectListLnknCashFlow(IA509001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListFnstFxfr -----");

		IA509001OUT outEtcList = new IA509001OUT();

	    List<IA509001DTO> list = null;

	   	list =  daoIA5090.selectListLnknCashFlow(inParam);

	    outEtcList.setList(list);

	   	// 마감정보 표시
	   	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outEtcList.setClsnCtnt("미마감");
	   	}else {
	   		outEtcList.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}

		return outEtcList;

	}

    /**
     * @brief IFRS연결현금흐름표 생성
     * @details IFRS연결현금흐름표 엑셀 업로드
	 * @author : 이동겸
	 * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA509002IN
     * @return IA509002OUT
     */
	public IA509002OUT insertLnknCashFlow(IA509002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLnknCashFlow -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("arrGridData", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;

        /* 기준일자에 해당하는 데이타 삭제 처리*/
        /* 첫번째 열의 기준년월 기준임 */

        iResult = daoIA5090.deleteLnknCashFlow(inParam.getArrGridData().get(0));

        /* 엑셀 업로드로 여러건 받아서 loop 돌려서 처리한다. */

		for(IA509001DTO iA509001DTO : inParam.getArrGridData()) {
				iA509001DTO.setUsrId(serviceComponent.getSessionVO().getUserId());
				iResult += daoIA5090.insertLnknCashFlowExcl(iA509001DTO);
		}

		IA509002OUT outParam = new IA509002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}
}
