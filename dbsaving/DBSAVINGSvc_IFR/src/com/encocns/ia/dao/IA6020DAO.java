/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6020DAO.java
 * @brief 공정가치금융자산내역 관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 8. 10. | First Created
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
import com.encocns.ia.dto.IA602001DTO;
import com.encocns.ia.service.svo.IA602001IN;
import com.encocns.ia.service.svo.IA602002IN;
import com.encocns.ia.service.svo.IA602003IN;

/**
 * @brief 공정가치금융자산내역 관리 DAO
 * @details 공정가치금융자산내역 관리 DAO
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA6020DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6020DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA602001IN
     * @return List<IA602001DTO>
     */
    public List<IA602001DTO> selectTnasetchgList(IA602001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectTnasetchgList -----");
        return session.selectList("IA6020.selectTnasetchgList", inParam);
    }

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA602002IN
     * @return int
     */
	public int insertTnasetchg(IA602002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertTnasetchg -----");
		return session.insert("IA6020.insertTnasetchg", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA602002IN
     * @return int
     */
	public int updateTnasetchg(IA602002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateTnasetchg -----");
		return session.update("IA6020.updateTnasetchg", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA602001DTO
     * @return int
     */
	public int insertTnasetchgExcel(IA602001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertTnasetchgExcel -----");
		return session.insert("IA6020.insertTnasetchgExcel", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA602003IN
     * @return int
     */
	public int deleteTnasetchg(IA602003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteTnasetchg -----");
		return session.delete("IA6020.deleteTnasetchg", inParam);
	}

}
