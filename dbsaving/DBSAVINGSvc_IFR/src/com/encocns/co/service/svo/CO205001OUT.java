/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO205001OUT.java
 * @brief 그룹사용자관리 OUT
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

import java.util.List;

import com.encocns.co.dto.CO205001DTO;

/**
 * @brief 그룹사용자관리 OUT
 * @details 그룹사용자관리 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO205001OUT {

	private List<CO205001DTO> arrList;

	public List<CO205001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<CO205001DTO> arrList) {
		this.arrList = arrList;
	}
}
