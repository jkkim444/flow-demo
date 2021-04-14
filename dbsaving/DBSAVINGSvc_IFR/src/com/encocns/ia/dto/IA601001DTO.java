/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515001DTO.java
 * @brief 수익용 부동산 보유 현황 management List Query DTO
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
 * @brief 수익용 부동산 보유 현황 management List Query DTO
 * @details 수익용 부동산 보유 현황 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA601001DTO {

	private String baseYm;                           /* 기준년월 */
	private String qtrDivCd;                         /* 분기구분코드 */
	private String seqno;                            /* 일련번호 */
	private String asetNm;                           /* 자산명 */
	private String rNum;                             /* 행번호 */
	private String fvLvlCd;                          /* 공정가치수준코드 */
	private BigDecimal bkvalAmt;                  	 /* 장부가금액 */
	private String usrId;                         	 /* 사용자ID */

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getQtrDivCd() {
		return qtrDivCd;
	}
	public void setQtrDivCd(String qtrDivCd) {
		this.qtrDivCd = qtrDivCd;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getAsetNm() {
		return asetNm;
	}
	public void setAsetNm(String asetNm) {
		this.asetNm = asetNm;
	}
	public String getFvLvlCd() {
		return fvLvlCd;
	}
	public void setFvLvlCd(String fvLvlCd) {
		this.fvLvlCd = fvLvlCd;
	}
	public BigDecimal getBkvalAmt() {
		return bkvalAmt;
	}
	public void setBkvalAmt(BigDecimal bkvalAmt) {
		this.bkvalAmt = bkvalAmt;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * @return the rNum
	 */
	public String getrNum() {
		return rNum;
	}
	/**
	 * @param rNum the rNum to set
	 */
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}


}
