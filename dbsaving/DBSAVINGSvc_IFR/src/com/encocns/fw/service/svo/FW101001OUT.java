/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW101001OUT.java
 * @brief Service Management OUT
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

import java.util.List;

import com.encocns.fw.dto.FW101001DTO;

/**
 * @brief Service Management OUT
 * @details Service Management OUT
 * @author : CHA, SANG-GIL
 * @date : 2019. 6. 20.
 * @version : 1.0.0
 */
public class FW101001OUT {

	private List<FW101001DTO> arrList;		/* 서비스 목록 */

	public List<FW101001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<FW101001DTO> arrList) {
		this.arrList = arrList;
	}
}
