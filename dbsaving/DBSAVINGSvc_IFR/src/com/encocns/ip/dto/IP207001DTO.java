/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP207001DTO.java
 * @brief 예치금대손충당금 기본 List Query DTO
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
 * @brief 예치금대손충당금 기본 management List Query DTO
 * @details 예치금대손충당금 기본 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP207001DTO {

	private String rNum;
	private String stdrYm;                   /* 기준년월 */
	private String instCd;                   /* 예치금기관코드 */
    private String crgdCd;                   /* 신용등급코드 */
    private BigDecimal loanBal;              /* 대출잔액 */
    private BigDecimal ucin;                 /* 미수이자 */
    private BigDecimal addLoanUcin;          /* 대출잔액+미수이자 */

    private double pdRate;                   /* PD비율 */
    private double lgdRate;                  /* LGD비율 */
    private BigDecimal dsmnRsam;             /* 예치금충당금엑 */
    private BigDecimal ucinRsam;             /* 미수이자 */

    private String delYn;					 /* 삭제 여부 */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public BigDecimal getAddLoanUcin() {
		return addLoanUcin;
	}
	public void setAddLoanUcin(BigDecimal addLoanUcin) {
		this.addLoanUcin = addLoanUcin;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
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
	public double getPdRate() {
		return pdRate;
	}
	public void setPdRate(double pdRate) {
		this.pdRate = pdRate;
	}
	public double getLgdRate() {
		return lgdRate;
	}
	public void setLgdRate(double lgdRate) {
		this.lgdRate = lgdRate;
	}
	public BigDecimal getDsmnRsam() {
		return dsmnRsam;
	}
	public void setDsmnRsam(BigDecimal dsmnRsam) {
		this.dsmnRsam = dsmnRsam;
	}
	public BigDecimal getUcinRsam() {
		return ucinRsam;
	}
	public void setUcinRsam(BigDecimal ucinRsam) {
		this.ucinRsam = ucinRsam;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
