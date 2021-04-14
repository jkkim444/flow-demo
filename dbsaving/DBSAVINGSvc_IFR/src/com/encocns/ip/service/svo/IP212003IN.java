/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IP212002IN.java
 * @brief 대손충당금 요약 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

import java.util.List;

import com.encocns.ip.dto.IP212001DTO;

/**
 * @brief 대손충당금 요약 management IN
 * @details 대손충당금 요약 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP212003IN {
    private String stdrYm;  					/* 기준년월 */
    private String frtrYm;  					/* 전기년월 */
    private List<IP212001DTO> arrGridData;      /* 그리드데이터 */

    private String badlnRsrvBrfDivCd;           /* 대손충당금요약구분코드 */
    private String chgAmtDivCd; 				/* 변동금액구분코드 */
    private String usrId;						/* 사용자ID */

	public String getFrtrYm() {
		return frtrYm;
	}
	public void setFrtrYm(String frtrYm) {
		this.frtrYm = frtrYm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getBadlnRsrvBrfDivCd() {
        return badlnRsrvBrfDivCd;
    }
    public void setBadlnRsrvBrfDivCd(String badlnRsrvBrfDivCd) {
        this.badlnRsrvBrfDivCd = badlnRsrvBrfDivCd;
    }
	public String getChgAmtDivCd() {
		return chgAmtDivCd;
	}
	public void setChgAmtDivCd(String chgAmtDivCd) {
		this.chgAmtDivCd = chgAmtDivCd;
	}
    public List<IP212001DTO> getArrGridData() {
        return arrGridData;
    }
    public void setArrGridData(List<IP212001DTO> arrGridData) {
        this.arrGridData = arrGridData;
    }
}
