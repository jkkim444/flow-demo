/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP210001DTO.java
 * @brief 담보가액관리 List Query DTO
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
 * @brief 담보가액관리 management List Query DTO
 * @details 담보가액관리 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP210001DTO {

	private String rNum;						   /* 행번호 */
	private String stdrYm;                         /* 기준년월 */
	private String loanAcno;                       /* 대출계좌번호 */
	private String gdsNm;						   /* 상품명 */
    private String cstno;                          /* 고객번호 */
    private String custNm;                         /* 고객명 */
    private BigDecimal loanBal;                    /* 대출잔액 */
    private BigDecimal mtpr;                       /* 담보가액 */
    private BigDecimal mrtgExcsAmt;                /* 담보초과금액 */

    private String delYn;						   /* 삭제여부 */

    public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
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
	public String getCstno() {
		return cstno;
	}
	public void setCstno(String cstno) {
		this.cstno = cstno;
	}
	public String getCustNm() {
		return custNm;
	}
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	public BigDecimal getLoanBal() {
		return loanBal;
	}
	public void setLoanBal(BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	public BigDecimal getMtpr() {
		return mtpr;
	}
	public void setMtpr(BigDecimal mtpr) {
		this.mtpr = mtpr;
	}
	public BigDecimal getMrtgExcsAmt() {
		return mrtgExcsAmt;
	}
	public void setMrtgExcsAmt(BigDecimal mrtgExcsAmt) {
		this.mrtgExcsAmt = mrtgExcsAmt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
