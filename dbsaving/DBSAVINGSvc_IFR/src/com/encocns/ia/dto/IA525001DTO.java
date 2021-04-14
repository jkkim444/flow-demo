/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA525001DTO.java
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
public class IA525001DTO {

	private String stdrYm;                           /* 전기년월 */
	private String ifrsAccCd;                        /* IFRS계정코드 */
	private String ifrsAccNm;                        /* IFRS계정명 */
	private String ifrsAccDcd;                       /* IFRS계정구분코드 */
	private int toacLvel ;                           /* 계정과목레벨 */
	private String lvelIfrsAccNm ;                   /* 레벨IFRS계정명 */
	private BigDecimal cnsgFundAmt1;                 /* 흥국5_수탁펀드금액 */
	private BigDecimal cnsgFundAmt2;                 /* 키움6_수탁펀드금액 */
	private BigDecimal cnsgFundAmt3;                 /* 디지비111_수탁펀드금액 */
	private BigDecimal cnsgFundAmt4;                 /* 키움3_수탁펀드금액 */
	private BigDecimal cnsgFundAmt5;                 /* 디지비117_수탁펀드금액 */
	private String usrId;                            /* 사용자ID */

	/**
	 * @return the lvelIfrsAccNm
	 */
	public String getLvelIfrsAccNm() {
		return lvelIfrsAccNm;
	}
	/**
	 * @param lvelIfrsAccNm the lvelIfrsAccNm to set
	 */
	public void setLvelIfrsAccNm(String lvelIfrsAccNm) {
		this.lvelIfrsAccNm = lvelIfrsAccNm;
	}
	/**
	 * @return the toacLvel
	 */
	public int getToacLvel() {
		return toacLvel;
	}
	/**
	 * @param toacLvel the toacLvel to set
	 */
	public void setToacLvel(int toacLvel) {
		this.toacLvel = toacLvel;
	}
	/**
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}
	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * @return the stdrYm
	 */
	public String getStdrYm() {
		return stdrYm;
	}
	/**
	 * @param stdrYm the stdrYm to set
	 */
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
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
	/**
	 * @return the ifrsAccDcd
	 */
	public String getIfrsAccDcd() {
		return ifrsAccDcd;
	}
	/**
	 * @param ifrsAccDcd the ifrsAccDcd to set
	 */
	public void setIfrsAccDcd(String ifrsAccDcd) {
		this.ifrsAccDcd = ifrsAccDcd;
	}




}
