/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO202002IN.java
 * @brief 화면 관리 등록 및 수정 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 화면 관리 등록 및 수정 IN
 * @details 화면 관리 등록 및 수정 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO202002IN {

	private String bizLclsCd;                     /* 업무구분코드 */
	private String scrId;                         /* 화면ID */
	private String lclCd;                         /* 코드 */
	private String scrNm;                         /* 화면명 */
	private String popYn;                         /* 팝업여부 */
	private String svcId;                         /* 서비스ID */
	private String rmkCntn;                       /* 비고 */
	private String usrId;                         /* 사용자ID */
	private String jobDivCd;                      /* 코드 */

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
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}

}
