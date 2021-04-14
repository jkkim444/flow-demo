/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5170DAO.java
 * @brief 계리보고서 정보 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 14. | First Created
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
import com.encocns.ia.dto.IA517001DTO;
import com.encocns.ia.service.svo.IA517001IN;
import com.encocns.ia.service.svo.IA517002IN;
import com.encocns.ia.service.svo.IA517003IN;

/**
 * @brief 계리보고서 정보 DAO
 * @details 계리보고서 정보 DAO
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
@Repository
public class IA5170DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5170DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief 계리보고서 정보 내역 조회
     * @details 계리보고서 정보 내역 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517001IN
     * @return List<IA517001DTO>
     */
    public List<IA517001DTO> selectListAconRpt(IA517001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListAconRpt -----");
        return session.selectList("IA5170.selectListAconRpt", inParam);
    }
    
    
    /**
     * @brief 계리보고서 정보  등록 
     * @details 계리보고서 정보  등록 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517001DTO
     * @return int
     */
	public int insertAconRpt(IA517001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertAconRpt -----");
		return session.insert("IA5170.insertAconRpt", inParam);
	}

	/**
     * @brief 계리보고서 정보  삭제 
     * @details 계리보고서 정보  삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517002IN
     * @return int
     */
	public int deleteAconRpt(IA517002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteAconRpt -----");
		return session.delete("IA5170.deleteAconRpt", inParam);
	}
	/**
     * @brief 분개데이터대상내역  삭제 
     * @details 분개데이터대상내역  삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517003IN
     * @return int
     */
	public int deleteCalcJrlzTrgtAmt(IA517003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("IA5170.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역  등록 
     * @details 분개데이터대상내역  등록
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517003IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmt(IA517003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt -----");
		return session.delete("IA5170.insertCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터상세내역  삭제 
     * @details 분개데이터상세내역  삭제 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517003IN
     * @return int
     */
	public int deletejrlzDtlProcs(IA517003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5170.deletejrlzDtlProcs", inParam);
	}

	/**
     * @brief 분개데이터상세내역  등록 
     * @details 분개데이터상세내역  등록
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517003IN
     * @return int
     */
	public int insertjrlzDtlProcs(IA517003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs -----");
		return session.delete("IA5170.insertjrlzDtlProcs", inParam);
	}

}
