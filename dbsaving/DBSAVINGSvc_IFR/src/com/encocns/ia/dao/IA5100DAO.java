/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5100DAO.java
 * @brief User List DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
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
import com.encocns.ia.dto.IA510001DTO;
import com.encocns.ia.service.svo.IA510001IN;

/**
 * @brief IFRS분개전표 DAO
 * @details IFRS분개전표 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5100DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5100DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief IFRS분개전표 조회
     * @details IFRS분개전표 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA510001IN
     * @return List<IA510001DTO>
     */
    public List<IA510001DTO> selectListIfrsConvJrlz(IA510001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsConvJrlz -----");
        return session.selectList("IA5100.selectListIfrsConvJrlz", inParam);
    }

}
