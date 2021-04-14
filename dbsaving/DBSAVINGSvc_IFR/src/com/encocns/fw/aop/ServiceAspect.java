/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ServiceAspect.java
 * @brief Service Aspect
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2017. 2. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.aop
 * @brief Common AOP Package
 */
package com.encocns.fw.aop;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.encocns.enfra.core.bean.ServiceBeanManager;
import com.encocns.enfra.core.component.BeanManager;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.service.ServiceConst;
import com.encocns.enfra.core.session.SessionVO;
import com.encocns.enfra.core.util.JsonUtil;
import com.encocns.enfra.db.dao.CFW_M_SVC_DAO;
import com.encocns.enfra.db.dvo.CFW_LOG_DVO;
import com.encocns.enfra.exception.EnfraMessage;
import com.encocns.enfra.transaction.TransactionVO;
import com.google.gson.JsonObject;

/**
 * @brief Service Aspect
 * @details Class for AOP processing
 * @author : CHOI, YOUNG-HWAN
 * @date : 2017. 2. 24.
 * @version : 1.0.0
 */
@Aspect
public class ServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);

    @Resource(name = "txManagerCore")
    protected DataSourceTransactionManager txManagerCore;

    public ServiceAspect ()
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug(" ServiceAspect Constructor ");
    }

    @Autowired
    private BeanManager beanManager;

    @Autowired
    HttpServletRequest request;

    @Autowired
    ServiceComponent serviceComponent;

    @Autowired
    private ObjectProvider<ServiceBeanManager> sbmProvider;

    @Autowired
    private CFW_M_SVC_DAO daoCFWMSVC;


    /**
     * @brief Pointcut declaration for all methods in ServiceController
     * @details Pointcut declaration for all methods in ServiceController
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     */
    @Pointcut("execution(* com.encocns.enfra.core.service.ServiceController.*(..))")
    public void callService(  )
    {
    }

    /**
     * @brief Service call pre-processing
     * @details Service call pre-processing
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     * @param joinPoint
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Before("callService()")
    public void serviceBefore( JoinPoint joinPoint ) throws Exception
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("ServiceAspect > ServiceBefore");

        JsonObject paramJson = new JsonObject();
        String sGUID = UUID.randomUUID().toString().replace("-", "");
        // 20200420 주석처리
//        paramJson.addProperty("GUID", sGUID);

        Object reqArg = joinPoint.getArgs()[0];
        Map<String,Object> reqMap = (Map<String,Object>)reqArg;

        MDC.put("GUID", "["+sGUID+"]");
        MDC.put("fileName", String.valueOf(reqMap.get("svc")));

        String currentDate = new DateFormatter("yyyyMMddHHmmssSS").print(new Date(), LocaleContextHolder.getLocale());
        String txStrtTime = currentDate.substring(8, 16);

        HttpSession hs = request.getSession();

        ServiceBeanManager serviceBeanManager = sbmProvider.getObject();

        TransactionVO transactionVO = new TransactionVO();

        serviceBeanManager.setTransactionVO(transactionVO);

        try
        {
            JsonObject headerjSON = JsonUtil.toJsonObject(reqMap.get("header"));

            transactionVO.setHeaderJson(headerjSON);
            transactionVO.setTxStrtTime(txStrtTime);
            transactionVO.setScreenId(headerjSON.get("scrId").getAsString());
            transactionVO.setService(String.valueOf(reqMap.get("svc")));
            transactionVO.setMethod(String.valueOf(reqMap.get("method")));
            transactionVO.setParam((Map<String,Object>)reqMap.get("param"));

            //20200420 127번째 줄 GUID만 들어가서 수정//////////////////////////
            paramJson = transactionVO.getParamJson();
            paramJson.addProperty("GUID", sGUID);
            /////////////////////////////////////////////////

            transactionVO.setParamJson(paramJson);
            transactionVO.setServiceObj(beanManager.getBean(String.valueOf(reqMap.get("svc"))));

            serviceBeanManager.setTransactionVO(transactionVO);

            SessionVO sessionVO = (SessionVO)hs.getAttribute(ServiceConst.SERVICE_CONTEXT_KEY);

            //@@@ 통테용
            if( sessionVO==null && "CO1011".equals(headerjSON.get("scrId").getAsString())) {

                // Create Session
                hs = request.getSession(true);
                sessionVO = new SessionVO();
                sessionVO.setScrn_id(headerjSON.get("scrId").getAsString());
                sessionVO.setServiceTransTime(new DateFormatter("YYYYMMddHHmmss").print(new Date(), LocaleContextHolder.getLocale()));

                hs.setAttribute(ServiceConst.SERVICE_CONTEXT_KEY, sessionVO);
            }
            else {
                sessionVO.setScrn_id(headerjSON.get("scrId").getAsString());
                sessionVO.setServiceTransTime(new DateFormatter("YYYYMMddHHmmss").print(new Date(), LocaleContextHolder.getLocale()));
            }

        }
        catch(Exception e)
        {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            insertErrServiceTransaction(transactionVO, e);

            throw e;
        }
    }

    /**
     * @brief Service Call post-processing
     * @details Service Call post-processing
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     */
    @After("callService()")
    public void serviceAfter()
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("ServiceAspect > ServiceAfter");
    }

    /**
     * @brief Save error log in case of ServiceController Exception
     * @details Save error log in case of ServiceController Exception
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     * @param ex
     * @throws Exception
     */
    @AfterThrowing(pointcut = "execution(* com.encocns.enfra.core.service.ServiceController.*(..))", throwing = "ex")
    public void serviceException(Exception ex) throws Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("ServiceAspect > ServiceException");

        ServiceBeanManager serviceBeanManager = sbmProvider.getObject();

        insertErrServiceTransaction(serviceBeanManager.getTransactionVO(), ex);
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
    @Around("callService()")
    public Object serviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceedResult = joinPoint.proceed();

        ServiceBeanManager serviceBeanManager = sbmProvider.getObject();

        insertServiceTransaction(serviceBeanManager.getTransactionVO());

        return proceedResult;
    }

    /**
     * @brief Declare pointcut index
     * @details Declare pointcut index
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     */
    @Pointcut("execution(* com.encocns.fw.controller..*(..)) || execution(* com.encocns.enfra.core.service.FileServiceController.*(..)) ")
    public void callController()
    {
    	System.out.println("callController");
    }

    @Before("callController()")
    public void controllerBefore( JoinPoint joinPoint ) throws Exception
    {
        String className = joinPoint.getSignature().getDeclaringType().getName();
        MDC.put("fileName", className.substring(className.lastIndexOf(".")+1));
    }

    /**
     * @brief Service Call post-processing
     * @details Service Call post-processing
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     */
    @After("callController()")
    public void controllerAfter()
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("ServiceAspect > controllerAfter");
    }

    /**
     * @brief Save error log in case of ServiceController Exception
     * @details Save error log in case of ServiceController Exception
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     * @param ex
     * @throws Exception
     */
    @AfterThrowing(pointcut = "execution(* com.encocns.fw.controller..*(..)) || execution(* com.encocns.enfra.core.service.FileServiceController.*(..))  ", throwing = "ex")
    public void controllerException(Exception ex) throws Exception {

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
     * @brief Save logs on success transaction processing
     * @details Save logs on success transaction processing
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     * @param transactionVO
     */
    public void insertServiceTransaction( TransactionVO transactionVO )
    {
        try
        {
            insLogDVO(transactionVO, true, "");
        }
        catch( Exception e )
        {
            if(LOGGER.isErrorEnabled()) LOGGER.error( EnfraMessage.getMessage("CE0006", new String[]{e.getMessage()}) );
        }
    }

    /**
     * @brief Save logs on error transaction processing
     * @details Save logs on error transaction processing
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     * @param transactionVO
     * @param ex
     * @throws Exception
     */
    public void insertErrServiceTransaction( TransactionVO transactionVO, Exception ex ) throws Exception
    {
        try
        {
            StringBuilder sbStackTrace = new StringBuilder();
            String sElement = "";

            if(ex.getCause() != null) {
                sbStackTrace.append(ex.getCause());
                sbStackTrace.append('\n');

                for (StackTraceElement element : ex.getCause().getStackTrace()) {
                    sElement = element.toString();
                    sbStackTrace.append(sElement);
                    sbStackTrace.append('\n');
                    sElement = "";
                }
            } else {
                sbStackTrace.append(ex);
                sbStackTrace.append('\n');

                for (StackTraceElement element : ex.getStackTrace()) {
                    sElement = element.toString();
                    sbStackTrace.append(sElement);
                    sbStackTrace.append('\n');
                    sElement = "";
                }
            }

            insLogDVO(transactionVO, false, sbStackTrace.toString());
        }
        catch( Exception e )
        {
            if(LOGGER.isErrorEnabled()) LOGGER.error( EnfraMessage.getMessage("CE0006", new String[]{e.getMessage()}) );

            throw e;
        }
    }

    /**
     * @brief Save logs on transaction processing
     * @details Save logs on transaction processing
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 11. 29.
     * @param transactionVO
     * @param logKindDvcd
     * @param errLoctCtnt
     */
    private void insLogDVO(TransactionVO transactionVO, boolean logKindDvcd, String errLoctCtnt) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus txStatus = txManagerCore.getTransaction(def);

        try {
            CFW_LOG_DVO dvoLog = new CFW_LOG_DVO();

            String sErrLoctCtnt = errLoctCtnt;

            String currentDate = new DateFormatter("yyyyMMddHHmmssSS").print(new Date(), LocaleContextHolder.getLocale());
            String dd = currentDate.substring(6, 8);
            String ymd = currentDate.substring(0, 8);
            String hhmmssSS = currentDate.substring(8, 16);

            int logSeq = daoCFWMSVC.selLogSeq();

//            String sLogSeq = StringUtils.leftPad(String.valueOf(logSeq), 8, "0");

            dvoLog.setTx_dd(dd);
            dvoLog.setLog_dt(ymd);
            dvoLog.setLog_seqno(logSeq);

            //N:Success, E:error
            if(logKindDvcd) {
                dvoLog.setLog_kind_dvcd("N");
            } else {
                dvoLog.setLog_kind_dvcd("E");
            }

            int empno = serviceComponent.getSessionVO().getEmpno();

            //GUID : Date (8) + Professional generation time (8) + dept code (8) + userod (8) + Serial number (8)
//            String guid = ymd + hhmmssSS + serviceComponent.getSessionVO().getDeptCd() + userId + sLogSeq;

            dvoLog.setGuid(transactionVO.getParamJson().get("GUID").getAsString());
            dvoLog.setSeqno(1);
            dvoLog.setFrst_trnm_ipad(getClientIpAddr(request));
            dvoLog.setScr_exe_info(transactionVO.getScreenId());
            dvoLog.setPgm_exe_info(transactionVO.getService());

            //PGM_EXE_SUB_INFO : Method | SessionID | Staff number (6)
            String sessionId = "";

            if(request.getSession() != null) {
                sessionId = request.getSession().getId();
            }

            dvoLog.setPgm_exe_sub_info(transactionVO.getMethod() + "|" + sessionId + "|" + empno);


            String bzwkSysCd = transactionVO.getService().substring(0, 2);

            dvoLog.setBzwk_sys_cd(bzwkSysCd);
            dvoLog.setChnl_tycd("U");

            String txDeptCd = serviceComponent.getSessionVO().getDeptCd();

            txDeptCd = txDeptCd==null?"00000000":txDeptCd;

            dvoLog.setTx_dept_cd(txDeptCd);
            dvoLog.setEmpno(empno);
            dvoLog.setTx_strt_time(transactionVO.getTxStrtTime());
            dvoLog.setTx_end_time(hhmmssSS);

            if(logKindDvcd) {
                dvoLog.setOutput_msg_cd("I000001");
            } else {
                dvoLog.setOutput_msg_cd("E000001");
            }

            //Error information when an error occurs
            if(!logKindDvcd) {
                if("".equals(sErrLoctCtnt)) sErrLoctCtnt = " ";
                dvoLog.setErr_loct_ctnt(strCut(sErrLoctCtnt,  200));
            } else {
                sErrLoctCtnt = " ";
                dvoLog.setErr_loct_ctnt(sErrLoctCtnt);
            }

            if(transactionVO.getParam() != null) {
            	dvoLog.setBod_data_ctnt(strCut(JsonUtil.toJsonObject(transactionVO.getParam()).toString(), 200));
            } else {dvoLog.setBod_data_ctnt(" ");}


            //transaction history storage processing
            daoCFWMSVC.insLog(dvoLog);

            txManagerCore.commit(txStatus);
        } catch(Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
            txManagerCore.rollback(txStatus);
        }
    }

    /**
     * @brief Returns IP Address.
     * @details Returns IP Address.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 11. 29.
     * @param request
     * @return String Client IP Address
     */
    private static String getClientIpAddr(HttpServletRequest request) {
        String ip = "";
        try {
            ip = request.getHeader("X-Forwarded-For");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } catch (Exception e) {
            ip = "0.0.0.0";
        }
        return ip;
    }

    /**
     * @brief
     * \~english Calculate the string byte and return the Cut result
     * \~korean Calculate the string byte and return the Cut result
     * @details
     * <pre>
     * \~english Calculate the string byte and return the Cut result
     * \~korean Calculate the string byte and return the Cut result
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016 11. 29.
     * @param szText text size
     * @param nLength Cut Size
     * @return String cut result text
     */
    private String strCut(String szText, int nLength) {
        if(szText == null) return "";

        if(!szText.isEmpty()) {
            if(szText.getBytes(StandardCharsets.UTF_8).length<=nLength) {
                return szText;
            } else {
                StringBuilder sb = new StringBuilder();
                int nCnt = 0;

                for(char ch:szText.toCharArray()) {
                    nCnt += String.valueOf(ch).getBytes(StandardCharsets.UTF_8).length;

                    if(nCnt > nLength) break;

                    sb.append(ch);
                }

                return sb.toString();
            }
        } else {
            return "";
        }
    }

    /**
     * @brief
     * \~english Pointcut declaration for all methods in LoginController
     * \~korean Pointcut declaration for all methods in LoginController
     * @details
     * <pre>
     * \~english Pointcut declaration for all methods in LoginController
     * \~korean Pointcut declaration for all methods in LoginController
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2017. 2. 24.
     */

    @Pointcut("execution(* com.encocns.fw.controller.LoginController.procLogin(..))")
    public void callLogin(  )
    {
    }

    /**
     * @brief
     * \~english Login call pre-processing
     * \~korean Login call pre-processing
     * @details
     * <pre>
     * \~english Login call pre-processing
     * \~korean Login call pre-processing
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2020. 3. 25.
     * @param joinPoint
     * @throws Exception
     */
    @Before("callLogin()")
    public void loginBefore( JoinPoint joinPoint ) throws Exception
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("ServiceAspect > LoginBefore");

        JsonObject paramJson = new JsonObject();
        String sGUID = UUID.randomUUID().toString().replace("-", "");
        paramJson.addProperty("GUID", sGUID);

        String currentDate = new DateFormatter("yyyyMMddHHmmssSS").print(new Date(), LocaleContextHolder.getLocale());

        ServiceBeanManager serviceBeanManager = sbmProvider.getObject();

        TransactionVO transactionVO = new TransactionVO();
        transactionVO.setTxStrtTime(currentDate.substring(8, 16));
        transactionVO.setScreenId("UIFCA000001");
        transactionVO.setService("CO0001");
        transactionVO.setMethod(request.getRequestURI());
        transactionVO.setParamJson(paramJson);
        serviceBeanManager.setTransactionVO(transactionVO);
    }

    /**
     * @brief
     * \~english Login Call post-processing
     * \~korean Login Call post-processing
     * @details
     * <pre>
     * \~english Login Call post-processing
     * \~korean Login Call post-processing
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2020. 3. 25.
     */
    @After("callLogin()")
    public void loginAfter()
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("ServiceAspect > LoginAfter");
    }

    /**
     * @brief
     * \~english Save error log in case of LoginController Exception
     * \~korean Save error log in case of LoginController Exception
     * @details
     * <pre>
     * \~english Save error log in case of LoginController Exception
     * \~korean Save error log in case of LoginController Exception
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2020. 3. 25.
     * @param ex
     * @throws Exception
     */
    @AfterThrowing(pointcut = "execution(* com.encocns.fw.controller.LoginController.procLogin(..))", throwing = "ex")
    public void loginException(Exception ex) throws Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("ServiceAspect > LoginException");

        ServiceBeanManager serviceBeanManager = sbmProvider.getObject();

        insertErrServiceTransaction(serviceBeanManager.getTransactionVO(), ex);
    }

    /**
     * @brief
     * \~english Declare around
     * \~korean Declare around
     * @details
     * <pre>
     * \~english Declare around
     * \~korean Declare around
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2020. 3. 25.
     * @param joinPoint
     * @return Object JoinPoint Proceed
     * @throws Throwable
     */
    @Around("callLogin()")
    public Object loginAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceedResult = joinPoint.proceed();

        ServiceBeanManager serviceBeanManager = sbmProvider.getObject();

        insertServiceTransaction(serviceBeanManager.getTransactionVO());

        return proceedResult;
    }

}
