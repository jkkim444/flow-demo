/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CacheController.java
 * @brief Common Code cache refresh
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 6. 25. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.controller
 * @brief Common Controller Package
 */
package com.encocns.fw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @brief Common Code Cache Controller
 * @details Common Code Cache Controller
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 6. 25.
 * @version : 1.0.0
 */
@Controller
public class CacheController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private EhCacheCacheManager cacheManager;

    /**
     * @brief Common Code cache refresh
     * @details Common Code cache refresh
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 6. 25.
     * @version : 1.0.0
     * @param request
     * @param response
     * @param model
     * @throws Exception
     */
    @RequestMapping(value = "/commonCodeRefresh", method = RequestMethod.POST)
    public void commonCodeRefresh( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception {
        try {
            Cache cache = cacheManager.getCache("commonCodeCache");
            cache.clear();

            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("commonCodeRefresh complete!");
            }

        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
