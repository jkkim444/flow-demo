/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA515001IN.java
 * @brief 계리보고서 정보 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 14. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 계리보고서 정보 management IN
 * @details 계리보고서 정보 management IN
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
public class IA517001IN {
    private String searchStdrYm;                  /* 전기년월 */
    private String aconInfoRptDivCd;              /* 계리보고서구분 */

    public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public String getAconInfoRptDivCd() {
		return aconInfoRptDivCd;
	}
	public void setAconInfoRptDivCd(String aconInfoRptDivCd) {
		this.aconInfoRptDivCd = aconInfoRptDivCd;
	}
}
