/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID2010DAO.java
 * @brief 공시보고서목록관리 DAO
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
import com.encocns.id.dto.ID201001DTO;
import com.encocns.id.dto.ID201002DTO;
import com.encocns.id.service.svo.ID201001IN;
import com.encocns.id.service.svo.ID201002IN;
import com.encocns.id.service.svo.ID201004IN;

/**
 * @brief 공시보고서목록관리 DAO
 * @details 공시보고서목록관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID2010DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID2010DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selectRptbsList
     * @details 공시보고서 명칭 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201001IN
     * @return List<ID201001DTO>
     */
    public List<ID201001DTO> selectRptbsList(ID201001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectRptbsList -----");
        return session.selectList("ID2010.selectRptbsList", inParam);
    }

	/**
     * @brief selectHeader
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201002IN
     * @return List<ID201002DTO>
     */
    public List<ID201002DTO> selectHeader(ID201002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");
        return session.selectList("ID2010.selectHeader", inParam);
    }

	/**
     * @brief selectMergeCell
     * @details 공시보고서 병합 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201002IN
     * @return List<ID201002DTO>
     */
    public List<ID201002DTO> selectMergeCell(ID201002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMergeCell -----");
        return session.selectList("ID2010.selectMergeCell", inParam);
    }

	/**
     * @brief selectHeaderExcel
     * @details 공시보고서 엑셀 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201001DTO
     * @return List<ID201002DTO>
     */
    public List<ID201002DTO> selectHeaderExcel(ID201001DTO dtoParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeaderExcel -----");
        return session.selectList("ID2010.selectHeaderExcel", dtoParam);
    }

	/**
     * @brief selectMergeCellExcel
     * @details 공시보고서 엑셀 병합 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201001DTO
     * @return List<ID201002DTO>
     */
    public List<ID201002DTO> selectMergeCellExcel(ID201001DTO dtoParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMergeCellExcel -----");
        return session.selectList("ID2010.selectMergeCellExcel", dtoParam);
    }

	/**
     * @brief selectMaxColNum
     * @details 공시보고서 최대 컬럼수 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201001DTO
     * @return int
     */
   public int selectMaxColNum(ID201001DTO dtoParam) {
       if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMaxColNum -----");
       return session.selectOne("ID2010.selectMaxColNum", dtoParam);
   }


	/**
    * @brief deleteRptFin
    * @details 공시보고서 확인여부 제거
    * @author : 차상길
    * @date : 2020. 11. 26.
    * @version : 1.0.0
    * @param ID201004IN
    * @return int
    */
	public int deleteRptFin(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRptFin -----");
		return session.delete("ID2010.deleteRptFin", inParam);
	}

	/**
     * @brief deleteNdrprExprCf
     * @details 예수부채 만기에 따른 현금흐름 데이터 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int deleteNdrprExprCf(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteNdrprExprCf -----");
		return session.delete("ID2010.deleteNdrprExprCf", inParam);
	}

	/**
     * @brief insertNdrprExprCf
     * @details 예수부채 만기에 따른 현금흐름 데이터 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int insertNdrprExprCf(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertNdrprExprCf -----");
		return session.insert("ID2010.insertNdrprExprCf", inParam);
	}

	/**
     * @brief updateCalcJrlzTrgtAmt
     * @details 공시보고서산출기준 초기화
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateCalcJrlzTrgtAmt(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateCalcJrlzTrgtAmt -----");
		return session.update("ID2010.updateCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief deleteCalcJrlzTrgtAmt
     * @details 공시보고서산출명세 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int deleteCalcJrlzTrgtAmt(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("ID2010.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief updateClcbaCustom
     * @details 공시보고서 산출 (별도)
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateClcbaCustom(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClcbaCustom -----");
		return session.update("ID2010.updateClcbaCustom", inParam);
	}

	/**
     * @brief updateClcbaAccd1
     * @details 공시보고서 데이터 생성 ( 기말 계정 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateClcbaAccd1(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClcbaAccd1 -----");
		return session.update("ID2010.updateClcbaAccd1", inParam);
	}

	/**
     * @brief updateClcbaAccdKgaap1
     * @details 공시보고서 데이터 생성 ( K-GAAP )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateClcbaAccdKgaap1(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClcbaAccdKgaap1 -----");
		return session.update("ID2010.updateClcbaAccdKgaap1", inParam);
	}

	/**
     * @brief updateClcbaAccd2
     * @details 공시보고서 데이터 생성 ( 기초 계정 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateClcbaAccd2(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClcbaAccd2 -----");
		return session.update("ID2010.updateClcbaAccd2", inParam);
	}

	/**
     * @brief updateClcbaSum
     * @details 공시보고서 데이터 생성 ( 합계 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateClcbaSum(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClcbaSum -----");
		return session.update("ID2010.updateClcbaSum", inParam);
	}

	/**
     * @brief updateClcbaAnother
     * @details 공시보고서 데이터 생성 ( 타보고서 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateClcbaAnother(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClcbaAnother -----");
		return session.update("ID2010.updateClcbaAnother", inParam);
	}

	/**
     * @brief updateClcbaAnotherSum
     * @details 공시보고서 데이터 생성 ( 타보고서 합계 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateClcbaAnotherSum(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClcbaAnotherSum -----");
		return session.update("ID2010.updateClcbaAnotherSum", inParam);
	}

	/**
     * @brief insertClcl
     * @details 공시보고서 데이터 생성 ( 합계테이블 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int insertClcl(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertClcl -----");
		return session.insert("ID2010.insertClcl", inParam);
	}

	/**
     * @brief updateClclCustom
     * @details 공시보고서 데이터 생성 ( 합계테이블 별도)
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateClclCustom(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateClclCustom -----");
		return session.update("ID2010.updateClclCustom", inParam);
	}

	/**
     * @brief updateValbaAccd
     * @details 검증 데이터 생성 ( 기말 계정 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104101IN
     * @return String
     */
	public int updateValbaAccd(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateValbaAccd -----");
		return session.update("ID2010.updateValbaAccd", inParam);
	}

	/**
     * @brief updateValbaAccd2
     * @details 검증 데이터 생성 ( 기초 계정 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateValbaAccd2(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateValbaAccd2 -----");
		return session.update("ID2010.updateValbaAccd2", inParam);
	}

	/**
     * @brief updateValbaCell
     * @details 검증 데이터 생성 ( 셀 데이터 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return int
     */
	public int updateValbaCell(ID201004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateValbaCell -----");
		return session.update("ID2010.updateValbaCell", inParam);
	}
}