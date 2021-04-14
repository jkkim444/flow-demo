/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW0000.java
 * @brief 파일컴포넌트ID 조회 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service
 * @brief FW Service Package
 */
package com.encocns.fw.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.fw.dao.FW0000DAO;
import com.encocns.fw.service.svo.FW000001IN;
import com.encocns.fw.service.svo.FW000001OUT;

/**
 * @brief 파일컴포넌트ID 조회 Service
 * @details 파일컴포넌트ID 조회 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class FW0000 {

    private static final Logger LOGGER = LoggerFactory.getLogger(FW0000.class);

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
    private FW0000DAO daoF00000;

    /**
     * @brief 파일컴포넌트ID 조회
     * @details 파일컴포넌트ID 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW000001IN
     * @return FW000001OUT
     */
    public FW000001OUT selectFileCpntId( FW000001IN inParam ) throws EnfraBusinessException
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug(inParam.getBizLclsCd());

        String fileCpntId = daoF00000.selectFileCpntId(inParam.getBizLclsCd());

        //Instance OSVO
        FW000001OUT outParam = new FW000001OUT();
        outParam.setFileCpntId(fileCpntId);

        return outParam;
    }


}
