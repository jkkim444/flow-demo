/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5210DAO.java
 * @brief 임차시설물 복구비용 발생이력 관리 DAO
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

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.ia.dto.IA521001DTO;
import com.encocns.ia.service.svo.IA521001IN;
import com.encocns.ia.service.svo.IA521002IN;
import com.encocns.ia.service.svo.IA521003IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 임차시설물 복구비용 발생이력 관리 DAO
 * @details 임차시설물 복구비용 발생이력 관리 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5210DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5210DAO.class);

	@Autowired
    private SqlMapClient session;

    @SuppressWarnings({ "unchecked", "rawtypes" })

    
    /**
     * @brief 임차시설물 복구비용 발생이력 조회
     * @details 임차시설물 복구비용 발생이력 조회(페이징 없는 조회)
     * @author : 이동겸
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA521001IN
     * @return ArrayList<IA521001DTO>
     */
    public ArrayList<IA521001DTO> selectListRentRcvrCost(IA521001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRentRcvrCost -----");
        return (ArrayList)session.selectList("IA5210.selectListRentRcvrCost", inParam);
    }

    /**
     * @brief 임차시설물 복구비용 발생이력 전체 건수
     * @details 임차시설물 복구비용 발생이력 전체 건수
     * @author : 이동겸
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA521001IN
     * @return int
     */
    public int selectTotalCount ( IA521001IN inParam ) {
        return session.selectOne("IA5210.selectTotalCount", inParam);
    }

    /**
     * @brief 임차시설물 복구비용 발생이력 페이징 처리
     * @details 임차시설물 복구비용 발생이력 페이징 처리
     * @author : 이동겸
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA521001IN
     * @return List<IA521001DTO>
     */
    public List<IA521001DTO> selectPaging( IA521001IN inParam ) {
        return session.selectList("IA5210.selectPaging", inParam);
    }

    /**
     * @brief 임차시설물 복구비용 발생이력 관리 등록 처리
     * @details 임차시설물 복구비용 발생이력 관리 등록 처리
     * @author : 이동겸
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA521002IN
     * @return int
     */
	public int insertRentRcvrCost(IA521002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRentRcvrCost -----");
		return session.insert("IA5210.insertRentRcvrCost", inParam);
	}

	/**
     * @brief 임차시설물 복구비용 발생이력 관리 변경 처리
     * @details 임차시설물 복구비용 발생이력 관리 변경 처리
     * @author : 이동겸
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA521002IN
     * @return int
     */
	public int updateRentRcvrCost(IA521002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRentRcvrCost -----");
		return session.update("IA5210.updateRentRcvrCost", inParam);
	}

	/**
     * @brief 임차시설물 복구비용 발생이력 관리 삭제 처리
     * @details 임차시설물 복구비용 발생이력 관리 삭제 처리
     * @author : 이동겸
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param IA521003IN
     * @return int
     */
	public int deleteRentRcvrCost(IA521003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRentRcvrCost -----");
		return session.delete("IA5210.deleteRentRcvrCost", inParam);
	}

}
