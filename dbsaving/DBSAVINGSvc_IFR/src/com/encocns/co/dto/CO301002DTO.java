/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO301002DTO.java
 * @brief 공통 코드 상세 DTO
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

import java.math.BigDecimal;

/**
 * @brief 공통 코드 상세 DTO
 * @details 공통 코드 상세 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO301002DTO {

	private String job;                           /* jobID */
	private String cdDmnId;                       /* 도메인 코드 */
	private String cd;                            /* 코드 */
	private String cdNm;                          /* 코드명 */
	private BigDecimal sortSeq;                   /* 일련번호 */
	private String delYn;                         /* 삭제여부 */
	private String rmkCntn;                       /* 비고 */
	private String usrId;                         /* 사용자ID */
	private String sysCdYn;                       /* 시스템코드여부 */
	private String lclCd;                         /* 번역코드 */

	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCdDmnId() {
		return cdDmnId;
	}
	public void setCdDmnId(String cdDmnId) {
		this.cdDmnId = cdDmnId;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getCdNm() {
		return cdNm;
	}
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	public BigDecimal getSortSeq() {
		return sortSeq;
	}
	public void setSortSeq(BigDecimal sortSeq) {
		this.sortSeq = sortSeq;
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
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getSysCdYn() {
		return sysCdYn;
	}
	public void setSysCdYn(String sysCdYn) {
		this.sysCdYn = sysCdYn;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}
}
