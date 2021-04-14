/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO0001.java
 * @brief Login Service
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 8. 1. | First Created
 * </pre>
 */
/**
 * @namespace tw.linebank.ifrs.common.service
 * @brief Common Service Package
 */
package com.encocns.co.service;

import java.util.ArrayList;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO0001DAO;
import com.encocns.co.dto.CO000101DTO;
import com.encocns.co.service.svo.CO000101IN;
import com.encocns.co.service.svo.CO000101OUT;
import com.encocns.co.service.svo.CO000102OUT;

/**
 * @brief Login Service
 * @details
 * <pre>
 * Look up user information with the login service.
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 8. 1.
 * @version : 1.0.0
 */
@Service
public class CO0001 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CO0001.class);

    @Autowired
    private CO0001DAO daoLoginInfo;

    /**
     * @brief Lookup login information
     * @details Look up login user.
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016 8. 18.
     * @param inLoginInfo parameter
     * @return CO000101_OUT login information
     */
    public CO000101OUT selectLogin(CO000101IN inLoginInfo) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- procLogin -----");

        CO000101OUT outLogin = new CO000101OUT();

        CO000101DTO dtoLogin = daoLoginInfo.selectLogin(inLoginInfo);

        if(dtoLogin != null) {
            outLogin.setDeptCd(dtoLogin.getDeptCd());
            outLogin.setDeptNm(dtoLogin.getDeptNm());
            outLogin.setEmpno(dtoLogin.getEmpno());
            outLogin.setEmpNm(dtoLogin.getEmpNm());
        }

        return outLogin;
    }

    public int selectEmpno(String id) {
        return daoLoginInfo.selectEmpno(id);
    }
}
