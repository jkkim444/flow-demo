/*

 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2030.java
 * @brief NICE PD관리 Service
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
import com.encocns.ip.dao.IP2030DAO;
import com.encocns.ip.dto.IP203001DTO;
import com.encocns.ip.dto.IP203002DTO;
import com.encocns.ip.service.svo.IP203001IN;
import com.encocns.ip.service.svo.IP203001OUT;
import com.encocns.ip.service.svo.IP203002IN;
import com.encocns.ip.service.svo.IP203002OUT;
import com.encocns.ip.service.svo.IP203003IN;
import com.encocns.ip.service.svo.IP203003OUT;
import com.encocns.ip.service.svo.IP203004IN;
import com.encocns.ip.service.svo.IP203004OUT;
/**
 * @brief NICE PD관리 Service
 * @details NICE PD관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
@Service
public class IP2030 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2030.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2030DAO daoIP2030;

    /**
     * @brief NICE PD 목록 조회
     * @details NICE PD 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP203001IN
     * @return IP203001OUT
     */
	public IP203001OUT selectListRcNicePdRflc(IP203001IN inParam) throws EnfraBusinessException, Exception
	{

		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRcNicePdRflc -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);
		IP203001OUT outParamList = new IP203001OUT();

	    int totalCount = daoIP2030.selectTotalCount(inParam);

	    List<IP203001DTO> list = null;

	    // 페이징 없는 조회
	    if( inParam.getSelectPage()==-1 ) {
	    	list =  daoIP2030.selectListRcNicePdRflc(inParam);
	    }
	    // 페이징 있는 조회
	    else {
	    	list =  daoIP2030.selectPaging(inParam);
	    }

	    outParamList.setCurrentPageNo(inParam.getSelectPage());
	    outParamList.setTotalCount(totalCount);
	    outParamList.setList(list);
		return outParamList;

	}

    /**
     * @brief NICE PD 등록 및 수정
     * @details NICE PD 등록 및 수정합니다.
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP203002IN
     * @return IP203002OUT
     */
	public IP203002OUT mergeRcNicePdRflc(IP203002IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRcNicePdRflc -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("crgdCd", new RequiredRule(true));
        ruleSet.addRule("pdRate1", new RequiredRule(true));
        ruleSet.addRule("pdRate2", new RequiredRule(true));
        ruleSet.addRule("pdRate3", new RequiredRule(true));
        ruleSet.addRule("pdRate4", new RequiredRule(true));
        ruleSet.addRule("pdRate5", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        int iResult = 0;
        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIP2030.insertRcNicePdRflc(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
        		//업데이트 처리
        	iResult = daoIP2030.updateRcNicePdRflc(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IP203002OUT outParam = new IP203002OUT();
		outParam.setiResult(iResult);
		return outParam;
	}

    /**
     * @brief NICE PD 정보 삭제
     * @details NICE PD 정보를 삭제합니다.
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP203003IN
     * @return IP203003OUT
     */
	public IP203003OUT deleteRcNicePdRflc(IP203003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcNicePdRflc -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("crgdCd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IP203003OUT outParam = new IP203003OUT();
		outParam.setiResult(daoIP2030.deleteRcNicePdRflc(inParam));

		return outParam;
	}

    /**
     * @brief NICE PD 정보 엑셀업로드
     * @details NICE PD 정보를 엑셀업로드합니다.
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP203004IN
     * @return IP203004OUT
     */
	public IP203004OUT insertRcNicePdRflcExcl(IP203004IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRcNicePdRflc -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("arrGridData", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        /*loop 반영 */

        int iResult = 0 ;

        iResult = daoIP2030.deleteRcNicePdRflcStdrYm(inParam.getArrGridData().get(0));

        for(IP203001DTO iP203001DTO : inParam.getArrGridData()){

        	IP203002IN iP203002IN = new IP203002IN();

        	IP203002DTO iP203002DTO = new IP203002DTO();                          /* 코드 오류 검출을 하기위해 객체생성*/
        	iP203002DTO.setCrgdCd(iP203001DTO.getCrgdCd());

        	iP203002DTO = daoIP2030.selectListRcLgdRflcErr(iP203002DTO);

	       	if(iP203002DTO == null) {
	       		 throw new EnfraBusinessException("E000030");                     /* 코드 미존재 오류검출 */
	       	}

            /**
             * 1.기준년월 계좌번호 부서 팀, 취득일자가 동일한 경우 중복 등록 오류 처리(todo)
             * */
        	iP203002IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        	iP203002IN.setStdrYm(iP203001DTO.getStdrYm());
        	iP203002IN.setCrgdCd(iP203001DTO.getCrgdCd());
        	iP203002IN.setPdRate1(iP203001DTO.getPdRate1());
        	iP203002IN.setPdRate2(iP203001DTO.getPdRate2());
        	iP203002IN.setPdRate3(iP203001DTO.getPdRate3());
        	iP203002IN.setPdRate4(iP203001DTO.getPdRate4());
        	iP203002IN.setPdRate5(iP203001DTO.getPdRate5());

        	iResult += daoIP2030.insertRcNicePdRflcExcl(iP203002IN);

        }

        IP203004OUT outEtc = new IP203004OUT();
		outEtc.setiResult(iResult);
		return outEtc;
	}
}

