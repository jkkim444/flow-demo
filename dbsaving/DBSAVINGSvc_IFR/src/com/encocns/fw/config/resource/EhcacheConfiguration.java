/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file EhcacheConfiguration.java
 * @brief Ehcache Configuration
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 9. 1. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.config.resource
 * @brief 
 */
package com.encocns.fw.config.resource;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @brief Ehcache Configuration
 * @details Ehcache Configuration
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 9. 1.
 * @version : 1.0.0
 */
@Configuration
@EnableCaching  
public class EhcacheConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(EhcacheConfiguration.class);
    
    /**
     * @brief EhCache Manager Factory Bean
     * @details EhCache Manager Factory Bean
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 9. 1.
     * @return EhCache Manager Factory Bean
     */
    @Bean(name = "ehcache")
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("com/encocns/fw/config/resource/ehcache.xml"));

        return bean;
    }

    /**
     * @brief Cache Manager
     * @details Cache Manager
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 9. 1.
     * @return EhcacheCacheManager
     */
    @Bean(name = "cacheManager")
    public EhCacheCacheManager cacheManager() {
        ehCacheManagerFactoryBean().getObject();
        return new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
    }

    /**
     * @brief Post Construct
     * @details Post Construct
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 9. 1.
     */
    @PostConstruct
    public void postConstruct() {
        if(LOGGER.isInfoEnabled()) LOGGER.info("Cache Created");
    }

}
