/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2010DAO.java
 * @brief F/L 반영 PD관리 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 08. 10. | First Created
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
import com.encocns.ip.dto.IP201001DTO;
import com.encocns.ip.dto.IP201002DTO;
import com.encocns.ip.service.svo.IP201001IN;
import com.encocns.ip.service.svo.IP201002IN;
import com.encocns.ip.service.svo.IP201003IN;


/**
 * @brief F/L반영 PD관리 management List DAO
 * @details F/L반영 PD관리 DAO입니다.
 * @author : 이동겸
 * @date : 2020. 08. 10.
 * @version : 1.0.0
 */
@Repository
public class IP2010DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2010DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief F/L반영 PD 목록 조회
     * @details F/L반영 PD 목록 조회
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201001IN
     * @return List<IP201001DTO>
     */
    public List<IP201001DTO> selectListRcPdRflc(IP201001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListEarnRlesHold -----");
        return session.selectList("IP2010.selectListRcPdRflc", inParam);
    }

    /**
     * @brief F/L반영 PD 목록 페이징 조회
     * @details F/L반영 PD 목록 페이징 조회
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201001IN
     * @return int
     */
    public int selectTotalCount ( IP201001IN inParam ) {
        return session.selectOne("IP2010.selectTotalCount", inParam);
    }

    /**
     * @brief F/L반영 PD 목록 페이징 조회
     * @details F/L반영 PD 목록 페이징 조회
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201001IN
     * @return List<IP201001DTO>
     */
    public List<IP201001DTO> selectPaging( IP201001IN inParam ) {
        return session.selectList("IP2010.selectPaging", inParam);
    }

    /**
     * @brief F/L반영 PD 등록
     * @details F/L반영 PD 등록
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201002IN
     * @return int
     */
	public int insertRcPdRflc(IP201002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeEarnRlesHold -----");
		return session.insert("IP2010.insertRcPdRflc", inParam);
	}

    /**
     * @brief F/L반영 PD 업데이트
     * @details F/L반영 PD 업데이트
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201002IN
     * @return int
     */
	public int updateRcPdRflc(IP201002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeEarnRlesHold -----");
		return session.update("IP2010.updateRcPdRflc", inParam);
	}

    /**
     * @brief F/L반영 PD 삭제
     * @details F/L반영 PD 삭제
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201003IN
     * @return int
     */
	public int deleteRcPdRflc(IP201003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEarnRlesHold -----");
		return session.delete("IP2010.deleteRcPdRflc", inParam);
	}

    /**
     * @brief F/L반영 PD 엑셀 업로드
     * @details F/L반영 PD 엑셀 업로드
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201002IN
     * @return int
     */
	public int insertRcPdRflcExcl(IP201002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcPdRflcExcl -----");
		return session.insert("IP2010.insertRcPdRflcExcl", inParam);
	}

    /**
     * @brief F/L반영 PD 년월 단위 삭제
     * @details F/L반영 PD 년월 단위 삭제
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201001DTO
     * @return int
     */
	public int deleteRcPdRflcStdrYm(IP201001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcPdRflcStdrYm -----");
		return session.delete("IP2010.deleteRcPdRflcStdrYm", inParam);
	}


    /**
     * @brief 코드 존재 여부 조회
     * @details 코드 존재 여부 조회
     * @author : 이동겸
     * @date : 2020. 08. 10.
     * @version : 1.0.0
     * @param IP201002DTO
     * @return IP201002DTO
     */
    public IP201002DTO selectListRcPdRflcErr ( IP201002DTO inParam ) {
        return session.selectOne("IP2010.selectListRcPdRflcErr", inParam);
    }

}
