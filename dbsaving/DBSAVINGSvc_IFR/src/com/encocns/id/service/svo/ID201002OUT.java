/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID201002OUT.java
 * @brief 공시보고서 상세 조회 OUT
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

import com.encocns.id.dto.ID201002DTO;

/**
 * @brief 공시보고서 상세 조회 OUT
 * @details 공시보고서 상세 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID201002OUT {
	private List<ID201002DTO> arrList;			/* 보고서 내용 */
	private List<ID201002DTO> arrListMerge;		/* 병합 내용 */

	public List<ID201002DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<ID201002DTO> arrList) {
		this.arrList = arrList;
	}

	public List<ID201002DTO> getArrListMerge() {
		return arrListMerge;
	}

	public void setArrListMerge(List<ID201002DTO> arrListMerge) {
		this.arrListMerge = arrListMerge;
	}
}
