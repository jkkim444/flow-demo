/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP210002IN.java
 * @brief 담보가액관리 IN
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

import com.encocns.ip.dto.IP210002DTO;

/**
 * @brief 담보가액관리 management IN
 * @details 담보가액관리 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP210005IN {

	private List<IP210002DTO> arrGridData;		/* 그리드데이터 */
	private String usrId;						/* 사용자ID */

	public List<IP210002DTO> getArrGridData() {
		return arrGridData;
	}
	public void setArrGridData(List<IP210002DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
