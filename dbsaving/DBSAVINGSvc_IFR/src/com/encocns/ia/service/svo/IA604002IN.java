/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501002IN.java
 * @brief IFRS 계정코드 management IN
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
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA604002IN {

	private String baseYm;                           /* 기준년도 */
	private BigDecimal seqno;                        /* 일련번호 */
	private String lentDivCtnt;                      /* 임대구분내용 */
	private String lese;                             /* 임차인 */
	private BigDecimal setpAmt;                      /* 설정금액 */
	private String rmkCtnt;                          /* 비고내용 */
	private String usrId;                            /* 사용자ID */

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
