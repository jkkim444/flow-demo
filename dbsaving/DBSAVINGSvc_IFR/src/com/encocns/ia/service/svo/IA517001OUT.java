/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA517001OUT.java
 * @brief 계리보고서 정보 management OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 14. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA517001DTO;

/**
 * @brief 계리보고서 정보 management OUT
 * @details 계리보고서 정보 management OUT
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
public class IA517001OUT {

    private List<IA517001DTO> list;		/* 조회 내역 */
    private String clsnCtnt;			/* 마감여부내용 */

	public List<IA517001DTO> getList() {
		return list;
	}
	public void setList(List<IA517001DTO> list) {
		this.list = list;
	}
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
}
