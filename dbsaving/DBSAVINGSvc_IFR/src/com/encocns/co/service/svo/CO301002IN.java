/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO301002IN.java
 * @brief 공통 코드 IN
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
 * @brief 공통 코드 IN
 * @details 공통 코드 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO301002IN {

    private String cdDmnId; /* Code domain ID */
    private String lclCd;   /* Locale code */

	public String getCdDmnId() {
		return cdDmnId;
	}
	public void setCdDmnId(String cdDmnId) {
		this.cdDmnId = cdDmnId;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}

}
