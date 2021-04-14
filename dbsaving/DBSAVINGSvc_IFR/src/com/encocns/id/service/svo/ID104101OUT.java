/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID104101OUT.java
 * @brief 헤더 조회 OUT
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

import com.encocns.id.dto.ID104101DTO;
import com.encocns.id.dto.ID104102DTO;

/**
 * @brief 헤더 조회 OUT
 * @details 헤더 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID104101OUT {

	private String pbnfRptNm;                        /* 공시보고서명 */
	private List<ID104101DTO> arrList;               /* 보고서 내용 */
	private List<ID104102DTO> arrListMerge;          /* 병합 내용 */

	public String getPbnfRptNm() {
		return pbnfRptNm;
	}

	public void setPbnfRptNm(String pbnfRptNm) {
		this.pbnfRptNm = pbnfRptNm;
	}

	public List<ID104101DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<ID104101DTO> arrList) {
		this.arrList = arrList;
	}

	public List<ID104102DTO> getArrListMerge() {
		return arrListMerge;
	}

	public void setArrListMerge(List<ID104102DTO> arrListMerge) {
		this.arrListMerge = arrListMerge;
	}
}
