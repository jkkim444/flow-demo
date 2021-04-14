/*
A * Copyright ENCOCNS.,LTD.
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
public class IA508003DTO {
	private String stdrYm;                          /* 기준년월 */
	private int seqno;                          	/* 일련번호 */
	private String spusLnknDivCd;               	/* 별도연결구분코드 */
	private String captDivCd;                   	/* 자본변동표구분코드 */
	private BigDecimal onskCapl;                    /* 보통주자본금 */
	private BigDecimal ressInstlAmt;                /* 재평가적립금액 */
	private BigDecimal fnncAsetEvalPrft;            /* 금융자산평가이익 */
	private BigDecimal insuActnPfls;                /* 보험수리손익 */
	private BigDecimal asetRessMrpr;                /* 자산재평가차익 */
	private BigDecimal lglInstlAmt	;               /* 법정적립금액 */
	private BigDecimal corpRtnlInstlAmt;            /* 기업합리화적립금액 */
	private BigDecimal corpInstlAmt;                /* 기업발전적립금액 */
	private BigDecimal optnlInstlAmt;               /* 임의적립금액 */
	private BigDecimal dspslPrftSrpl;               /* 처분이익잉여금 */
	private BigDecimal swayShrs;                    /* 비지배지분 */
	private String rNum;
	private BigDecimal sumAmt;


	/**
	 * @return the sumAmt
	 */
	public BigDecimal getSumAmt() {
		return sumAmt;
	}
	/**
	 * @param sumAmt the sumAmt to set
	 */
	public void setSumAmt(BigDecimal sumAmt) {
		this.sumAmt = sumAmt;
	}
	/**
	 * @return the seqno
	 */
	public int getSeqno() {
		return seqno;
	}
	/**
	 * @param seqno the seqno to set
	 */
	public void setSeqno(int seqno) {
		this.seqno = seqno;
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
	 * @return the spusLnknDivCd
	 */
	public String getSpusLnknDivCd() {
		return spusLnknDivCd;
	}
	/**
	 * @param spusLnknDivCd the spusLnknDivCd to set
	 */
	public void setSpusLnknDivCd(String spusLnknDivCd) {
		this.spusLnknDivCd = spusLnknDivCd;
	}
	/**
	 * @return the captDivCd
	 */
	public String getCaptDivCd() {
		return captDivCd;
	}
	/**
	 * @param captDivCd the captDivCd to set
	 */
	public void setCaptDivCd(String captDivCd) {
		this.captDivCd = captDivCd;
	}
	/**
	 * @return the onskCapl
	 */
	public BigDecimal getOnskCapl() {
		return onskCapl;
	}
	/**
	 * @param onskCapl the onskCapl to set
	 */
	public void setOnskCapl(BigDecimal onskCapl) {
		this.onskCapl = onskCapl;
	}
	/**
	 * @return the ressInstlAmt
	 */
	public BigDecimal getRessInstlAmt() {
		return ressInstlAmt;
	}
	/**
	 * @param ressInstlAmt the ressInstlAmt to set
	 */
	public void setRessInstlAmt(BigDecimal ressInstlAmt) {
		this.ressInstlAmt = ressInstlAmt;
	}
	/**
	 * @return the fnncAsetEvalPrft
	 */
	public BigDecimal getFnncAsetEvalPrft() {
		return fnncAsetEvalPrft;
	}
	/**
	 * @param fnncAsetEvalPrft the fnncAsetEvalPrft to set
	 */
	public void setFnncAsetEvalPrft(BigDecimal fnncAsetEvalPrft) {
		this.fnncAsetEvalPrft = fnncAsetEvalPrft;
	}
	/**
	 * @return the insuActnPfls
	 */
	public BigDecimal getInsuActnPfls() {
		return insuActnPfls;
	}
	/**
	 * @param insuActnPfls the insuActnPfls to set
	 */
	public void setInsuActnPfls(BigDecimal insuActnPfls) {
		this.insuActnPfls = insuActnPfls;
	}
	/**
	 * @return the asetRessMrpr
	 */
	public BigDecimal getAsetRessMrpr() {
		return asetRessMrpr;
	}
	/**
	 * @param asetRessMrpr the asetRessMrpr to set
	 */
	public void setAsetRessMrpr(BigDecimal asetRessMrpr) {
		this.asetRessMrpr = asetRessMrpr;
	}
	/**
	 * @return the lglInstlAmt
	 */
	public BigDecimal getLglInstlAmt() {
		return lglInstlAmt;
	}
	/**
	 * @param lglInstlAmt the lglInstlAmt to set
	 */
	public void setLglInstlAmt(BigDecimal lglInstlAmt) {
		this.lglInstlAmt = lglInstlAmt;
	}
	/**
	 * @return the corpRtnlInstlAmt
	 */
	public BigDecimal getCorpRtnlInstlAmt() {
		return corpRtnlInstlAmt;
	}
	/**
	 * @param corpRtnlInstlAmt the corpRtnlInstlAmt to set
	 */
	public void setCorpRtnlInstlAmt(BigDecimal corpRtnlInstlAmt) {
		this.corpRtnlInstlAmt = corpRtnlInstlAmt;
	}
	/**
	 * @return the corpInstlAmt
	 */
	public BigDecimal getCorpInstlAmt() {
		return corpInstlAmt;
	}
	/**
	 * @param corpInstlAmt the corpInstlAmt to set
	 */
	public void setCorpInstlAmt(BigDecimal corpInstlAmt) {
		this.corpInstlAmt = corpInstlAmt;
	}
	/**
	 * @return the optnlInstlAmt
	 */
	public BigDecimal getOptnlInstlAmt() {
		return optnlInstlAmt;
	}
	/**
	 * @param optnlInstlAmt the optnlInstlAmt to set
	 */
	public void setOptnlInstlAmt(BigDecimal optnlInstlAmt) {
		this.optnlInstlAmt = optnlInstlAmt;
	}
	/**
	 * @return the dspslPrftSrpl
	 */
	public BigDecimal getDspslPrftSrpl() {
		return dspslPrftSrpl;
	}
	/**
	 * @param dspslPrftSrpl the dspslPrftSrpl to set
	 */
	public void setDspslPrftSrpl(BigDecimal dspslPrftSrpl) {
		this.dspslPrftSrpl = dspslPrftSrpl;
	}
	/**
	 * @return the swayShrs
	 */
	public BigDecimal getSwayShrs() {
		return swayShrs;
	}
	/**
	 * @param swayShrs the swayShrs to set
	 */
	public void setSwayShrs(BigDecimal swayShrs) {
		this.swayShrs = swayShrs;
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





}
