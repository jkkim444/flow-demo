/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA526002IN.java
 * @brief 수익증권 재무제표 management IN
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 20.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;



/**
 * @brief 수익증권 재무제표 management IN
 * @details 수익증권 재무제표 management IN
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 20.
 * @version : 1.0.0
 */
public class IA526002IN {

	private String stdrYm;              /* 기준년월 */
	private String usrId;				/* 사용자ID */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
