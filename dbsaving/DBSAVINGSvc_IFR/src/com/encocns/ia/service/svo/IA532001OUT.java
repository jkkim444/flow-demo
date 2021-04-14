/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501001OUT.java
 * @brief IFRS 계정코드 management OUT
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 11. 18. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;


import com.encocns.ia.dto.IA532001DTO;

/**
 * @brief KGAAP 계정코드 management OUT
 * @details KGAAP 계정코드 management OUT
 * @author : LEE, MI-RAE
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
public class IA532001OUT {

    private int totalCount;				/* 총 건수 */
    private int currentPageNo;			/* 페이지 번호 */
    private List<IA532001DTO> list;		/* 조회 내용 */

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
	public List<IA532001DTO> getList() {
		return list;
	}
	public void setList(List<IA532001DTO> list) {
		this.list = list;
	}
}
