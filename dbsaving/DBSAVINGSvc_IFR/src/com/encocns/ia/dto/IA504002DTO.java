/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA504002DTO.java
 * @brief 재무상태표 산출 management List Query DTO
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
 * @brief 재무상태표 산출 management List Query DTO
 * @details 재무상태표 산출 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA504002DTO {

	private String lvelIfrsAccNm;                    /* 레벨IFRS계정명 */
	private BigDecimal accAmt;                       /* 계정금액 */

	/**
	 * @return the lvelIfrsAccNm
	 */
	public String getLvelIfrsAccNm() {
		return lvelIfrsAccNm;
	}
	/**
	 * @param lvelIfrsAccNm the lvelIfrsAccNm to set
	 */
	public void setLvelIfrsAccNm(String lvelIfrsAccNm) {
		this.lvelIfrsAccNm = lvelIfrsAccNm;
	}
	/**
	 * @return the accAmt
	 */
	public BigDecimal getAccAmt() {
		return accAmt;
	}
	/**
	 * @param accAmt the accAmt to set
	 */
	public void setAccAmt(BigDecimal accAmt) {
		this.accAmt = accAmt;
	}




}
