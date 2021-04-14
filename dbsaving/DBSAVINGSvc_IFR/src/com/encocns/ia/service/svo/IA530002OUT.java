/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA530002OUT.java
 * @brief IFRS 수정분개 관리 management OUT
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 26.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief IFRS 수정분개 관리 management OUT
 * @details IFRS 수정분개 관리 management OUT
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 26.
 * @version : 1.0.0
 */
public class IA530002OUT {

	private int iResult;		/* 건수 */

    public int getiResult() {
        return iResult;
    }
    public void setiResult(int iResult) {
        this.iResult = iResult;
    }
}
