/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501002IN.java
 * @brief IFRS 계정코드 management IN
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
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA520002IN {

	private String stdrYm;                           /* 전기년월 */
	private String lnrnDvcd;                         /* 임대차구분코드 */
	private String lnrnBrofCd;                       /* 임대차지점코드 */
	private String cntrScd;                          /* 계약상태코드 */
	private BigDecimal grmn;                         /* 보증금 */
	private String lnrnStdd;                         /* 임대차시작일자 */
	private String lnrnEndt;                         /* 임대차종료일자 */
	private String intrRt;                           /* 금리 */
	private int seqno;                               /* 일련번호 */
	private String jobDivCd;                         /* 등록수정구분코드 */
	private String usrId;                            /* 사용자ID */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getLnrnDvcd() {
		return lnrnDvcd;
	}
	public void setLnrnDvcd(String lnrnDvcd) {
		this.lnrnDvcd = lnrnDvcd;
	}
	public String getLnrnBrofCd() {
		return lnrnBrofCd;
	}
	public void setLnrnBrofCd(String lnrnBrofCd) {
		this.lnrnBrofCd = lnrnBrofCd;
	}
	public String getCntrScd() {
		return cntrScd;
	}
	public void setCntrScd(String cntrScd) {
		this.cntrScd = cntrScd;
	}
	public BigDecimal getGrmn() {
		return grmn;
	}
	public void setGrmn(BigDecimal grmn) {
		this.grmn = grmn;
	}
	public String getLnrnStdd() {
		return lnrnStdd;
	}
	public void setLnrnStdd(String lnrnStdd) {
		this.lnrnStdd = lnrnStdd;
	}
	public String getLnrnEndt() {
		return lnrnEndt;
	}
	public void setLnrnEndt(String lnrnEndt) {
		this.lnrnEndt = lnrnEndt;
	}
	public String getIntrRt() {
		return intrRt;
	}
	public void setIntrRt(String intrRt) {
		this.intrRt = intrRt;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
