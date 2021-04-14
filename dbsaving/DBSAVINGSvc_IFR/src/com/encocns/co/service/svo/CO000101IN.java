/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000101IN.java
 * @brief 로그인 IN
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
 * @brief 로그인 IN
 * @details 로그인 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000101IN {

	private int empno;                            /* 사원번호 */
	private String pswd;                          /* 패스워드 */
	private String usrId;                         /* 사용자ID */
	private String menuId;                        /* 메뉴ID */

    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getUsrId() {
        return usrId;
    }
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }
    public String getMenuId() {
        return menuId;
    }
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

}
