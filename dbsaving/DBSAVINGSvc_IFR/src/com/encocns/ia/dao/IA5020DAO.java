/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5020DAO.java
 * @brief 재무제표양식 DAO
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
import com.encocns.ia.dto.IA502001DTO;
import com.encocns.ia.service.svo.IA502001IN;
import com.encocns.ia.service.svo.IA502002IN;
import com.encocns.ia.service.svo.IA502003IN;

/**
 * @brief 제무제표 양식 DAO
 * @details 제무제표 양식 DAO
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Repository
public class IA5020DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5020DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief 조건에 해당하는 내역 조회
     * @details 조건에 해당하는 내역 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA502001IN
     * @return List<IA502001DTO>
     */
    public List<IA502001DTO> selectListFnstFxfr(IA502001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListFnstFxfr -----");
        return session.selectList("IA5020.selectListFnstFxfr", inParam);
    }

    /**
     * @brief 제무제표 양식 등록
     * @details 제무제표 양식 등록
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA502002IN
     * @return int
     */
	public int insertFnstFxfr(IA502002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertFnstFxfr -----");
		return session.insert("IA5020.insertFnstFxfr", inParam);
	}

    /**
     * @brief 제무제표 양식 변경
     * @details 제무제표 양식 변경
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA502002IN
     * @return int
     */
	public int updateFnstFxfr(IA502002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateFnstFxfr -----");
		return session.update("IA5020.updateFnstFxfr", inParam);
	}

    /**
     * @brief 제무제표 양식 종결처리 변경
     * @details제무제표 양식 종결처리 변경
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA502002IN
     * @return int
     */
	public int updateFnstFxfrEnd(IA502002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateFnstFxfrEnd -----");
		return session.update("IA5020.updateFnstFxfrEnd", inParam);
	}

    /**
     * @brief 제무제표 양식 종결건 현재일자로 변경 처리
     * @details 제무제표 양식 종결건 현재일자로 변경 처리
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA502003IN
     * @return int
     */
	public int updateFnstFxfrDel(IA502003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateFnstFxfrDel -----");
		return session.update("IA5020.updateFnstFxfrDel", inParam);
	}
    /**
     * @brief 제무제표 양식 삭제
     * @details 제무제표 양식 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA502003IN
     * @return int
     */
	public int deleteFnstFxfr(IA502003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteFnstFxfr -----");
		return session.delete("IA5020.deleteFnstFxfr", inParam);
	}

    /**
     * @brief 화면표시순서 1씩 증가 업데이트
     * @details 화면표시순서 1씩 증가 업데이트
     * @author : 이동겸
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA502002IN
     * @return int
     */
	public int updateScrnIndcOrd(IA502002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateScrnIndcOrd -----");
		return session.update("IA5020.updateScrnIndcOrd", inParam);
	}

    /**
     * @brief 화면표시순서 1씩 감소 업데이트
     * @details 화면표시순서 1씩 감소 업데이트
     * @author : 이동겸
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA502003IN
     * @return int
     */
	public int deleteScrnIndcOrd(IA502003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteScrnIndcOrd -----");
		return session.update("IA5020.deleteScrnIndcOrd", inParam);
	}

    /**
     * @brief 적용종료일자 9999-12-31 여부 확인
     * @details 적용종료일자 9999-12-31 여부 확인
     * @author : 이동겸
     * @date : 2020. 10. 28.
     * @version : 1.0.0
     * @param IA502003IN
     * @return int
     */
	public int selectAplcEndDt(IA502003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectAplcEndDt -----");
		return session.selectOne("IA5020.selectAplcEndDt", inParam);
	}


}
