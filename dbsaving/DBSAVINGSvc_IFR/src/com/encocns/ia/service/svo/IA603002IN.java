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
public class IA603002IN {

	private String baseYm;                        /* 기준년도 */
	private String itgastDivCd;                   /* 무형자산구분코드 */
	private String asetCd;                        /* 자산코드 */
	private String asetNm;                        /* 자산명 */
	private String acqsDt;                        /* 취득일자 */
	private BigDecimal acqsPmcs;                  /* 취득원가 */
	private BigDecimal thtrAcqsAmt;               /* 당기취득금액 */
	private BigDecimal thtrDspslAmt;              /* 당기처분금액 */
	private BigDecimal thtrImprAmt;               /* 당기손상금액 */
	private BigDecimal imprLdqCmtlAmt;            /* 손상차손누계액 */
	private BigDecimal thtrDprcAmt;               /* 당기상각금액 */
	private BigDecimal deprcCmtlAmt;              /* 감가상각누계액 */
	private String usrId;                         /* 사용자ID */

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getItgastDivCd() {
		return itgastDivCd;
	}
	public void setItgastDivCd(String itgastDivCd) {
		this.itgastDivCd = itgastDivCd;
	}
	public String getAsetCd() {
		return asetCd;
	}
	public void setAsetCd(String asetCd) {
		this.asetCd = asetCd;
	}
	public String getAsetNm() {
		return asetNm;
	}
	public void setAsetNm(String asetNm) {
		this.asetNm = asetNm;
	}
	public String getAcqsDt() {
		return acqsDt;
	}
	public void setAcqsDt(String acqsDt) {
		this.acqsDt = acqsDt;
	}
	public BigDecimal getAcqsPmcs() {
		return acqsPmcs;
	}
	public void setAcqsPmcs(BigDecimal acqsPmcs) {
		this.acqsPmcs = acqsPmcs;
	}
	public BigDecimal getThtrAcqsAmt() {
		return thtrAcqsAmt;
	}
	public void setThtrAcqsAmt(BigDecimal thtrAcqsAmt) {
		this.thtrAcqsAmt = thtrAcqsAmt;
	}
	public BigDecimal getThtrDspslAmt() {
		return thtrDspslAmt;
	}
	public void setThtrDspslAmt(BigDecimal thtrDspslAmt) {
		this.thtrDspslAmt = thtrDspslAmt;
	}
	public BigDecimal getThtrImprAmt() {
		return thtrImprAmt;
	}
	public void setThtrImprAmt(BigDecimal thtrImprAmt) {
		this.thtrImprAmt = thtrImprAmt;
	}
	public BigDecimal getImprLdqCmtlAmt() {
		return imprLdqCmtlAmt;
	}
	public void setImprLdqCmtlAmt(BigDecimal imprLdqCmtlAmt) {
		this.imprLdqCmtlAmt = imprLdqCmtlAmt;
	}
	public BigDecimal getThtrDprcAmt() {
		return thtrDprcAmt;
	}
	public void setThtrDprcAmt(BigDecimal thtrDprcAmt) {
		this.thtrDprcAmt = thtrDprcAmt;
	}
	public BigDecimal getDeprcCmtlAmt() {
		return deprcCmtlAmt;
	}
	public void setDeprcCmtlAmt(BigDecimal deprcCmtlAmt) {
		this.deprcCmtlAmt = deprcCmtlAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
