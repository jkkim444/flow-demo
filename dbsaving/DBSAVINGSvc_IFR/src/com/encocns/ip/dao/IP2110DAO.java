/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2110DAO.java
 * @brief 대손충당금 집계내역 관리 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.dao
 * @brief Common DAO Package
 */
package com.encocns.ip.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ip.dto.IP211001DTO;
import com.encocns.ip.dto.IP211002DTO;
import com.encocns.ip.dto.IP211003DTO;
import com.encocns.ip.service.svo.IP211001IN;
import com.encocns.ip.service.svo.IP211002IN;


/**
 * @brief 대손충당금 집계내역 관리 DAO
 * @details 대손충당금 집계내역 관리 DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2110DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2110DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 대손충당금 집계내역 조회 (PD기준)
     * @details 대손충당금 집계내역 조회 (PD기준)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211001IN
     * @return List<IP211001DTO>
     */
    public List<IP211001DTO> selectListPdLsrsrvTotl(IP211001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListPdLsrsrvTotl -----");
        return session.selectList("IP2110.selectListPdLsrsrvTotl", inParam);
    }

    /**
     * @brief 대손충당금 집계내역 조회 (LGD기준)
     * @details 대손충당금 집계내역 조회 (LGD기준)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211001IN
     * @return List<IP211001DTO>
     */
    public List<IP211001DTO> selectListlgdLsrsrvTotl(IP211001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListlgdLsrsrvTotl -----");
        return session.selectList("IP2110.selectListlgdLsrsrvTotl", inParam);
    }

    /**
     * @brief 대손충당금 집계내역 조회 (stg기준)
     * @details 대손충당금 집계내역 조회 (stg기준)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211001IN
     * @return List<IP211001DTO>
     */
    public List<IP211001DTO> selectListStgLsrsrvTotl(IP211001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListStgLsrsrvTotl -----");
        return session.selectList("IP2110.selectListStgLsrsrvTotl", inParam);
    }

    /**
     * @brief 대손충당금 집계내역 조회 (gds기준)
     * @details 대손충당금 집계내역 조회 (gds기준)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211001IN
     * @return List<IP211001DTO>
     */
    public List<IP211001DTO> selectListGdsLsrsrvTotl(IP211001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListGdsLsrsrvTotl -----");
        return session.selectList("IP2110.selectListGdsLsrsrvTotl", inParam);
    }

    /**
     * @brief 대손충당금 집계내역 조회 (변동분금액기준)
     * @details 대손충당금 집계내역 조회 (변동분금액기준)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211001IN
     * @return List<IP211001DTO>
     */
    public List<IP211001DTO> selectListStgSegLsrsrvTotl(IP211001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListStgSegLsrsrvTotl -----");
        return session.selectList("IP2110.selectListStgSegLsrsrvTotl", inParam);
    }

    /**
     * @brief 대손충당금 집계내역 조회 (PD+LGD기준)
     * @details 대손충당금 집계내역 조회 (PD+LGD기준)
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211001IN
     * @return List<IP211001DTO>
     */
    public List<IP211001DTO> selectListGdsPdLgd(IP211001IN inParam) {
    	if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListGdsPdLgd -----");
    	return session.selectList("IP2110.selectListGdsPdLgd", inParam);
    }

    /**
     * @brief 대손충당금 집계내역 엑셀 다운로드
     * @details 대손충당금 집계내역 엑셀 다운로드
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211001IN
     * @return List<IP211002DTO>
     */
    public List<IP211002DTO> selectListLsrsrvClclExcl(IP211001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLsrsrvClclExcl -----");
        return session.selectList("IP2110.selectListLsrsrvClclExcl", inParam);
    }

    /**
     * @brief LifeTime PD 산출 생성
     * @details LifeTime PD 산출 생성
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
	public int updateRsrvMdumClcl(IP211002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRsrvMdumClcl -----");
		return session.update("IP2110.updateRsrvMdumClcl", inParam);
	}

    /**
     * @brief 개별 충당금/미수충당금 산출 근거 생성
     * @details 개별 충당금/미수충당금 산출 근거 생성
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
	public int updateRsrvLastClclIndv(IP211002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRsrvLastClclIndv -----");
		return session.update("IP2110.updateRsrvLastClclIndv", inParam);
	}

    /**
     * @brief 충당금/미수충당금 산출 근거 생성
     * @details 충당금/미수충당금 산출 근거 생성
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
	public int updateRsrvLastClclBass(IP211002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRsrvLastClclBass -----");
		return session.update("IP2110.updateRsrvLastClclBass", inParam);
	}

    /**
     * @brief 충당금/미수충당금 산출 생성
     * @details 충당금/미수충당금 산출 생성
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
	public int updateRsrvLastClcl(IP211002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRsrvLastClcl -----");
		return session.update("IP2110.updateRsrvLastClcl", inParam);
	}

    /**
     * @brief 대손충당금 건별요약 삭제 처리
     * @details 대손충당금 건별요약 삭제 처리
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
    public int deleteBadlnrsrvpcsebrf(IP211002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteBadlnrsrvpcsebrf -----");
        return session.delete("IP2110.deleteBadlnrsrvpcsebrf", inParam);
    }

    /**
     * @brief 대손충당금 건별요약 등록
     * @details 대손충당금 건별요약 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
    public int insertBadlnrsrvpcsebrf(IP211002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertBadlnrsrvpcsebrf -----");
        return session.insert("IP2110.insertBadlnrsrvpcsebrf", inParam);
    }

    /**
     * @brief 고려전전입/환입 금액 산출
     * @details 고려전전입/환입 금액 산출
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211003DTO
     * @return IP211003DTO
     */
    public IP211003DTO selectMvinRetnAmt (IP211003DTO inParam ) {
        return session.selectOne("IP2110.selectMvinRetnAmt", inParam);
    }

    /**
     * @brief 당기제각회수정보관리 변경
     * @details 당기제각회수정보관리 변경
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211003DTO
     * @return int
     */
	public int updateDprnRtrv(IP211003DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateDprnRtrv -----");
		return session.update("IP2110.updateDprnRtrv", inParam);
	}

    /**
     * @brief 대손충당금 분개데이터대상내역 삭제
     * @details 대손충당금 분개데이터대상내역 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
    public int deleteCalcJrlzTrgtAmt(IP211002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
        return session.delete("IP2110.deleteCalcJrlzTrgtAmt", inParam);
    }

    /**
     * @brief 대손충당금 분개데이터대상내역 등록
     * @details 대손충당금 분개데이터대상내역 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
    public int insertCalcJrlzTrgtAmt(IP211002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmt -----");
        return session.insert("IP2110.insertCalcJrlzTrgtAmt", inParam);
    }

    /**
     * @brief 대손충당금 분개데이터상세 삭제
     * @details 대손충당금 분개데이터상세 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
    public int deletejrlzDtlProcs(IP211002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
        return session.delete("IP2110.deletejrlzDtlProcs", inParam);
    }

    /**
     * @brief 대손충당금 분개데이터상세 등록
     * @details 대손충당금 분개데이터상세 등록
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
    public int insertjrlzDtlProcs(IP211002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcs -----");
        return session.insert("IP2110.insertjrlzDtlProcs", inParam);
    }

    /**
     * @brief LifetimePD산출내역 삭제
     * @details LifetimePD산출내역 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
	public int deleteLtpdclclhistAll(IP211002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLtpdclclhistAll -----");
		return session.delete("IP2110.deleteLtpdclclhistAll", inParam);
	}

    /**
     * @brief 대손충당금산출내역 삭제
     * @details 대손충당금산출내역 삭제
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return int
     */
	public int deleteLsrsrvclclhistAll(IP211002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteLsrsrvclclhistAll -----");
		return session.delete("IP2110.deleteLsrsrvclclhistAll", inParam);
	}
}
