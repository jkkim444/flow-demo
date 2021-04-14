/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5310.java
 * @brief 리스부채사용권관리 Service
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 9. 24. | First Created
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
import com.encocns.ia.dao.IA5310DAO;
import com.encocns.ia.dto.IA531001DTO;
import com.encocns.ia.service.svo.IA531001IN;
import com.encocns.ia.service.svo.IA531001OUT;
import com.encocns.ia.service.svo.IA531002IN;
import com.encocns.ia.service.svo.IA531002OUT;
import com.encocns.ia.service.svo.IA531003IN;
import com.encocns.ia.service.svo.IA531003OUT;
import com.encocns.ia.service.svo.IA531004IN;
import com.encocns.ia.service.svo.IA531004OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 리스부채사용권관리 Service
 * @details 리스부채사용권관리 서비스입니다.
 * @author : 이미래
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
@Service
public class IA5310 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5310.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5310DAO daoIA5310;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 리스부채사용권관리 내역 조회
     * @details 리스부채사용권관리 내역 조회
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531001IN
     * @return IA531001OUT
     */
	public IA531001OUT selectListLeasDbtlUz(IA531001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLeasDbtlUz -----");

		IA531001OUT outParam = new IA531001OUT();
		List<IA531001DTO> outIA531001DTO = null;

		outIA531001DTO =  daoIA5310.selectListLeasDbtlUz(inParam);

	    outParam.setList(outIA531001DTO);

	    // 마감정보 표시
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
     * @brief 리스부채사용권관리 기초 자료생성 
     * @details 리스부채사용권관리 기초 자료생성
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return IA531002OUT
     */

	public IA531002OUT insertLeasDbtlUzBass(IA531002IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLeasDbtlUzBass -----");


        int iResult = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        IA531002OUT outEtc = new IA531002OUT();

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
        iResult += daoIA5310.deleteLeasDbtlUzAll(inParam);

        try {
        	iResult += daoIA5310.insertLeasDbtlUzBass(inParam);
        }
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}

		/**
        *
        * 리스부채사용권관리 기초생성 정보 저장
        *
        * */

        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
		iResult += calliA9000insertClsnYnReg(inIA900001IN);

        outEtc.setiResult(iResult);
		return outEtc;
	}

    /**
     * @brief 리스부채사용권 당기 정보 등록 및 수정
     * @details 리스부채사용권 당기 정보 등록 및 수정
	 * @author : 이미래
	 * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return IA531002OUT
     */
	public IA531002OUT mergeLeasDbtlUz(IA531002IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeLeasDbtlUz -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
        *
        * 리스부채사용권관리 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("seqno", new RequiredRule(true));
        ruleSet.addRule("leasDivCd", new RequiredRule(true));
        ruleSet.addRule("leasCntrStrtDt", new RequiredRule(true));
        ruleSet.addRule("leasCntrEndDt", new RequiredRule(true));
        
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
        		iResult = daoIA5310.insertLeasDbtlUz(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
        	iResult = daoIA5310.updateLeasDbtlUz(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IA531002OUT outEtc = new IA531002OUT();
		outEtc.setiResult(iResult);
		return outEtc;
	}


    /**
     * @brief 리스부채사용권관리 삭제
     * @details 리스부채사용권관리 삭제
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531003IN
     * @return IA531003OUT
     */
	public IA531003OUT deleteLeasDbtlUz(IA531003IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLeasDbtlUz -----");


        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

		IA531003OUT outEtc = new IA531003OUT();
		outEtc.setiResult(daoIA5310.deleteLeasDbtlUz(inParam));

		return outEtc;
	}
	/**
     * @brief 리스부채사용권 내역 반영
     * @details 리스부채사용권 내역 엑셀 반영
	 * @author : 이미래
	 * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531004IN
     * @return IA531004OUT
     */
	public IA531004OUT insertLeasDbtlUzExcl(IA531004IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeLeasDbtlUz -----");
        
        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getArrGridData().get(0).getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("arrGridData", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        /*loop 반영 */

        int iResult = 0 ;

        for(IA531001DTO iA513001DTO : inParam.getArrGridData()){

        	IA531002IN iA513002IN = new IA531002IN();

        	iA513002IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        	iA513002IN.setStdrYm(iA513001DTO.getStdrYm());
        	iA513002IN.setSeqno(iA513001DTO.getSeqno());
        	iA513002IN.setUzAsetAmt(iA513001DTO.getUzAsetAmt());
        	iA513002IN.setDprcCmtlAmt(iA513001DTO.getDprcCmtlAmt());
        	iA513002IN.setLeasDbtlAmt(iA513001DTO.getLeasDbtlAmt());
        	iA513002IN.setDpcs(iA513001DTO.getDpcs());
        	iA513002IN.setIntCost(iA513001DTO.getIntCost());
        	iA513002IN.setHrfeSbtrAmt(iA513001DTO.getHrfeSbtrAmt());
        	iA513002IN.setLeasDbtlClsPrft(iA513001DTO.getLeasDbtlClsPrft());
        	iA513002IN.setLeasDbtlClsLss(iA513001DTO.getLeasDbtlClsLss());
        	
        	iResult += daoIA5310.updateLeasDbtlUzExcel(iA513002IN);

        }

		IA531004OUT outEtc = new IA531004OUT();
		outEtc.setiResult(iResult);
		return outEtc;
	}

    /**
     * @brief 분개 대상 검증 데이타 생성 처리 한다
     * @details 계리보고서 저장 처리 한다
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return IA531002OUT
     */
	public IA531002OUT calcJrlzTrgtAmt(IA531002IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0;

        /**
        *
        * 리스부채사용권관리 마감여부  검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


        /**
         *  KIFRS 1116호 : 리스사용권자산과 리스부채 인식 (별도)
         *
         *
         * 02. 분개데이터대상내역 삭제 처리
         *
         * 03. 분개데이터대상내역 등록 처리
         *
         * 04. IFRS분개전표상세  삭제
         *
         * 05. IFRS분개전표상세  등록
         * */

        //02
        iResult += daoIA5310.deleteCalcJrlzTrgtAmt(inParam);
        //03
        iResult += daoIA5310.insertCalcJrlzTrgtAmt_1(inParam);
        iResult += daoIA5310.insertCalcJrlzTrgtAmt_2(inParam);
        iResult += daoIA5310.insertCalcJrlzTrgtAmt_3(inParam);
        //04
        iResult += daoIA5310.deletejrlzDtlProcs(inParam);
        //05
        iResult += daoIA5310.insertjrlzDtlProcs(inParam);


        IA531002OUT outParam = new IA531002OUT();
		outParam.setiResult(iResult);

		return outParam;


	}


    /**
     * @brief 리스부채사용권관리의 기초생성 정보 등록
     * @details 리스부채사용권관리의 기초생성 정보 등록
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
	 * @author : 이동겸
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

