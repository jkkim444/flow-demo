/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2070.java
 * @brief 예치금대손충당금 관리 Service
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
import com.encocns.ip.dao.IP2070DAO;
import com.encocns.ip.dto.IP207001DTO;
import com.encocns.ip.service.svo.IP207001IN;
import com.encocns.ip.service.svo.IP207001OUT;
import com.encocns.ip.service.svo.IP207002IN;
import com.encocns.ip.service.svo.IP207002OUT;
import com.encocns.ip.service.svo.IP207003IN;
import com.encocns.ip.service.svo.IP207003OUT;
import com.encocns.ip.service.svo.IP207004IN;
import com.encocns.ip.service.svo.IP207004OUT;

/**
 * @brief 예치금대손충당금 관리
 * @details It is 예치금대손충당금 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2070 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2070.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2070DAO daoIP2070;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 예치금대손충당금 목록 조회
     * @details 예치금대손충당금 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207001IN
     * @return IP207001OUT
     */
	public IP207001OUT selectListDsmnTrgt(IP207001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListDsmnTrgt -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IP207001OUT outParamList = new IP207001OUT();

	    int totalCount = daoIP2070.selectTotalCount(inParam);

	    List<IP207001DTO> list = null;

	    // 페이징 없는 조회
	    if( inParam.getSelectPage()==-1 ) {
	    	list =  daoIP2070.selectListDsmnTrgt(inParam);
	    }
	    // 페이징 있는 조회
	    else {
	    	list =  daoIP2070.selectPaging(inParam);
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
     * @brief 예치금대손충당금 정보 수정 및 저장
     * @details 예치금대손충당금 정보를 수정 및 저장합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207002IN
     * @return IP207002OUT
     */
	public IP207002OUT mergeDsmnTrgt(IP207002IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeDsmnTrgt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("instCd", new RequiredRule(true));
        ruleSet.addRule("crgdCd", new RequiredRule(true));
        ruleSet.addRule("loanBal", new RequiredRule(true));
        ruleSet.addRule("ucin", new RequiredRule(true));

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
        		iResult = daoIP2070.insertDsmnTrgt(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
        	iResult = daoIP2070.updateDsmnTrgt(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IP207002OUT outParam = new IP207002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 예치금대손충당금 정보 삭제
     * @details 예치금대손충당금 정보를 삭제합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207003IN
     * @return IP207003OUT
     */
	public IP207003OUT deleteDsmnTrgt(IP207003IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteDsmnTrgt -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("instCd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

		IP207003OUT outParam = new IP207003OUT();
		outParam.setiResult(daoIP2070.deleteDsmnTrgt(inParam));

		return outParam;
	}

    /**
     * @brief 분개 대상 검증 데이터 생성
     * @details 분개 대상 검증 데이터를 생성합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207004IN
     * @return IP207004OUT
     */
	public IP207004OUT calcJrlzTrgtAmt(IP207004IN inParam) throws EnfraBusinessException
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
         *
         * 01. 충당금 산출
         *
         * */

        //01
        iResult += daoIP2070.updateDsmnTrgtClcl(inParam);

        IP207004OUT outParam = new IP207004OUT();
		outParam.setiResult(iResult);

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

