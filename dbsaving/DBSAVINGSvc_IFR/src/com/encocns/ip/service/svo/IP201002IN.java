/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP201002IN.java
 * @brief F/L반영 PD관리 IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

/**
 * @brief F/L반영 PD관리 management IN
 * @details F/L반영 PD관리 management IN
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
public class IP201002IN {

	private String stdrYm;                  /* 기준년월 */
	private String pdSgmtCd;                /* PDSGMT코드 */
    private String pdSgmtCdNth;             /* PDSegment명 */
	private int nth;                        /* 회차 */
	private double pdRate1;                 /* PD비율1 */
	private double pdRate2;                 /* PD비율2 */
	private double pdRate3;                 /* PD비율3 */
	private double pdRate4;                 /* PD비율4 */
	private double pdRate5;                 /* PD비율5 */
	private String jobDivCd;                /* 작업구분코드(U,I) */

	private String usrId;					/* 사용자ID */

	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getPdSgmtCd() {
		return pdSgmtCd;
	}
	public void setPdSgmtCd(String pdSgmtCd) {
		this.pdSgmtCd = pdSgmtCd;
	}
	public int getNth() {
		return nth;
	}
	public void setNth(int nth) {
		this.nth = nth;
	}
	public double getPdRate1() {
		return pdRate1;
	}
	public void setPdRate1(double pdRate1) {
		this.pdRate1 = pdRate1;
	}
	public double getPdRate2() {
		return pdRate2;
	}
	public void setPdRate2(double pdRate2) {
		this.pdRate2 = pdRate2;
	}
	public double getPdRate3() {
		return pdRate3;
	}
	public void setPdRate3(double pdRate3) {
		this.pdRate3 = pdRate3;
	}
	public double getPdRate4() {
		return pdRate4;
	}
	public void setPdRate4(double pdRate4) {
		this.pdRate4 = pdRate4;
	}
	public double getPdRate5() {
		return pdRate5;
	}
	public void setPdRate5(double pdRate5) {
		this.pdRate5 = pdRate5;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getPdSgmtCdNth() {
		return pdSgmtCdNth;
	}
	public void setPdSgmtCdNth(String pdSgmtCdNth) {
		this.pdSgmtCdNth = pdSgmtCdNth;
	}
}
