/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5200DAO.java
 * @brief 임대차보증금 현재가치 산출내역 DAO
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
import com.encocns.ia.dto.IA520001DTO;
import com.encocns.ia.service.svo.IA520001IN;
import com.encocns.ia.service.svo.IA520002IN;
import com.encocns.ia.service.svo.IA520003IN;
import com.encocns.ia.service.svo.IA520004IN;

/**
 * @brief 임대차보증금 현재가치 산출내역 관리 DAO
 * @details 임대차보증금 현재가치 산출내역 관리 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5200DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5200DAO.class);

	@Autowired
    private SqlMapClient session;


	/**
     * @brief 임대차보증금 현재가치 자료 조회
     * @details 임대차보증금 현재가치 자료 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520001IN
     * @return List<IA520001DTO>
     */
    public List<IA520001DTO> selectListLnrnGrmnClcl(IA520001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLnrnGrmnClcl -----");
        return session.selectList("IA5200.selectListLnrnGrmnClcl", inParam);
    }


    /**
     * @brief 임대차보증금 현재가치 산출내역 등록 처리
     * @details 임대차보증금 현재가치 산출내역 등록 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520002IN
     * @return int
     */
	public int insertLnrnGrmnClcl(IA520002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLnrnGrmnClcl -----");
		return session.insert("IA5200.insertLnrnGrmnClcl", inParam);
	}

	/**
     * @brief 임대차보증금 현재가치 산출내역 변경 처리
     * @details 임대차보증금 현재가치 산출내역 변경 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520002IN
     * @return int
     */
	public int updateLnrnGrmnClcl(IA520002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateLnrnGrmnClcl -----");
		return session.update("IA5200.updateLnrnGrmnClcl", inParam);
	}

	/**
     * @brief 임대차보증금 현재가치 산출내역 삭제 처리
     * @details 임대차보증금 현재가치 산출내역 삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520003IN
     * @return int
     */
	public int deleteLnrnGrmnClcl(IA520003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLnrnGrmnClcl -----");
		return session.delete("IA5200.deleteLnrnGrmnClcl", inParam);
	}


	/**
     * @brief 임대차보증금 현재가치 산출내역 기초이월 삭제 처리
     * @details 임대차보증금 현재가치 산출내역 기초이월 삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int deleteLnrnGrmnClclAll(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLnrnGrmnClclAll -----");
		return session.delete("IA5200.deleteLnrnGrmnClclAll", inParam);
	}
	
	/**
     * @brief 기초 이월 임대차보증금 현재가치 산출내역
     * @details 기초 이월 임대차보증금 현재가치 산출내역
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int insertLnrnGrmnClclBass(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLnrnGrmnClclBass -----");
		return session.insert("IA5200.insertLnrnGrmnClclBass", inParam);
	}

	/**
     * @brief 임대차보증금현재가치산출내역 (  금액 산출 반영_월수 산출 ) 산출
     * @details 임대차보증금현재가치산출내역 (  금액 산출 반영_월수 산출 ) 산출
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int updatetLnrnGrmnClclClcl(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updatetLnrnGrmnClclClcl -----");
		return session.update("IA5200.updatetLnrnGrmnClclClcl", inParam);
	}

	/**
     * @brief 임대차보증금현재가치산출내역 (  금액 산출 반영) 산출
     * @details 임대차보증금현재가치산출내역 (  금액 산출 반영) 산출
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int updatetLnrnGrmnClclClclAmt(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updatetLnrnGrmnClclClclAmt -----");
		return session.update("IA5200.updatetLnrnGrmnClclClclAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역  삭제 처리
     * @details 분개데이터대상내역  삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int deleteCalcJrlzTrgtAmt(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("IA5200.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역 S06 등록 처리(임차보증금)
     * @details 분개데이터대상내역 S06  등록 처리(임차보증금)
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmt_S06(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt_S06 -----");
		return session.insert("IA5200.insertCalcJrlzTrgtAmt_S06", inParam);
	}
	
	/**
     * @brief 분개데이터대상내역 S09 등록 처리(임대보증금)
     * @details 분개데이터대상내역 S09 등록 처리(임대보증금)
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmt_S09(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt_S09 -----");
		return session.insert("IA5200.insertCalcJrlzTrgtAmt_S09", inParam);
	}

	/**
     * @brief 분개상세처리  삭제 처리
     * @details 분개상세처리  삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int deletejrlzDtlProcs(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5200.deletejrlzDtlProcs", inParam);
	}

	/**
     * @brief 분개상세처리 S06 등록 처리(임차보증금)
     * @details 분개상세처리 S06 등록 처리(임차보증금)
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int insertjrlzDtlProcs_S06(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs_S06 -----");
		return session.insert("IA5200.insertjrlzDtlProcs_S06", inParam);
	}
	
	/**
     * @brief 분개상세처리 S09 등록 처리(임대보증금)
     * @details 분개상세처리 S09 등록 처리(임대보증금)
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA520004IN
     * @return int
     */
	public int insertjrlzDtlProcs_S09(IA520004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs_S09 -----");
		return session.insert("IA5200.insertjrlzDtlProcs_S09", inParam);
	}
}
