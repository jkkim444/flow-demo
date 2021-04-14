/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2011.java
 * @brief 화면 목록 Service
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

import com.encocns.co.dao.CO2011DAO;
import com.encocns.co.dto.CO201101DTO;
import com.encocns.co.service.svo.CO201101IN;
import com.encocns.co.service.svo.CO201101OUT;

/**
 * @brief 화면 목록 Service
 * @details 화면 목록 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class CO2011 {

	@Autowired
	private CO2011DAO daoCO2011;

    /**
     * @brief 화면 목록 조회
     * @details 화면 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201101IN
     * @return CO201101OUT
     */
	public CO201101OUT selectScreenList( CO201101IN inParam )
	{
		List<CO201101DTO> arrList = daoCO2011.selectScreenList(inParam);

		CO201101OUT outParam = new CO201101OUT();
		outParam.setArrList(arrList);

		return outParam;
	}
}
