/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6080DAO.java
 * @brief 기타포괄손익 공정가치자산내역 관리 DAO
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
import com.encocns.ia.dto.IA608001DTO;
import com.encocns.ia.service.svo.IA608001IN;
import com.encocns.ia.service.svo.IA608002IN;
import com.encocns.ia.service.svo.IA608003IN;

/**
 * @brief 기타포괄손익 공정가치자산내역 관리 DAO
 * @details 기타포괄손익 공정가치자산내역 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
@Repository
public class IA6080DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6080DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 기타포괄손익 공정가치자산내역 조회
     * @details 기타포괄손익 공정가치자산내역 조회
     * @author : 차상길
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA608001IN
     * @return List<IA608001DTO>
     */
    public List<IA608001DTO> selectIcsPflsFvList(IA608001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectIcsPflsFvList -----");
        return session.selectList("IA6080.selectIcsPflsFvList", inParam);
    }

    /**
     * @brief 기타포괄손익 공정가치자산내역 등록 및 수정
     * @details 기타포괄손익 공정가치자산내역 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA608002IN
     * @return int
     */
	public int mergeIcsPflsFv(IA608002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeIcsPflsFv -----");
		return session.insert("IA6080.mergeIcsPflsFv", inParam);
	}

    /**
     * @brief 기타포괄손익 공정가치자산내역 삭제
     * @details 기타포괄손익 공정가치자산내역 삭제
     * @author : 차상길
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA608003IN
     * @return int
     */
	public int deleteIcsPflsFv(IA608003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIcsPflsFv -----");
		return session.delete("IA6080.deleteIcsPflsFv", inParam);
	}

    /**
     * @brief 기타포괄손익 공정가치자산내역 기초생성 전 삭제
     * @details 기타포괄손익 공정가치자산내역 기초생성 전 삭제
     * @author : 차상길
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA608002IN
     * @return int
     */
	public int deleteIcsPflsFvBass(IA608002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIcsPflsFvBass -----");
		return session.insert("IA6080.deleteIcsPflsFvBass", inParam);
	}

    /**
     * @brief 기타포괄손익 공정가치자산내역 기초생성
     * @details 기타포괄손익 공정가치자산내역 기초생성
     * @author : 차상길
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA608002IN
     * @return int
     */
	public int insertIcsPflsFvBass(IA608002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIcsPflsFvBass -----");
		return session.insert("IA6080.insertIcsPflsFvBass", inParam);
	}

}
