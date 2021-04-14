/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO401001OUT.java
 * @brief 공지사항 조회 OUT
 * @section Major History
 * <pre>
 *   - 최호연 | 2020. 10. 19. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.List;

import com.encocns.co.dto.CO401001DTO;

/**
 * @brief 공지사항 조회 OUT
 * @details 공지사항 조회 OUT
 * @author : 최호연
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
public class CO401001OUT {
    private List<CO401001DTO> arrList;
    private int totalCount;
    private int currentPageNo;

	public List<CO401001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<CO401001DTO> arrList) {
		this.arrList = arrList;
	}
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

}
