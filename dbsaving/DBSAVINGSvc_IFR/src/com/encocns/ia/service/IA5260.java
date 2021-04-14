/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5260.java
 * @brief 수익증권 재무제표 관리 Service
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 21.
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
import com.encocns.ia.dao.IA5260DAO;
import com.encocns.ia.dto.IA526001DTO;
import com.encocns.ia.service.svo.IA526001IN;
import com.encocns.ia.service.svo.IA526001OUT;
import com.encocns.ia.service.svo.IA526002IN;
import com.encocns.ia.service.svo.IA526002OUT;
import com.encocns.ia.service.svo.IA526003IN;
import com.encocns.ia.service.svo.IA526003OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 수익증권 재무제표 Service
 * @details 수익증권 재무제표 관리 서비스입니다.
 * @author : 이미래
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
@Service
public class IA5260 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5260.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5260DAO daoIA5260;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 수익증권 재무제표 조회
     * @details 수익증권 재무제표 조회
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526001IN
     * @return IA526001OUT
     */
	public IA526001OUT selectListBncfFnst(IA526001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBncfFnst -----");

		IA526001OUT outParam = new IA526001OUT();


	    List<IA526001DTO> list = null;

	    list =  daoIA5260.selectListBncfFnst(inParam);

	    outParam.setList(list);
	    
	    
	    /* 마감 여부 검증 */
		IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setClsnCtnt("미마감");
	   	}else {
	   		outParam.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}
	    
	    
		return outParam;

	}



    /**
     * @brief 수익증권 재무제표 기초 자료생성
     * @details 수익증권 재무제표 기초 자료생성
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526002IN
     * @return IA526002OUT
     */

	public IA526002OUT insertBncfFnstBass(IA526002IN inParam) throws Exception
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertBncfFnstBass -----");

        int iResult = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
        *
        * 수익증권 재무제표 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);
        
        /**
        *
        * 기초생성 여부 검증
        *
        * */
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        calliA9000selectBassCrtnYnIqry(inIA900001IN);

        IA526002OUT outParam = new IA526002OUT();

        /* 기존 자료 삭제 처리 후 반영 */
        iResult += daoIA5260.deleteBncfFnstAll(inParam);

        try {
        	iResult += daoIA5260.insertBncfFnstBass(inParam);
        }
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}
        
        
        /**
        *
        * 기타유형자산 기초생성 정보 저장
        *
        * */
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
		iResult += calliA9000insertClsnYnReg(inIA900001IN);

        outParam.setiResult(iResult);
		return outParam;
	}

    /**
     * @brief 수익증권 재무제표 등록 및 수정
     * @details 수익증권 재무제표 등록 및 수정
	 * @author : 이미래
	 * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526003IN
     * @return IA526003OUT
     */
	public IA526003OUT mergeEtcTypAsetDprc(IA526003IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeEtcTypAsetDprc -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
        *
        * 수익증권 재무제표 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);
        
        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("fnncGdsItmsNo", new RequiredRule(true));
        ruleSet.addRule("fnncGdsDivCd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0 ;

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */

        if("I".equals(inParam.getJobDivCd())) {


        	try {
            	// 등록 처리
        		iResult = daoIA5260.insertBncfFnst(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
        	iResult = daoIA5260.updateBncfFnst(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IA526003OUT outParam = new IA526003OUT();
		outParam.setiResult(iResult);
		return outParam;
	}


    /**
     * @brief 수익증권 재무제표 정보 삭제
     * @details 수익증권 재무제표 정보 삭제
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526003IN
     * @return IA526003OUT
     */
	public IA526003OUT deleteEtcTypAsetDprc(IA526003IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEtcTypAsetDprc -----");

        int iResult = 0;

        /**
        *
        * 수익증권 재무제표 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

		IA526003OUT outParam = new IA526003OUT();
		outParam.setiResult(iResult += daoIA5260.deleteBncfFnst(inParam));

		return outParam;
	}


    /**
     * @brief 수익증권 재무제표 분개 산출
     * @details 수익증권 재무제표 분개 산출 
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526002IN
     * @return IA526002OUT
     */
	public IA526002OUT calcJrlzTrgtAmt(IA526002IN inParam) throws Exception
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0;

        /**
        *
        * 수익증권 재무제표 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /**
         * 01. 수익증권 재무제표 분개 삭제 처리
         *
         * 02. 수익증권 재무제표 분개데이터 생성
         *
         * 03. 수익증권 재무제표 분개상세 처리
         *
         * */

        //01
        iResult += daoIA5260.deleteCalcJrlzTrgtAmt(inParam);
        iResult += daoIA5260.deletejrlzDtlProcs(inParam);
        //02
        iResult += daoIA5260.insertCalcJrlzTrgtAmt(inParam);
        //03
        iResult += daoIA5260.insertjrlzDtlProcs(inParam);

        IA526002OUT outParam = new IA526002OUT();
		outParam.setiResult(iResult);

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

		outParam = iA9000.selectClsnYnIqry(inParam);

		if(!outParam) {
			throw new EnfraBusinessException("E000033"); // 마감정보 확인바랍니다.

		}

		return outParam;

	}
	
	/**
     * @brief 기초 생성 여부 검증
     * @details 기초 생성 확인 검증
	 * @author : 이동겸
	 * @date : 2020. 10. 15.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */

	private boolean calliA9000selectBassCrtnYnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		boolean outParam = false;

		outParam = iA9000.selectBassCrtnYnIqry(inParam);

		if(!outParam) {
			throw new EnfraBusinessException("E000034"); // 마감정보 확인바랍니다.

		}

		return outParam;

	}
	
	/**
     * @brief 기타유형자산의 감가상각 기초생성 정보 등록
     * @details 기타유형자산의 감가상각 기초생성 정보 등록
	 * @author : 이동겸
	 * @date : 2020. 10. 15.
     * @version : 1.0.0
     * @param IA900001IN
     * @return int
     */
	private int calliA9000insertClsnYnReg(IA900001IN inParam) throws EnfraBusinessException
	{
		System.out.println(inParam.getBaseYm());
		System.out.println(inParam.getScrNo());
		System.out.println(inParam.getUsrId());
		int outParam = iA9000.insertClsnYnReg(inParam);

		return outParam;

	}

}

