/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA518001OUT.java
 * @brief 기초이월분개처리 management OUT
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 9. 29. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA518001DTO;

/**
 * @brief 기초이월분개처리 management OUT
 * @details 기초이월분개처리 management OUT
 * @author : LEE, MI-RAE
 * @date : 2020. 9. 28.
 * @version : 1.0.0
 */
public class IA518001OUT {

	 private List<IA518001DTO> list;		/* 조회 내용 */
	 private String clsnCtnt;				/* 마감여부내용 */

	public List<IA518001DTO> getList() {
		return list;
	}
	public void setList(List<IA518001DTO> list) {
		this.list = list;
	}
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
}
