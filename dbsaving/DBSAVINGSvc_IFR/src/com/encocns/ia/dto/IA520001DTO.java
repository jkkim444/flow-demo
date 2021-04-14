/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA520001DTO.java
 * @brief 임대차보증금현재가치산출내역 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 임대차보증금현재가치산출내역 management List Query DTO
 * @details 임대차보증금현재가치산출내역 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 10.
 * @version : 1.0.0
 */
public class IA520001DTO {

	private String rNum;                          /* 행번호 */

	private String stdrYm;                        /* 전기년월 */
	private String seqno;                         /* 일련번호 */
	private String lnrnDvcd;                      /* 임대차구분코드 */
	private String lnrnBrofCd;                    /* 임대차지점코드 */
	private String cntrScd;                       /* 계약상태코드 */
	private BigDecimal grmn;                      /* 보증금 */
	private String lnrnStdd;                      /* 임대차시작일자 */
	private String lnrnEndt;                      /* 임대차종료일자 */
	private int rentMmCnt;                        /* 임차월수 */
	private int ftreMmCnt;                        /* 전기말월수 */
	private int stlmMmCnt;                        /* 결산월수 */
	private BigDecimal intrRt;                    /* 금리 */
	private BigDecimal occuDtPvdac;               /* 발생일자현재가치할인차금 */
	private BigDecimal ftrePvdac;                 /* 전기말현재가치할인차금 */
	private BigDecimal stlmDtPvdac;               /* 결산월현재가치할인차금 */
	private BigDecimal pvdacDprcAmt;              /* 현할차상각금액 */
	private BigDecimal occuDtPrcvPpadRntl;        /* 발생일자선수선급임대료 */
	private BigDecimal ftrePrcvPpadRntl;          /* 전기말선수선급임대료 */
	private BigDecimal stlmDtPrcvPpadRntl;        /* 결산월선수선급임대료 */
	private BigDecimal prcvPpadRntlDprcAmt;       /* 선수선급임대료상각금액 */
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
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getLnrnDvcd() {
		return lnrnDvcd;
	}
	public void setLnrnDvcd(String lnrnDvcd) {
		this.lnrnDvcd = lnrnDvcd;
	}
	public String getLnrnBrofCd() {
		return lnrnBrofCd;
	}
	public void setLnrnBrofCd(String lnrnBrofCd) {
		this.lnrnBrofCd = lnrnBrofCd;
	}
	public String getCntrScd() {
		return cntrScd;
	}
	public void setCntrScd(String cntrScd) {
		this.cntrScd = cntrScd;
	}
	public BigDecimal getGrmn() {
		return grmn;
	}
	public void setGrmn(BigDecimal grmn) {
		this.grmn = grmn;
	}
	public String getLnrnStdd() {
		return lnrnStdd;
	}
	public void setLnrnStdd(String lnrnStdd) {
		this.lnrnStdd = lnrnStdd;
	}
	public String getLnrnEndt() {
		return lnrnEndt;
	}
	public void setLnrnEndt(String lnrnEndt) {
		this.lnrnEndt = lnrnEndt;
	}
	public int getRentMmCnt() {
		return rentMmCnt;
	}
	public void setRentMmCnt(int rentMmCnt) {
		this.rentMmCnt = rentMmCnt;
	}
	public int getFtreMmCnt() {
		return ftreMmCnt;
	}
	public void setFtreMmCnt(int ftreMmCnt) {
		this.ftreMmCnt = ftreMmCnt;
	}
	public int getStlmMmCnt() {
		return stlmMmCnt;
	}
	public void setStlmMmCnt(int stlmMmCnt) {
		this.stlmMmCnt = stlmMmCnt;
	}
	public BigDecimal getIntrRt() {
		return intrRt;
	}
	public void setIntrRt(BigDecimal intrRt) {
		this.intrRt = intrRt;
	}
	public BigDecimal getOccuDtPvdac() {
		return occuDtPvdac;
	}
	public void setOccuDtPvdac(BigDecimal occuDtPvdac) {
		this.occuDtPvdac = occuDtPvdac;
	}
	public BigDecimal getFtrePvdac() {
		return ftrePvdac;
	}
	public void setFtrePvdac(BigDecimal ftrePvdac) {
		this.ftrePvdac = ftrePvdac;
	}
	public BigDecimal getStlmDtPvdac() {
		return stlmDtPvdac;
	}
	public void setStlmDtPvdac(BigDecimal stlmDtPvdac) {
		this.stlmDtPvdac = stlmDtPvdac;
	}
	public BigDecimal getPvdacDprcAmt() {
		return pvdacDprcAmt;
	}
	public void setPvdacDprcAmt(BigDecimal pvdacDprcAmt) {
		this.pvdacDprcAmt = pvdacDprcAmt;
	}
	public BigDecimal getOccuDtPrcvPpadRntl() {
		return occuDtPrcvPpadRntl;
	}
	public void setOccuDtPrcvPpadRntl(BigDecimal occuDtPrcvPpadRntl) {
		this.occuDtPrcvPpadRntl = occuDtPrcvPpadRntl;
	}
	public BigDecimal getFtrePrcvPpadRntl() {
		return ftrePrcvPpadRntl;
	}
	public void setFtrePrcvPpadRntl(BigDecimal ftrePrcvPpadRntl) {
		this.ftrePrcvPpadRntl = ftrePrcvPpadRntl;
	}
	public BigDecimal getStlmDtPrcvPpadRntl() {
		return stlmDtPrcvPpadRntl;
	}
	public void setStlmDtPrcvPpadRntl(BigDecimal stlmDtPrcvPpadRntl) {
		this.stlmDtPrcvPpadRntl = stlmDtPrcvPpadRntl;
	}
	public BigDecimal getPrcvPpadRntlDprcAmt() {
		return prcvPpadRntlDprcAmt;
	}
	public void setPrcvPpadRntlDprcAmt(BigDecimal prcvPpadRntlDprcAmt) {
		this.prcvPpadRntlDprcAmt = prcvPpadRntlDprcAmt;
	}



}
