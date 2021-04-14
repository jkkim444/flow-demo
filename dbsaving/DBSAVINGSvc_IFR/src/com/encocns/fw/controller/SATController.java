/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SATController.java
 * @brief
 * 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - 홍길동 | 2019. 12. 7. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.controller
 * @brief
 */
package com.encocns.fw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encocns.co.dao.CO0001DAO;
import com.google.gson.JsonObject;

/**
 * @brief
 * 간략 설명을 작성한다.
 * @details
 * <pre>
 * 상세 설명을 작성한다.
 * </pre>
 * @author : 홍길동
 * @date : 2019. 12. 7.
 * @version : 1.0.0
 */
@Controller
public class SATController {


    @Autowired
    private CO0001DAO dao;


//    @RequestMapping(value = "/selectAuthList" , method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> selectMenuList( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception
    {
//        ArrayList authList = dao.selectAuthList();
//        ArrayList dlgList = dao.selectDlgAuthList();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        JsonObject result = new JsonObject();

//        String strList = JsonUtil.toJsonArray(authList).toString();
//
//        result.add("authList", JsonUtil.toJsonArray(authList));
//        result.add("dlgList", JsonUtil.toJsonArray(dlgList));

        return new ResponseEntity<String>(result.toString(), responseHeaders, HttpStatus.OK);
    }

}
