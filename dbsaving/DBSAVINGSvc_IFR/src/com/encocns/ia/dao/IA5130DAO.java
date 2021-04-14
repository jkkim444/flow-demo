/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5130DAO.java
 * @brief 기타유형자산 DAO
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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ia.dto.IA513001DTO;
import com.encocns.ia.service.svo.IA513001IN;
import com.encocns.ia.service.svo.IA513002IN;
import com.encocns.ia.service.svo.IA513003IN;

/**
 * @brief 기타유형자산 DAO
 * @details 기타유형자산 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5130DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5130DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 기타유형자산 조회  
     * @details 기타유형자산 조회  
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513001IN
     * @return List<IA513001DTO>
     */
    public List<IA513001DTO> selectListEtcTypAsetDprc(IA513001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListEtcTypAsetDprc -----");
        return session.selectList("IA5130.selectListEtcTypAsetDprc", inParam);
    }

    /**
     * @brief 기타유형자산 조회 총 갯수
     * @details 기타유형자산 조회 총 갯수
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513001IN
     * @return int
     */
    public int selectTotalCount ( IA513001IN inParam ) {
        return session.selectOne("IA5130.selectTotalCount", inParam);
    }

    /**
     * @brief 기타유형자산 조회 페이징 처리
     * @details 기타유형자산 조회 페이징 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513001IN
     * @return List<IA513001DTO>
     */
    public List<IA513001DTO> selectPaging( IA513001IN inParam ) {
        return session.selectList("IA5130.selectPaging", inParam);
    }
    /**
     * @brief 기타유형자산 기준년월 삭제
     * @details 기타유형자산 기준년월 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513002IN
     * @return int 
     */
	public int deleteEtcTypAsetDprcAll(IA513002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEtcTypAsetDprcAll -----");
		return session.delete("IA5130.deleteEtcTypAsetDprcAll", inParam);
	}
    /**
     * @brief 기초자료 생성 기타유형자산 List insert
     * @details 기타유형자산 List insert
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513002IN
     * @return int 
     */
	public int insertEtcTypAsetDprcBass(IA513002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEtcTypAsetDprcBass -----");
		return session.insert("IA5130.insertEtcTypAsetDprcBass", inParam);
	}


    /**
     * @brief 기타유형자산 등록
     * @details 기타유형자산 등록
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513002IN
     * @return int
     */
	public int insertEtcTypAsetDprc(IA513002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEtcTypAsetDprc -----");
		return session.insert("IA5130.insertEtcTypAsetDprc", inParam);
	}


    /**
     * @brief 기타유형자산 수정
     * @details 기타유형자산 수정
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513002IN
     * @return int
     */
	public int updateEtcTypAsetDprc(IA513002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateEtcTypAsetDprc -----");
		return session.update("IA5130.updateEtcTypAsetDprc", inParam);
	}

    /**
     * @brief 기타유형자산 List Delete
     * @details 기타유형자산 List Delete
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513003IN
     * @return int
     */
	public int deleteEtcTypAsetDprc(IA513003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEtcTypAsetDprc -----");
		return session.delete("IA5130.deleteEtcTypAsetDprc", inParam);
	}

	/**
     * @brief 상각누계 금액 산출
     * @details 상각누계 금액 산출
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513002IN
     * @return int 
     */
	public int updateDprcCmtlClcl(IA513002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateDprcCmtlClcl -----");
		return session.update("IA5130.updateDprcCmtlClcl", inParam);
	}

	/**
     * @brief 분개데이터대상내역  삭제 처리
     * @details 분개데이터대상내역  삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513002IN
     * @return int
     */
	public int deleteCalcJrlzTrgtAmt(IA513002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("IA5130.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역  등록 처리
     * @details 분개데이터대상내역  등록 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513002IN
     * @return int 
     */
	public int insertCalcJrlzTrgtAmt(IA513002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt -----");
		return session.insert("IA5130.insertCalcJrlzTrgtAmt", inParam);
	}
	/**
     * @brief 분개상세처리  삭제 처리
     * @details 분개상세처리  삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513002IN
     * @return int
     */
	public int deletejrlzDtlProcs(IA513002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5130.deletejrlzDtlProcs", inParam);
	}

	/**
     * @brief 분개상세처리  등록 처리
     * @details 분개상세처리  등록 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA513002IN
     * @return int 
     */
	public int insertjrlzDtlProcs(IA513002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs -----");
		return session.insert("IA5130.insertjrlzDtlProcs", inParam);
	}
}
