/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP205001DTO.java
 * @brief 예치금대손충당금 기본 List Query DTO
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

import java.math.BigDecimal;

/**
 * @brief 예치금대손충당금 기본 management List Query DTO
 * @details 예치금대손충당금 기본 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP206002DTO {


	private String stdrYm;                  /* 기준년월 */
	private String frtrYm;                  /* 전기년월 */
	private BigDecimal dprnAmt;             /* 제각금액 */
	private BigDecimal rtrvAmt;             /* 회수금액 */
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
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
