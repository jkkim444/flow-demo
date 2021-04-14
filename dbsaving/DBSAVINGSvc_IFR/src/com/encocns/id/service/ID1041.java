/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1041.java
 * @brief 산출 및 검증 대상 조회 Service
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
import com.encocns.id.dao.ID1041DAO;
import com.encocns.id.service.svo.ID104101IN;
import com.encocns.id.service.svo.ID104101OUT;

/**
 * @brief 산출 및 검증 대상 조회 Service
 * @details 산출 및 검증 대상 조회 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID1041 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1041.class);

	@Autowired
	private ID1041DAO daoID1041;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 공시보고서 양식 조회
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104101IN
     * @return ID104101OUT
     */
	public ID104101OUT selectHeader(ID104101IN inParam) throws EnfraBusinessException {

		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");

		ID104101OUT outParam = new ID104101OUT();

		// 보고서 명 조회
		outParam.setPbnfRptNm(daoID1041.selectOnePbnfRptNm(inParam));
		// 보고서 조회
		outParam.setArrList(daoID1041.selectHeader(inParam));
		// 보고서 머지 조회
		outParam.setArrListMerge(daoID1041.selectMergeCell(inParam));

		if(outParam.getArrList().size() == 0) {
			throw new EnfraBusinessException("E000061");
		}

		return outParam;
	}
}
