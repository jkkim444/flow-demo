/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO102001DTO.java
 * @brief 그룹사용자관리 DTO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 그룹사용자관리 DTO
 * @details 그룹사용자관리 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO205001DTO {

	private int empno;                            /* 사번 */
	private String empKnm;                        /* 사원명 */
	private String deptNm;                        /* 부서코드 */
	private String deptCd;                        /* 부서코드 *//* 코드 */
	private String userId;                        /* 사용자ID */
	private String grpId;                         /* 그룹ID */
	private String regYn;

	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpKnm() {
		return empKnm;
	}
	public void setEmpKnm(String empKnm) {
		this.empKnm = empKnm;
	}
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	public String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public String getRegYn() {
		return regYn;
	}
	public void setRegYn(String regYn) {
		this.regYn = regYn;
	}

}
