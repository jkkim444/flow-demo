/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515002IN.java
 * @brief 계리보고서 정보 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 14. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.math.BigDecimal;
import java.util.List;

import com.encocns.ia.dto.IA517002DTO;

/**
 * @brief 계리보고서 정보 management IN
 * @details 계리보고서 정보 management IN
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
public class IA517002IN {

	private String stdrYm;                           /* 전기년월 */
	private BigDecimal frmRetmSlry;                  /* 확정기여형 퇴직급여 */
	private List<IA517002DTO> arrGridData;			 /* 그리드 데이터 */
	private String aconInfoRptDivCd;                 /* 계리보고서구분 */
	private String usrId;							 /* 사용자ID */

	public BigDecimal getFrmRetmSlry() {
		return frmRetmSlry;
	}
	public void setFrmRetmSlry(BigDecimal frmRetmSlry) {
		this.frmRetmSlry = frmRetmSlry;
	}
	public String getAconInfoRptDivCd() {
		return aconInfoRptDivCd;
	}
	public void setAconInfoRptDivCd(String aconInfoRptDivCd) {
		this.aconInfoRptDivCd = aconInfoRptDivCd;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public List<IA517002DTO> getArrGridData() {
		return arrGridData;
	}
	public void setArrGridData(List<IA517002DTO> arrGridData) {
		this.arrGridData = arrGridData;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
