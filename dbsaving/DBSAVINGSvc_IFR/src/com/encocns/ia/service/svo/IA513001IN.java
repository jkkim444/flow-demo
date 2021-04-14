/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA513001IN.java
 * @brief 기타유형자산 management IN
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

/**
 * @brief 기타유형자산 management IN
 * @details 기타유형자산 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA513001IN {
    private String searchStdrYm;		  /* 검색기준년월 */
    private String searchAcqsDtSt;		  /* 취득일자 시작 */
    private String searchAcqsDtEnd;		  /* 취득일자 종료 */
    private boolean chk_balUp;        	  /* 잔액천원이상 여부 */
    private int selectPage;        	  	  /* 페이지 */
    private int pageSize;        	  	  /* 페이지사이즈 */

	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public String getSearchAcqsDtSt() {
		return searchAcqsDtSt;
	}
	public void setSearchAcqsDtSt(String searchAcqsDtSt) {
		this.searchAcqsDtSt = searchAcqsDtSt;
	}
	public String getSearchAcqsDtEnd() {
		return searchAcqsDtEnd;
	}
	public void setSearchAcqsDtEnd(String searchAcqsDtEnd) {
		this.searchAcqsDtEnd = searchAcqsDtEnd;
	}
	public boolean isChk_balUp() {
		return chk_balUp;
	}
	public void setChk_balUp(boolean chk_balUp) {
		this.chk_balUp = chk_balUp;
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
