/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA525002IN.java
 * @brief 수익증권 합계잔액시산표 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA525001DTO;

/**
 * @brief 수익증권 합계잔액시산표 management IN
 * @details 수익증권 합계잔액시산표 management IN
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
public class IA525002IN {

	private List<IA525001DTO> arrGridData;	/* 그리드 데이터 */
	private String usrId;					/* 사용자ID */

	public List<IA525001DTO> getArrGridData() {
		return arrGridData;
	}
	public void setArrGridData(List<IA525001DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
