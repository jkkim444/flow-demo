/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file CO000201IN.java
 * @brief 계정 코드 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 4. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 계정 코드 IN
 * @details 계정 코드 IN
 * @author : 차상길
 * @date : 2020. 4. 21.
 * @version : 1.0.0
 */
public class CO000201IN {

	private String ifrsAccCd;     /* 계정코드 */
	private String ifrsAccNm;     /* 계정명 */
	private String bltAccYn;      /* 실계정여부 */
	private String ifrsAccDcd;    /* 계정유형구분코드 */
	private String scnProcsDvcd;  /* 화면 처리 구분 */

	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
	public String getIfrsAccNm() {
		return ifrsAccNm;
	}
	public void setIfrsAccNm(String ifrsAccNm) {
		this.ifrsAccNm = ifrsAccNm;
	}
	public String getBltAccYn() {
		return bltAccYn;
	}
	public void setBltAccYn(String bltAccYn) {
		this.bltAccYn = bltAccYn;
	}
	public String getIfrsAccDcd() {
		return ifrsAccDcd;
	}
	public void setIfrsAccDcd(String ifrsAccDcd) {
		this.ifrsAccDcd = ifrsAccDcd;
	}
	public String getScnProcsDvcd() {
		return scnProcsDvcd;
	}
	public void setScnProcsDvcd(String scnProcsDvcd) {
		this.scnProcsDvcd = scnProcsDvcd;
	}

}
