/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2060DAO.java
 * @brief 당기제각회수정보 관리 List DAO
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
import com.encocns.ip.dto.IP206001DTO;
import com.encocns.ip.dto.IP206002DTO;
import com.encocns.ip.service.svo.IP206001IN;
import com.encocns.ip.service.svo.IP206003IN;


/**
 * @brief 당기제각회수정보관리 DAO
 * @details 당기제각회수정보관리 DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2060DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2060DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 당기제각회수정보 목록 조회
     * @details 당기제각회수정보 목록 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP206001IN
     * @return List<IP206001DTO>
     */
    public List<IP206001DTO> selectListDprnRtrv(IP206001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListDprnRtrv -----");
        return session.selectList("IP2060.selectListDprnRtrv", inParam);
    }

    /**
     * @brief 당기제각회수정보 등록
     * @details 당기제각회수정보 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP206002DTO
     * @return int
     */
	public int insertDprnRtrv(IP206002DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertDprnRtrv -----");
		return session.insert("IP2060.insertDprnRtrv", inParam);
	}

    /**
     * @brief 당기제각회수정보 변경
     * @details 당기제각회수정보 변경
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP206002DTO
     * @return int
     */
	public int updateDprnRtrv(IP206002DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateDprnRtrv -----");
		return session.update("IP2060.updateDprnRtrv", inParam);
	}

    /**
     * @brief 당기제각회수정보 삭제
     * @details 당기제각회수정보 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP206003IN
     * @return int
     */
	public int deleteDprnRtrv(IP206003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteDprnRtrv -----");
		return session.delete("IP2060.deleteDprnRtrv", inParam);
	}
}
