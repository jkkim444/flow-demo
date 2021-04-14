/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5130.java
 * @brief 기타유형자산 관리 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 24. | First Created
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
import com.encocns.ia.dao.IA5130DAO;
import com.encocns.ia.dto.IA513001DTO;
import com.encocns.ia.service.svo.IA513001IN;
import com.encocns.ia.service.svo.IA513001OUT;
import com.encocns.ia.service.svo.IA513002IN;
import com.encocns.ia.service.svo.IA513002OUT;
import com.encocns.ia.service.svo.IA513003IN;
import com.encocns.ia.service.svo.IA513003OUT;
import com.encocns.ia.service.svo.IA513004IN;
import com.encocns.ia.service.svo.IA513004OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 기타유형자산 Service
 * @details 기타유형자산 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
@Service
public class IA5130 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5130.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5130DAO daoIA5130;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 기타유형자산 내역 조회
     * @details 기타유형자산 내역 조회
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA513001IN
     * @return IA513001OUT
     */
	public IA513001OUT selectListEtcTypAsetDprc(IA513001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListEtcTypAsetDprc -----");

		IA513001OUT outParam = new IA513001OUT();

	    int totalCount = daoIA5130.selectTotalCount(inParam);

	    List<IA513001DTO> list = null;

	    if( inParam.getSelectPage()==-1 ) {
	    	list =  daoIA5130.selectListEtcTypAsetDprc(inParam);
	    }
	    else {
	    	list =  daoIA5130.selectPaging(inParam);
	    }

	    outParam.setCurrentPageNo(inParam.getSelectPage());
	    outParam.setTotalCount(totalCount);
	    outParam.setList(list);

	   	// 마감 미마감 표시
	   	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setClsnCtnt("미마감");
	   	}else {
	   		outParam.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}

		return outParam;

	}


    /**
     * @brief 기타유형자산 엑셀 다운로드
     * @details 기타유형자산 엑셀 다운로드
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA513001IN
     * @return IA513001OUT
     */

	public IA513001OUT selectListEtcTypAsetDprcExcl(IA513001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListEtcTypAsetDprcExcl -----");

		IA513001OUT outParam = new IA513001OUT();

	    List<IA513001DTO> list = null;

    	list =  daoIA5130.selectListEtcTypAsetDprc(inParam);

	    outParam.setList(list);
		return outParam;

	}


    /**
     * @brief 기타유형자산 기초 자료생성
     * @details 기타유형 자산 기초 자료 생성
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA513002IN
     * @return IA513002OUT
     */

	public IA513002OUT insertEtcTypAsetDprcBass(IA513002IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEtcTypAsetDprcBass -----");


        /*
         * 1.기준년월 + 등록자('9999')  가 존재 하는 경우 기초 자료 생성 오류 처리
         *
         * 특정 사번인 경우 무시 하고 처리(일단 송아영)(todo)
         *         *
         * */
        int iResult = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        IA513002OUT outEtc = new IA513002OUT();

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


        /* 기존 자료 삭제 처리 후 반영 */
        iResult += daoIA5130.deleteEtcTypAsetDprcAll(inParam);

        try {
        	iResult += daoIA5130.insertEtcTypAsetDprcBass(inParam);
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

        outEtc.setiResult(iResult);
		return outEtc;
	}

    /**
     * @brief 당기 신규 기타유형자산 등록 및 수정
     * @details 당기 신규  기타유형자산 등록 및 수정
	 * @author : 이동겸
	 * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA513002IN
     * @return IA513002OUT
     */
	public IA513002OUT mergeEtcTypAsetDprc(IA513002IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeEtcTypAsetDprc -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
        *
        * 기타유형자산 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("brcd", new RequiredRule(true));
        ruleSet.addRule("teamCd", new RequiredRule(true));

        ruleSet.addRule("prodNm", new RequiredRule(true));
        ruleSet.addRule("acqsDt", new RequiredRule(true));
        ruleSet.addRule("bkvalAmt", new RequiredRule(true));
        //ruleSet.addRule("seqno", new RequiredRule(true));   수정인 경우만 처리

        Validator.validation(inParam, ruleSet);

        int iResult = 0 ;

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */

        if("I".equals(inParam.getJobDivCd())) {

            /**
             * 1.기준년월 계좌번호 부서 팀, 취득일자가 동일한 경우 중볻 등록 오류 처리(todo)
             * */

        	try {
            	// 등록 처리
        		iResult = daoIA5130.insertEtcTypAsetDprc(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
        	iResult = daoIA5130.updateEtcTypAsetDprc(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IA513002OUT outEtc = new IA513002OUT();
		outEtc.setiResult(iResult);
		return outEtc;
	}


    /**
     * @brief 기타유형자산 삭제
     * @details 기타유형자산 삭제
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA513003IN
     * @return IA513003OUT
     */
	public IA513003OUT deleteEtcTypAsetDprc(IA513003IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEtcTypAsetDprc -----");


        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

		IA513003OUT outEtc = new IA513003OUT();
		outEtc.setiResult(daoIA5130.deleteEtcTypAsetDprc(inParam));

		return outEtc;
	}
	/**
     * @brief 당기 신규 기타유형자산 엑셀 반영
     * @details 당기 신규 기타유형자산 엑셀 반영
	 * @author : 이동겸
	 * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA513004IN
     * @return IA513004OUT
     */
	public IA513004OUT insertEtcTypAsetDprcExcl(IA513004IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEtcTypAsetDprcExcl -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("arrGridData", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        /*loop 반영 */

        int iResult = 0 ;

        for(IA513001DTO iA513001DTO : inParam.getArrGridData()){

        	IA513002IN iA513002IN = new IA513002IN();

            /**
             * 1.기준년월 계좌번호 부서 팀, 취득일자가 동일한 경우 중복 등록 오류 처리(todo)
             * */
            /**
            *
            * 마감 여부 검증
            *
            * */
            IA900001IN inIA900001IN  = new IA900001IN();
            inIA900001IN.setBaseYm(iA513001DTO.getStdrYm());
            calliA9000selectClsnYnIqry(inIA900001IN);


        	iA513002IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        	iA513002IN.setAcno(iA513001DTO.getAcno());
        	iA513002IN.setAcqsDt(iA513001DTO.getAcqsDt());
        	iA513002IN.setBkvalAmt(iA513001DTO.getBkvalAmt());;
        	iA513002IN.setBrcd(iA513001DTO.getBrcd());
        	iA513002IN.setProdNm(iA513001DTO.getProdNm());
        	iA513002IN.setStdrYm(iA513001DTO.getStdrYm());
        	iA513002IN.setTeamCd(iA513001DTO.getTeamCd());;

        	iResult += daoIA5130.insertEtcTypAsetDprc(iA513002IN);

        }

		IA513004OUT outEtc = new IA513004OUT();
		outEtc.setiResult(iResult);
		return outEtc;
	}

    /**
     * @brief 분개 대상 검증 데이타 생성 처리
     * @details 계리보고서 저장 처리 한다
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA513002IN
     * @return IA513002OUT
     */
	public IA513002OUT calcJrlzTrgtAmt(IA513002IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0;

        /**
        *
        * 기타유형자산 마감여부  검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


        /**
         *  ( 기타유형자산의 감가상각방법 변경 : 정률법 → 정액법 Conversion_7 )
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
        iResult += daoIA5130.updateDprcCmtlClcl(inParam);
        //02
        iResult += daoIA5130.deleteCalcJrlzTrgtAmt(inParam);
        //03
        iResult += daoIA5130.insertCalcJrlzTrgtAmt(inParam);
        //04
        iResult += daoIA5130.deletejrlzDtlProcs(inParam);
        //05
        iResult += daoIA5130.insertjrlzDtlProcs(inParam);


        IA513002OUT outParam = new IA513002OUT();
		outParam.setiResult(iResult);

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

    /**
     * @brief 마감여부  검증
     * @details 마감여부 확인 검증
	 * @author : CHOI,HO-YEON
	 * @date : 2020. 10. 15.
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
}

