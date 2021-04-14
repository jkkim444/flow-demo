/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5300DAO.java
 * @brief 수정분개관리 DAO
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 28. | First Created
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
import com.encocns.ia.dto.IA530001DTO;
import com.encocns.ia.service.svo.IA530001IN;
import com.encocns.ia.service.svo.IA530002IN;
import com.encocns.ia.service.svo.IA530003IN;

/**
 * @brief 수정분개관리 DAO
 * @details 수정분개관리 DAO
 * @author : 이미래
 * @date : 2020. 10. 28.
 * @version : 1.0.0
 */
@Repository
public class IA5300DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5300DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief 수정분개관리  요약 내역 조회
     * @details 수정분개관리  요약 내역 조회
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530001IN
     * @return ArrayList<IA530001DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<IA530001DTO> selectListAmndJrlzHist(IA530001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListAmndJrlzHist -----");
        return (ArrayList)session.selectList("IA5300.selectListAmndJrlzHist", inParam);
    }


    /**
     * @brief 수정분개관리 등록
     * @details 수정분개관리 등록
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530002IN
     * @return int
     */
	public int insertAmndJrlzHist(IA530002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertAmndJrlzHist -----");
		return session.insert("IA5300.insertAmndJrlzHist", inParam);
	}

    /**
     * @brief 수정분개관리 수정
     * @details 수정분개관리 수정
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530002IN
     * @return int
     */
	public int updateAmndJrlzHist(IA530002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateAmndJrlzHist -----");
		return session.update("IA5300.updateAmndJrlzHist", inParam);
	}


	/**
     * @brief 수정분개관리 삭제
     * @details 수정분개관리 삭제
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530003IN
     * @return int
     */
	public int deleteAmndJrlzHist(IA530003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteAmndJrlzHist -----");
		return session.delete("IA5300.deleteAmndJrlzHist", inParam);
	}
	
	/**
     * @brief 수정분개 기초 등록
     * @details 수정분개 기초 등록
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530001IN
     * @return int
     */
	public int insertAmndJrlzHistBass(IA530001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertAmndJrlzHistBass -----");
		return session.insert("IA5300.insertAmndJrlzHistBass", inParam);
	}
	
	/**
     * @brief 수정 분개 기초 삭제
     * @details 수정 분개 기초 삭제
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530001IN
     * @return int
     */
	public int deleteAmndJrlzHistBass(IA530001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteAmndJrlzHistBass -----");
		return session.delete("IA5300.deleteAmndJrlzHistBass", inParam);
	}
	
	/**
     * @brief 수정분개 산출
     * @details 수정분개 산출
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530002IN
     * @return int
     */
	public int insertjrlzDtlProcs(IA530002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs -----");
		return session.insert("IA5300.insertjrlzDtlProcs", inParam);
	}
	
	/**
     * @brief 수정분개 산출전 삭제
     * @details 수정분개 산출전 삭제
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530002IN
     * @return int
     */
	public int deletejrlzDtlProcs(IA530002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5300.deletejrlzDtlProcs", inParam);
	}
	
	/**
     * @brief 분개상세처리 (법인세비용 / 이연법인세부채(비유동) 일괄 인식) 산출
     * @details 분개상세처리 (법인세비용 / 이연법인세부채(비유동) 일괄 인식) 산출
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530002IN
     * @return int
     */
	public int insertjrlzDtlProcs_1(IA530002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs_1 -----");
		return session.insert("IA5300.insertjrlzDtlProcs_1", inParam);
	}
	
	/**
     * @brief 분개상세처리 (법인세비용 / 이연법인세부채(비유동) 일괄 인식) 산출
     * @details 분개상세처리 (법인세비용 / 이연법인세부채(비유동) 일괄 인식) 산출
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530002IN
     * @return int
     */
	public int insertjrlzDtlProcs_2(IA530002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs_2 -----");
		return session.insert("IA5300.insertjrlzDtlProcs_2", inParam);
	}
	
	
}
