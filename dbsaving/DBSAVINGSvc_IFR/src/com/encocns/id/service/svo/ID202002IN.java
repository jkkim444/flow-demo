/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID202002IN.java
 * @brief 보고서 수기 등록 IN
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

import java.util.List;

import com.encocns.id.dto.ID202003DTO;

/**
 * @brief 보고서 수기 등록 IN
 * @details 보고서 수기 등록 IN
 * @author : 차 상 길
 * @date : 2020. 09. 10.
 */
public class ID202002IN {
	private List<ID202003DTO> arrList;               /* 조회 내용 */
	private String baseYm;                           /* 기준년도 */
	private String pbnfRptId;                        /* 공시보고서ID */
	private String usrId;                            /* 사용자ID */

	public List<ID202003DTO> getArrList() {
		return arrList;
	}
	public void setArrList(List<ID202003DTO> arrList) {
		this.arrList = arrList;
	}
	public String getBaseYm() {
		return baseYm;
	}
	public void setBaseYm(String baseYm) {
		this.baseYm = baseYm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getPbnfRptId() {
		return pbnfRptId;
	}
	public void setPbnfRptId(String pbnfRptId) {
		this.pbnfRptId = pbnfRptId;
	}

}
