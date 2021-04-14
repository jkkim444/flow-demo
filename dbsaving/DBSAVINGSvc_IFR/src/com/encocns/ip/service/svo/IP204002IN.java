/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP204002IN.java
 * @brief 개별평가대상 기본 IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

import java.math.BigDecimal;
import java.util.List;

import com.encocns.ip.dto.IP204001DTO;

/**
 * @brief 개별평가대상 기본 management IN
 * @details 개별평가대상 기본 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP204002IN {

	private String stdrYm;                  /* 기준년월 */
	private String frtrYm;                  /* 전기년월 */
    private String loanAcno;                /* 계좌번호 */
    private BigDecimal loanBal;             /* 대출잔액 */
    private BigDecimal indvEvalRsrv;        /* 개별평가충당금 */

    private String jobDivCd;                /* 작업구분코드(U,I) */
	private String usrId;					/* 사용자ID */
	private List<IP204001DTO> arrGridData;  /* 그리드 데이터 */

	public String getFrtrYm() {
		return frtrYm;
	}
	public void setFrtrYm(String frtrYm) {
		this.frtrYm = frtrYm;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getLoanAcno() {
		return loanAcno;
	}
	public void setLoanAcno(String loanAcno) {
		this.loanAcno = loanAcno;
	}
	public BigDecimal getLoanBal() {
		return loanBal;
	}
	public void setLoanBal(BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	public BigDecimal getIndvEvalRsrv() {
		return indvEvalRsrv;
	}
	public void setIndvEvalRsrv(BigDecimal indvEvalRsrv) {
		this.indvEvalRsrv = indvEvalRsrv;
	}
	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public List<IP204001DTO> getArrGridData() {
		return arrGridData;
	}
	public void setArrGridData(List<IP204001DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
}
