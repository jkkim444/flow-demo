/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO202101OUT.java
 * @brief 서비스 목록 조회 OUT
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

import com.encocns.co.dto.CO202101DTO;

/**
 * @brief 서비스 목록 조회 OUT
 * @details 서비스 목록 조회 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO202101OUT {

	private List<CO202101DTO> arrList;		/* 서비스목록 조회 */

	public List<CO202101DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<CO202101DTO> arrList) {
		this.arrList = arrList;
	}

}
