/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5220DAO.java
 * @brief 복구비용 추정 속성 관리 DAO
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
import com.encocns.ia.dto.IA522001DTO;
import com.encocns.ia.service.svo.IA522001IN;
import com.encocns.ia.service.svo.IA522002IN;
import com.encocns.ia.service.svo.IA522003IN;

/**
 * @brief 복구비용추정속성관리 DAO
 * @details 복구비용추정속성관리 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5220DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5220DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief 복구비용추정속성관리 내역 조회
     * @details 복구비용추정속성관리 내역 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA522001IN
     * @return List<IA522001DTO>
     */
    public List<IA522001DTO> selectListRcvrCostEsti(IA522001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRcvrCostEsti -----");
        return session.selectList("IA5220.selectListRcvrCostEsti", inParam);
    }

    /**
     * @brief 복구비용추정속성관리 등록 처리
     * @details 복구비용추정속성관리 등록 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA522002IN
     * @return int
     */
	public int insertRcvrCostEsti(IA522002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcvrCostEsti -----");
		return session.insert("IA5220.insertRcvrCostEsti", inParam);
	}

	/**
     * @brief 복구비용추정속성관리 변경 처리
     * @details 복구비용추정속성관리 변경 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA522002IN
     * @return int
     */
	public int updateRcvrCostEsti(IA522002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRcvrCostEsti -----");
		return session.update("IA5220.updateRcvrCostEsti", inParam);
	}

	/**
     * @brief 복구비용추정속성관리 삭제 처리
     * @details 복구비용추정속성관리 삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA522003IN
     * @return int
     */
	public int deleteRcvrCostEsti(IA522003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcvrCostEsti -----");
		return session.delete("IA5220.deleteRcvrCostEsti", inParam);
	}

}
