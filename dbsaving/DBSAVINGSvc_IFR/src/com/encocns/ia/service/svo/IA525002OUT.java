/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA525002OUT.java
 * @brief 수익증권 합계잔액시산표 management OUT
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
 * @brief 수익증권 합계잔액시산표 management OUT
 * @details 수익증권 합계잔액시산표 management OUT
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA525002OUT {

	private int iResult;	/* 건수 */

    public int getiResult() {
        return iResult;
    }
    public void setiResult(int iResult) {
        this.iResult = iResult;
    }

}
