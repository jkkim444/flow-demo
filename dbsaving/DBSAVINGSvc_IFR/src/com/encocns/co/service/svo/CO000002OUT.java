/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000002OUT.java
 * @brief 홈 화면 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.List;

import com.encocns.co.dto.CO000002DTO;

/**
 * @brief 홈 화면 OUT
 * @details 홈 화면 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000002OUT {

	private List<CO000002DTO> arrList; /* 홈화면 조회 */
    private int totalCount;			   /* 총 건수 */
    private int currentPageNo;         /* 페이지번호 */

    public List<CO000002DTO> getArrList() {
        return arrList;
    }
    public void setArrList(List<CO000002DTO> arrList) {
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
