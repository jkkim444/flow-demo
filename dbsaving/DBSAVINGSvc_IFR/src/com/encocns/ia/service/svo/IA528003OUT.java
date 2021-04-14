/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501002OUT.java
 * @brief 유가증권처분내역 엑셀 업로드 management OUT
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 07.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 유가증권기초 내역 엑셀 업로드 management OUT
 * @details 유가증권기초 내역 엑셀 업로드 management OUT
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 12.
 * @version : 1.0.0
 */
public class IA528003OUT {

	private int iResult;		/* 건수 */

    public int getiResult() {
        return iResult;
    }
    public void setiResult(int iResult) {
        this.iResult = iResult;
    }
}
