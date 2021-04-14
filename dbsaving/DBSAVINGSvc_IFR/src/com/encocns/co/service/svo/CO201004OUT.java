/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO201004OUT.java
 * @brief 메뉴 관리 OUT
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

import com.encocns.co.dto.CO201003DTO;

/**
 * @brief 메뉴 관리 OUT
 * @details 메뉴 관리 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO201004OUT {

    private List<CO201003DTO> outMenuList;	/* 메뉴목록 조회 */

	public List<CO201003DTO> getOutMenuList() {
		return outMenuList;
	}

	public void setOutMenuList(List<CO201003DTO> outMenuList) {
		this.outMenuList = outMenuList;
	}
}
