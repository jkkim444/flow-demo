/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA515001IN.java
 * @brief 수익용 부동산 보유 현황 management IN
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
 * @brief 수익용 부동산 보유 현황 management IN
 * @details 수익용 부동산 보유 현황 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA521001IN {
    private String searchBsYmSt;                  /* 조회시작년월 */
    private String searchBsYmEnd;                 /* 조회종료년월 */
    private int selectPage;                       /* 조회페이지 */
    private int pageSize;                         /* 조회사이즈 */

	public String getSearchBsYmSt() {
		return searchBsYmSt;
	}
	public void setSearchBsYmSt(String searchBsYmSt) {
		this.searchBsYmSt = searchBsYmSt;
	}
	public String getSearchBsYmEnd() {
		return searchBsYmEnd;
	}
	public void setSearchBsYmEnd(String searchBsYmEnd) {
		this.searchBsYmEnd = searchBsYmEnd;
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
