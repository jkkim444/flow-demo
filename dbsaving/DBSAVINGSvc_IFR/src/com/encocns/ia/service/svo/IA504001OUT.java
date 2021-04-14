/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA504001OUT.java
 * @brief 재무상태표 산출 management OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA504001DTO;

/**
 * @brief 재무상태표 산출 management OUT
 * @details 재무상태표 산출 management OUT
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA504001OUT {

    private List<IA504001DTO> list;
    private String clsnCtnt;

	public List<IA504001DTO> getList() {
		return list;
	}

	public void setList(List<IA504001DTO> list) {
		this.list = list;
	}

	public String getClsnCtnt() {
		return clsnCtnt;
	}

	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}

}
