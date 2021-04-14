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
public class IA606001DTO {

	private String rNum;                          /* 행번호 */
	private String baseYm;                        /* 기준년월 */
	private String crtxCmpsCd;                    /* 법인세구성코드 */
	private String usrId;                         /* 사용자ID */
	private BigDecimal kgaapAmt;                  /* KGAAP금액 */
	private BigDecimal ifrsAmt;                   /* IFRS금액 */

	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getCrtxCmpsCd() {
		return crtxCmpsCd;
	}
	public void setCrtxCmpsCd(String crtxCmpsCd) {
		this.crtxCmpsCd = crtxCmpsCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public BigDecimal getKgaapAmt() {
		return kgaapAmt;
	}
	public void setKgaapAmt(BigDecimal kgaapAmt) {
		this.kgaapAmt = kgaapAmt;
	}
	public BigDecimal getIfrsAmt() {
		return ifrsAmt;
	}
	public void setIfrsAmt(BigDecimal ifrsAmt) {
		this.ifrsAmt = ifrsAmt;
	}

}
