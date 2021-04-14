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
public class IA523003DTO {

	private String stdrYm;                           /* 전기년월 */
	private int seqno;                               /* 일련번호 */
	private String brcd;                             /* 부점코드 */
	private String brcdNm;                           /* 부점명 */
	private String rcvrOblgYn;
	private double rentAre;                          /* 임차면적 */
	private String frstUzDt;
	private String finAntciDt;
	private int cnpdMcnt;
	private int ftreTrmMcnt;
	private int dsacTrmMcnt;
	private BigDecimal estiRcost;                    /* 복구비용 */
	private BigDecimal acqsAmt;                      /* 취득금액 */
	private BigDecimal ftreDprcCmtlAmt;              /* 상각누계금액 */
	private BigDecimal dsacDprcCmtlAmt;              /* 상각누계금액 */
	private BigDecimal deprcCmtlAmt;                 /* 감가상각누계액 */
	private BigDecimal ftreRcvrPrvsn;
	private BigDecimal eoctRcvrPrvsnRntl;
	private BigDecimal rcvrPrvsn;
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
	 * @return the brcd
	 */
	public String getBrcd() {
		return brcd;
	}
	/**
	 * @param brcd the brcd to set
	 */
	public void setBrcd(String brcd) {
		this.brcd = brcd;
	}
	/**
	 * @return the brcdNm
	 */
	public String getBrcdNm() {
		return brcdNm;
	}
	/**
	 * @param brcdNm the brcdNm to set
	 */
	public void setBrcdNm(String brcdNm) {
		this.brcdNm = brcdNm;
	}
	/**
	 * @return the rcvrOblgYn
	 */
	public String getRcvrOblgYn() {
		return rcvrOblgYn;
	}
	/**
	 * @param rcvrOblgYn the rcvrOblgYn to set
	 */
	public void setRcvrOblgYn(String rcvrOblgYn) {
		this.rcvrOblgYn = rcvrOblgYn;
	}
	/**
	 * @return the rentAre
	 */
	public double getRentAre() {
		return rentAre;
	}
	/**
	 * @param rentAre the rentAre to set
	 */
	public void setRentAre(double rentAre) {
		this.rentAre = rentAre;
	}
	/**
	 * @return the frstUzDt
	 */
	public String getFrstUzDt() {
		return frstUzDt;
	}
	/**
	 * @param frstUzDt the frstUzDt to set
	 */
	public void setFrstUzDt(String frstUzDt) {
		this.frstUzDt = frstUzDt;
	}
	/**
	 * @return the finAntciDt
	 */
	public String getFinAntciDt() {
		return finAntciDt;
	}
	/**
	 * @param finAntciDt the finAntciDt to set
	 */
	public void setFinAntciDt(String finAntciDt) {
		this.finAntciDt = finAntciDt;
	}
	/**
	 * @return the cnpdMcnt
	 */
	public int getCnpdMcnt() {
		return cnpdMcnt;
	}
	/**
	 * @param cnpdMcnt the cnpdMcnt to set
	 */
	public void setCnpdMcnt(int cnpdMcnt) {
		this.cnpdMcnt = cnpdMcnt;
	}
	/**
	 * @return the ftreTrmMcnt
	 */
	public int getFtreTrmMcnt() {
		return ftreTrmMcnt;
	}
	/**
	 * @param ftreTrmMcnt the ftreTrmMcnt to set
	 */
	public void setFtreTrmMcnt(int ftreTrmMcnt) {
		this.ftreTrmMcnt = ftreTrmMcnt;
	}
	/**
	 * @return the dsacTrmMcnt
	 */
	public int getDsacTrmMcnt() {
		return dsacTrmMcnt;
	}
	/**
	 * @param dsacTrmMcnt the dsacTrmMcnt to set
	 */
	public void setDsacTrmMcnt(int dsacTrmMcnt) {
		this.dsacTrmMcnt = dsacTrmMcnt;
	}
	/**
	 * @return the estiRcost
	 */
	public BigDecimal getEstiRcost() {
		return estiRcost;
	}
	/**
	 * @param estiRcost the estiRcost to set
	 */
	public void setEstiRcost(BigDecimal estiRcost) {
		this.estiRcost = estiRcost;
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
	 * @return the ftreDprcCmtlAmt
	 */
	public BigDecimal getFtreDprcCmtlAmt() {
		return ftreDprcCmtlAmt;
	}
	/**
	 * @param ftreDprcCmtlAmt the ftreDprcCmtlAmt to set
	 */
	public void setFtreDprcCmtlAmt(BigDecimal ftreDprcCmtlAmt) {
		this.ftreDprcCmtlAmt = ftreDprcCmtlAmt;
	}
	/**
	 * @return the dsacDprcCmtlAmt
	 */
	public BigDecimal getDsacDprcCmtlAmt() {
		return dsacDprcCmtlAmt;
	}
	/**
	 * @param dsacDprcCmtlAmt the dsacDprcCmtlAmt to set
	 */
	public void setDsacDprcCmtlAmt(BigDecimal dsacDprcCmtlAmt) {
		this.dsacDprcCmtlAmt = dsacDprcCmtlAmt;
	}
	/**
	 * @return the deprcCmtlAmt
	 */
	public BigDecimal getDeprcCmtlAmt() {
		return deprcCmtlAmt;
	}
	/**
	 * @param deprcCmtlAmt the deprcCmtlAmt to set
	 */
	public void setDeprcCmtlAmt(BigDecimal deprcCmtlAmt) {
		this.deprcCmtlAmt = deprcCmtlAmt;
	}
	/**
	 * @return the ftreRcvrPrvsn
	 */
	public BigDecimal getFtreRcvrPrvsn() {
		return ftreRcvrPrvsn;
	}
	/**
	 * @param ftreRcvrPrvsn the ftreRcvrPrvsn to set
	 */
	public void setFtreRcvrPrvsn(BigDecimal ftreRcvrPrvsn) {
		this.ftreRcvrPrvsn = ftreRcvrPrvsn;
	}
	/**
	 * @return the eoctRcvrPrvsnRntl
	 */
	public BigDecimal getEoctRcvrPrvsnRntl() {
		return eoctRcvrPrvsnRntl;
	}
	/**
	 * @param eoctRcvrPrvsnRntl the eoctRcvrPrvsnRntl to set
	 */
	public void setEoctRcvrPrvsnRntl(BigDecimal eoctRcvrPrvsnRntl) {
		this.eoctRcvrPrvsnRntl = eoctRcvrPrvsnRntl;
	}
	/**
	 * @return the rcvrPrvsn
	 */
	public BigDecimal getRcvrPrvsn() {
		return rcvrPrvsn;
	}
	/**
	 * @param rcvrPrvsn the rcvrPrvsn to set
	 */
	public void setRcvrPrvsn(BigDecimal rcvrPrvsn) {
		this.rcvrPrvsn = rcvrPrvsn;
	}



}
