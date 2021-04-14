/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5100DAO.java
 * @brief IFRS 정산표 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
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
import com.encocns.ia.dto.IA511001DTO;
import com.encocns.ia.dto.IA511002DTO;
import com.encocns.ia.service.svo.IA511001IN;
import com.encocns.ia.service.svo.IA511002IN;

/**
 * @brief IFRS 정산표 조회 management List DAO
 * @details IFRS 정산표 조회 management List DAO
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
@Repository
public class IA5110DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5110DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief IFRS 정산표  조회 
     * @details IFRS 정산표  조회 
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA511001IN
     * @return List<IA511001DTO>
     */
    public List<IA511001DTO> selectListIfrsAdjsHist(IA511001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsAdjsHist -----");
        return session.selectList("IA5110.selectListIfrsAdjsHist", inParam);
    }


    /**
     * @brief IFRS 정산표  조회엑셀
     * @details IFRS 정산표  조회엑셀
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA511002IN
     * @return List<IA511002DTO>
     */
    public List<IA511002DTO> selectListIfrsAdjsHistExcl(IA511002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsAdjsHistExcl -----");
        return session.selectList("IA5110.selectListIfrsAdjsHistExcl", inParam);
    }



}
