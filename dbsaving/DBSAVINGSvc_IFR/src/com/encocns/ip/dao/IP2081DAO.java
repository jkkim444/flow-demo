/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2081DAO.java
 * @brief 대손충당금상세 관리 DAO
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ip.dto.IP208101DTO;
import com.encocns.ip.service.svo.IP208101IN;
import com.encocns.ip.service.svo.IP208102IN;
import com.encocns.ip.service.svo.IP208103IN;


/**
 * @brief 대손충당금상세 관리 DAO
 * @details 대손충당금상세 관리DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2081DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2081DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 대손충당금상세 조회
     * @details 대손충당금상세 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208101IN
     * @return IP208101DTO
     */
    public IP208101DTO selectBadlnRsrvDtl(IP208101IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectBadlnRsrvDtl -----");
        return session.selectOne("IP2081.selectBadlnRsrvDtl", inParam);
    }

    /**
     * @brief 대손충당금상세 변경
     * @details 대손충당금상세 변경
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208102IN
     * @return int
     */
	public int updateBadlnRsrvDtl(IP208102IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateBadlnRsrvDtl -----");
		return session.update("IP2081.updateBadlnRsrvDtl", inParam);
	}

    /**
     * @brief 대손충당금상세 삭제
     * @details 대손충당금상세 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208103IN
     * @return int
     */
	public int deleteBadlnRsrvDtl(IP208103IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteBadlnRsrvDtl -----");
		return session.delete("IP2081.deleteBadlnRsrvDtl", inParam);
	}

}
