/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA527002OUT.java
 * @brief 유가증권처분내역 엑셀 저장 management OUT
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

import java.util.List;

import com.encocns.ia.dto.IA527002DTO;

/**
 * @brief 유가증권처분내역 엑셀 저장 management OUT
 * @details 유가증권처분내역 엑셀 저장 management OUT
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 07.
 * @version : 1.0.0
 */
public class IA527002OUT {
	private List<IA527002DTO> arrList;		/* 조회 내용 */

	public List<IA527002DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<IA527002DTO> arrList) {
		this.arrList = arrList;
	}
}
