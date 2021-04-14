/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5301.java
 * @brief IFRS 수정분개 관리_팝업 management Service
 * @section Major History
 * <pre>
 *   - LEE, DONG-KYEUM | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service
 * @brief Common Service Package
 */
package com.encocns.ia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.dao.IA5301DAO;
import com.encocns.ia.dto.IA530101DTO;
import com.encocns.ia.dto.IA530102DTO;
import com.encocns.ia.service.svo.IA530101IN;
import com.encocns.ia.service.svo.IA530101OUT;
import com.encocns.ia.service.svo.IA530102IN;
import com.encocns.ia.service.svo.IA530102OUT;

/**
 * @brief 수정분개 관리_팝업 Service
 * @details IFRS 수정분개 관리_팝업 서비스입니다.
 * @author : 이미래
 * @date : 2020.10. 26.
 *
 * @version : 1.0.0
 */
@Service
public class IA5301 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5301.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5301DAO daoIA5301;

    /**
     * @brief IFRS 수정분개 관리_팝업 조회
     * @details The IFRS 수정분개 관리_팝업 조회
	 * @author : 이미래
	 * @date : 2020.10. 15.
	 * @version : 1.0.0
     * @param IA530101IN
     * @return IA530101OUT
     */
	public IA530101OUT selectAmndJrlzHistPopUp(IA530101IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsAccd -----");


        IA530101OUT outParam  = new IA530101OUT();

        IA530102DTO outIA530102DTO = daoIA5301.selectAmndJrlzHistPopUp(inParam);


	    outParam.setList(outIA530102DTO);

		return outParam;

	}


    /**
     * @brief IFRS 수정분개관리 등록 및 수정
     * @details IFRS 수정분개관리 등록 및 수정
	 * @author : 이미래
	 * @date : 2020.10. 26.
	 * @version : 1.0.0
	 * @param IA530102IN
     * @return IA530102OUT
     */
	public IA530102OUT insertAmndJrlzHistPopUp(IA530102IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeIfrsAccd -----");



        int iResult = 0;

        IA530101DTO inIA530101DTO   = new IA530101DTO();


        inIA530101DTO.setJlzYm(inParam.getJlzYm());                     /*JLZ_YM               분개년월             */
        inIA530101DTO.setJrlzBzwkCd("S13");                             /*JRLZ_BZWK_CD         분개업무코드         */
        inIA530101DTO.setJrlzBzwkDtlCd("S1311");                        /*JRLZ_BZWK_CD         분개업무코드         */
        inIA530101DTO.setOrjrlzBzwkCd(inParam.getOrjrlzBzwkCd());       /*ORJRLZ_BZWK_CD       원분개업무코드       */
        inIA530101DTO.setOrjrlzBzwkDtlCd(inParam.getOrjrlzBzwkDtlCd()); /*ORJRLZ_BZWK_DTL_CD   원분개업무상세코드   */
        inIA530101DTO.setOrSeqno(inParam.getOrSeqno());                 /*ORSEQNO              원분개일련번호       */
        inIA530101DTO.setDbIfrsAccCd(inParam.getDbIfrsAccCd());         /*DB_IFRS_ACC_CD       차변IFRS계정코드     */
        inIA530101DTO.setCrIfrsAccCd(inParam.getCrIfrsAccCd());         /*CR_IFRS_ACC_CD       대변IFRS계정코드     */
        inIA530101DTO.setDbAccAmt(inParam.getDbAccAmt());                /*DB_ACC_AMT           차변계정금액         */
        inIA530101DTO.setCrAccAmt(inParam.getCrAccAmt());                /*CR_ACC_AMT           대변계정금액         */
        inIA530101DTO.setAmndJrlzRsnCtnt(inParam.getAmndJrlzRsnCtnt());           /*AMND_JRLZ_RSN_CTNT   수정분개사유내용     */
        inIA530101DTO.setCnsgFundYn(inParam.getCnsgFundYn());
        inIA530101DTO.setUsrId(serviceComponent.getSessionVO().getUserId());

    	try {
        	// 등록 처리
    		iResult = daoIA5301.insertAmndJrlzHistPopUp(inIA530101DTO);
    	}
    	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}

		IA530102OUT outParam = new IA530102OUT();
		outParam.setiResult(iResult);

		return outParam;
	}



}
