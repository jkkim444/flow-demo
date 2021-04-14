/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW102003IN.java
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
public class FW102004IN {

	private String batId;                            /* 배치ID */

    public String getBatId() {
        return batId;
    }

    public void setBatId(String batId) {
        this.batId = batId;
    }


}
