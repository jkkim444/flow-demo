/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP211001DTO.java
 * @brief 대손충당금 집계내역 List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.dto
 * @brief Common DTO Package
 */
package com.encocns.ip.dto;

import java.math.BigDecimal;

/**
 * @brief 대손충당금 집계내역 management List Query DTO
 * @details 대손충당금 집계내역 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP211001DTO {

	private String rNum;				  /* 행번호 */
	private String cd;                    /* 코드(PDorLGD) */
    private String cdNm;                  /* 코드명(PDorLGD) */
    private BigDecimal lnam;              /* 대출금액 */
    private BigDecimal loanBal;           /* 대출잔액 */
    private BigDecimal ucinAmt;           /* 미수이자금액 */
    private BigDecimal lsrsrv;            /* 대손충당금 */
    private BigDecimal ucinRsrv;          /* 미수이자충당금 */
    private String delYn;				  /* 삭제여부 */

	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getCdNm() {
		return cdNm;
	}
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	public BigDecimal getLnam() {
		return lnam;
	}
	public void setLnam(BigDecimal lnam) {
		this.lnam = lnam;
	}
	public BigDecimal getLoanBal() {
		return loanBal;
	}
	public void setLoanBal(BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	public BigDecimal getUcinAmt() {
		return ucinAmt;
	}
	public void setUcinAmt(BigDecimal ucinAmt) {
		this.ucinAmt = ucinAmt;
	}
	public BigDecimal getLsrsrv() {
		return lsrsrv;
	}
	public void setLsrsrv(BigDecimal lsrsrv) {
		this.lsrsrv = lsrsrv;
	}
	public BigDecimal getUcinRsrv() {
		return ucinRsrv;
	}
	public void setUcinRsrv(BigDecimal ucinRsrv) {
		this.ucinRsrv = ucinRsrv;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
