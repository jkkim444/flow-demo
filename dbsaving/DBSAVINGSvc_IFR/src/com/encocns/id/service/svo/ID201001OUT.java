/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID201001OUT.java
 * @brief 공시보고서 목록 조회 OUT
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

import com.encocns.id.dto.ID201001DTO;

/**
 * @brief 공시보고서 목록 조회 OUT
 * @details 공시보고서 목록 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID201001OUT {

	private List<ID201001DTO> arrList;	/* 조회 내용 */
    private String pbnfCtnt;			/* 마감여부내용 */

	public List<ID201001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<ID201001DTO> arrList) {
		this.arrList = arrList;
	}
	public String getPbnfCtnt() {
		return pbnfCtnt;
	}
	public void setPbnfCtnt(String pbnfCtnt) {
		this.pbnfCtnt = pbnfCtnt;
	}
}
