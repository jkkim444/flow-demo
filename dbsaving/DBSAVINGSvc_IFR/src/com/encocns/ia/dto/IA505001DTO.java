/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA505001DTO.java
 * @brief 재무상태표 조회 management List Query DTO
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
 * @brief 재무상태표 조회 management List Query DTO
 * @details 재무상태표 조회 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA505001DTO {

	private String ifrsAccCd;				         /* 계정코드 */
	private String lvelIfrsAccNm;                    /* 레벨계정코드명 */
	private BigDecimal thtrAccAmt;                   /* 당기금액 */
	private BigDecimal frtrAccAmt;                   /* 전기금액 */

	private String rNum;

	public String getIfrsAccCd() {
		return ifrsAccCd;
	}

	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}

	public String getLvelIfrsAccNm() {
		return lvelIfrsAccNm;
	}

	public void setLvelIfrsAccNm(String lvelIfrsAccNm) {
		this.lvelIfrsAccNm = lvelIfrsAccNm;
	}

	public BigDecimal getThtrAccAmt() {
		return thtrAccAmt;
	}

	public void setThtrAccAmt(BigDecimal thtrAccAmt) {
		this.thtrAccAmt = thtrAccAmt;
	}

	public BigDecimal getFrtrAccAmt() {
		return frtrAccAmt;
	}

	public void setFrtrAccAmt(BigDecimal frtrAccAmt) {
		this.frtrAccAmt = frtrAccAmt;
	}

	public String getrNum() {
		return rNum;
	}

	public void setrNum(String rNum) {
		this.rNum = rNum;
	}






}
