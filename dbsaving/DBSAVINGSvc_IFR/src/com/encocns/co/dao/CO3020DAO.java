/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO3020DAO.java
 * @brief 메시지 코드 관리 DAO
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

import com.encocns.co.dto.CO302001DTO;
import com.encocns.co.service.svo.CO302001IN;
import com.encocns.co.service.svo.CO302002IN;
import com.encocns.co.service.svo.CO302003IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 메시지 코드 관리 DAO
 * @details 메시지 코드 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO3020DAO {

    @Autowired
    private SqlMapClient session;

    /**
     * @brief 메시지 조회
     * @details 메시지 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO302001IN
     * @return List<CO302001DTO>
     */
    public List<CO302001DTO> selectMessageCodeList( CO302001IN inParam ){
        List<CO302001DTO> arrList = session.selectList( "CO3020.selectMessageCodeList", inParam );
        return arrList;
    }

    /**
     * @brief 메시지 등록 및 수정
     * @details 메시지 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param inMsgCd
     */
    public int mergeMessageCode( CO302002IN inParam ){
    	return session.insert( "CO3020.mergeMessageCode", inParam );
    }

    /**
     * @brief 메시지 삭제
     * @details 메시지 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO302003IN
     * @return int
     */
    public int deleteMessageCode( CO302003IN inParam ){
        int iResult = session.delete( "CO3020.deleteMessageCode", inParam );
        return iResult;
    }

}