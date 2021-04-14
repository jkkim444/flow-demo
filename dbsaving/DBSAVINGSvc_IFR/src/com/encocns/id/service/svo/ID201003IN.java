/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID201003IN.java
 * @brief 공시보고서 출력 IN
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

import java.util.List;

import com.encocns.id.dto.ID201001DTO;

/**
 * @brief 공시보고서 출력 IN
 * @details 공시보고서 출력 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID201003IN {

	private String baseYm;                           /* 기준년도 */
	private List<ID201001DTO> arrList;               /* 조회 내용 */

	public String getBaseYm() {
		return baseYm;
	}

	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}

	public List<ID201001DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<ID201001DTO> arrList) {
		this.arrList = arrList;
	}
}
