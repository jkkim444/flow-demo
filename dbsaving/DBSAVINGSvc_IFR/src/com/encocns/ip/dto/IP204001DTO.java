/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP204001DTO.java
 * @brief 개별평가대상 기본 List Query DTO
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
 * @brief 개별평가대상 기본 management List Query DTO
 * @details 개별평가대상 기본 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP204001DTO {

	private String rNum;
	private String stdrYm;                  /* 기준년월 */
    private String loanAcno;                /* 계좌번호 */
    private BigDecimal loanBal;             /* 대출잔액 */
    private BigDecimal indvEvalRsrv;        /* 개별평가충당금 */
    private String delYn;					/* 삭제여부 */

	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getLoanAcno() {
		return loanAcno;
	}
	public void setLoanAcno(String loanAcno) {
		this.loanAcno = loanAcno;
	}
	public BigDecimal getLoanBal() {
		return loanBal;
	}
	public void setLoanBal(BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	public BigDecimal getIndvEvalRsrv() {
		return indvEvalRsrv;
	}
	public void setIndvEvalRsrv(BigDecimal indvEvalRsrv) {
		this.indvEvalRsrv = indvEvalRsrv;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
