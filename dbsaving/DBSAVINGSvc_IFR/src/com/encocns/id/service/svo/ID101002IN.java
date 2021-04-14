/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID101002IN.java
 * @brief 보고서 기초생성 IN
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

/**
 * @brief 보고서 기초생성 IN
 * @details 보고서 기초생성 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID101002IN {

	private String baseYm;                           /* 기준년도 */
	private String searchFrtrYm;                     /* 전기년월 */
	private String usrId;                            /* 사용자ID */

	public String getBaseYm() {
		return baseYm;
	}

	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}

	public String getSearchFrtrYm() {
		return searchFrtrYm;
	}

	public void setSearchFrtrYm(String searchFrtrYm) {
		this.searchFrtrYm = searchFrtrYm;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
