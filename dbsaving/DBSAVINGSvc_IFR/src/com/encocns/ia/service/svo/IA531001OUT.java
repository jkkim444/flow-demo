/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA531001OUT.java
 * @brief 기타유형자산 management OUT
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

import com.encocns.ia.dto.IA531001DTO;

/**
 * @brief 기타유형자산 management OUT
 * @details 기타유형자산 management OUT
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA531001OUT {

    private int totalCount;				/* 총 건수 */
    private int currentPageNo;			/* 페이지 번호 */
    private List<IA531001DTO> list;		/* 조회 내용 */
    private String clsnCtnt;			/* 마감여부내용 */

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
	public List<IA531001DTO> getList() {
		return list;
	}
	public void setList(List<IA531001DTO> list) {
		this.list = list;
	}
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
}
