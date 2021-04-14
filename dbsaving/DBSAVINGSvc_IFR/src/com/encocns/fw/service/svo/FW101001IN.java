/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW101001IN.java
 * @brief Service Management IN
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 6. 20. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

/**
 * @brief Service Management IN
 * @details Service Management IN
 * @author : CHA, SANG-GIL
 * @date : 2019. 6. 20.
 * @version : 1.0.0
 */
public class FW101001IN {

	private String bizLclsCd;                        /* 업무구분코드 */
	private String svcId;                            /* 서비스ID */
	private String mthId;                            /* 메소드ID */
	private String lclCd;                            /* 코드 */
	private String mthNm;                            /* 메소드명 */

	public String getBizLclsCd() {
		return bizLclsCd;
	}
	public void setBizLclsCd(String bizLclsCd) {
		this.bizLclsCd = bizLclsCd;
	}
	public String getSvcId() {
		return svcId;
	}
	public void setSvcId(String svcId) {
		this.svcId = svcId;
	}
	public String getMthId() {
		return mthId;
	}
	public void setMthId(String mthId) {
		this.mthId = mthId;
	}
	public String getLclCd() {
		return lclCd;
	}
	public void setLclCd(String lclCd) {
		this.lclCd = lclCd;
	}
	public String getMthNm() {
		return mthNm;
	}
	public void setMthNm(String mthNm) {
		this.mthNm = mthNm;
	}
}
