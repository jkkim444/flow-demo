/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5020DAO.java
 * @brief User List DAO
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
import com.encocns.ia.dto.IA508001DTO;
import com.encocns.ia.dto.IA508002DTO;
import com.encocns.ia.service.svo.IA508001IN;
import com.encocns.ia.service.svo.IA508002IN;
import com.encocns.ia.service.svo.IA508004IN;

/**
 * @brief IFRS연결자본변동표관리 내역 DAO
 * @details IFRS연결자본변동표관리 내역 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5080DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5080DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief IFRS연결자본변동표관리 조회 내역
     * @details IFRS연결자본변동표관리 조회 내역
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508001IN
     * @return List<IA508001DTO>
     */
    public List<IA508001DTO> selectListlnknCaptChg(IA508001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListlnknCaptChg -----");
        return session.selectList("IA5080.selectListlnknCaptChg", inParam);
    }

    /**
     * @brief 계정과목존재여부  조회
     * @details 계정과목존재여부  조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508002DTO
     * @return IA508002DTO
     */
    public IA508002DTO selectacctExisYn ( IA508002DTO inParam ) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectacctExisYn -----");
    	return session.selectOne("IA5250.selectacctExisYn", inParam);
    }

	/**
	 * @brief IFRS연결자본변동표 K-GAAP 엑셀업로드
	 * @details IFRS연결자본변동표 K-GAAP 엑셀업로드
	 * @author : 이동겸
	 * @date : 2020. 8. 10.
	 * @version : 1.0.0
	 * @param IA508002DTO
	 * @return int
	 */
	public int insertlnknCaptChgExcl(IA508002DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertlnknCaptChgExcl -----");
		return session.insert("IA5080.insertlnknCaptChgExcl", inParam);
	}

	/**
     * @brief IFRS연결자본변동표 K-GAAP 삭제
     * @details IFRS연결자본변동표 K-GAAP 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508002IN
     * @return int
     */
	public int deletelnknCaptChgKgaap(IA508004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletelnknCaptChgKgaap -----");
		return session.delete("IA5080.deletelnknCaptChgKgaap", inParam);
	}

	/**
     * @brief IFRS연결자본변동표관리 K-GAAP제외 삭제
     * @details IFRS연결자본변동표관리 K-GAAP제외 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508002IN
     * @return int
     */
	public int deletelnknCaptChg(IA508002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletelnknCaptChg -----");
		return session.delete("IA5080.deletelnknCaptChg", inParam);
	}
	/**
     * @brief IFRS연결자본변동표관리 별도 생성
     * @details IFRS연결자본변동표관리 별도 생성
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508002IN
     * @return int
     */
	public int insertspusCaptChgBal(IA508002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertspusCaptChgBal -----");
		return session.insert("IA5080.insertspusCaptChgBal", inParam);
	}
	/**
     * @brief IFRS연결자본변동표관리 별도 생성(산출되는항목 3)
     * @details IFRS연결자본변동표관리 별도 생성(산출되는항목 3)
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508002IN
     * @return int
     */
	public int insertspusCaptChgBalCacl3(IA508002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertspusCaptChgBalCacl3 -----");
		return session.insert("IA5080.insertspusCaptChgBalCacl3", inParam);
	}
	/**
     * @brief IFRS연결자본변동표관리 별도 생성(산출되는항목 9)
     * @details IFRS연결자본변동표관리 별도 생성(산출되는항목 9)
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508002IN
     * @return int
     */
	public int insertspusCaptChgBalCacl9(IA508002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertspusCaptChgBalCacl9 -----");
		return session.insert("IA5080.insertspusCaptChgBalCacl9", inParam);
	}

	/**
     * @brief IFRS연결자본변동표관리 연결 생성
     * @details IFRS연결자본변동표관리 연결 생성
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508002IN
     * @return int
     */
	public int insertlnknCaptChgBal(IA508002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertlnknCaptChgBal -----");
		return session.insert("IA5080.insertlnknCaptChgBal", inParam);
	}
	/**
     * @brief IFRS연결자본변동표관리 연결 생성(산출되는항목3)
     * @details IFRS연결자본변동표관리 연결 생성(산출되는항목3)
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508002IN
     * @return int
     */
	public int insertlnknCaptChgBalCacl3(IA508002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertlnknCaptChgBalCacl3 -----");
		return session.insert("IA5080.insertlnknCaptChgBalCacl3", inParam);
	}
	/**
     * @brief IFRS연결자본변동표관리 연결 생성(산출되는항목9)
     * @details IFRS연결자본변동표관리 연결 생성(산출되는항목9)
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA508002IN
     * @return int
     */
	public int insertlnknCaptChgBalCacl9(IA508002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertlnknCaptChgBalCacl9 -----");
		return session.insert("IA5080.insertlnknCaptChgBalCacl9", inParam);
	}


}
