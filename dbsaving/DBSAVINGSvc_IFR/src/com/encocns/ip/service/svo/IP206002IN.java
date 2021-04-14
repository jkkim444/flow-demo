/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP205002IN.java
 * @brief 예치금대손충당금 기본 IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

import java.math.BigDecimal;

/**
 * @brief 예치금대손충당금 기본 management IN
 * @details 예치금대손충당금 기본 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP206002IN {

	private String stdrYm;                  /* 기준년월 */
	private String frtrYm;                  /* 전기년월 */
	private BigDecimal dprnAmt;             /* 제각금액 */
	private BigDecimal rtrvAmt;             /* 회수금액 */
	private String jobDivCd;                /* 작업구분코드(U,I) */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getFrtrYm() {
		return frtrYm;
	}
	public void setFrtrYm(String frtrYm) {
		this.frtrYm = frtrYm;
	}
	public BigDecimal getDprnAmt() {
		return dprnAmt;
	}
	public void setDprnAmt(BigDecimal dprnAmt) {
		this.dprnAmt = dprnAmt;
	}
	public BigDecimal getRtrvAmt() {
		return rtrvAmt;
	}
	public void setRtrvAmt(BigDecimal rtrvAmt) {
		this.rtrvAmt = rtrvAmt;
	}
	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
}
