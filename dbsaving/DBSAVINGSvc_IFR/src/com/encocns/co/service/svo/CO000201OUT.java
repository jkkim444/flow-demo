/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000201OUT.java
 * @brief 계정 코드 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 4. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.List;

import com.encocns.co.dto.CO000201DTO;

/**
 * @brief 계정 코드 OUT
 * @details 계정 코드 OUT
 * @author : 차상길
 * @date : 2020. 4. 21.
 * @version : 1.0.0
 */
public class CO000201OUT {

	private List<CO000201DTO> arrList;			   /* 계정조회 */
	private String sIqryRslt;                      /* 조회결과 */

	public List<CO000201DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<CO000201DTO> arrList) {
		this.arrList = arrList;
	}
	public String getsIqryRslt() {
		return sIqryRslt;
	}
	public void setsIqryRslt(String sIqryRslt) {
		this.sIqryRslt = sIqryRslt;
	}
}
