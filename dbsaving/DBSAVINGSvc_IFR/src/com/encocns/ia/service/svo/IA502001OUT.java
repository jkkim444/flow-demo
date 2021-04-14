/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA502001OUT.java
 * @brief 제무제표 양식 management OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA502001DTO;

/**
 * @brief 제무제표 양식 management OUT
 * @details 제무제표 양식 management OUT
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA502001OUT {
    private int totalCount;			/* 총건수 */
    private int currentPageNo;		/* 페이지 번호 */
    private List<IA502001DTO> list; /* 조회 목록 */

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public List<IA502001DTO> getList() {
		return list;
	}
	public void setList(List<IA502001DTO> list) {
		this.list = list;
	}
}
