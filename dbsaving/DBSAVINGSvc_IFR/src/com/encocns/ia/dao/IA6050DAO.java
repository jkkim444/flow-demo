/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6050DAO.java
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
import com.encocns.ia.dto.IA605001DTO;
import com.encocns.ia.service.svo.IA605001IN;
import com.encocns.ia.service.svo.IA605002IN;
import com.encocns.ia.service.svo.IA605003IN;
import com.encocns.ia.service.svo.IA605004IN;

/**
 * @brief 공정가치금융자산내역 관리 DAO
 * @details 공정가치금융자산내역 관리 DAO
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA6050DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6050DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA605001IN
     * @return List<IA605001DTO>
     */
    public List<IA605001DTO> selectNlnknstrentasetList(IA605001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectNlnknstrentasetList -----");
        return session.selectList("IA6050.selectNlnknstrentasetList", inParam);
    }

    /**
     * @brief 공정가치금융자산내역 기초삭제
     * @details 공정가치금융자산내역 기초삭제
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA605004IN
     * @return int
     */
	public int deleteNlnknstrentasetBass(IA605004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteNlnknstrentasetBass -----");
		return session.delete("IA6050.deleteNlnknstrentasetBass", inParam);
	}

    /**
     * @brief 공정가치금융자산내역 기초생성
     * @details 공정가치금융자산내역 기초생성
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA605004IN
     * @return int
     */
	public int insertNlnknstrentasetBass(IA605004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertNlnknstrentasetBass -----");
		return session.insert("IA6050.insertNlnknstrentasetBass", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA605002IN
     * @return int
     */
	public int insertNlnknstrentaset(IA605002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertNlnknstrentaset -----");
		return session.insert("IA6050.insertNlnknstrentaset", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA605002IN
     * @return int
     */
	public int updateNlnknstrentaset(IA605002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateNlnknstrentaset -----");
		return session.update("IA6050.updateNlnknstrentaset", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA605001DTO
     * @return int
     */
	public int insertNlnknstrentasetExcel(IA605001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertNlnknstrentasetExcel -----");
		return session.insert("IA6050.insertNlnknstrentasetExcel", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA605003IN
     * @return int
     */
	public int deleteNlnknstrentaset(IA605003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteNlnknstrentaset -----");
		return session.delete("IA6050.deleteNlnknstrentaset", inParam);
	}

}
