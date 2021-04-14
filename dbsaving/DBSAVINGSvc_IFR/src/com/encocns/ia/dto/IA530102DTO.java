/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA510001DTO.java
 * @brief IFRS분개전표 management List Query DTO
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
 * @brief IFRS 수정분개 관리_팝업 management OUT
 * @details IFRS 수정분개 관리_팝업 management OUT
 * @author : CHOI,HO-YEON
 * @date : 2020. 10. 15.
 * @version : 1.0.0
 */
public class IA530102DTO {

	private String jlzYm ;
	private String jrlzBzwkcd;               /* 분개업무코드 */
	private String jrlzBzwkDtlCd;            /* 분개업무상세코드 */
	private BigDecimal seqno ;               /* 순번 */
	private String dbIfrsAccNm;              /* 차변계정과목명 */
	private String dbIfrsAccDcd;             /* 차변계정구분 */
	private String dbIfrsAccCd;              /* 차변계정과목 */
	private BigDecimal dbAccAmt;             /* 차변계정금액 */
	private String crIfrsAccNm;              /* 대변계정과목명 */
	private String crIfrsAccCd;              /* 대변계정과목 */
	private String crIfrsAccDcd;             /* 대변계정구분 */
	private BigDecimal crAccAmt;             /* 대변계정금액 */

	private String cnsgFundYn;               /* 수탁펀드여부 */

	public String getJlzYm() {
		return jlzYm;
	}

	public void setJlzYm(String jlzYm) {
		this.jlzYm = jlzYm;
	}

	public String getJrlzBzwkcd() {
		return jrlzBzwkcd;
	}

	public void setJrlzBzwkcd(String jrlzBzwkcd) {
		this.jrlzBzwkcd = jrlzBzwkcd;
	}

	public String getJrlzBzwkDtlCd() {
		return jrlzBzwkDtlCd;
	}

	public void setJrlzBzwkDtlCd(String jrlzBzwkDtlCd) {
		this.jrlzBzwkDtlCd = jrlzBzwkDtlCd;
	}

	public BigDecimal getSeqno() {
		return seqno;
	}

	public void setSeqno(BigDecimal seqno) {
		this.seqno = seqno;
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

	public String getDbIfrsAccCd() {
		return dbIfrsAccCd;
	}

	public void setDbIfrsAccCd(String dbIfrsAccCd) {
		this.dbIfrsAccCd = dbIfrsAccCd;
	}

	public BigDecimal getDbAccAmt() {
		return dbAccAmt;
	}

	public void setDbAccAmt(BigDecimal dbAccAmt) {
		this.dbAccAmt = dbAccAmt;
	}

	public String getCrIfrsAccNm() {
		return crIfrsAccNm;
	}

	public void setCrIfrsAccNm(String crIfrsAccNm) {
		this.crIfrsAccNm = crIfrsAccNm;
	}

	public String getCrIfrsAccCd() {
		return crIfrsAccCd;
	}

	public void setCrIfrsAccCd(String crIfrsAccCd) {
		this.crIfrsAccCd = crIfrsAccCd;
	}

	public String getCrIfrsAccDcd() {
		return crIfrsAccDcd;
	}

	public void setCrIfrsAccDcd(String crIfrsAccDcd) {
		this.crIfrsAccDcd = crIfrsAccDcd;
	}

	public BigDecimal getCrAccAmt() {
		return crAccAmt;
	}

	public void setCrAccAmt(BigDecimal crAccAmt) {
		this.crAccAmt = crAccAmt;
	}

	public String getCnsgFundYn() {
		return cnsgFundYn;
	}

	public void setCnsgFundYn(String cnsgFundYn) {
		this.cnsgFundYn = cnsgFundYn;
	}





}
