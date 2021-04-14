package com.encocns.enfra.core.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.encocns.enfra.core.bean.ServiceBeanManager;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.exception.EnfraCoreException;
import com.encocns.enfra.exception.EnfraDownloadException;
import com.encocns.enfra.exception.EnfraNoLoginException;
import com.encocns.enfra.exception.EnfraValidationException;
import com.encocns.enfra.transaction.TransactionVO;
import com.google.gson.JsonObject;

@ControllerAdvice
@EnableWebMvc
public class ServiceExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExceptionHandler.class);

    @Autowired
//    private ServiceBeanManager serviceBeanManager;
    private ObjectProvider<ServiceBeanManager> sbmProvider;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleException(Exception e) {
        e.printStackTrace();
        
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();

        String ext = request.getRequestURI();

        if (ext.endsWith("service") || ext.endsWith(".json") || request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            JsonObject json = new JsonObject();

            if (e.getCause() != null) {
                StringBuilder sbStackTrace = new StringBuilder();
                sbStackTrace.append(e.getCause()).append("\n");
                
                for (StackTraceElement element : e.getCause().getStackTrace()) {
                    sbStackTrace.append(element.toString());
                    sbStackTrace.append("\n");
                }
                
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error(sbStackTrace.toString());
                }

                if (e.getCause().toString().indexOf("Socket read timed out") >= 0
                        || e.getCause().toString().indexOf("Software caused connection abort") >= 0
                        || e.getCause().toString().indexOf("CannotGetJdbcConnectionException") >= 0) {
                    json.addProperty("errorMessage",
                            "<font color='#BC4F51'>Connection failed.\r\nConnection to the server failed because there is no network connected.</font>");
                } else {
                    json.addProperty("errorMessage", "<font color='#BC4F51'>An error occurred while processing the service.</font>");
                }
            } else {
                StringBuilder sbStackTrace = new StringBuilder();
                sbStackTrace.append(e).append("\n");
                
                for (StackTraceElement element : e.getStackTrace()) { 
                    sbStackTrace.append(element.toString());
                    sbStackTrace.append("\n");
                }
                
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error(sbStackTrace.toString());
                }

                json.addProperty("errorMessage", "An error occurred while processing the service..");
            }

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

            return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            JsonObject json = new JsonObject();

            json.addProperty("errorMessage", "An error occurred while processing the service...");

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

            return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(EnfraCoreException.class)
    public @ResponseBody ResponseEntity<String> handleCoreException(EnfraCoreException e) {
        e.printStackTrace();
        
        if (e.getCause() != null) {
            StringBuilder sbStackTrace = new StringBuilder();
            sbStackTrace.append(e.getCause()).append("\n");
            
            for (StackTraceElement element : e.getCause().getStackTrace()) {
                sbStackTrace.append(element.toString());
                sbStackTrace.append("\n");
            }
            
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(sbStackTrace.toString());
            }
        }
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        ServiceBeanManager serviceBeanManager = sbmProvider.getObject();
        
        TransactionVO trsnVo = serviceBeanManager.getTransactionVO();

        // response json
        JsonObject resObj = new JsonObject();

        JsonObject _header = new JsonObject();
        _header.addProperty("svc", trsnVo.getService());
        _header.addProperty("method", trsnVo.getMethod());

        JsonObject _tail = new JsonObject();
        _tail.addProperty("stsCd", -1);
        _tail.addProperty("msgCode", e.getErr_cd());
        _tail.addProperty("rspMsgCntn", e.getMessage());

        resObj.add("header", _header);
        resObj.add("body", new JsonObject());
        resObj.add("tail", _tail);

        return new ResponseEntity<String>(resObj.toString(), responseHeaders, HttpStatus.OK);
    }

    @ExceptionHandler(EnfraBusinessException.class)
    public @ResponseBody ResponseEntity<String> handleEnfraException(EnfraBusinessException e) {
        if (e.getCause() != null) {
            StringBuilder sbStackTrace = new StringBuilder();
            sbStackTrace.append(e.getCause()).append("\n");
            
            for (StackTraceElement element : e.getCause().getStackTrace()) {
                sbStackTrace.append(element.toString());
                sbStackTrace.append("\n");
            }
            
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(sbStackTrace.toString());
            }
        }
        
        HttpHeaders responseHeaders = new HttpHeaders();

        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        ServiceBeanManager serviceBeanManager = sbmProvider.getObject();
        
        TransactionVO trsnVo = serviceBeanManager.getTransactionVO();

        // response json
        JsonObject resObj = new JsonObject();

        JsonObject _header = new JsonObject();
        _header.addProperty("svc", trsnVo.getService());
        _header.addProperty("method", trsnVo.getMethod());

        JsonObject _tail = new JsonObject();
        _tail.addProperty("stsCd", -1);
        _tail.addProperty("msgCode", e.getErr_cd());
        _tail.addProperty("rspMsgCntn", e.getMessage());

        resObj.add("header", _header);
        resObj.add("body", new JsonObject());
        resObj.add("tail", _tail);

        return new ResponseEntity<String>(resObj.toString(), responseHeaders, HttpStatus.OK);
    }

    @ExceptionHandler(EnfraNoLoginException.class)
    public Object noLoginException(EnfraNoLoginException ex, HttpServletRequest request) {
        if (ex.getCause() != null) {
            StringBuilder sbStackTrace = new StringBuilder();
            sbStackTrace.append(ex.getCause().getMessage()).append("\n");
            
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(sbStackTrace.toString());
            }
        }
        
        String ext = request.getRequestURI();
        if (LOGGER.isDebugEnabled())
            LOGGER.debug("ServiceExceptionHandler noLoginException request.getRequestURI() : {}", request.getRequestURI());

        if (ext.endsWith("service") || ext.endsWith(".json") || request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            JsonObject json = new JsonObject();

            json.addProperty("redirectUrl", "/login.do");

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

            return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.NOT_ACCEPTABLE);
        } else {
            if (LOGGER.isDebugEnabled())
                LOGGER.debug("ServiceExceptionHandler noLoginException redirect:/login.do");

            return "redirect:/login.do";
        }
    }

    @ExceptionHandler(EnfraValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object validationHandleException(EnfraValidationException ex, HttpServletRequest request) {
        ex.printStackTrace();
        
        StringBuilder sbStackTrace = new StringBuilder();
        if (ex.getCause() != null) {
            sbStackTrace.append(ex.getCause().getMessage()).append("\n");
            
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(sbStackTrace.toString());
            }
        }
        
        String ext = request.getRequestURI();
        if (LOGGER.isDebugEnabled())
            LOGGER.debug("ServiceExceptionHandler validationException request.getRequestURI() : {}", request.getRequestURI());

        if (ext.endsWith("service") || ext.endsWith(".json") || request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            JsonObject json = new JsonObject();
            json.addProperty("errMsg", ex.getMessage());
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

            return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.BAD_REQUEST);
        } else {
            if (LOGGER.isDebugEnabled())
                LOGGER.debug("ServiceExceptionHandler validationException");

            return "redirect:/errorpage/error400.do";
        }
    }
    
    @ExceptionHandler(EnfraDownloadException.class)
    public void handleDownloadException(EnfraDownloadException e, HttpServletResponse response) {
        LOGGER.error(e.getMessage());
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        
        response.setHeader("Set-Cookie", "fileDownload=false; path=/");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Content-Type", "text/html; charseet=utf-8");
        
        PrintWriter writer;
        try {
            writer = response.getWriter();
            writer.println("<html><head><meta charset=\"utf-8\" /></head><body></body></html>");
            writer.flush();
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
