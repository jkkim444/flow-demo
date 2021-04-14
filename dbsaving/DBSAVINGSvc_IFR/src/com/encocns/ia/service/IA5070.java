/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5070.java
 * @brief IFRS 포괄손익계산서 조회 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
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
import com.encocns.ia.dao.IA5070DAO;
import com.encocns.ia.dto.IA507001DTO;
import com.encocns.ia.service.svo.IA507001IN;
import com.encocns.ia.service.svo.IA507001OUT;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief IFRS 포괄손익계산서 내역 조회 Service
 * @details IFRS 포괄손익계산서 내역 조회 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5070 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5070.class);


	@Autowired
	private IA5070DAO daoIA5070;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief IFRS 포괄손익계산서 내역 조회
     * @details IFRS 포괄손익계산서 내역 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA507001IN
     * @return IA507001OUT
     */
	public IA507001OUT selectListIfrsIcsPflsBllsInq(IA507001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsfnafStaShtInq -----");

		IA507001OUT outEtcList = new IA507001OUT();

	    List<IA507001DTO> list = null;

	   	list =  daoIA5070.selectListIfrsIcsPflsBllsInq(inParam);

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
