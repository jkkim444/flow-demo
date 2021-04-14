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
public class IA605001DTO {

	private String baseYm;                        /* 기준년월 */
	private String rNum;                          /* 행번호 */
	private BigDecimal seqno;                     /* 일련번호 */
	private String acntDiv;                       /* 계정구분 */
	private String itmsDivCtnt;                   /* 종목구분내용 */
	private BigDecimal totAset;                   /* 총자산 */
	private BigDecimal acbkAmt;                   /* 장부금액 */
	private String usrId;						  /* 사용자ID */

	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public BigDecimal getSeqno() {
		return seqno;
	}
	public void setSeqno(BigDecimal seqno) {
		this.seqno = seqno;
	}
	public String getAcntDiv() {
		return acntDiv;
	}
	public void setAcntDiv(String acntDiv) {
		this.acntDiv = acntDiv;
	}
	public String getItmsDivCtnt() {
		return itmsDivCtnt;
	}
	public void setItmsDivCtnt(String itmsDivCtnt) {
		this.itmsDivCtnt = itmsDivCtnt;
	}
	public BigDecimal getTotAset() {
		return totAset;
	}
	public void setTotAset(BigDecimal totAset) {
		this.totAset = totAset;
	}
	public BigDecimal getAcbkAmt() {
		return acbkAmt;
	}
	public void setAcbkAmt(BigDecimal acbkAmt) {
		this.acbkAmt = acbkAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}


}
