/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID101201OUT.java
 * @brief 상위보고서 조회 OUT
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

import com.encocns.id.dto.ID101201DTO;

/**
 * @brief 상위보고서 조회 OUT
 * @details 상위보고서 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID101201OUT {

	private ArrayList<ID101201DTO> arrList;	/* 조회 내용 */

    public ArrayList<ID101201DTO> getArrList() {
        return arrList;
    }
    public void setArrList(ArrayList<ID101201DTO> arrList) {
        this.arrList = arrList;
    }

}
