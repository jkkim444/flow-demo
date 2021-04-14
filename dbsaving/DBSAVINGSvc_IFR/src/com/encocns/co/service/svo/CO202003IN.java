/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO202003IN.java
 * @brief 화면 관리 삭제 IN
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
 * @brief 화면 관리 삭제 IN
 * @details 화면 관리 삭제 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO202003IN {

	private String bizLclsCd;                     /* 업무구분코드 */
	private String scrId;                         /* 화면ID */

    public String getBizLclsCd() {
        return bizLclsCd;
    }
    public void setBizLclsCd(String bizLclsCd) {
        this.bizLclsCd = bizLclsCd;
    }
    public String getScrId() {
        return scrId;
    }
    public void setScrId(String scrId) {
        this.scrId = scrId;
    }
}
