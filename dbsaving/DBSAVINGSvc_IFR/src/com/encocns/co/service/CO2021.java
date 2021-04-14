/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2021.java
 * @brief 서비스 목록 Service
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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO2021DAO;
import com.encocns.co.dto.CO202101DTO;
import com.encocns.co.service.svo.CO202101IN;
import com.encocns.co.service.svo.CO202101OUT;

/**
 * @brief 서비스 목록 Service
 * @details 서비스 목록 Service.
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class CO2021 {

	@Autowired
	private CO2021DAO daoCO2021;

    /**
     * @brief Service List inquiry
     * @details The Service List.
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO202101IN
     * @return CO202101OUT
     */
	public CO202101OUT selectServiceList( CO202101IN inParam )
	{
		List<CO202101DTO> arrList = daoCO2021.selectServiceList(inParam);

		//Instance OSVO
		CO202101OUT outParam = new CO202101OUT();
		outParam.setArrList(arrList);

		return outParam;
	}
}
