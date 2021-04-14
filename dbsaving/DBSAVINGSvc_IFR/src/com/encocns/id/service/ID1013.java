/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1013.java
 * @brief 공시보고서 조회 Service
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

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.id.dao.ID1013DAO;
import com.encocns.id.dto.ID101301DTO;
import com.encocns.id.service.svo.ID101301IN;
import com.encocns.id.service.svo.ID101301OUT;

/**
 * @brief 공시보고서 조회 Service
 * @details 공시보고서 조회 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID1013 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1013.class);

	@Autowired
	private ID1013DAO daoID1013;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 보고서 조회
     * @details 보고서 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101301IN
     * @return ID101301OUT
     */
	public ID101301OUT selRptList(ID101301IN in) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selRptList -----");

		ArrayList<ID101301DTO> arrList = daoID1013.selRptList(in);

		ID101301OUT out = new ID101301OUT();
		out.setArrList(arrList);

		return out;
	}
}
