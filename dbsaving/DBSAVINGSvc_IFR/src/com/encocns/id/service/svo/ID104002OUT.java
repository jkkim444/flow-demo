/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID104002OUT.java
 * @brief 보고서 산출정보 조회 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.service.svo
 * @brief id SVO Package
 */
package com.encocns.id.service.svo;

import java.util.List;
import com.encocns.id.dto.ID104003DTO;

/**
 * @brief 보고서 산출정보 조회 OUT
 * @details 보고서 산출정보 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID104002OUT {
	private List<ID104003DTO> arrList;	/* 조회 내용 */

	public List<ID104003DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<ID104003DTO> arrList) {
		this.arrList = arrList;
	}

}
