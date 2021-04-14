/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1040DAO.java
 * @brief 산출기준관리 DAO
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
import com.encocns.id.dto.ID104001DTO;
import com.encocns.id.dto.ID104002DTO;
import com.encocns.id.dto.ID104003DTO;
import com.encocns.id.service.svo.ID104001IN;
import com.encocns.id.service.svo.ID104002IN;
import com.encocns.id.service.svo.ID104003IN;

/**
 * @brief 산출기준관리 DAO
 * @details 산출기준관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID1040DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1040DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selectOnePbnfRptNm
     * @details 공시보고서 명칭 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104001IN
     * @return String
     */
	public String selectOnePbnfRptNm(ID104001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectOnePbnfRptNm -----");
        return (String)session.selectOne("ID1040.selectOnePbnfRptNm", inParam);
    }

	/**
     * @brief selectHeader
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104001IN
     * @return List<ID104001DTO>
     */
    public List<ID104001DTO> selectHeader(ID104001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");
        return session.selectList("ID1040.selectHeader", inParam);
    }

	/**
     * @brief selectMergeCell
     * @details 공시보고서 병합 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104001IN
     * @return List<ID104002DTO>
     */
    public List<ID104002DTO> selectMergeCell(ID104001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMergeCell -----");
        return session.selectList("ID1040.selectMergeCell", inParam);
    }

	/**
     * @brief selectClcbaList
     * @details 공시보고서 산출 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104002IN
     * @return List<ID104003DTO>
     */
    public List<ID104003DTO> selectClcbaList(ID104002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClcbaList -----");
        return session.selectList("ID1040.selectClcbaList", inParam);
    }

	/**
     * @brief selectCellId
     * @details 셀 ID 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104003IN
     * @return String
     */
	public String selectCellId(ID104003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectCellId -----");
        return (String)session.selectOne("ID1040.selectCellId", inParam);
    }

	/**
     * @brief deleteClcba
     * @details 산출기준 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104003IN
     * @return int
     */
	public int deleteClcba(ID104003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteClcba -----");
        return session.delete("ID1040.deleteClcba", inParam);
    }

	/**
     * @brief insertClcba
     * @details 산출기준 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104003DTO
     * @return int
     */
	public int insertClcba(ID104003DTO dtoParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertClcba -----");
        return session.insert("ID1040.insertClcba", dtoParam);
    }

}
