/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP204001OUT.java
 * @brief 개별평가대상 기본 OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

import java.util.List;

import com.encocns.ip.dto.IP204001DTO;

/**
 * @brief 개별평가대상 기본 management OUT
 * @details 개별평가대상 기본 management OUT
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP204001OUT {
    private int totalCount;				/* 총 건수 */
    private int currentPageNo;			/* 페이지 번호 */
    private List<IP204001DTO> list;		/* 조회 내용 */
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
	public List<IP204001DTO> getList() {
		return list;
	}
	public void setList(List<IP204001DTO> list) {
		this.list = list;
	}
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
}
