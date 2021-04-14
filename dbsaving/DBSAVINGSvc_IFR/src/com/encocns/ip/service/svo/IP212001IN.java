/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IP212001IN.java
 * @brief 대손충당금 요약 management IN
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
 * @brief 대손충당금 요약 management IN
 * @details 대손충당금 요약 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP212001IN {
    private String searchStdrYm;  /* 기준년월 */
    private String chgAmtDivCd;	  /* 변동금액구분코드 */
    private int selectPage;       /* 페이지 선택 */
    private int pageSize;         /* 페이지 크기 */

	public String getChgAmtDivCd() {
		return chgAmtDivCd;
	}
	public void setChgAmtDivCd(String chgAmtDivCd) {
		this.chgAmtDivCd = chgAmtDivCd;
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
