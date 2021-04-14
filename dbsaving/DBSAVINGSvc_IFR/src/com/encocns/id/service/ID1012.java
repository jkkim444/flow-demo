/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1012.java
 * @brief 상위보고서 조회 Service
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
import com.encocns.id.dao.ID1012DAO;
import com.encocns.id.dto.ID101201DTO;
import com.encocns.id.service.svo.ID101201IN;
import com.encocns.id.service.svo.ID101201OUT;

/**
 * @brief 상위보고서 조회 Service
 * @details 상위보고서 조회 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID1012 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1012.class);

	@Autowired
	private ID1012DAO daoID1012;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 상위 공시보고서 목록 조회
     * @details 상위 공시보고서 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101201IN
     * @return ID101201OUT
     */
	public ID101201OUT selUprnRptList(ID101201IN in) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selUprnRptList -----");
		ArrayList<ID101201DTO> arrList = daoID1012.selUprnRptList(in);

		ID101201OUT out = new ID101201OUT();
		out.setArrList(arrList);


		return out;
	}
}
