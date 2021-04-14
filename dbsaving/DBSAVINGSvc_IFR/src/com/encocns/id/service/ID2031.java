/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID2031.java
 * @brief 공시보고서검증 상세 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.service
 * @brief ID Service Package
 */
package com.encocns.id.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.id.dao.ID2031DAO;
import com.encocns.id.service.svo.ID203101IN;
import com.encocns.id.service.svo.ID203101OUT;


/**
 * @brief 공시보고서검증 상세 Service
 * @details 공시보고서검증 상세 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID2031 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID2031.class);

	@Autowired
	private ID2031DAO daoID2031;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 공시보고서 양식 조회
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID203101IN
     * @return ID203101OUT
     */
	public ID203101OUT selectHeader(ID203101IN inParam) throws EnfraBusinessException{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");

		ID203101OUT outParam = new ID203101OUT();

		// 보고서 양식 조회
		outParam.setArrList(daoID2031.selectHeader(inParam));
		// 보고서 머지 조회
		outParam.setArrListMerge(daoID2031.selectMergeCell(inParam));

		if(outParam.getArrList().size() == 0) {
			throw new EnfraBusinessException("E000061");
		}
		return outParam;
	}

}
