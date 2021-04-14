/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1042.java
 * @brief 산출정보조회 Service
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
import com.encocns.id.dao.ID1042DAO;
import com.encocns.id.service.svo.ID104201IN;
import com.encocns.id.service.svo.ID104201OUT;

/**
 * @brief 산출정보조회 Service
 * @details 산출정보조회 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID1042 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1042.class);

	@Autowired
	private ID1042DAO daoID1042;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 산출정보 조회
     * @details 산출정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104201IN
     * @return ID104201OUT
     */
	public ID104201OUT selectClclIstgList(ID104201IN inParam) throws EnfraBusinessException {

		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClclIstgList -----");

		ID104201OUT outParam = new ID104201OUT();
		outParam.setArrList(daoID1042.selectClclIstgList(inParam));

		return outParam;
	}

}
