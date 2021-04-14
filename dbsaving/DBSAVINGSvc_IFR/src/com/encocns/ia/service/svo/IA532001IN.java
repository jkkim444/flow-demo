/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA532001IN.java
 * @brief KGAAP 계정코드 management IN
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 11. 18. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief KGAAP 계정코드 management IN
 * @details KGAAP 계정코드 management IN
 * @author : LEE, MI-RAE
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
public class IA532001IN {

	private String uprnToacCd;                       /* 상위KGAAP계정코드 */
	private String toacCd;                           /* KGAAP계정코드 */

	public String getUprnToacCd() {
		return uprnToacCd;
	}
	public void setUprnToacCd(String uprnToacCd) {
		this.uprnToacCd = uprnToacCd;
	}
	public String getToacCd() {
		return toacCd;
	}
	public void setToacCd(String toacCd) {
		this.toacCd = toacCd;
	}

}
