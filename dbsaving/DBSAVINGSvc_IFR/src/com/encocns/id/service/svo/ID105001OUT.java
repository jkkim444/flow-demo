/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID105001OUT.java
 * @brief 보고서 양식 조회 OUT
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

import com.encocns.id.dto.ID105001DTO;
import com.encocns.id.dto.ID105002DTO;

/**
 * @brief 보고서 양식 조회 OUT
 * @details 보고서 양식 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID105001OUT {

	private List<ID105001DTO> arrList;               /* 보고서 내용 */
	private List<ID105002DTO> arrListMerge;          /* 병합 내용 */
	private String pbnfRptNm;                        /* 공시보고서명 */
	private String pbnfCtnt;                      	 /* 마감여부내용 */

	public List<ID105001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<ID105001DTO> arrList) {
		this.arrList = arrList;
	}
	public List<ID105002DTO> getArrListMerge() {
		return arrListMerge;
	}
	public void setArrListMerge(List<ID105002DTO> arrListMerge) {
		this.arrListMerge = arrListMerge;
	}
	public String getPbnfRptNm() {
		return pbnfRptNm;
	}
	public void setPbnfRptNm(String pbnfRptNm) {
		this.pbnfRptNm = pbnfRptNm;
	}
	public String getPbnfCtnt() {
		return pbnfCtnt;
	}
	public void setPbnfCtnt(String pbnfCtnt) {
		this.pbnfCtnt = pbnfCtnt;
	}

}
