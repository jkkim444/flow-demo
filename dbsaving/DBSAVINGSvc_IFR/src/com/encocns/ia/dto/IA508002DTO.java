/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA508001DTO.java
 * @brief 연결자본변동표관리 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 연결자본변동표관리 management List Query DTO
 * @details 연결자본변동표관리 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA508002DTO {

	private String stdrYm;                          /* 기준년월 */
	private int seqno;                              /* 일련번호 */
	private String spusLnknDivCd;		         	/* 별도연결구분코드 */
	private String captDivCd;                   	/* 자본변동표구분코드 */
	private BigDecimal onskCapl;         	     	/* 보통주자본금 */
	private BigDecimal ressInstlAmt;                /* 재평가적립금액 */
	private BigDecimal fnncAsetEvalPrft;            /* 금융자산평가이익 */
	private BigDecimal insuActnPfls;                /* 보험수리손익 */
	private BigDecimal asetRessMrpr;                /* 자산재평가차익 */
	private BigDecimal lglInstlAmt;	             	/* 법정적립금액 */
	private BigDecimal corpRtnlInstlAmt;            /* 기업합리화적립금액 */
	private BigDecimal corpInstlAmt;  	            /* 기업발전적립금액 */
	private BigDecimal optnlInstlAmt;               /* 임의적립금액 */
	private BigDecimal dspslPrftSrpl;               /* 처분이익잉여금 */
	private BigDecimal swayShrs;  		            /* 비지배지분 */
	private BigDecimal sumAmt;
	private String usrId;
	private String rNum;

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getSpusLnknDivCd() {
		return spusLnknDivCd;
	}
	public void setSpusLnknDivCd(String spusLnknDivCd) {
		this.spusLnknDivCd = spusLnknDivCd;
	}
	public String getCaptDivCd() {
		return captDivCd;
	}
	public void setCaptDivCd(String captDivCd) {
		this.captDivCd = captDivCd;
	}
	public BigDecimal getOnskCapl() {
		return onskCapl;
	}
	public void setOnskCapl(BigDecimal onskCapl) {
		this.onskCapl = onskCapl;
	}
	public BigDecimal getRessInstlAmt() {
		return ressInstlAmt;
	}
	public void setRessInstlAmt(BigDecimal ressInstlAmt) {
		this.ressInstlAmt = ressInstlAmt;
	}
	public BigDecimal getFnncAsetEvalPrft() {
		return fnncAsetEvalPrft;
	}
	public void setFnncAsetEvalPrft(BigDecimal fnncAsetEvalPrft) {
		this.fnncAsetEvalPrft = fnncAsetEvalPrft;
	}
	public BigDecimal getInsuActnPfls() {
		return insuActnPfls;
	}
	public void setInsuActnPfls(BigDecimal insuActnPfls) {
		this.insuActnPfls = insuActnPfls;
	}
	public BigDecimal getAsetRessMrpr() {
		return asetRessMrpr;
	}
	public void setAsetRessMrpr(BigDecimal asetRessMrpr) {
		this.asetRessMrpr = asetRessMrpr;
	}
	public BigDecimal getLglInstlAmt() {
		return lglInstlAmt;
	}
	public void setLglInstlAmt(BigDecimal lglInstlAmt) {
		this.lglInstlAmt = lglInstlAmt;
	}
	public BigDecimal getCorpRtnlInstlAmt() {
		return corpRtnlInstlAmt;
	}
	public void setCorpRtnlInstlAmt(BigDecimal corpRtnlInstlAmt) {
		this.corpRtnlInstlAmt = corpRtnlInstlAmt;
	}
	public BigDecimal getCorpInstlAmt() {
		return corpInstlAmt;
	}
	public void setCorpInstlAmt(BigDecimal corpInstlAmt) {
		this.corpInstlAmt = corpInstlAmt;
	}
	public BigDecimal getOptnlInstlAmt() {
		return optnlInstlAmt;
	}
	public void setOptnlInstlAmt(BigDecimal optnlInstlAmt) {
		this.optnlInstlAmt = optnlInstlAmt;
	}
	public BigDecimal getDspslPrftSrpl() {
		return dspslPrftSrpl;
	}
	public void setDspslPrftSrpl(BigDecimal dspslPrftSrpl) {
		this.dspslPrftSrpl = dspslPrftSrpl;
	}
	public BigDecimal getSwayShrs() {
		return swayShrs;
	}
	public void setSwayShrs(BigDecimal swayShrs) {
		this.swayShrs = swayShrs;
	}
	public BigDecimal getSumAmt() {
		return sumAmt;
	}
	public void setSumAmt(BigDecimal sumAmt) {
		this.sumAmt = sumAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}

}
