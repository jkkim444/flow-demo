/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA513001IN.java
 * @brief 리스부채사용권관리 management IN
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 11. 02.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 리스부채사용권관리 management IN
 * @details 리스부채사용권관리 management IN
 * @author : LEE, MI-RAE
 * @date : 2020. 11. 02.
 * @version : 1.0.0
 */
public class IA531001IN {
    private String searchStdrYm;		  /* 검색기준년월 */

	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
}
