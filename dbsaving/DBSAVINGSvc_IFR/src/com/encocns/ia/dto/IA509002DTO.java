/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA508001DTO.java
 * @brief 연결자본변동표관리 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 연결자본변동표관리 management List Query DTO
 * @details 연결자본변동표관리 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA509002DTO {

	private String accNm;                            /* 계정명     */
	private BigDecimal thtmAmt;                      /* 당기금액 */
	private BigDecimal thtmAmt1;                     /* 당기금액1 */
	private BigDecimal bftrmAmt;                     /* 전기금액 */
	private BigDecimal bftrmAmt1;                    /* 전기금액1 */
	/**
	 * @return the accNm
	 */
	public String getAccNm() {
		return accNm;
	}
	/**
	 * @param accNm the accNm to set
	 */
	public void setAccNm(String accNm) {
		this.accNm = accNm;
	}
	/**
	 * @return the thtmAmt
	 */
	public BigDecimal getThtmAmt() {
		return thtmAmt;
	}
	/**
	 * @param thtmAmt the thtmAmt to set
	 */
	public void setThtmAmt(BigDecimal thtmAmt) {
		this.thtmAmt = thtmAmt;
	}
	/**
	 * @return the thtmAmt1
	 */
	public BigDecimal getThtmAmt1() {
		return thtmAmt1;
	}
	/**
	 * @param thtmAmt1 the thtmAmt1 to set
	 */
	public void setThtmAmt1(BigDecimal thtmAmt1) {
		this.thtmAmt1 = thtmAmt1;
	}
	/**
	 * @return the bftrmAmt
	 */
	public BigDecimal getBftrmAmt() {
		return bftrmAmt;
	}
	/**
	 * @param bftrmAmt the bftrmAmt to set
	 */
	public void setBftrmAmt(BigDecimal bftrmAmt) {
		this.bftrmAmt = bftrmAmt;
	}
	/**
	 * @return the bftrmAmt1
	 */
	public BigDecimal getBftrmAmt1() {
		return bftrmAmt1;
	}
	/**
	 * @param bftrmAmt1 the bftrmAmt1 to set
	 */
	public void setBftrmAmt1(BigDecimal bftrmAmt1) {
		this.bftrmAmt1 = bftrmAmt1;
	}

}
