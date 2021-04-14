/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP211001OUT.java
 * @brief 대손충당금 집계내역 OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

import java.util.List;

import com.encocns.ip.dto.IP211001DTO;
import com.encocns.ip.dto.IP211002DTO;

/**
 * @brief 대손충당금 집계내역 management OUT
 * @details 대손충당금 집계내역 management OUT
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP211001OUT {
    private List<IP211001DTO> List01;		/* 조회 내용1 */
    private List<IP211002DTO> List02;		/* 조회 내용2 */
    private String clsnCtnt;				/* 마감여부내용 */

	public List<IP211001DTO> getList01() {
		return List01;
	}
	public void setList01(List<IP211001DTO> list01) {
		List01 = list01;
	}
	public List<IP211002DTO> getList02() {
		return List02;
	}
	public void setList02(List<IP211002DTO> list02) {
		List02 = list02;
	}
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
}
