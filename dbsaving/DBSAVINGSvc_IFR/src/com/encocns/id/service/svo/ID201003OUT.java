/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID201003OUT.java
 * @brief 공시보고서 출력 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.service.svo
 * @brief id SVO Package
 */
package com.encocns.id.service.svo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @brief 공시보고서 출력 OUT
 * @details 공시보고서 출력 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID201003OUT {

	private int iResult;								/* 건수 */
	private ArrayList<HashMap<String, Object>> mapList; /* 엑셀출력 내용 */

	public int getiResult() {
		return iResult;
	}

	public void setiResult(int iResult) {
		this.iResult = iResult;
	}

	public ArrayList<HashMap<String, Object>> getMapList() {
		return mapList;
	}

	public void setMapList(ArrayList<HashMap<String, Object>> mapList) {
		this.mapList = mapList;
	}

}
