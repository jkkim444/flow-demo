/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID101101IN.java
 * @brief 공시보고서 삽입 / 수정 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.service.svo
 * @brief id SVO Package
 */
package com.encocns.id.service.svo;

/**
 * @brief 공시보고서 삽입 / 수정 IN
 * @details 공시보고서 삽입 / 수정 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID101101IN {

	private String pbnfRptId;                        /* 공시보고서ID */
	private String pbnfRptNm;                        /* 공시보고서명 */
	private String cmtLevel;                         /* 주석레벨 */
	private String mgmtUnitCd;                       /* 코드 */
	private String uprnPbnfRptId;                    /* 상위공시보고서ID */
	private int outputSer;                           /* 출력순서 */
	private String aplyStdt;                         /* 적용시작일자 */
	private String rptPbnfYn;                        /* 보고서공시여부 */
	private String aplyEndt;                         /* 적용종료일자 */
	private String rmkCtnt;                          /* 비고내용 */
	private String mnipRegYn;                        /* 수기등록여부 */
	private String usrId;                            /* 사용자ID */
	private String isCreate;                         /* 생성여부 */

	public String getRptPbnfYn() {
		return rptPbnfYn;
	}

	public void setRptPbnfYn(String rptPbnfYn) {
		this.rptPbnfYn = rptPbnfYn;
	}

	public String getIsCreate() {
		return isCreate;
	}

	public void setIsCreate(String isCreate) {
		this.isCreate = isCreate;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getPbnfRptId() {
		return pbnfRptId;
	}

	public void setPbnfRptId(String pbnfRptId) {
		this.pbnfRptId = pbnfRptId;
	}

	public String getPbnfRptNm() {
		return pbnfRptNm;
	}

	public void setPbnfRptNm(String pbnfRptNm) {
		this.pbnfRptNm = pbnfRptNm;
	}

	public String getCmtLevel() {
		return cmtLevel;
	}

	public void setCmtLevel(String cmtLevel) {
		this.cmtLevel = cmtLevel;
	}

	public String getMgmtUnitCd() {
		return mgmtUnitCd;
	}

	public void setMgmtUnitCd(String mgmtUnitCd) {
		this.mgmtUnitCd = mgmtUnitCd;
	}

	public String getUprnPbnfRptId() {
		return uprnPbnfRptId;
	}

	public void setUprnPbnfRptId(String uprnPbnfRptId) {
		this.uprnPbnfRptId = uprnPbnfRptId;
	}

	public int getOutputSer() {
		return outputSer;
	}

	public void setOutputSer(int outputSer) {
		this.outputSer = outputSer;
	}

	public String getAplyStdt() {
		return aplyStdt;
	}

	public void setAplyStdt(String aplyStdt) {
		this.aplyStdt = aplyStdt;
	}

	public String getAplyEndt() {
		return aplyEndt;
	}

	public void setAplyEndt(String aplyEndt) {
		this.aplyEndt = aplyEndt;
	}

	public String getRmkCtnt() {
		return rmkCtnt;
	}

	public void setRmkCtnt(String rmkCtnt) {
		this.rmkCtnt = rmkCtnt;
	}

	public String getMnipRegYn() {
		return mnipRegYn;
	}

	public void setMnipRegYn(String mnipRegYn) {
		this.mnipRegYn = mnipRegYn;
	}

}
