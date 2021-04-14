/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO301001OUT.java
 * @brief 공통 코드 도메인 OUT
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

import com.encocns.co.dto.CO301001DTO;

/**
 * @brief 공통 코드 도메인 OUT
 * @details 공통 코드 도메인 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO301001OUT {

    List<CO301001DTO> arrList;

	public List<CO301001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<CO301001DTO> arrList) {
		this.arrList = arrList;
	}
}
