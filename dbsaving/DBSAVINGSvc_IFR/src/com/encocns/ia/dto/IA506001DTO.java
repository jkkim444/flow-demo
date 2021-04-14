/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA506001DTO.java
 * @brief 포괄손익계산서 산출 management List Query DTO
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
 * @brief 포괄손익계산서 산출 management List Query DTO
 * @details 포괄손익계산서 산출 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA506001DTO {
	private String ifrsAccCd;                        /* IFRS계정코드 */
	private String lvelIfrsAccNm;                    /* 레벨IFRS계정명 */
	private BigDecimal accAmt;                       /* 계정금액 */
	private String rNum;                             /* 행번호 */

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


	public BigDecimal getAccAmt() {
		return accAmt;
	}


	public void setAccAmt(BigDecimal accAmt) {
		this.accAmt = accAmt;
	}


	public String getrNum() {
		return rNum;
	}


	public void setrNum(String rNum) {
		this.rNum = rNum;
	}



}
