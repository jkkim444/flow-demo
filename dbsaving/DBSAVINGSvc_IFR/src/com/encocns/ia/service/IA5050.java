/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5050.java
 * @brief IFRS 재무상태표 조회 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
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

import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.dao.IA5050DAO;
import com.encocns.ia.dto.IA505001DTO;
import com.encocns.ia.service.svo.IA505001IN;
import com.encocns.ia.service.svo.IA505001OUT;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief IFRS 재무상태표 내역 조회 Service
 * @details It is IFRS 재무상태표 내역 조회 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
@Service
public class IA5050 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5050.class);

	@Autowired
	private IA5050DAO daoIA5050;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief IFRS 재무상태표 조회
     * @details IFRS 재무상태표 조회 
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA505001IN
     * @return IA505001OUT
     */
	public IA505001OUT selectListIfrsfnafStaShtInq(IA505001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsfnafStaShtInq -----");

		IA505001OUT outEtcList = new IA505001OUT();


	    List<IA505001DTO> list = null;

	   	list =  daoIA5050.selectListIfrsfnafStaShtInq(inParam);

	    outEtcList.setList(list);

	   	// 마감정보 표시
	   	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchThtrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outEtcList.setClsnCtnt("미마감");
	   	}else {
	   		outEtcList.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}

		return outEtcList;

	}


}
