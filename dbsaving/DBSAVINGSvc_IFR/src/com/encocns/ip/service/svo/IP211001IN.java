/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IP211001IN.java
 * @brief 대손충당금 집계내역 management IN
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
 * @brief 대손충당금 집계내역 management IN
 * @details 대손충당금 집계내역 management IN
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP211001IN {
    private String searchStdrYm;               /* 기준년도 */
    private String searchFrtrYm;               /* 전기년도 */
    private String LsrsrvTotlIqryCd;           /* 코드(PDorLGD) */

    public String getLsrsrvTotlIqryCd() {
		return LsrsrvTotlIqryCd;
	}
	public void setLsrsrvTotlIqryCd(String lsrsrvTotlIqryCd) {
		LsrsrvTotlIqryCd = lsrsrvTotlIqryCd;
	}
	public String getSearchFrtrYm() {
		return searchFrtrYm;
	}
	public void setSearchFrtrYm(String searchFrtrYm) {
		this.searchFrtrYm = searchFrtrYm;
	}
	public String getSearchStdrYm() {
		return searchStdrYm;
	}
	public void setSearchStdrYm(String searchStdrYm) {
		this.searchStdrYm = searchStdrYm;
	}
}
