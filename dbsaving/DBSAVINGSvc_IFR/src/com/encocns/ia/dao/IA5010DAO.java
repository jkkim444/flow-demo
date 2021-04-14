/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5010DAO.java
 * @brief IFRS 계정코드 List DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
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
import com.encocns.ia.dto.IA501001DTO;
import com.encocns.ia.service.svo.IA501001IN;
import com.encocns.ia.service.svo.IA501002IN;
import com.encocns.ia.service.svo.IA501003IN;

/**
 * @brief IFRS 계정코드 DAO
 * @details IFRS 계정코드 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5010DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5010DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 조건에 해당하는 계정코드 내역 조회
     * @details 조건에 해당하는 계정코드 내역 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501001IN
     * @return List<IA501001DTO>
     */
    public List<IA501001DTO> selectListIfrsAccd(IA501001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsAccd -----");
        return session.selectList("IA5010.selectListIfrsAccd", inParam);
    }

    /**
     * @brief 계정코드  존재 여부  확인한다.
     * @details 계정코드  존재 여부  확인한다.
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501002IN
     * @return int
     */

    public int selectIfrsAccd(IA501002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectIfrsAccd -----");
        return session.selectOne("IA5010.selectIfrsAccd", inParam);
    }


    /**
     * @brief 계정과목코드 등록
     * @details 계정과목코드 등록
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501002IN
     * @return int
     */
	public int insertIfrsAccd(IA501002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsAccd -----");
		return session.insert("IA5010.insertIfrsAccd", inParam);
	}

    /**
     * @brief 계정과목코드 엑셀 업로드
     * @details 계정과목코드 엑셀 업로드
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501002IN
     * @return int
     */
	public int insertIfrsAccdExcl(IA501002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsAccdExcl -----");
		return session.insert("IA5010.insertIfrsAccdExcl", inParam);
	}

    /**
     * @brief  계정과목코드 변경 처리
     * @details 계정과목코드 변경 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501002IN
     * @return int
     */
	public int updateIfrsAccdEnd(IA501002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateIfrsAccdEnd -----");
		return session.update("IA5010.updateIfrsAccdEnd", inParam);
	}
    /**
     * @brief 기 등록된 계정과목코드 종료 처리
     * @details 기 등록된 계정과목코드 종료 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501002IN
     * @return int
     */
	public int updateIfrsAccd(IA501002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateIfrsAccd -----");
		return session.update("IA5010.updateIfrsAccd", inParam);
	}


    /**
     * @brief 삭제 처리 후 계정과목코드 변경 처리  처리
     * @details 삭제 처리 후 계정과목코드 변경 처리  처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501003IN
     * @return int
     */
	public int delUpdateIfrsAccd(IA501003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- delUpdateIfrsAccd -----");
		return session.delete("IA5010.delUpdateIfrsAccd", inParam);
	}


    /**
     * @brief 계정과목코드 삭제 처리
     * @details 계정과목코드 삭제 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA501003IN
     * @return int
     */
	public int deleteIfrsAccd(IA501003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIfrsAccd -----");
		return session.delete("IA5010.deleteIfrsAccd", inParam);
	}

    /**
     * @brief 화면표시순서 1씩 증가 업데이트
     * @details 화면표시순서 1씩 증가 업데이트
     * @author : 이동겸
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA501002IN
     * @return int
     */
	public int updateScrnIndcOrd(IA501002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateScrnIndcOrd -----");
		return session.update("IA5010.updateScrnIndcOrd", inParam);
	}

    /**
     * @brief 화면표시순서 1씩 감소 업데이트
     * @details 화면표시순서 1씩 감소 업데이트
     * @author : 이동겸
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA501003IN
     * @return int
     */
	public int deleteScrnIndcOrd(IA501003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteScrnIndcOrd -----");
		return session.update("IA5010.deleteScrnIndcOrd", inParam);
	}

    /**
     * @brief 적용종료일자 9999-12-31 여부 확인
     * @details 적용종료일자 9999-12-31 여부 확인
     * @author : 이동겸
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA501003IN
     * @return int
     */
	public int selectAplcEndDt(IA501003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectAplcEndDt -----");
		return session.selectOne("IA5010.selectAplcEndDt", inParam);
	}



}
