/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file BeanAspect.java
 * @brief Bean Aspect
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2017. 2. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.aop
 * @brief Common AOP Package
 */
package aop;

import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @brief Bean Aspect
 * @details Class for AOP processing
 * @author : CHOI, YOUNG-HWAN
 * @date : 2017. 2. 24.
 * @version : 1.0.0
 */
@Aspect
public class BeanAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanAspect.class);

    public BeanAspect ()
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug(" BeanAspect Constructor ");
    }

    /**
     * @brief Pointcut declaration for all methods in BeanController
     * @details Pointcut declaration for all methods in BeanController
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     */
//    @Pointcut("execution(* *(..))")
    @Pointcut("execution(* document.*.*(..))")
    public void callDocumentBean(  )
    {
    }

    /**
     * @brief Bean call pre-processing
     * @details Bean call pre-processing
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     * @param joinPoint
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Before("callDocumentBean()")
    public void documentBeanBefore( JoinPoint joinPoint ) throws Exception
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("BeanAspect > BeanBefore");
        
//        LOGGER.debug(joinPoint.getClass().getName());
        LOGGER.debug(joinPoint.getTarget().getClass().getName());
//        LOGGER.debug(joinPoint.getSignature().getde);
        
        String className = joinPoint.getTarget().getClass().getName();
        String fileName = className.substring(className.lastIndexOf(".")+1);
        
        
        String sGUID = UUID.randomUUID().toString().replace("-", "");
        MDC.put("GUID", "["+sGUID+"] ");
        MDC.put("fileName", fileName);

    }

    /**
     * @brief Bean Call post-processing
     * @details Bean Call post-processing
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     */
    @After("callDocumentBean()")
    public void documentBeanAfter()
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("BeanAspect > BeanAfter");
    }

    /**
     * @brief Save error log in case of BeanController Exception
     * @details Save error log in case of BeanController Exception
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     * @param ex
     * @throws Exception
     */
    @AfterThrowing(pointcut = "execution(* document.*.*(..))", throwing = "ex")
    public void BeanException(Exception ex) throws Exception {
    	
        if(LOGGER.isDebugEnabled()) LOGGER.debug("BeanAspect > BeanException");

        StringBuffer sbStackTrace = new StringBuffer();

        if(ex.getMessage() != null) {
            for (StackTraceElement element : ex.getStackTrace()) {
                sbStackTrace.append(element.toString());
                sbStackTrace.append("\n");
            }

        } else {
            if(ex.getCause() != null) {
                for (StackTraceElement element : ex.getCause().getStackTrace()) {
                    sbStackTrace.append(element.toString());
                    sbStackTrace.append("\n");
                }
            } else {
                for (StackTraceElement element : ex.getStackTrace()) {
                    sbStackTrace.append(element.toString());
                    sbStackTrace.append("\n");
                }
            }
        }

        LOGGER.error(sbStackTrace.toString());
        
    }

    /**
     * @brief Declare around
     * @details Declare around
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     * @param joinPoint
     * @return Object JoinPoint Proceed
     * @throws Throwable
     */
    @Around("callDocumentBean()")
    public Object documentBeanAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceedResult = joinPoint.proceed();
        return proceedResult;
    }

}
