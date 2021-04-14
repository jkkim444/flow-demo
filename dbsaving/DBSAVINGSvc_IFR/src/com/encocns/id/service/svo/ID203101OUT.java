/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID203101OUT.java
 * @brief 공시보고서검증 상세 조회 OUT
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

import com.encocns.id.dto.ID203101DTO;
import com.encocns.id.dto.ID203102DTO;

/**
 * @brief 공시보고서검증 상세 조회 OUT
 * @details 공시보고서검증 상세 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID203101OUT {

	private List<ID203101DTO> arrList;			/* 보고서 내용 */
	private List<ID203102DTO> arrListMerge;		/* 병합 내용 */

	public List<ID203101DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<ID203101DTO> arrList) {
		this.arrList = arrList;
	}
	public List<ID203102DTO> getArrListMerge() {
		return arrListMerge;
	}
	public void setArrListMerge(List<ID203102DTO> arrListMerge) {
		this.arrListMerge = arrListMerge;
	}
}
