/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5150DAO.java
 * @brief 수익용 부동산 DAO
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
import com.encocns.ia.dto.IA515001DTO;
import com.encocns.ia.service.svo.IA515001IN;
import com.encocns.ia.service.svo.IA515002IN;
import com.encocns.ia.service.svo.IA515003IN;
import com.encocns.ia.service.svo.IA515004IN;

/**
 * @brief 수익용 부동산 보유 현황 DAO
 * @details 수익용 부동산 보유 현황 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5150DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5150DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 수익용 부동산 목록 조회
     * @details 수익용 부동산 목록 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515001IN
     * @return List<IA515001DTO>
     */
    public List<IA515001DTO> selectListEarnRlesHold(IA515001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListEarnRlesHold -----");
        return session.selectList("IA5150.selectListEarnRlesHold", inParam);
    }


    /**
     * @brief 수익용 부동산 등록
     * @details 수익용 부동산 등록
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515002IN
     * @return int 
     */
	public int insertEarnRlesHold(IA515002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEarnRlesHold -----");
		return session.insert("IA5150.insertEarnRlesHold", inParam);
	}

	/**
     * @brief 수익용 부동산 수정
     * @details 수익용 부동산 수정
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515002IN
     * @return int 
     */
	public int updateEarnRlesHold(IA515002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateEarnRlesHold -----");
		return session.update("IA5150.updateEarnRlesHold", inParam);
	}

    /**
     * @brief 수익용 부동산 삭제
     * @details 수익용 부동산 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515003IN
     * @return int
     */
	public int deleteEarnRlesHold(IA515003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEarnRlesHold -----");
		return session.delete("IA5150.deleteEarnRlesHold", inParam);
	}

    /**
     * @brief 기초 이월 수익용 부동산 보유 삭제
     * @details 기초 이월 수익용 부동산 보유 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515004IN
     * @return int 
     */
	public int deleteEarnRlesHoldAll(IA515004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEarnRlesHoldAll -----");
		return session.delete("IA5150.deleteEarnRlesHoldAll", inParam);
	}
	
	/**
     * @brief 기초 이월 수익용 부동산 보유
     * @details 기초 이월 수익용 부동산 보유
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515004IN
     * @return int
     */
	public int insertEarnRlesHoldBass(IA515004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEarnRlesHoldBass -----");
		return session.delete("IA5150.insertEarnRlesHoldBass", inParam);
	}

	/**
     * @brief 수익용 부동산 보유 (금액 산출 반영) 산출
     * @details 수익용 부동산 보유 (금액 산출 반영) 산출
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515004IN
     * @return int
     */
	public int updateEarnRlesHoldClcl(IA515004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateEarnRlesHoldClcl -----");
		return session.delete("IA5150.updateEarnRlesHoldClcl", inParam);
	}

	/**
     * @brief 분개데이터대상내역  삭제 처리
     * @details 분개데이터대상내역  삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515004IN
     * @return int 
     */
	public int deleteCalcJrlzTrgtAmt(IA515004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("IA5150.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역  등록 처리
     * @details 분개데이터대상내역  등록 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515004IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmt(IA515004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt -----");
		return session.delete("IA5150.insertCalcJrlzTrgtAmt", inParam);
	}
	
	/**
     * @brief 분개상세처리  삭제 처리
     * @details 분개상세처리  삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515004IN
     * @return int
     */
	public int deletejrlzDtlProcs(IA515004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5150.deletejrlzDtlProcs", inParam);
	}

	
	/**
     * @brief 분개상세처리  등록 처리
     * @details 분개상세처리  등록 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA515004IN
     * @return int
     */
	public int insertjrlzDtlProcs(IA515004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs -----");
		return session.delete("IA5150.insertjrlzDtlProcs", inParam);
	}
}
