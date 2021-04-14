/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA505001IN.java
 * @brief 재무상태표 조회 management IN
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
 * @brief 재무상태표 조회 management IN
 * @details 재무상태표 조회 management IN
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA505001IN {

	private String searchThtrYm;                       /* 당기기준일 */
    private String searchFrtrYm;                       /* 전기기준일 */

	public String getSearchThtrYm() {
		return searchThtrYm;
	}
	public void setSearchThtrYm(String searchThtrYm) {
		this.searchThtrYm = searchThtrYm;
	}
	public String getSearchFrtrYm() {
		return searchFrtrYm;
	}
	public void setSearchFrtrYm(String searchFrtrYm) {
		this.searchFrtrYm = searchFrtrYm;
	}
}
