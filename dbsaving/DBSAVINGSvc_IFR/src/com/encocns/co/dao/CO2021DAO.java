/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2021DAO.java
 * @brief 서비스 목록 조회 DAO
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO202101DTO;
import com.encocns.co.service.svo.CO202101IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 서비스 목록 조회 DAO
 * @details 서비스 목록 조회 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO2021DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 서비스 목록 조회
     * @details 서비스 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO202101IN
     * @return List<CO202101DTO>
     */
	public List<CO202101DTO> selectServiceList( CO202101IN inParam ){
		List<CO202101DTO> arrList = session.selectList( "CO2021.selectServiceList", inParam );
		return arrList;
	}
}
