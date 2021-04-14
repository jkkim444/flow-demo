/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID101301IN.java
 * @brief 공시보고서 조회 IN
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
 * @brief 공시보고서 조회 IN
 * @details 공시보고서 조회 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID101301IN {

	private String pbnfRptId;                        /* 공시보고서ID */
	private String pbnfRptNm;                        /* 공시보고서명 */
	private String mnipRegYn;                        /* 수기등록여부 */

	public String getPbnfRptId() {
		return pbnfRptId;
	}

	public void setPbnfRptId(String pbnfRptId) {
		this.pbnfRptId = pbnfRptId;
	}

	public String getPbnfRptNm() {
		return pbnfRptNm;
	}

	public void setPbnfRptNm(String pbnfRptNm) {
		this.pbnfRptNm = pbnfRptNm;
	}

	public String getMnipRegYn() {
		return mnipRegYn;
	}

	public void setMnipRegYn(String mnipRegYn) {
		this.mnipRegYn = mnipRegYn;
	}

}
