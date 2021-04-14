/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP203001DTO.java
 * @brief NICE PD관리 List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.dto
 * @brief Common DTO Package
 */
package com.encocns.ip.dto;

/**
 * @brief NICE PD관리 management List Query DTO
 * @details NICE PD관리 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
public class IP203002DTO {

    private String crgdCd;               /* 신용등급 코드 */
    private String cd;                   /* 코드값 확인CD */
    private String delYn;				 /* 삭제여부 */

	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getCrgdCd() {
		return crgdCd;
	}
	public void setCrgdCd(String crgdCd) {
		this.crgdCd = crgdCd;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
}
