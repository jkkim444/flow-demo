/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA523002IN.java
 * @brief 임차시설물 복구충당부채 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.math.BigDecimal;

/**
 * @brief 임차시설물 복구충당부채 management IN
 * @details 임차시설물 복구충당부채 management IN
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA523002IN {

	private String stdrYm;                           /* 기준년월 */
	private String frtrYm;                           /* 전기년월 */
	private int seqno;                               /* 일련번호 */
	private String  lnrnBrofCd;                      /* 임대차부점코드 */
	private String enbrDt;                           /* 입점일자 */
	private String cntrDt;                           /* 계약일자 */
	private String rcvrAntciDt;                      /* 복구예상일자 */
	private BigDecimal cntrAre;                      /* 계약면적 */
	private BigDecimal cntrMmCnt;                    /* 계약월수 */
	private BigDecimal aplyDcrt;                     /* 적용할인율 */
	private BigDecimal rbfRcvrAntciCost;             /* 직전복구예상비용 */
	private BigDecimal rcvrAprpDbtlRessAmt;          /* 복구충당부채재평가금액 */
	private BigDecimal closeRcvrAprpDbtl;            /* 페점복구충당부채 */
	private BigDecimal closeStlmRentFclts;           /* 페점결산임차시설물 */
	private BigDecimal closeStlmDprcCmtl;            /* 페점결산상각누계 */
	private String jobDivCd;                         /* 등록수정구분코드 */
	private String usrId;                            /* 사용자ID */

	public String getFrtrYm() {
		return frtrYm;
	}
	public void setFrtrYm(String frtrYm) {
		this.frtrYm = frtrYm;
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
	public BigDecimal getAplyDcrt() {
		return aplyDcrt;
	}
	public void setAplyDcrt(BigDecimal aplyDcrt) {
		this.aplyDcrt = aplyDcrt;
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
	public BigDecimal getCntrMmCnt() {
		return cntrMmCnt;
	}
	public void setCntrMmCnt(BigDecimal cntrMmCnt) {
		this.cntrMmCnt = cntrMmCnt;
	}
}
