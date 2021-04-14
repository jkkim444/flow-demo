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
public class IA602003IN {

	private String baseDt;                           /* 기준일자 */
	private String acqsDspslDivCd;                   /* 취득처분구분코드 */
	private String tnasetDivCd;                      /* 유형자산구분코드 */
	private String asetCd;                           /* 자산코드 */

	public String getBaseDt() {
		return baseDt;
	}
	public void setBaseDt(String baseDt) {
		this.baseDt = baseDt;
	}
	public String getAcqsDspslDivCd() {
		return acqsDspslDivCd;
	}
	public void setAcqsDspslDivCd(String acqsDspslDivCd) {
		this.acqsDspslDivCd = acqsDspslDivCd;
	}
	public String getTnasetDivCd() {
		return tnasetDivCd;
	}
	public void setTnasetDivCd(String tnasetDivCd) {
		this.tnasetDivCd = tnasetDivCd;
	}
	public String getAsetCd() {
		return asetCd;
	}
	public void setAsetCd(String asetCd) {
		this.asetCd = asetCd;
	}

}
