/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID101102OUT.java
 * @brief 공시보고서 상세 조회 OUT
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

import com.encocns.id.dto.ID101101DTO;

/**
 * @brief 공시보고서 상세 조회 OUT
 * @details 공시보고서 상세 조회 OUT
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID101102OUT {

	private ID101101DTO pbnfRptInfo;	/* 보고서 정보 */

	public ID101101DTO getPbnfRptInfo() {
		return pbnfRptInfo;
	}

	public void setPbnfRptInfo(ID101101DTO pbnfRptInfo) {
		this.pbnfRptInfo = pbnfRptInfo;
	}

}
