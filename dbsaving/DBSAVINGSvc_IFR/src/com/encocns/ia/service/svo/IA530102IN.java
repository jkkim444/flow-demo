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
 * @brief IFRS 수정분개관리 management IN
 * @details IFRS 수정분개관리 management IN
 * @author : CHOI,HO-YEON
 * @date : 2020. 10. 15.
 * @version : 1.0.0
 */
public class IA530102IN {

	private String jlzYm ;					 /* 분개년월 */
	private String jrlzBzwkCd;               /* 분개업무코드 */
	private String orjrlzBzwkCd ;            /* 원분개업무코드 */
	private String orjrlzBzwkDtlCd;          /* 원분개업무상세코드 */
	private BigDecimal orSeqno;              /* 원일련번호 */
	private String dbIfrsAccCd;              /* 차변계정코드 */
	private String crIfrsAccCd;              /* 대변계정코드 */
	private BigDecimal dbAccAmt;             /* 차변계정금액 */
	private BigDecimal crAccAmt;			 /* 대변계정금액 */
	private String amndJrlzRsnCtnt;			 /* 분개수정사유 */
	private String cnsgFundYn;               /* 수탁펀드여부 */

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
}
