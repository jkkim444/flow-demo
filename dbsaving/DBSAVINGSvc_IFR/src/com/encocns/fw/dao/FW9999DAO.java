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
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief Service List DAO
 * @details Service List DAO
 * @author : CHA, SANG-GIL
 * @date : 2019. 6. 13.
 * @version : 1.0.0
 */
@Repository
public class FW9999DAO {

	@Autowired
    private SqlMapClient session;
	
	public ArrayList<Map> selectTest( Map q ){
	    ArrayList<Map> arrList = (ArrayList)session.selectList( "FW9999.selectTest", q );
		return arrList;
		
	}
	
    public int updateTest( Map q ){
        return session.update( "FW9999.updateTest", q );
    }
    
    public int insertTest( Map q ){
        return session.insert( "FW9999.insertTest", q );
    }
    
    public int deleteTest( Map q ){
        return session.delete( "FW9999.deleteTest", q );
    }
    
    
	
}
