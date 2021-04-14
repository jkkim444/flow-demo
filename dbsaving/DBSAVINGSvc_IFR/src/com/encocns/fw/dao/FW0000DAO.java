/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW0000DAO.java
 * @brief 파일컴포넌트ID 조회 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dao
 * @brief FW DAO Package
 */
package com.encocns.fw.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 파일컴포넌트ID 조회 DAO
 * @details 파일컴포넌트ID 조회 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class FW0000DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 파일 컴포넌트 ID 조회
     * @details 파일 컴포넌트 ID 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param String
     * @return String
     */
	public String selectFileCpntId( String bizLclsCd ){
		String fileCpntId = session.selectOne( "FW0000.selectFileCpntId", bizLclsCd );
		return fileCpntId;
	}


}
