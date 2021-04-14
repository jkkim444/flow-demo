/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO0004.java
 * @brief 사원 코드 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 4. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service
 * @brief Common Service Package
 */
package com.encocns.co.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO0004DAO;
import com.encocns.co.dto.CO000401DTO;
import com.encocns.co.service.svo.CO000401IN;
import com.encocns.co.service.svo.CO000401OUT;
import com.encocns.enfra.core.component.ServiceComponent;

/**
 * @brief 사원 코드 Service
 * @details 사원 코드 Service
 * @author : 차상길
 * @date : 2020. 4. 24.
 * @version : 1.0.0
 */
@Service
public class CO0004 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO0004.class);

	@Autowired
	private CO0004DAO daoCO0004;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 사원 코드 조회
     * @details 사원 코드 조회
     * @author : 차상길
     * @date : 2020. 4. 24.
     * @version : 1.0.0
     * @param CO000401IN
     * @return CO000401OUT
     */
	public CO000401OUT selectEmployeeList(CO000401IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectEmployeeList -----");

		List<CO000401DTO> arrList = null;
		arrList = daoCO0004.selectEmployeeList(inParam);

		CO000401OUT outParam = new CO000401OUT();
		outParam.setArrList(arrList);

		return outParam;
	}

}
