/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO201001OUT.java
 * @brief 메뉴 관리 조회 OUT
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

import java.util.ArrayList;

import com.encocns.co.dto.CO201001DTO;

/**
 * @brief 메뉴 관리 조회 OUT
 * @details 메뉴 관리 조회 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO201001OUT {

	private ArrayList<CO201001DTO> arrList;		/* 메뉴목록 조회 */
	private CO201001DTO menuScrInfo;			/* 메뉴정보 조회 */

	public ArrayList<CO201001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(ArrayList<CO201001DTO> arrList) {
		this.arrList = arrList;
	}
	public CO201001DTO getMenuScrInfo() {
		return menuScrInfo;
	}
	public void setMenuScrInfo(CO201001DTO menuScrInfo) {
		this.menuScrInfo = menuScrInfo;
	}
}
