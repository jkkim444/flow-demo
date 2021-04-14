/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW103001IN.java
 * @brief Batch Operation Status IN
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 22. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

/**
 * @brief Batch Operation Status IN
 * @details Batch Operation Status IN
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 22.
 * @version : 1.0.0
 */
public class FW103002IN {

	private String grpId;                         /* 그룹ID */
	private String grpNm;                         /* 그룹명 */

    public String getGrpId() {
        return grpId;
    }
    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }
    public String getGrpNm() {
        return grpNm;
    }
    public void setGrpNm(String grpNm) {
        this.grpNm = grpNm;
    }


}
