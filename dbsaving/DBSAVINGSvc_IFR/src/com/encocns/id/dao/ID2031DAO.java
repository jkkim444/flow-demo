/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID2031DAO.java
 * @brief 공시보고서 검증 상세 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.dao
 * @brief ID DAO Package
 */
package com.encocns.id.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.id.dto.ID203101DTO;
import com.encocns.id.dto.ID203102DTO;
import com.encocns.id.service.svo.ID203101IN;

/**
 * @brief 공시보고서 검증 상세 DAO
 * @details 공시보고서 검증 상세 DAO
 * @author : 차 상 길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID2031DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID2031DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 공시보고서 양식 조회
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID203101IN
     * @return List<ID203101DTO>
     */
    public List<ID203101DTO> selectHeader(ID203101IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");
        return session.selectList("ID2031.selectHeader", inParam);
    }

    /**
     * @brief 공시보고서 병합 조회
     * @details 공시보고서 병합 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID203101IN
     * @return List<ID203102DTO>
     */
    public List<ID203102DTO> selectMergeCell(ID203101IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMergeCell -----");
        return session.selectList("ID2031.selectMergeCell", inParam);
    }

}
