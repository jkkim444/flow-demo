/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO201101OUT.java
 * @brief 화면 목록 조회 OUT
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

import com.encocns.co.dto.CO201101DTO;

/**
 * @brief 화면 목록 조회 OUT
 * @details 화면 목록 조회 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO201101OUT {

	private List<CO201101DTO> arrList;		/* 화면목록 조회 */

	public List<CO201101DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<CO201101DTO> arrList) {
		this.arrList = arrList;
	}

}
