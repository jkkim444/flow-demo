/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA513001OUT.java
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

import com.encocns.ia.dto.IA513001DTO;

/**
 * @brief 기타유형자산 management OUT
 * @details 기타유형자산 management OUT
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA513001OUT {

    private int totalCount;

    private int currentPageNo;

    private List<IA513001DTO> list;
    private String clsnCtnt;

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the currentPageNo
	 */
	public int getCurrentPageNo() {
		return currentPageNo;
	}

	/**
	 * @param currentPageNo the currentPageNo to set
	 */
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	/**
	 * @return the list
	 */
	public List<IA513001DTO> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<IA513001DTO> list) {
		this.list = list;
	}

	/**
	 * @return the clsnCtnt
	 */
	public String getClsnCtnt() {
		return clsnCtnt;
	}

	/**
	 * @param clsnCtnt the clsnCtnt to set
	 */
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}



}
