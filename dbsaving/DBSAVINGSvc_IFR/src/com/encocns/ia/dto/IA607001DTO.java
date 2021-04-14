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
public class IA607001DTO {

	private String rNum;                             /* 행번호 */
	private String baseYm;                           /* 기준년월 */
	private String seqno;                            /* 일련번호 */
	private BigDecimal txtnStndStrtAmt;              /* 과세표준시작금액 */
	private BigDecimal txtnStndEndAmt;               /* 과세표준종료금액 */
	private BigDecimal aplyTxrt;                     /* 적용세율 */
	private BigDecimal clclTxam;                     /* 산출세액 */
	private String usrId;                            /* 사용자ID */

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
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public BigDecimal getTxtnStndStrtAmt() {
		return txtnStndStrtAmt;
	}
	public void setTxtnStndStrtAmt(BigDecimal txtnStndStrtAmt) {
		this.txtnStndStrtAmt = txtnStndStrtAmt;
	}
	public BigDecimal getTxtnStndEndAmt() {
		return txtnStndEndAmt;
	}
	public void setTxtnStndEndAmt(BigDecimal txtnStndEndAmt) {
		this.txtnStndEndAmt = txtnStndEndAmt;
	}
	public BigDecimal getAplyTxrt() {
		return aplyTxrt;
	}
	public void setAplyTxrt(BigDecimal aplyTxrt) {
		this.aplyTxrt = aplyTxrt;
	}
	public BigDecimal getClclTxam() {
		return clclTxam;
	}
	public void setClclTxam(BigDecimal clclTxam) {
		this.clclTxam = clclTxam;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
