/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5110.java
 * @brief IFRS 정산표  조회 Service
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
import org.springframework.stereotype.Service;

import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.dao.IA5110DAO;
import com.encocns.ia.dto.IA511001DTO;
import com.encocns.ia.dto.IA511002DTO;
import com.encocns.ia.service.svo.IA511001IN;
import com.encocns.ia.service.svo.IA511001OUT;
import com.encocns.ia.service.svo.IA511002IN;
import com.encocns.ia.service.svo.IA511002OUT;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief IFRS 정산표  조회 Service
 * @details IFRS 정산표  조회 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5110 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5110.class);


	@Autowired
	private IA5110DAO daoIA5110;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief IFRS 정산표  조회 
     * @details IFRS 정산표 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA511001IN
     * @return IA511001OUT
     */
	public IA511001OUT selectListIfrsAdjsHist(IA511001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsAdjsHist -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IA511001OUT outIfrsList = new IA511001OUT();

		List<IA511001DTO> list01 = null;

		list01 =  daoIA5110.selectListIfrsAdjsHist(inParam);
		outIfrsList.setList01(list01);

	   	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outIfrsList.setClsnCtnt("미마감");
	   	}else {
	   		outIfrsList.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}

		return outIfrsList;

	}

    /**
     * @brief IFRS 정산표 엑셀 다운
     * @details IFRS 정산표 엑셀 다운 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA511002IN
     * @return IA511002OUT
     */
	public IA511002OUT selectListIfrsAdjsHistExcl(IA511002IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsAdjsHistExcl -----");

		// Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IA511002OUT outIfrsList = new IA511002OUT();

		List<IA511002DTO> list02 = null;

		list02 =  daoIA5110.selectListIfrsAdjsHistExcl(inParam);
		outIfrsList.setList02(list02);

		return outIfrsList;

	}


}
