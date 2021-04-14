/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IndexContoller.java
 * @brief Index contoller
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 9. 1. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.controller
 * @brief Common Contoller Package
 */
package com.encocns.fw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encocns.co.dto.CO201001DTO;
import com.encocns.co.dto.CO201002DTO;
import com.encocns.co.dto.CO201003DTO;
import com.encocns.co.service.CO0000;
import com.encocns.co.service.CO2010;
import com.encocns.co.service.svo.CO000001IN;
import com.encocns.co.service.svo.CO000001OUT;
import com.encocns.co.service.svo.CO000002IN;
import com.encocns.co.service.svo.CO000002OUT;
import com.encocns.co.service.svo.CO000003IN;
import com.encocns.co.service.svo.CO000003OUT;
import com.encocns.co.service.svo.CO201001IN;
import com.encocns.co.service.svo.CO201001OUT;
import com.encocns.co.service.svo.CO201004IN;
import com.encocns.co.service.svo.CO201004OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.util.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @brief Index Controller
 * @details Index Controller
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 9. 1.
 * @version : 1.0.0
 */
@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
    private CO0000 serviceMain;

    @Autowired
    private CO2010 serviceMenu;


    @Value("#{globalContext}")
    protected Properties globalContextProp;

    /**
     * @brief When inquiring the main page, check SSO and return the user ID as a parameter to load the main page.
     * @details When inquiring the main page, check SSO and return the user ID as a parameter to load the main page.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 9. 1.
     * @param model Model
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param session Session
     * @return Index Main page view
     * @throws Exception
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Session ID : " + request.getSession().getId());
        }

        //session model set
        model.addAttribute("_sessionInfo", JsonUtil.toJsonObject(serviceComponent.getSessionVO()));

        boolean isSSO = false;

        request.setAttribute("menuId", request.getParameter("menuId"));

        // file Validition Info
        model.addAttribute("fileUploadMaxSize", globalContextProp.getProperty("FILE_UPLOAD_MAX_SIZE"));
        model.addAttribute("fileUploadExtList", globalContextProp.getProperty("FILE_UPLOAD_EXT_LIST"));

        Map<String, Object> mapParam = new HashMap<String, Object>();

        if (serviceComponent.getSessionVO() != null) {
            isSSO = serviceComponent.getSessionVO().getSso();
        }

        if (LOGGER.isDebugEnabled())
            LOGGER.debug("isSSO : " + isSSO);

        if (serviceComponent.getSessionVO() != null) {
            mapParam.put("usr_id", serviceComponent.getSessionVO().getUserId());
        }

        return "index";
    }

    /**
     * @brief menu list lookup
     * @details menu list lookup
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 6. 12.
     * @version : 1.0.0
     * @param request
     * @param response
     * @param model
     * @return JSON top level/lower menu list
     * @throws Exception
     */
    @RequestMapping(value = "/selectMenuList" , method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> selectMenuList( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception
    {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        CO201001IN inTopMenuList = new CO201001IN();

        //Top level menu list inquiry
        List<CO201002DTO> listTopMenu = serviceMenu.selectTopMenuList();

        //Lower level menu list inquiry
        JsonArray resultListMenu = new JsonArray();

        for(CO201002DTO dtoTopMenu : listTopMenu) {

            CO201004IN inMenuList = new CO201004IN();

            inMenuList.setBizLclsCd(dtoTopMenu.getBizLclsCd());
            inMenuList.setUsrId(serviceComponent.getSessionVO().getUserId());
            inMenuList.setEmpno(serviceComponent.getSessionVO().getEmpno());
            inMenuList.setMenuId(dtoTopMenu.getMenuId());

            CO201004OUT outMenuList = serviceMenu.selectMenuList(inMenuList);

            List<CO201003DTO> listBizLclsMenu = outMenuList.getOutMenuList();

            resultListMenu.add(JsonUtil.toJsonArray(listBizLclsMenu));


        }

        JsonArray resultListTopMenu = new JsonArray();

        resultListTopMenu = JsonUtil.toJsonArray(listTopMenu);

        //Menu jsonObject add
        JsonObject result = new JsonObject();
        result.add("topMenu", resultListTopMenu);
        result.add("menu", resultListMenu);
        result.addProperty("menuId", request.getParameter("menuId"));

        if( resultListMenu.size()==0 ) {
        	// 에러 메시지 출력 문제로 에러 코스 변경 ( INTERNAL_SERVER_ERROR -> UNAUTHORIZED )
//            return new ResponseEntity<String>(result.toString(), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<String>(result.toString(), responseHeaders, HttpStatus.UNAUTHORIZED); // UNAUTHORIZED 클라이언트 인증 실패
        }

        return new ResponseEntity<String>(result.toString(), responseHeaders, HttpStatus.OK);
    }

    /**
     * @brief menu screen list inquiry
     * @details menu screen list inquiry
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 9. 22.
     * @param session
     * @param inSearchText
     * @return ResponseEntity<String> menu screen list
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "/selectMenuScrList", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> selMenuScrList(CO201001IN inSearchText) throws Exception {
        JsonArray jsonArr = new JsonArray();

        CO201001OUT outSel = new CO201001OUT();

        ArrayList<CO201001DTO> arrMenuScrList = null;
        inSearchText.setEmpno(serviceComponent.getSessionVO().getEmpno());
        arrMenuScrList = (ArrayList) serviceMenu.selectMenuScrList(inSearchText);

        outSel.setArrList(arrMenuScrList);

        for (CO201001DTO dtoMenuScrList : arrMenuScrList) {
            JsonObject obj = new JsonObject();

            obj.addProperty("menuId", dtoMenuScrList.getMenuId());
            obj.addProperty("menuName", dtoMenuScrList.getMenuNm());
            obj.addProperty("scrId", dtoMenuScrList.getScrId());
            obj.addProperty("scrNm", dtoMenuScrList.getScrNm());
            obj.addProperty("rmkCntn", dtoMenuScrList.getRmkCntn());

            jsonArr.add(obj);
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        return new ResponseEntity<String>(jsonArr.toString(), responseHeaders, HttpStatus.OK);
    }

    /**
     * @brief menu screen information inquiry
     * @details menu screen information inquiry
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 9. 22.
     * @param session
     * @param inSearchText
     * @return ResponseEntity<String> menu screen information
     * @throws Exception
     */
    @RequestMapping(value = "/selectMenuScrInfo", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> selectMenuScrInfo(CO201001IN inSearchText) throws Exception {
        CO201001DTO dtoMenuScrInfo = serviceMenu.selectMenuScrInfo(inSearchText);

        JSONObject obj = new JSONObject();

        if(null != dtoMenuScrInfo){
            obj.put("menuId", dtoMenuScrInfo.getMenuId());
            obj.put("menuNm", dtoMenuScrInfo.getMenuNm());
            obj.put("scrId", dtoMenuScrInfo.getScrId());
            obj.put("scrNm", dtoMenuScrInfo.getScrNm());
            obj.put("svcId", dtoMenuScrInfo.getSvcId());
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        return new ResponseEntity<String>(obj.toString(), responseHeaders, HttpStatus.OK);
    }

    /**
     * @brief screen information inquiry
     * @details screen information inquiry
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 9. 1.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param model Model
     * @return Return Json Object after viewing screen information
     * @throws Exception exception
     */
    @RequestMapping(value = "/selectScreenInfo", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> selectScreenInfo( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        CO201001IN inScreenInfo = new CO201001IN();

        inScreenInfo.setScrId(request.getParameter("scrId"));

        CO201001DTO dtoScreenInfo = serviceMenu.selectScreenInfo(inScreenInfo);

        JsonObject json = new JsonObject();
        json.add("screenInfo", JsonUtil.getObject(dtoScreenInfo));

        if(LOGGER.isDebugEnabled()) LOGGER.debug(json.toString() );

        return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.OK);
    }

    /**
     * @brief selectMainContents
     * @details 메인화면조회
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 7. 4.
     * @version : 1.0.0
     * @param reqMap
     * @param model
     * @return main contents
     * @throws Exception
     */
    @RequestMapping(value = "/selectMainContents", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> selectMainContents( @RequestBody Map<String, Object> reqMap,
            HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception {

        CO000001IN in = new CO000001IN();
        CO000001OUT main = serviceMain.selectHomeNotice(in);

        CO000002IN in1 = new CO000002IN();
        CO000002OUT main1 = serviceMain.selectNoticetListCmknMtr(in1);

        CO000003IN in2 = new CO000003IN();
        CO000003OUT main2 = serviceMain.selectNoticeListClsnInfoMgmt(in2);

        JsonObject json = new JsonObject();

        json.add("arrList", JsonUtil.toJsonArray(main1.getArrList()));
        json.add("arrList3", JsonUtil.toJsonArray(main2.getArrList3()));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.OK);
    }


}