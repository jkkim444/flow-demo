/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6040DAO.java
 * @brief 공정가치금융자산내역 관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 8. 10. | First Created
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
import com.encocns.ia.dto.IA604001DTO;
import com.encocns.ia.service.svo.IA604001IN;
import com.encocns.ia.service.svo.IA604002IN;
import com.encocns.ia.service.svo.IA604003IN;
import com.encocns.ia.service.svo.IA604004IN;

/**
 * @brief 공정가치금융자산내역 관리 DAO
 * @details 공정가치금융자산내역 관리 DAO
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA6040DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6040DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA604001IN
     * @return List<IA604001DTO>
     */
    public List<IA604001DTO> selectRlessetpamtList(IA604001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectRlessetpamtList -----");
        return session.selectList("IA6040.selectRlessetpamtList", inParam);
    }

    /**
     * @brief 공정가치금융자산내역 기초삭제
     * @details 공정가치금융자산내역 기초삭제
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA604004IN
     * @return int
     */
	public int deleteRlessetpamtBass(IA604004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRlessetpamtBass -----");
		return session.delete("IA6040.deleteRlessetpamtBass", inParam);
	}

    /**
     * @brief 공정가치금융자산내역 기초생성
     * @details 공정가치금융자산내역 기초생성
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA604004IN
     * @return int
     */
	public int insertRlessetpamtBass(IA604004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRlessetpamtBass -----");
		return session.insert("IA6040.insertRlessetpamtBass", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA604002IN
     * @return int
     */
	public int insertRlessetpamt(IA604002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRlessetpamt -----");
		return session.insert("IA6040.insertRlessetpamt", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA604002IN
     * @return int
     */
	public int updateRlessetpamt(IA604002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRlessetpamt -----");
		return session.update("IA6040.updateRlessetpamt", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA604001DTO
     * @return int
     */
	public int insertRlessetpamtExcel(IA604001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRlessetpamtExcel -----");
		return session.insert("IA6040.insertRlessetpamtExcel", inParam);
	}

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA604003IN
     * @return int
     */
	public int deleteRlessetpamt(IA604003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRlessetpamt -----");
		return session.delete("IA6040.deleteRlessetpamt", inParam);
	}

}
