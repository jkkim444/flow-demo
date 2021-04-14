/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA518001IN.java
 * @brief 기초이월분개처리 management IN
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 9. 29. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 기초이월분개처리 management IN
 * @details 기초이월분개처리 management IN
 * @author : LEE, MI-RAE
 * @date : 2020. 9. 29.
 * @version : 1.0.0
 */
public class IA518001IN {

	private String searchStdrYm;                  /* 기준년월 */
	private String preYm;                         /* 전기년월 */
	private String usrId;                         /* 사용자ID */

	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public String getPreYm() {
		return preYm;
	}
	public void setPreYm(String preYm) {
		this.preYm = preYm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
