/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO1010DAO.java
 * @brief 사용자 관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 03. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief Common DAO Package
 */
package com.encocns.co.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO101001DTO;
import com.encocns.co.service.svo.CO101001IN;
import com.encocns.co.service.svo.CO101002IN;
import com.encocns.co.service.svo.CO101003IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 사용자 관리 DAO
 * @details 사용자 관리 DAO
 * @author : 차상길
 * @date : 2020. 09. 03.
 * @version : 1.0.0
 */
@Repository
public class CO1010DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO1010DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param CO101001IN
     * @return ArrayList<CO101001DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<CO101001DTO> selectUserList(CO101001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectUserList -----");
        return (ArrayList)session.selectList("CO1010.selectUserList", inParam);
    }

    /**
     * @brief 사용자 정보 등록
     * @details 사용자 정보 등록
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param CO101002IN
     * @return int
     */
    public int insertUser(CO101002IN inParam) {
        int iResult = session.insert("CO1010.insertUser", inParam);
        return iResult;
    }


    /**
     * @brief 그룹 사용자 매핑
     * @details 그룹 사용자 매핑
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param CO101002IN
     * @return int
     */
    public int insertGroupUser(CO101002IN inParam) {
        int iResult = session.insert("CO1010.insertGroupUser", inParam);
        return iResult;
    }

    /**
     * @brief 사용자 정보 업데이트
     * @details 사용자 정보 업데이트
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param CO101002IN
     * @return int
     */
    public int updateUser(CO101002IN inParam) {
        int iResult = session.update("CO1010.updateUser", inParam);
        return iResult;
    }

    /**
     * @brief 사용자 정보 삭제
     * @details 사용자 정보 삭제
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param CO101003IN
     * @return int
     */
    public int deleteUser(CO101003IN inParam) {
        int iResult = session.delete("CO1010.deleteUser", inParam);
        return iResult;
    }

    /**
     * @brief 그룹 사용자 정보 삭제
     * @details 그룹 사용자 정보 삭제
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param CO101003IN
     * @return int
     */
    public int deleteGroupUser(CO101003IN inParam) {
        int iResult = session.delete("CO1010.deleteGroupUser", inParam);
        return iResult;
    }
}
