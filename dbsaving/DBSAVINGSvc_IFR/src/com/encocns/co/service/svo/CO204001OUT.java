/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO204001OUT.java
 * @brief 부서 메뉴 관리 조회 OUT
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

import com.encocns.co.dto.CO204001DTO;

/**
 * @brief 부서 메뉴 관리 조회 OUT
 * @details 부서 메뉴 관리 조회 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO204001OUT {

	private String grpId;                         /* 그룹ID */
	private List<CO204001DTO> arrList;            /* 목록 조회 */

	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public List<CO204001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<CO204001DTO> arrList) {
		this.arrList = arrList;
	}

}