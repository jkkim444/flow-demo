/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5250DAO.java
 * @brief 수익증권합계잔액시산표 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 21. | First Created
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
import com.encocns.ia.dto.IA525001DTO;
import com.encocns.ia.service.svo.IA525001IN;


/**
 * @brief 수익증권합계잔액시산표 DAO
 * @details 수익증권합계잔액시산표 DAO
 * @author : 이동겸
 * @date : 2020. 9. 21.
 * @version : 1.0.0
 */
@Repository
public class IA5250DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5250DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief 수익증권합계잔액시산표 내역 조회
     * @details 수익증권합계잔액시산표 내역 조회 
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA525001IN
     * @return List<IA525001DTO>
     */
    public List<IA525001DTO> selectListBncfBalTrbs(IA525001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBncfBalTrbs -----");
        return session.selectList("IA5250.selectListBncfBalTrbs", inParam);
    }
    
    /**
     * @brief 계정과목존재여부 조회
     * @details 계정과목존재여부 조회 
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA525001DTO
     * @return IA525001DTO
     */
    public IA525001DTO selectacctExisYn ( IA525001DTO inParam ) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectacctExisYn -----");
    	return session.selectOne("IA5250.selectacctExisYn", inParam);
    }
    
    /**
     * @brief 수익증권합계잔액시산표 등록 처리
     * @details 수익증권합계잔액시산표 등록 처리 
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA525001DTO
     * @return int
     */
	public int insertBncfBalTrbs(IA525001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertBncfBalTrbs -----");
		return session.insert("IA5250.insertBncfBalTrbs", inParam);
	}

	/**
     * @brief 수익증권합계잔액시산표 삭제 처리
     * @details 수익증권합계잔액시산표 삭제 처리 
     * @author : 이동겸
     * @date : 2020. 9. 21.
     * @version : 1.0.0
     * @param IA525001DTO
     * @return int
     */
	public int deleteBncfBalTrbs(IA525001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteBncfBalTrbs -----");
		return session.delete("IA5250.deleteBncfBalTrbs", inParam);
	}


}
