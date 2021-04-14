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
public class IA501001IN {
    private String searchStdrYm;				/* 적용시작일자 */
    private String ifrsAccCd;					/* 계정코드 */
    private String uprIfrsAccCd;				/* 상위IFRS계정코드 */
    private boolean bltAccYn;					/* 실계정여부 */
	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
	public String getUprIfrsAccCd() {
		return uprIfrsAccCd;
	}
	public void setUprIfrsAccCd(String uprIfrsAccCd) {
		this.uprIfrsAccCd = uprIfrsAccCd;
	}
	public boolean isBltAccYn() {
		return bltAccYn;
	}
	public void setBltAccYn(boolean bltAccYn) {
		this.bltAccYn = bltAccYn;
	}




}
