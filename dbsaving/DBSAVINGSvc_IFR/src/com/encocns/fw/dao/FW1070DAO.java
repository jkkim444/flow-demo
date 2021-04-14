/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1070DAO.java
 * @brief 배치 그룹 상세 관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dao
 * @brief fw DAO Package
 */
package com.encocns.fw.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.fw.dto.FW107001DTO;
import com.encocns.fw.service.svo.FW107001IN;

/**
 * @brief 배치 그룹 상세 관리 DAO
 * @details 배치 그룹 상세 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class FW1070DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 배치 그룹 조회
     * @details 배치 그룹 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW107001IN
     * @return ArrayList<FW107001DTO>
     */
	public ArrayList<FW107001DTO> selectBatDtl( FW107001IN inBatchGrp ){
		ArrayList<FW107001DTO> arrList = (ArrayList)session.selectList( "FW1070.selectBatDtl", inBatchGrp );
		return arrList;
	}

    /**
     * @brief 배치 그룹 등록 및 수정
     * @details 배치 그룹 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW107001DTO
     * @return int
     */
	public int mergeBatDtl( FW107001DTO inBatchGrp ){
		int iResult = session.delete( "FW1070.mergeBatDtl", inBatchGrp );
		return iResult;
	}

   /**
    * @brief 배치 그룹 삭제
    * @details 배치 그룹 삭제
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param FW107001DTO
    * @return int
    */
	public int deleteBatDtl( FW107001DTO inBatchGrp ){
		int iResult = session.update( "FW1070.deleteBatDtl", inBatchGrp );
		return iResult;
	}


   /**
    * @brief 배치 그룹 작업기록
    * @details 배치 그룹 작업기록
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param FW107001DTO
    * @return int
    */
	public int insertBatExeMapp( FW107001DTO inBatchGrp ){
		int iResult = session.insert( "FW1070.insertBatExeMapp", inBatchGrp );
		return iResult;
	}

}
