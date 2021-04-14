/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5180.java
 * @brief 기초이월분개처리 Service
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 9. 29. | First Created
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
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.dao.IA5180DAO;
import com.encocns.ia.dto.IA518001DTO;
import com.encocns.ia.service.svo.IA518001IN;
import com.encocns.ia.service.svo.IA518001OUT;
import com.encocns.ia.service.svo.IA518002OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 기초이월분개처리 관리 Service
 * @details 기초이월분개처리 관리 서비스입니다.
 * @author : 이미래
 * @date : 2020. 9. 28.
 * @version : 1.0.0
 */
@Service
public class IA5180 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5180.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5180DAO daoIA5180;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 기초이월분개처리 조회
     * @details 기초이월분개처리 조회
     * @author : 이미래
     * @date : 2020. 9. 28.
     * @version : 1.0.0
     * @param IA518001IN
     * @return IA518001OUT
     */
	public IA518001OUT selectListBassCrfrJrlz(IA518001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBassCrfrJrlz -----");

		IA518001OUT outParam = new IA518001OUT();

	    List<IA518001DTO> list = null;

	    /* 기초이월분개정보를 조회하여 List로 출력 */
	    list =  daoIA5180.selectListBassCrfrJrlz(inParam);

	    outParam.setList(list);

	    /* 마감 여부 확인 */
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
     * @brief 기초이월분개처리 저장
     * @details 기초이월분개처리 저장
     * @author : 이미래
     * @date : 2020. 9. 29.
     * @version : 1.0.0
     * @param IA518001IN
     * @return IA518002OUT
     */
	public IA518002OUT mergeBassCrfrJrlz(IA518001IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeBassCrfrJrlz -----");


        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getSearchStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


        int iResult  = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
		 * 1.   기초이월분개처리 삭제
		 * 2.   기초이월분개처리 생성
		 * 3.   산출한 값을 DB에 저장한다.
		 */
        iResult += daoIA5180.deleteBassCrfrJrlz(inParam);
        iResult += daoIA5180.insertBassCrfrJrlz(inParam);

		IA518002OUT outParam = new IA518002OUT();
		outParam.setiResult(iResult);

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



}
