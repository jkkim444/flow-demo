/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5180DAO.java
 * @brief 기초이월분개처리 DAO
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 9. 29. | First Created
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
import com.encocns.ia.dto.IA518001DTO;
import com.encocns.ia.service.svo.IA518001IN;


/**
 * @brief 기초이월분개처리 정보 DAO
 * @details 기초이월분개처리 정보 DAO
 * @author : 이미래
 * @date : 2020. 9. 28.
 * @version : 1.0.0
 */
@Repository
public class IA5180DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5180DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief 기초 이월 분개 처리 조회
     * @details 기초 이월 분개 처리 조회
     * @author : 이미래
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA518001IN
     * @return List<IA518001DTO>
     */
    public List<IA518001DTO> selectListBassCrfrJrlz(IA518001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBassCrfrJrlz -----");
        return session.selectList("IA5180.selectListBassCrfrJrlz", inParam);
    }

    /**
     * @brief 기초이월분개처리 등록
     * @details 기초이월분개처리 등록
     * @author : 이미래
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA518001IN
     * @return int
     */
	public int insertBassCrfrJrlz(IA518001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertBassCrfrJrlz -----");
		return session.insert("IA5180.insertBassCrfrJrlz", inParam);
	}

	/**
     * @brief 기초이월분개처리  삭제 
     * @details 기초이월분개처리  삭제 
     * @author : 이미래
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA518001IN
     * @return int
     */
	public int deleteBassCrfrJrlz(IA518001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteBassCrfrJrlz -----");
		return session.delete("IA5180.deleteBassCrfrJrlz", inParam);
	}


}
