/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP208001OUT.java
 * @brief 금대손충당금 대상 OUT
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.encocns.ip.dto.IP208001DTO;
import com.encocns.ip.dto.IP208002DTO;

/**
 * @brief 금대손충당금 대상 management OUT
 * @details 금대손충당금 대상 management OUT
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP208001OUT {

    private int totalCount;								/* 총건수 */
    private int currentPageNo;							/* 페이지번호 */
    private List<IP208001DTO> list;						/* 조회 내역 */
    private List<IP208002DTO> listExcl;					/* 조회 내역 엑셀 */
	private ArrayList<HashMap<String, Object>> mapList;	/* 엑셀 다운로드 내용 */
    private String clsnCtnt;							/* 마감여부내용 */

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public List<IP208001DTO> getList() {
		return list;
	}
	public void setList(List<IP208001DTO> list) {
		this.list = list;
	}
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
	public List<IP208002DTO> getListExcl() {
		return listExcl;
	}
	public void setListExcl(List<IP208002DTO> listExcl) {
		this.listExcl = listExcl;
	}
	public ArrayList<HashMap<String, Object>> getMapList() {
		return mapList;
	}

	public void setMapList(ArrayList<HashMap<String, Object>> mapList) {
		this.mapList = mapList;
	}
}
