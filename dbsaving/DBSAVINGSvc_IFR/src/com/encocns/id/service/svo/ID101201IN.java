/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID101201IN.java
 * @brief 상위보고서 조회 IN
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
 * @brief 상위보고서 조회 IN
 * @details 상위보고서 조회 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID101201IN {

	private String uprnPbnfRptId;                    /* 상위공시보고서ID */
	private String uprnPbnfRptNm;                    /* 공시보고서명 */
	private int cmtLevel;                            /* 주석레벨 */

	public int getCmtLevel() {
		return cmtLevel;
	}

	public void setCmtLevel(int cmtLevel) {
		this.cmtLevel = cmtLevel;
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
