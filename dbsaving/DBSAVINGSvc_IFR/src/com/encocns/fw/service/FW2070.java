/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW2070.java
 * @brief Create Annotation Service
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 11. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service
 * @brief Common Service Package
 */
package com.encocns.fw.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.fw.dao.FW2070DAO;
import com.encocns.fw.dto.FW207001DTO;
import com.encocns.fw.service.svo.FW207001IN;
import com.encocns.fw.service.svo.FW207001OUT;

/**
 * @brief Create Annotation Service
 * @details It is Create Annotation service.
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 11.
 * @version : 1.0.0
 */
@Service
public class FW2070 {

	@Autowired
	private FW2070DAO daoFW2070;

    /**
     * @brief column name inquiry
     * @details column name inquiry
     * @author : CHA, SANG-GIL
     * @date : 2019. 7. 11.
     * @version : 1.0.0
     * @param inSearchParam
     * @return ArrayList List of Service
     */
	public FW207001OUT selectColumnName( FW207001IN inSearchParam ) throws EnfraBusinessException
	{
		ArrayList<FW207001DTO> arrList = daoFW2070.selectColumnName(inSearchParam);

		//Instance OSVO
		FW207001OUT outColumnList = new FW207001OUT();
		outColumnList.setArrList(arrList);

		return outColumnList;
	}
}
