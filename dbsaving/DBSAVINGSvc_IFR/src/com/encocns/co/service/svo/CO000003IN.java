/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000003IN.java
 * @brief 홈 화면 IN
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

/**
 * @brief 홈 화면 IN
 * @details 홈 화면 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000003IN {

	private String cmknSrchDivCd;      /* 공지검색구분코드 */
    private String titlNm;

    private int selectPage;			   /* 선택페이지 */
    private int pageSize;         	   /* 페이지크기 */

	public String getCmknSrchDivCd() {
		return cmknSrchDivCd;
	}
	public void setCmknSrchDivCd(String cmknSrchDivCd) {
		this.cmknSrchDivCd = cmknSrchDivCd;
	}
	public String getTitlNm() {
		return titlNm;
	}
	public void setTitlNm(String titlNm) {
		this.titlNm = titlNm;
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
