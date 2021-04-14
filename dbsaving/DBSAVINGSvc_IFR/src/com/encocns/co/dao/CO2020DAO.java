/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2020DAO.java
 * @brief 화면 목록 관리 DAO
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO202001DTO;
import com.encocns.co.service.svo.CO202001IN;
import com.encocns.co.service.svo.CO202002IN;
import com.encocns.co.service.svo.CO202003IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 화면 목록 관리 DAO
 * @details 화면 목록 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO2020DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO2020DAO.class);

	@Autowired
    private SqlMapClient session;


    /**
     * @brief 화면 목록 조회
     * @details 화면 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO202001IN
     * @return List<CO202001DTO>
     */
	public List<CO202001DTO> selectScreenList(CO202001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectScreenList -----");
		return session.selectList("CO2020.selectScreenList", inParam);
	}

    /**
     * @brief 화면 등록
     * @details 화면 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO202002IN
     * @return int
     */
	public int insertScreen(CO202002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertScreen -----");
		return session.insert("CO2020.insertScreen", inParam);
	}


    /**
     * @brief 화면 수정
     * @details 화면 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO202002IN
     * @return int
     */
	public int updateScreen(CO202002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateScreen -----");
		return session.update("CO2020.updateScreen", inParam);
	}

    /**
     * @brief 화면 삭제
     * @details 화면 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO202003IN
     * @return int
     */
	public int deleteScreen(CO202003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteScreen -----");
		return session.delete("CO2020.deleteScreen", inParam);
	}

}
