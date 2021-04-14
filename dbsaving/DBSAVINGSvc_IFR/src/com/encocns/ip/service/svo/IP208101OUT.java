/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP208101OUT.java
 * @brief 예치금대손충당금 기본 OUT
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

import com.encocns.ip.dto.IP208101DTO;

/**
 * @brief 예치금대손충당금 기본 management OUT
 * @details 예치금대손충당금 기본 management OUT
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP208101OUT {

    private IP208101DTO list;		/* 조회 내용 */

	public IP208101DTO getList() {
		return list;
	}
	public void setList(IP208101DTO list) {
		this.list = list;
	}
}
