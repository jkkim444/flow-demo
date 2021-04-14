/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5100.java
 * @brief IFRS분개전표 관리 Service
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
import com.encocns.ia.dao.IA5100DAO;
import com.encocns.ia.dto.IA510001DTO;
import com.encocns.ia.service.svo.IA510001IN;
import com.encocns.ia.service.svo.IA510001OUT;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief IFRS분개전표 관리 Service
 * @details IFRS분개전표 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5100 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5100.class);


	@Autowired
	private IA5100DAO daoIA5100;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief IFRS분개전표 조회
     * @details IFRS분개전표 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA510001IN
     * @return IA510001OUT
     */
	public IA510001OUT selectListIfrsConvJrlz(IA510001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsConvJrlz -----");

		IA510001OUT outIfrsList = new IA510001OUT();

	    List<IA510001DTO> list = null;


	    list =  daoIA5100.selectListIfrsConvJrlz(inParam);

	    System.out.println(daoIA5100.selectListIfrsConvJrlz(inParam));
	    System.out.println("gogo");
	    System.out.println(list);

	    outIfrsList.setCurrentPageNo(inParam.getSelectPage());
	    outIfrsList.setList(list);

	   	// 마감 미마감 표시
	   	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outIfrsList.setClsnCtnt("미마감");
	   	}else {
	   		outIfrsList.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}

		return outIfrsList;

	}



}
