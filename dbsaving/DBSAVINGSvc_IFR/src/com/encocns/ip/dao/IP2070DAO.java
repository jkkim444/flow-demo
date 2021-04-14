/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2070DAO.java
 * @brief 예치금대손충당금 관리 DAO
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
import com.encocns.ip.dto.IP207001DTO;
import com.encocns.ip.service.svo.IP207001IN;
import com.encocns.ip.service.svo.IP207002IN;
import com.encocns.ip.service.svo.IP207003IN;
import com.encocns.ip.service.svo.IP207004IN;


/**
 * @brief 예치금대손충당금 관리 DAO
 * @details 예치금대손충당금 관리 DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2070DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2070DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 예치금대손충당금 목록 조회(전체)
     * @details 예치금대손충당금 목록 조회(전체)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207001IN
     * @return List<IP207001DTO>
     */
    public List<IP207001DTO> selectListDsmnTrgt(IP207001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListDsmnTrgt -----");
        return session.selectList("IP2070.selectListDsmnTrgt", inParam);
    }

    /**
     * @brief 예치금대손충당금 목록 페이징 건수 조회
     * @details 예치금대손충당금 목록 페이징 건수 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207001IN
     * @return int
     */
    public int selectTotalCount ( IP207001IN inParam ) {
        return session.selectOne("IP2070.selectTotalCount", inParam);
    }

    /**
     * @brief 예치금대손충당금 목록 조회(페이징)
     * @details 예치금대손충당금 목록 조회(페이징)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207001IN
     * @return List<IP207001DTO>
     */
    public List<IP207001DTO> selectPaging( IP207001IN inParam ) {
        return session.selectList("IP2070.selectPaging", inParam);
    }

    /**
     * @brief 예치금대손충당금 정보 등록
     * @details 예치금대손충당금 정보 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207002IN
     * @return int
     */
	public int insertDsmnTrgt(IP207002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertDsmnTrgt -----");
		return session.insert("IP2070.insertDsmnTrgt", inParam);
	}

	/**
     * @brief 예치금대손충당금 정보 변경
     * @details 예치금대손충당금 정보 변경
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207002IN
     * @return int
     */
	public int updateDsmnTrgt(IP207002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateDsmnTrgt -----");
		return session.update("IP2070.updateDsmnTrgt", inParam);
	}

	/**
     * @brief 예치금대손충당금 정보 삭제
     * @details 예치금대손충당금 정보 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207003IN
     * @return int
     */
	public int deleteDsmnTrgt(IP207003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteDsmnTrgt -----");
		return session.delete("IP2070.deleteDsmnTrgt", inParam);
	}

	/**
     * @brief 예치금대손충당금 산출
     * @details 예치금대손충당금 산출
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP207004IN
     * @return int
     */
	public int updateDsmnTrgtClcl(IP207004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateDsmnTrgtClcl -----");
		return session.update("IP2070.updateDsmnTrgtClcl", inParam);
	}
}
