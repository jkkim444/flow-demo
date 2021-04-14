/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID2010DAO.java
 * @brief 공시보고서수기관리 DAO
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
import com.encocns.id.dto.ID202001DTO;
import com.encocns.id.dto.ID202002DTO;
import com.encocns.id.dto.ID202003DTO;
import com.encocns.id.service.svo.ID202001IN;
import com.encocns.id.service.svo.ID202002IN;

/**
 * @brief 공시보고서수기관리 DAO
 * @details 공시보고서수기관리 DAO
 * @author : 차 상 길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID2020DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID2020DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selectOnePbnfRptNm
     * @details 공시보고서 명칭 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID202001IN
     * @return String
     */
    public String selectOnePbnfRptNm(ID202001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectOnePbnfRptNm -----");
        return session.selectOne("ID2020.selectOnePbnfRptNm", inParam);
    }

	/**
     * @brief selectRptFin
     * @details 공시보고서 확인 여부 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID202001IN
     * @return String
     */
    public String selectRptFin(ID202001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectRptFin -----");
        return session.selectOne("ID2020.selectRptFin", inParam);
    }

	/**
     * @brief selectHeader
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID202001IN
     * @return List<ID202001DTO>
     */
   public List<ID202001DTO> selectHeader(ID202001IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");
       return session.selectList("ID2020.selectHeader", inParam);
   }

	/**
    * @brief selectMergeCell
    * @details 공시보고서 병합 조회
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID202001IN
    * @return List<ID202002DTO>
    */
   public List<ID202002DTO> selectMergeCell(ID202001IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMergeCell -----");
       return session.selectList("ID2020.selectMergeCell", inParam);
   }

	/**
    * @brief insertRptLog
    * @details 공시보고서 수기등록 변경내역 기록
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID202003DTO
    * @return int
    */
   public int insertRptLog(ID202003DTO dtoParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRptLog -----");
       return session.insert("ID2020.insertRptLog", dtoParam);
   }

	/**
    * @brief mergeClcl
    * @details 공시보고서 산출 정보 수정
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID202003DTO
    * @return int
    */
   public int mergeClcl(ID202003DTO dtoParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeClcl -----");
       return session.insert("ID2020.mergeClcl", dtoParam);
   }

	/**
    * @brief updateClclCustom
    * @details 공시보고서 산출 정보 수정 (별도)
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID202003DTO
    * @return int
    */
   public int updateClclCustom(ID202003DTO dtoParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClclCustom -----");
       return session.update("ID2020.updateClclCustom", dtoParam);
   }

	/**
    * @brief mergeClclSum
    * @details 공시보고서 산출정보 합계 수정
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID202003DTO
    * @return int
    */
   public int mergeClclSum(ID202003DTO dtoParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeClclSum -----");
       return session.insert("ID2020.mergeClclSum", dtoParam);
   }

	/**
    * @brief mergeValbaSum
    * @details 공시보고서 검증 합계 수정
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID202003DTO
    * @return int
    */
   public int mergeValbaSum(ID202003DTO dtoParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeValbaSum -----");
       return session.insert("ID2020.mergeValbaSum", dtoParam);
   }

	/**
    * @brief updateValba
    * @details 공시보고서 검증 정보 수정
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID202003DTO
    * @return int
    */
   public int updateValba(ID202003DTO dtoParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateValba -----");
       return session.update("ID2020.updateValba", dtoParam);
   }

	/**
    * @brief mergeRptFin
    * @details 공시보고서 확인여부 수정
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID202002IN
    * @return int
    */
   public int mergeRptFin(ID202002IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRptFin -----");
       return session.update("ID2020.mergeRptFin", inParam);
   }

	/**
    * @brief deleteRptFin
    * @details 공시보고서 확인여부 제거
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID202002IN
    * @return int
    */
   public int deleteRptFin(ID202002IN inParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRptFin -----");
       return session.delete("ID2020.deleteRptFin", inParam);
   }

   public void flush(){
 	 session.flushStatements();
   }
}
