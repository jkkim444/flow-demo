/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file LoginCheckInterceptor.java
 * @brief Login Check Interceptor
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 9. 1. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.interceptor
 * @brief Common Interceptor Package
 */
package com.encocns.fw.interceptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.encocns.enfra.core.service.ServiceConst;
import com.encocns.enfra.exception.EnfraNoLoginException;

/**
 * @brief Login Check Interceptor
 * @details Login Check Interceptor
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 4. 29.
 * @version : 1.0.0
 */
public class LoginCheckInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCheckInterceptor.class);

    /**
     * @brief LoginCheck Interceptor preHandle
     * @details LoginCheck Interceptor preHandle
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 9. 1.
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param handler Handler
     * @return boolean true
     * @throws Exception exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Pattern pattern = Pattern.compile("([^\\s]+(\\.(?i)(js|css|jpg|png|gif|bmp|less|eot|woff|ttf|xlsx|zip|ico))$)");
        Matcher matcher = pattern.matcher(request.getRequestURI());

        if(matcher.matches()) {
          return true;
        }

        HttpSession session  = request.getSession(false);

        if( session == null || (session != null && session.getAttribute(ServiceConst.SERVICE_CONTEXT_KEY) == null )) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("login user is null");
            }
            throw new EnfraNoLoginException("login user is null");
        }

        return true;
    }

    /**
     * @brief LoginCheck Interceptor postHandle
     * @details LoginCheck Interceptor postHandle
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 9. 1.
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param handler Handler
     * @param modelAndView Model And View
     * @throws Exception exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    /**
     * @brief LoginCheck Interceptor afterCompletion
     * @details LoginCheck Interceptor afterCompletion
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 9. 1.
     * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param handler Handler
     * @param ex Exception
     * @throws Exception exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
