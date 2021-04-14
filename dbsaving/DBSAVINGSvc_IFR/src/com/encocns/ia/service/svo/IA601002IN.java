/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501002IN.java
 * @brief IFRS 계정코드 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.math.BigDecimal;
import java.util.List;

import com.encocns.ia.dto.IA601001DTO;

/**
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA601002IN {

	private String baseYm;                           /* 기준년도 */
	private String qtrDivCd;                         /* 분기구분코드 */
	private BigDecimal seqno;                        /* 일련번호 */
	private String asetNm;                           /* 자산명 */
	private String fvLvlCd;                          /* 공정가치수준코드 */
	private BigDecimal bkvalAmt;                     /* 장부가금액 */
	private String usrId;                            /* 사용자ID */
	private List<IA601001DTO> arrList;				 /* 그리드 데이터 */

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
	public BigDecimal getSeqno() {
		return seqno;
	}
	public void setSeqno(BigDecimal seqno) {
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
	public List<IA601001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<IA601001DTO> arrList) {
		this.arrList = arrList;
	}

}
