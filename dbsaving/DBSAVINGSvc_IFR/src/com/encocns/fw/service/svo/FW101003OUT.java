/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW101003OUT.java
 * @brief Service Management OUT
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 6. 20. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

/**
 * @brief Service Management OUT
 * @details Service Management OUT
 * @author : CHA, SANG-GIL
 * @date : 2019. 6. 20.
 * @version : 1.0.0
 */
public class FW101003OUT {

	private int iResult;	/* 건수 */

	public int getiResult() {
		return iResult;
	}

	public void setiResult(int iResult) {
		this.iResult = iResult;
	}

}
