/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP207003IN.java
 * @brief 예치금대손충당금 기본 IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

/**
 * @brief 예치금대손충당금 기본 management IN
 * @details 예치금대손충당금 기본 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP207003IN {

	private String stdrYm;                      /* 기준년월 */
	private String instCd;                      /* 예치금기관코드 */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getInstCd() {
		return instCd;
	}
	public void setInstCd(String instCd) {
		this.instCd = instCd;
	}

}
