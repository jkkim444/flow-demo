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

/**
 * @brief IFRS분개전표 management List Query DTO
 * @details IFRS분개전표 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA511002DTO {

	private String ifrsAccCd;                        /* IFRS계정코드 */
	private String toacCd;                           /* KGAAP계정코드 */
	private String lvelIfrsAccNm;                    /* 레벨IFRS계정명 */
	private String bltAccYn;                         /* 실계정여부 */
	private String accAmt;                           /* 계정금액 */
	private String gnrlDrJrlzAmt;                    /* 일반차변분개금액 */
	private String gnrlCrJrlzAmt;                    /* 일반대변분개금액 */
	private String cnsgDrJrlzAmt;                    /* 수익차변분개금액 */
	private String cnsgCrJrlzAmt;                    /* 수익대변분개금액 */
	private String cnsgFundAmt1;                     /* 흥국5_수탁펀드금액 */
	private String cnsgFundAmt2;                     /* 키움6_수탁펀드금액 */
	private String cnsgFundAmt3;                     /* 디지비111_수탁펀드금액 */
	private String cnsgFundAmt4;                     /* 키움3_수탁펀드금액 */
	private String cnsgFundAmt5;                     /* 디지비117_수탁펀드금액 */
	private String spusIfrsAccAmt;                   /* 별도IFRS계정금액 */
	private String lnknIfrsAccAmt;                   /* 연결IFRS계정금액 */
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
	 * @return the toacCd
	 */
	public String getToacCd() {
		return toacCd;
	}
	/**
	 * @param toacCd the toacCd to set
	 */
	public void setToacCd(String toacCd) {
		this.toacCd = toacCd;
	}
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
	 * @return the bltAccYn
	 */
	public String getBltAccYn() {
		return bltAccYn;
	}
	/**
	 * @param bltAccYn the bltAccYn to set
	 */
	public void setBltAccYn(String bltAccYn) {
		this.bltAccYn = bltAccYn;
	}
	/**
	 * @return the accAmt
	 */
	public String getAccAmt() {
		return accAmt;
	}
	/**
	 * @param accAmt the accAmt to set
	 */
	public void setAccAmt(String accAmt) {
		this.accAmt = accAmt;
	}
	/**
	 * @return the gnrlDrJrlzAmt
	 */
	public String getGnrlDrJrlzAmt() {
		return gnrlDrJrlzAmt;
	}
	/**
	 * @param gnrlDrJrlzAmt the gnrlDrJrlzAmt to set
	 */
	public void setGnrlDrJrlzAmt(String gnrlDrJrlzAmt) {
		this.gnrlDrJrlzAmt = gnrlDrJrlzAmt;
	}
	/**
	 * @return the gnrlCrJrlzAmt
	 */
	public String getGnrlCrJrlzAmt() {
		return gnrlCrJrlzAmt;
	}
	/**
	 * @param gnrlCrJrlzAmt the gnrlCrJrlzAmt to set
	 */
	public void setGnrlCrJrlzAmt(String gnrlCrJrlzAmt) {
		this.gnrlCrJrlzAmt = gnrlCrJrlzAmt;
	}
	/**
	 * @return the cnsgDrJrlzAmt
	 */
	public String getCnsgDrJrlzAmt() {
		return cnsgDrJrlzAmt;
	}
	/**
	 * @param cnsgDrJrlzAmt the cnsgDrJrlzAmt to set
	 */
	public void setCnsgDrJrlzAmt(String cnsgDrJrlzAmt) {
		this.cnsgDrJrlzAmt = cnsgDrJrlzAmt;
	}
	/**
	 * @return the cnsgCrJrlzAmt
	 */
	public String getCnsgCrJrlzAmt() {
		return cnsgCrJrlzAmt;
	}
	/**
	 * @param cnsgCrJrlzAmt the cnsgCrJrlzAmt to set
	 */
	public void setCnsgCrJrlzAmt(String cnsgCrJrlzAmt) {
		this.cnsgCrJrlzAmt = cnsgCrJrlzAmt;
	}
	/**
	 * @return the cnsgFundAmt1
	 */
	public String getCnsgFundAmt1() {
		return cnsgFundAmt1;
	}
	/**
	 * @param cnsgFundAmt1 the cnsgFundAmt1 to set
	 */
	public void setCnsgFundAmt1(String cnsgFundAmt1) {
		this.cnsgFundAmt1 = cnsgFundAmt1;
	}
	/**
	 * @return the cnsgFundAmt2
	 */
	public String getCnsgFundAmt2() {
		return cnsgFundAmt2;
	}
	/**
	 * @param cnsgFundAmt2 the cnsgFundAmt2 to set
	 */
	public void setCnsgFundAmt2(String cnsgFundAmt2) {
		this.cnsgFundAmt2 = cnsgFundAmt2;
	}
	/**
	 * @return the cnsgFundAmt3
	 */
	public String getCnsgFundAmt3() {
		return cnsgFundAmt3;
	}
	/**
	 * @param cnsgFundAmt3 the cnsgFundAmt3 to set
	 */
	public void setCnsgFundAmt3(String cnsgFundAmt3) {
		this.cnsgFundAmt3 = cnsgFundAmt3;
	}
	/**
	 * @return the cnsgFundAmt4
	 */
	public String getCnsgFundAmt4() {
		return cnsgFundAmt4;
	}
	/**
	 * @param cnsgFundAmt4 the cnsgFundAmt4 to set
	 */
	public void setCnsgFundAmt4(String cnsgFundAmt4) {
		this.cnsgFundAmt4 = cnsgFundAmt4;
	}
	/**
	 * @return the cnsgFundAmt5
	 */
	public String getCnsgFundAmt5() {
		return cnsgFundAmt5;
	}
	/**
	 * @param cnsgFundAmt5 the cnsgFundAmt5 to set
	 */
	public void setCnsgFundAmt5(String cnsgFundAmt5) {
		this.cnsgFundAmt5 = cnsgFundAmt5;
	}
	/**
	 * @return the spusIfrsAccAmt
	 */
	public String getSpusIfrsAccAmt() {
		return spusIfrsAccAmt;
	}
	/**
	 * @param spusIfrsAccAmt the spusIfrsAccAmt to set
	 */
	public void setSpusIfrsAccAmt(String spusIfrsAccAmt) {
		this.spusIfrsAccAmt = spusIfrsAccAmt;
	}
	/**
	 * @return the lnknIfrsAccAmt
	 */
	public String getLnknIfrsAccAmt() {
		return lnknIfrsAccAmt;
	}
	/**
	 * @param lnknIfrsAccAmt the lnknIfrsAccAmt to set
	 */
	public void setLnknIfrsAccAmt(String lnknIfrsAccAmt) {
		this.lnknIfrsAccAmt = lnknIfrsAccAmt;
	}

}
