/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2040DAO.java
 * @brief 부서 메뉴 관리 DAO
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

import com.encocns.co.dto.CO204001DTO;
import com.encocns.co.dto.CO204002DTO;
import com.encocns.co.service.svo.CO204001IN;
import com.encocns.co.service.svo.CO204002IN;
import com.encocns.co.service.svo.CO204003IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 부서 메뉴 관리 DAO
 * @details 부서 메뉴 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO2040DAO {

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 그룹 조회
     * @details 그룹 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO204001IN
     * @return List<CO204001DTO>
     */
	public List<CO204001DTO> selectGroupList( CO204001IN inParam ){
		List<CO204001DTO> arrList = session.selectList( "CO2040.selectGroupList", inParam );
		return arrList;
	}

    /**
     * @brief 그룹 메뉴 조회
     * @details 그룹 메뉴 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO204002IN
     * @return List<CO204002DTO>
     */
    public List<CO204002DTO> selectGroupMenuList( CO204002IN inParam ){
        List<CO204002DTO> arrList = session.selectList( "CO2040.selectGroupMenuList", inParam );
        return arrList;
    }

    /**
     * @brief 그룹 메뉴 삭제
     * @details 그룹 메뉴 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO204003IN
     * @return int
     */
    public int deleteGroupMenu( CO204003IN inParam ){
        int iResult = session.delete( "CO2040.deleteGroupMenu", inParam );
        return iResult;
    }

    /**
     * @brief 그룹 메뉴 등록
     * @details 그룹 메뉴 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO204002DTO
     * @return int
     */
    public int insertGroupMenu( CO204002DTO dtoGroup ){
        int iResult = session.insert( "CO2040.insertGroupMenu", dtoGroup );
        return iResult;
    }
}
