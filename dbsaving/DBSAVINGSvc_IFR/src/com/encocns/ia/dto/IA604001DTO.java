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
public class IA604001DTO {

	private String rNum;
	private String baseYm;                           /* 기준년월 */
	private String seqno;                            /* 일련번호 */
	private String lentDivCtnt;                      /* 임대구분내용 */
	private String lese;                             /* 임차인 */
	private BigDecimal setpAmt;                   	 /* 설정금액 */
	private String rmkCtnt;                          /* 비고내용 */
	private String usrId;
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
	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getLentDivCtnt() {
		return lentDivCtnt;
	}
	public void setLentDivCtnt(String lentDivCtnt) {
		this.lentDivCtnt = lentDivCtnt;
	}
	public String getLese() {
		return lese;
	}
	public void setLese(String lese) {
		this.lese = lese;
	}
	public BigDecimal getSetpAmt() {
		return setpAmt;
	}
	public void setSetpAmt(BigDecimal setpAmt) {
		this.setpAmt = setpAmt;
	}
	public String getRmkCtnt() {
		return rmkCtnt;
	}
	public void setRmkCtnt(String rmkCtnt) {
		this.rmkCtnt = rmkCtnt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}



}
