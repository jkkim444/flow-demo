/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP202002IN.java
 * @brief LGD 관리 IN
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

import com.encocns.ip.dto.IP202001DTO;

/**
 * @brief LGD 관리 management IN
 * @details LGD 관리 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP202002IN {

	private String stdrYm;                  /* 기준년월 */
    private String lgdSgmtCd;               /* LGDSegment코드  */
    private BigDecimal imprPntmLoanBal;     /* 손상시점대출잔액 */
    private double rate;                    /* 비율 */
    private double lgdRate;                 /* LGD비율 */

    private String jobDivCd;                /* 작업구분코드(U,I) */
	private String usrId;					/* 사용자ID */

	private List<IP202001DTO> arrGridData;	/* 그리드데이터 */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getLgdSgmtCd() {
		return lgdSgmtCd;
	}
	public void setLgdSgmtCd(String lgdSgmtCd) {
		this.lgdSgmtCd = lgdSgmtCd;
	}
	public BigDecimal getImprPntmLoanBal() {
		return imprPntmLoanBal;
	}
	public void setImprPntmLoanBal(BigDecimal imprPntmLoanBal) {
		this.imprPntmLoanBal = imprPntmLoanBal;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getLgdRate() {
		return lgdRate;
	}
	public void setLgdRate(double lgdRate) {
		this.lgdRate = lgdRate;
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
	public List<IP202001DTO> getArrGridData() {
		return arrGridData;
	}
	public void setArrGridData(List<IP202001DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
}
