/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5040.java
 * @brief IFRS 재무상태표 산출 management Service
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

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.dao.IA5040DAO;
import com.encocns.ia.dto.IA504001DTO;
import com.encocns.ia.service.svo.IA504001IN;
import com.encocns.ia.service.svo.IA504001OUT;
import com.encocns.ia.service.svo.IA504002IN;
import com.encocns.ia.service.svo.IA504002OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief IFRS 재무상태표 산출 내역 Service
 * @details IFRS 재무상태표 산출 내역 관리 서비스입니다..
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5040 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5040.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5040DAO daoIA5040;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief IFRS 재무상태표 산출 내역 조회
     * @details IFRS 재무상태표 산출 내역을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA504001IN
     * @return IA504001OUT
     */
	public IA504001OUT selectListIfrsfnafStaSht(IA504001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListFnstFxfr -----");

		IA504001OUT outEtcList = new IA504001OUT();

	    List<IA504001DTO> list = null;

	   	list =  daoIA5040.selectListIfrsfnafStaSht(inParam);

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
     * @brief IFRS 재무상태표 산출 생성 
     * @details IFRS 재무상태표 산출 생성
	 * @author : 이동겸
	 * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA504002IN
     * @return IA504002OUT
     */
	public IA504002OUT insertIfrsfnafStaSht(IA504002IN inParam) throws EnfraBusinessException, Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsfnafStaSht -----");

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

        int iResult =0 ;

        /**
        *
        * 기준일자 해당하는 데이터 삭제 처리
        *
        * */
		iResult = daoIA5040.deleteIfrsfnafStaSht(inParam);

		/**
        *
        * IFRS 재무상태표 산출 insert  처리
        *
        * */

		iResult = daoIA5040.insertIfrsfnafStaSht(inParam);

		/**
        *
        * IFRS 재무상태표 산출 마감 정보 저장
        *
        * */

		iResult += calliA9000insertClsnYnReg(inIA900001IN);

		IA504002OUT outIfrs = new IA504002OUT();
		outIfrs.setiResult(iResult);



		return outIfrs;
	}

    /**
     * @brief IFRS 재무상태표 기초생성/마감 정보 등록
     * @details IFRS 재무상태표 기초생성/마감 정보 등록
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
