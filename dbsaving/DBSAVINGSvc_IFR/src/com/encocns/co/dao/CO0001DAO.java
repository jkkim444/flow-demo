/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO0001DAO.java
 * @brief 로그인 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao;
 * @brief Common DAO Package
 */
package com.encocns.co.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO000101DTO;
import com.encocns.co.service.svo.CO000101IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 로그인 DAO
 * @details 로그인 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO0001DAO {

	@Autowired
    private SqlMapClient session;

	/**
	 * @brief 로그인 정보 조회
	 * @details 로그인 정보 조회
	 * @author : 차상길
	 * @date : 2020. 11. 26.
	 * @param CO000101IN
	 * @return CO000101DTO
	 */
	public CO000101DTO selectLogin( CO000101IN inLoginInfo ){
		return (CO000101DTO)session.selectOne( "CO0001.selectLogin", inLoginInfo );
	}

	/**
	 * @brief 사용자 정보 조회
	 * @details 사용자 정보 조회
	 * @author : 차상길
	 * @date : 2020. 11. 26.
	 * @param CO000101IN
	 * @return CO000101DTO
	 */
	public CO000101DTO selectLoginInfo( CO000101IN inLoginInfo ){
		return (CO000101DTO)session.selectOne( "CO0001.selectLoginInfo", inLoginInfo );
	}

    /**
     * @brief 사용자 정보 조회
     * @details 사용자 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param String
     * @return int
     */
    public int selectEmpno( String id ){
        return session.selectOne( "CO0001.selectEmpno", id );
    }

}
