/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1050DAO.java
 * @brief 검증기준관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.dao
 * @brief ID DAO Package
 */
package com.encocns.id.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.id.dto.ID105001DTO;
import com.encocns.id.dto.ID105002DTO;
import com.encocns.id.dto.ID105003DTO;
import com.encocns.id.service.svo.ID105001IN;
import com.encocns.id.service.svo.ID105002IN;
import com.encocns.id.service.svo.ID105003IN;

/**
 * @brief 검증기준관리 DAO
 * @details 검증기준관리 DAO
 * @author : 차 상 길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID1050DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1050DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selectOnePbnfRptNm
     * @details 공시보고서 명칭 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105001IN
     * @return String
     */
	public String selectOnePbnfRptNm(ID105001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectOnePbnfRptNm -----");
        return session.selectOne("ID1050.selectOnePbnfRptNm", inParam);
    }

	/**
     * @brief selectHeader
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105001IN
     * @return List<ID105001DTO>
     */
    public List<ID105001DTO> selectHeader(ID105001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");
        return session.selectList("ID1050.selectHeader", inParam);
    }

	/**
     * @brief selectMergeCell
     * @details 공시보고서 병합 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105001IN
     * @return List<ID105002DTO>
     */
	public List<ID105002DTO> selectMergeCell(ID105001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMergeCell -----");
        return session.selectList("ID1050.selectMergeCell", inParam);
    }

	/**
     * @brief selectValbaList
     * @details 공시보고서 검증 기준 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105002IN
     * @return List<ID105003DTO>
     */
    public List<ID105003DTO> selectValbaList(ID105002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectValbaList -----");
        return session.selectList("ID1050.selectValbaList", inParam);
    }


	/**
     * @brief selectCellId
     * @details 공시보고서 셀 ID 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105003IN
     * @return String
     */
	public String selectCellId(ID105003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectCellId -----");
        return (String)session.selectOne("ID1050.selectCellId", inParam);
    }

	/**
     * @brief deleteValba
     * @details 검증 기준 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105003IN
     * @return int
     */
	public int deleteValba(ID105003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteValba -----");
        return session.delete("ID1050.deleteValba", inParam);
    }

	/**
     * @brief insertValba
     * @details 검증 기준 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105003DTO
     * @return int
     */
	public int insertValba(ID105003DTO dtoParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertValba -----");
        return session.insert("ID1050.insertValba", dtoParam);
    }
}
