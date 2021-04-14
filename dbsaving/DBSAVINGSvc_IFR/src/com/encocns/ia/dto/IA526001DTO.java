/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA513001DTO.java
 * @brief 기타유형자산 management List Query DTO
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
 * @brief 수익증권 재무제표 management List Query DTO
 * @details 수익증권 재무제표 management List Query DTO
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
public class IA526001DTO {

	private String rNum;					 	 /* 순번 */
	private String stdrYm;                   /* 기준년월 */
	private String fnncGdsItmsNo;            /* 금융상품종목번호 */
	private String fnncGdsDivCd;			 /* 금융상품구분코드 */
    private String fnncGdsItmsNm;            /* 금융상품종목명 */
    private BigDecimal mkstShrt;             /* 유가증권지분율 */
    private BigDecimal bassAcbkAmt;          /* 기초장부금액 */
    private BigDecimal acqsAmt;              /* 취득금액 */
    private BigDecimal spusFvAmt;            /* 별도공정가치금액 */
	private BigDecimal acmlChgAmt;           /* 누적변동금액 */
	private BigDecimal edtmEvprftPl;         /* 기말평가이익PL */
	private BigDecimal edtmEvlssPl;          /* 기말평가손실PL */
	private BigDecimal thtrChgAmt;           /* 당기변동금액 */
	private BigDecimal frtrMoveChgAmt;		 /* 전기이전변동금액 */
	private BigDecimal thtrDvdnAmt;          /* 당기배당금액 */
	private BigDecimal earnOnskCapl;         /* 수익보통주자본금 */
	private BigDecimal earnCrfrPrftSrpl;      /* 수익이월이익잉여금 */
	private BigDecimal earnThtrNtpr;         /* 수익당기순이익 */
	private BigDecimal swayStclShrt;         /* 지배주주지분율 */
	private BigDecimal swayEarnOnskCapl;     /* 지배수익보통주자본금 */
	private BigDecimal swayEarnCrfrPrftSrpl; /* 지배수익이월이익잉여금 */
	private BigDecimal swayEarnThtrNtpr;     /* 지배수익당기순이익  */
	
	
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
	 * @return the fnncGdsDivCd
	 */
	public String getFnncGdsDivCd() {
		return fnncGdsDivCd;
	}
	/**
	 * @param fnncGdsDivCd the fnncGdsDivCd to set
	 */
	public void setFnncGdsDivCd(String fnncGdsDivCd) {
		this.fnncGdsDivCd = fnncGdsDivCd;
	}
	/**
	 * @return the fnncGdsItmsNm
	 */
	public String getFnncGdsItmsNm() {
		return fnncGdsItmsNm;
	}
	/**
	 * @param fnncGdsItmsNm the fnncGdsItmsNm to set
	 */
	public void setFnncGdsItmsNm(String fnncGdsItmsNm) {
		this.fnncGdsItmsNm = fnncGdsItmsNm;
	}
	
	/**
	 * @return the acmlChgAmt
	 */
	public BigDecimal getAcmlChgAmt() {
		return acmlChgAmt;
	}
	/**
	 * @param acmlChgAmt the acmlChgAmt to set
	 */
	public void setAcmlChgAmt(BigDecimal acmlChgAmt) {
		this.acmlChgAmt = acmlChgAmt;
	}
	/**
	 * @return the edtmEvprftPl
	 */
	public BigDecimal getEdtmEvprftPl() {
		return edtmEvprftPl;
	}
	/**
	 * @param edtmEvprftPl the edtmEvprftPl to set
	 */
	public void setEdtmEvprftPl(BigDecimal edtmEvprftPl) {
		this.edtmEvprftPl = edtmEvprftPl;
	}
	/**
	 * @return the edtmEvlssPl
	 */
	public BigDecimal getEdtmEvlssPl() {
		return edtmEvlssPl;
	}
	/**
	 * @param edtmEvlssPl the edtmEvlssPl to set
	 */
	public void setEdtmEvlssPl(BigDecimal edtmEvlssPl) {
		this.edtmEvlssPl = edtmEvlssPl;
	}
	/**
	 * @return the thtrChgAmt
	 */
	public BigDecimal getThtrChgAmt() {
		return thtrChgAmt;
	}
	/**
	 * @param thtrChgAmt the thtrChgAmt to set
	 */
	public void setThtrChgAmt(BigDecimal thtrChgAmt) {
		this.thtrChgAmt = thtrChgAmt;
	}
	/**
	 * @return the frtrMoveChgAmt
	 */
	public BigDecimal getFrtrMoveChgAmt() {
		return frtrMoveChgAmt;
	}
	/**
	 * @param frtrMoveChgAmt the frtrMoveChgAmt to set
	 */
	public void setFrtrMoveChgAmt(BigDecimal frtrMoveChgAmt) {
		this.frtrMoveChgAmt = frtrMoveChgAmt;
	}
	/**
	 * @return the thtrDvdnAmt
	 */
	public BigDecimal getThtrDvdnAmt() {
		return thtrDvdnAmt;
	}
	/**
	 * @param thtrDvdnAmt the thtrDvdnAmt to set
	 */
	public void setThtrDvdnAmt(BigDecimal thtrDvdnAmt) {
		this.thtrDvdnAmt = thtrDvdnAmt;
	}
	/**
	 * @return the earnOnskCapl
	 */
	public BigDecimal getEarnOnskCapl() {
		return earnOnskCapl;
	}
	/**
	 * @param earnOnskCapl the earnOnskCapl to set
	 */
	public void setEarnOnskCapl(BigDecimal earnOnskCapl) {
		this.earnOnskCapl = earnOnskCapl;
	}
	
