/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA527001DTO.java
 * @brief 유가증권처분내역 management List Query DTO
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 05.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

import java.math.BigDecimal;

/**
 * @brief 유가증권처분내역 List Query DTO
 * @details  유가증권처분 요약내역 List Query DTO
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 05.
 * @version : 1.0.0
 */
public class IA527001DTO {

	private String stdrYm;            		    /* 기준년월 */
	private String acngBaseCd;                  /* 회계기준코드 */
	private String fnncGdsItmsNo;               /* 금융상품종목번호 */
	private String fnncGdsDivCd;                /* 금융상품구분코드 */
    private String fnncGdsDivNm;       		    /* 금융상품구분명 */
	private String fnncGdsItmsNm;               /* 금융상품종목명 */
	private String thtrDspslDgre;               /* 당기처분차수 */
	private String kgaapCtgrCd;                 /* KGAAP범주코드 */
	private String kifrsCtgrCd;                 /* KIFRS범주코드 */
	private BigDecimal thtrDspslQty;            /* 당기처분수량 */
	private BigDecimal thtrDspslAcbkamt;        /* 당기처분장부금액 */
	private BigDecimal thtrDspslOciamt;         /* 당기처분OCI금액 */
	private BigDecimal thtrDspslPrftAmt;        /* 당기처분이익금액 */
	private BigDecimal thtrDspslLssAmt;         /* 당기처분손실금액 */
	private String rNum;						/* 행 번호 */
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getAcngBaseCd() {
		return acngBaseCd;
	}
	public void setAcngBaseCd(String acngBaseCd) {
		this.acngBaseCd = acngBaseCd;
	}
	public String getFnncGdsItmsNo() {
		return fnncGdsItmsNo;
	}
	public void setFnncGdsItmsNo(String fnncGdsItmsNo) {
		this.fnncGdsItmsNo = fnncGdsItmsNo;
	}
	public String getThtrDspslDgre() {
		return thtrDspslDgre;
	}
	public void setThtrDspslDgre(String thtrDspslDgre) {
		this.thtrDspslDgre = thtrDspslDgre;
	}
	public String getKgaapCtgrCd() {
		return kgaapCtgrCd;
	}
	public void setKgaapCtgrCd(String kgaapCtgrCd) {
		this.kgaapCtgrCd = kgaapCtgrCd;
	}
	public String getKifrsCtgrCd() {
		return kifrsCtgrCd;
	}
	public void setKifrsCtgrCd(String kifrsCtgrCd) {
		this.kifrsCtgrCd = kifrsCtgrCd;
	}
	public BigDecimal getThtrDspslQty() {
		return thtrDspslQty;
	}
	public void setThtrDspslQty(BigDecimal thtrDspslQty) {
		this.thtrDspslQty = thtrDspslQty;
	}
	public BigDecimal getThtrDspslAcbkamt() {
		return thtrDspslAcbkamt;
	}
	public void setThtrDspslAcbkamt(BigDecimal thtrDspslAcbkamt) {
		this.thtrDspslAcbkamt = thtrDspslAcbkamt;
	}
	public BigDecimal getThtrDspslOciamt() {
		return thtrDspslOciamt;
	}
	public void setThtrDspslOciamt(BigDecimal thtrDspslOciamt) {
		this.thtrDspslOciamt = thtrDspslOciamt;
	}
	public BigDecimal getThtrDspslPrftAmt() {
		return thtrDspslPrftAmt;
	}
	public void setThtrDspslPrftAmt(BigDecimal thtrDspslPrftAmt) {
		this.thtrDspslPrftAmt = thtrDspslPrftAmt;
	}
	public BigDecimal getThtrDspslLssAmt() {
		return thtrDspslLssAmt;
	}
	public void setThtrDspslLssAmt(BigDecimal thtrDspslLssAmt) {
		this.thtrDspslLssAmt = thtrDspslLssAmt;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
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


}
