/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID101001IN.java
 * @brief 보고서 조회 IN
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
 * @brief 보고서 조회 IN
 * @details 보고서 조회 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID101001IN {

	private String baseYm;        /* 기준년도 */
	private String pbnfRptId;     /* 공시보고서ID */
	private String pbnfRptNm;     /* 공시보고서명 */
	private String rptPbnfYn;     /* 보고서공시여부 */
	private String uprnPbnfRptId; /* 상위공시보고서ID */
	private String uprnPbnfRptNm; /* 공시보고서명 */

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

	public String getPbnfRptNm() {
		return pbnfRptNm;
	}

	public void setPbnfRptNm(String pbnfRptNm) {
		this.pbnfRptNm = pbnfRptNm;
	}

	public String getRptPbnfYn() {
		return rptPbnfYn;
	}

	public void setRptPbnfYn(String rptPbnfYn) {
		this.rptPbnfYn = rptPbnfYn;
	}

	public String getUprnPbnfRptId() {
		return uprnPbnfRptId;
	}

	public void setUprnPbnfRptId(String uprnPbnfRptId) {
		this.uprnPbnfRptId = uprnPbnfRptId;
	}

	public String getUprnPbnfRptNm() {
		return uprnPbnfRptNm;
	}

	public void setUprnPbnfRptNm(String uprnPbnfRptNm) {
		this.uprnPbnfRptNm = uprnPbnfRptNm;
	}

}