	/**
	 * @return the earnThtrNtpr
	 */
	public BigDecimal getEarnThtrNtpr() {
		return earnThtrNtpr;
	}
	/**
	 * @param earnThtrNtpr the earnThtrNtpr to set
	 */
	public void setEarnThtrNtpr(BigDecimal earnThtrNtpr) {
		this.earnThtrNtpr = earnThtrNtpr;
	}
	/**
	 * @return the swayStclShrt
	 */
	public BigDecimal getSwayStclShrt() {
		return swayStclShrt;
	}
	/**
	 * @param swayStclShrt the swayStclShrt to set
	 */
	public void setSwayStclShrt(BigDecimal swayStclShrt) {
		this.swayStclShrt = swayStclShrt;
	}
	/**
	 * @return the swayEarnOnskCapl
	 */
	public BigDecimal getSwayEarnOnskCapl() {
		return swayEarnOnskCapl;
	}
	/**
	 * @param swayEarnOnskCapl the swayEarnOnskCapl to set
	 */
	public void setSwayEarnOnskCapl(BigDecimal swayEarnOnskCapl) {
		this.swayEarnOnskCapl = swayEarnOnskCapl;
	}
	/**
	 * @return the swayEarnCrfrPrftSrpl
	 */
	public BigDecimal getSwayEarnCrfrPrftSrpl() {
		return swayEarnCrfrPrftSrpl;
	}
	/**
	 * @param swayEarnCrfrPrftSrpl the swayEarnCrfrPrftSrpl to set
	 */
	public void setSwayEarnCrfrPrftSrpl(BigDecimal swayEarnCrfrPrftSrpl) {
		this.swayEarnCrfrPrftSrpl = swayEarnCrfrPrftSrpl;
	}
	/**
	 * @return the swayEarnThtrNtpr
	 */
	public BigDecimal getSwayEarnThtrNtpr() {
		return swayEarnThtrNtpr;
	}
	/**
	 * @param swayEarnThtrNtpr the swayEarnThtrNtpr to set
	 */
	public void setSwayEarnThtrNtpr(BigDecimal swayEarnThtrNtpr) {
		this.swayEarnThtrNtpr = swayEarnThtrNtpr;
	}
	
	/**
	 * @return the fnncGdsItmsNo
	 */
	public String getFnncGdsItmsNo() {
		return fnncGdsItmsNo;
	}
	/**
	 * @param fnncGdsItmsNo the fnncGdsItmsNo to set
	 */
	public void setFnncGdsItmsNo(String fnncGdsItmsNo) {
		this.fnncGdsItmsNo = fnncGdsItmsNo;
	}
	/**
	 * @return the mkstShrt
	 */
	public BigDecimal getMkstShrt() {
		return mkstShrt;
	}
	/**
	 * @param mkstShrt the mkstShrt to set
	 */
	public void setMkstShrt(BigDecimal mkstShrt) {
		this.mkstShrt = mkstShrt;
	}
	/**
	 * @return the bassAcbkAmt
	 */
	public BigDecimal getBassAcbkAmt() {
		return bassAcbkAmt;
	}
	/**
	 * @param bassAcbkAmt the bassAcbkAmt to set
	 */
	public void setBassAcbkAmt(BigDecimal bassAcbkAmt) {
		this.bassAcbkAmt = bassAcbkAmt;
	}
	/**
	 * @return the acqsAmt
	 */
	public BigDecimal getAcqsAmt() {
		return acqsAmt;
	}
	/**
	 * @param acqsAmt the acqsAmt to set
	 */
	public void setAcqsAmt(BigDecimal acqsAmt) {
		this.acqsAmt = acqsAmt;
	}
	/**
	 * @return the spusFvAmt
	 */
	public BigDecimal getSpusFvAmt() {
		return spusFvAmt;
	}
	/**
	 * @param spusFvAmt the spusFvAmt to set
	 */
	public void setSpusFvAmt(BigDecimal spusFvAmt) {
		this.spusFvAmt = spusFvAmt;
	}
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
	 * @return the earnCrfrPrftSrpl
	 */
	public BigDecimal getEarnCrfrPrftSrpl() {
		return earnCrfrPrftSrpl;
	}
	/**
	 * @param earnCrfrPrftSrpl the earnCrfrPrftSrpl to set
	 */
	public void setEarnCrfrPrftSrpl(BigDecimal earnCrfrPrftSrpl) {
		this.earnCrfrPrftSrpl = earnCrfrPrftSrpl;
	}	 
	


}
