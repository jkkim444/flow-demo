/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6030DAO.java
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
import com.encocns.ia.dto.IA603001DTO;
import com.encocns.ia.service.svo.IA603001IN;
import com.encocns.ia.service.svo.IA603002IN;
import com.encocns.ia.service.svo.IA603003IN;
import com.encocns.ia.service.svo.IA603004IN;

/**
 * @brief 공정가치금융자산내역 관리 DAO
 * @details 공정가치금융자산내역 관리 DAO
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA6030DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6030DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 무형자산 변동내역 조회
     * @details 무형자산 변동내역 조회
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA603001IN
     * @return List<IA603001DTO>
     */
    public List<IA603001DTO> selectItgastchgList(IA603001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectItgastchgList -----");
        return session.selectList("IA6030.selectItgastchgList", inParam);
    }

    /**
     * @brief 무형자산 변동내역 저장
     * @details 무형자산 변동내역 저장
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA603002IN
     * @return int
     */
	public int insertItgastchg(IA603002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertItgastchg -----");
		return session.insert("IA6030.insertItgastchg", inParam);
	}

    /**
     * @brief 무형자산 변동내역 수정
     * @details 무형자산 변동내역 수정
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA603002IN
     * @return int
     */
	public int updateItgastchg(IA603002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateItgastchg -----");
		return session.update("IA6030.updateItgastchg", inParam);
	}

    /**
     * @brief 무형자산 변동내역 엑셀저장
     * @details 무형자산 변동내역 엑셀저장
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA603001DTO
     * @return int
     */
	public int insertItgastchgExcel(IA603001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertItgastchgExcel -----");
		return session.insert("IA6030.insertItgastchgExcel", inParam);
	}

    /**
     * @brief 무형자산 변동내역 삭제
     * @details 무형자산 변동내역 삭제
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA603003IN
     * @return int
     */
	public int deleteItgastchg(IA603003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteItgastchg -----");
		return session.delete("IA6030.deleteItgastchg", inParam);
	}

    /**
     * @brief 무형자산 변동내역 기초삭제
     * @details 무형자산 변동내역 기초삭제
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA603004IN
     * @return int
     */
	public int deleteItgastchgBass(IA603004IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteItgastchgBass -----");
		return session.delete("IA6030.deleteItgastchgBass", inParam);
	}


    /**
     * @brief 무형자산 변동내역 기초 템플릿 다운
     * @details 무형자산 변동내역 기초 템플릿 다운
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param IA603001IN
     * @return List<IA603001DTO>
     */
    public List<IA603001DTO> selectItgastchgBass(IA603001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectItgastchgBass -----");
        return session.selectList("IA6030.selectItgastchgBass", inParam);
    }
}
