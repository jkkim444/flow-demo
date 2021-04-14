/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA508001IN.java
 * @brief 연결자본변동표관리 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 연결자본변동표관리 management IN
 * @details 연결자본변동표관리 management IN
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA508001IN {

	private String searchStdrYm;                        /* 기준년월 */
	private String spusLnknDivCd;                       /* 연결변동 구분코드 */

	public String getSpusLnknDivCd() {
		return spusLnknDivCd;
	}
	public void setSpusLnknDivCd(String spusLnknDivCd) {
		this.spusLnknDivCd = spusLnknDivCd;
	}
	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}

}
