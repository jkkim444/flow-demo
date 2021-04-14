/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5320DAO.java
 * @brief KGAAP 계정코드 매핑 관리 DAO
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 11. 18. | First Created
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
import com.encocns.ia.dto.IA532001DTO;


import com.encocns.ia.service.svo.IA532001IN;
import com.encocns.ia.service.svo.IA532002IN;

/**
 * @brief KGAAP 계정코드 매핑 관리 DAO
 * @details KGAAP 계정코드 매핑 관리 DAO
 * @author : 이미래
 * @date : 2020. 11. 18.
 * @version : 1.0.0
 */
@Repository
public class IA5320DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5320DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 조건에 해당하는 KGAAP 계정코드 내역 조회
     * @details 조건에 해당하는 KGAAP 계정코드 내역 조회
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532001IN
     * @return List<IA532001DTO>
     */
    public List<IA532001DTO> selectListKgaapAccd(IA532001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListKgaapAccd -----");
        return session.selectList("IA5320.selectListKgaapAccd", inParam);
    }

    /**
     * @brief 계정코드 존재 여부 확인
     * @details 계정코드 존재 여부 확인
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532001IN
     * @return int
     */
    public int selectKgaapAccd(IA532001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectKgaapAccd -----");
        return session.selectOne("IA5320.selectKgaapAccd", inParam);
    }
    
    /**
     * @brief 상위계정코드  존재 여부  확인한다.
     * @details 상위계정코드  존재 여부  확인한다.
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532002IN
     * @return int
     */
    public int selectUprnToaccd(IA532002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectUprnToaccd -----");
        return session.selectOne("IA5320.selectUprnToaccd", inParam);
    }
    
    /**
     * @brief KGAAP계정코드 일치 여부 확인
     * @details KGAAP계정코드 일치 여부 확인
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532002IN
     * @return IA532001DTO
     */
    public IA532001DTO selectIfrsAccd(IA532002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectIfrsAccd -----");
        return session.selectOne("IA5320.selectIfrsAccd", inParam);
    }


    /**
     * @brief KGAAP계정과목코드 등록
     * @details KGAAP계정과목코드 등록
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532002IN
     * @return int
     */
	public int insertKgaapAccd(IA532002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertKgaapAccd -----");
		return session.insert("IA5320.insertKgaapAccd", inParam);
	}

	/**
     * @brief 계정과목코드 변경  처리
     * @details 계정과목코드 변경  처리
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532002IN
     * @return int
     */
	public int updateKgaapAccd(IA532002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateKgaapAccd -----");
		return session.update("IA5320.updateKgaapAccd", inParam);
	}
 

	/**
     * @brief 계정과목코드 삭제 처리
     * @details 계정과목코드 삭제 처리
     * @author : 이미래
     * @date : 2020. 11. 18.
     * @version : 1.0.0
     * @param IA532002IN
     * @return int
     */
	public int deleteKgaapAccd(IA532002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteKgaapAccd -----");
		return session.delete("IA5320.deleteKgaapAccd", inParam);
	}


}
