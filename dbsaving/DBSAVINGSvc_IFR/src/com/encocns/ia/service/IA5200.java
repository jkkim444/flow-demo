/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5200.java
 * @brief 임대차보증금 현재가치 산출내역 관리 Service
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.dao.IA5200DAO;
import com.encocns.ia.dto.IA520001DTO;
import com.encocns.ia.service.svo.IA520001IN;
import com.encocns.ia.service.svo.IA520001OUT;
import com.encocns.ia.service.svo.IA520002IN;
import com.encocns.ia.service.svo.IA520002OUT;
import com.encocns.ia.service.svo.IA520003IN;
import com.encocns.ia.service.svo.IA520003OUT;
import com.encocns.ia.service.svo.IA520004IN;
import com.encocns.ia.service.svo.IA520004OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 임대차보증금 현재가치 산출내역 관리 Service
 * @details 임대차보증금 현재가치 산출내역 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5200 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5200.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5200DAO daoIA5200;

	@Autowired
	private IA9000 iA9000;
    /**
     * @brief 임대차보증금 현재가치 산출내역 관리 조회
     * @details 임대차보증금 현재가치 산출내역 관리 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520001IN
     * @return IA520001OUT
     */
	public IA520001OUT selectListLnrnGrmnClcl(IA520001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLnrnGrmnClcl -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IA520001OUT outParamList = new IA520001OUT();

	    List<IA520001DTO> list = null;

	    /**
	     * 1. 조건에 해당하는 자료 조회한다
	     *
	     * */
    	list =  daoIA5200.selectListLnrnGrmnClcl(inParam);

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
     * @brief 임대차보증금 현재가치 산출내역 등록 및 수정
     * @details 임대차보증금 현재가치 산출내역 등록 및 수정
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520002IN
     * @return IA520002OUT
     */
	public IA520002OUT mergeLnrnGrmnClcl(IA520002IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeEarnRlesHold -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("lnrnDvcd", new RequiredRule(true));
        ruleSet.addRule("lnrnBrofCd", new RequiredRule(true));
        ruleSet.addRule("brofNm", new RequiredRule(true));
        ruleSet.addRule("grmn", new RequiredRule(true));
        ruleSet.addRule("lnrnStdd", new RequiredRule(true));
        ruleSet.addRule("lnrnEndt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 임대차보증금 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        int iResult = 0 ;

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */

        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIA5200.insertLnrnGrmnClcl(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
        	iResult = daoIA5200.updateLnrnGrmnClcl(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }


		IA520002OUT outParam = new IA520002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 삭제
     * @details 임대차보증금 현재가치 산출내역 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520003IN
     * @return IA520003OUT
     */
	public IA520003OUT deleteLnrnGrmnClcl(IA520003IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEarnRlesHold -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("seqno", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 임대차보증금 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

		IA520003OUT outParam = new IA520003OUT();
		outParam.setiResult(daoIA5200.deleteLnrnGrmnClcl(inParam));

		return outParam;
	}
	/**
     * @brief 기초 이월 임대차 보증금 현재가치 산출내역
     * @details 기초 이월 임대차 보증금 현재가치 산출내역
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA520004IN
     * @return IA520004OUT
     */

	public IA520004OUT insertLnrnGrmnClclBass(IA520004IN inParam) throws Exception
	{
		   	RuleSet ruleSet = new RuleSet();

	        ruleSet.addRule("stdrYm", new RequiredRule(true));
	        ruleSet.addRule("frtrYm", new RequiredRule(true));

	        Validator.validation(inParam, ruleSet);


	        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

	        IA520004OUT outParam = new IA520004OUT();

	        int iResult = 0;

	        /**
	        *
	        * 마감 여부 검증
	        *
	        * */
	        IA900001IN inIA900001IN  = new IA900001IN();
	        inIA900001IN.setBaseYm(inParam.getStdrYm());
	        calliA9000selectClsnYnIqry(inIA900001IN);

	        /**
	        *
	        * 임대차보증금 기초생성 정보 조회
	        *
	        * */
	        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
	        calliA9000selectBassCrtnYnIqry(inIA900001IN);

	        /**
	        *
	        * 01. 임대차보증금 기초삭제
	        *
	        * 02. 임대차보증금 기초생성
	        *
	        * */

	        iResult += daoIA5200.deleteLnrnGrmnClclAll(inParam);	//01

	        iResult += daoIA5200.insertLnrnGrmnClclBass(inParam);	//02

	        
			/**
	        *
	        * 임대차보증금 기초생성 정보 저장
	        *
	        * */

	        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
			iResult += calliA9000insertClsnYnReg(inIA900001IN);

	   		outParam.setiResult(iResult);

			return outParam;
	}


	/**
     * @brief 임대차보증금현재가치산출내역 데이타 생성
     * @details 임대차보증금현재가치산출내역 산출 
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA520004IN
     * @return IA520004OUT
     */
	public IA520004OUT calcJrlzTrgtAmt(IA520004IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
        *
        * 임대차보증금 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        int iResult = 0;

        /**
        *
        * 01. 임대차보증금 월수 산출
        *
        * 02. 임대차보증금 금액 산출
        *
        * */

        iResult += daoIA5200.updatetLnrnGrmnClclClcl(inParam);      /* 01 (월수 산출)*/

        iResult += daoIA5200.updatetLnrnGrmnClclClclAmt(inParam);   /* 02 (금액 산출)*/



        /**
        *
        *  1.필수입력 항목 검증 필요 (todo)
        *    기준년월 ,전기년월  , 임대구분코드
        */


        /**
         *  금융자산인 임차보증금의 최초 인식금액 전환 (현재가치 반영) (별도)  (S06)  == > 임차(02)  ==> Conversion_3
         *  금융부채인 임대보증금의 최초 인식금액 전환(현재가치 반영) (별도)  (S09)  == > 임대(01)  ==> Conversion_4
         *
         * 01. 상각누계 금액 산출
         *
         * 02. 분개데이터대상내역 삭제 처리
         *
         * 03. IFRS분개전표상세  삭제
         *
         * 04. 분개데이터대상내역 등록 처리
         *
         * 05. IFRS분개전표상세  등록
         *
         * */




        if("01".equals(inParam.getLnrnDvcd())) {   /* 01 : 임차 */

        	inParam.setJrlzBzwkCd("S06");
            iResult += daoIA5200.deleteCalcJrlzTrgtAmt(inParam);        /* 02 */
        	iResult += daoIA5200.deletejrlzDtlProcs(inParam);           /* 03 */
            iResult += daoIA5200.insertCalcJrlzTrgtAmt_S06(inParam); /* 04 */
            iResult += daoIA5200.insertjrlzDtlProcs_S06(inParam);    /* 05 */
        }else if("02".equals(inParam.getLnrnDvcd())) { /* 02 : 임대 */
        	inParam.setJrlzBzwkCd("S09");
            iResult += daoIA5200.deleteCalcJrlzTrgtAmt(inParam);        /* 02 */
        	iResult += daoIA5200.deletejrlzDtlProcs(inParam);           /* 03 */
            iResult += daoIA5200.insertCalcJrlzTrgtAmt_S09(inParam); /* 04 */
            iResult += daoIA5200.insertjrlzDtlProcs_S09(inParam);    /* 05 */
        }else {
        	/* 임대차 구분코드 오류 처리 */
        	throw new EnfraBusinessException("E000029"); // 산출시 임대차 구분코드를 선택해주십시오.
        }
        IA520004OUT outParam = new IA520004OUT();
		outParam.setiResult(iResult);

		return outParam;

	}


    /**
     * @brief 임대차보증금 기초생성 정보 등록
     * @details 임대차보증금 기초생성 정보 등록
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
