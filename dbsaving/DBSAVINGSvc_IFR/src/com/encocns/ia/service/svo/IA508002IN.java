/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA508002IN.java
 * @brief 연결자본변동표관리 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 연결자본변동표관리 management IN
 * @details 연결자본변동표관리 management IN
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA508002IN {

	private String stdrYm;                                     /* 기준년월 */
	private String spusLnknDivCd;                              /* 별도연결구분코드 */
	private String frtrYm;									   /* 전기년월 */
	private String usrId;                                      /* 유저ID */


	public String getFrtrYm() {
		return frtrYm;
	}
	public void setFrtrYm(String frtrYm) {
		this.frtrYm = frtrYm;
	}
	public String getSpusLnknDivCd() {
		return spusLnknDivCd;
	}
	public void setSpusLnknDivCd(String spusLnknDivCd) {
		this.spusLnknDivCd = spusLnknDivCd;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
