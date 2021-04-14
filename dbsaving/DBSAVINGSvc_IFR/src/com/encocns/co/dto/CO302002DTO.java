/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO301102DTO.java
 * @brief 메시지 코드 관리 DTO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 메시지 코드 관리 DTO
 * @details 메시지 코드 관리 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO302002DTO {

    private String lclCd;           /* 번역코드 */
    private String lclSimpleNm;     /* 번역약어 */

	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}
	public String getLclSimpleNm() {
		return lclSimpleNm;
	}
	public void setLclSimpleNm(String lclSimpleNm) {
		this.lclSimpleNm = lclSimpleNm;
	}

}
