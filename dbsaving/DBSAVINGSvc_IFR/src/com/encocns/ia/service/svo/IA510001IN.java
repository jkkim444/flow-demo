/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA510001IN.java
 * @brief IFRS분개전표 management IN
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
 * @brief IFRS분개전표 management IN
 * @details IFRS분개전표 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA510001IN {
    private String searchStdrYm;                  /* 전기년월 */
    private String jrlzBzwkcd;                    /* 분개업무구분코드 */
    private int selectPage;                       /* 페이지 */
    private int pageSize;                         /* 페이지 사이즈 */
    private boolean chkIfrs;              		  /* 0원 이상 */

	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public String getJrlzBzwkcd() {
		return jrlzBzwkcd;
	}
	public void setJrlzBzwkcd(String jrlzBzwkcd) {
		this.jrlzBzwkcd = jrlzBzwkcd;
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
	public boolean isChkIfrs() {
		return chkIfrs;
	}
	public void setChkIfrs(boolean chkIfrs) {
		this.chkIfrs = chkIfrs;
	}




}
