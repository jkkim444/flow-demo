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



/**
 * @brief 예치금대손충당금 기본 management List Query DTO
 * @details 예치금대손충당금 기본 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP208002DTO {

	private String rNum;
	private String stdrYm;                     /* 기준년월 */
	private String seqno;                      /* 일련번호 */
	private String loanAcno;                   /* 대출계좌번호 */
	private String cstno;                      /* 고객번호 */
	private String custNm;                     /* 고객명 */
	private String idvdCorpDvcd;               /* 개인기업구분코드 */
	private String idvdCorpDvcdNm;			   /* 개인기업구분명 */
	private String gdsNm;                      /* 상품명 */
	private String pdSgmtCd;                   /* PDSegment코드 */
	private String pdSgmtNm;				   /* PDSegment코드명 */
	private String lgdSgmtCd;                  /* LGDSegment코드 */
	private String lgdSgmtNm;	               /* LGDSegment코드명 */
	private String indvTrevYn;                 /* 개별평가대상여부 */
	private String otinOvrdYn;                 /* 타기관연체여부 */
	private String loanDt;                     /* 대출일자 */
	private String exprDt;                     /* 만기일자 */
	private String lnam;                       /* 대출금액 */
	private String loanBal;                    /* 대출잔액 */
	private String loanRt;                     /* 대출이율 */
	private String ovrdNth;                    /* 연체회차 */
	private String ucinAmt;                    /* 미수이자금액 */
	private String asqlClcd;                   /* 자산건전성분류코드 */
	private String trgtValdtnCd;               /* 대상검증코드  */

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
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
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
	public String getIdvdCorpDvcd() {
		return idvdCorpDvcd;
	}
	public void setIdvdCorpDvcd(String idvdCorpDvcd) {
		this.idvdCorpDvcd = idvdCorpDvcd;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getPdSgmtCd() {
		return pdSgmtCd;
	}
	public void setPdSgmtCd(String pdSgmtCd) {
		this.pdSgmtCd = pdSgmtCd;
	}
	public String getLgdSgmtCd() {
		return lgdSgmtCd;
	}
	public void setLgdSgmtCd(String lgdSgmtCd) {
		this.lgdSgmtCd = lgdSgmtCd;
	}
	public String getIndvTrevYn() {
		return indvTrevYn;
	}
	public void setIndvTrevYn(String indvTrevYn) {
		this.indvTrevYn = indvTrevYn;
	}
	public String getOtinOvrdYn() {
		return otinOvrdYn;
	}
	public void setOtinOvrdYn(String otinOvrdYn) {
		this.otinOvrdYn = otinOvrdYn;
	}
	public String getLoanDt() {
		return loanDt;
	}
	public void setLoanDt(String loanDt) {
		this.loanDt = loanDt;
	}
	public String getExprDt() {
		return exprDt;
	}
	public void setExprDt(String exprDt) {
		this.exprDt = exprDt;
	}
	public String getAsqlClcd() {
		return asqlClcd;
	}
	public void setAsqlClcd(String asqlClcd) {
		this.asqlClcd = asqlClcd;
	}
	public String getTrgtValdtnCd() {
		return trgtValdtnCd;
	}
	public void setTrgtValdtnCd(String trgtValdtnCd) {
		this.trgtValdtnCd = trgtValdtnCd;
	}
	public String getIdvdCorpDvcdNm() {
		return idvdCorpDvcdNm;
	}
	public void setIdvdCorpDvcdNm(String idvdCorpDvcdNm) {
		this.idvdCorpDvcdNm = idvdCorpDvcdNm;
	}
	public String getPdSgmtNm() {
		return pdSgmtNm;
	}
	public void setPdSgmtNm(String pdSgmtNm) {
		this.pdSgmtNm = pdSgmtNm;
	}
	public String getLgdSgmtNm() {
		return lgdSgmtNm;
	}
	public void setLgdSgmtNm(String lgdSgmtNm) {
		this.lgdSgmtNm = lgdSgmtNm;
	}
	public String getLnam() {
		return lnam;
	}
	public void setLnam(String lnam) {
		this.lnam = lnam;
	}
	public String getLoanBal() {
		return loanBal;
	}
	public void setLoanBal(String loanBal) {
		this.loanBal = loanBal;
	}
	public String getLoanRt() {
		return loanRt;
	}
	public void setLoanRt(String loanRt) {
		this.loanRt = loanRt;
	}
	public String getOvrdNth() {
		return ovrdNth;
	}
	public void setOvrdNth(String ovrdNth) {
		this.ovrdNth = ovrdNth;
	}
	public String getUcinAmt() {
		return ucinAmt;
	}
	public void setUcinAmt(String ucinAmt) {
		this.ucinAmt = ucinAmt;
	}
}
