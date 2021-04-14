/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP202001DTO.java
 * @brief LGD 관리 List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.dto
 * @brief Common DTO Package
 */
package com.encocns.ip.dto;

import java.math.BigDecimal;

/**
 * @brief LGD 관리 management List Query DTO
 * @details LGD 관리 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP202001DTO {

	private String rNum;
	private String stdrYm;                    /* 기준년월 */
    private String lgdSgmtCd;                 /* LGDSegment코드  */
    private BigDecimal imprPntmLoanBal;       /* 손상시점대출잔액 */
    private double rate;                      /* 비율 */
    private double lgdRate;                   /* LGD비율 */

    private String delYn;					  /* 삭제여부 */

	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
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

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

}
