package com.encocns.enfra.core.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encocns.enfra.core.bean.CommonCode;
import com.encocns.enfra.core.util.JsonUtil;
import com.encocns.enfra.db.dvo.CCD_C_CDDTL_DVO;
import com.google.gson.JsonArray;

@Controller
public class CommonCodeController {

	@Autowired
	CommonCode commonCode;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/commonCode", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> callFileService( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");		
		
		String cd_dmn_id = request.getParameter("codeDoamin");

		CCD_C_CDDTL_DVO codeDvo = new CCD_C_CDDTL_DVO();
//		codeDvo.setLcl_cd(LocaleContextHolder.getLocale().toString());
		codeDvo.setCd_dmn_id(cd_dmn_id);
				
		ArrayList<CCD_C_CDDTL_DVO> cdList =  (ArrayList<CCD_C_CDDTL_DVO>)commonCode.getCode(codeDvo);
		
		JsonArray cdjSONArray = JsonUtil.toJsonArray(cdList);
		        
		return new ResponseEntity<String>(cdjSONArray.toString(), responseHeaders, HttpStatus.OK);
	}
}
