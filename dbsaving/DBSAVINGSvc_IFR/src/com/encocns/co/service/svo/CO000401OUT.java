/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000401OUT.java
 * @brief 사원 코드 조회 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 4. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.List;

import com.encocns.co.dto.CO000401DTO;

/**
 * @brief 사원 코드 조회 OUT
 * @details 사원 코드 조회 OUT
 * @author : 차상길
 * @date : 2020. 4. 24.
 * @version : 1.0.0
 */
public class CO000401OUT {

	private List<CO000401DTO> arrList;		/* 사원조회 */

	public List<CO000401DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<CO000401DTO> arrList) {
		this.arrList = arrList;
	}

}
