/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO302001OUT.java
 * @brief 메시지 코드 조회 OUT
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

import com.encocns.co.dto.CO302001DTO;

/**
 * @brief 메시지 코드 조회 OUT
 * @details 메시지 코드 조회 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO302001OUT {

    private List<CO302001DTO> arrList;

	public List<CO302001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<CO302001DTO> arrList) {
		this.arrList = arrList;
	}
}
