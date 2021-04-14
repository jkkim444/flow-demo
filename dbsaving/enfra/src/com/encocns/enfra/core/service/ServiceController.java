package com.encocns.enfra.core.service;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encocns.enfra.core.bean.ServiceBeanManager;
import com.encocns.enfra.core.component.ServiceVOConverter;
import com.encocns.enfra.core.service.handler.ControllerHandler;
import com.encocns.enfra.core.service.handler.ExcelDownloadHandler;
import com.encocns.enfra.core.service.view.ExcelFileDownloadView;
import com.encocns.enfra.core.util.JsonUtil;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.exception.EnfraCoreException;
import com.encocns.enfra.exception.EnfraMessage;
import com.encocns.enfra.exception.EnfraValidationException;
import com.encocns.enfra.transaction.TransactionConst;
import com.encocns.enfra.transaction.TransactionVO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class ServiceController extends ExcelFileDownloadView {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceController.class);

	@Autowired
	private ObjectProvider<ServiceBeanManager> sbmProvider;

	@Autowired
	private ServiceVOConverter serviceVOConverter;

	@RequestMapping(value = "/service" , method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> callService( @RequestBody Map<String, Object> reqMap,
	        HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

		ServiceBeanManager serviceBeanManager = sbmProvider.getObject();

    	TransactionVO transactionVO = serviceBeanManager.getTransactionVO();

    	try
    	{
    		serviceBeanManager.isTransactionService(transactionVO);
    	}
    	catch( EnfraCoreException e )
    	{
    		if(LOGGER.isErrorEnabled()) LOGGER.error( EnfraMessage.getMessage("E000014") );
    		throw e;
    	}

    	if(LOGGER.isDebugEnabled()) {
	    	LOGGER.debug("/************* Service Controller *****************/");
	    	LOGGER.debug("SCR_ID     : " + transactionVO.getScreenId());
	    	LOGGER.debug("SVC_ID     : " + transactionVO.getService());
	    	LOGGER.debug("MTH_ID     : " + transactionVO.getMethod());
//	    	LOGGER.debug("PARAMETERS : " + transactionVO.getParam());
	    	LOGGER.debug(transactionVO.getServiceObj().getClass().getName());
    	}

		// Create ISVO
		serviceVOConverter.setParam( transactionVO.getParamJson() );

    	Object isvo = serviceVOConverter.createISVO( transactionVO.getIsvoObj() );

    	// Run Service!
    	Object serviceObj = transactionVO.getServiceObj();
    	Method serviceMethod = serviceObj.getClass().getMethod( transactionVO.getMethod(), transactionVO.getIsvoCls());
    	Object osvo = null;

    	try
    	{
            //defined controller handler initializer
            if( serviceObj instanceof ControllerHandler ) {
                ControllerHandler handler = (ControllerHandler)serviceObj;
                handler.init();
            }

    		osvo = serviceMethod.invoke(serviceObj, isvo);
    		JsonObject header = transactionVO.getHeaderJson();
    		if(header.has("excel")) {
    		    if(header.get("excel").getAsBoolean()) {
    		          //defined controller handler
    	            if( serviceObj instanceof ExcelDownloadHandler ) {
    	                ExcelDownloadHandler excelHandler = (ExcelDownloadHandler)serviceObj;

    	                if(excelHandler.getFileName()!=null) {
    	                    super.excelInit(excelHandler.getFileName(), excelHandler.getReportName(), excelHandler.getSheetList(), request, response);
    	                }
    	                else {
    	                    super.excelInit(excelHandler.getReportName(), excelHandler.getSheetList(), request, response);
    	                }
    	                // 20200423 엑셀다운로드(커스텀)
    	                if(header.has("custom") && header.get("custom").getAsBoolean())
    	                	super.customExcelDownload();
    	                else
    	                	super.excelDownload();
    	            }
    		    }
    		}

    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();

            if( e.getCause() instanceof EnfraCoreException )
            {
                throw (EnfraCoreException)e.getCause();
            }

    		if( e.getCause() instanceof EnfraBusinessException )
    		{
    			throw (EnfraBusinessException)e.getCause();
    		}

            if( e.getCause() instanceof EnfraValidationException )
            {
                throw (EnfraValidationException)e.getCause();
            }

    		throw e;
    	}

    	JsonObject osvojson = serviceVOConverter.createOSVO(osvo);

    	request.setAttribute(TransactionConst.RSP_BODY_KEY, osvojson);

    	// Response Create
    	JsonObject _response = new JsonObject();

    	JsonObject _header = new JsonObject();
        _header.addProperty("svc", transactionVO.getService());
        _header.addProperty("method", transactionVO.getMethod());

    	JsonObject _tail = new JsonObject();
    	_tail.addProperty("stsCd", "0");
    	_tail.addProperty("msgCode", "I000001");
    	_tail.addProperty("rspMsgCntn", EnfraMessage.getMessage("I000001"));

    	_response.add("header", _header);
    	_response.add("body", osvojson);
    	_response.add("tail", _tail);

//    	if(LOGGER.isDebugEnabled()) LOGGER.debug(_response.toString());

		return new ResponseEntity<String>(_response.toString(), responseHeaders, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/service" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getCallService( HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

		ServiceBeanManager serviceBeanManager = sbmProvider.getObject();

    	TransactionVO transactionVO = serviceBeanManager.getTransactionVO();

    	//JSONObject header = JSONObject.fromObject(request.getParameter("header"));

    	try
    	{
    		serviceBeanManager.isTransactionService(transactionVO);
    	}
    	catch( EnfraCoreException e )
    	{
    		if(LOGGER.isErrorEnabled()) LOGGER.error( EnfraMessage.getMessage("E000014") );
    		throw e;
    	}

    	if(LOGGER.isDebugEnabled()) {
	    	LOGGER.debug("/************* Service Controller *****************/");
	    	LOGGER.debug("SVC_ID     : " + transactionVO.getService());
	    	LOGGER.debug("MTH_ID     : " + transactionVO.getMethod());
	    	LOGGER.debug("PARAMETERS : " + transactionVO.getParam());
	    	LOGGER.debug(transactionVO.getServiceObj().getClass().getName());
    	}

    	// Create ISVO
//    	serviceVOConverter.setParam( JSONObject.fromObject( transactionVO.getParam() ) );
    	serviceVOConverter.setParam( JsonUtil.toJsonObject(transactionVO.getParam()) );
    	Object isvo = serviceVOConverter.createISVO( transactionVO.getIsvoObj() );

    	// Run Service!
    	Object serviceObj = transactionVO.getServiceObj();
    	Method serviceMethod = serviceObj.getClass().getMethod( transactionVO.getMethod(), transactionVO.getIsvoCls());

    	Object osvo = null;

    	try
    	{
    		osvo = serviceMethod.invoke(serviceObj, isvo);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();

    		if( e.getCause() instanceof EnfraBusinessException )
    		{
    			throw (EnfraBusinessException)e.getCause();
    		}

    		if( e.getCause() instanceof EnfraValidationException )
    		{
    		    throw (EnfraValidationException)e.getCause();
    		}

    		throw e;
    	}

    	JsonObject osvojson = serviceVOConverter.createOSVO(osvo);

		Set entrySetBody = osvojson.entrySet();
	    Iterator iterator = entrySetBody.iterator();
	    boolean isFirst = true;
	    String sList = "{}";

	    while (iterator.hasNext()) {
	    	Map.Entry entry = (Map.Entry) iterator.next();
	    	if(isFirst) {
	    		JsonArray arrList = (JsonArray)entry.getValue();
	    		sList = arrList.toString();
	    		isFirst = false;
	    	}
	    }

		return new ResponseEntity<String>(sList.toString(), responseHeaders, HttpStatus.OK);
	}
}
