/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO301008IN.java
 * @brief 공통 코드 캐시 갱신 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.List;

import com.encocns.co.dto.CO301002DTO;

/**
 * @brief 공통 코드 캐시 갱신 IN
 * @details 공통 코드 캐시 갱신 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO301008IN {

    private List<CO301002DTO> arrList;

	public List<CO301002DTO> getArrList() {
		return arrList;
	}

	public void setArrList(List<CO301002DTO> arrList) {
		this.arrList = arrList;
	}

}
