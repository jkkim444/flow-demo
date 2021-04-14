/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO0003.java
 * @brief 부서 조회 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service
 * @brief Common Service Package
 */
package com.encocns.co.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO0003DAO;
import com.encocns.co.dto.CO000301DTO;
import com.encocns.co.service.svo.CO000301IN;
import com.encocns.co.service.svo.CO000301OUT;
import com.encocns.enfra.core.component.ServiceComponent;

/**
 * @brief 부서 조회 Service
 * @details 부서 조회 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class CO0003 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO0003.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private CO0003DAO daoCO0003;

    /**
     * @brief 부서 조회
     * @details 부서 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO000301IN
     * @return CO000301OUT
     */
	public CO000301OUT selectDept(CO000301IN inDept) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectGroupList -----");

		ArrayList<CO000301DTO> arrList = daoCO0003.selectDept(inDept);

		CO000301OUT outDeptList = new CO000301OUT();
		outDeptList.setArrList(arrList);

		return outDeptList;
	}

}
