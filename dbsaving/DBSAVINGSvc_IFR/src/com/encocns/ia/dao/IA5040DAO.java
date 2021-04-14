/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5020DAO.java
 * @brief IFRS 재무상태표 산출 내역 List DAO
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

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ia.dto.IA504001DTO;
import com.encocns.ia.service.svo.IA504001IN;
import com.encocns.ia.service.svo.IA504002IN;

/**
 * @brief IFRS 재무상태표 산출 내역 DAO
 * @details IFRS 재무상태표 산출 내역 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5040DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5040DAO.class);

	@Autowired
    private SqlMapClient session;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    
    /**
     * @brief IFRS 재무상태표 산출 조회 
     * @details IFRS 재무상태표 산출 조회 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA504001IN
     * @return ArrayList<IA504001DTO>
     */
    public ArrayList<IA504001DTO> selectListIfrsfnafStaSht(IA504001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsfnafStaSht -----");
        return (ArrayList)session.selectList("IA5040.selectListIfrsfnafStaSht", inParam);
    }

    /**
     * @brief IFRS 재무상태표 산출 생성
     * @details IFRS 재무상태표 산출 생성
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA504002IN
     * @return int
     */
	public int insertIfrsfnafStaSht(IA504002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsfnafStaSht -----");
		return session.insert("IA5040.insertIfrsfnafStaSht", inParam);
	}

	/**
     * @brief IFRS 재무상태표 산출 삭제
     * @details IFRS 재무상태표 산출 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA504002IN
     * @return int
     */
	public int deleteIfrsfnafStaSht(IA504002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIfrsfnafStaSht -----");
		return session.delete("IA5040.deleteIfrsfnafStaSht", inParam);
	}



}
