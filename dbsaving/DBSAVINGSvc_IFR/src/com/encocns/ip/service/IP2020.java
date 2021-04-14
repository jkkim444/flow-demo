/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2020.java
 * @brief LGD 관리 Service
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
import com.encocns.ip.dao.IP2020DAO;
import com.encocns.ip.dto.IP202001DTO;
import com.encocns.ip.dto.IP202002DTO;
import com.encocns.ip.service.svo.IP202001IN;
import com.encocns.ip.service.svo.IP202001OUT;
import com.encocns.ip.service.svo.IP202002IN;
import com.encocns.ip.service.svo.IP202002OUT;
import com.encocns.ip.service.svo.IP202003IN;
import com.encocns.ip.service.svo.IP202003OUT;

/**
 * @brief LGD 관리 Service
 * @details LGD 관리 서비스 입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2020 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2020.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2020DAO daoIP2020;

    /**
     * @brief LGD 목록 조회
     * @details LGD 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP202001IN
     * @return IP202001OUT
     */
	public IP202001OUT selectListRcLgdRflc(IP202001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRcLgdRflc -----");

		IP202001OUT outParamList = new IP202001OUT();

	    int totalCount = daoIP2020.selectTotalCount(inParam);

	    List<IP202001DTO> list = null;

	    if( inParam.getSelectPage()==-1 ) {
	    	list =  daoIP2020.selectListRcLgdRflc(inParam);
	    }
	    else {
	    	list =  daoIP2020.selectPaging(inParam);
	    }

	    outParamList.setCurrentPageNo(inParam.getSelectPage());
	    outParamList.setTotalCount(totalCount);
	    outParamList.setList(list);
		return outParamList;

	}

    /**
     * @brief LGD 등록 및 수정
     * @details LGD 등록 및 수정합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP202002IN
     * @return IP202002OUT
     */
	public IP202002OUT mergeRcLgdRflc(IP202002IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRcLgdRflc -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

 		int iResult = 0;

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        	 	iResult = daoIP2020.insertRcLgdRflc(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
	    		//업데이트 처리
        	iResult = daoIP2020.updateRcLgdRflc(inParam);
	    }else {
	    	// 오류 메시지 출력
	        throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
	    }
		IP202002OUT outParam = new IP202002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief LGD 정보 삭제
     * @details LGD 정보 삭제합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP202003IN
     * @return IP202003OUT
     */
	public IP202003OUT deleteRcLgdRflc(IP202003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcLgdRflc -----");

		IP202003OUT outParam = new IP202003OUT();
		outParam.setiResult(daoIP2020.deleteRcLgdRflc(inParam));

		return outParam;
	}

    /**
     * @brief LGD 정보 엑셀업로드
     * @details LGD 정보 엑셀업로드합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP202002IN
     * @return IP202002OUT
     */
	public IP202002OUT insertRcLgdRflcExcl(IP202002IN inParam)throws EnfraBusinessException {
     if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRcPdRflc -----");

     inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

     // Parameter validation
     RuleSet ruleSet = new RuleSet();
     ruleSet.addRule("arrGridData", new RequiredRule(true));

     Validator.validation(inParam, ruleSet);

     /*loop 반영 */

     int iResult = 0 ;

     iResult = daoIP2020.deleteRcLgdRflcExcl(inParam.getArrGridData().get(0));

     for(IP202001DTO iP202001DTO : inParam.getArrGridData()){

	     IP202002DTO iP202002DTO = new IP202002DTO();                          /* 코드 오류 검출을 하기위해 객체생성*/
	     iP202002DTO.setLgdSgmtCd(iP202001DTO.getLgdSgmtCd());

	     iP202002DTO = daoIP2020.selectListRcLgdRflcErr(iP202002DTO);

	     if(iP202002DTO == null) {
	       throw new EnfraBusinessException("E000030");                     /* 코드 미존재 오류검출 */
	     }

	     IP202002IN iP202002IN = new IP202002IN();
         /**
          * 1.신용등급코드가 공통코드상세에 존재 하지 않으면 오류 처리 하세요.
          * */
    	 iP202002IN.setUsrId(serviceComponent.getSessionVO().getUserId());
    	 iP202002IN.setStdrYm(iP202001DTO.getStdrYm());
    	 iP202002IN.setLgdSgmtCd(iP202001DTO.getLgdSgmtCd());
    	 iP202002IN.setImprPntmLoanBal(iP202001DTO.getImprPntmLoanBal());
    	 iP202002IN.setRate(iP202001DTO.getRate());
    	 iP202002IN.setLgdRate(iP202001DTO.getLgdRate());

     	 iResult += daoIP2020.insertRcLgdRflcExcl(iP202002IN);

     }

        IP202002OUT outEtc = new IP202002OUT();
		outEtc.setiResult(iResult);
		return outEtc;
	}

}

