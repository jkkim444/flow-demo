/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SessionCounterListener.java
 * @brief
 * \~english Session Counter Listener
 * \~korean 세션 카운터 리스너
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 11. 22. | First Created
 * </pre>
 */
/**
 * @namespace tw.linebank.ifrs.common.listener
 * @brief Common Listener Package
 */
package com.encocns.fw.listener;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @brief
 * \~english Session Counter Listener
 * \~korean 세션 카운터 리스너
 * @details
 * <pre>
 * \~english Session Counter Listener
 * \~korean 세션 카운터 리스너
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 11. 22.
 * @version : 1.0.0
 */
public class SessionCounterListener implements HttpSessionListener{

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionCounterListener.class);

    private static int activeSessions;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        activeSessions++;

        if(LOGGER.isInfoEnabled()) {
            LOGGER.info("Created! activeSessions : {}", activeSessions);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        activeSessions--;

        if(LOGGER.isInfoEnabled()) {
            LOGGER.info("Destoryed! activeSessions : {}", activeSessions);
        }
    }

}
