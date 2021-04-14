/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA501001IN.java
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

/**
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA604001IN {

	private String baseYm;                        /* 기준년도 */
	private String lentDivCtnt;                   /* 임대구분내용 */
	private String lese;                          /* 임차인 */
	private String rmkCtnt;                       /* 비고내용 */

    public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getLentDivCtnt() {
		return lentDivCtnt;
	}
	public void setLentDivCtnt(String lentDivCtnt) {
		this.lentDivCtnt = lentDivCtnt;
	}
	public String getLese() {
		return lese;
	}
	public void setLese(String lese) {
		this.lese = lese;
	}
	public String getRmkCtnt() {
		return rmkCtnt;
	}
	public void setRmkCtnt(String rmkCtnt) {
		this.rmkCtnt = rmkCtnt;
	}

}
