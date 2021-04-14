/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO101003IN.java
 * @brief 사용자 정보 삭제 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 03. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 사용자 정보 삭제 IN
 * @details 사용자 정보 삭제 IN
 * @author : 차상길
 * @date : 2020. 09. 03.
 * @version : 1.0.0
 */
public class CO101003IN {

	private String empno;                         /* 사원번호 */

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

}
