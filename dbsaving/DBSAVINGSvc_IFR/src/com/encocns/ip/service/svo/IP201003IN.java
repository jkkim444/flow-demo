/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP201003IN.java
 * @brief F/L반영 PD관리 IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

/**
 * @brief F/L반영 PD관리 management IN
 * @details F/L반영 PD관리 management IN
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
public class IP201003IN {

	private String stdrYm;               /* 기준년월 */
	private String pdSgmtCd;             /* PDSGMT코드 */
	private int nth;					 /* 연체회차 */

	public int getNth() {
		return nth;
	}
	public void setNth(int nth) {
		this.nth = nth;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getPdSgmtCd() {
		return pdSgmtCd;
	}
	public void setPdSgmtCd(String pdSgmtCd) {
		this.pdSgmtCd = pdSgmtCd;
	}

}
