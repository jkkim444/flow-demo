/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6010.java
 * @brief 공정가치측정금융자산내역 관리 Service
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

import java.math.BigDecimal;
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
import com.encocns.ia.dao.IA6010DAO;
import com.encocns.ia.dto.IA601001DTO;
import com.encocns.ia.service.svo.IA601001IN;
import com.encocns.ia.service.svo.IA601001OUT;
import com.encocns.ia.service.svo.IA601002IN;
import com.encocns.ia.service.svo.IA601002OUT;
import com.encocns.ia.service.svo.IA601003IN;
import com.encocns.ia.service.svo.IA601003OUT;
import com.encocns.ia.service.svo.IA601004OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 공정가치측정금융자산내역 관리 Service
 * @details 공정가치측정금융자산내역 관리 서비스입니다.
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA6010 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6010.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA6010DAO daoIA6010;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 공정가치측정금융자산내역 조회
     * @details 공정가치측정금융자산내역 조회
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA601001IN
     * @return IA601001OUT
     */
	public IA601001OUT selectFvfnasList(IA601001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectFvfnasList -----");

	    List<IA601001DTO> arrList = daoIA6010.selectFvfnasList(inParam);

		IA601001OUT outParam = new IA601001OUT();

    	outParam.setArrList(arrList);

    	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getBaseYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setPbnfCtnt("미마감");
	   	}else {
	   		outParam.setPbnfCtnt(outIA900002OUT.getPbnfCtnt());
	   	}

		return outParam;

	}

    /**
     * @brief 공정가치측정금융자산내역 저장 
     * @details 공정가치측정금융자산내역 저장
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA601002IN
     * @return IA601002OUT
     */
	public IA601002OUT mergeFvfnas(IA601002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeFvfnas -----");


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

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("baseYm", new RequiredRule(true));
        ruleSet.addRule("fvLvlCd", new RequiredRule(true));
        ruleSet.addRule("asetNm", new RequiredRule(true));
        ruleSet.addRule("fvLvlCd", new RequiredRule(true));
        ruleSet.addRule("bkvalAmt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0 ;
        BigDecimal zero = BigDecimal.ZERO;

        if(0 == zero.compareTo(inParam.getSeqno())) {
            iResult = daoIA6010.insertFvfnas(inParam);
        }
        else {
    		iResult = daoIA6010.updateFvfnas(inParam);
        }

		IA601002OUT outParam = new IA601002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}




    /**
     * @brief 공정가치측정금융자산내역 삭제 
     * @details 공정가치측정금융자산내역 삭제
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA601003IN
     * @return IA601003OUT
     */
	public IA601003OUT deleteFvfnas(IA601003IN inParam) throws Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteFvfnas -----");


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

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("baseYm", new RequiredRule(true));
        ruleSet.addRule("fvLvlCd", new RequiredRule(true));
        ruleSet.addRule("seqno", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IA601003OUT outParam = new IA601003OUT();
		outParam.setiResult(daoIA6010.deleteFvfnas(inParam));

		return outParam;
	}

    /**
     * @brief  공정가치측정금융자산내역 기초 자료생성 
     * @details 공정가치측정금융자산내역 기초 자료생성
     * @author : 차상길
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA601003IN
     * @return IA601004OUT
     */

	public IA601004OUT insertFvfnasBass(IA601003IN inParam) throws Exception
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertFvfnasBass -----");

        /*
         * 1.기준년월 + 등록자('9999')  가 존재 하는 경우 기초 자료 생성 오류 처리
         *
         * 특정 사번인 경우 무시 하고 처리(일단 송아영)(todo)
         *         *
         * */
        int iResult = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        IA601004OUT outEtc = new IA601004OUT();

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



        /* 기존 자료 삭제 처리 후 반영 */
        iResult += daoIA6010.deleteFvfnasAll(inParam);
        try {
        	iResult += daoIA6010.insertFvfnasBass(inParam);
        }
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}

		/**
        *
        * 대손충당금 기초생성 정보 저장
        *
        * */

		iResult += calliA9000insertClsnYnReg(inIA900001IN);


        outEtc.setiResult(iResult);
		return outEtc;
	}

    /**
     * @brief 공정가치측정 마감 정보 등록
     * @details 공정가치측정 마감 정보 등록
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
