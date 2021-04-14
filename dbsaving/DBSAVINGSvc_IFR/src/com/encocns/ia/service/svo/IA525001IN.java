/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA525001IN.java
 * @brief 수익증권 합계잔액시산표 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 수익증권 합계잔액시산표 management IN
 * @details 수익증권 합계잔액시산표 management IN
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA525001IN {
    private String searchStdrYm;                  /* 기준년월 */

	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
}
