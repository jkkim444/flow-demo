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
public class IA607002DTO {

	private String aplyTxrt;                         /* 적용세율 */
	private BigDecimal crtxCostAmt;                  /* 법인세비용금액 */
	private BigDecimal ntprAmt;                      /* 적용세율금액 */
	private BigDecimal lnknIfrsAccAmt;               /* 연결IFRS계정금액 */

	public String getAplyTxrt() {
		return aplyTxrt;
	}
	public void setAplyTxrt(String aplyTxrt) {
		this.aplyTxrt = aplyTxrt;
	}
	public BigDecimal getCrtxCostAmt() {
		return crtxCostAmt;
	}
	public void setCrtxCostAmt(BigDecimal crtxCostAmt) {
		this.crtxCostAmt = crtxCostAmt;
	}
	public BigDecimal getNtprAmt() {
		return ntprAmt;
	}
	public void setNtprAmt(BigDecimal ntprAmt) {
		this.ntprAmt = ntprAmt;
	}
	public BigDecimal getLnknIfrsAccAmt() {
		return lnknIfrsAccAmt;
	}
	public void setLnknIfrsAccAmt(BigDecimal lnknIfrsAccAmt) {
		this.lnknIfrsAccAmt = lnknIfrsAccAmt;
	}
}
