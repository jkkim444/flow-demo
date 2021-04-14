/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5060.java
 * @brief 포괄손익계산서 산출 Service
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
import com.encocns.ia.dao.IA5060DAO;
import com.encocns.ia.dto.IA506001DTO;
import com.encocns.ia.service.svo.IA506001IN;
import com.encocns.ia.service.svo.IA506001OUT;
import com.encocns.ia.service.svo.IA506002IN;
import com.encocns.ia.service.svo.IA506002OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 포괄손익계산서 산출 내역 Service
 * @details 포괄손익계산서 산출 내역 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
@Service
public class IA5060 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5060.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5060DAO daoIA5060;

    @Autowired
	private IA9000 iA9000;
    /**
     * @brief IFRS 포괄손익계산서 산출 내역 조회
     * @details IFRS 포괄손익계산서 산출 내역 조회
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA506001IN
     * @return IA506001OUT
     */
	public IA506001OUT selectListIfrsIcsPflsBlls(IA506001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsIcsPflsBlls -----");

		IA506001OUT outEtcList = new IA506001OUT();

	    List<IA506001DTO> list = null;

	   	list =  daoIA5060.selectListIfrsIcsPflsBlls(inParam);

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
     * @brief 포괄손익계산서 산출 생성 
     * @details 포괄손익계산서 산출 생성 
	 * @author : 이동겸
	 * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA506002IN
     * @return IA506002OUT
     */
	public IA506002OUT insertIfrsIcsPflsBlls(IA506002IN inParam) throws EnfraBusinessException, Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsIcsPflsBlls -----");

        int iResult =0 ;

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /**
         * IFRS 포괄손익계산서 산출 삭제  처리
         */
		iResult = daoIA5060.deleteIfrsIcsPflsBlls(inParam);

        /**
         * IFRS 포괄손익계산서 산출 insert  처리
         */
		iResult = daoIA5060.insertIfrsIcsPflsBlls(inParam);

		/**
        *
        * IFRS 포괄손익계산서 산출 마감 정보 저장
        *
        * */

		iResult += calliA9000insertClsnYnReg(inIA900001IN);

		IA506002OUT outIfrs = new IA506002OUT();
		outIfrs.setiResult(iResult);

		return outIfrs;
	}

    /**
     * @brief IFRS 포괄손익계산서 기초생성/마감 정보 등록
     * @details IFRS 포괄손익계산서 기초생성/마감 정보 등록
	 * @author : 이동겸
	 * @date : 2020. 10. 26.
     * @version : 1.0.0
     * @param IA900001IN
     * @return int
     */
	private int calliA9000insertClsnYnReg(IA900001IN inParam) throws EnfraBusinessException, Exception {

		int outParam = iA9000.insertClsnYnReg(inParam);

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
	private boolean calliA9000selectClsnYnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		boolean outParam = false;

		outParam = iA9000.selectClsnYnIqryOn(inParam);

		if(!outParam) {
			throw new EnfraBusinessException("E000033"); // 마감정보 확인바랍니다.
		}
		return outParam;
	}
}
