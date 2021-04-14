/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID101301OUT.java
 * @brief 공시보고서 조회 OUT
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

import java.util.ArrayList;

import com.encocns.id.dto.ID101301DTO;

/**
 * @brief 공시보고서 조회 OUT
 * @details 공시보고서 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID101301OUT {

	private ArrayList<ID101301DTO> arrList;	/* 조회 내용 */

    public ArrayList<ID101301DTO> getArrList() {
        return arrList;
    }
    public void setArrList(ArrayList<ID101301DTO> arrList) {
        this.arrList = arrList;
    }

}
