/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO1021DAO.java
 * @brief 부서조회 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief Common DAO Package
 */
package com.encocns.co.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO000301DTO;
import com.encocns.co.service.svo.CO000301IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 부서조회 DAO
 * @details 부서조회 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO0003DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO0003DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 부서조회
     * @details 부서조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO000301IN
     * @return ArrayList<CO000301DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<CO000301DTO> selectDept(CO000301IN inGroup) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectDept -----");
        return (ArrayList)session.selectList("CO0003.selectDept", inGroup);
    }

}
