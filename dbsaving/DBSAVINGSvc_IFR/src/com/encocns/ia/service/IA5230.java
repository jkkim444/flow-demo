/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5230.java
 * @brief 임차시설물 복구충당부채 Service
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
import com.encocns.ia.dao.IA5230DAO;
import com.encocns.ia.dto.IA523001DTO;
import com.encocns.ia.service.svo.IA523001IN;
import com.encocns.ia.service.svo.IA523001OUT;
import com.encocns.ia.service.svo.IA523002IN;
import com.encocns.ia.service.svo.IA523002OUT;
import com.encocns.ia.service.svo.IA523003IN;
import com.encocns.ia.service.svo.IA523003OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 복구충당부채 산출내역 Service
 * @details 복구충당부채 산출내역 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
@Service
public class IA5230 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5230.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5230DAO daoIA5230;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 복구충당부채 산출내역 조회
     * @details 복구충당부채 산출내역 조회
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523001IN
     * @return IA523001OUT
     */
	public IA523001OUT selectListRcvrRsrvClcl(IA523001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRcvrRsrvClcl -----");

		IA523001OUT outParamList = new IA523001OUT();

	    List<IA523001DTO> list = null;

	    list =  daoIA5230.selectListRcvrRsrvClcl(inParam);

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
     * @brief 복구충당부채 산출내역 등록 및 수정
     * @details 복구충당부채 산출내역 등록 및 수정
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return IA523002OUT
     */
	public IA523002OUT mergeRcvrRsrvClcl(IA523002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRcvrRsrvClcl -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("seqno", new RequiredRule(true));
        ruleSet.addRule("lnrnBrofCd", new RequiredRule(true));
        ruleSet.addRule("enbrDt", new RequiredRule(true));
        ruleSet.addRule("cntrDt", new RequiredRule(true));
        ruleSet.addRule("rcvrAntciDt", new RequiredRule(true));
        ruleSet.addRule("cntrAre", new RequiredRule(true));
        ruleSet.addRule("cntrMmCnt", new RequiredRule(true));
        ruleSet.addRule("aplyDcrt", new RequiredRule(true));
        ruleSet.addRule("rbfRcvrAntciCost", new RequiredRule(true));
        ruleSet.addRule("rcvrAprpDbtlRessAmt", new RequiredRule(true));
        ruleSet.addRule("closeRcvrAprpDbtl", new RequiredRule(true));
        ruleSet.addRule("closeStlmRentFclts", new RequiredRule(true));
        ruleSet.addRule("closeStlmDprcCmtl", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 복구충당부채 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        int iResult = 0;
        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIA5230.insertRcvrRsrvClcl(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
        		//업데이트 처리
        		iResult = daoIA5230.updateRcvrRsrvClcl(inParam);
        		
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IA523002OUT outParam = new IA523002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 복구충당부채 산출내역 삭제
     * @details 복구충당부채 산출내역 삭제
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523003IN
     * @return IA523003OUT
     */
	public IA523003OUT deleteRcvrRsrvClcl(IA523003IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcvrRsrvClcl -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("seqno", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 복구충당부채 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

		IA523003OUT outParam = new IA523003OUT();
		outParam.setiResult(daoIA5230.deleteRcvrRsrvClcl(inParam));

		return outParam;
	}



	/**
     * @brief 복구충당부채 기초 생성
     * @details 복구충당부채 기초 생성
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return IA523002OUT
     */
	public IA523002OUT insertRcvrRsrvClclBass(IA523002IN inParam) throws Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcvrRsrvClclBass -----");

       
        int iResult = 0;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        IA523002OUT outParam = new IA523002OUT();

        /**
        *
        * 복구충당부채 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /**
        *
        * 복구충당부채 기초생성 정보 조회
        *
        * */
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        calliA9000selectBassCrtnYnIqry(inIA900001IN);

        iResult += daoIA5230.deleteRcvrRsrvClclAll(inParam);

    	try {
        	// 등록 처리
    		iResult += daoIA5230.insertRcvrRsrvClclBass(inParam);
    	}
    	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}

		/**
        *
        * 복구충당부채 기초생성 정보 저장
        *
        * */

        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
		iResult += calliA9000insertClsnYnReg(inIA900001IN);

    	outParam.setiResult(iResult);

		return outParam;
	}

	/**
     * @brief 복구충당부채 산출 
     * @details 복구충당부채 산출
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return IA523002OUT
     */
	public IA523002OUT calcJrlzTrgtAmt(IA523002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
		IA523002OUT outParam = new IA523002OUT();

        /**
        *
        * 복구충당부채 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

		int iResult = 0;
		/**
	     * 01. 복구 충당금 산출 결과 반영
         *
         * 02. 분개데이터대상내역 삭제 처리
         *
         * 03. 분개데이터대상내역 등록 처리
         *
         * 04. 분개데이터 상세 삭제 처리
         *
         * 05. 분개데이터 상세 등록 처리         *
         *
         * */

		iResult += daoIA5230.updateRcvrRsrvClclrslt(inParam); //01
		iResult += daoIA5230.updateRcvrRsrvClclrslt_2(inParam); //01
		
		
		iResult += daoIA5230.deleteCalcJrlzTrgtAmt(inParam);  //02
		iResult += daoIA5230.insertCalcJrlzTrgtAmt(inParam);  //03

		iResult += daoIA5230.deletejrlzDtlProcs(inParam);	  //04
        iResult += daoIA5230.insertjrlzDtlProcs(inParam);     //05

		outParam.setiResult(iResult);

		return outParam;


	}


    /**
     * @brief 복구충당부채 기초생성 정보 등록
     * @details 복구충당부채 기초생성 정보 등록
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
     * @brief 기초 생성 여부 검증
     * @details 기초 생성 확인 검증
	 * @author : 이동겸
	 * @date : 2020. 10. 26.
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
}
