/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000301OUT.java
 * @brief 부서 조회 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.ArrayList;

import com.encocns.co.dto.CO000301DTO;

/**
 * @brief 부서 조회 OUT
 * @details 부서 조회 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000301OUT {

	private ArrayList<CO000301DTO> arrList;			/* 부서 조회 */

	public ArrayList<CO000301DTO> getArrList() {
		return arrList;
	}

	public void setArrList(ArrayList<CO000301DTO> arrList) {
		this.arrList = arrList;
	}

}
