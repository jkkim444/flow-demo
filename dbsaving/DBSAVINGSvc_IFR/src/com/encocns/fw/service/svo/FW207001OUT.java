/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW207001OUT.java
 * @brief Create Annotation OUT
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 6. 20. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

import java.util.ArrayList;

import com.encocns.fw.dto.FW207001DTO;

/**
 * @brief column name List OUT
 * @details column name List OUT
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 11.
 * @version : 1.0.0
 */
public class FW207001OUT {

	private ArrayList<FW207001DTO> arrList;

	public ArrayList<FW207001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(ArrayList<FW207001DTO> arrList) {
		this.arrList = arrList;
	}
}
