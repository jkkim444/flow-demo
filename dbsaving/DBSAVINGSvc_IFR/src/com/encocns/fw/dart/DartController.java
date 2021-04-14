package com.encocns.fw.dart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encocns.co.service.svo.CO000101IN;
import com.google.gson.JsonObject;

public class DartController {

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
        
        
        
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.CREATED);
    }	
	
	
	
}
