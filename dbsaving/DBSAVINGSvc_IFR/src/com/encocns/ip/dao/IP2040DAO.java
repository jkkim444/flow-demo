/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2040DAO.java
 * @brief 개별평가대상 관리 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.dao
 * @brief Common DAO Package
 */
package com.encocns.ip.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ip.dto.IP204001DTO;
import com.encocns.ip.service.svo.IP204001IN;
import com.encocns.ip.service.svo.IP204002IN;
import com.encocns.ip.service.svo.IP204003IN;


/**
 * @brief 개별평가대상 관리 DAO
 * @details 개별평가대상 관리 DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2040DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2040DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 개별평가대상 목록 조회(전체)
     * @details 개별평가대상 목록 조회(전체)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204001IN
     * @return List<IP204001DTO>
     */
    public List<IP204001DTO> selectListIndvEvalTrgt(IP204001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIndvEvalTrgt -----");
        return session.selectList("IP2040.selectListIndvEvalTrgt", inParam);
    }

    /**
     * @brief 개별평가대상 목록 페이징 건수 조회
     * @details 개별평가대상 목록 페이징 건수 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204001IN
     * @return int
     */
    public int selectTotalCount ( IP204001IN inParam ) {
        return session.selectOne("IP2040.selectTotalCount", inParam);
    }

    /**
     * @brief 개별평가대상 목록 조회(페이징)
     * @details 개별평가대상 목록 조회(페이징)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204001IN
     * @return List<IP204001DTO>
     */
    public List<IP204001DTO> selectPaging( IP204001IN inParam ) {
        return session.selectList("IP2040.selectPaging", inParam);
    }

    /**
     * @brief 개별평가대상 정보 등록
     * @details 개별평가대상 정보 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return int
     */
	public int insertIndvEvalTrgt(IP204002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIndvEvalTrgt -----");
		return session.insert("IP2040.insertIndvEvalTrgt", inParam);
	}

    /**
     * @brief 개별평가대상 정보 변경
     * @details 개별평가대상 정보 변경
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return int
     */
	public int updateIndvEvalTrgt(IP204002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateIndvEvalTrgt -----");
		return session.update("IP2040.updateIndvEvalTrgt", inParam);
	}

    /**
     * @brief 충당금 기본 계좌번호 조회
     * @details 충당금 기본 계좌번호 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return int
     */
	public int selectChkLnrnlsrsrvtrgtbsic(IP204002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectChkLnrnlsrsrvtrgtbsic -----");
		return session.selectOne("IP2040.selectChkLnrnlsrsrvtrgtbsic", inParam);
	}

    /**
     * @brief 충당금 기본에 개별평가 여부 등록
     * @details 충당금 기본에 개별평가 여부 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return int
     */
	public int updateBadlnRsrvIndvEvalTrgt(IP204002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateBadlnRsrvIndvEvalTrgt -----");
		return session.update("IP2040.updateBadlnRsrvIndvEvalTrgt", inParam);
	}

    /**
     * @brief 개별평가대상 정보 삭제
     * @details 개별평가대상 정보 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204003IN
     * @return int
     */
	public int deleteIndvEvalTrgt(IP204003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIndvEvalTrgt -----");
		return session.delete("IP2040.deleteIndvEvalTrgt", inParam);
	}

    /**
     * @brief 개별평가대상 정보 엑셀업로드 전 삭제
     * @details 개별평가대상 정보 엑셀업로드 전 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204001DTO
     * @return int
     */
	public int deleteIndvEvalTrgtExcl(IP204001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIndvEvalTrgt -----");
		return session.delete("IP2040.deleteIndvEvalTrgtExcl", inParam);
	}

    /**
     * @brief 개별평가대상 정보 엑셀업로드
     * @details 개별평가대상 정보 엑셀업로드
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return int
     */
	public int insertIndvEvalTrgtExcl(IP204002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIndvEvalTrgt -----");
		return session.insert("IP2040.insertIndvEvalTrgtExcl", inParam);
	}

    /**
     * @brief 개별평가대상 계좌번호 조회
     * @details 개별평가대상 계좌번호 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return List<IP204001DTO>
     */
	public List<IP204001DTO> selectIndvEvalTrgtBass(IP204002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectIndvEvalTrgtBass -----");
		return session.selectList("IP2040.selectIndvEvalTrgtBass", inParam);
	}

    /**
     * @brief 개별평가대상 기초 이월 전 삭제
     * @details 개별평가대상 기초 이월 전 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return int
     */
	public int deleteIndvEvalTrgtBass(IP204002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIndvEvalTrgtBass -----");
		return session.delete("IP2040.deleteIndvEvalTrgtBass", inParam);
	}

    /**
     * @brief 개별평가대상 기초 이월 생성
     * @details 개별평가대상 기초 이월 생성
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP204002IN
     * @return int
     */
	public int insertIndvEvalTrgtBass(IP204002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIndvEvalTrgtBass -----");
		return session.insert("IP2040.insertIndvEvalTrgtBass", inParam);
	}

}
