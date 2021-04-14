/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA505001IN.java
 * @brief 재무상태표 조회 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 마감정보 관리 management IN
 * @details 마감정보 관리 management IN
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA900001OUT {

	private int iResult;                       /* 건수 */

	public int getiResult() {
		return iResult;
	}
	public void setiResult(int iResult) {
		this.iResult = iResult;
	}
}
