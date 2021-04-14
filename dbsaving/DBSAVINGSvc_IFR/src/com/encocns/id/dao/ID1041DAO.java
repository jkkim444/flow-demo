/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1041DAO.java
 * @brief 산출 및 검증 대상 조회 DAO
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
import com.encocns.id.dto.ID104101DTO;
import com.encocns.id.dto.ID104102DTO;
import com.encocns.id.service.svo.ID104101IN;


/**
 * @brief 산출 및 검증 대상 조회 DAO
 * @details 산출 및 검증 대상 조회 DAO
 * @author : 차 상 길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID1041DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1041DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selectOnePbnfRptNm
     * @details 공시보고서 명칭 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104101IN
     * @return String
     */
	public String selectOnePbnfRptNm(ID104101IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectOnePbnfRptNm -----");
        return (String)session.selectOne("ID1041.selectOnePbnfRptNm", inParam);
    }

	/**
     * @brief selectHeader
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104101IN
     * @return List<ID104101DTO>
     */
    public List<ID104101DTO> selectHeader(ID104101IN in) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");
        return session.selectList("ID1041.selectHeader", in);
    }

	/**
     * @brief selectMergeCell
     * @details 공시보고서 병합 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104101IN
     * @return List<ID104102DTO>
     */
    public List<ID104102DTO> selectMergeCell(ID104101IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMergeCell -----");
        return session.selectList("ID1041.selectMergeCell", inParam);
    }
}
