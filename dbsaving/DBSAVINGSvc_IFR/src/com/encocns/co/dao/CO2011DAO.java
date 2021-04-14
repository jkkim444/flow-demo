/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2011DAO.java
 * @brief 화면 목록 조회 DAO
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

import com.encocns.co.dto.CO201101DTO;
import com.encocns.co.service.svo.CO201101IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 화면 목록 조회 DAO
 * @details 화면 목록 조회 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO2011DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 화면 목록 조회
     * @details 화면 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201101IN
     * @return List<CO201101DTO>
     */
	public List<CO201101DTO> selectScreenList( CO201101IN inParam ){
		List<CO201101DTO> arrList = session.selectList( "CO2011.selectScreenList", inParam );
		return arrList;
	}
}
