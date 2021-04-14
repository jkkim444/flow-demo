/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA9000DAO.java
 * @brief 마감정보관리 DAO
 * @section Major History
 * <pre>
 *   - 이동겸| 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dao
 * @brief Common DAO Package
 */
package com.encocns.ia.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ia.dto.IA900001DTO;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 마감정보 관리 DAO
 * @details 마감정보 관리 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA9000DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA9000DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief 마감정보 조회
     * @details 마감정보 조회
     * @author : 이동겸
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA900002IN
     * @return String
     */
    public String selectClsninfomgmtBaseYm ( IA900002IN inParam ) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClsninfomgmtBaseYm -----");
    	return session.selectOne("IA9000.selectClsninfomgmtBaseYm", inParam);
    }
    
    /**
     * @brief 마감정보 조회
     * @details 마감정보 조회
     * @author : 이동겸
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA900001IN
     * @return IA900001DTO
     */
    public IA900001DTO selectClsnInfoMgmtBASS ( IA900001IN inParam ) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClsnInfoMgmtBASS -----");
    	return session.selectOne("IA9000.selectClsnInfoMgmtBASS", inParam);
    }

    /**
     * @brief 마감정보 변경처리 조회
     * @details 마감정보 변경처리 조회
     * @author : 이동겸
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA900001IN
     * @return int
     */
	public int updateClsnInfoMgmtBASS(IA900001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClsnInfoMgmtBASS -----");
		return session.update("IA9000.updateClsnInfoMgmtBASS", inParam);
	}

	/**
     * @brief 정산 공시 마감 내용 조회
     * @details 정산 공시 마감 내용 조회
     * @author : 이동겸
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA900002IN
     * @return IA900002OUT
     */
	public IA900002OUT selectClsnCtntInq(IA900002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClsnCtntInq -----");
		return session.selectOne("IA9000.selectClsnCtntInq", inParam);
	}
}
