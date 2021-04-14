/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW103001OUT.java
 * @brief Batch Operation Status OUT
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 22. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

import java.util.ArrayList;

import com.encocns.fw.dto.FW103002DTO;

/**
 * @brief Batch Operation Status OUT
 * @details Batch Operation Status OUT
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 22.
 * @version : 1.0.0
 */
public class FW103002OUT {

	private String grpId;                         /* 그룹ID */
	private ArrayList<FW103002DTO> arrList;       /* 배치조회 */

	public String getGrpId() {
        return grpId;
    }

    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }

    public ArrayList<FW103002DTO> getArrList() {
		return arrList;
	}

	public void setArrList(ArrayList<FW103002DTO> arrList) {
		this.arrList = arrList;
	}
}
