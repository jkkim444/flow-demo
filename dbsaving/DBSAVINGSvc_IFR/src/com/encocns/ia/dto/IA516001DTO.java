/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515001DTO.java
 * @brief 퇴직금 지급 현황 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 14. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 퇴직금 지급 현황 management List Query DTO
 * @details 퇴직금 지급 현황 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
public class IA516001DTO {

	private String stdrYm;                        /* 기준일자 */
	private String qtrDivCd;                      /* 분기구분코드 */
	private BigDecimal yrThtrWorkPmcs;            /* 년도당기근무원가 */
	private BigDecimal yrRetmSlryRsrv;            /* 년도확정급여채무이자원가 */
	private BigDecimal yrInstlAsetIntEarn;        /* 년도사외적립자산이자수익 */
	private BigDecimal yrFrmRetmSlry;             /* 년도확정기여형퇴직급여 */
	private BigDecimal qtrRetmAprpDecAmt;         /* 분기퇴직충당감소액 */
	private BigDecimal qtrThtrWorkPmcs;           /* 분기당기근무원가 */
	private BigDecimal qtrRetmSlryRsrv;           /* 분기확정급여채무이자원가 */
	private BigDecimal qtrInstlAsetIntEarn;       /* 분기사외적립자산이자수익 */
	private BigDecimal qtrInstlAsetPrvs;          /* 분기사외적립자산 지급액 */
	private BigDecimal qtrFrmSlryDebtChg;         /* 분기확정급여채무 변동 */
	private BigDecimal qtrInstlAsetChg;           /* 분기사외적립자산 변동 */
	private String usrId;          				  /* 사용자ID */
	private String rNum;           				  /* 행번호 */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getQtrDivCd() {
		return qtrDivCd;
	}
	public void setQtrDivCd(String qtrDivCd) {
		this.qtrDivCd = qtrDivCd;
	}
	public BigDecimal getYrThtrWorkPmcs() {
		return yrThtrWorkPmcs;
	}
	public void setYrThtrWorkPmcs(BigDecimal yrThtrWorkPmcs) {
		this.yrThtrWorkPmcs = yrThtrWorkPmcs;
	}
	public BigDecimal getYrRetmSlryRsrv() {
		return yrRetmSlryRsrv;
	}
	public void setYrRetmSlryRsrv(BigDecimal yrRetmSlryRsrv) {
		this.yrRetmSlryRsrv = yrRetmSlryRsrv;
	}
	public BigDecimal getYrInstlAsetIntEarn() {
		return yrInstlAsetIntEarn;
	}
	public void setYrInstlAsetIntEarn(BigDecimal yrInstlAsetIntEarn) {
		this.yrInstlAsetIntEarn = yrInstlAsetIntEarn;
	}
	public BigDecimal getYrFrmRetmSlry() {
		return yrFrmRetmSlry;
	}
	public void setYrFrmRetmSlry(BigDecimal yrFrmRetmSlry) {
		this.yrFrmRetmSlry = yrFrmRetmSlry;
	}
	public BigDecimal getQtrRetmAprpDecAmt() {
		return qtrRetmAprpDecAmt;
	}
	public void setQtrRetmAprpDecAmt(BigDecimal qtrRetmAprpDecAmt) {
		this.qtrRetmAprpDecAmt = qtrRetmAprpDecAmt;
	}
	public BigDecimal getQtrThtrWorkPmcs() {
		return qtrThtrWorkPmcs;
	}
	public void setQtrThtrWorkPmcs(BigDecimal qtrThtrWorkPmcs) {
		this.qtrThtrWorkPmcs = qtrThtrWorkPmcs;
	}
	public BigDecimal getQtrRetmSlryRsrv() {
		return qtrRetmSlryRsrv;
	}
	public void setQtrRetmSlryRsrv(BigDecimal qtrRetmSlryRsrv) {
		this.qtrRetmSlryRsrv = qtrRetmSlryRsrv;
	}
	public BigDecimal getQtrInstlAsetIntEarn() {
		return qtrInstlAsetIntEarn;
	}
	public void setQtrInstlAsetIntEarn(BigDecimal qtrInstlAsetIntEarn) {
		this.qtrInstlAsetIntEarn = qtrInstlAsetIntEarn;
	}
	public BigDecimal getQtrInstlAsetPrvs() {
		return qtrInstlAsetPrvs;
	}
	public void setQtrInstlAsetPrvs(BigDecimal qtrInstlAsetPrvs) {
		this.qtrInstlAsetPrvs = qtrInstlAsetPrvs;
	}
	public BigDecimal getQtrFrmSlryDebtChg() {
		return qtrFrmSlryDebtChg;
	}
	public void setQtrFrmSlryDebtChg(BigDecimal qtrFrmSlryDebtChg) {
		this.qtrFrmSlryDebtChg = qtrFrmSlryDebtChg;
	}
	public BigDecimal getQtrInstlAsetChg() {
		return qtrInstlAsetChg;
	}
	public void setQtrInstlAsetChg(BigDecimal qtrInstlAsetChg) {
		this.qtrInstlAsetChg = qtrInstlAsetChg;
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
