/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000001IN.java
 * @brief 홈 화면 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 홈 화면 IN
 * @details 홈 화면 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000001IN {

	private String seEmpno;                       /* 사원번호 */
	private String isBad;

	public String getSeEmpno() {
		return seEmpno;
	}
	public void setSeEmpno(String seEmpno) {
		this.seEmpno = seEmpno;
	}
	public String getIsBad() {
		return isBad;
	}
	public void setIsBad(String isBad) {
		this.isBad = isBad;
	}
}
