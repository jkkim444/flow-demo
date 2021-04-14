/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP201001OUT.java
 * @brief F/L반영 PD관리 OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

import java.util.List;

import com.encocns.ip.dto.IP201001DTO;

/**
 * @brief F/L반영 PD관리 management OUT
 * @details F/L반영 PD관리 management OUT
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
public class IP201001OUT {
    private int totalCount;				/* 총건수 */
    private int currentPageNo;			/* 페이지번호 */
    private List<IP201001DTO> list;		/* 조회 내용 */

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
	public List<IP201001DTO> getList() {
		return list;
	}
	public void setList(List<IP201001DTO> list) {
		this.list = list;
	}

}
