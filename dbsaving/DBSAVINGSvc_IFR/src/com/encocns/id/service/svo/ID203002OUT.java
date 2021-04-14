/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID203002OUT.java
 * @brief 공시보고서 양식 조회 OUT
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

import com.encocns.id.dto.ID203002DTO;
import com.encocns.id.dto.ID203003DTO;
import com.encocns.id.dto.ID203004DTO;

/**
 * @brief 공시보고서 양식 조회 OUT
 * @details 공시보고서 양식 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID203002OUT {

	private List<ID203002DTO> arrList;			/* 보고서 내용 */
	private List<ID203003DTO> arrListMerge;		/* 병합 내용 */
	private List<ID203004DTO> arrListValdtnYn;	/* 검증완료 여부 내용 */

	public List<ID203002DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<ID203002DTO> arrList) {
		this.arrList = arrList;
	}
	public List<ID203003DTO> getArrListMerge() {
		return arrListMerge;
	}
	public void setArrListMerge(List<ID203003DTO> arrListMerge) {
		this.arrListMerge = arrListMerge;
	}
	public List<ID203004DTO> getArrListValdtnYn() {
		return arrListValdtnYn;
	}
	public void setArrListValdtnYn(List<ID203004DTO> arrListValdtnYn) {
		this.arrListValdtnYn = arrListValdtnYn;
	}


}
