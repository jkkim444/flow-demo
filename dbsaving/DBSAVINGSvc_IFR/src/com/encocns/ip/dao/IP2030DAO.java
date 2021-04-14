/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2030DAO.java
 * @brief NICE PD관리 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 1. | First Created
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
import com.encocns.ip.dto.IP203001DTO;
import com.encocns.ip.dto.IP203002DTO;
import com.encocns.ip.service.svo.IP203001IN;
import com.encocns.ip.service.svo.IP203002IN;
import com.encocns.ip.service.svo.IP203003IN;


/**
 * @brief NICE PD관리 DAO
 * @details NICE PD관리 DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2030DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2030DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief NICE PD 목록 조회(전체)
     * @details NICE PD 목록 조회(전체)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP203001IN
     * @return List<IP203001DTO>
     */
    public List<IP203001DTO> selectListRcNicePdRflc(IP203001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRcNicePdRflc -----");
        return session.selectList("IP2030.selectListRcNicePdRflc", inParam);
    }

    /**
     * @brief NICE PD 목록 페이징 건수 조회
     * @details NICE PD 목록 페이징 건수 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP203001IN
     * @return int
     */
    public int selectTotalCount ( IP203001IN inParam ) {
        return session.selectOne("IP2030.selectTotalCount", inParam);
    }

    /**
     * @brief NICE PD 목록 조회(페이징)
     * @details NICE PD 목록 조회(페이징)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP203001IN
     * @return List<IP203001DTO>
     */
    public List<IP203001DTO> selectPaging( IP203001IN inParam ) {
        return session.selectList("IP2030.selectPaging", inParam);
    }

    /**
     * @brief NICE PD 정보 등록
     * @details NICE PD 정보 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP203002IN
     * @return int
     */
	public int insertRcNicePdRflc(IP203002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcLgdRflc -----");
		return session.insert("IP2030.insertRcNicePdRflc", inParam);
	}

    /**
     * @brief NICE PD 정보 변경
     * @details NICE PD 정보 변경
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP203002IN
     * @return int
     */
	public int updateRcNicePdRflc(IP203002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRcLgdRflc -----");
		return session.update("IP2030.updateRcNicePdRflc", inParam);
	}


    /**
     * @brief NICE PD 정보 삭제
     * @details NICE PD 정보 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP203003IN
     * @return int
     */
	public int deleteRcNicePdRflc(IP203003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcLgdRflc -----");
		return session.delete("IP2030.deleteRcNicePdRflc", inParam);
	}

    /**
     * @brief NICE PD 정보 삭제(기준년월)
     * @details NICE PD 정보 삭제(기준년월)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP203004IN
     * @return int
     */
	public int deleteRcNicePdRflcStdrYm(IP203001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcNicePdRflcStdrYm -----");
		return session.delete("IP2030.deleteRcNicePdRflcStdrYm", inParam);
	}

    /**
     * @brief NICE PD 정보 엑셀 업로드
     * @details NICE PD 정보 엑셀 업로드
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP203002IN
     * @return int
     */
	public int insertRcNicePdRflcExcl(IP203002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcLgdRflc -----");
		return session.insert("IP2030.insertRcNicePdRflcExcl", inParam);
	}

    /**
     * @brief NICE PD 코드 존재여부 조회
     * @details NICE PD 코드 존재여부 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP203002DTO
     * @return IP203002DTO
     */
    public IP203002DTO selectListRcLgdRflcErr (IP203002DTO inParam ) {
        return session.selectOne("IP2030.selectListRcLgdRflcErr", inParam);
    }

}
