/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA501002IN.java
 * @brief IFRS 계정코드 management IN
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

import java.util.List;

import com.encocns.ia.dto.IA606001DTO;

/**
 * @brief IFRS 계정코드 management IN
 * @details IFRS 계정코드 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA606002IN {

	private List<IA606001DTO> arrList;
	private String baseYm;                           /* 기준년도 */
	private String bfQtrYm;                          /* 이전분기년월 */
	private String lastYm;                           /* 전년도말월 */
	private String usrId;                            /* 사용자ID */

	public List<IA606001DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<IA606001DTO> arrList) {
		this.arrList = arrList;
	}
	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getBfQtrYm() {
		return bfQtrYm;
	}
	public void setBfQtrYm(String bfQtrYm) {
		this.bfQtrYm = bfQtrYm;
	}
	public String getLastYm() {
		return lastYm;
	}
	public void setLastYm(String lastYm) {
		this.lastYm = lastYm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
