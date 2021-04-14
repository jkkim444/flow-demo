/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID202001OUT.java
 * @brief 보고서 양식 및 산출 조회 OUT
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

import com.encocns.id.dto.ID202001DTO;
import com.encocns.id.dto.ID202002DTO;

/**
 * @brief 보고서 양식 및 산출 조회 OUT
 * @details 보고서 양식 및 산출 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID202001OUT {

	private List<ID202001DTO> arrList;               /* 보고서 내용 */
	private List<ID202002DTO> arrListMerge;          /* 병합 내용 */
	private String pbnfRptNm;                        /* 공시보고서명 */
	private String pbnfCtnt;                      	 /* 마감여부내용 */
	private String rptFinText;                    	 /* 보고서 확인 여부 */

	public List<ID202001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<ID202001DTO> arrList) {
		this.arrList = arrList;
	}
	public List<ID202002DTO> getArrListMerge() {
		return arrListMerge;
	}
	public void setArrListMerge(List<ID202002DTO> arrListMerge) {
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
	public String getRptFinText() {
		return rptFinText;
	}
	public void setRptFinText(String rptFinText) {
		this.rptFinText = rptFinText;
	}

}
