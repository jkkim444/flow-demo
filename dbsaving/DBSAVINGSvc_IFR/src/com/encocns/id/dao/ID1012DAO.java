/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1012DAO.java
 * @brief 상위보고서 조회 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief ID DAO Package
 */
package com.encocns.id.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.id.dto.ID101201DTO;
import com.encocns.id.service.svo.ID101201IN;

/**
 * @brief 상위보고서 조회 DAO
 * @details 상위보고서 조회 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID1012DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1012DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selUprnRptList
     * @details 상위 보고서 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101201IN
     * @return ArrayList<ID101201DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<ID101201DTO> selUprnRptList(ID101201IN in) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selUprnRptList -----");
        return (ArrayList)session.selectList("ID1012.selUprnRptList", in);
    }

}
