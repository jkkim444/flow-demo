/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO0000DAO.java
 * @brief
 * 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - 홍길동 | 2020. 1. 23. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief
 */
package com.encocns.co.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO000002DTO;
import com.encocns.co.dto.CO000003DTO;
import com.encocns.co.service.svo.CO000002IN;
import com.encocns.co.service.svo.CO000003IN;
import com.encocns.fw.config.db.SqlMapClient;

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
@Repository
public class CO0000DAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(CO0000DAO.class);

    @Autowired
    private SqlMapClient session;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<CO000002DTO> selecNoticetListCmknMtr(CO000002IN inGroup) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selecNoticetListCmknMtr -----");
        return (ArrayList)session.selectList("CO0000.selecNoticetListCmknMtr", inGroup);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<CO000003DTO> selectNoticeListClsnInfoMgmt(CO000003IN inGroup) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectNoticeListClsnInfoMgmt -----");
        return (ArrayList)session.selectList("CO0000.selectNoticeListClsnInfoMgmt", inGroup);
    }

}
