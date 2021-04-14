/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1020.java
 * @brief 배치 관리 Service
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.fw.dao.FW1020DAO;
import com.encocns.fw.dto.FW102001DTO;
import com.encocns.fw.service.svo.FW102001IN;
import com.encocns.fw.service.svo.FW102001OUT;
import com.encocns.fw.service.svo.FW102002IN;
import com.encocns.fw.service.svo.FW102002OUT;
import com.encocns.fw.service.svo.FW102003IN;
import com.encocns.fw.service.svo.FW102003OUT;
import com.encocns.fw.service.svo.FW102004IN;
import com.encocns.fw.service.svo.FW102004OUT;

/**
 * @brief 배치 관리 Service
 * @details 배치 관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class FW1020 {

    private static final Logger LOGGER = LoggerFactory.getLogger(FW1020.class);

    @Value("#{globalContext}")
    private Properties globalContextProp;

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
    private FW1020DAO daoFW1020;

    /**
     * @brief 배치 관리 조회
     * @details 배치 관리 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW102001IN
     * @return FW102001OUT
     */
    public FW102001OUT selectBatchList( FW102001IN inService ) throws EnfraBusinessException
    {
        ArrayList<FW102001DTO> arrList = daoFW1020.selectBatchList(inService);

        //Instance OSVO
        FW102001OUT outService = new FW102001OUT();
        outService.setArrList(arrList);

        return outService;
    }

    /**
     * @brief 배치 관리 등록 및 수정
     * @details 배치 관리 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW102002IN
     * @return FW102002OUT
     */
    public FW102002OUT mergeBatch( FW102002IN inService )
    {
        //Instance OSVO
        FW102002OUT outService = new FW102002OUT();

        inService.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = daoFW1020.mergeBatch(inService);

        outService.setiResult(iResult);

        return outService;
    }

    /**
     * @brief 배치 삭제
     * @details 배치 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW102003IN
     * @return FW102003OUT
     */
    public FW102003OUT deleteBatch( FW102003IN inService )
    {
        int iResult = daoFW1020.deleteBatch(inService);

        //Instance OSVO
        FW102003OUT outService = new FW102003OUT();
        outService.setiResult(iResult);

        return outService;
    }

    /**
     * @brief 배치 실행 service
     * @details 배치 실행 service
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW102004IN
     * @return FW102004OUT
     */
    public FW102004OUT exeBatch( FW102004IN inService )
    {
        //Instance OSVO
        FW102004OUT outService = new FW102004OUT();

        String[] command = null;
        command = new String[] { globalContextProp.getProperty("BATCH_RUN"), "/com/encocns/co/base/job-AD.xml", inService.getBatId() };

        DefaultExecutor executor = new DefaultExecutor();
        CommandLine cmdLine = CommandLine.parse(command[0]);

        for (int i=1, n=command.length ; i<n ; i++ ) {
            cmdLine.addArgument(command[i]);
        }

        try {
            //async execute
            executor.execute(cmdLine, new DefaultExecuteResultHandler());
        } catch (IOException e) {
            outService.setiResult(-1);
        }

        outService.setiResult(0);

        return outService;
    }


}
