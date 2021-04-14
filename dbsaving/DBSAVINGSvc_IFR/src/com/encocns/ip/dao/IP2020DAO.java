/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2020DAO.java
 * @brief LGD 관리 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 01. | First Created
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

import com.encocns.ip.dto.IP202001DTO;
import com.encocns.ip.dto.IP202002DTO;
import com.encocns.ip.service.svo.IP202001IN;
import com.encocns.ip.service.svo.IP202002IN;
import com.encocns.ip.service.svo.IP202003IN;
import com.encocns.fw.config.db.SqlMapClient;


/**
 * @brief LGD 관리 DAO
 * @details LGD 관리 DAO
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Repository
public class IP2020DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2020DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
	 * @brief LGD 목록 조회(페이징 없이)
	 * @details LGD 목록 조회(페이징 없이)
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
     * @param IP202001IN
     * @return List<IP202001DTO>
	 */
    public List<IP202001DTO> selectListRcLgdRflc(IP202001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRcLgdRflc -----");
        return session.selectList("IP2020.selectListRcLgdRflc", inParam);
    }

	/**
	 * @brief LGD 목록 페이징 건수 조회
	 * @details LGD 목록 페이징 건수 조회
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
     * @param IP202001IN
     * @return int
	 */
    public int selectTotalCount (IP202001IN inParam ) {
        return session.selectOne("IP2020.selectTotalCount", inParam);
    }

	/**
	 * @brief LGD 목록 조회(페이징)
	 * @details LGD 목록 조회(페이징)
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
     * @param IP202001IN
     * @return List<IP202001DTO>
	 */
    public List<IP202001DTO> selectPaging( IP202001IN inParam ) {
        return session.selectList("IP2020.selectPaging", inParam);
    }

	/**
	 * @brief LGD 등록 처리
	 * @details LGD 등록 처리
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
     * @param IP202002IN
     * @return int
	 */
	public int insertRcLgdRflc(IP202002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcLgdRflc -----");
		return session.insert("IP2020.insertRcLgdRflc", inParam);
	}

	/**
	 * @brief LGD 정보 등록
	 * @details LGD 정보 등록
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
     * @param IP202002IN
     * @return int
	 */
	public int updateRcLgdRflc(IP202002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateRcLgdRflc -----");
		return session.update("IP2020.updateRcLgdRflc", inParam);
	}

	/**
	 * @brief LGD 정보 삭제
	 * @details LGD 정보 삭제
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
     * @param IP202003IN
     * @return int
	 */
	public int deleteRcLgdRflc(IP202003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcLgdRflc -----");
		return session.delete("IP2020.deleteRcLgdRflc", inParam);
	}


	/**
	 * @brief LGD 정보 엑셀업로드 전 삭제
	 * @details LGD 정보 엑셀업로드 전 삭제
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
     * @param IP202001DTO
     * @return int
	 */
	public int deleteRcLgdRflcExcl(IP202001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRcLgdRflc -----");
		return session.delete("IP2020.deleteRcLgdRflcExcl", inParam);
	}

	/**
	 * @brief LGD 정보 엑셀업로드
	 * @details LGD 정보 엑셀업로드
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
     * @param IP202002IN
     * @return int
	 */
	public int insertRcLgdRflcExcl(IP202002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcLgdRflc -----");
		return session.insert("IP2020.insertRcLgdRflcExcl", inParam);
	}

	/**
	 * @brief LGD 코드 존재 여부 조회
	 * @details LGD 코드 존재 여부 조회
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
	 * @version : 1.0.0
     * @param IP202002DTO
     * @return IP202002DTO
	 */
    public IP202002DTO selectListRcLgdRflcErr ( IP202002DTO inParam ) {
        return session.selectOne("IP2020.selectListRcLgdRflcErr", inParam);
    }

}
