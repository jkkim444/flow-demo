/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO101001OUT.java
 * @brief 사용자 목록 조회 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 03. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.List;

import com.encocns.co.dto.CO101001DTO;

/**
 * @brief 사용자 목록 조회 OUT
 * @details 사용자 목록 조회 OUT
 * @author : 차상길
 * @date : 2020. 09. 03.
 * @version : 1.0.0
 */
public class CO101001OUT {

	private List<CO101001DTO> arrList;		/* 사원 조회 */

	public List<CO101001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<CO101001DTO> arrList) {
		this.arrList = arrList;
	}

}
