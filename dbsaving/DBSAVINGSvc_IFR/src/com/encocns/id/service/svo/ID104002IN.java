/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID104002IN.java
 * @brief 보고서 산출정보 조회 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.service.svo
 * @brief id SVO Package
 */
package com.encocns.id.service.svo;

/**
 * @brief 보고서 산출정보 조회 IN
 * @details 보고서 산출정보 조회 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID104002IN {
	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private int rowNo;                               /* 로우번호 */
	private int colNo;                               /* 컬럼번호 */

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getPbnfRptId() {
		return pbnfRptId;
	}
	public void setPbnfRptId(String pbnfRptId) {
		this.pbnfRptId = pbnfRptId;
	}
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	public int getColNo() {
		return colNo;
	}
	public void setColNo(int colNo) {
		this.colNo = colNo;
	}
}
