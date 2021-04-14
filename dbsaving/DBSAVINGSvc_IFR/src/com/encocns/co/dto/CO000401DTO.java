/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000401DTO.java
 * @brief 사원 코드 조회 DTO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 4. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 사원 코드 조회 DTO
 * @details 사원 코드 조회 DTO
 * @author : 차상길
 * @date : 2020. 4. 24.
 * @version : 1.0.0
 */
public class CO000401DTO {

	private String deptCd;                        /* 부서코드 */
	private String deptNm;                        /* 부서코드 */
	private String empno;                         /* 사번 */
	private String empNm;                         /* 사원명 */

	// 공통 팝업용 변수
	private String cd;                            /* 코드 */
	private String nm;                            /* 명 */

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
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}

}
