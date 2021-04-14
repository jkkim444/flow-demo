/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1013DAO.java
 * @brief 공시보고서 조회 DAO
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
import com.encocns.id.dto.ID101301DTO;
import com.encocns.id.service.svo.ID101301IN;

/**
 * @brief 공시보고서 조회 DAO
 * @details 공시보고서 조회 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID1013DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1013DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selRptList
     * @details 공시보고서 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101301IN
     * @return ArrayList<ID101301DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<ID101301DTO> selRptList(ID101301IN in) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selRptList -----");
        return (ArrayList)session.selectList("ID1013.selRptList", in);
    }



}
