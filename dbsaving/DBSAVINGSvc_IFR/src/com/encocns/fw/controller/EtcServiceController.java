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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.ia.dao.IA9000DAO;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;
import com.google.gson.JsonObject;

/**
 * @brief Login Controller
 * @details Login Controller
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 8. 29.
 * @version : 1.0.0
 */
@Controller
public class EtcServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EtcServiceController.class);

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
	private IA9000DAO daoIA9000;

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
    @RequestMapping(value = "/finBaseYm", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> finBaseYm(IA900002IN inParam, HttpServletRequest request,
            HttpServletResponse response, Model model) throws Exception {

    	// outParam
        JsonObject json = new JsonObject();

		IA900002OUT outParam = new IA900002OUT();
		outParam.setBaseYm(daoIA9000.selectClsninfomgmtBaseYm(inParam));

        json.addProperty("baseYm", outParam.getBaseYm());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.OK);
    }

}

