/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA608001IN.java
 * @brief 기타포괄손익공정가치내역 조회 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 18. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 기타포괄손익공정가치내역 조회 IN
 * @details 기타포괄손익공정가치내역 조회 IN
 * @author : 차상길
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
public class IA608001IN {

	private String baseYm;                           /* 기준년도 */

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}

}
