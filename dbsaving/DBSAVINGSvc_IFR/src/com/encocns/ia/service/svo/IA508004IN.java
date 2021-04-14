/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA508004IN.java
 * @brief 연결자본변동표 엑셀업로드 IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 12. 15. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA508002DTO;


/**
 * @brief 연결자본변동표관리 엑셀업로드 IN
 * @details 연결자본변동표관리 엑셀업로드 IN
 * @author : 이동겸
 * @date : 2020. 12. 15.
 * @version : 1.0.0
 */
public class IA508004IN {

	private String stdrYm;
	private List<IA508002DTO> arrExcelData;	/* 엑셀 데이터 */
	private String usrId;					/* 사용자ID */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public List<IA508002DTO> getArrExcelData() {
		return arrExcelData;
	}
	public void setArrExcelData(List<IA508002DTO> arrExcelData) {
		this.arrExcelData = arrExcelData;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
