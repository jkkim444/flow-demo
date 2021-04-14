/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA503002DTO.java
 * @brief IFRS정산표 검증 management List Query DTO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 11. 16. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;

/**
 * @brief IFRS정산표 검증 금액 management List Query DTO
 * @details IFRS정산표 검증 금액 management List Query DTO
 * @author : 이동겸
 * @date : 2020. 11. 16.
 * @version : 1.0.0
 */
public class IA503002DTO {

	private String chkKgaap;                  /* KGAAP */
	private String chkSpus;                  /* IFRS 별도 */
	private String chkLnkn;                  /* IFRS 연결 */
	/**
	 * @return the chkKgaap
	 */
	public String getChkKgaap() {
		return chkKgaap;
	}
	/**
	 * @param chkKgaap the chkKgaap to set
	 */
	public void setChkKgaap(String chkKgaap) {
		this.chkKgaap = chkKgaap;
	}
	/**
	 * @return the chkSpus
	 */
	public String getChkSpus() {
		return chkSpus;
	}
	/**
	 * @param chkSpus the chkSpus to set
	 */
	public void setChkSpus(String chkSpus) {
		this.chkSpus = chkSpus;
	}
	/**
	 * @return the chkLnkn
	 */
	public String getChkLnkn() {
		return chkLnkn;
	}
	/**
	 * @param chkLnkn the chkLnkn to set
	 */
	public void setChkLnkn(String chkLnkn) {
		this.chkLnkn = chkLnkn;
	}


}
