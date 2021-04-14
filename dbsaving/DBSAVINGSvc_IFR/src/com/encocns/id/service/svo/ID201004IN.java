/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID201004IN.java
 * @brief 산출 데이터 생성 IN
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
 * @brief 산출 데이터 생성 IN
 * @details 산출 데이터 생성 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID201004IN {

	private String baseYm;                           /* 기준년도 */
	private String prevYm;                           /* 전기년월 */
	private String lastDay;                          /* 마지막일 */
	private String usrId;                            /* 사용자ID */

	public String getBaseYm() {
		return baseYm;
	}

	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getPrevYm() {
		return prevYm;
	}

	public void setPrevYm(String prevYm) {
		this.prevYm = prevYm;
	}

	public String getLastDay() {
		return lastDay;
	}

	public void setLastDay(String lastDay) {
		this.lastDay = lastDay;
	}
}
