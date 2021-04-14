/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2040.java
 * @brief 개별평가대상 관리 Service
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
import com.encocns.ia.service.IA9000;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;
import com.encocns.ip.dao.IP2040DAO;
import com.encocns.ip.dto.IP204001DTO;
import com.encocns.ip.service.svo.IP204001IN;
import com.encocns.ip.service.svo.IP204001OUT;
import com.encocns.ip.service.svo.IP204002IN;
import com.encocns.ip.service.svo.IP204002OUT;
import com.encocns.ip.service.svo.IP204003IN;
import com.encocns.ip.service.svo.IP204003OUT;

/**
 * @brief 개별평가대상 관리 Service
 * @details 개별평가대상 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2040 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2040.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2040DAO daoIP2040;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 개별평가대상 목록 조회
     * @details 개별평가대상 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204001IN
     * @return IP204001OUT
     */
	public IP204001OUT selectListIndvEvalTrgt(IP204001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIndvEvalTrgt -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IP204001OUT outParamList = new IP204001OUT();

	    int totalCount = daoIP2040.selectTotalCount(inParam);

	    List<IP204001DTO> arrList = null;

	    // 페이징 없는 조회
	    if( inParam.getSelectPage()==-1 ) {
	    	arrList =  daoIP2040.selectListIndvEvalTrgt(inParam);
	    }
	    // 페이징 있는 조회
	    else {
	    	arrList =  daoIP2040.selectPaging(inParam);
	    }

	    outParamList.setCurrentPageNo(inParam.getSelectPage());
	    outParamList.setTotalCount(totalCount);
	    outParamList.setList(arrList);

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
     * @brief 개별평가대상 기초 생성
     * @details 개별평가대상 기초를 생성합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return IP204002OUT
     */
	public IP204002OUT insertIndvEvalTrgtBass(IP204002IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEtcTypAsetDprcBass -----");

        int iResult = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        IP204002OUT outEtc = new IP204002OUT();
        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        List<IP204001DTO> list = daoIP2040.selectIndvEvalTrgtBass(inParam);
        /**
         * 이월한 계좌번호 조회
         * */
        for(IP204001DTO iP204001DTO : list) {
            /**
             * 대손충당금 기본에 등록 되어있는 계좌번호인지 조회
             * */
        	inParam.setLoanAcno(iP204001DTO.getLoanAcno());
            iResult = daoIP2040.selectChkLnrnlsrsrvtrgtbsic(inParam);
            if(daoIP2040.selectChkLnrnlsrsrvtrgtbsic(inParam) == 0) {
            	throw new EnfraBusinessException("E000035"); // 미존재 대출계좌번호 입니다.
            }
        }

        /* 기존 자료 삭제 처리 후 반영 */
        iResult += daoIP2040.deleteIndvEvalTrgtBass(inParam);

        try {
        	iResult += daoIP2040.insertIndvEvalTrgtBass(inParam);
        }
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}
        /** 개별 평가 여부 처리    */
       	iResult += daoIP2040.updateBadlnRsrvIndvEvalTrgt(inParam);

        outEtc.setiResult(iResult);
		return outEtc;
	}

    /**
     * @brief 개별평가대상 등록 및 수정
     * @details 개별평가대상을 등록 및 수정합니다.
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return IP204002OUT
     */
	public IP204002OUT mergeIndvEvalTrgt(IP204002IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeIndvEvalTrgt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("loanAcno", new RequiredRule(true));
        ruleSet.addRule("loanBal", new RequiredRule(true));
        ruleSet.addRule("indvEvalRsrv", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);
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
         * 대손충당금 기본에 등록 되어있는 계좌번호인지 조회
         * */

        iResult = daoIP2040.selectChkLnrnlsrsrvtrgtbsic(inParam);
        if(daoIP2040.selectChkLnrnlsrsrvtrgtbsic(inParam) == 0) {
        	throw new EnfraBusinessException("E000035"); // 미존재 대출계좌번호 입니다.
        }

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIP2040.insertIndvEvalTrgt(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
        		//업데이트 처리
        	iResult = daoIP2040.updateIndvEvalTrgt(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

        /** 개별 평가 여부 처리    */
       	iResult += daoIP2040.updateBadlnRsrvIndvEvalTrgt(inParam);

		IP204002OUT outParam = new IP204002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 개별평가대상 정보 삭제
     * @details 개별평가대상 정보를 삭제합니다.
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204003IN
     * @return IP204003OUT
     */
	public IP204003OUT deleteIndvEvalTrgt(IP204003IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIndvEvalTrgt -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("loanAcno", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);
        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        int iResult =0;

        IP204002IN inIP204002IN = new IP204002IN();
        inIP204002IN.setStdrYm(inParam.getStdrYm());

        iResult += daoIP2040.deleteIndvEvalTrgt(inParam);
        iResult += daoIP2040.updateBadlnRsrvIndvEvalTrgt(inIP204002IN);

		IP204003OUT outParam = new IP204003OUT();
		outParam.setiResult(iResult);

		return outParam;
	}


	/**
     * @brief 개별평가대상 엑셀 업로드
     * @details 개별평가대상 엑셀업로드합니다.
  	 * @author : CHOI, HO-YEON
  	 * @date : 2020. 10. 12.
     * @version : 1.0.0
     * @param IP204002IN
     * @return IP204002OUT
     */
	public IP204002OUT insertIndvEvalTrgtExcl(IP204002IN inParam)throws EnfraBusinessException
	{
     if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRcPdRflc -----");

     inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

     // Parameter validation
     RuleSet ruleSet = new RuleSet();
     ruleSet.addRule("arrGridData", new RequiredRule(true));

     Validator.validation(inParam, ruleSet);
     /**
     *
     * 마감 여부 검증
     *
     * */
     IA900001IN inIA900001IN  = new IA900001IN();
     inIA900001IN.setBaseYm(inParam.getArrGridData().get(0).getStdrYm());
     calliA9000selectClsnYnIqry(inIA900001IN);

     /*loop 반영 */

     int iResult = 0 ;

     iResult = daoIP2040.deleteIndvEvalTrgtExcl(inParam.getArrGridData().get(0));

     for(IP204001DTO iP204001DTO : inParam.getArrGridData()){

    	 IP204002IN iP204002IN = new IP204002IN();


    	 iP204002IN.setUsrId(serviceComponent.getSessionVO().getUserId());
    	 iP204002IN.setStdrYm(iP204001DTO.getStdrYm());
    	 iP204002IN.setLoanAcno(iP204001DTO.getLoanAcno().trim());
    	 iP204002IN.setLoanBal(iP204001DTO.getLoanBal());
    	 iP204002IN.setIndvEvalRsrv(iP204001DTO.getIndvEvalRsrv());
         /** 개별 평가 여부 처리    */
     	 iResult += daoIP2040.insertIndvEvalTrgtExcl(iP204002IN);
     	 iResult += daoIP2040.updateBadlnRsrvIndvEvalTrgt(iP204002IN);

     }

        IP204002OUT outEtc = new IP204002OUT();
		outEtc.setiResult(iResult);
		return outEtc;
	}
    /**
     * @brief 마감여부 검증
     * @details 마감여부 확인 검증합니다.
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

