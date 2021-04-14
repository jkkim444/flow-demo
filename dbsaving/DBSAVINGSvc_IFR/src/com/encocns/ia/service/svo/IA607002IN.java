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
import java.util.List;

import com.encocns.ia.dto.IA607001DTO;
import com.encocns.ia.dto.IA607003DTO;

/**
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA607002IN {

	private List<IA607001DTO> arrList1;              /* 구간별계산 내용 */
	private List<IA607003DTO> arrList2;              /* 법인세효과 내용 */
	private String baseYm;                           /* 기준년도 */
	private BigDecimal aplyTxrt;                     /* 적용세율 */
	private BigDecimal crtxCostAmt;                  /* 법인세비용금액 */
	private String usrId;                            /* 사용자ID */

	public List<IA607001DTO> getArrList1() {
		return arrList1;
	}
	public void setArrList1(List<IA607001DTO> arrList1) {
		this.arrList1 = arrList1;
	}
	public List<IA607003DTO> getArrList2() {
		return arrList2;
	}
	public void setArrList2(List<IA607003DTO> arrList2) {
		this.arrList2 = arrList2;
	}
	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public BigDecimal getAplyTxrt() {
		return aplyTxrt;
	}
	public void setAplyTxrt(BigDecimal aplyTxrt) {
		this.aplyTxrt = aplyTxrt;
	}
	public BigDecimal getCrtxCostAmt() {
		return crtxCostAmt;
	}
	public void setCrtxCostAmt(BigDecimal crtxCostAmt) {
		this.crtxCostAmt = crtxCostAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
