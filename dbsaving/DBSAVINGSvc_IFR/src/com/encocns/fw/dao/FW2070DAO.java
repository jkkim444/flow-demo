/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW2070DAO.java
 * @brief Create Annotation DAO
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 11. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dao
 * @brief Common DAO Package
 */
package com.encocns.fw.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.fw.dto.FW207001DTO;
import com.encocns.fw.service.svo.FW207001IN;

/**
 * @brief Service List DAO
 * @details Service List DAO
 * @author : CHA, SANG-GIL
 * @date : 2019. 6. 13.
 * @version : 1.0.0
 */
@Repository
public class FW2070DAO {

	@Autowired
    private SqlMapClient session;
	
    /**
     * @brief column name inquiry
     * @details column name inquiry
     * @author : CHA, SANG-GIL
     * @date : 2019. 7. 11.
     * @version : 1.0.0
     * @param inSearchParam
     * @return ArrayList list
     */
	public ArrayList<FW207001DTO> selectColumnName( FW207001IN inSearchParam ){
		ArrayList<FW207001DTO> arrList = (ArrayList)session.selectList( "FW2070.selectColumnName", inSearchParam );
		return arrList;
		
	}
}
