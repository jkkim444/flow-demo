/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CorsFilter.java
 * @brief 
 */
/**
 * @namespace com.encocns.enfra.core.config.cors
 * @brief 
 */
package com.encocns.fw.config.cors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @brief Access Controller Allow Filter
 * @details Access Controller Allow Filter이다.
 * @author : joy
 * @date : 2016. 9. 2.
 * @version : 1.0.0
 */
public class CorsFilter extends OncePerRequestFilter {

    /**
     * @brief Do Filter Internal
     * @details Do Filter Internal이다.
     * @author : joy
     * @date : 2016. 9. 2.
     * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

    	response.addHeader("Access-Control-Allow-Origin", "*");
//    	response.addHeader("Access-Control-Allow-Origin", "http://dart.fss.or.kr");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept,X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
//        response.addHeader("Access-Control-Allow-Methods", "*");
//        response.addHeader("Access-Control-Allow-Headers", "*");
        response.addHeader("Access-Control-Max-Age", "1728000");

//        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
//            // CORS "pre-flight" request
//        }

        filterChain.doFilter(request, response);
    }

}
