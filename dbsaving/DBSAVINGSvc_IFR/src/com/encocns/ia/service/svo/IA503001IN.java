/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA503001IN.java
 * @brief IFRS정산표 산출 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief IFRS정산표 산출 management IN
 * @details IFRS정산표 산출 management IN
 * @author : 이동겸
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
public class IA503001IN {

	private String searchStdrYm;           /* 전기년월 */
    private boolean bltAccYn;              /* 실계정여부 */
    private String ifrsAccCd;			   /* 계정코드 */
    private boolean chkAmt;				   /* 검증식 적용 */
    private String usrId;				   /* 사용자ID */

	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public boolean isChkAmt() {
		return chkAmt;
	}
	public void setChkAmt(boolean chkAmt) {
		this.chkAmt = chkAmt;
	}
	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public boolean isBltAccYn() {
		return bltAccYn;
	}
	public void setBltAccYn(boolean bltAccYn) {
		this.bltAccYn = bltAccYn;
	}
	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
}
