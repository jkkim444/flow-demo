/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA527003IN.java
 * @brief 유가증권처분내역 업로드 management IN
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 05.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA528001DTO;

/**
 * @brief 유가증권기초 내역 업로드 management IN
 * @details 유가증권기초 내역 업로드 management IN
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 12.
 * @version : 1.0.0
 */
public class IA528003IN {

	private List<IA528001DTO> insertExelList;		/* 엑셀업로드데이터 */

	public List<IA528001DTO> getInsertExelList() {
		return insertExelList;
	}
	public void setInsertExelList(List<IA528001DTO> insertExelList) {
		this.insertExelList = insertExelList;
	}
}
