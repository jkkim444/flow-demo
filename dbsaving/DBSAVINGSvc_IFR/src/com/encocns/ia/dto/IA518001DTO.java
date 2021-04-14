/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515001DTO.java
 * @brief 계리보고서 정보  management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 14. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 기초이월분개처리  management List Query DTO
 * @details 기초이월분개처리  management List Query DTO
 * @author : LEE, MI-RAE
 * @date : 2020. 9. 28.
 * @version : 1.0.0
 */
public class IA518001DTO {

	private String rNum;                                                   /* 순번 */
	private String ifrsAccCd;                                              /* IFRS계정코드 */
	private String ifrsAccNm;                                              /* IFRS계정명 */
	private String fnCdNm;                                                 /* 계정구분 */
	private BigDecimal accAmt;                                             /* IFRS계정금액 */
	private BigDecimal spusIfrsAccAmt;                                     /* 별도IFRS계정금액 */
	private BigDecimal AccAmtMinSpusAccAmt;                                /* DIFF */
	
	
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
	public String getIfrsAccNm() {
		return ifrsAccNm;
	}
	public void setIfrsAccNm(String ifrsAccNm) {
		this.ifrsAccNm = ifrsAccNm;
	}
	public String getFnCdNm() {
		return fnCdNm;
	}
	public void setFnCdNm(String fnCdNm) {
		this.fnCdNm = fnCdNm;
	}
	public BigDecimal getAccAmt() {
		return accAmt;
	}
	public void setAccAmt(BigDecimal accAmt) {
		this.accAmt = accAmt;
	}
	public BigDecimal getSpusIfrsAccAmt() {
		return spusIfrsAccAmt;
	}
	public void setSpusIfrsAccAmt(BigDecimal spusIfrsAccAmt) {
		this.spusIfrsAccAmt = spusIfrsAccAmt;
	}
	public BigDecimal getAccAmtMinSpusAccAmt() {
		return AccAmtMinSpusAccAmt;
	}
	public void setAccAmtMinSpusAccAmt(BigDecimal accAmtMinSpusAccAmt) {
		AccAmtMinSpusAccAmt = accAmtMinSpusAccAmt;
	}
	
}
