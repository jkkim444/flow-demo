/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO3010.java
 * @brief 공통코드 관리 service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service
 * @brief Common Service Package
 */
package com.encocns.co.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Resource;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO3010DAO;
import com.encocns.co.dto.CO301001DTO;
import com.encocns.co.dto.CO301002DTO;
import com.encocns.co.service.svo.CO301001IN;
import com.encocns.co.service.svo.CO301001OUT;
import com.encocns.co.service.svo.CO301002IN;
import com.encocns.co.service.svo.CO301002OUT;
import com.encocns.co.service.svo.CO301003IN;
import com.encocns.co.service.svo.CO301003OUT;
import com.encocns.co.service.svo.CO301005IN;
import com.encocns.co.service.svo.CO301005OUT;
import com.encocns.co.service.svo.CO301006IN;
import com.encocns.co.service.svo.CO301006OUT;
import com.encocns.co.service.svo.CO301008IN;
import com.encocns.co.service.svo.CO301008OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.MaxLengthRule;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;

/**
 * @brief 공통코드 관리 service
 * @details 공통코드 관리 service.
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class CO3010 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CO3010.class);

    @Autowired
    private EhCacheCacheManager cacheManager;

    @Autowired
    private ServiceComponent serviceComponent;

    @Value("#{globalContext}")
    protected Properties globalContextProp;

    @Autowired
    private CO3010DAO daoCode;

    @Resource(name = "txManagerIFRS")
    protected DataSourceTransactionManager txManagerIFRS;

    /**
     * @brief 공통코드 도메인 조회
     * @details 공통코드 도메인 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO301001IN
     * @return CO301001OUT
     */
    public CO301001OUT selectCodeDomainList( CO301001IN inParam ) {
        List<CO301001DTO> arrList = daoCode.selectCodeDomainList(inParam);

        CO301001OUT outParam = new CO301001OUT();

        outParam.setArrList(arrList);

        return outParam;
    }

    /**
     * @brief 공통코드 조회
     * @details 공통코드 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO301002IN
     * @return CO301002IN
     */
    public CO301002OUT selectCodeDtlList( CO301002IN inParam ) {
        List<CO301002DTO> arrList = daoCode.selectCodeDtlList(inParam);

        CO301002OUT outParam = new CO301002OUT();

        outParam.setArrList(arrList);

        return outParam;
    }

    /**
     * @brief 공통코드 도메인 등록 및 수정
     * @details 공통코드 도메인 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO301003IN
     * @return CO301003OUT
     * @throws EnfraBusinessException Handling Business Exception
     */
    public CO301003OUT mergeCodeDomain( CO301003IN inParam )
    {
        //Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("cdDmnId", new RequiredRule(true), new MaxLengthRule(30));
        ruleSet.addRule("CdDmnNm", new RequiredRule(true), new MaxLengthRule(60));

        Validator.validation(inParam, ruleSet);

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        daoCode.mergeCodeDomain(inParam);

        CO301003OUT outParam = new CO301003OUT();

        outParam.setiResult(1);

        return outParam;
    }

    /**
     * @brief 공통 코드 도메인 삭제여부 수정
     * @details 공통 코드 도메인 삭제여부 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO301005IN
     * @return CO301005OUT
     */
    public CO301005OUT updateCodeDomainDelYn( CO301005IN inParam )
    {
        int iResult = 0;

        iResult = daoCode.updateCodeDomainDelYn(inParam);
        iResult += daoCode.updateCodeDomainDtlDelYn(inParam);

        CO301005OUT outParam = new CO301005OUT();

        outParam.setiResult(iResult);

        return outParam;
    }


    /**
     * @brief 공통 코드 등록 및 수정
     * @details 공통 코드 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO301006IN
     * @return CO301006OUT
     * @throws Exception
     */
    public CO301006OUT mergeCd( CO301006IN inParam ) throws Exception
    {
        int iResult = 0;

        // 삭제여부 "Y" 처리
        iResult = daoCode.updateCdYn(inParam);



        for( CO301002DTO row : inParam.getArrList() ) {
            row.setUsrId(serviceComponent.getSessionVO().getUserId());
            // 등록 및 수정
            daoCode.mergeCd(row);
            iResult++;
        }

        CO301006OUT outParam = new CO301006OUT();
        outParam.setiResult(iResult);

        CO301008IN inParamCache = new CO301008IN();

        updateCacheRefresh(inParamCache);

        return outParam;
    }

    /**
     * @brief 캐시 갱신
     * @details 캐시 갱신
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     */
    private void clearCache()
    {
        try {
            Cache cache = cacheManager.getCache("commonCodeCache");
            cache.clear();
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    /**
     * @brief 캐시 갱신
     * @details 캐시 갱신
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @throws Exception
     */
    @SuppressWarnings("unused")
    public CO301008OUT updateCacheRefresh(CO301008IN inParam) throws Exception {
        String domainUrl = globalContextProp.getProperty("SERVER_URL");

        //httpPostSender(domainUrl + "/commonCodeRefresh.do", null);

        clearCache();

        CO301008OUT outParam = new CO301008OUT();

        outParam.setiResult(1);

        return outParam;
    }

    /**
     * @brief Call the URL as a parameter and process it for return.
     * @details Call the URL as a parameter and process it for return.
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param callUrl
     * @param param
     * @throws Exception
     */
    @SuppressWarnings("unused")
    private void httpPostSender(String callUrl, Map<String, Object> param) throws Exception {
        URL url = new URL(callUrl);
        URLConnection httpConn = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            if(LOGGER.isInfoEnabled()) LOGGER.info("httpPostSender -> callUrl : {}, param : {}", callUrl, param);

            // HTTPS
            if (url.getProtocol().toLowerCase().equals("https")) {

                trustAllHosts();

                HttpsURLConnection https;
                https = (HttpsURLConnection) url.openConnection();

                // SET hostName Verification
                https.setHostnameVerifier(new HostnameVerifier() {
                    public boolean verify(String hostname, SSLSession session) {
                        // Ignore host name verification. It always returns
                        // true.
                        return true;
                    }
                });

                httpConn = https;
            } else { // HTTP
                httpConn = url.openConnection();
            }

            httpConn.setDoOutput(true);
            httpConn.setUseCaches(false);

            /* Timeout setting */
            /* defaultConnectTimeout sets the timeout for connections to the host and */
            /* defaultReadTimeout sets the timeout when reading the input stream after connection. */
            System.setProperty("sun.net.client.defaultConnectTimeout", "5000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");

            out = new PrintWriter(httpConn.getOutputStream());

            out.print(urlEncoding(param));
            out.flush();

            if(LOGGER.isInfoEnabled()) LOGGER.info("httpPostSender -> Connection Success");

            InputStream is = httpConn.getInputStream();
            in = new BufferedReader(new InputStreamReader(is), 8 * 1024);
            String line = null;
            while ((line = in.readLine()) != null) {
                if(LOGGER.isDebugEnabled()) LOGGER.debug("#####" + line);
            }

        } finally {
            if (out != null) try { out.close(); } catch (Exception e) {
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error(e.getMessage());
                }
            }
            if (in != null) try { in.close(); } catch (Exception e) {
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }

    /**
     * @brief Processing trust all hosts
     * @details Processing SSH trust all hosts
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     */
    private void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }

            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {
            }

            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {
            }

        }};

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            if(LOGGER.isErrorEnabled()) LOGGER.error("error",e);
        }
    }

    /**
     * @brief URL Encoding
     * @details URL Encoding
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param param
     * @return String url encoding result
     */
    private String urlEncoding(Map<String, Object> param) throws Exception {
        if(param == null) return "";

        StringBuffer sb = new StringBuffer();

        sb.append("");

        for(Entry<String, Object> entry:param.entrySet()) {
            if(entry.getKey() != null && entry.getValue() != null) {
                if(sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(entry.getKey(),"UTF-8")).append('=').append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
            }
        }

        return sb.toString();
    }


}
