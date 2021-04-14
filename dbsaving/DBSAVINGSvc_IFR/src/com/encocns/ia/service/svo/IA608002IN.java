/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA608002IN.java
 * @brief 기타포괄손익공정가치내역 등록 및 수정IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 18. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.math.BigDecimal;

/**
 * @brief 기타포괄손익공정가치내역 등록 및 수정IN
 * @details 기타포괄손익공정가치내역 등록 및 수정IN
 * @author : 차상길
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
public class IA608002IN {

	private String baseYm;                           /* 기준년도 */
	private String searchFrtrYm;                     /* 전기년월 */
	private BigDecimal seqno;                        /* 일련번호 */
	private String asetDiv;                          /* 자산구분 */
	private String acqsDspslDivCd;                   /* 취득처분구분코드 */
	private String asetNm;                           /* 자산명 */
	private int stckCnt;                             /* 주식수 */
	private BigDecimal acqsUnprAmt;                  /* 취득단가금액 */
	private BigDecimal acqsPmcsAmt;                  /* 취득원가금액 */
	private BigDecimal baseDtUnprAmt;                /* 기준일자단가금액 */
	private BigDecimal baseDtFvAmt;                  /* 기준일자공정가치금액 */
	private BigDecimal pflsCmtlAmt;                  /* 손익누계금액 */
	private String usrId;                            /* 사용자ID */

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getSearchFrtrYm() {
		return searchFrtrYm;
	}
	public void setSearchFrtrYm(String searchFrtrYm) {
		this.searchFrtrYm = searchFrtrYm;
	}
	public BigDecimal getSeqno() {
		return seqno;
	}
	public void setSeqno(BigDecimal seqno) {
		this.seqno = seqno;
	}
	public String getAsetDiv() {
		return asetDiv;
	}
	public void setAsetDiv(String asetDiv) {
		this.asetDiv = asetDiv;
	}
	public String getAcqsDspslDivCd() {
		return acqsDspslDivCd;
	}
	public void setAcqsDspslDivCd(String acqsDspslDivCd) {
		this.acqsDspslDivCd = acqsDspslDivCd;
	}
	public String getAsetNm() {
		return asetNm;
	}
	public void setAsetNm(String asetNm) {
		this.asetNm = asetNm;
	}
	public int getStckCnt() {
		return stckCnt;
	}
	public void setStckCnt(int stckCnt) {
		this.stckCnt = stckCnt;
	}
	public BigDecimal getBaseDtUnprAmt() {
		return baseDtUnprAmt;
	}
	public BigDecimal getAcqsUnprAmt() {
		return acqsUnprAmt;
	}
	public void setAcqsUnprAmt(BigDecimal acqsUnprAmt) {
		this.acqsUnprAmt = acqsUnprAmt;
	}
	public BigDecimal getAcqsPmcsAmt() {
		return acqsPmcsAmt;
	}
	public void setAcqsPmcsAmt(BigDecimal acqsPmcsAmt) {
		this.acqsPmcsAmt = acqsPmcsAmt;
	}
	public void setBaseDtUnprAmt(BigDecimal baseDtUnprAmt) {
		this.baseDtUnprAmt = baseDtUnprAmt;
	}
	public BigDecimal getBaseDtFvAmt() {
		return baseDtFvAmt;
	}
	public void setBaseDtFvAmt(BigDecimal baseDtFvAmt) {
		this.baseDtFvAmt = baseDtFvAmt;
	}
	public BigDecimal getPflsCmtlAmt() {
		return pflsCmtlAmt;
	}
	public void setPflsCmtlAmt(BigDecimal pflsCmtlAmt) {
		this.pflsCmtlAmt = pflsCmtlAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
