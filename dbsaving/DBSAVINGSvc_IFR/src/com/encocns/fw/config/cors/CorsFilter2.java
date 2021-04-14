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

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @brief Access Controller Allow Filter
 * @details Access Controller Allow Filter이다.
 * @author : joy
 * @date : 2016. 9. 2.
 * @version : 1.0.0
 */
public class CorsFilter2 implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	    HttpServletResponse response = (HttpServletResponse) res;
	    
	    System.out.println("@@@@@ cros");
	    
	    response.setHeader("Access-Control-Allow-Origin", "*");     //허용할 Origin(요청 url) : "*" 의 경우 모두 허용
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");     //허용할 request http METHOD : POST, GET, DELETE, PUT
	    response.setHeader("Access-Control-Max-Age", "3600");     //브라우저 캐시 시간(단위: 초) : "3600" 이면 최소 1시간 안에는 서버로 재요청 되지 않음
	    response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");    //요청 허용 헤더(ajax : X-Requested-With)
	    // (cf. 요청 허용 헤더 : "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization")
	    chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
}
