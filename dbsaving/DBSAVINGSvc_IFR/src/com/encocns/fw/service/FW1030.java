/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1030.java
 * @brief 배치 작업 현황 Service
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.fw.dao.FW1030DAO;
import com.encocns.fw.dto.FW103001DTO;
import com.encocns.fw.dto.FW103002DTO;
import com.encocns.fw.service.svo.FW103001IN;
import com.encocns.fw.service.svo.FW103001OUT;
import com.encocns.fw.service.svo.FW103002IN;
import com.encocns.fw.service.svo.FW103002OUT;

/**
 * @brief 배치 작업 현황 Service
 * @details 배치 작업 현황 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class FW1030 {

    private static final Logger LOGGER = LoggerFactory.getLogger(FW1030.class);

    @Autowired
    private FW1030DAO daoFW1030;


    /**
     * @brief 배치 그룹 ID 조회
     * @details 배치 그룹 ID 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW103002IN
     * @return FW103002OUT
     */
    public FW103002OUT selectGrpId( FW103002IN inService )
    {
        ArrayList<FW103002DTO> arrList = null;

        if( inService.getGrpId() !=null && !"".equals(inService.getGrpId())  ) {
            arrList = daoFW1030.selectGrpInsId( inService.getGrpId() );
        }
        else {
            arrList = daoFW1030.selectGrpId();
        }

        //Instance OSVO
        FW103002OUT outService = new FW103002OUT();

        outService.setGrpId(inService.getGrpId());
        outService.setArrList(arrList);

        return outService;
    }


    /**
     * @brief 배치 작업 내역 조회
     * @details 배치 작업 내역 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW103001IN
     * @return FW103001OUT
     */
    public FW103001OUT selectBatchOperationList( FW103001IN inService ) throws EnfraBusinessException
    {
        ArrayList<FW103001DTO> arrList = daoFW1030.selectBatchOperationList(inService);

        //Instance OSVO
        FW103001OUT outService = new FW103001OUT();
        outService.setArrList(arrList);

        return outService;
    }
}
