/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA532001DTO.java
 * @brief KGAAP 계정코드 management List Query DTO
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 11. 18. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dto
 * @brief Common DTO Package
 */
package com.encocns.ia.dto;


/**
 * @brief KGAAP 계정코드 management List Query DTO
 * @details KGAAP 계정코드 management List Query DTO
 * @author : LEE, MI-RAE
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
public class IA532001DTO {

	private String toacCd;                           /* KGAAP계정코드 */
	private String toacNm;                           /* KGAAP계정명 */
	private String uprnToacCd;                       /* 상위KGAAP계정코드 */
	private String ifrsAccCd;                        /* IFRS계정코드 */

	private int rNum;                                /* 행번호 */

	public String getToacCd() {
		return toacCd;
	}

	public void setToacCd(String toacCd) {
		this.toacCd = toacCd;
	}

	public String getToacNm() {
		return toacNm;
	}

	public void setToacNm(String toacNm) {
		this.toacNm = toacNm;
	}

	public String getUprnToacCd() {
		return uprnToacCd;
	}

	public void setUprnToacCd(String uprnToacCd) {
		this.uprnToacCd = uprnToacCd;
	}

	public String getIfrsAccCd() {
		return ifrsAccCd;
	}

	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}




}
