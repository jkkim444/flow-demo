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
 * @brief 리스부채사용권관리 management List Query DTO
 * @details 리스부채사용권관리 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA531001DTO {



	private String rNum;
	private String  stdrYm ;
	private int seqno;                       	/* 일련번호 */

	private String leasDivCd;					/* 리스구분코드 */
	private String leasCntrNm;                  /* 리스계약명 */
	private String leasCntrStrtDt;              /* 리스계약시작일자 */
	private String leasCntrEndDt;               /* 리스계약종료일자 */
	private BigDecimal leasCntrMmCnt;           /* 리스계약월수 */
	private BigDecimal leasRemnMmCnt;           /* 리스잔존월수 */
	private BigDecimal leasTrmMmCnt;            /* 리스기간월수 */
	private String leasTrmEndDt;                /* 리스기간종료일자 */
	private BigDecimal leasTrmRemnMmCnt;        /* 리스기간잔존월수 */
	private BigDecimal fixLefe;                 /* 고정리스료 */
	private String endYn;                       /* 종료여부 */
	private String leasChngYn;                  /* 리스개량여부 */
	private String leasChngDt;                  /* 리스개량일자 */


	private BigDecimal uzAsetAmt;               /* 사용자산금액 */
	private BigDecimal dprcCmtlAmt;             /* 상각누계금액 */
	private BigDecimal leasDbtlAmt;             /* 리스부채금액 */
	private BigDecimal dpcs ;                   /* 감가상각비 */
	private BigDecimal intCost;                 /* 이자비용 */
	private BigDecimal hrfeSbtrAmt;             /* 임차료차감금액 */
	private BigDecimal leasDbtlClsPrft;         /* 리스부채해지이익 */
	private BigDecimal leasDbtlClsLss;          /* 리스부채해지손실 */


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
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getLeasDivCd() {
		return leasDivCd;
	}
	public void setLeasDivCd(String leasDivCd) {
		this.leasDivCd = leasDivCd;
	}
	public String getLeasCntrNm() {
		return leasCntrNm;
	}
	public void setLeasCntrNm(String leasCntrNm) {
		this.leasCntrNm = leasCntrNm;
	}
	public String getLeasCntrStrtDt() {
		return leasCntrStrtDt;
	}
	public void setLeasCntrStrtDt(String leasCntrStrtDt) {
		this.leasCntrStrtDt = leasCntrStrtDt;
	}
	public String getLeasCntrEndDt() {
		return leasCntrEndDt;
	}
	public void setLeasCntrEndDt(String leasCntrEndDt) {
		this.leasCntrEndDt = leasCntrEndDt;
	}
	public BigDecimal getLeasCntrMmCnt() {
		return leasCntrMmCnt;
	}
	public void setLeasCntrMmCnt(BigDecimal leasCntrMmCnt) {
		this.leasCntrMmCnt = leasCntrMmCnt;
	}
	public BigDecimal getLeasRemnMmCnt() {
		return leasRemnMmCnt;
	}
	public void setLeasRemnMmCnt(BigDecimal leasRemnMmCnt) {
		this.leasRemnMmCnt = leasRemnMmCnt;
	}
	public BigDecimal getLeasTrmMmCnt() {
		return leasTrmMmCnt;
	}
	public void setLeasTrmMmCnt(BigDecimal leasTrmMmCnt) {
		this.leasTrmMmCnt = leasTrmMmCnt;
	}
	public String getLeasTrmEndDt() {
		return leasTrmEndDt;
	}
	public void setLeasTrmEndDt(String leasTrmEndDt) {
		this.leasTrmEndDt = leasTrmEndDt;
	}
	public BigDecimal getLeasTrmRemnMmCnt() {
		return leasTrmRemnMmCnt;
	}
	public void setLeasTrmRemnMmCnt(BigDecimal leasTrmRemnMmCnt) {
		this.leasTrmRemnMmCnt = leasTrmRemnMmCnt;
	}
	public BigDecimal getFixLefe() {
		return fixLefe;
	}
	public void setFixLefe(BigDecimal fixLefe) {
		this.fixLefe = fixLefe;
	}
	public String getEndYn() {
		return endYn;
	}
	public void setEndYn(String endYn) {
		this.endYn = endYn;
	}
	public String getLeasChngYn() {
		return leasChngYn;
	}
	public void setLeasChngYn(String leasChngYn) {
		this.leasChngYn = leasChngYn;
	}
	public String getLeasChngDt() {
		return leasChngDt;
	}
	public void setLeasChngDt(String leasChngDt) {
		this.leasChngDt = leasChngDt;
	}
	public BigDecimal getUzAsetAmt() {
		return uzAsetAmt;
	}
	public void setUzAsetAmt(BigDecimal uzAsetAmt) {
		this.uzAsetAmt = uzAsetAmt;
	}
	public BigDecimal getDprcCmtlAmt() {
		return dprcCmtlAmt;
	}
	public void setDprcCmtlAmt(BigDecimal dprcCmtlAmt) {
		this.dprcCmtlAmt = dprcCmtlAmt;
	}
	public BigDecimal getLeasDbtlAmt() {
		return leasDbtlAmt;
	}
	public void setLeasDbtlAmt(BigDecimal leasDbtlAmt) {
		this.leasDbtlAmt = leasDbtlAmt;
	}
	public BigDecimal getDpcs() {
		return dpcs;
	}
	public void setDpcs(BigDecimal dpcs) {
		this.dpcs = dpcs;
	}

	public BigDecimal getHrfeSbtrAmt() {
		return hrfeSbtrAmt;
	}
	public void setHrfeSbtrAmt(BigDecimal hrfeSbtrAmt) {
		this.hrfeSbtrAmt = hrfeSbtrAmt;
	}
	public BigDecimal getLeasDbtlClsPrft() {
		return leasDbtlClsPrft;
	}
	public void setLeasDbtlClsPrft(BigDecimal leasDbtlClsPrft) {
		this.leasDbtlClsPrft = leasDbtlClsPrft;
	}
	public BigDecimal getLeasDbtlClsLss() {
		return leasDbtlClsLss;
	}
	public void setLeasDbtlClsLss(BigDecimal leasDbtlClsLss) {
		this.leasDbtlClsLss = leasDbtlClsLss;
	}
	public BigDecimal getIntCost() {
		return intCost;
	}
	public void setIntCost(BigDecimal intCost) {
		this.intCost = intCost;
	}

}
