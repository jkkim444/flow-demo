/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA511001IN.java
 * @brief IFRS정산표 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief IFRS정산표 management IN
 * @details IFRS정산표 management IN
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA511001IN {
    private String searchStdrYm;           /* 기준년월 */
    private String accDiv;				   /* 계정구분 코드 */
    private String ifrsAccCd;              /* IFRS 계정 코드*/
    private boolean chkIfrs;               /* 0원 이상 */
    private boolean bltAccYn;              /* 실계정여부 */

	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public String getAccDiv() {
		return accDiv;
	}
	public void setAccDiv(String accDiv) {
		this.accDiv = accDiv;
	}
	public boolean isChkIfrs() {
		return chkIfrs;
	}
	public void setChkIfrs(boolean chkIfrs) {
		this.chkIfrs = chkIfrs;
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
