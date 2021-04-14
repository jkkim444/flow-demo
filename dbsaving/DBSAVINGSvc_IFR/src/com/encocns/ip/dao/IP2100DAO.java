/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2100DAO.java
 * @brief 담보가액 관리 DAO
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
import com.encocns.ip.dto.IP210001DTO;
import com.encocns.ip.service.svo.IP210001IN;
import com.encocns.ip.service.svo.IP210002IN;
import com.encocns.ip.service.svo.IP210003IN;


/**
 * @brief 담보가액 관리 DAO
 * @details 담보가액 관리 DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2100DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2100DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 담보가액 목록 조회(전체)
     * @details 담보가액 목록 조회(전체)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210001IN
     * @return List<IP210001DTO>
     */
    public List<IP210001DTO> selectListMtprMgmt(IP210001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListMtprHist -----");
        return session.selectList("IP2100.selectListMtprMgmt", inParam);
    }

    /**
     * @brief 담보가액 페이징 건수 조회
     * @details 담보가액 페이징 건수 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210001IN
     * @return int
     */
    public int selectTotalCount ( IP210001IN inParam ) {
        return session.selectOne("IP2100.selectTotalCount", inParam);
    }

    /**
     * @brief 담보가액 목록 조회(페이징)
     * @details 담보가액 목록 조회(페이징)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210001IN
     * @return List<IP210001DTO>
     */
    public List<IP210001DTO> selectPaging( IP210001IN inParam ) {
        return session.selectList("IP2100.selectPaging", inParam);
    }

    /**
     * @brief 담보가액 엑셀 업로드 전 삭제
     * @details 담보가액 엑셀 업로드 전 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210002IN
     * @return int
     */
    public int deleteMtprMgmtAll(IP210002IN inParam) {
    	if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteMtprMgmtAll -----");
    	return session.delete("IP2100.deleteMtprMgmtAll", inParam);
    }

    /**
     * @brief 담보가액 정보 등록
     * @details 담보가액 정보 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210002IN
     * @return int
     */
	public int insertMtprMgmt(IP210002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMtprMgmt -----");
		return session.insert("IP2100.insertMtprMgmt", inParam);
	}

    /**
     * @brief 담보가액 정보 변경
     * @details 담보가액 정보 변경
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210002IN
     * @return int
     */
	public int updateMtprMgmt(IP210002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateMtprMgmt -----");
		return session.update("IP2100.updateMtprMgmt", inParam);
	}

    /**
     * @brief 담보가액 정보 삭제
     * @details 담보가액 정보 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210003IN
     * @return int
     */
	public int deleteMtprMgmt(IP210003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteMtprMgmt -----");
		return session.delete("IP2100.deleteMtprMgmt", inParam);
	}

    /**
     * @brief 충당금 계좌번호 조회
     * @details 충당금 계좌번호 조회
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210002IN
     * @return int
     */
	public int selectChkLnrnlsrsrvtrgtbsic(IP210002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectChkLnrnlsrsrvtrgtbsic -----");
		return session.selectOne("IP2100.selectChkLnrnlsrsrvtrgtbsic", inParam);
	}
}
