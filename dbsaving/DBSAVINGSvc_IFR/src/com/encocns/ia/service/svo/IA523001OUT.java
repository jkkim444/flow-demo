/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA523001OUT.java
 * @brief 임차시설물 복구충당부채 management OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA523001DTO;

/**
 * @brief 임차시설물 복구충당부채 management OUT
 * @details 임차시설물 복구충당부채 management OUT
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA523001OUT {

    private List<IA523001DTO> list;		/* 조회 내용 */
    private String clsnCtnt;			/* 마감여부내용 */

	public List<IA523001DTO> getList() {
		return list;
	}
	public void setList(List<IA523001DTO> list) {
		this.list = list;
	}
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
}
