/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO301001IN.java
 * @brief 공통 코드 도메인 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 공통 코드 도메인 IN
 * @details 공통 코드 도메인 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO301001IN {

    private String cdDmnId; /* Code Domain ID */
    private String cdDmnNm;
    private String sysCdYn; /* System code status */
    private String lclCd;   /* Locale code */

	public String getCdDmnId() {
		return cdDmnId;
	}
	public void setCdDmnId(String cdDmnId) {
		this.cdDmnId = cdDmnId;
	}
	public String getCdDmnNm() {
		return cdDmnNm;
	}
	public void setCdDmnNm(String cdDmnNm) {
		this.cdDmnNm = cdDmnNm;
	}
	public String getSysCdYn() {
		return sysCdYn;
	}
	public void setSysCdYn(String sysCdYn) {
		this.sysCdYn = sysCdYn;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}

}
