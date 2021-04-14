/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5260DAO.java
 * @brief 수익증권 재무제표 DAO
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 19. | First Created
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
import com.encocns.ia.dto.IA526001DTO;
import com.encocns.ia.service.svo.IA526001IN;
import com.encocns.ia.service.svo.IA526002IN;
import com.encocns.ia.service.svo.IA526003IN;

/**
 * @brief 수익증권 재무제표 DAO
 * @details 수익증권 재무제표 DAO
 * @author : 이미래
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
@Repository
public class IA5260DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5260DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 수익증권 재무제표 조회
     * @details 수익증권 재무제표 조회 
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526001IN
     * @return List<IA526001DTO>
     */
    public List<IA526001DTO> selectListBncfFnst(IA526001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBncfFnst -----");
        return session.selectList("IA5260.selectListBncfFnst", inParam);
    }
    /**
     * @brief 수익증권 재무제표 등록
     * @details 수익증권 재무제표 등록
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526003IN
     * @return int 
     */
	public int insertBncfFnst(IA526003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertBncfFnst -----");
		return session.insert("IA5260.insertBncfFnst", inParam);
	}


    /**
     * @brief 수익증권 재무제표 수정
     * @details 수익증권 재무제표 수정
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526003IN
     * @return int 
     */
	public int updateBncfFnst(IA526003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateBncfFnst -----");
		return session.update("IA5260.updateBncfFnst", inParam);
	}
    /**
     * @brief 수익증권 재무제표(기준년월) 전체삭제
     * @details 수익증권 재무제표(기준년월) 전체삭제
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526002IN
     * @return int
     */
	public int deleteBncfFnstAll(IA526002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteBncfFnstAll -----");
		return session.delete("IA5260.deleteBncfFnstAll", inParam);
	}


    /**
     * @brief 수익증권 재무제표 선택 삭제
     * @details 수익증권 재무제표 선택 삭제
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526003IN
     * @return int
     */
	public int deleteBncfFnst(IA526003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteBncfFnst -----");
		return session.delete("IA5260.deleteBncfFnst", inParam);
	}
    /**
     * @brief 수익증권 재무제표 기초 생성
     * @details 수익증권 재무제표 기초 생성
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526002IN
     * @return int 
     */
	public int insertBncfFnstBass(IA526002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertBncfFnstBass -----");
		return session.insert("IA5260.insertBncfFnstBass", inParam);
	}

	/**
     * @brief 분개데이터대상내역  삭제 처리
     * @details 분개데이터대상내역  삭제 처리
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526002IN
     * @return int 
     */
	public int deleteCalcJrlzTrgtAmt(IA526002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("IA5260.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역  등록 처리
     * @details 분개데이터대상내역  등록 처리
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526002IN
     * @return int 
     */
	public int insertCalcJrlzTrgtAmt(IA526002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt -----");
		return session.insert("IA5260.insertCalcJrlzTrgtAmt", inParam);
	}
	
	/**
     * @brief 분개상세처리  삭제 처리
     * @details 분개상세처리  삭제 처리
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526002IN
     * @return int 
     */
	public int deletejrlzDtlProcs(IA526002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5260.deletejrlzDtlProcs", inParam);
	}

	
	/**
     * @brief 분개상세처리  등록 처리
     * @details 분개상세처리  등록 처리
     * @author : 이미래
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA526002IN
     * @return int 
     */
	public int insertjrlzDtlProcs(IA526002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs -----");
		return session.insert("IA5260.insertjrlzDtlProcs", inParam);
	}
}
