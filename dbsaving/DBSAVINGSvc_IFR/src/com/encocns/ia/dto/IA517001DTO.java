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
 * @brief 계리보고서 정보  management List Query DTO
 * @details 계리보고서 정보  management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
public class IA517001DTO {

	private String cdNm;                             /* 코드명 */
	private String stdrYm;                           /* 전기년월 */
	private BigDecimal frmRetmSlry;                  /* 확정기여형 퇴직급여 */
	private String aconRptItemDivCd;                 /* 계리보고서항목구분코드 */
	private String aconRptItemDivVal;                /* 계리보고서항목구분값 */
	private String aconInfoRptDivCd;                 /* 계리정보보고서구분코드 */

	private String usrId;                            /* 사용자ID */
	private String rNum;                             /* 행 번호*/


	/**
	 * @return the frmRetmSlry
	 */
	public BigDecimal getFrmRetmSlry() {
		return frmRetmSlry;
	}
	/**
	 * @param frmRetmSlry the frmRetmSlry to set
	 */
	public void setFrmRetmSlry(BigDecimal frmRetmSlry) {
		this.frmRetmSlry = frmRetmSlry;
	}
	public String getCdNm() {
		return cdNm;
	}
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getAconRptItemDivCd() {
		return aconRptItemDivCd;
	}
	public void setAconRptItemDivCd(String aconRptItemDivCd) {
		this.aconRptItemDivCd = aconRptItemDivCd;
	}
	public String getAconRptItemDivVal() {
		return aconRptItemDivVal;
	}
	public void setAconRptItemDivVal(String aconRptItemDivVal) {
		this.aconRptItemDivVal = aconRptItemDivVal;
	}
	public String getAconInfoRptDivCd() {
		return aconInfoRptDivCd;
	}
	public void setAconInfoRptDivCd(String aconInfoRptDivCd) {
		this.aconInfoRptDivCd = aconInfoRptDivCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}



}
