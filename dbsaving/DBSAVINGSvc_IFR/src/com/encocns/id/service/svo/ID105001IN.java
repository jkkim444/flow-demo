/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID105001IN.java
 * @brief 보고서 양식 조회 IN
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
 * @brief 보고서 양식 조회 IN
 * @details 보고서 양식 조회 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID105001IN {

	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */

	public String getBaseYm() {
		return baseYm;
	}

	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}

	public String getPbnfRptId() {
		return pbnfRptId;
	}

	public void setPbnfRptId(String pbnfRptId) {
		this.pbnfRptId = pbnfRptId;
	}

}
