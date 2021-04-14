/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO0004DAO.java
 * @brief 사원 코드 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 4. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief Common DAO Package
 */
package com.encocns.co.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO000401DTO;
import com.encocns.co.service.svo.CO000401IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 사원 코드 DAO
 * @details 사원 코드 DAO
 * @author : 차상길
 * @date : 2020. 4. 24.
 * @version : 1.0.0
 */
@Repository
public class CO0004DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO0004DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 사원 코드 조회
     * @details 사원 코드 조회
     * @author : 차상길
     * @date : 2020. 4. 24.
     * @version : 1.0.0
     * @param CO000401IN
     * @return List<CO000401DTO>
     */
    public List<CO000401DTO> selectEmployeeList(CO000401IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectEmployeeList -----");
        return session.selectList("CO0004.selectEmployeeList", inParam);
    }

}
