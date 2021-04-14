/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515001DTO.java
 * @brief 수익용 부동산 보유 현황 management List Query DTO
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
 * @brief 수익용 부동산 보유 현황 management List Query DTO
 * @details 수익용 부동산 보유 현황 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA603001DTO {

	private String baseYm;                        /* 기준년월 */
	private String acqsDt;                        /* 취득일자 */
	private String itgastDivCd;                   /* 무형자산구분코드 */
	private String asetCd;                        /* 자산코드 */
	private String asetNm;                        /* 자산명 */
	private BigDecimal acqsPmcs;                  /* 취득원가 */
	private BigDecimal thtrAcqsAmt;               /* 당기취득금액 */
	private BigDecimal thtrDspslAmt;              /* 당기처분금액 */
	private BigDecimal thtrImprAmt;               /* 당기손상금액 */
	private BigDecimal imprLdqCmtlAmt;            /* 손상차손누계액 */
	private BigDecimal thtrDprcAmt;               /* 당기상각금액 */
	private BigDecimal deprcCmtlAmt;              /* 감가상각누계액 */
	private String usrId;                         /* 사용자ID */
	private String rNum;                          /* 행번호 */
	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getAcqsDt() {
		return acqsDt;
	}
	public void setAcqsDt(String acqsDt) {
		this.acqsDt = acqsDt;
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
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}




}
