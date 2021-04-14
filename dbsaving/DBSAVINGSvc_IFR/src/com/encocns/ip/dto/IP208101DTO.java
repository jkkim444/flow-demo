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
public class IP208101DTO {

	private String rNum;				   /* 행번호 */
	private String stdrYm;                 /* 기준년월 */
	private String loanAcno;               /* 대출계좌번호 */
	private String cstno;                  /* 고객번호 */
	private String custNm;                 /* 고객명 */
	private String idvdCorpDvcd;           /* 개인기업구분코드 */
	private String gdsNm;                  /* 상품명 */
	private String pdSgmtCd;               /* PDSegment코드 */
	private String lgdSgmtCd;              /* LGDSegment코드 */
	private String indvTrevYn;             /* 개별평가대상여부 */
	private String loanDt;                 /* 대출일자 */
	private String exprDt;                 /* 만기일자 */
	private BigDecimal lnam;               /* 대출금액 */
	private BigDecimal loanBal;            /* 대출잔액 */
	private double loanRt;                 /* 대출이율 */
	private int ovrdNth;                   /* 연체회차 */
	private BigDecimal ucinAmt;            /* 미수이자금액 */
	private String asqlClcd;               /* 자산건전성분류코드 */
	private String trgtValdtnCd;           /* 대상검증코드  */
	private BigDecimal mtpr;               /* 담보가액 */

    private String delYn;				   /* 사용자ID */

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
	public String getLoanDt() {
		return loanDt;
	}
	public void setLoanDt(String loanDt) {
		this.loanDt = loanDt;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getExprDt() {
		return exprDt;
	}
	public void setExprDt(String exprDt) {
		this.exprDt = exprDt;
	}
	public String getPdSgmtCd() {
		return pdSgmtCd;
	}
	public void setPdSgmtCd(String pdSgmtCd) {
		this.pdSgmtCd = pdSgmtCd;
	}
	public BigDecimal getLnam() {
		return lnam;
	}
	public void setLnam(BigDecimal lnam) {
		this.lnam = lnam;
	}
	public String getLgdSgmtCd() {
		return lgdSgmtCd;
	}
	public void setLgdSgmtCd(String lgdSgmtCd) {
		this.lgdSgmtCd = lgdSgmtCd;
	}
	public BigDecimal getLoanBal() {
		return loanBal;
	}
	public void setLoanBal(BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	public String getIndvTrevYn() {
		return indvTrevYn;
	}
	public void setIndvTrevYn(String indvTrevYn) {
		this.indvTrevYn = indvTrevYn;
	}
	public String getIdvdCorpDvcd() {
		return idvdCorpDvcd;
	}
	public void setIdvdCorpDvcd(String idvdCorpDvcd) {
		this.idvdCorpDvcd = idvdCorpDvcd;
	}
	public double getLoanRt() {
		return loanRt;
	}
	public void setLoanRt(double loanRt) {
		this.loanRt = loanRt;
	}
	public int getOvrdNth() {
		return ovrdNth;
	}
	public void setOvrdNth(int ovrdNth) {
		this.ovrdNth = ovrdNth;
	}
	public BigDecimal getUcinAmt() {
		return ucinAmt;
	}
	public void setUcinAmt(BigDecimal ucinAmt) {
		this.ucinAmt = ucinAmt;
	}
	public String getTrgtValdtnCd() {
		return trgtValdtnCd;
	}
	public void setTrgtValdtnCd(String trgtValdtnCd) {
		this.trgtValdtnCd = trgtValdtnCd;
	}
	public String getCustNm() {
		return custNm;
	}
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	public String getAsqlClcd() {
		return asqlClcd;
	}
	public void setAsqlClcd(String asqlClcd) {
		this.asqlClcd = asqlClcd;
	}
	public BigDecimal getMtpr() {
		return mtpr;
	}
	public void setMtpr(BigDecimal mtpr) {
		this.mtpr = mtpr;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
