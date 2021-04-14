/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA513003IN.java
 * @brief 기타유형자산 management IN
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
 * @brief 기타유형자산 management IN
 * @details 기타유형자산 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA526003IN {

	private String stdrYm;                           /* 기준년월 */
	private String jobDivCd;                         /* 등록수정구분코드 */
	private String usrId;                            /* 사용자ID */
	private String fnncGdsItmsNo;                    /* 금융상품종목번호 */
	private String fnncGdsDivCd;                     /* 금융상품구분코드 */
	private String fnncGdsItmsNm;                    /* 금융상품종목명 */
	private BigDecimal mkstShrt;                     /* 유가증권지분율 */
	private BigDecimal bassAcbkAmt;                  /* 기초장부금액 */
	private BigDecimal acqsAmt;                      /* 취득금액 */
	private BigDecimal spusFvAmt;                    /* 별도공정가치금액 */
	private BigDecimal acmlChgAmt;                   /* 누적변동금액 */
	private BigDecimal edtmEvprftPl;                 /* 기말평가이익PL */
	private BigDecimal edtmEvlssPl;                  /* 기말평가손실PL */
	private BigDecimal thtrChgAmt;                   /* 당기변동금액 */
	private BigDecimal frtrMoveChgAmt;               /* 전기이전변동금액 */
	private BigDecimal thtrDvdnAmt ;                 /* 당기배당금액 */
	private BigDecimal earnOnskCapl;                 /* 수익보통주자본금 */
	private BigDecimal earnCrfrPrftSrpl;             /* 수익이월이익잉여금 */
	private BigDecimal earnThtrNtpr;                 /* 수익당기순이익 */
	private BigDecimal swayStclShrt;                 /* 지배주주지분율 */
	private BigDecimal swayEarnOnskCapl;             /* 지배수익보통주자본금 */
	private BigDecimal swayEarnCrfrPrftSrpl;         /* 지배수익이월이익잉여금 */
	private BigDecimal swayEarnThtrNtpr;             /* 지배수익당기순이익 */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
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
	public String getFnncGdsItmsNo() {
		return fnncGdsItmsNo;
	}
	public void setFnncGdsItmsNo(String fnncGdsItmsNo) {
		this.fnncGdsItmsNo = fnncGdsItmsNo;
	}
	public String getFnncGdsDivCd() {
		return fnncGdsDivCd;
	}
	public void setFnncGdsDivCd(String fnncGdsDivCd) {
		this.fnncGdsDivCd = fnncGdsDivCd;
	}
	public String getFnncGdsItmsNm() {
		return fnncGdsItmsNm;
	}
	public void setFnncGdsItmsNm(String fnncGdsItmsNm) {
		this.fnncGdsItmsNm = fnncGdsItmsNm;
	}
	public BigDecimal getMkstShrt() {
		return mkstShrt;
	}
	public void setMkstShrt(BigDecimal mkstShrt) {
		this.mkstShrt = mkstShrt;
	}
	public BigDecimal getBassAcbkAmt() {
		return bassAcbkAmt;
	}
	public void setBassAcbkAmt(BigDecimal bassAcbkAmt) {
		this.bassAcbkAmt = bassAcbkAmt;
	}
	public BigDecimal getAcqsAmt() {
		return acqsAmt;
	}
	public void setAcqsAmt(BigDecimal acqsAmt) {
		this.acqsAmt = acqsAmt;
	}
	public BigDecimal getSpusFvAmt() {
		return spusFvAmt;
	}
	public void setSpusFvAmt(BigDecimal spusFvAmt) {
		this.spusFvAmt = spusFvAmt;
	}
	public BigDecimal getAcmlChgAmt() {
		return acmlChgAmt;
	}
	public void setAcmlChgAmt(BigDecimal acmlChgAmt) {
		this.acmlChgAmt = acmlChgAmt;
	}
	public BigDecimal getEdtmEvprftPl() {
		return edtmEvprftPl;
	}
	public void setEdtmEvprftPl(BigDecimal edtmEvprftPl) {
		this.edtmEvprftPl = edtmEvprftPl;
	}
	public BigDecimal getEdtmEvlssPl() {
		return edtmEvlssPl;
	}
	public void setEdtmEvlssPl(BigDecimal edtmEvlssPl) {
		this.edtmEvlssPl = edtmEvlssPl;
	}
	public BigDecimal getThtrChgAmt() {
		return thtrChgAmt;
	}
	public void setThtrChgAmt(BigDecimal thtrChgAmt) {
		this.thtrChgAmt = thtrChgAmt;
	}
	public BigDecimal getFrtrMoveChgAmt() {
		return frtrMoveChgAmt;
	}
	public void setFrtrMoveChgAmt(BigDecimal frtrMoveChgAmt) {
		this.frtrMoveChgAmt = frtrMoveChgAmt;
	}
	public BigDecimal getThtrDvdnAmt() {
		return thtrDvdnAmt;
	}
	public void setThtrDvdnAmt(BigDecimal thtrDvdnAmt) {
		this.thtrDvdnAmt = thtrDvdnAmt;
	}
	public BigDecimal getEarnOnskCapl() {
		return earnOnskCapl;
	}
	public void setEarnOnskCapl(BigDecimal earnOnskCapl) {
		this.earnOnskCapl = earnOnskCapl;
	}
	public BigDecimal getEarnCrfrPrftSrpl() {
		return earnCrfrPrftSrpl;
	}
	public void setEarnCrfrPrftSrpl(BigDecimal earnCrfrPrftSrpl) {
		this.earnCrfrPrftSrpl = earnCrfrPrftSrpl;
	}
	public BigDecimal getEarnThtrNtpr() {
		return earnThtrNtpr;
	}
	public void setEarnThtrNtpr(BigDecimal earnThtrNtpr) {
		this.earnThtrNtpr = earnThtrNtpr;
	}
	public BigDecimal getSwayStclShrt() {
		return swayStclShrt;
	}
	public void setSwayStclShrt(BigDecimal swayStclShrt) {
		this.swayStclShrt = swayStclShrt;
	}
	public BigDecimal getSwayEarnOnskCapl() {
		return swayEarnOnskCapl;
	}
	public void setSwayEarnOnskCapl(BigDecimal swayEarnOnskCapl) {
		this.swayEarnOnskCapl = swayEarnOnskCapl;
	}
	public BigDecimal getSwayEarnCrfrPrftSrpl() {
		return swayEarnCrfrPrftSrpl;
	}
	public void setSwayEarnCrfrPrftSrpl(BigDecimal swayEarnCrfrPrftSrpl) {
		this.swayEarnCrfrPrftSrpl = swayEarnCrfrPrftSrpl;
	}
	public BigDecimal getSwayEarnThtrNtpr() {
		return swayEarnThtrNtpr;
	}
	public void setSwayEarnThtrNtpr(BigDecimal swayEarnThtrNtpr) {
		this.swayEarnThtrNtpr = swayEarnThtrNtpr;
	}
}
