/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW102001OUT.java
 * @brief Batch Management OUT
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 19. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

import java.util.ArrayList;

import com.encocns.fw.dto.FW102001DTO;

/**
 * @brief Batch Management OUT
 * @details Batch Management OUT
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 19.
 * @version : 1.0.0
 */
public class FW102001OUT {

	private ArrayList<FW102001DTO> arrList;		/* 배치목록 */

	public ArrayList<FW102001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(ArrayList<FW102001DTO> arrList) {
		this.arrList = arrList;
	}
}
