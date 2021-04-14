/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID102002IN.java
 * @brief 보고서 양식 정보 등록 및 수정 IN
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

import com.encocns.id.dto.ID102002DTO;
import com.encocns.id.dto.ID102003DTO;

/**
 * @brief 보고서 양식 정보 등록 및 수정 IN
 * @details 보고서 양식 정보 등록 및 수정 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID102002IN {

	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private List<ID102002DTO> arrList;               /* 보고서 내용 */
	private List<ID102003DTO> mergeList;             /* 병합 내용 */

	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getPbnfRptId() {
		return pbnfRptId;
	}
	public void setPbnfRptId(String pbnfRptId) {
		this.pbnfRptId = pbnfRptId;
	}
	public List<ID102002DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<ID102002DTO> arrList) {
		this.arrList = arrList;
	}
	public List<ID102003DTO> getMergeList() {
		return mergeList;
	}
	public void setMergeList(List<ID102003DTO> mergeList) {
		this.mergeList = mergeList;
	}
}
