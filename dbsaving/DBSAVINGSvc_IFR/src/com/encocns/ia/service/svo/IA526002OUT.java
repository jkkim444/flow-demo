/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA513002OUT.java
 * @brief 기타유형자산 management OUT
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
 * @brief 수익증권 재무제표 관리 management OUT
 * @details 수익증권 재무제표 관리 기초생성 삭제 management OUT
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
public class IA526002OUT {

	private int iResult;	/* 건수 */

    public int getiResult() {
        return iResult;
    }

    public void setiResult(int iResult) {
        this.iResult = iResult;
    }

}
