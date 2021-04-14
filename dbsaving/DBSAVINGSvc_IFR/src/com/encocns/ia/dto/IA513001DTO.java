/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA513001DTO.java
 * @brief 기타유형자산 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 기타유형자산 management List Query DTO
 * @details 기타유형자산 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA513001DTO {

	private String rNum;
	private String stdrYm;                    /* 기준년월  */
	private int seqno;                        /* 일련번호 */
	private String brcd;                      /* 부점코드 */
    private String teamCd;                    /* 팀구분코드 */
    private String acno;                      /* 계좌번호 */
    private String prodNm;                    /* 품명 */
    private String acqsDt;                    /* 취득일자 */
    private BigDecimal bkvalAmt;              /* 장부가금액 */
    private String dspslDt;             	  /* 처분일자 */
	private BigDecimal dspslAmt;        	  /* 처분금액 */
	private String elpsMnsCnt;                /* 경과개월수 */
	private BigDecimal dprcCmtlAmt;           /* 상각누계금액 */
	private BigDecimal afdpBal;               /* 상각후잔액 */
	private String usrId;               	  /* 사용자ID */


	/**
	 * @return the dspslDt
	 */
	public String getDspslDt() {
		return dspslDt;
	}
	/**
	 * @param dspslDt the dspslDt to set
	 */
	public void setDspslDt(String dspslDt) {
		this.dspslDt = dspslDt;
	}
	/**
	 * @return the dspslAmt
	 */
	public BigDecimal getDspslAmt() {
		return dspslAmt;
	}
	/**
	 * @param dspslAmt the dspslAmt to set
	 */
	public void setDspslAmt(BigDecimal dspslAmt) {
		this.dspslAmt = dspslAmt;
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
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
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
	public String getElpsMnsCnt() {
		return elpsMnsCnt;
	}
	public void setElpsMnsCnt(String elpsMnsCnt) {
		this.elpsMnsCnt = elpsMnsCnt;
	}
	public BigDecimal getBkvalAmt() {
		return bkvalAmt;
	}
	public void setBkvalAmt(BigDecimal bkvalAmt) {
		this.bkvalAmt = bkvalAmt;
	}
	public BigDecimal getDprcCmtlAmt() {
		return dprcCmtlAmt;
	}
	public void setDprcCmtlAmt(BigDecimal dprcCmtlAmt) {
		this.dprcCmtlAmt = dprcCmtlAmt;
	}
	public BigDecimal getAfdpBal() {
		return afdpBal;
	}
	public void setAfdpBal(BigDecimal afdpBal) {
		this.afdpBal = afdpBal;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}


}
