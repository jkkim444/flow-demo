/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID101001OUT.java
 * @brief 보고서 조회 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.service.svo
 * @brief id SVO Package
 */
package com.encocns.id.service.svo;

import java.util.List;

import com.encocns.id.dto.ID101001DTO;

/**
 * @brief 보고서 조회 OUT
 * @details 보고서 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID101001OUT {

	private List<ID101001DTO> arrList; /* 공시보고서 리스트 */

	public List<ID101001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<ID101001DTO> arrList) {
		this.arrList = arrList;
	}

}
