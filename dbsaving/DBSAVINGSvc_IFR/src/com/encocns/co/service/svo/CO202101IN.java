/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO202101IN.java
 * @brief 서비스 목록 조회 IN
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

/**
 * @brief 서비스 목록 조회 IN
 * @details 서비스 목록 조회 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO202101IN {

	private String bizLclsCd;                        /* 업무구분코드 */
	private String svcId;                            /* 서비스ID */
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
    public String getMthNm() {
        return mthNm;
    }
    public void setMthNm(String mthNm) {
        this.mthNm = mthNm;
    }

}
