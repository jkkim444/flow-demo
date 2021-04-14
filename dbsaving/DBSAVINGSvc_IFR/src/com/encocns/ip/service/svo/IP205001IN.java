/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IP205001IN.java
 * @brief 기타충당금 기본 management IN
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

/**
 * @brief 기타충당금 기본 management IN
 * @details 기타충당금 기본 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP205001IN {
    private String searchStdrYm;               /* 기준년월 시작 */
    private String searchStdrYmEnd;            /* 기준년월 종료 */
    private int selectPage;					   /* 페이지 */
    private int pageSize;					   /* 페이지사이즈 */

	public String getSearchStdrYmEnd() {
		return searchStdrYmEnd;
	}
	public void setSearchStdrYmEnd(String searchStdrYmEnd) {
		this.searchStdrYmEnd = searchStdrYmEnd;
	}
	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public int getSelectPage() {
		return selectPage;
	}
	public void setSelectPage(int selectPage) {
		this.selectPage = selectPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
