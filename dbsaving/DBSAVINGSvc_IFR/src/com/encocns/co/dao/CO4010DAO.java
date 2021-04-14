/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO4010DAO.java
 * @brief 공지사항 관리 DAO
 * @section Major History
 * <pre>
 *   - CHOI,HO-YEON | 2020. 10. 19. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief Common DAO Package
 */
package com.encocns.co.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO401001DTO;
import com.encocns.co.service.svo.CO401001IN;
import com.encocns.co.service.svo.CO401002IN;
import com.encocns.co.service.svo.CO401003IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 공지사항관리 management List DAO
 * @details 공지사항관리 management List DAO
 * @author : CHOI,HO-YEON
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
@Repository
public class CO4010DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO4010DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 공지사항 조회
     * @details 공지사항 조회
     * @author : CHOI,HO-YEON
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401001IN
     * @return List<CO401001DTO>
     */
    public List<CO401001DTO> selectListCmknMtr(CO401001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListCmknMtr -----");
        return session.selectList("CO4010.selectListCmknMtr", inParam);
    }

    /**
     * @brief 총 건수 조회
     * @details 총 건수 조회
     * @author : CHOI,HO-YEON
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401001IN
     * @return int
     */
    public int selectTotalCount ( CO401001IN inParam ) {
        return session.selectOne("CO4010.selectTotalCount", inParam);
    }

    /**
     * @brief 페이징 조회
     * @details 페이징 조회
     * @author : CHOI,HO-YEON
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401001IN
     * @return List<CO401001DTO>
     */
    public List<CO401001DTO> selectPaging( CO401001IN inParam ) {
        return session.selectList("CO4010.selectPaging", inParam);
    }
    /**
     * @brief 공지사항 등록 및 수정
     * @details 공지사항 등록 및 수정
     * @author : CHOI,HO-YEON
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401002IN
     * @return int
     */
	public int mergeCmknMtr(CO401002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeCmknMtr -----");
		return session.insert("CO4010.mergeCmknMtr", inParam);
	}

    /**
     * @brief 공지사항 삭제
     * @details 공지사항 삭제
     * @author : CHOI,HO-YEON
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401003IN
     * @return int
     */
	public int deleteCmknMtr(CO401003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCmknMtr -----");
		return session.delete("CO4010.deleteCmknMtr", inParam);
	}

	/**
     * @brief 공지사항 조회 횟수 증가
     * @details 공지사항 조회 횟수 증가
     * @author : CHOI,HO-YEON
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401003IN
     * @return int
     */
	public int updateCmknMtrViews(CO401003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateCmknMtrViews -----");
		return session.update("CO4010.updateCmknMtrViews", inParam);
	}

	/**
     * @brief 공지사항 등록
     * @details 공지사항 등록
     * @author : CHOI,HO-YEON
     * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401002IN
     * @return int
     */
	public int insertCmknMtr(CO401002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCmknMtr -----");
		return session.insert("CO4010.insertCmknMtr", inParam);
	}


}
