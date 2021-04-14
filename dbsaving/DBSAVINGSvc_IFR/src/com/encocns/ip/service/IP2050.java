/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2050.java
 * @brief 기타충당금 관리 Service
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

import com.encocns.ip.dao.IP2050DAO;
import com.encocns.ip.dto.IP205001DTO;
import com.encocns.ip.service.svo.IP205001IN;
import com.encocns.ip.service.svo.IP205001OUT;
import com.encocns.ip.service.svo.IP205002IN;
import com.encocns.ip.service.svo.IP205002OUT;
import com.encocns.ip.service.svo.IP205003IN;
import com.encocns.ip.service.svo.IP205003OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.service.IA9000;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 기타충당금 관리 Service
 * @details 기타충당금 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2050 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2050.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2050DAO daoIP2050;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 기타충당금 목록 조회
     * @details 기타충당금 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP205001IN
     * @return IP205001OUT
     */
	public IP205001OUT selectListEtcRsrv(IP205001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListEtcRsrv -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        ruleSet.addRule("searchStdrYmEnd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IP205001OUT outParamList = new IP205001OUT();

	    int totalCount = daoIP2050.selectTotalCount(inParam);

	    List<IP205001DTO> list = null;
	    // 페이징 없는 조회
	    if( inParam.getSelectPage()==-1 ) {
	    	list =  daoIP2050.selectListEtcRsrv(inParam);
	    }
	    // 페이징 있는 조회
	    else {
	    	list =  daoIP2050.selectPaging(inParam);
	    }

	    outParamList.setCurrentPageNo(inParam.getSelectPage());
	    outParamList.setTotalCount(totalCount);
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
     * @brief 기타충당금 정보 수정 및 등록
     * @details 기타충당금 정보를 수정 및 등록합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP205002IN
     * @return IP205002OUT
     */
	public IP205002OUT mergeEtcRsrv(IP205002IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeEtcRsrv -----");
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("etcLoanRsrv", new RequiredRule(true));
        ruleSet.addRule("unuseLimtAmt", new RequiredRule(true));
        ruleSet.addRule("ccfVal", new RequiredRule(true));
        ruleSet.addRule("etcRsrv", new RequiredRule(true));
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
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIP2050.insertEtcRsrv(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
    		iResult = daoIP2050.updateEtcRsrv(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IP205002OUT outParam = new IP205002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 기타충당금 정보 삭제
     * @details 기타충당금 정보를 삭제합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP205003IN
     * @return IP205003OUT
     */
	public IP205003OUT deleteEtcRsrv(IP205003IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEtcRsrv -----");
        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

		IP205003OUT outParam = new IP205003OUT();
		outParam.setiResult(daoIP2050.deleteEtcRsrv(inParam));

		return outParam;
	}

    /**
     * @brief 마감여부 검증
     * @details 마감여부를 검증합니다.
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
