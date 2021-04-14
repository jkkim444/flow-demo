/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file CO401001IN.java
 * @brief 공지사항 조회 IN
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

/**
 * @brief 공지사항 조회 IN
 * @details 공지사항 조회 IN
 * @author : 최호연
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
public class CO401001IN {
    private String cmknSrchDivCd;      /* 공지검색구분코드 */
    private String titlNm;
    private int selectPage;
    private int pageSize;

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
