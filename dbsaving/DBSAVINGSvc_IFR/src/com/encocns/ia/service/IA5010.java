/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5010.java
 * @brief IFRS 계정코드 management Service
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
import com.encocns.ia.dao.IA5010DAO;
import com.encocns.ia.dto.IA501001DTO;
import com.encocns.ia.service.svo.IA501001IN;
import com.encocns.ia.service.svo.IA501001OUT;
import com.encocns.ia.service.svo.IA501002IN;
import com.encocns.ia.service.svo.IA501002OUT;
import com.encocns.ia.service.svo.IA501003IN;
import com.encocns.ia.service.svo.IA501003OUT;
import com.encocns.ia.service.svo.IA501004IN;
import com.encocns.ia.service.svo.IA501004OUT;

/**
 * @brief IFRS 계정코드 관리 Service.
 * @details IFRS 계정코드 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5010 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5010.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5010DAO daoIA5010;

    /**
     * @brief IFRS 계정코드 목록 조회
     * @details IFRS 계정코드 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501001IN
     * @return IA501001OUT
     */
	public IA501001OUT selectListIfrsAccd(IA501001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsAccd -----");

		IA501001OUT outIfrsList = new IA501001OUT();

	    List<IA501001DTO> list = null;

	    list =  daoIA5010.selectListIfrsAccd(inParam);

	    outIfrsList.setList(list);

		return outIfrsList;

	}


    /**
     * @brief IFRS 계정코드 등록 및 수정
     * @details IFRS 계정코드 등록 및 수정합니다.
	 * @author : 이동겸
	 * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501002IN
     * @return IA501002OUT
     */
	public IA501002OUT mergeIfrsAccd(IA501002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeIfrsAccd -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("ifrsAccCd", new RequiredRule(true));
        ruleSet.addRule("ifrsAccDcd", new RequiredRule(true));
        ruleSet.addRule("ifrsAccNm", new RequiredRule(true));
        ruleSet.addRule("bltAccYn", new RequiredRule(true));
        ruleSet.addRule("toacLvel", new RequiredRule(true));

        ruleSet.addRule("scrnIndcOrd", new RequiredRule(true));
//      ruleSet.addRule("uprIfrsAccCd", new RequiredRule(true)); LEK 제외처리(0928)
//        ruleSet.addRule("toacCd", new RequiredRule(true));   LEK 제외처리(0928)
//        ruleSet.addRule("lvelIfrsAccNm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		int iResult  = 0 ;
		//계정코드 정합성 검사
		if(inParam.getIfrsAccCd().length() < 10)  throw new EnfraBusinessException("E000036");



        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */

        if("I".equals(inParam.getJobDivCd())) {
    		/**
    		 * 1. 계정코드 존재 여부 확인
    		 *
    		 */
    		/* 계정코드 존재여부 */
    		iResult = daoIA5010.selectIfrsAccd(inParam);

    		/* 계정코드가 존재 하는  */
    		if(iResult != 0 ) {
    			iResult = daoIA5010.updateIfrsAccdEnd(inParam);
    		}
    		/* 계정코드가 존재 하지 않는 신규 건 등록 */
    		else {

    			//원래 있던 화면표시번호를 +1씩 증가
    			daoIA5010.updateScrnIndcOrd(inParam);

    		}
        	// 등록 처리
        	try {
            	// 등록 처리
        		iResult = daoIA5010.insertIfrsAccd(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}


        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
        	iResult = daoIA5010.updateIfrsAccd(inParam);

        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }
//
//        if("I".equals(stJobDivCd)) {
//        	try {
//            	// 등록 처리
//        		iResult = daoIA5010.insertIfrsAccd(inParam);
//        	}
//        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
//        		// 중복 코드 에러 메시지 출력
//                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
//			}
//        }else if("U".equals(stJobDivCd)) {
//    		//업데이트 처리
//        	iResult = daoIA5010.updateIfrsAccd(inParam);
//
//        	try {
//            	// 업데이트 후 등록 처리
//        		iResult += daoIA5010.insertIfrsAccd(inParam);
//        	}
//        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
//        		// APLC_STRT_DT가 오늘날짜일 경우 오류
//                throw new EnfraBusinessException("E000027"); // 한 번 밖에 수정 할 수 없습니다.
//			}
//        }else {
//        	// 오류 메시지 출력
//            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
//        }

		IA501002OUT outIfrs = new IA501002OUT();
		outIfrs.setiResult(iResult);

		return outIfrs;
	}

    /**
     * @brief IFRS 계정코드 정보 삭제
     * @details IFRS 계정코드 정보 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501003IN
     * @return IA501003OUT
     */
	public IA501003OUT deleteIfrsAccd(IA501003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIfrsAccd -----");

        // Parameter validation
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("ifrsAccCd", new RequiredRule(true));
        ruleSet.addRule("aplcStrtDt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);
        int iResult = 0 ;
        int iResult2 = 0;
		int iResult3 = 0;

		iResult2 = daoIA5010.selectAplcEndDt(inParam);			  /* 삭제하려는 항목의 종료일자가 9999-12-31인지 확인 */

		iResult +=  daoIA5010.deleteIfrsAccd(inParam);            /* 삭제처리 */

		iResult3 += daoIA5010.delUpdateIfrsAccd(inParam);         /* 최종계정과목코드 변경처리 */

    	//종료일자가 9999-12-31인 경우에만
		if(iResult2 != 0 && iResult3 == 0){
			iResult +=  daoIA5010.deleteScrnIndcOrd(inParam);            /* 화면표시순서 -1 */
		}


		IA501003OUT outIfrs = new IA501003OUT();
		outIfrs.setiResult(iResult);   /* 삭제처리 */


		return outIfrs;
	}

    /**
     * @brief IFRS 계정코드 생성 
     * @details IFRS 계정코드 엑셀 업로드
	 * @author : 이동겸
	 * @date : 2020. 11. 04.
     * @version : 1.0.0
     * @param IA501004IN
     * @return IA501004OUT
     */
	public IA501004OUT insertIfrsAccdExcl(IA501004IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsAccdExcl -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("arrGridData", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;

        /* 엑셀 업로드로 여러건 받아서 loop 돌려서 처리한다. */

		for(IA501001DTO iA501001DTO : inParam.getArrGridData()) {

	    	IA501002IN iA501002IN = new IA501002IN();

            /**
             * 1.기준년월 계좌번호 부서 팀, 취득일자가 동일한 경우 중복 등록 오류 처리(todo)
             * */
        	iA501002IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        	iA501002IN.setIfrsAccCd(iA501001DTO.getIfrsAccCd());

            /* 업로드 이전 데이터 (현재일자-1)일로 업데이트처리 */
            iResult += daoIA5010.updateIfrsAccdEnd(iA501002IN);


        	iA501002IN.setIfrsAccDcd(iA501001DTO.getIfrsAccDcd());
        	iA501002IN.setIfrsAccNm(iA501001DTO.getIfrsAccNm());
        	iA501002IN.setBltAccYn(iA501001DTO.getBltAccYn());
        	iA501002IN.setToacLvel(iA501001DTO.getToacLvel());
        	iA501002IN.setUprIfrsAccCd(iA501001DTO.getUprIfrsAccCd());
        	iA501002IN.setScrnIndcOrd(iA501001DTO.getScrnIndcOrd());
        	iA501002IN.setToacCd(iA501001DTO.getToacCd());


        	iResult += daoIA5010.insertIfrsAccdExcl(iA501002IN);
		}

		IA501004OUT outParam = new IA501004OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

}
