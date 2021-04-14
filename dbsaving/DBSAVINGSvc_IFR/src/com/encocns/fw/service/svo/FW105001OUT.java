/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW105001OUT.java
 * @brief logback.xml file contents select OSVO
 * @section Major History
 * <pre>
 *   - KO, GYU-HWAN | 2019. 8. 6. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common ISVO Package
 */
package com.encocns.fw.service.svo;

/**
 * @brief logback.xml file contents select OSVO
 * @details logback.xml file contents select OSVO
 * @author : KO, GYU-HWAN
 * @date : 2019. 8. 6.
 * @version : 1.0.0
 */
public class FW105001OUT {

    private String onlineLevel; /* online log level value */
    private String batchLevel;  /* batch log level value */

    public String getOnlineLevel() {
        return onlineLevel;
    }
    public void setOnlineLevel(String onlineLevel) {
        this.onlineLevel = onlineLevel;
    }
    public String getBatchLevel() {
        return batchLevel;
    }
    public void setBatchLevel(String batchLevel) {
        this.batchLevel = batchLevel;
    }
}
