/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP208003OUT.java
 * @brief 타사연체 여부 즉시업로드 OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 11. 25. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;


/**
 * @brief 타사연체 여부 즉시업로드 management OUT
 * @details 타사연체 여부 즉시업로드 management OUT
 * @author : 이동겸
 * @date : 2020. 11. 25.
 * @version : 1.0.0
 */
public class IP208003OUT {

	private int iResult;	/* 건수 */

	public int getiResult() {
		return iResult;
	}

	public void setiResult(int iResult) {
		this.iResult = iResult;
	}
}
