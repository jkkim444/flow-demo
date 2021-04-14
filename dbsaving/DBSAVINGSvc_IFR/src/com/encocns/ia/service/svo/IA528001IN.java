/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file IA528001IN.java
 * @brief 유가증권요약내역 리스트 조회 management IN
 * @section Major History
 * <pre>
 *   - LEE, MI-RAE | 2020. 10. 12.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

/**
 * @brief 유가증권요약내역 리스트 조회 management IN
 * @details유가증권요약내역 리스트 조회 management IN
 * @author : LEE, MI-RAE
 * @date : 2020. 10. 12.
 * @version : 1.0.0
 */
public class IA528001IN {
	private String stdrYm;                           /* 기준년월 */
	private String acngBaseCd;                       /* 회계기준코드 */
	private String mkstIqryDivCd;                    /* 조회구분코드 */
	private String usrId;                            /* 사용자ID */

	public String getStdrYm() {
		return stdrYm;
	}
	public void setStdrYm(String stdrYm) {
		this.stdrYm = stdrYm;
	}
	public String getAcngBaseCd() {
		return acngBaseCd;
	}
	public void setAcngBaseCd(String acngBaseCd) {
		this.acngBaseCd = acngBaseCd;
	}
	public String getMkstIqryDivCd() {
		return mkstIqryDivCd;
	}
	public void setMkstIqryDivCd(String mkstIqryDivCd) {
		this.mkstIqryDivCd = mkstIqryDivCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
}
