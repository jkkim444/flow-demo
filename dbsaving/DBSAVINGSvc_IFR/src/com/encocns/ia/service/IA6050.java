/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6050.java
 * @brief 임대차보증금 현재가치 산출내역 관리 Service
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
import com.encocns.ia.dao.IA6050DAO;
import com.encocns.ia.dto.IA605001DTO;
import com.encocns.ia.service.svo.IA605004IN;
import com.encocns.ia.service.svo.IA605004OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;
import com.encocns.ia.service.svo.IA605001IN;
import com.encocns.ia.service.svo.IA605001OUT;
import com.encocns.ia.service.svo.IA605002IN;
import com.encocns.ia.service.svo.IA605002OUT;
import com.encocns.ia.service.svo.IA605003IN;
import com.encocns.ia.service.svo.IA605003OUT;

/**
 * @brief 임대차보증금 현재가치 산출내역 관리 Service
 * @details 임대차보증금 현재가치 산출내역 관리 서비스입니다.
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA6050 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6050.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA6050DAO daoIA6050;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 임대차보증금 현재가치 산출내역 조회
     * @details 임대차보증금 현재가치 산출내역 조회
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA605001IN
     * @return IA605001OUT
     */
	public IA605001OUT selectNlnknstrentasetList(IA605001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectNlnknstrentasetList -----");

	    List<IA605001DTO> arrList = daoIA6050.selectNlnknstrentasetList(inParam);

		IA605001OUT outParam = new IA605001OUT();

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
     * @brief 임대차보증금 기초생성
     * @details 임대차보증금 기초생성
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA605004IN
     * @return IA605004OUT
     */

	public IA605004OUT insertNlnknstrentasetBass(IA605004IN inParam) throws Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertNlnknstrentasetBass -----");

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

		inParam.setUsrId(serviceComponent.getSessionVO().getUsr_id());

		int iResult = 0;

		 /* 기존 자료 삭제 처리 후 반영 */
        iResult += daoIA6050.deleteNlnknstrentasetBass(inParam);
        try {
            iResult += daoIA6050.insertNlnknstrentasetBass(inParam);

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

        IA605004OUT outParam = new IA605004OUT();
        outParam.setiResult(iResult);



		return outParam;

	}


    /**
     * @brief 임대차보증금 현재가치 산출내역 저장
     * @details 임대차보증금 현재가치 산출내역 저장
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA605002IN
     * @return IA605002OUT
     */
	public IA605002OUT mergeNlnknstrentaset(IA605002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeNlnknstrentaset -----");

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
        ruleSet.addRule("acntDiv", new RequiredRule(true));
        ruleSet.addRule("itmsDivCtnt", new RequiredRule(true));
        ruleSet.addRule("totAset", new RequiredRule(true));
        ruleSet.addRule("acbkAmt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0 ;
        BigDecimal zero = BigDecimal.ZERO;

        if(0 == zero.compareTo(inParam.getSeqno())) {
            iResult = daoIA6050.insertNlnknstrentaset(inParam);
        }
        else {
    		iResult = daoIA6050.updateNlnknstrentaset(inParam);
        }

		IA605002OUT outParam = new IA605002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 저장
     * @details 임대차보증금 현재가치 산출내역 저장
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA605002IN
     * @return IA605002OUT
     */
	public IA605002OUT insertNlnknstrentasetExcel(IA605002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertNlnknstrentasetExcel -----");

        int iResult = 0 ;

        try {
            for(IA605001DTO dtoParam : inParam.getArrList()) {
            	dtoParam.setUsrId(serviceComponent.getSessionVO().getUserId());
                iResult += daoIA6050.insertNlnknstrentasetExcel(dtoParam);
            }
        }
        catch(Exception e){
    		// 오류 메시지 출력
            throw new EnfraBusinessException("E000025");
        }

		IA605002OUT outParam = new IA605002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 삭제 
     * @details 임대차보증금 현재가치 산출내역 삭제
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA605003IN
     * @return IA605003OUT
     */
	public IA605003OUT deleteNlnknstrentaset(IA605003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteNlnknstrentaset -----");

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
        ruleSet.addRule("seqno", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IA605003OUT outParam = new IA605003OUT();
		outParam.setiResult(daoIA6050.deleteNlnknstrentaset(inParam));

		return outParam;
	}


    /**
     * @brief 임대차보증금 현재가치 마감 정보 등록
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
