/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1011DAO.java
 * @brief 공시보고서 상세 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief ID DAO Package
 */
package com.encocns.id.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.id.dto.ID101101DTO;
import com.encocns.id.service.svo.ID101101IN;
import com.encocns.id.service.svo.ID101102IN;

/**
 * @brief 공시보고서 상세 DAO
 * @details 공시보고서 상세 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID1011DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1011DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief mergePbnfRpt
     * @details 공시보고서 정보 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101101IN
     * @return int
     */
    public int mergePbnfRpt(ID101101IN in) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergePbnfRpt -----");
        return session.update("ID1011.mergePbnfRpt", in);
    }

	/**
     * @brief selectPbnfRpt
     * @details 공시보고서 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101102IN
     * @return ID101101DTO
     */
    public ID101101DTO selectPbnfRpt(ID101102IN in) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectPbnfRpt -----");
        return session.selectOne("ID1011.selectPbnfRpt", in);
    }


	/**
     * @brief existPbnfRpt
     * @details 공시보고서 존재여부 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101101IN
     * @return int
     */
    public int existPbnfRpt(ID101101IN in) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- existPbnfRpt -----");
        return session.selectOne("ID1011.existPbnfRpt", in);
    }

}
