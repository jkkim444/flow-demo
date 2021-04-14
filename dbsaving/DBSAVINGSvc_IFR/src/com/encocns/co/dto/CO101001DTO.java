/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO101001DTO.java
 * @brief 사용자 목록 조회 DTO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 03. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 사용자 목록 조회 DTO
 * @details 사용자 목록 조회 DTO
 * @author : 차상길
 * @date : 2020. 09. 03.
 * @version : 1.0.0
 */
public class CO101001DTO {

	private String empno;                         /* 사번 */
	private String empNm;                         /* 사원명 */
	private String deptCd;                        /* 부서코드 */
	private String deptNm;                        /* 부서코드 */
	private String pswd;                          /* 패스워드 */

	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
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
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

}
