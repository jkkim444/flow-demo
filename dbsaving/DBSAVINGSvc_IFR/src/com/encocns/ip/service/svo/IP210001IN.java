/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IP210001IN.java
 * @brief 담보가액관리 management IN
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
 * @brief 담보가액관리 management IN
 * @details 담보가액관리 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP210001IN {
    private String searchStdrYm;               /* 기준년월 */
    private String cstno;                      /* 고객번호 */
    private boolean chk_mtpr;                  /* 담보가액 체크 */
    private int selectPage;					   /* 페이지 */
    private int pageSize;					   /* 페이지사이즈 */

	public String getCstno() {
		return cstno;
	}
	public void setCstno(String cstno) {
		this.cstno = cstno;
	}
	public boolean isChk_mtpr() {
		return chk_mtpr;
	}
	public void setChk_mtpr(boolean chk_mtpr) {
		this.chk_mtpr = chk_mtpr;
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
