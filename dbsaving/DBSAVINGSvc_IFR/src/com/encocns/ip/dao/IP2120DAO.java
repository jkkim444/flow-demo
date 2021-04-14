/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2120DAO.java
 * @brief 대손충당금 요약 관리 DAO
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
import com.encocns.ip.dto.IP212001DTO;
import com.encocns.ip.service.svo.IP212001IN;
import com.encocns.ip.service.svo.IP212002IN;
import com.encocns.ip.service.svo.IP212003IN;


/**
 * @brief 대손충당금 요약 관리 DAO
 * @details 대손충당금 요약 관리 DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2120DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2120DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 대손충당금 요약 조회(대출금/충당금)
     * @details 대손충당금 요약 조회(대출금/충당금)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212001IN
     * @return List<IP212001DTO>
     */
    public List<IP212001DTO> selectListLsrsrvBrf(IP212001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLsrsrvBrf -----");
        return session.selectList("IP2120.selectListLsrsrvBrf", inParam);
    }

    /**
     * @brief 대손충당금 요약 생성(충당금)
     * @details 대손충당금 요약 생성(충당금)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int insertLsrsrvBrf(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLsrsrvBrf -----");
		return session.insert("IP2120.insertLsrsrvBrf", inParam);
	}

    /**
     * @brief 대손충당금 요약 생성(회수)(충당금)
     * @details 대손충당금 요약 생성(회수)(충당금)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int insertLsrsrvBrfRtrv(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLsrsrvBrfRtrv -----");
		return session.insert("IP2120.insertLsrsrvBrfRtrv", inParam);
	}

    /**
     * @brief 대손충당금 요약 생성(대출잔액)
     * @details 대손충당금 요약 생성(대출잔액)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int insertLsrsrvBrfBal(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLsrsrvBrfBal -----");
		return session.insert("IP2120.insertLsrsrvBrfBal", inParam);
	}

    /**
     * @brief 대손충당금 요약 생성(회수)(대출잔액)
     * @details 대손충당금 요약 생성(회수)(대출잔액)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int insertLsrsrvBrfRtrvBal(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLsrsrvBrfRtrvBal -----");
		return session.insert("IP2120.insertLsrsrvBrfRtrvBal", inParam);
	}
	
	/**
     * @brief 대손충당금 요약 생성(대출잔액_V1)
     * @details 대손충당금 요약 생성(대출잔액_V1)
     * @author : 이미래
     * @date : 2020. 12. 16.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int insertLsrsrvBrfBal_V1(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLsrsrvBrfBal_V1 -----");
		return session.insert("IP2121.insertLsrsrvBrfBal_V1", inParam);
	}
	
	/**
     * @brief 대손충당금 요약 생성(회수)(대출잔액_V1)
     * @details 대손충당금 요약 생성(회수)(대출잔액_V1)
     * @author : 이미래
     * @date : 2020. 12. 16.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int insertLsrsrvBrfRtrvBal_V1(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLsrsrvBrfRtrvBal_V1 -----");
		return session.insert("IP2121.insertLsrsrvBrfRtrvBal_V1", inParam);
	}
	
	/**
     * @brief 대손충당금 요약 생성(대출잔액_V1)
     * @details 대손충당금 요약 생성(대출잔액_V1)
     * @author : 이미래
     * @date : 2020. 12. 16.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int updateLsrsrvBrfBal_1(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateLsrsrvBrfBal_1 -----");
		return session.update("IP2121.updateLsrsrvBrfBal_1", inParam);
	}
	
	/**
     * @brief 대손충당금 요약 생성(대출잔액_V1)
     * @details 대손충당금 요약 생성(대출잔액_V1)
     * @author : 이미래
     * @date : 2020. 12. 16.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int updateLsrsrvBrfBal_2(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateLsrsrvBrfBal_2 -----");
		return session.update("IP2121.updateLsrsrvBrfBal_2", inParam);
	}
	
	/**
     * @brief 대손충당금 요약 생성(대출잔액_V1)
     * @details 대손충당금 요약 생성(대출잔액_V1)
     * @author : 이미래
     * @date : 2020. 12. 16.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int updateLsrsrvBrfBal_3(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateLsrsrvBrfBal_3 -----");
		return session.update("IP2121.updateLsrsrvBrfBal_3", inParam);
	}
	
	/**
     * @brief 대손충당금 요약 생성(대출잔액_V1)
     * @details 대손충당금 요약 생성(대출잔액_V1)
     * @author : 이미래
     * @date : 2020. 12. 16.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int updateLsrsrvBrfBal_4(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateLsrsrvBrfBal_4 -----");
		return session.update("IP2121.updateLsrsrvBrfBal_4", inParam);
	}
	
	/**
     * @brief 대손충당금 요약 생성(대출잔액_V1)
     * @details 대손충당금 요약 생성(대출잔액_V1)
     * @author : 이미래
     * @date : 2020. 12. 16.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int updateLsrsrvBrfBal_5(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateLsrsrvBrfBal_5 -----");
		return session.update("IP2121.updateLsrsrvBrfBal_5", inParam);
	}
	
	

    /**
     * @brief 대손충당금 등록
     * @details 대손충당금 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212001DTO
     * @return int
     */
    public int insertListLsrsrvBrf(IP212001DTO inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertListLsrsrvBrf -----");
        return session.insert("IP2120.insertListLsrsrvBrf", inParam);
    }

    /**
     * @brief 대손충당금 요약 삭제
     * @details 대손충당금 요약 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212002IN
     * @return int
     */
	public int deleteMtprMgmt(IP212002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteMtprMgmt -----");
		return session.delete("IP2120.deleteMtprMgmt", inParam);
	}

    /**
     * @brief 대손충당금 요약 삭제
     * @details 대손충당금 요약 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212003IN
     * @return int
     */
    public int deleteMtprMgmt(IP212003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteMtprMgmt -----");
        return session.delete("IP2120.deleteMtprMgmt", inParam);
    }
}
