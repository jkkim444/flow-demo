/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP210002DTO.java
 * @brief 담보가액관리 List Query DTO
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
 * @brief 담보가액관리 management List Query DTO
 * @details 담보가액관리 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP210002DTO {

	private String stdrYm;                         /* 기준년월 */
	private String loanAcno;                       /* 대출계좌번호 */
    private BigDecimal mtpr;                       /* 담보가액 */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getLoanAcno() {
		return loanAcno;
	}
	public void setLoanAcno(String loanAcno) {
		this.loanAcno = loanAcno;
	}
	public BigDecimal getMtpr() {
		return mtpr;
	}
	public void setMtpr(BigDecimal mtpr) {
		this.mtpr = mtpr;
	}
}
