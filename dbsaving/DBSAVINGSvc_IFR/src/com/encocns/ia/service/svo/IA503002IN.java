/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA503001IN.java
 * @brief 정산표 산출 management IN
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 정산표 산출 management IN
 * @details 정산표 산출 management IN
 * @author : 이동겸
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
public class IA503002IN {

	private String stdrYm;                 /* 전기년월 */
	private String frtrYm;                 /* 전기년월 */
    private boolean bltAccYn;              /* 실계정여부 */
    private String ifrsAccCd;			   /* 계정코드 */

    private String usrId;				   /* 사용자ID */

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

	public boolean isBltAccYn() {
		return bltAccYn;
	}

	public void setBltAccYn(boolean bltAccYn) {
		this.bltAccYn = bltAccYn;
	}

	public String getIfrsAccCd() {
		return ifrsAccCd;
	}

	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}


}
