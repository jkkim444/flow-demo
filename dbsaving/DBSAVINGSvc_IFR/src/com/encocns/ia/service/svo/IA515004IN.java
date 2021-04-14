/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515004IN.java
 * @brief 수익용 부동산 보유 현황 management IN
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

/**
 * @brief 수익용 부동산 보유 현황 management IN
 * @details 수익용 부동산 보유 현황 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA515004IN {

	private String stdrYm;       /* 기준년월 */
	private String frtrYm;		 /* 전기년월 */
	private String usrId;		 /* 사용자ID */

	public String getStdrYm() {
		return stdrYm;
	}

	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}

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
}
