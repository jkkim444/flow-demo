/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5060DAO.java
 * @brief User List DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
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
import com.encocns.ia.dto.IA506001DTO;
import com.encocns.ia.service.svo.IA506001IN;
import com.encocns.ia.service.svo.IA506002IN;

/**
 * @brief IFRS 포괄손익계산서 산출 DAO
 * @details IFRS 포괄손익계산서 산출 DAO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
@Repository
public class IA5060DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5060DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief IFRS 포괄손익계산서 산출 조회 내역
     * @details IFRS 포괄손익계산서 산출 조회 내역
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA506001IN
     * @return List<IA506001DTO>
     */
    public List<IA506001DTO> selectListIfrsIcsPflsBlls(IA506001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsIcsPflsBlls -----");
        return session.selectList("IA5060.selectListIfrsIcsPflsBlls", inParam);
    }

    /**
     * @brief IFRS 포괄손익계산서 산출 생성
     * @details IFRS 포괄손익계산서 산출 생성
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA506002IN
     * @return int
     */
	public int insertIfrsIcsPflsBlls(IA506002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsIcsPflsBlls -----");
		return session.insert("IA5060.insertIfrsIcsPflsBlls", inParam);
	}

	/**
     * @brief IFRS 포괄손익계산서 산출 삭제
     * @details IFRS 포괄손익계산서 산출 삭제
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA506002IN
     * @return int
     */
	public int deleteIfrsIcsPflsBlls(IA506002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIfrsIcsPflsBlls -----");
		return session.delete("IA5060.deleteIfrsIcsPflsBlls", inParam);
	}



}
