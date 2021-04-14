/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SIFCG040006.java
 * @brief Source Generator Service
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 7. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service
 * @brief Common Service Package
 */
package com.encocns.fw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Service;

import com.encocns.fw.dao.FW2041DAO;
import com.encocns.fw.dto.FW204102DTO;
import com.encocns.fw.service.svo.FW204101IN;
import com.encocns.fw.service.svo.FW204101OUT;
import com.encocns.fw.service.svo.FW204102IN;
import com.encocns.fw.service.svo.FW204102OUT;

/**
 * @brief Source Generator Service
 * @details Source Generator Service
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 7. 24.
 * @version : 1.0.0
 */
@Service
public class FW2041 {

    @Autowired
    private FW2041DAO daoSourceGenerator;
    
    /**
     * @brief Table list search
     * @details Table list search 
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 7. 24.
     * @version : 1.0.0
     * @param inTableList
     * @return List Table list
     */
    public FW204101OUT selectTableList ( FW204101IN inTableList ) {
        FW204101OUT outTableList = new FW204101OUT();
        
        outTableList.setArrList(daoSourceGenerator.selectTableList(inTableList));

        return outTableList;
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
    public FW204102OUT selectColumnList ( FW204102IN inColumnList ) {
        FW204102OUT outColumnList = new FW204102OUT();
        
        
        List<FW204102DTO> arrList = daoSourceGenerator.selectColumnList(inColumnList);
        
        for( FW204102DTO col : arrList ) {
            col.setName(JdbcUtils.convertUnderscoreNameToPropertyName(col.getName()));
            
            String colType = "String";
            
            if( col.getType().indexOf("VAR")>=0 ) {
                colType = "String";
            }
            else if( col.getType().indexOf("TIME")>=0 ) {
                colType = "String";
            }
            else if( col.getType().indexOf("NUM")>=0 ) {
                
                if( col.getName().indexOf("AMT")>=0 ){
                    colType = "BigDecimal";
                }
                else {
                    colType = "int";
                }
            }
            
            col.setType(colType);
        }
        
        outColumnList.setArrList(arrList);
        
        return outColumnList;
    }
    
}
