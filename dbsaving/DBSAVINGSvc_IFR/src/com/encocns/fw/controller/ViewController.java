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

import java.net.URLDecoder;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.service.ServiceConst;
import com.encocns.enfra.core.session.SessionVO;
import com.encocns.enfra.core.util.JsonUtil;

/**
 * @brief Login Controller
 * @details Login Controller
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 8. 29.
 * @version : 1.0.0
 */
@Controller
public class ViewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewController.class);

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
    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public String view(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

//        String contextPath = globalContextProp.getProperty("CONTEXT_PATH");

        String scrId = (request.getParameter("scrId")!=null)?request.getParameter("scrId"):"";
        String bizType = scrId.substring(0, 2).toLowerCase();


//        String jsUrl = contextPath+"/views_script/" + bizType + "/"+ scrId +".js?v=" + System.currentTimeMillis();
        String jspUrl = bizType + "/"+ scrId +".jsp";

        model.addAttribute("jspUrl", jspUrl);

        return "view";

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
    @RequestMapping(value = "/pop", method = RequestMethod.POST)
    public String pop(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        String contextPath = globalContextProp.getProperty("CONTEXT_PATH");

        SessionVO _sessionInfo = (SessionVO)request.getSession().getAttribute(ServiceConst.SERVICE_CONTEXT_KEY);

        Object sessionInfo = null;
        //@@통테용
        if( _sessionInfo!=null ) sessionInfo = (Object)JsonUtil.toJsonObject(_sessionInfo);

        String scrId = (request.getParameter("scrId")!=null)?request.getParameter("scrId"):"";
        String scrNm = (request.getParameter("scrNm")!=null)?URLDecoder.decode(request.getParameter("scrNm"), "UTF-8"):"";
        String bizType = scrId.substring(0, 2).toLowerCase();

        String svcId = (request.getParameter("svcId")!=null)?request.getParameter("svcId"):"";
        String param = (request.getParameter("param")!=null)?URLDecoder.decode(request.getParameter("param"), "UTF-8"):"";

        System.err.println(request.getParameter("param"));


        String jsUrl = contextPath+"/views_script/" + bizType + "/"+ scrId +".js?v=" + System.currentTimeMillis();
        String jspUrl = bizType + "/"+ scrId +".jsp";

        model.addAttribute("scrId", scrId);
        model.addAttribute("scrNm", scrNm);
        model.addAttribute("bizType", bizType);
        model.addAttribute("svcId", svcId);
        model.addAttribute("_param", JsonUtil.toJsonObject(param));


        model.addAttribute("jsUrl", jsUrl);
        model.addAttribute("jspUrl", jspUrl);

        //@@통테용
        if( _sessionInfo!=null ) {
        	model.addAttribute("sessionInfo", JsonUtil.toJsonObject(_sessionInfo).toString());
        }

        return "pop";

    }

}

