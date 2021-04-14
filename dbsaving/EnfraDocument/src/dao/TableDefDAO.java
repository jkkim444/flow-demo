/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1010DAO.java
 * @brief Service Management DAO
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 6. 20. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dao
 * @brief Common DAO Package
 */
package dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import db.CamelHashMap;
import db.SqlMapClient;

/**
 * @brief Service Management List DAO
 * @details Service Management List DAO
 * @author : CHA, SANG-GIL
 * @date : 2019. 6. 20.
 * @version : 1.0.0
 */
@Repository
public class TableDefDAO {

	@Autowired
	private SqlMapClient session;
	
	public ArrayList<CamelHashMap> selectTblList( String owner ){
		ArrayList<CamelHashMap> arrList = (ArrayList)session.selectList("TableDef.selectTblList", owner);
		return arrList;
	}

}
