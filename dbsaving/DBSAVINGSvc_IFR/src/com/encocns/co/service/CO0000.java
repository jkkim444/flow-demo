/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO0000.java
 * @brief
 * 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - 홍길동 | 2020. 1. 23. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service
 * @brief
 */
package com.encocns.co.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO0000DAO;
import com.encocns.co.dao.CO4010DAO;
import com.encocns.co.service.svo.CO000001IN;
import com.encocns.co.service.svo.CO000001OUT;
import com.encocns.co.service.svo.CO000002IN;
import com.encocns.co.service.svo.CO000002OUT;
import com.encocns.co.service.svo.CO000003IN;
import com.encocns.co.service.svo.CO000003OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;

/**
 * @brief
 * 간략 설명을 작성한다.
 * @details
 * <pre>
 * 상세 설명을 작성한다.
 * </pre>
 * @author : 홍길동
 * @date : 2020. 1. 23.
 * @version : 1.0.0
 */
@Service
public class CO0000 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CO0000.class);

    @Autowired
    private CO0000DAO daoCO0000;

    @Autowired
    private CO4010DAO daoCO4010;

    @Autowired
    private ServiceComponent serviceComponent;

    /**
     * @brief
     * 메인 홈 알림글 조회
     * @details
     * <pre>
     * 메인 홈 유의사항 및 금감원 안내자료를 조회한다.
     * </pre>
     * @author : 이좌형
     * @date : 2020. 1. 29.
     * @param inParam
     * @return
     */
    public CO000001OUT selectHomeNotice(CO000001IN inParam) {

        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHomeNotice -----");

        inParam.setSeEmpno(serviceComponent.getSessionVO().getUserId());
        CO000001OUT outParam = new CO000001OUT();
        return outParam;
    }

    /**
     * @brief 공지사항관리 management List inquiry
     * @details The Lotice management List.
	 * @author : CHOI,HO-YEON
	 * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param inParam
     * @return ArrayList List of User
     */
	public CO000002OUT selectNoticetListCmknMtr(CO000002IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selecNoticetListCmknMtr -----");

		CO000002OUT outParamList = new CO000002OUT();
		outParamList.setArrList(daoCO0000.selecNoticetListCmknMtr(inParam));

		return outParamList;

	}

    /**
     * @brief 공지사항관리 management List inquiry
     * @details The Lotice management List.
	 * @author : CHOI,HO-YEON
	 * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param inParam
     * @return ArrayList List of User
     */
	public CO000003OUT selectNoticeListClsnInfoMgmt(CO000003IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectNoticeListClsnInfoMgmt -----");

		CO000003OUT outParamList = new CO000003OUT();
		outParamList.setArrList3(daoCO0000.selectNoticeListClsnInfoMgmt(inParam));

		return outParamList;

	}

}
