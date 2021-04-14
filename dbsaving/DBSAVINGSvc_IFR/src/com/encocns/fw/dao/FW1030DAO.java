/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1030DAO.java
 * @brief 배치 작업 현황 DAO
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
import com.encocns.fw.dto.FW103001DTO;
import com.encocns.fw.dto.FW103002DTO;
import com.encocns.fw.service.svo.FW103001IN;

/**
 * @brief 배치 작업 현황 DAO
 * @details 배치 작업 현황 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class FW1030DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 배치 그룹 정보 조회
     * @details 배치 그룹 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param
     * @return ArrayList<FW103002DTO>
     */
    public ArrayList<FW103002DTO> selectGrpId(){
        ArrayList<FW103002DTO> arrList = (ArrayList)session.selectList( "FW1030.selectGrpId" );
        return arrList;
    }

    /**
     * @brief 배치 작업 ID 조회
     * @details 배치 작업 ID 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param String
     * @return ArrayList<FW103002DTO>
     */
    public ArrayList<FW103002DTO> selectGrpInsId( String grpId ){
        ArrayList<FW103002DTO> arrList = (ArrayList)session.selectList( "FW1030.selectGrpInsId", grpId );
        return arrList;
    }


    /**
     * @brief 배치 작업 내역 조회
     * @details 배치 작업 내역 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW103001IN
     * @return ArrayList<FW103001DTO>
     */
	public ArrayList<FW103001DTO> selectBatchOperationList( FW103001IN inBatch ){
		ArrayList<FW103001DTO> arrList = (ArrayList)session.selectList( "FW1030.selectBatchOperationList", inBatch );
		return arrList;
	}
}
