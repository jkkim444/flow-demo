/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file CO000201IN.java
 * @brief 사원 코드 조회 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 4. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 사원 코드 조회 IN
 * @details 사원 코드 조회 IN
 * @author : 차상길
 * @date : 2020. 4. 24.
 * @version : 1.0.0
 */
public class CO000401IN {

	private String deptCd;                        /* 부서코드 */
	private String deptNm;                        /* 부서명 */
	private String empNo;                         /* 사원번호 */
	private String empNm;                         /* 사원명 */

	public String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
}
