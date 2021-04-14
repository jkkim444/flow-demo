/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO0002DAO.java
 * @brief 계정코드 조회 DAO
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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO000201DTO;
import com.encocns.co.service.svo.CO000201IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 계정코드 조회 DAO
 * @details 계정코드 조회 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO0002DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO0002DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 계정코드 조회
     * @details 계정코드 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO000201IN
     * @return List<CO000201DTO>
     */
    public List<CO000201DTO> selectIfrsAcc1(CO000201IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectIfrsAcc1 -----");
        return session.selectList("CO0002.selectIfrsAcc1", inParam);
    }

    /**
     * @brief 계정코드 조회
     * @details 계정코드 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO000201IN
     * @return int
     */
    public int selectIfrsAcc2(CO000201IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectIfrsAcc2 -----");
        return session.selectOne("CO0002.selectIfrsAcc2", inParam);
    }

}
