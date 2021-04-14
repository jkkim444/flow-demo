/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5301DAO.java
 * @brief 수정분개 관리 팝업 DAO
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dao
 * @brief Common DAO Package
 */
package com.encocns.ia.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ia.dto.IA530101DTO;
import com.encocns.ia.dto.IA530102DTO;
import com.encocns.ia.service.svo.IA530101IN;

/**
 * @brief 수정분개 관리_팝업 DAO
 * @details 수정분개 관리_팝업 DAO
 * @author : 이미래
 * @date : 2020. 10. 26.
 * @version : 1.0.0
 */
@Repository
public class IA5301DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5301DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief 수정분개 관리_팝업  요약 내역 조회
     * @details 수정분개 관리_팝업  요약 내역 조회
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530101IN
     * @return IA530102DTO
     */
    public IA530102DTO selectAmndJrlzHistPopUp(IA530101IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectAmndJrlzHistPopUp -----");
        return session.selectOne("IA5301.selectAmndJrlzHistPopUp", inParam);
    }


    /**
     * @brief 수정분개 관리_팝업 등록
     * @details 수정분개 관리_팝업 등록
     * @author : 이미래
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA530101DTO
     * @return int
     */
	public int insertAmndJrlzHistPopUp(IA530101DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertAmndJrlzHistPopUp -----");
		return session.insert("IA5301.insertAmndJrlzHist", inParam);
	}

}
