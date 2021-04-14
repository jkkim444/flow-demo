/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW103001IN.java
 * @brief Batch Operation Status IN
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 22. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

/**
 * @brief Batch Operation Status IN
 * @details Batch Operation Status IN
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 22.
 * @version : 1.0.0
 */
public class FW103001IN {

	private String grpId;                         /* 그룹ID */
	private String grpInsId;                      /* 그룹등록ID */
	private String batId;                         /* 배치ID */
	private String batNm;                         /* 배치명 */
	private String jobStatus;                     /* job상태 */
	private String batStDt;                       /* 배치시작일자 */
	private String batEdDt;                       /* 배치종료일자 */

    public String getGrpId() {
        return grpId;
    }
    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }
    public String getGrpInsId() {
        return grpInsId;
    }
    public void setGrpInsId(String grpInsId) {
        this.grpInsId = grpInsId;
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

}
