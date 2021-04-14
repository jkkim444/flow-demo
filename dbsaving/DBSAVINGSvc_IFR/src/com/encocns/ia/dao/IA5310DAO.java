/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5310DAO.java
 * @brief 리스부채사용권관리 DAO
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 9. 24. | First Created
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
import com.encocns.ia.dto.IA531001DTO;
import com.encocns.ia.service.svo.IA531001IN;
import com.encocns.ia.service.svo.IA531002IN;
import com.encocns.ia.service.svo.IA531003IN;

/**
 * @brief 리스부채사용권관리 DAO
 * @details 리스부채사용권관리 DAO
 * @author : 이미래
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
@Repository
public class IA5310DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5310DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 리스부채사용권관리 조회
     * @details 리스부채사용권관리 조회
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531001IN
     * @return List<IA531001DTO>
     */
    public List<IA531001DTO> selectListLeasDbtlUz(IA531001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLeasDbtlUz -----");
        return session.selectList("IA5310.selectListLeasDbtlUz", inParam);
    }

    /**
     * @brief 리스부채사용권관리 기준년월 삭제
     * @details 리스부채사용권관리 기준년월 삭제
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int deleteLeasDbtlUzAll(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLeasDbtlUzAll -----");
		return session.delete("IA5310.deleteLeasDbtlUzAll", inParam);
	}
	
	/**
     * @brief 기초자료 생성 리스부채사용권관리 등록
     * @details 기초자료 생성 리스부채사용권관리 등록
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int insertLeasDbtlUzBass(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLeasDbtlUzBass -----");
		return session.insert("IA5310.insertLeasDbtlUzBass", inParam);
	}

	/**
     * @brief 리스부채사용권관리 등록
     * @details 리스부채사용권관리 등록
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int insertLeasDbtlUz(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLeasDbtlUz -----");
		return session.insert("IA5310.insertLeasDbtlUz", inParam);
	}

	/**
     * @brief 리스부채사용권관리 수정
     * @details 리스부채사용권관리 수정
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int updateLeasDbtlUz(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateLeasDbtlUz -----");
		return session.update("IA5310.updateLeasDbtlUz", inParam);
	}
	
	/**
     * @brief 리스부채사용권관리 엑셀업로드
     * @details 리스부채사용권관리 내역 등록
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int updateLeasDbtlUzExcel(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateLeasDbtlUzExcel -----");
		return session.update("IA5310.updateLeasDbtlUzExcel", inParam);
	}

	/**
     * @brief 리스부채사용권관리 삭제
     * @details 리스부채사용권관리 삭제
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531003IN
     * @return int
     */
	public int deleteLeasDbtlUz(IA531003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLeasDbtlUz -----");
		return session.delete("IA5310.deleteLeasDbtlUz", inParam);
	}

	/**
     * @brief 분개데이터대상내역  삭제 처리
     * @details 분개데이터대상내역  삭제 처리
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int deleteCalcJrlzTrgtAmt(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("IA5310.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역  등록 처리 1
     * @details 분개데이터대상내역  등록 처리 1
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmt_1(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt_1 -----");
		return session.insert("IA5310.insertCalcJrlzTrgtAmt_1", inParam);
	}
	
	/**
     * @brief 분개데이터대상내역  등록 처리 2
     * @details 분개데이터대상내역  등록 처리 2
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmt_2(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt_2 -----");
		return session.insert("IA5310.insertCalcJrlzTrgtAmt_2", inParam);
	}
	
	/**
     * @brief 분개데이터대상내역  등록 처리 3
     * @details 분개데이터대상내역  등록 처리 3
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmt_3(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt_3 -----");
		return session.insert("IA5310.insertCalcJrlzTrgtAmt_3", inParam);
	}
	
	/**
     * @brief 분개상세처리  삭제 처리
     * @details 분개상세처리  삭제 처리
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int deletejrlzDtlProcs(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5310.deletejrlzDtlProcs", inParam);
	}
	
	/**
     * @brief 분개상세처리  등록 처리
     * @details 분개상세처리  등록 처리
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA531002IN
     * @return int
     */
	public int insertjrlzDtlProcs(IA531002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs -----");
		return session.insert("IA5310.insertjrlzDtlProcs", inParam);
	}
}
