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
import com.encocns.fw.dto.FW204101DTO;
import com.encocns.fw.dto.FW204102DTO;
import com.encocns.fw.service.svo.FW204101IN;
import com.encocns.fw.service.svo.FW204102IN;

/**
 * @brief Source Generator DAO
 * @details Source Generator DAO 
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 7. 24.
 * @version : 1.0.0
 */
@Repository
public class FW2041DAO {

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
    public List<FW204101DTO> selectTableList( FW204101IN inTableList ) {
        return session.selectList("FW2041.selectTableList", inTableList);
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
    public List<FW204102DTO> selectColumnList( FW204102IN inColumnList ) {
        return session.selectList("FW2041.selectColumnList", inColumnList);
    }
    
}
