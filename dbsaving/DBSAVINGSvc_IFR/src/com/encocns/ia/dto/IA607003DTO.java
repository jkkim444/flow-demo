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
public class IA607003DTO {

	private String rNum;                             /* 행번호 */
	private String baseYm;                           /* 기준년월 */
	private String adjMtrDivCd;                      /* 조정사항구분코드 */
	private BigDecimal txafAdjBllsAmt;               /* 세무조정계산서금액 */
	private BigDecimal crtxEfecAmt;                  /* 법인세효과금액 */
	private String usrId;                            /* 사용자ID */

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
	public String getAdjMtrDivCd() {
		return adjMtrDivCd;
	}
	public void setAdjMtrDivCd(String adjMtrDivCd) {
		this.adjMtrDivCd = adjMtrDivCd;
	}
	public BigDecimal getTxafAdjBllsAmt() {
		return txafAdjBllsAmt;
	}
	public void setTxafAdjBllsAmt(BigDecimal txafAdjBllsAmt) {
		this.txafAdjBllsAmt = txafAdjBllsAmt;
	}
	public BigDecimal getCrtxEfecAmt() {
		return crtxEfecAmt;
	}
	public void setCrtxEfecAmt(BigDecimal crtxEfecAmt) {
		this.crtxEfecAmt = crtxEfecAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
