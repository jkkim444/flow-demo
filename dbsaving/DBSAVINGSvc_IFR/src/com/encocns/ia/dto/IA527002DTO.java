/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA527002DTO.java
 * @brief 유가증권처분 내역 management List Query DTO
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 06. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 유가증권처분 내역 management List Query DTO
 * @details 유가증권처분 내역 management List Query DTO
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 06.
 * @version : 1.0.0
 */
public class IA527002DTO {

	private String stdrYm;					      /* 기준년월 */
	private String acngBaseCd;				      /* 회계기준코드 */
	private String fnncGdsItmsNo;                 /* 금융상품종목번호 */
	private String thtrDspslDgre;                 /* 당기처분차수 */
	private String fnncGdsDivCd;                  /* 금융상품구분코드 */
	private String fnncGdsDivNm;       		      /* 금융상품구분명 */
	private String fnncGdsItmsNm;                 /* 금융상품종목명 */
	private String kgaapCtgrCd;                   /* KGAAP범주코드 */
	private String kifrsCtgrCd;                   /* KIFRS범주코드 */
	private BigDecimal thtrDspslQty;              /* 당기처분수량 */
	private BigDecimal thtrDspslAcbkAmt;          /* 당기처분장부금액 */
	private BigDecimal thtrDspslOciAmt;           /* 당기처분OCI금액 */
	private BigDecimal thtrDspslPrftAmt;          /* 당기처분이익금액 */
	private BigDecimal thtrDspslLssAmt;           /* 당기처분손실금액 */
	private String usrId;					  	  /* 사용자 ID */

	private int rNum;							  /* 행번호 */


	/**
	 * @return the fnncGdsItmsNo
	 */
	public String getFnncGdsItmsNo() {
		return fnncGdsItmsNo;
	}
	/**
	 * @param fnncGdsItmsNo the fnncGdsItmsNo to set
	 */
	public void setFnncGdsItmsNo(String fnncGdsItmsNo) {
		this.fnncGdsItmsNo = fnncGdsItmsNo;
	}
	/**
	 * @return the thtrDspslDgre
	 */
	public String getThtrDspslDgre() {
		return thtrDspslDgre;
	}
	/**
	 * @param thtrDspslDgre the thtrDspslDgre to set
	 */
	public void setThtrDspslDgre(String thtrDspslDgre) {
		this.thtrDspslDgre = thtrDspslDgre;
	}
	/**
	 * @return the fnncGdsDivCd
	 */
	public String getFnncGdsDivCd() {
		return fnncGdsDivCd;
	}
	/**
	 * @param fnncGdsDivCd the fnncGdsDivCd to set
	 */
	public void setFnncGdsDivCd(String fnncGdsDivCd) {
		this.fnncGdsDivCd = fnncGdsDivCd;
	}
	/**
	 * @return the fnncGdsItmsNm
	 */
	public String getFnncGdsItmsNm() {
		return fnncGdsItmsNm;
	}
	/**
	 * @param fnncGdsItmsNm the fnncGdsItmsNm to set
	 */
	public void setFnncGdsItmsNm(String fnncGdsItmsNm) {
		this.fnncGdsItmsNm = fnncGdsItmsNm;
	}
	/**
	 * @return the kgaapCtgrCd
	 */
	public String getKgaapCtgrCd() {
		return kgaapCtgrCd;
	}
	/**
	 * @param kgaapCtgrCd the kgaapCtgrCd to set
	 */
	public void setKgaapCtgrCd(String kgaapCtgrCd) {
		this.kgaapCtgrCd = kgaapCtgrCd;
	}
	/**
	 * @return the kifrsCtgrCd
	 */
	public String getKifrsCtgrCd() {
		return kifrsCtgrCd;
	}
	/**
	 * @param kifrsCtgrCd the kifrsCtgrCd to set
	 */
	public void setKifrsCtgrCd(String kifrsCtgrCd) {
		this.kifrsCtgrCd = kifrsCtgrCd;
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
	 * @return the acngBaseCd
	 */
	public String getAcngBaseCd() {
		return acngBaseCd;
	}
	/**
	 * @param acngBaseCd the acngBaseCd to set
	 */
	public void setAcngBaseCd(String acngBaseCd) {
		this.acngBaseCd = acngBaseCd;
	}
	/**
	 * @return the fnncGdsDivNm
	 */
	public String getFnncGdsDivNm() {
		return fnncGdsDivNm;
	}
	/**
	 * @param fnncGdsDivNm the fnncGdsDivNm to set
	 */
	public void setFnncGdsDivNm(String fnncGdsDivNm) {
		this.fnncGdsDivNm = fnncGdsDivNm;
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
	 * @return the thtrDspslQty
	 */
	public BigDecimal getThtrDspslQty() {
		return thtrDspslQty;
	}
	/**
	 * @param thtrDspslQty the thtrDspslQty to set
	 */
	public void setThtrDspslQty(BigDecimal thtrDspslQty) {
		this.thtrDspslQty = thtrDspslQty;
	}
	/**
	 * @return the thtrDspslAcbkAmt
	 */
	public BigDecimal getThtrDspslAcbkAmt() {
		return thtrDspslAcbkAmt;
	}
	/**
	 * @param thtrDspslAcbkAmt the thtrDspslAcbkAmt to set
	 */
	public void setThtrDspslAcbkAmt(BigDecimal thtrDspslAcbkAmt) {
		this.thtrDspslAcbkAmt = thtrDspslAcbkAmt;
	}
	/**
	 * @return the thtrDspslOciAmt
	 */
	public BigDecimal getThtrDspslOciAmt() {
		return thtrDspslOciAmt;
	}
	/**
	 * @param thtrDspslOciAmt the thtrDspslOciAmt to set
	 */
	public void setThtrDspslOciAmt(BigDecimal thtrDspslOciAmt) {
		this.thtrDspslOciAmt = thtrDspslOciAmt;
	}
	/**
	 * @return the thtrDspslPrftAmt
	 */
	public BigDecimal getThtrDspslPrftAmt() {
		return thtrDspslPrftAmt;
	}
	/**
	 * @param thtrDspslPrftAmt the thtrDspslPrftAmt to set
	 */
	public void setThtrDspslPrftAmt(BigDecimal thtrDspslPrftAmt) {
		this.thtrDspslPrftAmt = thtrDspslPrftAmt;
	}
	/**
	 * @return the thtrDspslLssAmt
	 */
	public BigDecimal getThtrDspslLssAmt() {
		return thtrDspslLssAmt;
	}
	/**
	 * @param thtrDspslLssAmt the thtrDspslLssAmt to set
	 */
	public void setThtrDspslLssAmt(BigDecimal thtrDspslLssAmt) {
		this.thtrDspslLssAmt = thtrDspslLssAmt;
	}
	/**
	 * @return the rNum
	 */
	public int getrNum() {
		return rNum;
	}
	/**
	 * @param rNum the rNum to set
	 */
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}


}
