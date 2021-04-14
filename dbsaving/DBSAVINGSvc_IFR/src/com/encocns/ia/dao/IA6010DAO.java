/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6010DAO.java
 * @brief 공정가치 금융자산 내역 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 9. 03. | First Created
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
import com.encocns.ia.dto.IA601001DTO;
import com.encocns.ia.service.svo.IA601001IN;
import com.encocns.ia.service.svo.IA601002IN;
import com.encocns.ia.service.svo.IA601003IN;

/**
 * @brief 공정가치금융자산내역 관리 DAO
 * @details 공정가치금융자산내역 관리 DAO
 * @author : 차상길
 * @date : 2020. 9. 03.
 * @version : 1.0.0
 */
@Repository
public class IA6010DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6010DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA601001IN
     * @return List<IA601001DTO>
     */
    public List<IA601001DTO> selectFvfnasList(IA601001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectFvfnasList -----");
        return session.selectList("IA6010.selectFvfnasList", inParam);
    }

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA601002IN
     * @return int
     */
	public int insertFvfnas(IA601002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertFvfnas -----");
		return session.insert("IA6010.insertFvfnas", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA601002IN
     * @return int
     */
	public int updateFvfnas(IA601002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateFvfnas -----");
		return session.update("IA6010.updateFvfnas", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA601003IN
     * @return int
     */
	public int deleteFvfnas(IA601003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteFvfnas -----");
		return session.delete("IA6010.deleteFvfnas", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA601001DTO
     * @return int
     */
	public int insertFvfnasExcel(IA601001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertFvfnasExcel -----");
		return session.insert("IA6010.insertFvfnasExcel", inParam);
	}

    /**
     * @brief 공정가치측정금융자산내역 기준년월 삭제
     * @details 공정가치측정금융자산내역 기준년월 삭제
     * @author : 차상길
     * @date : 2020. 10. 26.
     * @version : 1.0.0
     * @param IA601003IN
     * @return int
     */
	public int deleteFvfnasAll(IA601003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteFvfnasAll -----");
		return session.delete("IA6010.deleteFvfnasAll", inParam);
	}
    /**
     * @brief 기초자료 생성 공정가치측정금융자산내역 등록
     * @details 기초자료 생성 공정가치측정금융자산내역 등록
     * @author : 차상길
     * @date : 2020. 10. 26.
     * @version : 1.0.0
     * @param IA601003IN
     * @return int 
     */
	public int insertFvfnasBass(IA601003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertFvfnasBass -----");
		return session.insert("IA6010.insertFvfnasBass", inParam);
	}

}
