/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA527001OUT.java
 * @brief 유가증권처분 요약내역 management OUT
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 05.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA528001DTO;

/**
 * @brief 유가증권기초 요약내역 management OUT
 * @details 유가증권처분 요약내역 management OUT
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 12.
 * @version : 1.0.0
 */
public class IA528002OUT {

    private List<IA528001DTO> arrList;		/* 조회내용 */
    private String clsnCtnt;				/* 마감여부내용 */

	public List<IA528001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<IA528001DTO> arrList) {
		this.arrList = arrList;
	}
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
}
