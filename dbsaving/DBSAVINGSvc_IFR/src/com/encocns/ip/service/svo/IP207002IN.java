/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP207002IN.java
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
public class IP207002IN {

	private String stdrYm;                  /* 기준년월 */
	private String instCd;                  /* 예치금기관코드 */
	private String crgdCd;                  /* 신용등급코드 */
	private BigDecimal loanBal;             /* 대출잔액 */
	private BigDecimal ucin;                /* 미수이자 */

	private String jobDivCd;                /* 작업구분코드(U,I) */
	private String usrId;				    /* 사용자ID */

	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getInstCd() {
		return instCd;
	}
	public void setInstCd(String instCd) {
		this.instCd = instCd;
	}
	public String getCrgdCd() {
		return crgdCd;
	}
	public void setCrgdCd(String crgdCd) {
		this.crgdCd = crgdCd;
	}
	public BigDecimal getLoanBal() {
		return loanBal;
	}
	public void setLoanBal(BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	public BigDecimal getUcin() {
		return ucin;
	}
	public void setUcin(BigDecimal ucin) {
		this.ucin = ucin;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
