/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515002DTO.java
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
public class IA516002DTO {

	private String qtrDivCd;                         /* 분기구분코드 */
	private BigDecimal qtrRetmAprpDecAmt;            /* 분기퇴직충당감소액 */
	private BigDecimal qtrInstlAsetPrvs;             /* 분기사외적립자산 지급액 */
	private BigDecimal qtrThtrWorkPmcs;              /* 분기당기근무원가 */
	private BigDecimal qtrRetmSlryRsrv;              /* 분기확정급여채무이자원가 */
	private BigDecimal qtrFrmSlryDebtChg;            /* 분기확정급여채무 변동 */
	private BigDecimal qtrInstlAsetIntEarn;          /* 분기사외적립자산이자수익 */
	private BigDecimal qtrInstlAsetChg;              /* 분기사외적립자산 변동 */

	private String usrId;                            /* 사용자ID */

	/**
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}
	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * @return the qtrDivCd
	 */
	public String getQtrDivCd() {
		return qtrDivCd;
	}
	/**
	 * @param qtrDivCd the qtrDivCd to set
	 */
	public void setQtrDivCd(String qtrDivCd) {
		this.qtrDivCd = qtrDivCd;
	}
	/**
	 * @return the qtrRetmAprpDecAmt
	 */
	public BigDecimal getQtrRetmAprpDecAmt() {
		return qtrRetmAprpDecAmt;
	}
	/**
	 * @param qtrRetmAprpDecAmt the qtrRetmAprpDecAmt to set
	 */
	public void setQtrRetmAprpDecAmt(BigDecimal qtrRetmAprpDecAmt) {
		this.qtrRetmAprpDecAmt = qtrRetmAprpDecAmt;
	}
	/**
	 * @return the qtrInstlAsetPrvs
	 */
	public BigDecimal getQtrInstlAsetPrvs() {
		return qtrInstlAsetPrvs;
	}
	/**
	 * @param qtrInstlAsetPrvs the qtrInstlAsetPrvs to set
	 */
	public void setQtrInstlAsetPrvs(BigDecimal qtrInstlAsetPrvs) {
		this.qtrInstlAsetPrvs = qtrInstlAsetPrvs;
	}
	/**
	 * @return the qtrThtrWorkPmcs
	 */
	public BigDecimal getQtrThtrWorkPmcs() {
		return qtrThtrWorkPmcs;
	}
	/**
	 * @param qtrThtrWorkPmcs the qtrThtrWorkPmcs to set
	 */
	public void setQtrThtrWorkPmcs(BigDecimal qtrThtrWorkPmcs) {
		this.qtrThtrWorkPmcs = qtrThtrWorkPmcs;
	}
	/**
	 * @return the qtrRetmSlryRsrv
	 */
	public BigDecimal getQtrRetmSlryRsrv() {
		return qtrRetmSlryRsrv;
	}
	/**
	 * @param qtrRetmSlryRsrv the qtrRetmSlryRsrv to set
	 */
	public void setQtrRetmSlryRsrv(BigDecimal qtrRetmSlryRsrv) {
		this.qtrRetmSlryRsrv = qtrRetmSlryRsrv;
	}
	/**
	 * @return the qtrFrmSlryDebtChg
	 */
	public BigDecimal getQtrFrmSlryDebtChg() {
		return qtrFrmSlryDebtChg;
	}
	/**
	 * @param qtrFrmSlryDebtChg the qtrFrmSlryDebtChg to set
	 */
	public void setQtrFrmSlryDebtChg(BigDecimal qtrFrmSlryDebtChg) {
		this.qtrFrmSlryDebtChg = qtrFrmSlryDebtChg;
	}
	/**
	 * @return the qtrInstlAsetIntEarn
	 */
	public BigDecimal getQtrInstlAsetIntEarn() {
		return qtrInstlAsetIntEarn;
	}
	/**
	 * @param qtrInstlAsetIntEarn the qtrInstlAsetIntEarn to set
	 */
	public void setQtrInstlAsetIntEarn(BigDecimal qtrInstlAsetIntEarn) {
		this.qtrInstlAsetIntEarn = qtrInstlAsetIntEarn;
	}
	/**
	 * @return the qtrInstlAsetChg
	 */
	public BigDecimal getQtrInstlAsetChg() {
		return qtrInstlAsetChg;
	}
	/**
	 * @param qtrInstlAsetChg the qtrInstlAsetChg to set
	 */
	public void setQtrInstlAsetChg(BigDecimal qtrInstlAsetChg) {
		this.qtrInstlAsetChg = qtrInstlAsetChg;
	}





}
