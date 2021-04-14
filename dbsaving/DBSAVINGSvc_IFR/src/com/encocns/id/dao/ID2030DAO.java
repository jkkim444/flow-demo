/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID2030DAO.java
 * @brief 공시보고서 검증 DAO
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
import com.encocns.id.dto.ID203001DTO;
import com.encocns.id.dto.ID203002DTO;
import com.encocns.id.dto.ID203003DTO;
import com.encocns.id.dto.ID203004DTO;
import com.encocns.id.dto.ID203005DTO;
import com.encocns.id.service.svo.ID203001IN;
import com.encocns.id.service.svo.ID203002IN;
import com.encocns.id.service.svo.ID203003IN;

/**
 * @brief 공시보고서 검증 DAO
 * @details 공시보고서 검증 DAO
 * @author : 차상길
 * @date : 2020. 4. 23.
 * @version : 1.0.0
 */
@Repository
public class ID2030DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID2030DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selectRptbsList
     * @details 공시보고서 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID203001IN
     * @return List<ID203001DTO>
     */
    public List<ID203001DTO> selectRptbsList(ID203001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectRptbsList -----");
        return session.selectList("ID2030.selectRptbsList", inParam);
    }

	/**
     * @brief selectHeader
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID203002IN
     * @return List<ID203002DTO>
     */
   public List<ID203002DTO> selectHeader(ID203002IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");
       return session.selectList("ID2030.selectHeader", inParam);
   }

	/**
    * @brief selectMergeCell
    * @details 공시보고서 병합 조회
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID203002IN
    * @return List<ID203003DTO>
    */
   public List<ID203003DTO> selectMergeCell(ID203002IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMergeCell -----");
       return session.selectList("ID2030.selectMergeCell", inParam);
   }

	/**
    * @brief selectValbaYnCell
    * @details 공시보고서 검증 성공여부 조회
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID203002IN
    * @return List<ID203004DTO>
    */
   public List<ID203004DTO> selectValbaYnCell(ID203002IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectValbaYnCell -----");
       return session.selectList("ID2030.selectValbaYnCell", inParam);
   }

	/**
    * @brief selectValbaList
    * @details 공시보고서 검증 상세 조회
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID203003IN
    * @return List<ID203005DTO>
    */
   public List<ID203005DTO> selectValbaList(ID203003IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectValbaList -----");
       return session.selectList("ID2030.selectValbaList", inParam);
   }
}
