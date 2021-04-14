/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA511002OUT.java
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

import com.encocns.ia.dto.IA511002DTO;

/**
 * @brief IFRS정산표 management OUT
 * @details IFRS정산표 management OUT
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
public class IA511002OUT {

    private List<IA511002DTO> list02;

	public List<IA511002DTO> getList02() {
		return list02;
	}
	public void setList02(List<IA511002DTO> list02) {
		this.list02 = list02;
	}
}
