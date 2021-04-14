/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO301004IN.java
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
public class CO301004IN {

    private String cdDmnId;
    private String cdDmnNm;
    private String rmkCntn;
    private String usrId;

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
	public String getRmkCntn() {
		return rmkCntn;
	}
	public void setRmkCntn(String rmkCntn) {
		this.rmkCntn = rmkCntn;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
