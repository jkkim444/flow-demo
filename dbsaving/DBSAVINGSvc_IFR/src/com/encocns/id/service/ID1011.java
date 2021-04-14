/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1011.java
 * @brief 공시보고서 상세 Service
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
import com.encocns.id.dao.ID1011DAO;
import com.encocns.id.service.svo.ID101101IN;
import com.encocns.id.service.svo.ID101101OUT;

/**
 * @brief 공시보고서 상세 Service
 * @details 공시보고서 상세 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID1011 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1011.class);

	@Autowired
	private ID1011DAO daoID1011;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 공시보고서 등록 및 수정
     * @details 공시보고서 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101101IN
     * @return ID101101OUT
     */
	public ID101101OUT mergePbnfRpt(ID101101IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergePbnfRpt -----");

		if(1 <= daoID1011.existPbnfRpt(inParam) && inParam.getIsCreate().equals("Y")) {
			throw new EnfraBusinessException("E000059");
		}

		inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

		int iResult = 0;

		iResult = daoID1011.mergePbnfRpt(inParam);

		ID101101OUT out = new ID101101OUT();
		out.setiResult(iResult);

		return out;
	}
}
