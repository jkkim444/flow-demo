/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515001DTO.java
 * @brief 수익용 부동산 보유 현황 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 수익용 부동산 보유 현황 management List Query DTO
 * @details 수익용 부동산 보유 현황 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA515001DTO {

	private String rNum;

	private String stdrYm;                          /* 기준년월 */
	private int cllpNo;                             /* 물건지번호 */
	private String cllpNm;                          /* 물건지명 */
    private BigDecimal lndAcqsAmt;                  /* 토지취득금액 */
    private BigDecimal lndDprcCmtlAMt;              /* 토지상각누계금액 */
    private BigDecimal lndBkval;                    /* 토지장부가 */
    private BigDecimal bldgAcqsAmt;                 /* 건물취득금액 */
    private BigDecimal bldgDprcCmtlAmt;             /* 건물상각누계금액 */
    private BigDecimal bldgBkval;                   /* 건물장부가 */
    private double owhsRate;                        /* 자가비율 */
    private double lentRate;                        /* 임대비율 */
    private String acqsDt;                          /* 취득일자 */
    private BigDecimal typLndAcqsAmt;               /* 유형자산토지취득금액 */
    private BigDecimal typLndDprcCmtlAmt;           /* 유형자산토지상각누계금액 */
    private BigDecimal typLndBkval;                 /* 유형자산토지장부가 */
    private BigDecimal typBldgAcqsAmt;              /* 유형자산건물취득금액 */
    private BigDecimal typBldgDprcCmtlAmt;          /* 유형자산건물상각누계금액 */
    private BigDecimal typBldgBkval;                /* 유형자산건물장부가 */
    private BigDecimal invstLndAcqsAmt;             /* 투자자산토지취득금액 */
    private BigDecimal invstLndDprcCmtlAmt;         /* 투자자산토지상각누계금액 */
    private BigDecimal invstLndBkval;               /* 투자자산토지장부가 */
	private BigDecimal invstBldgAcqsAmt;            /* 투자자산건물취득금액 */
	private BigDecimal invstBldgDprcCmtlAmt;        /* 투자자산건물상각누계금액 */
	private BigDecimal invstBldgBkval;              /* 투자자산건물장부가  */
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
	public int getCllpNo() {
		return cllpNo;
	}
	public void setCllpNo(int cllpNo) {
		this.cllpNo = cllpNo;
	}
	public String getCllpNm() {
		return cllpNm;
	}
	public void setCllpNm(String cllpNm) {
		this.cllpNm = cllpNm;
	}
	public BigDecimal getLndAcqsAmt() {
		return lndAcqsAmt;
	}
	public void setLndAcqsAmt(BigDecimal lndAcqsAmt) {
		this.lndAcqsAmt = lndAcqsAmt;
	}
	public BigDecimal getLndDprcCmtlAMt() {
		return lndDprcCmtlAMt;
	}
	public void setLndDprcCmtlAMt(BigDecimal lndDprcCmtlAMt) {
		this.lndDprcCmtlAMt = lndDprcCmtlAMt;
	}
	public BigDecimal getLndBkval() {
		return lndBkval;
	}
	public void setLndBkval(BigDecimal lndBkval) {
		this.lndBkval = lndBkval;
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
	public BigDecimal getBldgBkval() {
		return bldgBkval;
	}
	public void setBldgBkval(BigDecimal bldgBkval) {
		this.bldgBkval = bldgBkval;
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
	public String getAcqsDt() {
		return acqsDt;
	}
	public void setAcqsDt(String acqsDt) {
		this.acqsDt = acqsDt;
	}
	public BigDecimal getTypLndAcqsAmt() {
		return typLndAcqsAmt;
	}
	public void setTypLndAcqsAmt(BigDecimal typLndAcqsAmt) {
		this.typLndAcqsAmt = typLndAcqsAmt;
	}
	public BigDecimal getTypLndDprcCmtlAmt() {
		return typLndDprcCmtlAmt;
	}
	public void setTypLndDprcCmtlAmt(BigDecimal typLndDprcCmtlAmt) {
		this.typLndDprcCmtlAmt = typLndDprcCmtlAmt;
	}
	public BigDecimal getTypLndBkval() {
		return typLndBkval;
	}
	public void setTypLndBkval(BigDecimal typLndBkval) {
		this.typLndBkval = typLndBkval;
	}
	public BigDecimal getTypBldgAcqsAmt() {
		return typBldgAcqsAmt;
	}
	public void setTypBldgAcqsAmt(BigDecimal typBldgAcqsAmt) {
		this.typBldgAcqsAmt = typBldgAcqsAmt;
	}
	public BigDecimal getTypBldgDprcCmtlAmt() {
		return typBldgDprcCmtlAmt;
	}
	public void setTypBldgDprcCmtlAmt(BigDecimal typBldgDprcCmtlAmt) {
		this.typBldgDprcCmtlAmt = typBldgDprcCmtlAmt;
	}
	public BigDecimal getTypBldgBkval() {
		return typBldgBkval;
	}
	public void setTypBldgBkval(BigDecimal typBldgBkval) {
		this.typBldgBkval = typBldgBkval;
	}
	public BigDecimal getInvstLndAcqsAmt() {
		return invstLndAcqsAmt;
	}
	public void setInvstLndAcqsAmt(BigDecimal invstLndAcqsAmt) {
		this.invstLndAcqsAmt = invstLndAcqsAmt;
	}
	public BigDecimal getInvstLndDprcCmtlAmt() {
		return invstLndDprcCmtlAmt;
	}
	public void setInvstLndDprcCmtlAmt(BigDecimal invstLndDprcCmtlAmt) {
		this.invstLndDprcCmtlAmt = invstLndDprcCmtlAmt;
	}
	public BigDecimal getInvstLndBkval() {
		return invstLndBkval;
	}
	public void setInvstLndBkval(BigDecimal invstLndBkval) {
		this.invstLndBkval = invstLndBkval;
	}
	public BigDecimal getInvstBldgAcqsAmt() {
		return invstBldgAcqsAmt;
	}
	public void setInvstBldgAcqsAmt(BigDecimal invstBldgAcqsAmt) {
		this.invstBldgAcqsAmt = invstBldgAcqsAmt;
	}
	public BigDecimal getInvstBldgDprcCmtlAmt() {
		return invstBldgDprcCmtlAmt;
	}
	public void setInvstBldgDprcCmtlAmt(BigDecimal invstBldgDprcCmtlAmt) {
		this.invstBldgDprcCmtlAmt = invstBldgDprcCmtlAmt;
	}
	public BigDecimal getInvstBldgBkval() {
		return invstBldgBkval;
	}
	public void setInvstBldgBkval(BigDecimal invstBldgBkval) {
		this.invstBldgBkval = invstBldgBkval;
	}



}
