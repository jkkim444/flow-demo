/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1060DAO.java
 * @brief 배치 그룹 관리 DAO
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
import com.encocns.fw.dto.FW106001DTO;
import com.encocns.fw.service.svo.FW106001IN;
import com.encocns.fw.service.svo.FW106002IN;
import com.encocns.fw.service.svo.FW106003IN;

/**
 * @brief 배치 그룹 관리 DAO
 * @details 배치 그룹 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class FW1060DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 배치 그룹 조회
     * @details 배치 그룹 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW106001IN
     * @return ArrayList<FW106001DTO>
     */
	public ArrayList<FW106001DTO> selectBatchGrpList( FW106001IN inBatchGrp ){
		ArrayList<FW106001DTO> arrList = (ArrayList)session.selectList( "FW1060.selectBatchGrpList", inBatchGrp );
		return arrList;
	}

    /**
     * @brief 배치 그룹 등록 및 수정
     * @details 배치 그룹 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW106002IN
     * @return int
     */
	public int mergeBatchGrp( FW106002IN inBatchGrp ){
		int iResult = session.delete( "FW1060.mergeBatchGrp", inBatchGrp );
		return iResult;
	}

   /**
    * @brief 배치 그룹 삭제
    * @details 배치 그룹 삭제
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param FW106003IN
    * @return int
    */
	public int deleteBatchGrp( FW106003IN inBatchGrp ){
		int iResult = session.update( "FW1060.deleteBatchGrp", inBatchGrp );
		return iResult;
	}

}
