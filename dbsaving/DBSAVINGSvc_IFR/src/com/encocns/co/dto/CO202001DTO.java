/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO202001DTO.java
 * @brief 화면 관리 조회 DTO
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
 * @brief 화면 관리 조회 DTO
 * @details 화면 관리 조회 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO202001DTO {

	private String bizLclsCd;                     /* 업무대분류코드 */
	private String scrId;                         /* 화면ID */
	private String lclCd;                         /* 코드 */
	private String scrNm;                         /* 화면명 */
	private String popYn;                         /* 팝업여부 */
	private String svcId;                         /* 서비스ID */
	private String rmkCntn;                       /* 비고 */

	public String getBizLclsCd() {
		return bizLclsCd;
	}
	public void setBizLclsCd(String bizLclsCd) {
		this.bizLclsCd = bizLclsCd;
	}
	public String getScrId() {
		return scrId;
	}
	public void setScrId(String scrId) {
		this.scrId = scrId;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}
	public String getScrNm() {
		return scrNm;
	}
	public void setScrNm(String scrNm) {
		this.scrNm = scrNm;
	}
	public String getPopYn() {
		return popYn;
	}
	public void setPopYn(String popYn) {
		this.popYn = popYn;
	}
	public String getSvcId() {
		return svcId;
	}
	public void setSvcId(String svcId) {
		this.svcId = svcId;
	}
	public String getRmkCntn() {
		return rmkCntn;
	}
	public void setRmkCntn(String rmkCntn) {
		this.rmkCntn = rmkCntn;
	}

}
