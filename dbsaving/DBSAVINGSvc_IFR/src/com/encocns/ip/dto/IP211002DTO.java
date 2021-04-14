/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP211002DTO.java
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

/**
 * @brief 대손충당금 집계내역 management List Query DTO
 * @details 대손충당금 집계내역 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP211002DTO {

	private String stdrYm;                 /* 기준년월 */
	private String loanAcno;               /* 계좌번호 */
    private String cstno;                  /* 고객번호 */
    private String custNm;                 /* 고객명 */
    private String idvdCorpDvcd;           /* 개인기업구분코드 */
    private String gdsNm;                  /* 상품명 */
    private String pdSgmtCd;               /* PDSegment코드 */
    private String lgdSgmtCd;              /* LGDSegment코드 */
    private String indvTrevYn;             /* 개별평가대상여부 */
    private String otinOvrdYn;             /* 타기관연체여부 */
    private String loanDt;                 /* 대출일자 */
    private String exprDt;                 /* 만기일자 */
    private String lnam;                   /* 대출금액 */
    private String loanBal;                /* 대출잔액 */
    private String loanRt;                 /* 대출이율 */
    private String ovrdNth;                /* 회차 */
    private String ucinAmt;                /* 미수이자 */
    private String asqlClcd;               /* 자산건전성분류코드 */
    private String trgtValdtnCd;           /* 대상검증코드 */
    private String fxblYn;                 /* 고정이하여부 */
    private String loanBalHmw5ExcsYn;      /* 대출잔액5억초과여부 */
    private String ovrdTi4AbvYn;           /* 연체4회이상여부 */
    private String sunlSbrpYn;             /* 햇살론대위번제여부 */
    private String nplTrgtYn;              /* NPL대상여부 */
    private String sunlEsloYnRcost;        /* 햇살론추정손실여부 */
    private String stgClcd;                /* STAGE분류코드 */
    private String mn12Pd;                 /* 12개월PD */
    private String ltPd;                   /* LifetimePD */
    private String lgdRate;                /* LGD비율 */
    private String adjLgdRate;             /* 조정LGD비율 */
    private String mtpr;                   /* 담보가액 */
    private String mrtgExcsAmt;            /* 담보초과금액 */
    private String ead;                    /* EAD */
    private String lsrsrv;                 /* 대손충당금 */
    private String ucinRsrv;               /* 미수이자충당금 */
    private String idvdCorpDvcdNm;         /* 개인기업구분명 */
    private String pdSgmtNm;               /* PDSegment코드명 */
    private String lgdSgmtNm;              /* LGDSegment코드명 */

    private String delYn;				   /* 삭제여부 */

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
	public String getFxblYn() {
		return fxblYn;
	}
	public void setFxblYn(String fxblYn) {
		this.fxblYn = fxblYn;
	}
	public String getLoanBalHmw5ExcsYn() {
		return loanBalHmw5ExcsYn;
	}
	public void setLoanBalHmw5ExcsYn(String loanBalHmw5ExcsYn) {
		this.loanBalHmw5ExcsYn = loanBalHmw5ExcsYn;
	}
	public String getOvrdTi4AbvYn() {
		return ovrdTi4AbvYn;
	}
	public void setOvrdTi4AbvYn(String ovrdTi4AbvYn) {
		this.ovrdTi4AbvYn = ovrdTi4AbvYn;
	}
	public String getSunlSbrpYn() {
		return sunlSbrpYn;
	}
	public void setSunlSbrpYn(String sunlSbrpYn) {
		this.sunlSbrpYn = sunlSbrpYn;
	}
	public String getNplTrgtYn() {
		return nplTrgtYn;
	}
	public void setNplTrgtYn(String nplTrgtYn) {
		this.nplTrgtYn = nplTrgtYn;
	}
	public String getSunlEsloYnRcost() {
		return sunlEsloYnRcost;
	}
	public void setSunlEsloYnRcost(String sunlEsloYnRcost) {
		this.sunlEsloYnRcost = sunlEsloYnRcost;
	}
	public String getStgClcd() {
		return stgClcd;
	}
	public void setStgClcd(String stgClcd) {
		this.stgClcd = stgClcd;
	}
	public String getMn12Pd() {
		return mn12Pd;
	}
	public void setMn12Pd(String mn12Pd) {
		this.mn12Pd = mn12Pd;
	}
	public String getLtPd() {
		return ltPd;
	}
	public void setLtPd(String ltPd) {
		this.ltPd = ltPd;
	}
	public String getLgdRate() {
		return lgdRate;
	}
	public void setLgdRate(String lgdRate) {
		this.lgdRate = lgdRate;
	}
	public String getAdjLgdRate() {
		return adjLgdRate;
	}
	public void setAdjLgdRate(String adjLgdRate) {
		this.adjLgdRate = adjLgdRate;
	}
	public String getMtpr() {
		return mtpr;
	}
	public void setMtpr(String mtpr) {
		this.mtpr = mtpr;
	}
	public String getMrtgExcsAmt() {
		return mrtgExcsAmt;
	}
	public void setMrtgExcsAmt(String mrtgExcsAmt) {
		this.mrtgExcsAmt = mrtgExcsAmt;
	}
	public String getEad() {
		return ead;
	}
	public void setEad(String ead) {
		this.ead = ead;
	}
	public String getLsrsrv() {
		return lsrsrv;
	}
	public void setLsrsrv(String lsrsrv) {
		this.lsrsrv = lsrsrv;
	}
	public String getUcinRsrv() {
		return ucinRsrv;
	}
	public void setUcinRsrv(String ucinRsrv) {
		this.ucinRsrv = ucinRsrv;
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
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
