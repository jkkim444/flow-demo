/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501001DTO.java
 * @brief IFRS 수정분개관리 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 15. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief IFRS 수정분개관리 management List Query DTO
 * @details IFRS 수정분개관리 management List Query DTO
 * @author : 이미래
 * @date : 2020. 10. 15.
 * @version : 1.0.0
 */
public class IA530001DTO {

	private String jlzYm ;                        /* 분개년월 */
	private String jrlzBzwkCd;                    /* 분개업무구분코드 */
	private BigDecimal amndSeqno;                 /* 수정일련번호 */
	private String orjrlzBzwkCd;                  /* 원분개업무코드 */
	private String orjrlzBzwkDtlCd;               /* 원분개업무상세코드 */
	private BigDecimal orSeqno;                   /* 원분개일련번호 */
	private String dbIfrsAccCd;                   /* 차변IFRS계정코드 */
	private String crIfrsAccCd;                   /* 대변IFRS계정코드 */
	private BigDecimal dbAccAmt;                  /* 차변계정금액 */
	private BigDecimal crAccAmt;                  /* 대변계정금액 */
	private String amndJrlzRsnCtnt;               /* 수정분개사유내용 */
	private String cnsgFundYn;                    /* 수탁펀드여부 */
	private String jrlzBzwkDtlCd;                 /* 분개업무상세코드 */
	private String crIfrsAccNm;                   /* IFRS계정명 */
	private String dbIfrsAccNm;                   /* IFRS계정명 */
	private String dbIfrsAccDcd;                  /* IFRS계정구분코드 */
	private String crIfrsAccDcd;                  /* IFRS계정구분코드 */

    private String rNum;						  /* 행번호 */


	public String getJlzYm() {
		return jlzYm;
	}


	public void setJlzYm(String jlzYm) {
		this.jlzYm = jlzYm;
	}


	public String getJrlzBzwkCd() {
		return jrlzBzwkCd;
	}


	public void setJrlzBzwkCd(String jrlzBzwkCd) {
		this.jrlzBzwkCd = jrlzBzwkCd;
	}


	public BigDecimal getAmndSeqno() {
		return amndSeqno;
	}


	public void setAmndSeqno(BigDecimal amndSeqno) {
		this.amndSeqno = amndSeqno;
	}


	public String getOrjrlzBzwkCd() {
		return orjrlzBzwkCd;
	}


	public void setOrjrlzBzwkCd(String orjrlzBzwkCd) {
		this.orjrlzBzwkCd = orjrlzBzwkCd;
	}


	public String getOrjrlzBzwkDtlCd() {
		return orjrlzBzwkDtlCd;
	}


	public void setOrjrlzBzwkDtlCd(String orjrlzBzwkDtlCd) {
		this.orjrlzBzwkDtlCd = orjrlzBzwkDtlCd;
	}


	public BigDecimal getOrSeqno() {
		return orSeqno;
	}


	public void setOrSeqno(BigDecimal orSeqno) {
		this.orSeqno = orSeqno;
	}


	public String getDbIfrsAccCd() {
		return dbIfrsAccCd;
	}


	public void setDbIfrsAccCd(String dbIfrsAccCd) {
		this.dbIfrsAccCd = dbIfrsAccCd;
	}


	public String getCrIfrsAccCd() {
		return crIfrsAccCd;
	}


	public void setCrIfrsAccCd(String crIfrsAccCd) {
		this.crIfrsAccCd = crIfrsAccCd;
	}


	public BigDecimal getDbAccAmt() {
		return dbAccAmt;
	}


	public void setDbAccAmt(BigDecimal dbAccAmt) {
		this.dbAccAmt = dbAccAmt;
	}


	public BigDecimal getCrAccAmt() {
		return crAccAmt;
	}


	public void setCrAccAmt(BigDecimal crAccAmt) {
		this.crAccAmt = crAccAmt;
	}


	public String getAmndJrlzRsnCtnt() {
		return amndJrlzRsnCtnt;
	}


	public void setAmndJrlzRsnCtnt(String amndJrlzRsnCtnt) {
		this.amndJrlzRsnCtnt = amndJrlzRsnCtnt;
	}


	public String getCnsgFundYn() {
		return cnsgFundYn;
	}


	public void setCnsgFundYn(String cnsgFundYn) {
		this.cnsgFundYn = cnsgFundYn;
	}


	public String getJrlzBzwkDtlCd() {
		return jrlzBzwkDtlCd;
	}


	public void setJrlzBzwkDtlCd(String jrlzBzwkDtlCd) {
		this.jrlzBzwkDtlCd = jrlzBzwkDtlCd;
	}


	public String getCrIfrsAccNm() {
		return crIfrsAccNm;
	}


	public void setCrIfrsAccNm(String crIfrsAccNm) {
		this.crIfrsAccNm = crIfrsAccNm;
	}


	public String getDbIfrsAccNm() {
		return dbIfrsAccNm;
	}


	public void setDbIfrsAccNm(String dbIfrsAccNm) {
		this.dbIfrsAccNm = dbIfrsAccNm;
	}


	public String getDbIfrsAccDcd() {
		return dbIfrsAccDcd;
	}


	public void setDbIfrsAccDcd(String dbIfrsAccDcd) {
		this.dbIfrsAccDcd = dbIfrsAccDcd;
	}


	public String getCrIfrsAccDcd() {
		return crIfrsAccDcd;
	}


	public void setCrIfrsAccDcd(String crIfrsAccDcd) {
		this.crIfrsAccDcd = crIfrsAccDcd;
	}


	public String getrNum() {
		return rNum;
	}


	public void setrNum(String rNum) {
		this.rNum = rNum;
	}

}
