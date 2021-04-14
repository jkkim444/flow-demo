/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP201003IN.java
 * @brief F/L반영 PD관리 IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

import java.util.List;

import com.encocns.ip.dto.IP201001DTO;

/**
 * @brief F/L반영 PD관리 management IN
 * @details F/L반영 PD관리 management IN
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
public class IP201004IN {

	private String stdrYm;               	/* 기준년월 */
	private String pdSgmtCd;             	/* PDSGMT코드 */
	private List<IP201001DTO> arrGridData;	/* 그리드 데이터 */
	private String usrId;					/* 사용자ID */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getPdSgmtCd() {
		return pdSgmtCd;
	}
	public void setPdSgmtCd(String pdSgmtCd) {
		this.pdSgmtCd = pdSgmtCd;
	}
	public List<IP201001DTO> getArrGridData() {
		return arrGridData;
	}
	public void setArrGridData(List<IP201001DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
