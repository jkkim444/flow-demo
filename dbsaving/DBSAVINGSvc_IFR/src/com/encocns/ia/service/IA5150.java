/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5150.java
 * @brief 수익용 부동산 보유 현황 Service
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
import com.encocns.ia.dao.IA5150DAO;
import com.encocns.ia.dto.IA515001DTO;
import com.encocns.ia.service.svo.IA515001IN;
import com.encocns.ia.service.svo.IA515001OUT;
import com.encocns.ia.service.svo.IA515002IN;
import com.encocns.ia.service.svo.IA515002OUT;
import com.encocns.ia.service.svo.IA515003IN;
import com.encocns.ia.service.svo.IA515003OUT;
import com.encocns.ia.service.svo.IA515004IN;
import com.encocns.ia.service.svo.IA515004OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 수익용 부동산 보유 현황 Service
 * @details 수익용 부동산 보유 현황 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5150 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5150.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5150DAO daoIA5150;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 수익용 부동산 보유 현황 조회
     * @details 수익용 부동산 보유 현황 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515001IN
     * @returnList IA515001OUT
     */
	public IA515001OUT selectListEarnRlesHold(IA515001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListEarnRlesHold -----");
		IA515001OUT outParamList = new IA515001OUT();

	    List<IA515001DTO> list = null;

    	list =  daoIA5150.selectListEarnRlesHold(inParam);

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
     * @brief 수익용 부동산 보유 현황 등록 및 수정
     * @details 수익용 부동산 보유 현황 등록 및 수정
	 * @author : 이동겸
	 * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515002IN
     * @return IA515002OUT
     */
	public IA515002OUT mergeEarnRlesHold(IA515002IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeEarnRlesHold -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        //ruleSet.addRule("cllpNo", new RequiredRule(true));
        ruleSet.addRule("cllpNm", new RequiredRule(true));
        ruleSet.addRule("owhsRate", new RequiredRule(true));
        ruleSet.addRule("lentRate", new RequiredRule(true));
        ruleSet.addRule("lndAcqsAmt", new RequiredRule(true));
        ruleSet.addRule("lndDprcCmtlAmt", new RequiredRule(true));
        ruleSet.addRule("bldgAcqsAmt", new RequiredRule(true));
        ruleSet.addRule("bldgDprcCmtlAmt", new RequiredRule(true));
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("acqsDt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */

        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIA5150.insertEarnRlesHold(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
    		iResult = daoIA5150.updateEarnRlesHold(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IA515002OUT outParam = new IA515002OUT();
		outParam.setiResult(iResult);
		return outParam;
	}

    /**
     * @brief 수익용 부동산 정보 삭제
     * @details 수익용 부동산 정보 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515003IN
     * @return IA515003OUT
     */
	public IA515003OUT deleteEarnRlesHold(IA515003IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEarnRlesHold -----");
        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

		IA515003OUT outParam = new IA515003OUT();
		outParam.setiResult(daoIA5150.deleteEarnRlesHold(inParam));

		return outParam;
	}

	/**
     * @brief 기초 이월 수익용 부동산 보유
     * @details 기초 이월 수익용 부동산 보유
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA515004IN
     * @return IA515004OUT
     */

	public IA515004OUT insertEarnRlesHoldBass(IA515004IN inParam) throws Exception
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEtcTypAsetDprcBass -----");

        /*
         * 1.기준년월 + 등록자('9999')  가 존재 하는 경우 기초 자료 생성 오류 처리
         *
         * 특정 사번인 경우 무시 하고 처리(일단 송아영)(todo)
         *         *
         * */
        int iResult = 0;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        IA515004OUT outParam = new IA515004OUT();

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
        * 기초생성 여부 검증
        *
        * */
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        calliA9000selectBassCrtnYnIqry(inIA900001IN);


        iResult += daoIA5150.deleteEarnRlesHoldAll(inParam);

    	try {
        	// 등록 처리
    		iResult += daoIA5150.insertEarnRlesHoldBass(inParam);
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
     * @brief 분개 대상 검증 데이타 생성 처리 한다
     * @details 수익용 부동산 보유  산출 처리
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA515004IN
     * @return IA515004OUT
     */
	public IA515004OUT calcJrlzTrgtAmt(IA515004IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        int iResult = 0;

        /**
         *  ( 기타유형자산의 감가상각방법 변경 : 정률법 → 정액법 Conversion_7 )    (TODO)
         *
         * 01. 상각누계 금액 산출
         *
         * 02. 분개데이터대상내역 삭제 처리
         *
         * 03. 분개데이터대상내역 등록 처리
         *
         * 04. IFRS분개전표상세  삭제
         *
         * 05. IFRS분개전표상세  등록
         * */

        //01
        iResult += daoIA5150.updateEarnRlesHoldClcl(inParam);
        //02
        iResult += daoIA5150.deleteCalcJrlzTrgtAmt(inParam);
        //03
        iResult += daoIA5150.insertCalcJrlzTrgtAmt(inParam);
        //04
        iResult += daoIA5150.deletejrlzDtlProcs(inParam);
        //05
        iResult += daoIA5150.insertjrlzDtlProcs(inParam);

        IA515004OUT outParam = new IA515004OUT();
		outParam.setiResult(iResult);

		return outParam;

	}

    /**
     * @brief 복구충당부채 기초생성 정보 등록
     * @details 복구충당부채 감가상각 기초생성 정보 등록
	 * @author : 이동겸
	 * @date : 2020. 10. 15.
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
	 * @date : 2020. 10. 15.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */

	private boolean calliA9000selectClsnYnIqry(IA900001IN inParam) throws EnfraBusinessException {
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
}
