/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA523001DTO.java
 * @brief 임차시설물 복구충당부채 management List Query DTO
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
 * @brief 임차시설물 복구충당부채 management List Query DTO
 * @details 임차시설물 복구충당부채 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
/**
 * @author HONG, GIL-DONG
 *
 */
public class IA523001DTO {

	private String rNum;                             /* 행 번호 */
	private String stdrYm;                           /* 전기년월 */
	private int seqno;                               /* 일련번호 */
	private String  lnrnBrofCd;                      /* 임대차지점코드 */
	private String enbrDt;                           /* 입점일자 */
	private String cntrDt;                           /* 계약일자 */
	private String rcvrAntciDt;                      /* 복구예상일자 */
	private BigDecimal cntrAre;                      /* 계약면적 */
	private BigDecimal cntrMmCnt;                    /* 계약월수 */
	private BigDecimal rcvrDueMmCnt;                 /* 복구도래월수 */
	private BigDecimal stlmRemdMmCnt;                /* 결산잔여월수 */
	private BigDecimal rcvrAntciAmt;                 /* 복구예상금액 */
	private BigDecimal aplyDcrt;                     /* 적용할인율 */
	private BigDecimal cntrRcvrAprpDbtl;             /* 계약복구충당부채 */
	private BigDecimal stlmRcvrAprpDbtl;             /* 결산복구충당부채 */
	private BigDecimal rbfRcvrAntciCost;             /* 직전복구예상비용 */
	private BigDecimal rcvrAprpDbtlRessAmt;          /* 복구충당부채재평가금액 */
	private BigDecimal rcvrAprpDbtlIfrsBal;          /* 복구충당부채IFRS잔액 */
	private BigDecimal rcvrAprpDbtlInde;             /* 복구충당부채증감 */
	private BigDecimal stlmRentFclts;                /* 결산임차시설물 */
	private BigDecimal stlmDprcCmtl;                 /* 결산상각누계 */
	private BigDecimal rentFcltsIfrsBal;             /* 임차시설물IFRS잔액 */
	private BigDecimal dprcCmtlIfrsBal;              /* 상각누계IFRS잔액 */
	private BigDecimal closeRcvrAprpDbtl;            /* 페점복구충당부채 */
	private BigDecimal closeStlmRentFclts;           /* 페점결산임차시설물 */
	private BigDecimal closeStlmDprcCmtl;            /* 페점결산상각누계 */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getLnrnBrofCd() {
		return lnrnBrofCd;
	}
	public void setLnrnBrofCd(String lnrnBrofCd) {
		this.lnrnBrofCd = lnrnBrofCd;
	}
	public String getEnbrDt() {
		return enbrDt;
	}
	public void setEnbrDt(String enbrDt) {
		this.enbrDt = enbrDt;
	}
	public String getCntrDt() {
		return cntrDt;
	}
	public void setCntrDt(String cntrDt) {
		this.cntrDt = cntrDt;
	}
	public String getRcvrAntciDt() {
		return rcvrAntciDt;
	}
	public void setRcvrAntciDt(String rcvrAntciDt) {
		this.rcvrAntciDt = rcvrAntciDt;
	}
	public BigDecimal getCntrAre() {
		return cntrAre;
	}
	public void setCntrAre(BigDecimal cntrAre) {
		this.cntrAre = cntrAre;
	}
	public BigDecimal getCntrMmCnt() {
		return cntrMmCnt;
	}
	public void setCntrMmCnt(BigDecimal cntrMmCnt) {
		this.cntrMmCnt = cntrMmCnt;
	}
	public BigDecimal getRcvrDueMmCnt() {
		return rcvrDueMmCnt;
	}
	public void setRcvrDueMmCnt(BigDecimal rcvrDueMmCnt) {
		this.rcvrDueMmCnt = rcvrDueMmCnt;
	}
	public BigDecimal getStlmRemdMmCnt() {
		return stlmRemdMmCnt;
	}
	public void setStlmRemdMmCnt(BigDecimal stlmRemdMmCnt) {
		this.stlmRemdMmCnt = stlmRemdMmCnt;
	}
	public BigDecimal getRcvrAntciAmt() {
		return rcvrAntciAmt;
	}
	public void setRcvrAntciAmt(BigDecimal rcvrAntciAmt) {
		this.rcvrAntciAmt = rcvrAntciAmt;
	}
	public BigDecimal getAplyDcrt() {
		return aplyDcrt;
	}
	public void setAplyDcrt(BigDecimal aplyDcrt) {
		this.aplyDcrt = aplyDcrt;
	}
	public BigDecimal getCntrRcvrAprpDbtl() {
		return cntrRcvrAprpDbtl;
	}
	public void setCntrRcvrAprpDbtl(BigDecimal cntrRcvrAprpDbtl) {
		this.cntrRcvrAprpDbtl = cntrRcvrAprpDbtl;
	}
	public BigDecimal getStlmRcvrAprpDbtl() {
		return stlmRcvrAprpDbtl;
	}
	public void setStlmRcvrAprpDbtl(BigDecimal stlmRcvrAprpDbtl) {
		this.stlmRcvrAprpDbtl = stlmRcvrAprpDbtl;
	}
	public BigDecimal getRbfRcvrAntciCost() {
		return rbfRcvrAntciCost;
	}
	public void setRbfRcvrAntciCost(BigDecimal rbfRcvrAntciCost) {
		this.rbfRcvrAntciCost = rbfRcvrAntciCost;
	}
	public BigDecimal getRcvrAprpDbtlRessAmt() {
		return rcvrAprpDbtlRessAmt;
	}
	public void setRcvrAprpDbtlRessAmt(BigDecimal rcvrAprpDbtlRessAmt) {
		this.rcvrAprpDbtlRessAmt = rcvrAprpDbtlRessAmt;
	}
	public BigDecimal getRcvrAprpDbtlIfrsBal() {
		return rcvrAprpDbtlIfrsBal;
	}
	public void setRcvrAprpDbtlIfrsBal(BigDecimal rcvrAprpDbtlIfrsBal) {
		this.rcvrAprpDbtlIfrsBal = rcvrAprpDbtlIfrsBal;
	}
	public BigDecimal getRcvrAprpDbtlInde() {
		return rcvrAprpDbtlInde;
	}
	public void setRcvrAprpDbtlInde(BigDecimal rcvrAprpDbtlInde) {
		this.rcvrAprpDbtlInde = rcvrAprpDbtlInde;
	}
	public BigDecimal getStlmRentFclts() {
		return stlmRentFclts;
	}
	public void setStlmRentFclts(BigDecimal stlmRentFclts) {
		this.stlmRentFclts = stlmRentFclts;
	}
	public BigDecimal getStlmDprcCmtl() {
		return stlmDprcCmtl;
	}
	public void setStlmDprcCmtl(BigDecimal stlmDprcCmtl) {
		this.stlmDprcCmtl = stlmDprcCmtl;
	}
	public BigDecimal getRentFcltsIfrsBal() {
		return rentFcltsIfrsBal;
	}
	public void setRentFcltsIfrsBal(BigDecimal rentFcltsIfrsBal) {
		this.rentFcltsIfrsBal = rentFcltsIfrsBal;
	}
	public BigDecimal getDprcCmtlIfrsBal() {
		return dprcCmtlIfrsBal;
	}
	public void setDprcCmtlIfrsBal(BigDecimal dprcCmtlIfrsBal) {
		this.dprcCmtlIfrsBal = dprcCmtlIfrsBal;
	}
	public BigDecimal getCloseRcvrAprpDbtl() {
		return closeRcvrAprpDbtl;
	}
	public void setCloseRcvrAprpDbtl(BigDecimal closeRcvrAprpDbtl) {
		this.closeRcvrAprpDbtl = closeRcvrAprpDbtl;
	}
	public BigDecimal getCloseStlmRentFclts() {
		return closeStlmRentFclts;
	}
	public void setCloseStlmRentFclts(BigDecimal closeStlmRentFclts) {
		this.closeStlmRentFclts = closeStlmRentFclts;
	}
	public BigDecimal getCloseStlmDprcCmtl() {
		return closeStlmDprcCmtl;
	}
	public void setCloseStlmDprcCmtl(BigDecimal closeStlmDprcCmtl) {
		this.closeStlmDprcCmtl = closeStlmDprcCmtl;
	}



}
