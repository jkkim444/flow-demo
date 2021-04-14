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
public class OnlineDesignDAO {

	@Autowired
	private SqlMapClient session;
	
	public ArrayList<CamelHashMap> selectServiceList(){
		ArrayList<CamelHashMap> arrList = (ArrayList)session.selectList("OnlineDesign.selectServiceList");
		return arrList;
	}
	
	public CamelHashMap selectSubject( String svcId ){
		CamelHashMap subejct  = session.selectOne("OnlineDesign.selectSubject", svcId);
		return subejct;
	}
	
	public CamelHashMap selectClassDef( String svcId  ){
		CamelHashMap classDef = session.selectOne("OnlineDesign.selectClassDef", svcId);
		return classDef;
	}
	
	public ArrayList<CamelHashMap> selectMethodDefList( String svcId  ){
		ArrayList<CamelHashMap> arrList = (ArrayList)session.selectList("OnlineDesign.selectMethodDefList", svcId);
		return arrList;
	}
	
	public ArrayList<CamelHashMap> selectMethodList( String svcId  ){
		ArrayList<CamelHashMap> arrList = (ArrayList)session.selectList("OnlineDesign.selectMethodList", svcId);
		return arrList;
	}

}
