/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA508003OUT.java
 * @brief 연결자본변동표 management OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 11. 03. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 연결자본변동표 management OUT
 * @details 연결자본변동표 management OUT
 * @author : 이동겸
 * @date : 2020. 11. 03.
 * @version : 1.0.0
 */
public class IA508003OUT {

	private int iResult;	/* 건수 */

    public int getiResult() {
        return iResult;
    }
    public void setiResult(int iResult) {
        this.iResult = iResult;
    }

}