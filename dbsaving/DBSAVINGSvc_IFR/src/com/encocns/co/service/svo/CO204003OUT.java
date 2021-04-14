/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO204003OUT.java
 * @brief 부서 메뉴 관리 삭제 OUT
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
 * @brief 부서 메뉴 관리 삭제 OUT
 * @details 부서 메뉴 관리 삭제 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO204003OUT {

    private String grpId;
	private int iResult;

	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public int getiResult() {
		return iResult;
	}
	public void setiResult(int iResult) {
		this.iResult = iResult;
	}
}
