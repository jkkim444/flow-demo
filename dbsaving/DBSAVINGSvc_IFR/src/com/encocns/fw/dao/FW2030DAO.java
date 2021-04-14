/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SIFCG040006DAO.java
 * @brief Source Generator DAO
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 7. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dao
 * @brief Common DAO Package
 */
package com.encocns.fw.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.fw.dto.FW203001DTO;
import com.encocns.fw.service.svo.FW203001IN;

/**
 * @brief Source Generator DAO
 * @details Source Generator DAO 
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 7. 24.
 * @version : 1.0.0
 */
@Repository
public class FW2030DAO {

    @Autowired
    private SqlMapClient session;
    
    /**
     * @brief Table list search
     * @details Table list search
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 7. 24.
     * @version : 1.0.0
     * @param inTableList
     * @return List Table list
     */
    public int selectTotalCount ( FW203001IN isvo ) {
        return session.selectOne("FW2030.selectTotalCount", isvo);
    }
    
    /**
     * @brief Column list search
     * @details Column list search
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 7. 24.
     * @version : 1.0.0
     * @param inColumnList
     * @return List Column list
     */
    public List<FW203001DTO> selectPaging( FW203001IN isvo ) {
        return session.selectList("FW2030.selectPaging", isvo);
    }
    
    
    public List<FW203001DTO> selectList( FW203001IN isvo ) {
        return session.selectList("FW2030.selectList", isvo);
    }
    
    public int insertTemplate( FW203001DTO isvo ) {
        return session.insertBatch("FW2030.insertTemplate", isvo);
    }
    
    public int deleteTemplate() {
        return session.delete("FW2030.deleteTemplate", null);
    }
    
    
    public void flush() {
    	session.flushStatements();
    }
}
