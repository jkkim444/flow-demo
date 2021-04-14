/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file EnfraJUnit.java
 * @brief JUnit Tester
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 7. 15. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.junit
 * @brief JUnit package
 */
package com.encocns.junit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.Date;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.encocns.enfra.core.service.ServiceConst;
import com.encocns.enfra.core.session.SessionVO;
import com.encocns.enfra.core.util.JsonUtil;

/**
 * @brief JUnit Tester
 * @details JUnit Tester 
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 7. 15.
 * @version : 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:test/src/spring/appServlet/servlet-context.xml", 
        "file:test/src/spring/context/context-common.xml",
        "file:test/src/spring/context/context-datasource.xml",
        "file:test/src/spring/context/context-mybatis.xml",
        "file:test/src/spring/context/context-locale.xml",
        "file:WebContent/WEB-INF/spring/context/context-transaction.xml",
        "file:WebContent/WEB-INF/spring/context/context-views.xml"
        })
@ActiveProfiles("local")
public abstract class EnfraJUnit {

    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;
    
    private String svc;
    private String method;
    private String scrId;
    
    private MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    
    private MockHttpSession mockHttpSession = null;
    
    @Before
    public void setConfiguration() throws Exception {
        MockitoAnnotations.initMocks(this);
        
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    /**
     * @brief get session
     * @details get session 
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 7. 15.
     * @version : 1.0.0
     * @return MockHttpSession
     */
    private MockHttpSession getSession() {
        if(mockHttpSession == null) {
            mockHttpSession = new MockHttpSession();
            SessionVO sessionVO = new SessionVO();
            sessionVO.setUserId("9999");
            sessionVO.setUserName("Administrator");
            sessionVO.setBranchCode("1111");
            sessionVO.setBranchName("2222");
            sessionVO.setLoginDate(new DateFormatter("yyyyMMdd").print(new Date(), LocaleContextHolder.getLocale()));
            sessionVO.setLoginTime(new DateFormatter("HHmmss").print(new Date(), LocaleContextHolder.getLocale()));
            sessionVO.setSso(false);
            
            mockHttpSession.setAttribute(ServiceConst.SERVICE_CONTEXT_KEY, sessionVO);
        }
        
        return mockHttpSession;
    }
    
    /**
     * @param SessionVO the SessionVO to set
     */
    public void setSession(SessionVO sessionVO) {
        mockHttpSession = new MockHttpSession();
        
        mockHttpSession.setAttribute(ServiceConst.SERVICE_CONTEXT_KEY, sessionVO);
    }
    
    /**
     * @brief mockMvc do and expect
     * @details mockMvc do and expect
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 7. 15.
     * @version : 1.0.0
     * @throws Exception
     */
    public void test() throws Exception {
        try {
            mockMvc.perform(post(new URI("/service")).session(getSession()).params(params).contentType(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk());
        } catch(Exception e) {
            throw e;
        }
    }

    /**
     * @return the wac
     */
    public WebApplicationContext getWac() {
        return wac;
    }

    /**
     * @param wac the wac to set
     */
    public void setWac(WebApplicationContext wac) {
        this.wac = wac;
    }

    /**
     * @return the mockMvc
     */
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    /**
     * @param mockMvc the mockMvc to set
     */
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    /**
     * @return the svc
     */
    public String getSvc() {
        return svc;
    }

    /**
     * @param svc the svc to set
     */
    public void setSvc(String svc) {
        this.svc = svc;
    }

    /**
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return the scrId
     */
    public String getScrId() {
        return scrId;
    }

    /**
     * @param scrId the scrId to set
     */
    public void setScrId(String scrId) {
        this.scrId = scrId;
    }

    /**
     * @param parameter the parameter to set
     */
    public void setParameter(Object parameter) {
        params.add("header", "{scrId:\"" + getScrId() + "\"}");
        params.add("svc", getSvc());
        params.add("method", getMethod());
        params.add("param", JsonUtil.toJsonObject(parameter).toString());
    }
    
}
