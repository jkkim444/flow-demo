/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ExcelDownloadController.java
 * @brief Excel Download Controller
 */
/**
 * @namespace com.encocns.enfra.core.service
 * @brief Core Service Package
 */
package com.encocns.enfra.core.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.encocns.enfra.core.annotation.Label;
import com.encocns.enfra.core.bean.ServiceBeanManager;
import com.encocns.enfra.core.component.BeanManager;
import com.encocns.enfra.core.component.ServiceVOConverter;
import com.encocns.enfra.core.session.SessionVO;
import com.encocns.enfra.core.util.JsonUtil;
import com.encocns.enfra.db.dao.CFW_M_TSLT_DAO;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.exception.EnfraCoreException;
import com.encocns.enfra.exception.EnfraMessage;
import com.encocns.enfra.transaction.TransactionVO;
import com.encocns.enfra.util.DateUtil;
import com.google.gson.JsonObject;

/**
 * @brief Excel Download Controller
 * @details Excel Download Controller 이다.
 * @author : joy
 * @date : 2016. 10. 27.
 * @version : 1.0.0
 */
@Controller
public class ExcelDownloadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelDownloadController.class);

	@Autowired
	private BeanManager beanManager;

	@Autowired
//	ServiceBeanManager sbm;
	private ObjectProvider<ServiceBeanManager> sbmProvider;

	@Autowired
	private ServiceVOConverter serviceVOConverter;
	
    @Autowired
    private CFW_M_TSLT_DAO tsltDao;	

    /**
     * @brief Excel Download
     * @details Excel Download Method이다.
     * @author : joy
     * @date : 2016. 10. 27.
     * @param model
     * @return excelDownloadView
     * @throws EnfraBusinessException
     */
	@RequestMapping(value="/excelDownload", method=RequestMethod.POST)
    public String excelDownload( HttpServletRequest request, HttpServletResponse response, HttpSession session
    		, Model model) throws Exception {

	    ServiceBeanManager sbm = sbmProvider.getObject();
	    
    	Object serviceObj = null;
    	Method serviceMethod = null;
    	Object isvo = null;

    	TransactionVO transactionVO = new TransactionVO();

    	try {

    		transactionVO.setService(URLDecoder.decode(request.getParameter("svc"), "UTF-8"));
    		transactionVO.setMethod(URLDecoder.decode(request.getParameter("method"), "UTF-8"));
//    		transactionVO.setParam(URLDecoder.decode(request.getParameter("param"), "UTF-8"));
    		transactionVO.setServiceObj(beanManager.getBean(URLDecoder.decode(request.getParameter("svc"), "UTF-8")));

    		sbm.setTransactionVO(transactionVO);

    		String header = URLDecoder.decode(request.getParameter("header"), "UTF-8");

//    		JSONObject headerjSON = JSONObject.fromObject(header);
    		JsonObject headerjSON = JsonUtil.toJsonObject(header);
//    		String serverDv = headerjSON.getString("serverDv");
//    		String serverDv = headerjSON.get("serverdv").getAsString();

    		SessionVO sessionVO = (SessionVO)session.getAttribute(ServiceConst.SERVICE_CONTEXT_KEY);

    		sessionVO.setServiceTransTime(DateUtil.getDateTime());
//	  		sessionVO.setScrn_id(headerjSON.getString("scrn_id"));
	  		sessionVO.setScrn_id(headerjSON.get("scrn_id").getAsString());


	  		if(LOGGER.isDebugEnabled()) {
		  		LOGGER.debug("/************* Excel Download Controller *****************/");
//		  		LOGGER.debug("SERVER_DV     : " + serverDv);
		  		LOGGER.debug("SCR_ID     : " + transactionVO.getScreenId());
		  		LOGGER.debug("SVC_ID     : " + transactionVO.getService());
		  		LOGGER.debug("MTH_ID     : " + transactionVO.getMethod());
		  		LOGGER.debug("PARAMETERS : " + transactionVO.getParam());
		  		LOGGER.debug(transactionVO.getServiceObj().getClass().getName());
	  		}

//	    	serviceVOConverter.setParam( JSONObject.fromObject( transactionVO.getParam() ) );
	    	serviceVOConverter.setParam( JsonUtil.toJsonObject(transactionVO.getParam()) );
	    	
	    	isvo = serviceVOConverter.createISVO( transactionVO.getIsvoObj() );

	    	//run service
	    	serviceObj = transactionVO.getServiceObj();

	    	serviceMethod = serviceObj.getClass().getMethod( transactionVO.getMethod(), transactionVO.getIsvoCls());

    	} catch( EnfraCoreException e ){
    		if(LOGGER.isErrorEnabled()) LOGGER.error( EnfraMessage.getMessage("E000014") );
    		throw e;
    	}

    	Object osvo = null;

    	try
    	{
    		osvo = serviceMethod.invoke(serviceObj, isvo);

    		if(osvo == null) {
    			throw new Exception();
    		} else {
    			if(osvo instanceof ArrayList) {
    				model.addAttribute("reportList", osvo);
    				model.addAttribute("serviceId", transactionVO.getService());
    			} else {
    				throw new Exception();
    			}
    		}

    	} catch(Exception e) {
    		e.printStackTrace();

    		if( e.getCause() instanceof EnfraBusinessException ) {
    			throw (EnfraBusinessException)e.getCause();
    		}

    		throw e;
    	}

    	return "excelDownloadView";
    }

	/**
	 * @brief CSV Download
	 * @details CSV 파일로 Download 처리한다.
	 * @author : joy
	 * @date : 2017. 1. 24.
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/csvDownload", method=RequestMethod.POST)
    public void csvDownload( HttpServletRequest request, HttpServletResponse response, HttpSession session
    		, Model model) throws Exception {

	    ServiceBeanManager sbm = sbmProvider.getObject();
	    
		String currentDate = DateUtil.getDateTime();
		String HHmmssSS = currentDate.substring(8, 16);

    	Object serviceObj = null;
    	Method serviceMethod = null;
    	Object isvo = null;

    	TransactionVO transactionVO = new TransactionVO();

    	try {
    		transactionVO.setService(URLDecoder.decode(request.getParameter("svc"), "UTF-8"));
    		transactionVO.setMethod(URLDecoder.decode(request.getParameter("method"), "UTF-8"));
//    		transactionVO.setParam(URLDecoder.decode(request.getParameter("param"), "UTF-8"));
    		transactionVO.setServiceObj(beanManager.getBean(URLDecoder.decode(request.getParameter("svc"), "UTF-8")));

    		sbm.setTransactionVO(transactionVO);

    		String header = URLDecoder.decode(request.getParameter("header"), "UTF-8");

//    		JSONObject headerjSON = JSONObject.fromObject(header);

            JsonObject headerjSON = JsonUtil.toJsonObject(header) ;

//    		String serverDv = headerjSON.getString("serverDv");
//    		String serverDv = headerjSON.get("serverdv").getAsString();

    		SessionVO sessionVO = (SessionVO)session.getAttribute(ServiceConst.SERVICE_CONTEXT_KEY);

    		sessionVO.setServiceTransTime(DateUtil.getDateTime());
//	  		sessionVO.setScrn_id(headerjSON.getString("scrn_id"));
    		sessionVO.setScrn_id(headerjSON.get("scrn_id").getAsString());

	  		if(LOGGER.isDebugEnabled()) {
		  		LOGGER.debug("/************* Excel Download Controller *****************/");
