/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA509001DTO.java
 * @brief 연결현금흐름표 management List Query DTO
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
 * @brief 연결현금흐름표 management List Query DTO
 * @details 연결현금흐름표 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA509001DTO {

	private String stdrYm;                           /* 전기년월 */
	private String seqno;                            /* 일련번호 */
	private String accNm;                            /* 계정명     */
	private BigDecimal thtmAmt;                      /* 당기금액 */
	private BigDecimal thtmAmt1;                     /* 당기금액1 */
	private BigDecimal bftrmAmt;                     /* 전기금액 */
	private BigDecimal bftrmAmt1;                    /* 전기금액1 */

	private String usrId;                            /* 사용자ID */
	private String rNum;                             /* 행 번호 */

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
	public String getAccNm() {
		return accNm;
	}
	public void setAccNm(String accNm) {
		this.accNm = accNm;
	}
	public BigDecimal getThtmAmt() {
		return thtmAmt;
	}
	public void setThtmAmt(BigDecimal thtmAmt) {
		this.thtmAmt = thtmAmt;
	}
	public BigDecimal getThtmAmt1() {
		return thtmAmt1;
	}
	public void setThtmAmt1(BigDecimal thtmAmt1) {
		this.thtmAmt1 = thtmAmt1;
	}
	public BigDecimal getBftrmAmt() {
		return bftrmAmt;
	}
	public void setBftrmAmt(BigDecimal bftrmAmt) {
		this.bftrmAmt = bftrmAmt;
	}
	public BigDecimal getBftrmAmt1() {
		return bftrmAmt1;
	}
	public void setBftrmAmt1(BigDecimal bftrmAmt1) {
		this.bftrmAmt1 = bftrmAmt1;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}

}
