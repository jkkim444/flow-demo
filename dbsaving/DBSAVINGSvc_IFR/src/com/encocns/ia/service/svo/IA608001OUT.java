/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA608001OUT.java
 * @brief 기타포괄손익공정가치내역 조회 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 18. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA608001DTO;

/**
 * @brief 기타포괄손익공정가치내역 조회 OUT
 * @details 기타포괄손익공정가치내역 조회 OUT
 * @author : 차상길
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
public class IA608001OUT {
    private List<IA608001DTO> arrList;		/* 조회 내용 */
    private String pbnfCtnt;				/* 마감구분내용 */

	public List<IA608001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<IA608001DTO> arrList) {
		this.arrList = arrList;
	}
	public String getPbnfCtnt() {
		return pbnfCtnt;
	}
	public void setPbnfCtnt(String pbnfCtnt) {
		this.pbnfCtnt = pbnfCtnt;
	}

}
