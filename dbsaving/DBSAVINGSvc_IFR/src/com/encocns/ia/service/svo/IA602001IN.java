/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA501001IN.java
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
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA602001IN {

	private String baseDtSt;                      /* 기준일자 */
	private String baseDtEnd;                     /* 기준일자 */
	private String acqsDspslDivCd;                /* 취득처분구분코드 */
	private String tnasetDivCd;                   /* 유형자산구분코드 */
	private String asetNm;                        /* 자산명 */

	public String getBaseDtSt() {
		return baseDtSt;
	}
	public void setBaseDtSt(String baseDtSt) {
		this.baseDtSt = baseDtSt;
	}
	public String getBaseDtEnd() {
		return baseDtEnd;
	}
	public void setBaseDtEnd(String baseDtEnd) {
		this.baseDtEnd = baseDtEnd;
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
	public String getAsetNm() {
		return asetNm;
	}
	public void setAsetNm(String asetNm) {
		this.asetNm = asetNm;
	}

}
