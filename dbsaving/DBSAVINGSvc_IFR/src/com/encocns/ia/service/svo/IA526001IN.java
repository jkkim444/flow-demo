/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA513001IN.java
 * @brief 기타유형자산 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 수익증권 재무제표 management IN
 * @details 수익증권 재무제표 management IN
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 20.
 * @version : 1.0.0
 */
public class IA526001IN {
    private String stdrYm;		  /* 검색기준년월 */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
}
