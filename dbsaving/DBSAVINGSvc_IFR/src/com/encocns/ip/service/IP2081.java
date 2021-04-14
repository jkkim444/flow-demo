/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2081.java
 * @brief 대손충당금상세 관리 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service
 * @brief Common Service Package
 */
package com.encocns.ip.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.service.IA9000;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ip.dao.IP2081DAO;
import com.encocns.ip.dto.IP208101DTO;
import com.encocns.ip.service.svo.IP208101IN;
import com.encocns.ip.service.svo.IP208101OUT;
import com.encocns.ip.service.svo.IP208102IN;
import com.encocns.ip.service.svo.IP208102OUT;
import com.encocns.ip.service.svo.IP208103IN;
import com.encocns.ip.service.svo.IP208103OUT;

/**
 * @brief 대손충당금상세 관리 Service
 * @details 대손충당금상세 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2081 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2081.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2081DAO daoIP2081;

    @Autowired
	private IA9000 iA9000;
    /**
     * @brief 대손충당금상세 조회
     * @details 대손충당금상세 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208101IN
     * @return IP208101OUT
     */
	public IP208101OUT selectBadlnRsrvDtl(IP208101IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBadlnRsrvDtl -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        ruleSet.addRule("seqno", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IP208101OUT outParam  = new IP208101OUT();

		IP208101DTO outIP208101DTO =  daoIP2081.selectBadlnRsrvDtl(inParam);

	    outParam.setList(outIP208101DTO);

		return outParam;

	}

    /**
     * @brief 대손충당금상세 수정
     * @details 대손충당금상세 수정합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208102IN
     * @return IP208102OUT
     */
	public IP208102OUT mergeBadlnRsrvDtl(IP208102IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeBadlnRsrvDtl -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("seqno", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int  iResult = daoIP2081.updateBadlnRsrvDtl(inParam);

		IP208102OUT outParam = new IP208102OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 대손충당금상세 삭제
     * @details 대손충당금상세 삭제합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208103IN
     * @return IP208103OUT
     */
	public IP208103OUT deleteBadlnRsrvDtl(IP208103IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeBadlnRsrvDtl -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("seqno", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


        int  iResult = daoIP2081.deleteBadlnRsrvDtl(inParam);

		IP208103OUT outParam = new IP208103OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 마감여부 검증
     * @details 마감여부 검증합니다.
     * @author : 이동겸
     * @date : 2020. 10. 26.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */
	private boolean calliA9000selectClsnYnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		boolean outParam = false;

		outParam = iA9000.selectClsnYnIqry(inParam);

		if(!outParam) {
			throw new EnfraBusinessException("E000033"); // 마감정보 확인바랍니다.

		}
		return outParam;
	}
}

