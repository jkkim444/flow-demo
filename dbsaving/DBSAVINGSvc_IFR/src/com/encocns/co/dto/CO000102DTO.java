/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000102DTO.java
 * @brief 로그인 사용자 DTO
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
 * @brief 로그인 사용자 DTO
 * @details 로그인 사용자 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000102DTO {

	private String authCd;                        /* 권한코드 */
	private int empno;                            /* 사번 */
	private String deptCd;                        /* 부서코드 */
	private String deptNm;                        /* 부서코드 */
	private String profitDeptCd;                  /* 부서코드 */

    public String getAuthCd() {
        return authCd;
    }

    public void setAuthCd(String authCd) {
        this.authCd = authCd;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
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

    public String getProfitDeptCd() {
        return profitDeptCd;
    }

    public void setProfitDeptCd(String profitDeptCd) {
        this.profitDeptCd = profitDeptCd;
    }


}
