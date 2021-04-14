/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1010DAO.java
 * @brief 기본정보관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief Common DAO Package
 */
package com.encocns.id.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.id.dto.ID101001DTO;
import com.encocns.id.service.svo.ID101001IN;
import com.encocns.id.service.svo.ID101002IN;

/**
 * @brief 기본정보관리 DAO
 * @details 기본정보관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class ID1010DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1010DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief selRptList
     * @details 공시보고서 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101001IN
     * @return List<ID101001DTO>
     */
    public List<ID101001DTO> selRptList(ID101001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selRptList -----");
        return session.selectList("ID1010.selRptList", inParam);
    }

	/**
     * @brief insertTbIdMHdrmgBass
     * @details 기초 생성 ( 병합 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int insertTbIdMHdrmgBass(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertTbIdMHdrmgBass -----");
		return session.insert("ID1010.insertTbIdMHdrmgBass", inParam);
	}

	/**
     * @brief insertTbIdMRpthdrBass
     * @details 기초 생성 ( 양식 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int insertTbIdMRpthdrBass(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertTbIdMRpthdrBass -----");
		return session.insert("ID1010.insertTbIdMRpthdrBass", inParam);
	}

	/**
     * @brief insertTbIdMClcbaBass
     * @details 기초 생성 ( 산출 정보 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int insertTbIdMClcbaBass(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertTbIdMClcbaBass -----");
		return session.insert("ID1010.insertTbIdMClcbaBass", inParam);
	}

	/**
     * @brief insertTbIdMValbaBass
     * @details 기초 생성 ( 검증 정보 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int insertTbIdMValbaBass(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertTbIdMValbaBass -----");
		return session.insert("ID1010.insertTbIdMValbaBass", inParam);
	}

	/**
     * @brief deleteTbIdMHdrmgBass
     * @details 기초 생성 전 초기화 ( 병합 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int deleteTbIdMHdrmgBass(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteTbIdMHdrmgBass -----");
		return session.delete("ID1010.deleteTbIdMHdrmgBass", inParam);
	}

	/**
     * @brief deleteTbIdMRpthdrBass
     * @details 기초 생성 전 초기화 ( 양식 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int deleteTbIdMRpthdrBass(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteTbIdMRpthdrBass -----");
		return session.delete("ID1010.deleteTbIdMRpthdrBass", inParam);
	}

	/**
     * @brief deleteTbIdMClcbaBass
     * @details 기초 생성 전 초기화 ( 산출 정보 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int deleteTbIdMClcbaBass(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteTbIdMClcbaBass -----");
		return session.delete("ID1010.deleteTbIdMClcbaBass", inParam);
	}

	/**
     * @brief deleteTbIdIClclBass
     * @details 기초 생성 전 초기화 ( 산출 합계 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int deleteTbIdIClclBass(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteTbIdIClclBass -----");
		return session.delete("ID1010.deleteTbIdIClclBass", inParam);
	}

	/**
     * @brief deleteTbIdMValbaBass
     * @details 기초 생성 전 초기화 ( 검증 정보 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int deleteTbIdMValbaBass(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteTbIdMValbaBass -----");
		return session.delete("ID1010.deleteTbIdMValbaBass", inParam);
	}

	/**
     * @brief deleteRptFinHist
     * @details 기초 생성 전 초기화 ( 보고서 완료내역 )
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return int
     */
	public int deleteRptFinHist(ID101002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRptFinHist -----");
		return session.delete("ID1010.deleteRptFinHist", inParam);
	}

}
