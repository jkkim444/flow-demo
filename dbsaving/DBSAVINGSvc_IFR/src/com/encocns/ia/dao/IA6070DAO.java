/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6070DAO.java
 * @brief 공정가치금융자산내역 관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dao
 * @brief Common DAO Package
 */
package com.encocns.ia.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ia.dto.IA607001DTO;
import com.encocns.ia.dto.IA607002DTO;
import com.encocns.ia.dto.IA607003DTO;
import com.encocns.ia.service.svo.IA607001IN;
import com.encocns.ia.service.svo.IA607002IN;
import com.encocns.ia.service.svo.IA607003IN;

/**
 * @brief 공정가치금융자산내역 관리 DAO
 * @details 공정가치금융자산내역 관리 DAO
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA6070DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6070DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 적용세율에 따른 법인세비용 구간별 계산 조회 (기초데이터)
     * @details 적용세율에 따른 법인세비용 구간별 계산 조회 (기초데이터)
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607001IN
     * @return List<IA607001DTO>
     */
    public List<IA607001DTO> selectPsectCrtxCostBassList(IA607001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectPsectCrtxCostBassList -----");
        return session.selectList("IA6070.selectPsectCrtxCostBassList", inParam);
    }

    /**
     * @brief 적용세율에 따른 법인세비용 구간별 계산 조회
     * @details 적용세율에 따른 법인세비용 구간별 계산 조회
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607001IN
     * @return List<IA607001DTO>
     */
    public List<IA607001DTO> selectPsectCrtxCostList(IA607001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectPsectCrtxCostList -----");
        return session.selectList("IA6070.selectPsectCrtxCostList", inParam);
    }

    /**
     * @brief 구간별 산출 세액 총금액 및 적용세율 조회
     * @details 구간별 산출 세액 총금액 및 적용세율 조회
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607001IN
     * @return IA607002DTO
     */
    public IA607002DTO selectCrtxAplyTxrt(IA607001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectCrtxAplyTxrt -----");
        return session.selectOne("IA6070.selectCrtxAplyTxrt", inParam);
    }

    /**
     * @brief 비과세수익 및 비공제비용 조회
     * @details 비과세수익 및 비공제비용 조회
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607001IN
     * @return List<IA607003DTO>
     */
    public List<IA607003DTO> selectCrtxcostList(IA607001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectCrtxcostList -----");
        return session.selectList("IA6070.selectCrtxcostList", inParam);
    }

    /**
     * @brief 적용세율에 따른 법인세비용 구간별 계산 등록
     * @details 적용세율에 따른 법인세비용 구간별 계산 등록
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607001DTO
     * @return int
     */
	public int insertPsectCrtxCost(IA607001DTO dtoParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertPsectCrtxCost -----");
		return session.insert("IA6070.insertPsectCrtxCost", dtoParam);
	}

    /**
     * @brief 구간별 산출 세액 총금액 및 적용세율 등록
     * @details 구간별 산출 세액 총금액 및 적용세율 등록
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607002IN
     * @return int
     */
	public int insertCrtxAplyTxrt(IA607002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCrtxAplyTxrt -----");
		return session.insert("IA6070.insertCrtxAplyTxrt", inParam);
	}

    /**
     * @brief 비과세수익 및 비공제비용 등록
     * @details 비과세수익 및 비공제비용 등록
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607003DTO
     * @return int
     */
	public int insertCrtxcost(IA607003DTO dtoParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCrtxcost -----");
		return session.insert("IA6070.insertCrtxcost", dtoParam);
	}

    /**
     * @brief 적용세율에 따른 법인세비용 구간별 계산 삭제
     * @details 적용세율에 따른 법인세비용 구간별 계산 삭제
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607003IN
     * @return int
     */
	public int deletePsectCrtxCost(IA607003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletePsectCrtxCost -----");
		return session.delete("IA6070.deletePsectCrtxCost", inParam);
	}

    /**
     * @brief 비과세수익 및 비공제비용 삭제
     * @details 비과세수익 및 비공제비용 삭제
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607003IN
     * @return int
     */
	public int deleteCrtxcost(IA607003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCrtxcost -----");
		return session.delete("IA6070.deleteCrtxcost", inParam);
	}

    /**
     * @brief 구간별 산출 세액 총금액 및 적용세율 삭제
     * @details 구간별 산출 세액 총금액 및 적용세율 삭제
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607003IN
     * @return int
     */
	public int deleteCrtxAplyTxrt(IA607003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCrtxAplyTxrt -----");
		return session.delete("IA6070.deleteCrtxAplyTxrt", inParam);
	}

}
