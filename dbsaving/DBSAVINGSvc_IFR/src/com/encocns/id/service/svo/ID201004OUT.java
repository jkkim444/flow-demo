/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID201004OUT.java
 * @brief 산출 데이터 생성 OUT
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
 * @brief 산출 데이터 생성 OUT
 * @details 산출 데이터 생성 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID201004OUT {

	private int iResult;								/* 건수 */
	private ArrayList<HashMap<String, Object>> mapList; /* 엑셀 데이터 */

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
