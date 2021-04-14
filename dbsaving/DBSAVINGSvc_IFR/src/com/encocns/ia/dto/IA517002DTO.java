/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515001DTO.java
 * @brief 계리보고서 정보 관리 management List Query DTO
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

/**
 * @brief 계리보고서 정보 관리 management List Query DTO
 * @details 계리보고서 정보 관리 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
public class IA517002DTO {

	private String aconRptItemDivCd;                 /* 계리보고서항목구분코드 */
	private String aconRptItemDivVal;                /* 계리보고서항목구분값 */
	/**
	 * @return the aconRptItemDivCd
	 */
	public String getAconRptItemDivCd() {
		return aconRptItemDivCd;
	}
	/**
	 * @param aconRptItemDivCd the aconRptItemDivCd to set
	 */
	public void setAconRptItemDivCd(String aconRptItemDivCd) {
		this.aconRptItemDivCd = aconRptItemDivCd;
	}
	/**
	 * @return the aconRptItemDivVal
	 */
	public String getAconRptItemDivVal() {
		return aconRptItemDivVal;
	}
	/**
	 * @param aconRptItemDivVal the aconRptItemDivVal to set
	 */
	public void setAconRptItemDivVal(String aconRptItemDivVal) {
		this.aconRptItemDivVal = aconRptItemDivVal;
	}



}
