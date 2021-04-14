/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO101002IN.java
 * @brief 사용자 정보 등록 및 수정 IN
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
 * @brief 사용자 정보 등록 및 수정 IN
 * @details 사용자 정보 등록 및 수정 IN
 * @author : 차상길
 * @date : 2020. 09. 03.
 * @version : 1.0.0
 */
public class CO101002IN {

	private String deptCd;                        /* 부서코드 */
	private String empno;                         /* 사원번호 */
	private String empnm;                         /* 사원명 */
	private String pswd;                          /* 패스워드 */
	private String jobDivCd;                      /* 코드 */
	private String userId;                        /* 사용자ID */

	public String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	public String getEmpnm() {
		return empnm;
	}
	public void setEmpnm(String empnm) {
		this.empnm = empnm;
	}
	public String getJobDivCd() {
		return jobDivCd;
	}
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
