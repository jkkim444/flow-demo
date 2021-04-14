/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6060DAO.java
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
import com.encocns.ia.dto.IA606001DTO;
import com.encocns.ia.service.svo.IA606001IN;
import com.encocns.ia.service.svo.IA606002IN;

/**
 * @brief 공정가치금융자산내역 관리 DAO
 * @details 공정가치금융자산내역 관리 DAO
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA6060DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6060DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA606001IN
     * @return List<IA606001DTO>
     */
    public List<IA606001DTO> selectCrtxcostcmpsList(IA606001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectCrtxcostcmpsList -----");
        return session.selectList("IA6060.selectCrtxcostcmpsList", inParam);
    }

    /**
     * @brief 법인세비용구성관리 기초생성 삭제
     * @details 법인세비용구성관리 기초생성 삭제
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA606002IN
     * @return int
     */
	public int deleteCrtxcostBass(IA606002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCrtxcostBass -----");
		return session.delete("IA6060.deleteCrtxcostBass", inParam);
	}

    /**
     * @brief 법인세비용구성관리 기초생성 등록
     * @details 법인세비용구성관리 기초생성 등록
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA606002IN
     * @return int
     */
	public int insertCrtxcostBass(IA606002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCrtxcostBass -----");
		return session.insert("IA6060.insertCrtxcostBass", inParam);
	}

    /**
     * @brief 법인세비용구성관리 수정
     * @details 법인세비용구성관리 수정
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA606001DTO
     * @return int
     */
	public int updateCrtxcostcmps(IA606001DTO dtoParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateCrtxcostcmps -----");
		return session.update("IA6060.updateCrtxcostcmps", dtoParam);
	}

}
