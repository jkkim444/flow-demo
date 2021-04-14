/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501001OUT.java
 * @brief IFRS 계정코드 management OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import com.encocns.ia.dto.IA530102DTO;

/**
 * @brief IFRS 수정분개 관리_팝업 management OUT
 * @details IFRS 수정분개 관리_팝업 management OUT
 * @author : CHOI,HO-YEON
 * @date : 2020. 10. 15.
 * @version : 1.0.0
 */
public class IA530101OUT {

	private IA530102DTO list;	/* 조회 내용 */

	public IA530102DTO getList() {
		return list;
	}
	public void setList(IA530102DTO list) {
		this.list = list;
	}
}
