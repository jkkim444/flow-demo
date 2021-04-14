/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA509002IN.java
 * @brief 연결현금흐름표 management IN
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

import com.encocns.ia.dto.IA509001DTO;

/**
 * @brief 연결현금흐름표 management IN
 * @details 연결현금흐름표 management IN
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA509002IN {

	private String stdrYm;                                     /* 기준년월 */
	private List<IA509001DTO> arrGridData;					   /* 그리드 조회 */
	private String usrId;                                      /* 사용자ID */

	public List<IA509001DTO> getArrGridData() {
		return arrGridData;
	}
	public void setArrGridData(List<IA509001DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
