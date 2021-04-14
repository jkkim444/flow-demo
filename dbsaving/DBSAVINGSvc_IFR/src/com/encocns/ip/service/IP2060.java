/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2060.java
 * @brief 당기제각회수정보 관리 Service
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
import com.encocns.ip.dao.IP2060DAO;
import com.encocns.ip.dto.IP206001DTO;
import com.encocns.ip.dto.IP206002DTO;
import com.encocns.ip.service.svo.IP206001IN;
import com.encocns.ip.service.svo.IP206001OUT;
import com.encocns.ip.service.svo.IP206002IN;
import com.encocns.ip.service.svo.IP206002OUT;
import com.encocns.ip.service.svo.IP206003IN;
import com.encocns.ip.service.svo.IP206003OUT;

/**
 * @brief 당기제각회수정보 관리
 * @details 당기제각회수정보 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2060 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2060.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2060DAO daoIP2060;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 당기제각회수 목록 조회
     * @details 당기제각회수 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP206001IN
     * @return IP206001OUT
     */
	public IP206001OUT selectListDprnRtrv(IP206001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListDprnRtrv -----");

		// Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        ruleSet.addRule("searchStdrYmEnd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IP206001OUT outParam = new IP206001OUT();

	    List<IP206001DTO> list = null;

    	list =  daoIP2060.selectListDprnRtrv(inParam);

    	outParam.setCurrentPageNo(inParam.getSelectPage());
	    outParam.setList(list);

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
     * @brief 당기제각회수 정보 수정 및 등록
     * @details 당기제각회수 정보를 수정 및 등록합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP206002IN
     * @return IP206002OUT
     */
	public IP206002OUT mergeDprnRtrv(IP206002IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeDprnRtrv -----");

        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("frtrYm", new RequiredRule(true));
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("dprnAmt", new RequiredRule(true));
        ruleSet.addRule("rtrvAmt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


        IP206002DTO  inIP206002DTO  = new IP206002DTO();

        inIP206002DTO.setFrtrYm(inParam.getFrtrYm());  /** 전기년월 **/
        inIP206002DTO.setStdrYm(inParam.getStdrYm());  /** 당기년월 **/
        inIP206002DTO.setDprnAmt(inParam.getDprnAmt()); /** 제각금액 **/
        inIP206002DTO.setRtrvAmt(inParam.getRtrvAmt()); /** 회수금액 **/
        inIP206002DTO.setUsrId(serviceComponent.getSessionVO().getUserId()); /* 사용자 */

        int iResult = 0 ;
        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */

        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIP2060.insertDprnRtrv(inIP206002DTO);

        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
        	iResult = daoIP2060.updateDprnRtrv(inIP206002DTO);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

        IP206002OUT outParam = new IP206002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 당기제각회수 정보 삭제
     * @details 당기제각회수 정보를 삭제합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP206003IN
     * @return IP206003OUT
     */
	public IP206003OUT deleteDprnRtrv(IP206003IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteDprnRtrv -----");

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


		IP206003OUT outParam = new IP206003OUT();
		outParam.setiResult(daoIP2060.deleteDprnRtrv(inParam));

		return outParam;
	}
    /**
     * @brief 마감여부  검증
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

