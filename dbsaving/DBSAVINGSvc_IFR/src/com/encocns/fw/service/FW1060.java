/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1060.java
 * @brief 배치 그룹 관리 Service
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

import java.util.ArrayList;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.fw.dao.FW1060DAO;
import com.encocns.fw.dto.FW106001DTO;
import com.encocns.fw.service.svo.FW106001IN;
import com.encocns.fw.service.svo.FW106001OUT;
import com.encocns.fw.service.svo.FW106002IN;
import com.encocns.fw.service.svo.FW106002OUT;
import com.encocns.fw.service.svo.FW106003IN;
import com.encocns.fw.service.svo.FW106003OUT;

/**
 * @brief 배치 그룹 관리 Service
 * @details 배치 그룹 관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class FW1060 {

    private static final Logger LOGGER = LoggerFactory.getLogger(FW1060.class);

    @Value("#{globalContext}")
    private Properties globalContextProp;

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
    private FW1060DAO daoFW1060;

    /**
     * @brief 배치 그룹 조회
     * @details 배치 그룹 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW106001IN
     * @return FW106001OUT
     */
    public FW106001OUT selectBatGroup( FW106001IN inService ) throws EnfraBusinessException
    {
        ArrayList<FW106001DTO> arrList = daoFW1060.selectBatchGrpList(inService);

        //Instance OSVO
        FW106001OUT outService = new FW106001OUT();
        outService.setArrList(arrList);

        return outService;
    }

    /**
     * @brief 배치 그룹 등록 및 수정
     * @details 배치 그룹 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW106002IN
     * @return FW106002OUT
     */
    public FW106002OUT mergeBatGroup( FW106002IN inService )
    {
        //Instance OSVO
        FW106002OUT outService = new FW106002OUT();

        inService.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = daoFW1060.mergeBatchGrp(inService);

        outService.setiResult(iResult);

        return outService;
    }

    /**
     * @brief 배치 그룹 삭제
     * @details 배치 그룹 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW106003IN
     * @return FW106003OUT
     */
    public FW106003OUT deleteBatGroup( FW106003IN inService )
    {
        int iResult = daoFW1060.deleteBatchGrp(inService);

        //Instance OSVO
        FW106003OUT outService = new FW106003OUT();
        outService.setiResult(iResult);

        return outService;
    }



}
