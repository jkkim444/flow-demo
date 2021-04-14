/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA607001OUT.java
 * @brief IFRS 계정코드 management OUT
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
 * @brief IFRS 계정코드 management OUT
 * @details IFRS 계정코드 management OUT
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA607001OUT {
    private List<IA607001DTO> arrList1;           /* 법인세비용구간별계산 데이터 */
    private List<IA607003DTO> arrList2;           /* 법이세효과 데이터 */
    private String aplyTxrt;                      /* 적용세율 */
	private BigDecimal crtxCostAmt;               /* 법인세비용금액 */
	private BigDecimal ntprAmt;                   /* 산출금액 */
	private BigDecimal lnknIfrsAccAmt;            /* 연결IFRS계정금액 */
    private String pbnfCtnt;                      /* 마감여부내용 */

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
	public String getPbnfCtnt() {
		return pbnfCtnt;
	}
	public void setPbnfCtnt(String pbnfCtnt) {
		this.pbnfCtnt = pbnfCtnt;
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
