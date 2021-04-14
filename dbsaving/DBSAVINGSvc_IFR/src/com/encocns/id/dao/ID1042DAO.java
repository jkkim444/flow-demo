/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1042DAO.java
 * @brief 산출정보조회 DAO
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
import com.encocns.id.dto.ID104201DTO;
import com.encocns.id.service.svo.ID104201IN;


/**
 * @brief 산출정보조회 DAO
 * @details 산출정보조회 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID1042DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1042DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selectClclIstgList
     * @details 보고서 산출정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104201IN
     * @return List<ID104201DTO>
     */
    public List<ID104201DTO> selectClclIstgList(ID104201IN in) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClclIstgList -----");
        return session.selectList("ID1042.selectClclIstgList", in);
    }
}
