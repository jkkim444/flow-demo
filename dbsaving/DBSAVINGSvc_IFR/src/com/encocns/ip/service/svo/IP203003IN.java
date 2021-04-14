/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP203003IN.java
 * @brief NICE PD관리 IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

/**
 * @brief NICE PD관리 management IN
 * @details NICE PD관리 management IN
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
public class IP203003IN {

	private String stdrYm;                  /* 기준년월 */
	private String crgdCd;                  /* 신용등급 코드 */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getCrgdCd() {
		return crgdCd;
	}
	public void setCrgdCd(String crgdCd) {
		this.crgdCd = crgdCd;
	}
}
