/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IP208003IN.java
 * @brief 타사연체 여부 즉시업로드 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 11. 25. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

import java.util.List;

import com.encocns.ip.dto.IP208003DTO;

/**
 * @brief 타사연체 여부 즉시업로드 management IN
 * @details 타사연체 여부 즉시업로드 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP208003IN {

	private List<IP208003DTO> arrGridData;		/* 그리드 데이터 */
	private String usrId;						/* 사용자ID */

	public List<IP208003DTO> getArrGridData() {
		return arrGridData;
	}
	public void setArrGridData(List<IP208003DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
