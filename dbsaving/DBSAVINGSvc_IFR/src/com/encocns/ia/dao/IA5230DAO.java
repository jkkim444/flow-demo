/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5230DAO.java
 * @brief 임차시설물 복구충당부채 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
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
import com.encocns.ia.dto.IA523001DTO;
import com.encocns.ia.service.svo.IA523001IN;
import com.encocns.ia.service.svo.IA523002IN;
import com.encocns.ia.service.svo.IA523003IN;

/**
 * @brief 복구충당부채 산출내역 DAO
 * @details 복구충당부채 산출내역 DAO
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
@Repository
public class IA5230DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5230DAO.class);

	@Autowired
    private SqlMapClient session;

	
	/**
     * @brief 복구충당부채 산출내역 조회
     * @details 복구충당부채 산출내역 조회
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523001IN
     * @return List<IA523001DTO>
     */
    public List<IA523001DTO> selectListRcvrRsrvClcl(IA523001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRcvrRsrvClcl -----");
        return session.selectList("IA5230.selectListRcvrRsrvClcl", inParam);
    }


    /**
     * @brief 복구충당부채 산출내역 등록 처리
     * @details 복구충당부채 산출내역 등록 처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int insertRcvrRsrvClcl(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcvrRsrvClcl -----");
		return session.insert("IA5230.insertRcvrRsrvClcl", inParam);
	}

	/**
     * @brief 복구충당부채 산출내역 변경 처리
     * @details 복구충당부채 산출내역 변경 처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int updateRcvrRsrvClcl(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRcvrRsrvClcl -----");
		return session.update("IA5230.updateRcvrRsrvClcl", inParam);
	}

	/**
     * @brief 복구충당부채 산출내역 삭제 처리
     * @details 복구충당부채 산출내역 삭제 처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523003IN
     * @return int
     */
	public int deleteRcvrRsrvClcl(IA523003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcvrRsrvClcl -----");
		return session.delete("IA5230.deleteRcvrRsrvClcl", inParam);
	}

	/**
     * @brief 복구충당부채 기초 삭제  처리
     * @details 복구충당부채 기초 삭제  처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int deleteRcvrRsrvClclAll(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcvrRsrvClclAll -----");
		return session.delete("IA5230.deleteRcvrRsrvClclAll", inParam);
	}

	/**
     * @brief 복구충당부채 기초 생성  처리
     * @details 복구충당부채 기초 생성  처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int insertRcvrRsrvClclBass(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcvrRsrvClclBass -----");
		return session.insert("IA5230.insertRcvrRsrvClclBass", inParam);
	}

	/**
     * @brief 복구충당부채 산출 결과  처리
     * @details 복구충당부채 산출 결과  처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int updateRcvrRsrvClclrslt(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRcvrRsrvClclrslt -----");
		return session.update("IA5230.updateRcvrRsrvClclrslt", inParam);
	}
	
	
	/**
     * @brief 복구충당부채 산출 결과2  처리
     * @details 복구충당부채 산출 결과2  처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int updateRcvrRsrvClclrslt_2(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRcvrRsrvClclrslt_2 -----");
		return session.update("IA5230.updateRcvrRsrvClclrslt_2", inParam);
	}
	
	/**
     * @brief 분개데이터대상내역  삭제 처리
     * @details 분개데이터대상내역  삭제 처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int deleteCalcJrlzTrgtAmt(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("IA5230.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역  등록 처리
     * @details 분개데이터대상내역  등록 처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmt(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt -----");
		return session.insert("IA5230.insertCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터상세내역  삭제 처리
     * @details 분개데이터상세내역  삭제 처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int deletejrlzDtlProcs(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5230.deletejrlzDtlProcs", inParam);
	}

	/**
     * @brief 분개데이터상세내역  등록 처리
     * @details 분개데이터상세내역  등록 처리
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA523002IN
     * @return int
     */
	public int insertjrlzDtlProcs(IA523002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs -----");
		return session.insert("IA5230.insertjrlzDtlProcs", inParam);
	}



}
