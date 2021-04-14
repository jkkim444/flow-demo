/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA527001IN.java
 * @brief 유가증권처분내역 management IN
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 05. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 유가증권처분내역 management IN
 * @details 유가증권처분내역 요약 조회 및 엑셀 다운 IN
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 05.
 * @version : 1.0.0
 */
public class IA527001IN {
    private String searchStdrYm;                  /* 기준년월 */
    private String acngBaseCd;                    /* 회계기준코드 */
    private String mkstIqryDivCd;                 /* 조회구분 */

	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public String getAcngBaseCd() {
		return acngBaseCd;
	}
	public void setAcngBaseCd(String acngBaseCd) {
		this.acngBaseCd = acngBaseCd;
	}
	public String getMkstIqryDivCd() {
		return mkstIqryDivCd;
	}
	public void setMkstIqryDivCd(String mkstIqryDivCd) {
		this.mkstIqryDivCd = mkstIqryDivCd;
	}
}

