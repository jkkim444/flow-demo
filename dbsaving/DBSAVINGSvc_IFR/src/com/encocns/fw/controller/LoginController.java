/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file LoginController.java
 * @brief Login Controller
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 8. 29. | First Created
 * </pre>
 */
/**
 * @namespace tw.linebank.ifrs.common.controller
 * @brief Common Controller Package
 */
package com.encocns.fw.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encocns.co.service.CO0001;
import com.encocns.co.service.svo.CO000101IN;
import com.encocns.co.service.svo.CO000101OUT;
import com.encocns.co.service.svo.CO000102OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.service.ServiceConst;
import com.encocns.enfra.core.session.SessionVO;
import com.encocns.enfra.exception.EnfraMessage;
import com.encocns.fw.util.EncryptionUtil;
import com.google.gson.JsonObject;

/**
 * @brief Login Controller
 * @details Login Controller
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 8. 29.
 * @version : 1.0.0
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private CO0001 serviceLogin;

    @Autowired
    private ServiceComponent serviceComponent;

    @Value("#{globalContext}")
    private Properties globalContextProp;

    @Value("${spring.profiles.active}")
    private String profile;

    /**
     * @brief login processing
     * @details Log in with the userId, passwd entered.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 29.
     * @version : 1.0.0
     * @param isvo
     * @param request
     * @param response
     * @param model
     * @return ResponseEntity<String> Return json object after login processing is complete
     * @throws Exception
     */
    @RequestMapping(value = "/ssologin", method = RequestMethod.GET)
    public String ssoLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        String id = request.getParameter("id");

        LOGGER.debug("============================== 인증키 =========================");
        LOGGER.debug(id);

        int empno=0;

        if( serviceLogin!=null ) {
            empno = serviceLogin.selectEmpno(id);
        }

        LOGGER.debug("============================== 변환된 사번 =========================");
        LOGGER.debug(String.valueOf(empno));

        String menuId = "";

        CO000101IN isvo = new CO000101IN();

        isvo.setEmpno(empno);

        try {

            CO000101OUT outLogin = serviceLogin.selectLogin(isvo);

            if (outLogin != null && outLogin.getEmpno()>0 ) {

                // Create Session
                HttpSession hs = request.getSession(true);

                SessionVO sessionVO = new SessionVO();

                sessionVO.setEmpno(outLogin.getEmpno());
                sessionVO.setEmpKnm(outLogin.getEmpNm());
                sessionVO.setDeptCd(outLogin.getDeptCd());
                sessionVO.setDeptNm(outLogin.getDeptNm());

                /* 권한리스트 */
//                CO000102OUT roleOut = serviceLogin.selectAuthInfo(isvo);
//                sessionVO.setRole(roleOut.getRole());

                ////////////////////////////////////////////////////////////////
                sessionVO.setUserId(String.valueOf(outLogin.getEmpno()));
                sessionVO.setUserName(outLogin.getEmpNm());
                sessionVO.setLoginDate(new DateFormatter("yyyyMMdd").print(new Date(), LocaleContextHolder.getLocale()));
                sessionVO.setLoginTime(new DateFormatter("HHmmss").print(new Date(), LocaleContextHolder.getLocale()));

                sessionVO.setSso(false);

                hs.setAttribute(ServiceConst.SERVICE_CONTEXT_KEY, sessionVO);

//                return "redirect:/?menuId="+menuId;
                return "redirect:/";

            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * @brief logout processing
     * @details logout processing
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 29.
     * @param redirectAttributes
     * @param param Parameters
     * @param request HttpServletRequest
     * @return redirect login.do
     * @throws IOException
     */
    @RequestMapping(value = "/procLogout", method = RequestMethod.GET)
    public String confirmationLogoutProc(RedirectAttributes redirectAttributes, @RequestParam Map<String, String> param,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(LOGGER.isInfoEnabled()) {
            LOGGER.info("##### Logout User ID : {}", serviceComponent.getSessionVO().getUserId());
        }

        if (request.getSession().getAttribute("SSO_ID") != null) {
            request.getSession().invalidate();
            return "logout";
        }

        request.getSession().invalidate();

        return "redirect:/login.do";
    }

    /**
     * @brief login processing
     * @details Log in with the userId, passwd entered.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 29.
     * @version : 1.0.0
     * @param isvo
     * @param request
     * @param response
     * @param model
     * @return ResponseEntity<String> Return json object after login processing is complete
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login( HttpServletRequest request, HttpServletResponse response, Model model,
            SessionStatus sessionStatus )   throws Exception {

//        if( "product".equals(profile) ) {
//          throw new Exception("유효하지 않은 접근");
//        }

        // login session delete
        sessionStatus.setComplete();

        return "login";
    }

    /**
     * @brief login processing
     * @details Log in with the userId, passwd entered.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 29.
     * @version : 1.0.0
     * @param isvo
     * @param request
     * @param response
     * @param model
     * @return ResponseEntity<String> Return json object after login processing is complete
     * @throws Exception
     */
    @RequestMapping(value = "/mailLogin", method = RequestMethod.GET)
    public String mailLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        String id = request.getParameter("id");
        String menuId = request.getParameter("menuid");

        CO000101IN isvo = new CO000101IN();

        LOGGER.debug("============================== 인증키 =========================");
        LOGGER.debug(id);
        int empno=0;

        if( serviceLogin!=null ) {
            empno = serviceLogin.selectEmpno(id);
            isvo.setEmpno(empno);
        }

        LOGGER.debug("============================== 변환된 사번 =========================");

        try {

            CO000101OUT outLogin = serviceLogin.selectLogin(isvo);

            if (outLogin != null && outLogin.getEmpno()>0 ) {

                // Create Session
                HttpSession hs = request.getSession(true);

                SessionVO sessionVO = new SessionVO();

                sessionVO.setEmpno(outLogin.getEmpno());
                sessionVO.setEmpKnm(outLogin.getEmpNm());
                sessionVO.setDeptCd(outLogin.getDeptCd());
                sessionVO.setDeptNm(outLogin.getDeptNm());

                /* 권한리스트 */
//                CO000102OUT roleOut = serviceLogin.selectAuthInfo(isvo);
//                sessionVO.setRole(roleOut.getRole());

                ////////////////////////////////////////////////////////////////
                sessionVO.setUserId(String.valueOf(outLogin.getEmpno()));
                sessionVO.setUserName(outLogin.getEmpNm());
                sessionVO.setLoginDate(new DateFormatter("yyyyMMdd").print(new Date(), LocaleContextHolder.getLocale()));
                sessionVO.setLoginTime(new DateFormatter("HHmmss").print(new Date(), LocaleContextHolder.getLocale()));

                sessionVO.setSso(false);

                hs.setAttribute(ServiceConst.SERVICE_CONTEXT_KEY, sessionVO);

                return "redirect:/?menuId="+menuId;

            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @brief login processing
     * @details Log in with the userId, passwd entered.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 29.
     * @version : 1.0.0
     * @param isvo
     * @param request
     * @param response
     * @param model
     * @return ResponseEntity<String> Return json object after login processing is complete
     * @throws Exception
     */
    @RequestMapping(value = "/loginTemp", method = RequestMethod.GET)
    public String loginTmp( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception {

        String strEmpno = request.getParameter("empno");

        if( strEmpno==null || "".equals(strEmpno ) ) {
            strEmpno = "82000629";
        }

        int empno = Integer.valueOf(strEmpno);
        CO000101IN isvo = new CO000101IN();

        isvo.setEmpno(empno);

        try {

            CO000101OUT outLogin = serviceLogin.selectLogin(isvo);

            if (outLogin != null && outLogin.getEmpno()>0 ) {

                // Create Session
                HttpSession hs = request.getSession(true);

                SessionVO sessionVO = new SessionVO();

                sessionVO.setEmpno(outLogin.getEmpno());
                sessionVO.setEmpKnm(outLogin.getEmpNm());
                sessionVO.setDeptCd(outLogin.getDeptCd());
                sessionVO.setDeptNm(outLogin.getDeptNm());


                /* 권한리스트 */
//                CO000102OUT roleOut = serviceLogin.selectAuthInfo(isvo);
//                sessionVO.setRole(roleOut.getRole());

                ////////////////////////////////////////////////////////////////
                sessionVO.setUserId(String.valueOf(outLogin.getEmpno()));
                sessionVO.setUserName(outLogin.getEmpNm());
                sessionVO.setLoginDate(new DateFormatter("yyyyMMdd").print(new Date(), LocaleContextHolder.getLocale()));
                sessionVO.setLoginTime(new DateFormatter("HHmmss").print(new Date(), LocaleContextHolder.getLocale()));

                sessionVO.setSso(false);

                hs.setAttribute(ServiceConst.SERVICE_CONTEXT_KEY, sessionVO);

                return "redirect:/";

            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * @brief login processing
     * @details Log in with the userId, passwd entered.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 29.
     * @version : 1.0.0
     * @param isvo
     * @param request
     * @param response
     * @param model
     * @return ResponseEntity<String> Return json object after login processing is complete
     * @throws Exception
     */
    @RequestMapping(value = "/procLogin", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> procLogin(CO000101IN isvo, HttpServletRequest request,
            HttpServletResponse response, Model model) throws Exception {

        JsonObject json = new JsonObject();

        try {

        	// 패스워드 암호화
        	isvo.setPswd(EncryptionUtil.encrypt(isvo.getPswd()));

            CO000101OUT outLogin = serviceLogin.selectLogin(isvo);

            if (outLogin != null && outLogin.getEmpno()>0 ) {
                // Create Session
                HttpSession hs = request.getSession(true);

                SessionVO sessionVO = new SessionVO();

                sessionVO.setEmpno(outLogin.getEmpno());
                sessionVO.setEmpKnm(outLogin.getEmpNm());
                sessionVO.setDeptCd(outLogin.getDeptCd());
                sessionVO.setDeptNm(outLogin.getDeptNm());

                /* 권한리스트 */
//                CO000102OUT roleOut = serviceLogin.selectAuthInfo(isvo);
//                sessionVO.setRole(roleOut.getRole());

                ////////////////////////////////////////////////////////////////
                sessionVO.setUserId(String.valueOf(outLogin.getEmpno()));
                sessionVO.setUserName(outLogin.getEmpNm());
                sessionVO.setLoginDate(new DateFormatter("yyyyMMdd").print(new Date(), LocaleContextHolder.getLocale()));
                sessionVO.setLoginTime(new DateFormatter("HHmmss").print(new Date(), LocaleContextHolder.getLocale()));

                hs.setAttribute(ServiceConst.SERVICE_CONTEXT_KEY, sessionVO);

                json.addProperty("login_yn", "1");
                json.addProperty("login_msg", "");
            } else {
                json.addProperty("login_yn", "0");
                json.addProperty("login_msg", EnfraMessage.getMessage("E000015")); //Message : "Invalid ID or password."
            }
        } catch (Exception e) {
            throw e;
        }

        //if (LOGGER.isDebugEnabled()) LOGGER.debug(json.toString());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.OK);
    }


}
