/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1010DAO.java
 * @brief 서비스 관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dao
 * @brief FW DAO Package
 */
package com.encocns.fw.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.fw.dto.FW101001DTO;
import com.encocns.fw.service.svo.FW101001IN;
import com.encocns.fw.service.svo.FW101002IN;
import com.encocns.fw.service.svo.FW101003IN;

/**
 * @brief 서비스 관리 DAO
 * @details 서비스 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class FW1010DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 서비스 목록 조회
     * @details 서비스 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW101001IN
     * @return List<FW101001DTO>
     */
	public List<FW101001DTO> selectServiceList( FW101001IN inParam ){
		List<FW101001DTO> arrList = session.selectList( "FW1010.selectServiceList", inParam );
		return arrList;
	}

    /**
     * @brief 서비스 등록 및 수정
     * @details 서비스 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW101002IN
     * @return int
     */
	public int mergeService( FW101002IN inParam ){
		int iResult = session.delete( "FW1010.mergeService", inParam );
		return iResult;
	}

   /**
    * @brief 서비스 삭제
    * @details 서비스 삭제
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param FW101003IN
    * @return int
    */
	public int deleteService( FW101003IN inParam ){
		int iResult = session.update( "FW1010.deleteService", inParam );
		return iResult;
	}

}
