/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2080DAO.java
 * @brief 대손충당금대상 관리 DAO
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
import com.encocns.ip.dto.IP208001DTO;
import com.encocns.ip.dto.IP208002DTO;
import com.encocns.ip.dto.IP208003DTO;
import com.encocns.ip.service.svo.IP208001IN;
import com.encocns.ip.service.svo.IP208002IN;


/**
 * @brief 대손충당금대상 관리 DAO
 * @details 대손충당금대상 관리 DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2080DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2080DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 대손충당금대상 목록 조회(전체)
     * @details 대손충당금대상 목록 조회(전체)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208001IN
     * @return List<IP208001DTO>
     */
    public List<IP208001DTO> selectListBadlnRsrv(IP208001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBadlnRsrv -----");
        return session.selectList("IP2080.selectListBadlnRsrv", inParam);
    }

    /**
     * @brief 대손충당금대상 목록 페이징 건수 조회
     * @details 대손충당금대상 목록 페이징 건수 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208001IN
     * @return int
     */
    public int selectTotalCount ( IP208001IN inParam ) {
        return session.selectOne("IP2080.selectTotalCount", inParam);
    }

    /**
     * @brief 대손충당금대상 목록 조회(페이징)
     * @details 대손충당금대상 목록 조회(페이징)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208001IN
     * @return List<IP208001DTO>
     */
    public List<IP208001DTO> selectPaging( IP208001IN inParam ) {
        return session.selectList("IP2080.selectPaging", inParam);
    }

    /**
     * @brief 대손충당금대상 목록 조회(페이징)
     * @details 대손충당금대상 목록 조회(페이징)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208001IN
     * @return List<IP208001DTO>
     */
    public List<IP208002DTO> selectListBadlnRsrvExcl(IP208001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBadlnRsrvExcl -----");
        return session.selectList("IP2080.selectListBadlnRsrvExcl", inParam);
    }

    /**
     * @brief 대손충당금대상 기초 이월 생성
     * @details 대손충당금대상 기초 이월 생성
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int insertBadlnRsrvBass(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertBadlnRsrvBass -----");
		return session.insert("IP2080.insertBadlnRsrvBass", inParam);
	}

    /**
     * @brief 대손충당금대상 타사연체 등록
     * @details 대손충당금대상 타사연체 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int insertOtcpOvrdBass(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertOtcpOvrdBass -----");
		return session.insert("IP2080.insertOtcpOvrdBass", inParam);
	}

    /**
     * @brief 대손충당금대상 기초이월 전 삭제
     * @details 대손충당금대상 기초이월 전 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int deleteBadlnRsrvAll(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteBadlnRsrvAll -----");
		return session.delete("IP2080.deleteBadlnRsrvAll", inParam);
	}

    /**
     * @brief 대손충당금대상 타사연체 등록 전 삭제
     * @details 대손충당금대상 타사연체 등록 전 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int deleteOtcpOvrdAll(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteOtcpOvrdAll -----");
		return session.delete("IP2080.deleteOtcpOvrdAll", inParam);
	}

    /**
     * @brief LifetimePD산출내역 삭제
     * @details LifetimePD산출내역 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int deleteLtpdclclhistAll(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLtpdclclhistAll -----");
		return session.delete("IP2080.deleteLtpdclclhistAll", inParam);
	}

    /**
     * @brief 대손충당금산출내역 삭제
     * @details 대손충당금산출내역 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int deleteLsrsrvclclhistAll(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLsrsrvclclhistAll -----");
		return session.delete("IP2080.deleteLsrsrvclclhistAll", inParam);
	}

    /**
     * @brief 대손충당금 건별요약 삭제
     * @details 대손충당금 건별요약 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int deleteBadlnrsrvpcsebrfAll(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteBadlnrsrvpcsebrfAll -----");
		return session.delete("IP2080.deleteBadlnrsrvpcsebrfAll", inParam);
	}

    /**
     * @brief 대손충당금 요약 삭제
     * @details 대손충당금 요약 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int deleteBadlnrsrvbrfAll(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteBadlnrsrvbrfAll -----");
		return session.delete("IP2080.deleteBadlnrsrvbrfAll", inParam);
	}

    /**
     * @brief 대손충당금 오류 검증
     * @details 대손충당금 오류 검증
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int updateBadlnRsrvErr(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateBadlnRsrvErr -----");
		return session.update("IP2080.updateBadlnRsrvErr", inParam);
	}

    /**
     * @brief 타사 연체 여부 처리
     * @details 타사 연체 여부 처리
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return int
     */
	public int updatetOtcpOvrdYn(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updatetOtcpOvrdYn -----");
		return session.update("IP2080.updatetOtcpOvrdYn", inParam);
	}

	/**
	 * @brief 개별평가 여부 처리
	 * @details 개별평가 여부 처리
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
	 * @param IP208002IN
	 * @return int
	 */
	public int updateIndvTrevYn(IP208002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateIndvTrevYn -----");
		return session.update("IP2080.updateIndvTrevYn", inParam);
	}

    /**
     * @brief 타사 연체 여부 엑셀업로드
     * @details 타사 연체 여부 엑셀업로드
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208003DTO
     * @return int
     */
	public int updatetOtinovrdhist(IP208003DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updatetOtinovrdhist -----");
		return session.update("IP2080.updatetOtinovrdhist", inParam);
	}

}
