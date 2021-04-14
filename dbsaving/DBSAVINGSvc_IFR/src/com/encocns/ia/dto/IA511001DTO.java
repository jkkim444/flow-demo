/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA511001DTO.java
 * @brief IFRS정산표 management List Query DTO
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
 * @brief IFRS정산표 management List Query DTO
 * @details IFRS정산표 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA511001DTO {

	private String ifrsAccCd;                        /* IFRS계정코드 */
	private String lvelIfrsAccNm;                    /* 레벨IFRS계정명 */
	private String bltAccYn;                         /* 실계정여부 */

	private String ifrsAccDcd;                       /* IFRS계정구분코드 */
	private String toacCd;                           /* KGAAP계정코드 */
	private BigDecimal spusIfrsAccAmt;               /* 별도IFRS계정금액 */
	private BigDecimal accAmt;                       /* 계정금액 */
	private BigDecimal lnknIfrsAccAmt;               /* 연결IFRS계정금액 */
	private String rNum;                             /* 행 번호 */

	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
	public String getLvelIfrsAccNm() {
		return lvelIfrsAccNm;
	}
	public void setLvelIfrsAccNm(String lvelIfrsAccNm) {
		this.lvelIfrsAccNm = lvelIfrsAccNm;
	}
	public String getBltAccYn() {
		return bltAccYn;
	}
	public void setBltAccYn(String bltAccYn) {
		this.bltAccYn = bltAccYn;
	}
	public String getIfrsAccDcd() {
		return ifrsAccDcd;
	}
	public void setIfrsAccDcd(String ifrsAccDcd) {
		this.ifrsAccDcd = ifrsAccDcd;
	}
	public String getToacCd() {
		return toacCd;
	}
	public void setToacCd(String toacCd) {
		this.toacCd = toacCd;
	}
	public BigDecimal getSpusIfrsAccAmt() {
		return spusIfrsAccAmt;
	}
	public void setSpusIfrsAccAmt(BigDecimal spusIfrsAccAmt) {
		this.spusIfrsAccAmt = spusIfrsAccAmt;
	}
	public BigDecimal getAccAmt() {
		return accAmt;
	}
	public void setAccAmt(BigDecimal accAmt) {
		this.accAmt = accAmt;
	}
	public BigDecimal getLnknIfrsAccAmt() {
		return lnknIfrsAccAmt;
	}
	public void setLnknIfrsAccAmt(BigDecimal lnknIfrsAccAmt) {
		this.lnknIfrsAccAmt = lnknIfrsAccAmt;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}


}
