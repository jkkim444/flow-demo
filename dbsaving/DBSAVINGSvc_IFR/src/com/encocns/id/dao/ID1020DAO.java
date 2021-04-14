/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1020DAO.java
 * @brief 양식관리 DAO
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
import com.encocns.id.dto.ID102001DTO;
import com.encocns.id.dto.ID102002DTO;
import com.encocns.id.dto.ID102003DTO;
import com.encocns.id.service.svo.ID102001IN;
import com.encocns.id.service.svo.ID102002IN;

/**
 * @brief 양식관리 DAO
 * @details 양식관리 DAO
 * @author : 차상길
 * @date : 2020. 4. 23.
 * @version : 1.0.0
 */
@Repository
public class ID1020DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1020DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selectOnePbnfRptNm
     * @details 공시보고서 명칭 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID102001IN
     * @return String
     */
    public String selectOnePbnfRptNm(ID102001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectOnePbnfRptNm -----");
        return session.selectOne("ID1020.selectOnePbnfRptNm", inParam);
    }

	/**
     * @brief selectMergeCell
     * @details 공시보고서 병합 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID102001IN
     * @return List<ID102001DTO>
     */
    public List<ID102001DTO> selectMergeCell(ID102001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMergeCell -----");
        return session.selectList("ID1020.selectMergeCell", inParam);
    }

	/**
     * @brief selectHeader
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID102001IN
     * @return List<ID102001DTO>
     */
   public List<ID102001DTO> selectHeader(ID102001IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");
       return session.selectList("ID1020.selectHeader", inParam);
   }

	/**
    * @brief deleteHeaderData
    * @details 공시보고서 양식 삭제
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID102002IN
    * @return int
    */
   public int deleteHeaderData(ID102002IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteHeaderData -----");
       return session.delete("ID1020.deleteHeaderData", inParam);
   }

	/**
    * @brief deleteHeaderMergeCellData
    * @details 공시보고서 병합 삭제
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID102002IN
    * @return int
    */
   public int deleteHeaderMergeCellData(ID102002IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteHeaderMergeCellData -----");
       return session.delete("ID1020.deleteHeaderMergeCellData", inParam);
   }

	/**
    * @brief insertHeaderCellData
    * @details 공시보고서 양식 등록
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID104003IN in
    * @return String
    */
   public int insertHeaderCellData(ID102002DTO dto) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHeaderCellData -----");
       return session.insertBatch("ID1020.insertHeaderCellData", dto);
   }

	/**
    * @brief insertHeaderMergeCellData
    * @details 공시보고서 병합 등록
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID102003DTO
    * @return int
    */
   public int insertHeaderMergeCellData(ID102003DTO dto) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHeaderMergeCellData -----");
       return session.insertBatch("ID1020.insertHeaderMergeCellData", dto);
   }

	/**
    * @brief isExistPbnfRpt
    * @details 공시보고서 존재여부 조회
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID102001IN
    * @return int
    */
	public int isExistPbnfRpt(ID102001IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- isExistPbnfRpt -----");
       return session.selectOne("ID1020.isExistPbnfRpt", inParam);
   }

	/**
     * @brief mergeHeaderMergeCell
     * @details 공시보고서 병합 셀 셀 정보 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID102002IN
     * @return int
     */
   public int mergeHeaderMergeCell(ID102002IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeHeaderMergeCell -----");
       return session.update("ID1020.mergeHeaderMergeCell", inParam);
   }
}
