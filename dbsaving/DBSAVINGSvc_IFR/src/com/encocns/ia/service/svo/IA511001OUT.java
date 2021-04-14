/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA511001OUT.java
 * @brief IFRS정산표 management OUT
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

import com.encocns.ia.dto.IA511001DTO;

/**
 * @brief IFRS정산표 management OUT
 * @details IFRS정산표 management OUT
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA511001OUT {

    private List<IA511001DTO> list01;
    private String clsnCtnt;

	public List<IA511001DTO> getList01() {
		return list01;
	}
	public void setList01(List<IA511001DTO> list01) {
		this.list01 = list01;
	}
	public String getClsnCtnt() {
		return clsnCtnt;
	}
	public void setClsnCtnt(String clsnCtnt) {
		this.clsnCtnt = clsnCtnt;
	}
}
