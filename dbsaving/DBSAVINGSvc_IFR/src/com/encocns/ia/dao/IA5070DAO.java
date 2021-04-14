/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5070DAO.java
 * @brief 포괄손익계산서 DAO
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
import com.encocns.ia.dto.IA507001DTO;
import com.encocns.ia.service.svo.IA507001IN;

/**
 * @brief : 포괄손익계산서 조회 DAO
 * @details : 포괄손익계산서 조회 DAO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
@Repository
public class IA5070DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5070DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief : IFRS 포괄손익계산서 산출 조회
     * @details : IFRS 포괄손익계산서 산출 조회
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA507001IN
     * @return List<IA507001DTO>
     */
    public List<IA507001DTO> selectListIfrsIcsPflsBllsInq(IA507001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsIcsPflsBllsInq -----");
        return session.selectList("IA5070.selectListIfrsIcsPflsBllsInq", inParam);
    }



}
