/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW103001OUT.java
 * @brief Batch Operation Status OUT
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 22. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

import java.util.ArrayList;

import com.encocns.fw.dto.FW103001DTO;

/**
 * @brief Batch Operation Status OUT
 * @details Batch Operation Status OUT
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 22.
 * @version : 1.0.0
 */
public class FW103001OUT {

	private ArrayList<FW103001DTO> arrList;		/* 배치조회 */

	public ArrayList<FW103001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(ArrayList<FW103001DTO> arrList) {
		this.arrList = arrList;
	}
}
