/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA501001IN.java
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
public class IA607001IN {

	private String baseYm;                           /* 기준년도 */
	private String qtrDivCd;                         /* 분기구분코드 */
	private BigDecimal crtxCostAmt; 				 /* 구간별 산출세액 합계 */

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getQtrDivCd() {
		return qtrDivCd;
	}
	public void setQtrDivCd(String qtrDivCd) {
		this.qtrDivCd = qtrDivCd;
	}
	public BigDecimal getCrtxCostAmt() {
		return crtxCostAmt;
	}
	public void setCrtxCostAmt(BigDecimal crtxCostAmt) {
		this.crtxCostAmt = crtxCostAmt;
	}

}
