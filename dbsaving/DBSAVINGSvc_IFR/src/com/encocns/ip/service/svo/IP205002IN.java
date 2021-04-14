/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP205002IN.java
 * @brief 기타충당금 기본 IN
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
 * @brief 기타충당금 기본 management IN
 * @details 기타충당금 기본 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP205002IN {

	private String stdrYm;                  /* 기준년월 */
	private BigDecimal etcLoanRsrv;         /* 기타대출충당금 */
	private BigDecimal cntrAmt;				/* 계약금액 */
	private BigDecimal uzAmt;				/* 사용금액 */
	private BigDecimal unuseLimtAmt;        /* 미사용한도금액 */
	private double ccfVal;                  /* CCF값 */
	private BigDecimal etcRsrv;             /* 기타충당금 */

	private String jobDivCd;                /* 작업구분코드(U,I) */
	private String usrId;					/* 사용자ID */

	public BigDecimal getCntrAmt() {
		return cntrAmt;
	}
	public void setCntrAmt(BigDecimal cntrAmt) {
		this.cntrAmt = cntrAmt;
	}
	public BigDecimal getUzAmt() {
		return uzAmt;
	}
	public void setUzAmt(BigDecimal uzAmt) {
		this.uzAmt = uzAmt;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public BigDecimal getEtcLoanRsrv() {
		return etcLoanRsrv;
	}
	public void setEtcLoanRsrv(BigDecimal etcLoanRsrv) {
		this.etcLoanRsrv = etcLoanRsrv;
	}
	public BigDecimal getUnuseLimtAmt() {
		return unuseLimtAmt;
	}
	public void setUnuseLimtAmt(BigDecimal unuseLimtAmt) {
		this.unuseLimtAmt = unuseLimtAmt;
	}
	public double getCcfVal() {
		return ccfVal;
	}
	public void setCcfVal(double ccfVal) {
		this.ccfVal = ccfVal;
	}
	public BigDecimal getEtcRsrv() {
		return etcRsrv;
	}
	public void setEtcRsrv(BigDecimal etcRsrv) {
		this.etcRsrv = etcRsrv;
	}
	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
