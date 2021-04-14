/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5090DAO.java
 * @brief 연결현금흐름표 List DAO
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
import com.encocns.ia.dto.IA509001DTO;
import com.encocns.ia.service.svo.IA509001IN;

/**
 * @brief IFRS연결현금흐름표 내역 DAO
 * @details IFRS연결현금흐름표 내역 DAO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
@Repository
public class IA5090DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5090DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief IFRS연결현금흐름표 조회 내역
     * @details IFRS연결현금흐름표 조회 내역
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA509001IN
     * @return List<IA509001DTO>
     */
    public List<IA509001DTO> selectListLnknCashFlow(IA509001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLnknCashFlow -----");
        return session.selectList("IA5090.selectListLnknCashFlow", inParam);
    }

    /**
     * @brief IFRS연결현금흐름표 생성
     * @details IFRS연결현금흐름표 생성
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA509001DTO
     * @return int
     */
	public int insertLnknCashFlowExcl(IA509001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLnknCashFlowExcl -----");
		return session.insert("IA5090.insertLnknCashFlowExcl", inParam);
	}

	/**
     * @brief IFRS연결현금흐름표 삭제
     * @details IFRS연결현금흐름표 삭제
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA509001DTO
     * @return int
     */
	public int deleteLnknCashFlow(IA509001DTO iA509001DTO) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLnknCashFlow -----");
		return session.delete("IA5090.deleteLnknCashFlow", iA509001DTO);
	}


}
