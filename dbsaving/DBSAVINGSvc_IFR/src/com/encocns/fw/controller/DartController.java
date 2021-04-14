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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @brief Index Controller
 * @details Index Controller
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 9. 1.
 * @version : 1.0.0
 */
@Controller
public class DartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DartController.class);
    
    @Value("#{globalContext}")
    private Properties globalContextProp;
    
    
    @RequestMapping(value = "/dartSearch", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> dartSearch (@RequestBody Map<String, Object> reqMap,
            HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        
        String dartKey = globalContextProp.getProperty("DART_KEY");
        String param = String.valueOf(reqMap.get("param"));
        
        LOGGER.debug(dartKey);
        
        HttpURLConnection con = null;
        BufferedReader br = null;
        String resString = "";
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        JSONObject json = new JSONObject();
        
        try {
            
            URL url = new URL("http://dart.fss.or.kr/api/search.json?auth="+dartKey+"&"+param);
            con = (HttpURLConnection)url.openConnection();
            
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            
            String temp=null;
            
            while( ( temp=br.readLine()  ) !=null ) {
                resString = resString.concat(temp);
            }
            
        }
        catch(Exception e) {
            json.put("res", "{\"err_code\" : \"-1\", \"err_msg\" : \"DRAT와의 통신이 원활하지 않습니다.<br>잠시후 다시 시도해주세요\"}");
            return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.OK);
        }
        finally {
            try {
                if (con != null) {
                    con.disconnect();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception ee) {
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error(ee.getMessage());
                }
            }
        }
        
        json.put("res", resString);
        return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/dartCompany", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> dartCompany ( @RequestBody Map<String, Object> reqMap, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        
        String dartKey = globalContextProp.getProperty("DART_KEY");
        String crp_cd = String.valueOf(reqMap.get("crp_cd"));
        
        LOGGER.debug(dartKey);
        
        HttpURLConnection con = null;
        BufferedReader br = null;
        String resString = "";
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        JSONObject json = new JSONObject();
        
        try {
            
            URL url = new URL("http://dart.fss.or.kr/api/company.json?auth="+dartKey+"&crp_cd="+crp_cd);
            con = (HttpURLConnection)url.openConnection();
            
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            
            String temp=null;
            
            while( ( temp=br.readLine()  ) !=null ) {
                resString = resString.concat(temp);
            }
            
        }
        catch(Exception e) {
            json.put("res", "{\"err_code\" : \"-1\", \"err_msg\" : \"DRAT와의 통신이 원활하지 않습니다.<br>잠시후 다시 시도해주세요\"}");
            return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.OK);
        }
        finally {
            try {
                if (con != null) {
                    con.disconnect();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception ee) {
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error(ee.getMessage());
                }
            }
        }
        
        json.put("res", resString);
        return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.OK);
    }
    

}