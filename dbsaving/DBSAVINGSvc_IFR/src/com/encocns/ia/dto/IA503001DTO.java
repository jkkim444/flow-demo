/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA503001DTO.java
 * @brief IFRS정산표 산출 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief IFRS정산표 산출 management List Query DTO
 * @details IFRS정산표 산출 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
public class IA503001DTO {

	private String ifrsAccCd;                   /* 계정과목 */
	private String lvelIfrsAccNm;               /* 계정과목명 */
	private String bltAccYn;                    /* 실계정여부 */
	private BigDecimal accAmt;                  /* KGAAP */
	private BigDecimal gnrlDrJrlzAmt;           /* CONVERSION분개 DR */
	private BigDecimal gnrlCrJrlzAmt;           /* CONVERSION분개 CR */
	private BigDecimal spusIfrsAccAmt;          /* IFRS 별도 */
	private BigDecimal cnsgFundAmt1;            /* 흥국5호 */
	private BigDecimal cnsgFundAmt2;            /* 키움6호 */
	private BigDecimal cnsgFundAmt3;            /* 디지비111호 */
	private BigDecimal cnsgFundAmt4;            /* 키움3호 */
	private BigDecimal cnsgFundAmt5;            /* 디지비117호 */
	private BigDecimal cnsgFundAmt6;            /* 디지비117호 */
	private BigDecimal cnsgDrJrlzAmt;           /* 연결분개 DR */
	private BigDecimal cnsgCrJrlzAmt;           /* 연결분개 CR */
	private BigDecimal lnknIfrsAccAmt;          /* IFRS 연결 */

	private String rNum;
	private int scrnIndcOrd;                     /* 화면표시순서 */

	private String toacCd;                   /* K계정과목명 */
	private String ifrsAccDcd;               /* 계정구분코드 */
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
	public BigDecimal getAccAmt() {
		return accAmt;
	}
	public void setAccAmt(BigDecimal accAmt) {
		this.accAmt = accAmt;
	}
	public BigDecimal getGnrlDrJrlzAmt() {
		return gnrlDrJrlzAmt;
	}
	public void setGnrlDrJrlzAmt(BigDecimal gnrlDrJrlzAmt) {
		this.gnrlDrJrlzAmt = gnrlDrJrlzAmt;
	}
	public BigDecimal getGnrlCrJrlzAmt() {
		return gnrlCrJrlzAmt;
	}
	public void setGnrlCrJrlzAmt(BigDecimal gnrlCrJrlzAmt) {
		this.gnrlCrJrlzAmt = gnrlCrJrlzAmt;
	}
	public BigDecimal getSpusIfrsAccAmt() {
		return spusIfrsAccAmt;
	}
	public void setSpusIfrsAccAmt(BigDecimal spusIfrsAccAmt) {
		this.spusIfrsAccAmt = spusIfrsAccAmt;
	}
	public BigDecimal getCnsgFundAmt1() {
		return cnsgFundAmt1;
	}
	public void setCnsgFundAmt1(BigDecimal cnsgFundAmt1) {
		this.cnsgFundAmt1 = cnsgFundAmt1;
	}
	public BigDecimal getCnsgFundAmt2() {
		return cnsgFundAmt2;
	}
	public void setCnsgFundAmt2(BigDecimal cnsgFundAmt2) {
		this.cnsgFundAmt2 = cnsgFundAmt2;
	}
	public BigDecimal getCnsgFundAmt3() {
		return cnsgFundAmt3;
	}
	public void setCnsgFundAmt3(BigDecimal cnsgFundAmt3) {
		this.cnsgFundAmt3 = cnsgFundAmt3;
	}
	public BigDecimal getCnsgFundAmt4() {
		return cnsgFundAmt4;
	}
	public void setCnsgFundAmt4(BigDecimal cnsgFundAmt4) {
		this.cnsgFundAmt4 = cnsgFundAmt4;
	}
	public BigDecimal getCnsgFundAmt5() {
		return cnsgFundAmt5;
	}
	public void setCnsgFundAmt5(BigDecimal cnsgFundAmt5) {
		this.cnsgFundAmt5 = cnsgFundAmt5;
	}
	public BigDecimal getCnsgFundAmt6() {
		return cnsgFundAmt6;
	}
	public void setCnsgFundAmt6(BigDecimal cnsgFundAmt6) {
		this.cnsgFundAmt6 = cnsgFundAmt6;
	}
	public BigDecimal getCnsgDrJrlzAmt() {
		return cnsgDrJrlzAmt;
	}
	public void setCnsgDrJrlzAmt(BigDecimal cnsgDrJrlzAmt) {
		this.cnsgDrJrlzAmt = cnsgDrJrlzAmt;
	}
	public BigDecimal getCnsgCrJrlzAmt() {
		return cnsgCrJrlzAmt;
	}
	public void setCnsgCrJrlzAmt(BigDecimal cnsgCrJrlzAmt) {
		this.cnsgCrJrlzAmt = cnsgCrJrlzAmt;
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
	public int getScrnIndcOrd() {
		return scrnIndcOrd;
	}
	public void setScrnIndcOrd(int scrnIndcOrd) {
		this.scrnIndcOrd = scrnIndcOrd;
	}
	public String getToacCd() {
		return toacCd;
	}
	public void setToacCd(String toacCd) {
		this.toacCd = toacCd;
	}
	public String getIfrsAccDcd() {
		return ifrsAccDcd;
	}
	public void setIfrsAccDcd(String ifrsAccDcd) {
		this.ifrsAccDcd = ifrsAccDcd;
	}



}
