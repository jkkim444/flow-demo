/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW102001IN.java
 * @brief Batch Management IN
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 19. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

/**
 * @brief Batch Management IN
 * @details Batch Management IN
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 19.
 * @version : 1.0.0
 */
public class FW102001IN {

	private String bizLclsCd;                     /* 업무구분코드 */
	private String batId;                         /* 배치ID */
	private String batNm;                         /* 배치명 */

    public String getBizLclsCd() {
		return bizLclsCd;
	}
	public void setBizLclsCd(String bizLclsCd) {
		this.bizLclsCd = bizLclsCd;
	}
	public String getBatId() {
        return batId;
    }
    public void setBatId(String batId) {
        this.batId = batId;
    }
    public String getBatNm() {
        return batNm;
    }
    public void setBatNm(String batNm) {
        this.batNm = batNm;
    }


}
