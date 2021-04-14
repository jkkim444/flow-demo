/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA513002IN.java
 * @brief 기타유형자산 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.math.BigDecimal;

/**
 * @brief 기타유형자산 management IN
 * @details 기타유형자산 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA513002IN {

	private String stdrYm;              /* 기준년월  */
	private String brcd;                /* 부점코드 */
	private String teamCd;              /* 팀구분코드 */
	private String acno;                /* 계좌번호 */
	private String prodNm;              /* 품명 */
	private String acqsDt;              /* 취득일자 */
	private BigDecimal bkvalAmt;        /* 장부가금액 */
	private String dspslDt;             /* 처분일자 */
	private BigDecimal dspslAmt;        /* 처분금액 */
	private int seqno;                  /* 일련번호 */
	private String frtrYm;				/* 전기년월 */
	private String jobDivCd;			/* 등록수정구분코드 */
	private String usrId;				/* 사용자ID */

	public String getDspslDt() {
		return dspslDt;
	}
	public void setDspslDt(String dspslDt) {
		this.dspslDt = dspslDt;
	}
	public BigDecimal getDspslAmt() {
		return dspslAmt;
	}
	public void setDspslAmt(BigDecimal dspslAmt) {
		this.dspslAmt = dspslAmt;
	}
	public String getFrtrYm() {
		return frtrYm;
	}
	public void setFrtrYm(String frtrYm) {
		this.frtrYm = frtrYm;
	}
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
	public String getBrcd() {
		return brcd;
	}
	public void setBrcd(String brcd) {
		this.brcd = brcd;
	}
	public String getTeamCd() {
		return teamCd;
	}
	public void setTeamCd(String teamCd) {
		this.teamCd = teamCd;
	}
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	public String getProdNm() {
		return prodNm;
	}
	public void setProdNm(String prodNm) {
		this.prodNm = prodNm;
	}
	public String getAcqsDt() {
		return acqsDt;
	}
	public void setAcqsDt(String acqsDt) {
		this.acqsDt = acqsDt;
	}
	public BigDecimal getBkvalAmt() {
		return bkvalAmt;
	}
	public void setBkvalAmt(BigDecimal bkvalAmt) {
		this.bkvalAmt = bkvalAmt;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
