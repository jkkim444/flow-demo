/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000001OUT.java
 * @brief
 * 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - 홍길동 | 2020. 1. 23. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief
 */
package com.encocns.co.service.svo;

import java.util.List;

import com.encocns.co.dto.CO000003DTO;

/**
 * @brief 홈 화면 OUT
 * @details 홈 화면 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000003OUT {

    private int totalCount;				/* 총 건수 */

    private List<CO000003DTO> arrList3; /* 홈화면 조회 */

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<CO000003DTO> getArrList3() {
		return arrList3;
	}

	public void setArrList3(List<CO000003DTO> arrList3) {
		this.arrList3 = arrList3;
	}
}
