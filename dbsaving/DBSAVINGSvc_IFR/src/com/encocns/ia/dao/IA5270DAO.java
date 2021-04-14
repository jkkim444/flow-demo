/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5270DAO.java
 * @brief 유가증권처분내역 DAO
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 08. 
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
import com.encocns.ia.dto.IA527001DTO;
import com.encocns.ia.dto.IA527002DTO;
import com.encocns.ia.service.svo.IA527001IN;

/**
 * @brief 유가증권처분내역  DAO
 * @details 유가증권처분내역 DAO
 * @author : 이미래
 * @date : 2020. 10. 08.
 * @version : 1.0.0
 */
@Repository
public class IA5270DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5270DAO.class);

	@Autowired
    private SqlMapClient session;
	
	/**
     * @brief 유가증권처분내역  요약 내역 조회 건수
     * @details 유가증권처분내역  요약 내역 조회 건수 
     * @author : 이미래
     * @date : 2020. 10. 08.
     * @version : 1.0.0
     * @param IA527001IN
     * @return int
     */
	public int selectTotalCount ( IA527001IN inParam ) {
        return session.selectOne("IA5270.selectTotalCount", inParam);
    }
	
	/**
     * @brief 유가증권처분내역  요약 내역 조회
     * @details 유가증권처분내역  요약 내역 조회 
     * @author : 이미래
     * @date : 2020. 10. 08.
     * @version : 1.0.0
     * @param IA527001IN
     * @return ArrayList<IA527001DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<IA527001DTO> selectListMkstDspslBrf(IA527001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListMkstDspslBrf -----");
        return (ArrayList)session.selectList("IA5270.selectListMkstDspslBrf", inParam);
    }

    /**
     * @brief 유가증권처분 건별 엑셀 다운
     * @details 유가증권처분 건별 엑셀 다운 
     * @author : 이미래
     * @date : 2020. 10. 08.
     * @version : 1.0.0
     * @param IA527001IN
     * @return ArrayList<IA527002DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<IA527002DTO> selectListMkstDspslHist(IA527001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListMkstDspslHist -----");
        return (ArrayList)session.selectList("IA5270.selectListMkstDspslHist", inParam);
    }
    
    /**
     * @brief 유가증권기초내역 존재 여부 조회
     * @details 유가증권기초내역 존재 여부 조회 
     * @author : 이미래
     * @date : 2020. 10. 08.
     * @version : 1.0.0
     * @param IA527002DTO
     * @return IA527002DTO
     */
    public IA527002DTO selectMkstBassExisYn ( IA527002DTO inParam ) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMkstBassExisYn -----");
    	return session.selectOne("IA5270.selectMkstBassExisYn", inParam);
    }
    
    /**
     * @brief 유가증권처분내역 등록 처리(kgaap 내역 생성)
     * @details 유가증권처분내역 등록 처리(kgaap 내역 생성) 
     * @author : 이미래
     * @date : 2020. 10. 08.
     * @version : 1.0.0
     * @param IA527002DTO
     * @return int
     */
	public int insertMkstDspslHistKgaap(IA527002DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstDspslHistKgaap -----");
		return session.insert("IA5270.insertMkstDspslHistKgaap", inParam);
	}

	/**
     * @brief 유가증권처분내역 삭제 처리
     * @details 유가증권처분내역 삭제 처리 
     * @author : 이미래
     * @date : 2020. 10. 08.
     * @version : 1.0.0
     * @param IA527002DTO
     * @return int
     */
	public int deleteMkstDspslHist(IA527002DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteMkstDspslHist -----");
		return session.delete("IA5270.deleteMkstDspslHist", inParam);
	}

	
	/**
     * @brief 유가증권처분 요약 (KGAP / IFRS ) 등록 처리
     * @details 유가증권처분 요약 (KGAP / IFRS ) 등록 처리 
     * @author : 이미래
     * @date : 2020. 10. 08.
     * @version : 1.0.0
     * @param IA527002DTO
     * @return int
     */
	public int insertMkstDspslBrf(IA527002DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstDspslBrf -----");
		return session.insert("IA5270.insertMkstDspslBrf", inParam);
	}
}
