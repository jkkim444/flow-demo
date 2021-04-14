/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA502001IN.java
 * @brief 제무제표 양식 management IN
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
 * @brief 제무제표 양식 management IN
 * @details 제무제표 양식 management IN
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA502001IN {
	private String searchStdrYm;                     /* 전기년월 */
	private String ecalTpCd;                         /* 정산유형코드 */
	private String ifrsAccCd;                        /* IFRS계정코드 */

	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
	public String getEcalTpCd() {
		return ecalTpCd;
	}
	public void setEcalTpCd(String ecalTpCd) {
		this.ecalTpCd = ecalTpCd;
	}
	public String getIfrsAccCd() {
		return ifrsAccCd;
	}
	public void setIfrsAccCd(String ifrsAccCd) {
		this.ifrsAccCd = ifrsAccCd;
	}




}
