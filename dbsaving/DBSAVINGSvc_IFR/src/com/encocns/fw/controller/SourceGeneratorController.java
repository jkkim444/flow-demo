/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SourceGeneratorController.java
 * @brief Source Generator Controller
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 7. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.controller
 * @brief Common Controller Package
 */
package com.encocns.fw.controller;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import com.encocns.enfra.core.util.JsonUtil;
import com.encocns.enfra.util.DateUtil;
import com.encocns.fw.velocity.DAODescription;
import com.encocns.fw.velocity.DTODescription;
import com.encocns.fw.velocity.JavaScriptDescription;
import com.encocns.fw.velocity.JspDescription;
import com.encocns.fw.velocity.MapperDescription;
import com.encocns.fw.velocity.ServiceDescription;
import com.encocns.fw.velocity.SourceGenBean;
import com.encocns.fw.velocity.attr.ClassInfoAttribute;
import com.encocns.fw.velocity.attr.MethodInfoAttribute;
import com.encocns.fw.velocity.attr.QueryInfoAttribute;
import com.encocns.fw.velocity.attr.VariableInfoAttribute;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @brief Source Generator Controller
 * @details Source Generator Controller
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 7. 24.
 * @version : 1.0.0
 */
@Controller
public class SourceGeneratorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SourceGeneratorController.class);
	
    @Autowired
    private SourceGenBean sourceGenBean;
    
    @Autowired
    private ServiceComponent serviceComponent;
    
    /**
     * @brief Source Gen Cotroller
     * @details Source Gen Cotroller
     * @author : 이좌형
     * @date : 2019. 7. 24.
     * @version : 1.0.0
     * @param request
     * @param model
     * @return void
     * @throws Exception
     */
    @RequestMapping(value = "/sourceGen", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> codeCreate(HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception {
         
        String strJsonParam = URLDecoder.decode(request.getParameter("param"), "UTF-8");
        JsonObject json = JsonUtil.toJsonObject(strJsonParam);
        
        JsonArray mthJsonArr = json.get("methodList").getAsJsonArray();
        
        System.err.println(json);
        
//        sourceGenBean.
        
        boolean isScreen = json.get("isScreen").getAsBoolean();
        boolean isScript = json.get("isScript").getAsBoolean();
        boolean isService = json.get("isService").getAsBoolean();
        boolean isSvo = json.get("isSvo").getAsBoolean();
        boolean isDao = json.get("isDao").getAsBoolean();
        boolean isMapper = json.get("isMapper").getAsBoolean();
        String popYn = json.get("popYn").getAsString();
        String splitYn = json.get("splitYn").getAsString();
        
        
    	String today = DateUtil.getDate();
    	
    	SimpleDateFormat dt = new SimpleDateFormat("yyyymmdd");
    	Date date = dt.parse(today); 
    	SimpleDateFormat dt1 = new SimpleDateFormat("yyyy. mm. dd");
    	
        String writer = System.getProperty("user.name");
        String writeTime = dt1.format(date);
        
        
    	JsonObject mth;
    	
    	ArrayList<MethodInfoAttribute> mthList = new ArrayList<MethodInfoAttribute>();
    	MethodInfoAttribute mthInfo;
    	for( int i=0; i<mthJsonArr.size(); i++ ) 
    	{
    		mth = mthJsonArr.get(i).getAsJsonObject();
    		mthInfo = new MethodInfoAttribute();
    		mthInfo.setName(mth.get("mthId").getAsString());
    		mthInfo.setDesc(mth.get("mthNm").getAsString());

    		ClassInfoAttribute dto = new ClassInfoAttribute();
    		ClassInfoAttribute inSvo = new ClassInfoAttribute();
    		ClassInfoAttribute outSvo = new ClassInfoAttribute();
    		
    		if( mth.get("isDto")!=null )
    		{
    			if("Y".equals(mth.get("isDto").getAsString())){
        			dto.setName(getName(mth.get("dtoPathCntn").getAsString(),"."));
        			dto.setPkg(getPath(mth.get("dtoPathCntn").getAsString(),"."));
        			
        			mthInfo.setDtoVar(getVarInfoList(mth.get("dtoInfo").getAsJsonArray()));
    			}
    		}
    		
    		inSvo.setName(getName(mth.get("isvoPathCntn").getAsString(),"."));
    		inSvo.setPkg(getPath(mth.get("isvoPathCntn").getAsString(),"."));
    		
    		outSvo.setName(getName(mth.get("osvoPathCntn").getAsString(),"."));
    		outSvo.setPkg(getPath(mth.get("osvoPathCntn").getAsString(),"."));
    		
    		if(mth.get("isIsvo")!=null) {
    			if("Y".equals(mth.get("isIsvo").getAsString())){
    				mthInfo.setInSvoVar(getVarInfoList(mth.get("isvoInfo").getAsJsonArray()));
    			}
    		}
    		
    		if(mth.get("isOsvo")!=null) {
    			if("Y".equals(mth.get("isOsvo").getAsString())){
    				mthInfo.setOutSvoVar(getVarInfoList(mth.get("osvoInfo").getAsJsonArray()));
    			}
    		}
    		
    		mthInfo.setDto(dto);
    		mthInfo.setInSvo(inSvo);
    		mthInfo.setOutSvo(outSvo);
    		
    		mthList.add(mthInfo);
    	}
        
        
    	String status = "0";
    	try {
            //소스생성순서
            //Mapper(DTO) -> DAO -> SVO -> SVC -> JS -> JSP
            if( isMapper )
            {
                genMapper(json, writer, writeTime, mthList);
                LOGGER.debug("MAPPER 생성완료");
            }
            if( isDao )
            {
                geDAO(json, writer, writeTime, mthList);
                LOGGER.debug("DAO 생성완료");
            }
            if( isSvo )
            {
                genSVO(json, writer, writeTime, mthList);
                LOGGER.debug("SVO 생성완료");
            }
            if( isService )
            {
                genSVC(json, writer, writeTime, mthList);
                LOGGER.debug("Service 생성완료");
            }
            if( isScript )
            {
                genJavaScript(json, writer, writeTime,  mthList);
                LOGGER.debug("Javascript 생성완료");
            }
            if( isScreen )
            {
                genJsp(json, writer, writeTime, mthList, popYn, splitYn);
                LOGGER.debug("JSP 생성완료");
            }
    	}
    	catch(Exception e) {
    	    status = "-1";
    	}
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        JsonObject resjson = new JsonObject();
        
        resjson.addProperty("status", status);
        
        return new ResponseEntity<String>(resjson.toString(), responseHeaders, HttpStatus.OK);
    }

    public String getPath( String fullPath, String split ) {
    	return fullPath.substring(0, fullPath.lastIndexOf(split));
    }

    public String getName( String fullPath, String split ) {
    	return fullPath.substring(fullPath.lastIndexOf(split)+1);
    }
    
    public ArrayList<VariableInfoAttribute> getVarInfoList( JsonArray varJsonArr ) {
    	
		ArrayList<VariableInfoAttribute> varInfoList = new ArrayList<VariableInfoAttribute>();
		VariableInfoAttribute varInfo = null;
		
		for( int i=0; i<varJsonArr.size(); i++ ) 
    	{
			varInfo = new VariableInfoAttribute();
			
			JsonObject dtoJson = varJsonArr.get(i).getAsJsonObject();
			
			String name = dtoJson.get("name").getAsString();
			String type = dtoJson.get("type").getAsString();
			String comment = dtoJson.get("comments")!=null?dtoJson.get("comments").getAsString():"";
			
			if( "ArrayList".equals(type) )
			{
				String generic = dtoJson.get("generic").getAsString();
				type = type + "<" + generic + ">";
			}
			
			varInfo.setName(name);
			varInfo.setType(type);
			varInfo.setUppername(name.substring(0, 1).toUpperCase() + name.substring(1));
			varInfo.setComment(comment);
			
			varInfoList.add(varInfo);
    	}
    	
    	return varInfoList;
    }
    
    
    public void genMapper( JsonObject json, String writer, String writeTime, ArrayList<MethodInfoAttribute> mthList ) {
        
        boolean isDto = json.get("isDto").getAsBoolean();
        
        MapperDescription desc = new MapperDescription();
        
        String mapperId = json.get("mapNm").getAsString();
        String mapperPath = getPath(json.get("mapPath").getAsString(), ".");
        
        ArrayList<QueryInfoAttribute> queryList = new ArrayList<QueryInfoAttribute>();
        QueryInfoAttribute queryInfo = null;
        for( MethodInfoAttribute mthAttr : mthList ) 
        {
            queryInfo = new QueryInfoAttribute();
            queryInfo.setId(mthAttr.getName());
            queryInfo.setDto(mthAttr.getDto());
            queryInfo.setInSvo(mthAttr.getInSvo());
            queryList.add(queryInfo);
            
            
            if( isDto ) 
            {
                if( mthAttr.getDtoVar()!=null && mthAttr.getDtoVar().size()>0 )
                {
                    
                    DTODescription dtoDesc = new DTODescription();
//              dto.setDesc(desc);
                    dtoDesc.setFileNm(mthAttr.getDto().getName());
                    dtoDesc.setFilePath(mthAttr.getDto().getPkg());
                    dtoDesc.setName(mthAttr.getDto().getName());
                    dtoDesc.setPkg(mthAttr.getDto().getPkg());
                    dtoDesc.setWriter(writer);
                    dtoDesc.setWriteTime(writeTime);
                    dtoDesc.setVarList(mthAttr.getDtoVar());
                    sourceGenBean.setGetTemplateGen(dtoDesc);
                }
            }
        }
        
        desc.setWriter(writer);
        desc.setWriteTime(writeTime);
        desc.setName(mapperId);
        desc.setFileNm(mapperId);
        desc.setFilePath(mapperPath);
        desc.setPkg(mapperPath);
        desc.setQueryList(queryList);
        
        sourceGenBean.mapperTemplateGen(desc);
    }
    
    public void geDAO( JsonObject json, String writer, String writeTime, ArrayList<MethodInfoAttribute> mthList ) {
        
        DAODescription desc = new DAODescription();
//      desc.setDesc(desc);
        desc.setFileNm(json.get("daoNm").getAsString());
        desc.setFilePath(getPath(json.get("daoPath").getAsString(),"."));
        desc.setName(json.get("daoNm").getAsString());
        desc.setPkg(getPath(json.get("daoPath").getAsString(),"."));
        desc.setNamespace(json.get("mapNm").getAsString());
        desc.setWriter(writer);
        desc.setWriteTime(writeTime);
        desc.setMethodList(mthList);
        
        sourceGenBean.daoTemplateGen(desc);
    }

    public void genSVO( JsonObject json, String writer, String writeTime, ArrayList<MethodInfoAttribute> mthList ) {
        
        for( MethodInfoAttribute mthAttr : mthList ) 
        {
            if( mthAttr.getInSvoVar()!=null && mthAttr.getInSvoVar().size()>0 )
            {
                
                DTODescription dtoDesc = new DTODescription();
//              dto.setDesc(desc);
                dtoDesc.setFileNm(mthAttr.getInSvo().getName());
                dtoDesc.setFilePath(mthAttr.getInSvo().getPkg());
                dtoDesc.setName(mthAttr.getInSvo().getName());
                dtoDesc.setPkg(mthAttr.getInSvo().getPkg());
                dtoDesc.setWriter(writer);
                dtoDesc.setWriteTime(writeTime);
                dtoDesc.setVarList(mthAttr.getInSvoVar());
                
                sourceGenBean.setGetTemplateGen(dtoDesc);
            }
            if( mthAttr.getOutSvoVar()!=null && mthAttr.getOutSvoVar().size()>0 )
            {
                
                DTODescription dtoDesc = new DTODescription();
//              dto.setDesc(desc);
                dtoDesc.setFileNm(mthAttr.getOutSvo().getName());
                dtoDesc.setFilePath(mthAttr.getOutSvo().getPkg());
                dtoDesc.setName(mthAttr.getOutSvo().getName());
                dtoDesc.setPkg(mthAttr.getOutSvo().getPkg());
                dtoDesc.setWriter(writer);
                dtoDesc.setWriteTime(writeTime);
                dtoDesc.setVarList(mthAttr.getOutSvoVar());
                
                sourceGenBean.setGetTemplateGen(dtoDesc);
            }
        }
    }

    public void genSVC( JsonObject json, String writer, String writeTime, ArrayList<MethodInfoAttribute> mthList ) {
        
        ServiceDescription desc = new ServiceDescription();
        ClassInfoAttribute daoAttr = new ClassInfoAttribute();
        
//        desc.setDesc(desc);
        desc.setFileNm(json.get("svcId").getAsString());
        desc.setFilePath(getPath(json.get("svcPath").getAsString(),"."));
        desc.setName(json.get("svcId").getAsString());
        desc.setPkg(getPath(json.get("svcPath").getAsString(),"."));
        daoAttr.setName(json.get("daoNm").getAsString());
        daoAttr.setPkg(getPath(json.get("daoPath").getAsString(),"."));
        desc.setDao(daoAttr);
        desc.setWriter(writer);
        desc.setWriteTime(writeTime);
        desc.setMethodList(mthList);
        
        sourceGenBean.serviceTemplateGen(desc);
    }
    
    public void genJavaScript( JsonObject json, String writer, String writeTime, ArrayList<MethodInfoAttribute> mthList ) {
        
        JavaScriptDescription desc = new JavaScriptDescription();
        
//      desc.setDesc(desc);
        desc.setFileNm(json.get("jspNm").getAsString());
        desc.setFilePath(getPath(json.get("jspPath").getAsString(),"/").replaceAll("views", "views_script"));
        desc.setName(json.get("jspNm").getAsString());
        desc.setPkg(getPath(json.get("jspPath").getAsString(),"/").replaceAll("views", "views_script"));
        desc.setWriter(writer);
        desc.setWriteTime(writeTime);
        desc.setMethodList(mthList);
        
        sourceGenBean.javaScriptTemplateGen(desc);
    }
    
    public void genJsp( JsonObject json, String writer, String writeTime, ArrayList<MethodInfoAttribute> mthList, String popYn, String splitYn ) {
        
        JspDescription desc = new JspDescription();
        
//      desc.setDesc(desc);
        desc.setFileNm(json.get("jspNm").getAsString());
        desc.setFilePath(getPath(json.get("jspPath").getAsString(),"/"));
        desc.setName(json.get("jspNm").getAsString());
        desc.setPkg(getPath(json.get("jspPath").getAsString(),"/"));
        desc.setWriter(writer);
        desc.setWriteTime(writeTime);
        desc.setSplitYn(splitYn);
        
        sourceGenBean.jspTemplateGen(desc, popYn);
    }
    
    
}
