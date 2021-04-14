/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5320.java
 * @brief KGAAP 계정코드 관리 Service
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 11. 18. | First Created
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

import com.encocns.ia.dao.IA5320DAO;

import com.encocns.ia.dto.IA532001DTO;

import com.encocns.ia.service.svo.IA532001IN;
import com.encocns.ia.service.svo.IA532001OUT;
import com.encocns.ia.service.svo.IA532002IN;
import com.encocns.ia.service.svo.IA532002OUT;
import com.encocns.ia.service.svo.IA532003OUT;

/**
 * @brief KGAAP 계정코드 관리 Service.
 * @details KGAAP 계정코드 관리 서비스입니다.
 * @author : 이미래
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
@Service
public class IA5320 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5320.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5320DAO daoIA5320;
	
    /**
     * @brief KGAAP 계정코드 내역 조회
     * @details KGAAP 계정코드 내역 조회
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532001IN
     * @return IA532001OUT
     */
	public IA532001OUT selectListKgaapAccd(IA532001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListKgaapAccd -----");

		IA532001OUT outList = new IA532001OUT();

	    List<IA532001DTO> list = null;

	    list =  daoIA5320.selectListKgaapAccd(inParam);

	    outList.setList(list);

		return outList;

	}


    /**
     * @brief KGAAP 계정코드 등록 및 수정
     * @details KGAAP 계정코드 등록 및 수정
	 * @author : 이미래
	 * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532002IN
     * @return IA532002OUT
     */
	public IA532002OUT mergeKgaapAccd(IA532002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeKgaapAccd -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("toacCd", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);
		
		//계정코드 정합성 검사
		if(inParam.getToacCd().length() > 10)  throw new EnfraBusinessException("E000036");
		int iResult  = 0 ;
        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
		if("I".equals(inParam.getJobDivCd())) {
        	try {
            	/**
            	 * 1. 계정코드를 확인한다
            	 * 2. 등록한다
            	 */
        			
        		checkValidationI(inParam);
        		iResult += daoIA5320.insertKgaapAccd(inParam);
        		
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
	        	
        	/**
        	 * 1. 계정코드를 확인한다
        	 * 2. 변경한다
        	 */
        	
        	checkValidationU(inParam);
        	iResult += daoIA5320.updateKgaapAccd(inParam);
        	
        }else {
        	// 오류 메시지 출력
        	throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }


		IA532002OUT outParam = new IA532002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief KGAAP 계정코드 삭제
     * @details KGAAP 계정코드 삭제
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532002IN
     * @return IA532003OUT
     */
	public IA532003OUT deleteKgaapAccd(IA532002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteKgaapAccd -----");

        int iResult = 0;
        
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("toacCd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        iResult += daoIA5320.deleteKgaapAccd(inParam);
        
        IA532003OUT outParam = new IA532003OUT();
        outParam.setiResult(iResult);
        
		return outParam;
	}
	
	
	/**
     * @brief CHECK 계정코드
     * @details CHECK 계정코드 
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532002IN
     * @return boolean
     */
	private boolean checkValidationI(IA532002IN inParam)throws EnfraBusinessException {
		boolean ck = false;
//		IA532001DTO ia532001dto = new IA532001DTO();
		
//		if("".equals(inParam.getIfrsAccCd())  == false ) {
//			ia532001dto = daoIA5320.selectIfrsAccd(inParam);			// IFRS계정코드 확인
//
//				if(ia532001dto.getToacCd().equals(inParam.getToacCd()))
//				{
//					ck = true;
//				}else {
//					throw new EnfraBusinessException("E000041");		// IFRS계정코드 확인 부탁
//				}
//		}
		if("".equals(inParam.getUprnToacCd())  == false ) {
			int ckUprnToaccd = daoIA5320.selectUprnToaccd(inParam); // 상위계정코드 확인
			
			if(ckUprnToaccd == 0) {
				throw new EnfraBusinessException("E000042");		// 상위계정코드 확인 부탁
			}
			else {
				 ck = true;
			}
		}
		return ck;
	}
	
	
	/**
     * @brief CHECK 계정코드
     * @details CHECK 계정코드
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532002IN
     * @return boolean
     */
	private boolean checkValidationU(IA532002IN inParam)throws EnfraBusinessException {
		boolean ck = false;
//		IA532001DTO ia532001dto = new IA532001DTO();
//		
//		
//		if("".equals(inParam.getIfrsAccCd())  == false ) {
//			ia532001dto = daoIA5320.selectIfrsAccd(inParam);// IFRS계정코드 확인
//		
//					
//					if(ia532001dto.getToacCd().equals(inParam.getToacCd()))
//					{
//						ck = true;
//					}else {
//						throw new EnfraBusinessException("E000041");		// IFRS계정코드 확인 부탁
//					}
//		}
		if("".equals(inParam.getUprnToacCd())  == false ) {
			int ckUprnToaccd = daoIA5320.selectUprnToaccd(inParam); // 상위계정코드 확인
			
			if(ckUprnToaccd == 0) {
				throw new EnfraBusinessException("E000042");		// 상위계정코드 확인 부탁
			}
			else {
				 ck = true;
			}
			
		}
		return ck;
	}

}