//		  		LOGGER.debug("SERVER_DV     : " + serverDv);
		  		LOGGER.debug("SCR_ID     : " + transactionVO.getScreenId());
		  		LOGGER.debug("SVC_ID     : " + transactionVO.getService());
		  		LOGGER.debug("MTH_ID     : " + transactionVO.getMethod());
		  		LOGGER.debug("PARAMETERS : " + transactionVO.getParam());
		  		LOGGER.debug(transactionVO.getServiceObj().getClass().getName());
	  		}
	  		
//	    	serviceVOConverter.setParam( JSONObject.fromObject( transactionVO.getParam() ) );
	    	serviceVOConverter.setParam( JsonUtil.toJsonObject(transactionVO.getParam()) );
	    	isvo = serviceVOConverter.createISVO( transactionVO.getIsvoObj() );

	    	serviceObj = transactionVO.getServiceObj();

	    	serviceMethod = serviceObj.getClass().getMethod( transactionVO.getMethod(), transactionVO.getIsvoCls());

    	} catch( EnfraCoreException e ){
    		LOGGER.error( EnfraMessage.getMessage("E000014") );
    		throw e;
    	}

    	Object osvo = null;

    	try
    	{
    		osvo = serviceMethod.invoke(serviceObj, isvo);

    		if(osvo == null) {
    			throw new Exception();
    		} else {
    			if(osvo instanceof ArrayList) {
    				csvDownload(request, response, (ArrayList)osvo, URLDecoder.decode((request.getParameter("csvfilename")==null?currentDate + HHmmssSS + ".csv":request.getParameter("csvfilename")), "UTF-8"));
    			} else {
    				throw new Exception();
    			}
    		}

    	} catch(Exception e) {
    		e.printStackTrace();

    		if( e.getCause() instanceof EnfraBusinessException ) {
    			throw (EnfraBusinessException)e.getCause();
    		}

    		throw e;
    	}
    }

	/**
	 * @brief CSV 파일 생성
	 * @details 해당 목록을 CSV 파일로 다운로드 처리한다.
	 * @author : joy
	 * @date : 2017. 1. 24.
	 * @param request
	 * @param response
	 * @param list
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void csvDownload(HttpServletRequest request, HttpServletResponse response, ArrayList list, String exportCSVFileName) throws Exception {
	    
        try {
            
            ServiceBeanManager sbm = sbmProvider.getObject();
            
//        	exportCSVFileName = new String(exportCSVFileName.getBytes("KSC5601"), "8859_1");
            response.setContentType("application/octet-stream; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(exportCSVFileName, "UTF-8") + ".csv");
            response.setHeader("Content-Transfer-Encoding", "binary");
            if (request.isSecure()) {
                response.setHeader("Cache-Control", "public");
                response.setHeader("Pragma", "public");
            }

            String EXCEL_COMMA = ",";
            String EXCEL_NEW_LINE = "\n";

            StringBuffer sb = new StringBuffer();

            ArrayList arrayHeaderComments = null;
            ArrayList arrayHeader = null;
            ArrayList dataArray = null;
            
            if( ((HashMap<String, Object>)list.get(0)).containsKey("headerComments") ) {
                arrayHeaderComments = (ArrayList) ((HashMap<String, Object>)list.get(0)).get("headerComments");
            }
            if( ((HashMap<String, Object>)list.get(0)).containsKey("header") ) {
                arrayHeader = (ArrayList) ((HashMap<String, Object>)list.get(0)).get("header");
            }     
            if( ((HashMap<String, Object>)list.get(0)).containsKey("rowList") ) {
                dataArray = (ArrayList) ((HashMap<String, Object>)list.get(0)).get("rowList");
            }              

            if( 0 == dataArray.size() ) {
            	return;
            }

            if( null != arrayHeaderComments ) {
            	for( int i=0; i < arrayHeaderComments.size(); i++ ) {
            		sb.append(String.valueOf(arrayHeaderComments.get(i)));
            		if( i != arrayHeaderComments.size()-1 ) sb.append(EXCEL_COMMA);
            		else sb.append(EXCEL_NEW_LINE);
            	}
            }
            
            // dataType String
            if( dataArray.get(0).getClass().getName().endsWith("String") ) {
                if( null != arrayHeader ) {
                    for( int i=0; i < arrayHeader.size(); i++ ) {
                        sb.append(String.valueOf(arrayHeader.get(i)));
                        if( i != arrayHeader.size()-1 ) sb.append(EXCEL_COMMA);
                    }
                }
                for(Object excelRow :  dataArray) {
                    sb.append(EXCEL_NEW_LINE);
                    sb.append(excelRow.toString());
                }
            }
            // dataType Generic
            else {
                
                boolean flag = true;
                
                for(Object excelRow :  dataArray) {

                    Field[] fields = excelRow.getClass().getDeclaredFields();

                    if( flag ) {
                        for ( int i=0; i < fields.length; i++ ) {
                            
                            if(i > 0) sb.append(EXCEL_COMMA);
                            
                            if( null == fields[i].getAnnotation(Label.class) ) {
                                sb.append("");   
                                continue;
                            }
                            if( null == fields[i].getAnnotation(Label.class).tsltId() ) {
                                sb.append("");   
                                continue;
                            }
                            HashMap mapTemp = new HashMap<String, Object>();
                            mapTemp.put("tsltId", fields[i].getAnnotation(Label.class).tsltId().toString()); 
                            String tslt_ctnt = tsltDao.selTslt(mapTemp);

                            sb.append( null != tslt_ctnt ? tslt_ctnt : "");   
                        }
                        flag = false;
                    }

                    sb.append(EXCEL_NEW_LINE);
                    
                    for ( int i=0; i < fields.length; i++ ) {
                        String filedName = fields[i].getName();
                        if(filedName.substring(0,  1).matches("[a-z]+") &&
                                filedName.substring(1,  2).matches("[A-Z]+")
                                ) {
                            filedName = "get"+filedName;
                        } else {
                            filedName = "get"+StringUtils.capitalize(filedName);
                        }

                        Method getMethod = excelRow.getClass().getMethod(filedName, null);

                        if(i > 0) sb.append(EXCEL_COMMA);
                        String strResult = String.valueOf(getMethod.invoke(excelRow, null));
                        sb.append( "null" == strResult ? "" : strResult );
                    }
                }
            }

            ServletOutputStream out = response.getOutputStream() ;
            out.write(sb.toString().getBytes("EUC-KR")) ;
            out.flush() ;
            out.close() ;
        } catch(Exception e) {
        	e.printStackTrace();
        	throw e;
        }
	}

}
