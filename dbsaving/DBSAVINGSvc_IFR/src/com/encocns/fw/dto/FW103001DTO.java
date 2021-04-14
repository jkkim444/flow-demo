/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW103001DTO.java
 * @brief Batch Operation Status List Query DTO
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 22. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dto
 * @brief Common DTO Package
 */
package com.encocns.fw.dto;

/**
 * @brief Batch Operation Status List Query DTO
 * @details Batch Operation Status List Query DTO
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 22.
 * @version : 1.0.0
 */
public class FW103001DTO {

	private String jobExecutionId;                   /* job실행ID */
	private String grpId;                            /* 그룹ID */
	private String grpNm;                            /* 그룹명 */
	private String grpInstanceId;                    /* 그룹인스턴스ID */
	private int excSeq;                              /* 실행일변번호 */
	private String bizLclsCd;                        /* 업무구분코드 */
	private String batId;                            /* 배치ID */
	private String batNm;                            /* 배치명 */
	private String jobStatus;                        /* job상태 */
	private String batStDt;                          /* 배치시작일자 */
	private String batEdDt;                          /* 배치종료일자 */
	private String jobParam;                         /* jobParam */

	public String getJobExecutionId() {
		return jobExecutionId;
	}
	public void setJobExecutionId(String jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}
	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public String getGrpNm() {
		return grpNm;
	}
	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}
	public String getGrpInstanceId() {
		return grpInstanceId;
	}
	public void setGrpInstanceId(String grpInstanceId) {
		this.grpInstanceId = grpInstanceId;
	}
	public int getExcSeq() {
		return excSeq;
	}
	public void setExcSeq(int excSeq) {
		this.excSeq = excSeq;
	}
	public String getBizLclsCd() {
		return bizLclsCd;
	}
	public void setBizLclsCd(String bizLclsCd) {
		this.bizLclsCd = bizLclsCd;
	}
	public String getBatId() {
		return batId;
	}
	public void setBatId(String batId) {
		this.batId = batId;
	}
	public String getBatNm() {
		return batNm;
	}
	public void setBatNm(String batNm) {
		this.batNm = batNm;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getBatStDt() {
		return batStDt;
	}
	public void setBatStDt(String batStDt) {
		this.batStDt = batStDt;
	}
	public String getBatEdDt() {
		return batEdDt;
	}
	public void setBatEdDt(String batEdDt) {
		this.batEdDt = batEdDt;
	}
	public String getJobParam() {
		return jobParam;
	}
	public void setJobParam(String jobParam) {
		this.jobParam = jobParam;
	}

}
