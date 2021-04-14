/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA532003OUT.java
 * @brief KGAAP 계정코드 management OUT
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 11. 18. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief KGAAP 계정코드 management OUT
 * @details KGAAP 계정코드 management OUT
 * @author : LEE, MI-RAE
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
public class IA532003OUT {

	private int iResult;	/* 건수 */

	public int getiResult() {
		return iResult;
	}

	public void setiResult(int iResult) {
		this.iResult = iResult;
	}

}
