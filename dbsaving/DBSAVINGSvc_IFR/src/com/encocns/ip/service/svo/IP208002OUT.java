/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP208001OUT.java
 * @brief 금대손충당금 대상 OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;


/**
 * @brief 금대손충당금 대상 management OUT
 * @details 금대손충당금 대상 management OUT
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP208002OUT {

	private int iResult;		/* 건수 */

	public int getiResult() {
		return iResult;
	}
	public void setiResult(int iResult) {
		this.iResult = iResult;
	}
}
