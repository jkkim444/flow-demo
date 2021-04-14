/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO301001DTO.java
 * @brief 공통 코드 도메인 DTO
 * @section Major History
 * <pre>
 *   - 차상길 | 2019. 6. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 공통 코드 도메인 DTO
 * @details 공통 코드 도메인 DTO
 * @author : 차상길
 * @date : 2019. 6. 10.
 * @version : 1.0.0
 */
public class CO301001DTO {

	private String cdDmnId;                       /* 도메인코드 */
	private String lclCd;                         /* 번역코드 */
	private String cdDmnNm;                       /* 도메인명 */
	private String sysCdYn;                       /* 코드 */
	private String delYn;                         /* 삭제여부 */
	private String rmkCntn;                       /* 비고 */

	public String getCdDmnId() {
		return cdDmnId;
	}
	public void setCdDmnId(String cdDmnId) {
		this.cdDmnId = cdDmnId;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}
	public String getCdDmnNm() {
		return cdDmnNm;
	}
	public void setCdDmnNm(String cdDmnNm) {
		this.cdDmnNm = cdDmnNm;
	}
	public String getSysCdYn() {
		return sysCdYn;
	}
	public void setSysCdYn(String sysCdYn) {
		this.sysCdYn = sysCdYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getRmkCntn() {
		return rmkCntn;
	}
	public void setRmkCntn(String rmkCntn) {
		this.rmkCntn = rmkCntn;
	}

}
