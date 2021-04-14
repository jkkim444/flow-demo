/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5160DAO.java
 * @brief 퇴직금 지급 현황 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 14. | First Created
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
import com.encocns.ia.dto.IA516001DTO;
import com.encocns.ia.service.svo.IA516001IN;
import com.encocns.ia.service.svo.IA516002IN;
import com.encocns.ia.service.svo.IA516003IN;

/**
 * @brief 퇴직금 지급 현황 DAO
 * @details 퇴직금 지급 현황 DAO
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
@Repository
public class IA5160DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5160DAO.class);

	@Autowired
    private SqlMapClient session;

	
	/**
     * @brief 퇴직금 지급 현황 내역
     * @details 퇴직금 지급 현황 내역
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA516001IN
     * @return List<IA516001DTO>
     */
    public List<IA516001DTO> selectListRetmPrvsPres(IA516001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRetmPrvsPres -----");
        return session.selectList("IA5160.selectListRetmPrvsPres", inParam);
    }

    /**
     * @brief 퇴직금 지급 현황 등록 
     * @details 퇴직금 지급 현황 등록 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA516001DTO
     * @return int
     */
	public int insertRetmPrvsPres(IA516001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRetmPrvsPres -----");
		return session.insert("IA5160.insertRetmPrvsPres", inParam);
	}

	/**
     * @brief 퇴직금 지급 현황 삭제 
     * @details 퇴직금 지급 현황 삭제 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param inParam
     * @return int
     */
	public int deleteRetmPrvsPres(IA516002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRetmPrvsPres -----");
		return session.delete("IA5160.deleteRetmPrvsPres", inParam);
	}


	/**
     * @brief 분개데이터대상내역  삭제 
     * @details 분개데이터대상내역  삭제 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA516003IN
     * @return int
     */
	public int deleteCalcJrlzTrgtAmt(IA516003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("IA5160.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역  등록 
     * @details 분개데이터대상내역  등록 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA516003IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmt(IA516003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt -----");
		return session.delete("IA5160.insertCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터상세내역  삭제 
     * @details 분개데이터상세내역  삭제 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA516003IN
     * @return int
     */
	public int deletejrlzDtlProcs(IA516003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5160.deletejrlzDtlProcs", inParam);
	}

	
	/**
     * @brief 분개데이터상세내역  등록 처리
     * @details 분개데이터상세내역  등록 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param inParam
     * @return int
     */
	public int insertjrlzDtlProcs(IA516003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs -----");
		return session.delete("IA5160.insertjrlzDtlProcs", inParam);
	}

}
