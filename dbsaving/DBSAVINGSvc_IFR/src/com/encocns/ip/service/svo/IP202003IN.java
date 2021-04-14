/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP202003IN.java
 * @brief LGD 관리 IN
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

/**
 * @brief LGD 관리 management IN
 * @details LGD 관리 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP202003IN {

	private String stdrYm;                    /* 기준년월 */
	private String lgdSgmtCd;                 /* LGDSegment코드  */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getLgdSgmtCd() {
		return lgdSgmtCd;
	}
	public void setLgdSgmtCd(String lgdSgmtCd) {
		this.lgdSgmtCd = lgdSgmtCd;
	}

}
