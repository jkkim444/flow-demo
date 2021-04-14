/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW105002IN.java
 * @brief logback.xml file contents update ISVO
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
 * @brief logback.xml file contents update ISVO
 * @details logback.xml file contents update ISVO
 * @author : KO, GYU-HWAN
 * @date : 2019. 8. 6.
 * @version : 1.0.0
 */
public class FW105002IN {

    private String dvcd;     /* (online, batch) partition code */
    private String logLevel; /* log level */

    public String getDvcd() {
        return dvcd;
    }
    public void setDvcd(String dvcd) {
        this.dvcd = dvcd;
    }
    public String getLogLevel() {
        return logLevel;
    }
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
