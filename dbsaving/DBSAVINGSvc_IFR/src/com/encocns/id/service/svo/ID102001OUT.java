/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID102001OUT.java
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

import com.encocns.id.dto.ID102001DTO;

/**
 * @brief 보고서 양식 조회 OUT
 * @details 보고서 양식 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID102001OUT {

	private List<ID102001DTO> arrList;               /* 보고서 조회 내용 */
	private List<ID102001DTO> arrListMerge;          /* 병합 조회 내용 */
	private String pbnfRptNm;                        /* 공시보고서명 */
	private String pbnfCtnt;                     	 /* 마감여부내용 */

	public List<ID102001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<ID102001DTO> arrList) {
		this.arrList = arrList;
	}
	public List<ID102001DTO> getArrListMerge() {
		return arrListMerge;
	}
	public void setArrListMerge(List<ID102001DTO> arrListMerge) {
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
