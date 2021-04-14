/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW101001DTO.java
 * @brief Service Management List Query DTO
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 6. 20. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dto
 * @brief Common DTO Package
 */
package com.encocns.fw.dto;

/**
 * @brief Service Management List Query DTO
 * @details Service Management List Query DTO
 * @author : CHA, SANG-GIL
 * @date : 2019. 6. 20.
 * @version : 1.0.0
 */
public class FW101001DTO {

	private String bizLclsCd;                     /* 업무구분코드 */
	private String svcId;                         /* 서비스ID */
	private String mthId;                         /* 메소드ID */
	private String lclCd;                         /* 번역코드 */
	private String mthNm;                         /* 메소드명 */
	private String svcPathCntn;                   /* 서비스경로 */
	private String isvoPathCntn;                  /* ISVO경로 */
	private String osvoPathCntn;                  /* OSVO경로 */
	private String rmkCntn;                       /* 비고 */

	public String getBizLclsCd() {
		return bizLclsCd;
	}
	public void setBizLclsCd(String bizLclsCd) {
		this.bizLclsCd = bizLclsCd;
	}
	public String getSvcId() {
		return svcId;
	}
	public void setSvcId(String svcId) {
		this.svcId = svcId;
	}
	public String getMthId() {
		return mthId;
	}
	public void setMthId(String mthId) {
		this.mthId = mthId;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}
	public String getMthNm() {
		return mthNm;
	}
	public void setMthNm(String mthNm) {
		this.mthNm = mthNm;
	}
	public String getSvcPathCntn() {
		return svcPathCntn;
	}
	public void setSvcPathCntn(String svcPathCntn) {
		this.svcPathCntn = svcPathCntn;
	}
	public String getIsvoPathCntn() {
		return isvoPathCntn;
	}
	public void setIsvoPathCntn(String isvoPathCntn) {
		this.isvoPathCntn = isvoPathCntn;
	}
	public String getOsvoPathCntn() {
		return osvoPathCntn;
	}
	public void setOsvoPathCntn(String osvoPathCntn) {
		this.osvoPathCntn = osvoPathCntn;
	}
	public String getRmkCntn() {
		return rmkCntn;
	}
	public void setRmkCntn(String rmkCntn) {
		this.rmkCntn = rmkCntn;
	}

}
