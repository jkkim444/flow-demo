/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2050DAO.java
 * @brief 그룹 사용자 관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief Common DAO Package
 */
package com.encocns.co.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO205001DTO;
import com.encocns.co.service.svo.CO205001IN;
import com.encocns.co.service.svo.CO205002IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 그룹 사용자 관리 DAO
 * @details 그룹 사용자 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO2050DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 그룹 사용자 조회
     * @details 그룹 사용자 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO205001IN
     * @return List<CO205001DTO>
     */
    public List<CO205001DTO> selectGroupUserList( CO205001IN inParam ){
        List<CO205001DTO> arrList = session.selectList( "CO2050.selectGroupUserList", inParam );
        return arrList;
    }

    /**
     * @brief 그룹 사용자 삭제
     * @details 그룹 사용자 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO205002IN
     * @return int
     */
    public int deleteGroupUser( CO205002IN inParam ){
        int iResult = session.delete( "CO2050.deleteGroupUser", inParam );
        return iResult;
    }

    /**
     * @brief 그룹 사용자 등록
     * @details 그룹 사용자 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO205001DTO
     * @return int
     */
    public int insertGroupUser( CO205001DTO dtoParam ){
        int iResult = session.insert( "CO2050.insertGroupUser", dtoParam );
        return iResult;
    }

}
