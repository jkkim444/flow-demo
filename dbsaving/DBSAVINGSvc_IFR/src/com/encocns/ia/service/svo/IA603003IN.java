/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501003IN.java
 * @brief IFRS 계정코드 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : CHA, SANG-GIL
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA603003IN {

	private String baseYm;                           /* 기준년도 */
	private String itgastDivCd;                      /* 무형자산구분코드 */
	private String asetCd;                           /* 자산코드 */

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getItgastDivCd() {
		return itgastDivCd;
	}
	public void setItgastDivCd(String itgastDivCd) {
		this.itgastDivCd = itgastDivCd;
	}
	public String getAsetCd() {
		return asetCd;
	}
	public void setAsetCd(String asetCd) {
		this.asetCd = asetCd;
	}
}
