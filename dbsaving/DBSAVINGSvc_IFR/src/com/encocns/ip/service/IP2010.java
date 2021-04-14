/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2010.java
 * @brief F/L반영 PD관리 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
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
import com.encocns.ip.dao.IP2010DAO;
import com.encocns.ip.dto.IP201001DTO;
import com.encocns.ip.dto.IP201002DTO;
import com.encocns.ip.service.svo.IP201001IN;
import com.encocns.ip.service.svo.IP201001OUT;
import com.encocns.ip.service.svo.IP201002IN;
import com.encocns.ip.service.svo.IP201002OUT;
import com.encocns.ip.service.svo.IP201003IN;
import com.encocns.ip.service.svo.IP201003OUT;
import com.encocns.ip.service.svo.IP201004IN;
import com.encocns.ip.service.svo.IP201004OUT;

/**
 * @brief F/L반영 PD관리 Service
 * @details It is F/L반영 PD관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
@Service
public class IP2010 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2010.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2010DAO daoIP2010;

    /**
     * @brief F/L반영 PD 목록 조회
     * @details The F/L반영 PD 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201001IN
     * @return IP201001OUT
     */
	public IP201001OUT selectListRcPdRflc(IP201001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRcPdRflc -----");

		IP201001OUT outParamList = new IP201001OUT();

	    int totalCount = daoIP2010.selectTotalCount(inParam);

	    List<IP201001DTO> list = null;

	    if( inParam.getSelectPage()==-1 ) {
	    	list =  daoIP2010.selectListRcPdRflc(inParam);
	    }
	    else {
	    	list =  daoIP2010.selectPaging(inParam);
	    }

	    outParamList.setCurrentPageNo(inParam.getSelectPage());
	    outParamList.setTotalCount(totalCount);
	    outParamList.setList(list);
		return outParamList;

	}


    /**
     * @brief F/L반영 PD 등록 및 수정
     * @details F/L반영 PD 등록 및 수정합니다.
	 * @author : 이동겸
	 * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201002IN
     * @return IP201002OUT
     */
	public IP201002OUT mergeRcPdRflc(IP201002IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRcPdRflc -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("pdSgmtCd", new RequiredRule(true));
        ruleSet.addRule("nth", new RequiredRule(true));
        ruleSet.addRule("pdRate1", new RequiredRule(true));
        ruleSet.addRule("pdRate2", new RequiredRule(true));
        ruleSet.addRule("pdRate3", new RequiredRule(true));
        ruleSet.addRule("pdRate4", new RequiredRule(true));
        ruleSet.addRule("pdRate5", new RequiredRule(true));
        ruleSet.addRule("jobDivCd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

 		int iResult = 0;

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         **/
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIP2010.insertRcPdRflc(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
        		iResult = daoIP2010.updateRcPdRflc(inParam);
        }else {
        	// 오류 메시지 출력
        	throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IP201002OUT outParam = new IP201002OUT();
		outParam.setiResult(iResult);
		return outParam;
	}

    /**
     * @brief F/L반영 PD 삭제
     * @details F/L반영 PD 삭제 처리합니다.
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201003IN
     * @return IP201003OUT
     */
	public IP201003OUT deleteRcPdRflc(IP201003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcPdRflc -----");

		IP201003OUT outParam = new IP201003OUT();
		outParam.setiResult(daoIP2010.deleteRcPdRflc(inParam));

		return outParam;
	}

	/**
     * @brief F/L반영 PD 엑셀 업로드
     * @details F/L반영 PD 엑셀 업로드합니다.
	 * @author : 이동겸
	 * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201004IN
     * @return IP201004OUT
     */
	public IP201004OUT insertRcPdRflcExcl(IP201004IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcPdRflcExcl -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("arrGridData", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        /*loop 반영 */

        int iResult = 0 ;

        iResult = daoIP2010.deleteRcPdRflcStdrYm(inParam.getArrGridData().get(0));

        for(IP201001DTO iP201001DTO : inParam.getArrGridData()){

        	IP201002IN iP201002IN = new IP201002IN();

        	IP201002DTO iP201002DTO = new IP201002DTO();                          /* 코드 오류 검출을 하기위해 객체생성*/
        	iP201002DTO.setPdSgmtCd(iP201001DTO.getPdSgmtCd());

        	iP201002DTO = daoIP2010.selectListRcPdRflcErr(iP201002DTO);

	       	if(iP201002DTO == null) {
	       		 throw new EnfraBusinessException("E000030");                     /* 코드 미존재 오류검출 */
	       	}

            /**
             * 1.기준년월 계좌번호 부서 팀, 취득일자가 동일한 경우 중복 등록 오류 처리(todo)
             **/
        	iP201002IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        	iP201002IN.setStdrYm(iP201001DTO.getStdrYm());
        	iP201002IN.setPdSgmtCd(iP201001DTO.getPdSgmtCd());
        	iP201002IN.setNth(iP201001DTO.getNth());
        	iP201002IN.setPdSgmtCdNth(iP201001DTO.getPdSgmtCdNth());
        	iP201002IN.setPdRate1(iP201001DTO.getPdRate1());
        	iP201002IN.setPdRate2(iP201001DTO.getPdRate2());
        	iP201002IN.setPdRate3(iP201001DTO.getPdRate3());
        	iP201002IN.setPdRate4(iP201001DTO.getPdRate4());
        	iP201002IN.setPdRate5(iP201001DTO.getPdRate5());

        	iResult += daoIP2010.insertRcPdRflcExcl(iP201002IN);

        }

        IP201004OUT outEtc = new IP201004OUT();
		outEtc.setiResult(iResult);
		return outEtc;
	}
}

