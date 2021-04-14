/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP211003DTO.java
 * @brief 대손충당금 집계내역 List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.dto
 * @brief Common DTO Package
 */
package com.encocns.ip.dto;

/**
 * @brief 대손충당금 집계내역 management List Query DTO
 * @details 대손충당금 집계내역 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */

import java.math.BigDecimal;

/**
 * @brief 대손충당금 집계내역 management List Query DTO
 * @details 대손충당금 집계내역 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP211003DTO {

	private String stdrYm;                  /* 기준년월 */
	private String frtrYm;                  /* 전기년월 */
	private BigDecimal dprnAmt;             /* 제각금액 */
	private BigDecimal rtrvAmt;             /* 회수금액 */
    private BigDecimal bfCnsdMvinAmt;       /* 고려전전입금액 */
    private BigDecimal bfCnsdRetnAmt;       /* 고려전환입금액 */
	private String usrId;					/* 사용자ID */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getFrtrYm() {
		return frtrYm;
	}
	public void setFrtrYm(String frtrYm) {
		this.frtrYm = frtrYm;
	}
	public BigDecimal getDprnAmt() {
		return dprnAmt;
	}
	public void setDprnAmt(BigDecimal dprnAmt) {
		this.dprnAmt = dprnAmt;
	}
	public BigDecimal getRtrvAmt() {
		return rtrvAmt;
	}
	public void setRtrvAmt(BigDecimal rtrvAmt) {
		this.rtrvAmt = rtrvAmt;
	}
	public BigDecimal getBfCnsdMvinAmt() {
		return bfCnsdMvinAmt;
	}
	public void setBfCnsdMvinAmt(BigDecimal bfCnsdMvinAmt) {
		this.bfCnsdMvinAmt = bfCnsdMvinAmt;
	}
	public BigDecimal getBfCnsdRetnAmt() {
		return bfCnsdRetnAmt;
	}
	public void setBfCnsdRetnAmt(BigDecimal bfCnsdRetnAmt) {
		this.bfCnsdRetnAmt = bfCnsdRetnAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
