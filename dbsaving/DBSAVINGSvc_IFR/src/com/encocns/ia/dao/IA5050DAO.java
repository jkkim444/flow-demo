/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5050DAO.java
 * @brief 재무상태표 조회 List DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dao
 * @brief Common DAO Package
 */
package com.encocns.ia.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ia.dto.IA505001DTO;
import com.encocns.ia.service.svo.IA505001IN;

/**
 * @brief IFRS 재무상태표 조회 DAO
 * @details IFRS 재무상태표 조회 DAO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
@Repository
public class IA5050DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5050DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief IFRS 재무상태표 조회 
     * @details IFRS 재무상태표 조회
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA505001IN
     * @return List<IA505001DTO>
     */
    public List<IA505001DTO> selectListIfrsfnafStaShtInq(IA505001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsfnafStaShtInq -----");
        return session.selectList("IA5050.selectListIfrsfnafStaShtInq", inParam);
    }



}
