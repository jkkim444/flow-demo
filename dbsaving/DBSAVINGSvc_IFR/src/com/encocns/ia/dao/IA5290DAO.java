/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5290DAO.java
 * @brief 마감정보관리 DAO
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
import com.encocns.ia.dto.IA529001DTO;
import com.encocns.ia.service.svo.IA529001IN;
import com.encocns.ia.service.svo.IA529002IN;
import com.encocns.ia.service.svo.IA529003IN;

/**
 * @brief 마감정보관리 DAO
 * @details 마감정보관리 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5290DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5290DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief 마감정보관리  요약 내역 조회
     * @details 마감정보관리  요약 내역 조회 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA529001IN
     * @return ArrayList<IA529001DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<IA529001DTO> selectListClsnInfoMgmt(IA529001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListClsnInfoMgmt -----");
        return (ArrayList)session.selectList("IA5290.selectListClsnInfoMgmt", inParam);
    }

    /**
     * @brief 마감정보관리 등록
     * @details 마감정보관리 등록 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA529001DTO
     * @return int
     */
	public int insertClsnInfoMgmt(IA529001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertClsnInfoMgmt -----");
		return session.insert("IA5290.insertClsnInfoMgmt", inParam);
	}

	/**
     * @brief 마감정보관리 등록
     * @details 마감정보관리 등록 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA529002IN
     * @return int
     */
	public int insertClsnInfoMgmt(IA529002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertClsnInfoMgmt -----");
		return session.insert("IA5290.insertClsnInfoMgmt", inParam);
	}

	/**
     * @brief 마감정보관리 수정
     * @details 마감정보관리 수정 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA529001IN
     * @return int
     */
	public int updateClsnInfoMgmt(IA529001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateCaclMkstBassHist -----");
		return session.update("IA5290.updateClsnInfoMgmt", inParam);
	}

	/**
     * @brief 마감정보관리 수정
     * @details 마감정보관리 수정 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA529002IN
     * @return int
     */
	public int updateClsnInfoMgmt(IA529002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateCaclMkstBassHist -----");
		return session.update("IA5290.updateClsnInfoMgmt", inParam);
	}
	
	/**
     * @brief 마감정보관리 삭제
     * @details 마감정보관리 삭제 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA529001DTO
     * @return int
     */
	public int deleteClsnInfoMgmt(IA529001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteClsnInfoMgmt -----");
		return session.delete("IA5290.deleteClsnInfoMgmt", inParam);
	}

	/**
     * @brief 마감정보관리 삭제
     * @details 마감정보관리 삭제 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA529003IN
     * @return int
     */
	public int deleteClsnInfoMgmt(IA529003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteClsnInfoMgmt -----");
		return session.delete("IA5290.deleteClsnInfoMgmt", inParam);
	}

}
