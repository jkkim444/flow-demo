/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1020DAO.java
 * @brief 배치 관리 DAO
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

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.fw.dto.FW102001DTO;
import com.encocns.fw.service.svo.FW102001IN;
import com.encocns.fw.service.svo.FW102002IN;
import com.encocns.fw.service.svo.FW102003IN;

/**
 * @brief 배치 관리 DAO
 * @details 배치 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class FW1020DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 배치 조회
     * @details 배치 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW102001IN
     * @return ArrayList<FW102001DTO>
     */
	public ArrayList<FW102001DTO> selectBatchList( FW102001IN inBatch ){
		ArrayList<FW102001DTO> arrList = (ArrayList)session.selectList( "FW1020.selectBatchList", inBatch );
		return arrList;
	}

    /**
     * @brief 배치 등록 및 수정
     * @details 배치 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW102002IN
     * @return int
     */
	public int mergeBatch( FW102002IN inBatch ){
		int iResult = session.delete( "FW1020.mergeBatch", inBatch );
		return iResult;
	}

   /**
    * @brief 배치 삭제
    * @details 배치 삭제
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param FW102003IN
    * @return int
    */
	public int deleteBatch( FW102003IN inBatch ){
		int iResult = session.update( "FW1020.deleteBatch", inBatch );
		return iResult;
	}

}
