/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA525002DTO.java
 * @brief 수익증권 합계잔액시산표 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 수익증권 합계잔액시산표 management List Query DTO
 * @details 수익증권 합계잔액시산표 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA525002DTO {

	private String ifrsAccCd;                        /* IFRS계정코드 */
	private String ifrsAccNm;                        /* IFRS계정명 */
	private BigDecimal cnsgFundAmt1;                 /* 흥국5_수탁펀드금액 */
	private BigDecimal cnsgFundAmt2;                 /* 키움6_수탁펀드금액 */
	private BigDecimal cnsgFundAmt3;                 /* 디지비111_수탁펀드금액 */
	private BigDecimal cnsgFundAmt4;                 /* 키움3_수탁펀드금액 */
	private BigDecimal cnsgFundAmt5;                 /* 디지비117_수탁펀드금액 */
	/**
	 * @return the ifrsAccCd
	 */
	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	/**
	 * @param ifrsAccCd the ifrsAccCd to set
	 */
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}
	/**
	 * @return the ifrsAccNm
	 */
	public String getIfrsAccNm() {
		return ifrsAccNm;
	}
	/**
	 * @param ifrsAccNm the ifrsAccNm to set
	 */
	public void setIfrsAccNm(String ifrsAccNm) {
		this.ifrsAccNm = ifrsAccNm;
	}
	/**
	 * @return the cnsgFundAmt1
	 */
	public BigDecimal getCnsgFundAmt1() {
		return cnsgFundAmt1;
	}
	/**
	 * @param cnsgFundAmt1 the cnsgFundAmt1 to set
	 */
	public void setCnsgFundAmt1(BigDecimal cnsgFundAmt1) {
		this.cnsgFundAmt1 = cnsgFundAmt1;
	}
	/**
	 * @return the cnsgFundAmt2
	 */
	public BigDecimal getCnsgFundAmt2() {
		return cnsgFundAmt2;
	}
	/**
	 * @param cnsgFundAmt2 the cnsgFundAmt2 to set
	 */
	public void setCnsgFundAmt2(BigDecimal cnsgFundAmt2) {
		this.cnsgFundAmt2 = cnsgFundAmt2;
	}
	/**
	 * @return the cnsgFundAmt3
	 */
	public BigDecimal getCnsgFundAmt3() {
		return cnsgFundAmt3;
	}
	/**
	 * @param cnsgFundAmt3 the cnsgFundAmt3 to set
	 */
	public void setCnsgFundAmt3(BigDecimal cnsgFundAmt3) {
		this.cnsgFundAmt3 = cnsgFundAmt3;
	}
	/**
	 * @return the cnsgFundAmt4
	 */
	public BigDecimal getCnsgFundAmt4() {
		return cnsgFundAmt4;
	}
	/**
	 * @param cnsgFundAmt4 the cnsgFundAmt4 to set
	 */
	public void setCnsgFundAmt4(BigDecimal cnsgFundAmt4) {
		this.cnsgFundAmt4 = cnsgFundAmt4;
	}
	/**
	 * @return the cnsgFundAmt5
	 */
	public BigDecimal getCnsgFundAmt5() {
		return cnsgFundAmt5;
	}
	/**
	 * @param cnsgFundAmt5 the cnsgFundAmt5 to set
	 */
	public void setCnsgFundAmt5(BigDecimal cnsgFundAmt5) {
		this.cnsgFundAmt5 = cnsgFundAmt5;
	}


}
