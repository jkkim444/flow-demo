/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000001OUT.java
 * @brief 홈 화면 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.ArrayList;

import com.encocns.co.dto.CO000001DTO;

/**
 * @brief 홈 화면 OUT
 * @details 홈 화면 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000001OUT {
    private ArrayList<CO000001DTO> arrList1;    /* 공지사항 */
    private ArrayList<CO000001DTO> arrList2;    /* 마감정보 */

	public ArrayList<CO000001DTO> getArrList1() {
		return arrList1;
	}
	public void setArrList1(ArrayList<CO000001DTO> arrList1) {
		this.arrList1 = arrList1;
	}
	public ArrayList<CO000001DTO> getArrList2() {
		return arrList2;
	}
	public void setArrList2(ArrayList<CO000001DTO> arrList2) {
		this.arrList2 = arrList2;
	}

}
