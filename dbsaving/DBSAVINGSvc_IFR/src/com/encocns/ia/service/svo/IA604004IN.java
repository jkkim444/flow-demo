/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501003IN.java
 * @brief IFRS 계정코드 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : CHA, SANG-GIL
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA604004IN {

	private String baseYm;                           /* 기준년도 */
	private String searchFrtrYm;                     /* 전기년월 */
	private String usrId;                            /* 사용자ID */

	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
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
}
