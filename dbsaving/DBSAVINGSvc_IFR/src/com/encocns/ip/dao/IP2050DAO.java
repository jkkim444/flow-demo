/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2050DAO.java
 * @brief 기타 충당금 관리 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
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
import com.encocns.ip.dto.IP205001DTO;
import com.encocns.ip.service.svo.IP205001IN;
import com.encocns.ip.service.svo.IP205002IN;
import com.encocns.ip.service.svo.IP205003IN;


/**
 * @brief 기타충당금관리 기본 management List DAO
 * @details 기타충당금관리 기본 management List DAO
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
@Repository
public class IP2050DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2050DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 기타충당금 목록 조회(전체)
     * @details 기타충당금 목록 조회(전체)
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP205001IN
     * @return List<IP205001DTO>
     */
    public List<IP205001DTO> selectListEtcRsrv(IP205001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListEtcRsrv -----");
        return session.selectList("IP2050.selectListEtcRsrv", inParam);
    }

    /**
     * @brief 기타충당금 목록 페이징 건수 조회
     * @details 기타충당금 목록 페이징 건수 조회
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP205001IN
     * @return int
     */
    public int selectTotalCount ( IP205001IN inParam ) {
        return session.selectOne("IP2050.selectTotalCount", inParam);
    }

    /**
     * @brief 기타충당금 목록 조회(페이징)
     * @details 기타충당금 목록 조회(페이징)
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP205001IN
     * @return List<IP205001DTO>
     */
    public List<IP205001DTO> selectPaging( IP205001IN inParam ) {
        return session.selectList("IP2050.selectPaging", inParam);
    }

    /**
     * @brief 기타충당금 정보 등록
     * @details 기타충당금 정보 등록
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP205002IN
     * @return int
     */
	public int insertEtcRsrv(IP205002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEtcRsrv -----");
		return session.insert("IP2050.insertEtcRsrv", inParam);
	}

    /**
     * @brief 기타충당금 정보 변경
     * @details 기타충당금 정보 변경
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP205002IN
     * @return int
     */
	public int updateEtcRsrv(IP205002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateEtcRsrv -----");
		return session.update("IP2050.updateEtcRsrv", inParam);
	}

    /**
     * @brief 기타충당금 정보 삭제
     * @details 기타충당금 정보 삭제
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP205003IN
     * @return int
     */
	public int deleteEtcRsrv(IP205003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEtcRsrv -----");
		return session.delete("IP2050.deleteEtcRsrv", inParam);
	}
}
