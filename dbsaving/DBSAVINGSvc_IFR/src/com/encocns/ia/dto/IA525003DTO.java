/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA525003DTO.java
 * @brief 수익증권 합계잔액시산표 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 수익증권 합계잔액시산표 management List Query DTO
 * @details 수익증권 합계잔액시산표 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA525003DTO {

private String rNum;                          /* 행 번호 */

private String stdrYm;                        /* 전기년월 */
private String cllpNm;                        /* 물건지명 */

private BigDecimal lndAcqsAmt;                /* 토지취득금액 */
private BigDecimal lndDprcCmtlAMt;            /* 토지상각누계금액 */
private BigDecimal lndBkval;                  /* 토지장부가 */

private BigDecimal bldgAcqsAmt;               /* 건물취득금액 */
private BigDecimal bldgDprcCmtlAmt;           /* 건물상각누계금액 */
private BigDecimal bldgBkval;                 /* 건물장부가 */

private double owhsRate;                      /* 자가비율 */
private double lentRate;                      /* 임대비율 */

private String acqsDt;                        /* 취득일자 */

private BigDecimal typLndAcqsAmt;             /* 유형자산토지취득금액 */
private BigDecimal typLndDprcCmtlAmt;         /* 유형자산토지상각누계금액 */
private BigDecimal typLndBkval;               /* 유형자산토지장부가 */

private BigDecimal typBldgAcqsAmt;            /* 유형자산건물취득금액 */
private BigDecimal typBldgDprcCmtlAmt;        /* 유형자산건물상각누계금액 */
private BigDecimal typBldgBkval;              /* 유형자산건물장부가 */

private BigDecimal invstLndAcqsAmt;           /* 투자자산토지취득금액 */
private BigDecimal invstLndDprcCmtlAmt;       /* 투자자산토지상각누계금액 */
private BigDecimal invstLndBkval;             /* 투자자산토지장부가 */

private BigDecimal invstBldgAcqsAmt;          /* 투자자산건물취득금액 */
private BigDecimal invstBldgDprcCmtlAmt;      /* 투자자산건물상각누계금액 */
private BigDecimal invstBldgBkval;            /* 투자자산건물장부가 */

private int cllpNo;                           /* 물건지번호 */

	/**
	 * @return the rNum
	 */
	public String getrNum() {
		return rNum;
	}

	/**
	 * @param rNum the rNum to set
	 */
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}

	/**
	 * @return the stdrYm
	 */
	public String getStdrYm() {
		return stdrYm;
	}

	/**
	 * @param stdrYm the stdrYm to set
	 */
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}

	/**
	 * @return the cllpNm
	 */
	public String getCllpNm() {
		return cllpNm;
	}

	/**
	 * @param cllpNm the cllpNm to set
	 */
	public void setCllpNm(String cllpNm) {
		this.cllpNm = cllpNm;
	}

	/**
	 * @return the lndAcqsAmt
	 */
	public BigDecimal getLndAcqsAmt() {
		return lndAcqsAmt;
	}

	/**
	 * @param lndAcqsAmt the lndAcqsAmt to set
	 */
	public void setLndAcqsAmt(BigDecimal lndAcqsAmt) {
		this.lndAcqsAmt = lndAcqsAmt;
	}

	/**
	 * @return the lndDprcCmtlAMt
	 */
	public BigDecimal getLndDprcCmtlAMt() {
		return lndDprcCmtlAMt;
	}

	/**
	 * @param lndDprcCmtlAMt the lndDprcCmtlAMt to set
	 */
	public void setLndDprcCmtlAMt(BigDecimal lndDprcCmtlAMt) {
		this.lndDprcCmtlAMt = lndDprcCmtlAMt;
	}

	/**
	 * @return the lndBkval
	 */
	public BigDecimal getLndBkval() {
		return lndBkval;
	}

	/**
	 * @param lndBkval the lndBkval to set
	 */
	public void setLndBkval(BigDecimal lndBkval) {
		this.lndBkval = lndBkval;
	}

	/**
	 * @return the bldgAcqsAmt
	 */
	public BigDecimal getBldgAcqsAmt() {
		return bldgAcqsAmt;
	}

	/**
	 * @param bldgAcqsAmt the bldgAcqsAmt to set
	 */
	public void setBldgAcqsAmt(BigDecimal bldgAcqsAmt) {
		this.bldgAcqsAmt = bldgAcqsAmt;
	}

	/**
	 * @return the bldgDprcCmtlAmt
	 */
	public BigDecimal getBldgDprcCmtlAmt() {
		return bldgDprcCmtlAmt;
	}

	/**
	 * @param bldgDprcCmtlAmt the bldgDprcCmtlAmt to set
	 */
	public void setBldgDprcCmtlAmt(BigDecimal bldgDprcCmtlAmt) {
		this.bldgDprcCmtlAmt = bldgDprcCmtlAmt;
	}

	/**
	 * @return the bldgBkval
	 */
	public BigDecimal getBldgBkval() {
		return bldgBkval;
	}

	/**
	 * @param bldgBkval the bldgBkval to set
	 */
	public void setBldgBkval(BigDecimal bldgBkval) {
		this.bldgBkval = bldgBkval;
	}

	/**
	 * @return the owhsRate
	 */
	public double getOwhsRate() {
		return owhsRate;
	}

	/**
	 * @param owhsRate the owhsRate to set
	 */
	public void setOwhsRate(double owhsRate) {
		this.owhsRate = owhsRate;
	}

	/**
	 * @return the lentRate
	 */
	public double getLentRate() {
		return lentRate;
	}

	/**
	 * @param lentRate the lentRate to set
	 */
	public void setLentRate(double lentRate) {
		this.lentRate = lentRate;
	}

	/**
	 * @return the acqsDt
	 */
	public String getAcqsDt() {
		return acqsDt;
	}

	/**
	 * @param acqsDt the acqsDt to set
	 */
	public void setAcqsDt(String acqsDt) {
		this.acqsDt = acqsDt;
	}

	/**
	 * @return the typLndAcqsAmt
	 */
	public BigDecimal getTypLndAcqsAmt() {
		return typLndAcqsAmt;
	}

	/**
	 * @param typLndAcqsAmt the typLndAcqsAmt to set
	 */
	public void setTypLndAcqsAmt(BigDecimal typLndAcqsAmt) {
		this.typLndAcqsAmt = typLndAcqsAmt;
	}

	/**
	 * @return the typLndDprcCmtlAmt
	 */
	public BigDecimal getTypLndDprcCmtlAmt() {
		return typLndDprcCmtlAmt;
	}

	/**
	 * @param typLndDprcCmtlAmt the typLndDprcCmtlAmt to set
	 */
	public void setTypLndDprcCmtlAmt(BigDecimal typLndDprcCmtlAmt) {
		this.typLndDprcCmtlAmt = typLndDprcCmtlAmt;
	}

	/**
	 * @return the typLndBkval
	 */
	public BigDecimal getTypLndBkval() {
		return typLndBkval;
	}

	/**
	 * @param typLndBkval the typLndBkval to set
	 */
	public void setTypLndBkval(BigDecimal typLndBkval) {
		this.typLndBkval = typLndBkval;
	}

	/**
	 * @return the typBldgAcqsAmt
	 */
	public BigDecimal getTypBldgAcqsAmt() {
		return typBldgAcqsAmt;
	}

	/**
	 * @param typBldgAcqsAmt the typBldgAcqsAmt to set
	 */
	public void setTypBldgAcqsAmt(BigDecimal typBldgAcqsAmt) {
		this.typBldgAcqsAmt = typBldgAcqsAmt;
	}

	/**
	 * @return the typBldgDprcCmtlAmt
	 */
	public BigDecimal getTypBldgDprcCmtlAmt() {
		return typBldgDprcCmtlAmt;
	}

	/**
	 * @param typBldgDprcCmtlAmt the typBldgDprcCmtlAmt to set
	 */
	public void setTypBldgDprcCmtlAmt(BigDecimal typBldgDprcCmtlAmt) {
		this.typBldgDprcCmtlAmt = typBldgDprcCmtlAmt;
	}

	/**
	 * @return the typBldgBkval
	 */
	public BigDecimal getTypBldgBkval() {
		return typBldgBkval;
	}

	/**
	 * @param typBldgBkval the typBldgBkval to set
	 */
	public void setTypBldgBkval(BigDecimal typBldgBkval) {
		this.typBldgBkval = typBldgBkval;
	}

	/**
	 * @return the invstLndAcqsAmt
	 */
	public BigDecimal getInvstLndAcqsAmt() {
		return invstLndAcqsAmt;
	}

	/**
	 * @param invstLndAcqsAmt the invstLndAcqsAmt to set
	 */
	public void setInvstLndAcqsAmt(BigDecimal invstLndAcqsAmt) {
		this.invstLndAcqsAmt = invstLndAcqsAmt;
	}

	/**
	 * @return the invstLndDprcCmtlAmt
	 */
	public BigDecimal getInvstLndDprcCmtlAmt() {
		return invstLndDprcCmtlAmt;
	}

	/**
	 * @param invstLndDprcCmtlAmt the invstLndDprcCmtlAmt to set
	 */
	public void setInvstLndDprcCmtlAmt(BigDecimal invstLndDprcCmtlAmt) {
		this.invstLndDprcCmtlAmt = invstLndDprcCmtlAmt;
	}

	/**
	 * @return the invstLndBkval
	 */
	public BigDecimal getInvstLndBkval() {
		return invstLndBkval;
	}

	/**
	 * @param invstLndBkval the invstLndBkval to set
	 */
	public void setInvstLndBkval(BigDecimal invstLndBkval) {
		this.invstLndBkval = invstLndBkval;
	}

	/**
	 * @return the invstBldgAcqsAmt
	 */
	public BigDecimal getInvstBldgAcqsAmt() {
		return invstBldgAcqsAmt;
	}

	/**
	 * @param invstBldgAcqsAmt the invstBldgAcqsAmt to set
	 */
	public void setInvstBldgAcqsAmt(BigDecimal invstBldgAcqsAmt) {
		this.invstBldgAcqsAmt = invstBldgAcqsAmt;
	}

	/**
	 * @return the invstBldgDprcCmtlAmt
	 */
	public BigDecimal getInvstBldgDprcCmtlAmt() {
		return invstBldgDprcCmtlAmt;
	}

	/**
	 * @param invstBldgDprcCmtlAmt the invstBldgDprcCmtlAmt to set
	 */
	public void setInvstBldgDprcCmtlAmt(BigDecimal invstBldgDprcCmtlAmt) {
		this.invstBldgDprcCmtlAmt = invstBldgDprcCmtlAmt;
	}

	/**
	 * @return the invstBldgBkval
	 */
	public BigDecimal getInvstBldgBkval() {
		return invstBldgBkval;
	}

	/**
	 * @param invstBldgBkval the invstBldgBkval to set
	 */
	public void setInvstBldgBkval(BigDecimal invstBldgBkval) {
		this.invstBldgBkval = invstBldgBkval;
	}

	/**
	 * @return the cllpNo
	 */
	public int getCllpNo() {
		return cllpNo;
	}

	/**
	 * @param cllpNo the cllpNo to set
	 */
	public void setCllpNo(int cllpNo) {
		this.cllpNo = cllpNo;
	}






}
