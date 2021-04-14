/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file CO101001IN.java
 * @brief 사용자 목록 조회 IN
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
 * @brief 사용자 목록 조회 IN
 * @details 사용자 목록 조회 IN
 * @author : 차상길
 * @date : 2020. 09. 03.
 * @version : 1.0.0
 */
public class CO101001IN {

	private String empno;                         /* 사원번호 */
	private String empnm;                         /* 사원명 */
	private String deptCd;                        /* 부서코드 */
	private String deptNm;                        /* 부서명 */

	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpnm() {
        return empnm;
    }
    public void setEmpnm(String empnm) {
        this.empnm = empnm;
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

}
