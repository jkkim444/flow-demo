/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515002IN.java
 * @brief 수익용 부동산 보유 현황 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.math.BigDecimal;

/**
 * @brief 수익용 부동산 보유 현황 management IN
 * @details 수익용 부동산 보유 현황 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA521002IN {

	private String cllpNm;                           /* 물건지명 */
	private double owhsRate;                         /* 자가비율 */
	private double lentRate;                         /* 임대비율 */
	private BigDecimal lndAcqsAmt;                   /* 토지취득금액 */
	private BigDecimal lndDprcCmtlAmt;               /* 토지상각누계금액 */
	private BigDecimal bldgAcqsAmt;                  /* 건물취득금액 */
	private BigDecimal bldgDprcCmtlAmt;              /* 건물상각누계금액 */
	private String stdrYm;                           /* 기준년월 */
	private String acqsDt;                           /* 취득일자 */
	private int cllpNo;                              /* 물건지번호 */
	private String usrId;                            /* 사용자ID */

	public String getCllpNm() {
		return cllpNm;
	}
	public void setCllpNm(String cllpNm) {
		this.cllpNm = cllpNm;
	}
	public double getOwhsRate() {
		return owhsRate;
	}
	public void setOwhsRate(double owhsRate) {
		this.owhsRate = owhsRate;
	}
	public double getLentRate() {
		return lentRate;
	}
	public void setLentRate(double lentRate) {
		this.lentRate = lentRate;
	}
	public BigDecimal getLndAcqsAmt() {
		return lndAcqsAmt;
	}
	public void setLndAcqsAmt(BigDecimal lndAcqsAmt) {
		this.lndAcqsAmt = lndAcqsAmt;
	}
	public BigDecimal getLndDprcCmtlAmt() {
		return lndDprcCmtlAmt;
	}
	public void setLndDprcCmtlAmt(BigDecimal lndDprcCmtlAmt) {
		this.lndDprcCmtlAmt = lndDprcCmtlAmt;
	}
	public BigDecimal getBldgAcqsAmt() {
		return bldgAcqsAmt;
	}
	public void setBldgAcqsAmt(BigDecimal bldgAcqsAmt) {
		this.bldgAcqsAmt = bldgAcqsAmt;
	}
	public BigDecimal getBldgDprcCmtlAmt() {
		return bldgDprcCmtlAmt;
	}
	public void setBldgDprcCmtlAmt(BigDecimal bldgDprcCmtlAmt) {
		this.bldgDprcCmtlAmt = bldgDprcCmtlAmt;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getAcqsDt() {
		return acqsDt;
	}
	public void setAcqsDt(String acqsDt) {
		this.acqsDt = acqsDt;
	}
	public int getCllpNo() {
		return cllpNo;
	}
	public void setCllpNo(int cllpNo) {
		this.cllpNo = cllpNo;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
