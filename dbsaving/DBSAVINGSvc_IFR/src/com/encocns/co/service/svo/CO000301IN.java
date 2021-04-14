/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */

/**
 * @file CO000301IN.java
 * @brief 부서 조회 IN
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
 * @brief 부서 조회 IN
 * @details 부서 조회 IN
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000301IN {

	private String cd;                            /* 코드 */
	private String nm;                            /* 명 */

    public String getCd() {
        return cd;
    }
    public void setCd(String cd) {
        this.cd = cd;
    }
    public String getNm() {
        return nm;
    }
    public void setNm(String nm) {
        this.nm = nm;
    }

}
