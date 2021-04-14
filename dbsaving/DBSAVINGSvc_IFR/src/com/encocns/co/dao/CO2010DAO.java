/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2010DAO.java
 * @brief 메뉴 관리 DAO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dao
 * @brief Common DAO Package
 */
package com.encocns.co.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.co.dto.CO201001DTO;
import com.encocns.co.dto.CO201002DTO;
import com.encocns.co.dto.CO201003DTO;
import com.encocns.co.dto.CO201004DTO;
import com.encocns.co.service.svo.CO201001IN;
import com.encocns.co.service.svo.CO201002IN;
import com.encocns.co.service.svo.CO201003IN;
import com.encocns.co.service.svo.CO201004IN;
import com.encocns.enfra.core.session.SessionVO;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 메뉴 관리 DAO
 * @details 메뉴 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO2010DAO {

    @Autowired
    private SqlMapClient session;

    /**
     * @brief 상위 메뉴 조회
     * @details 상위 메뉴 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return List<CO201002DTO>
     */
    public List<CO201002DTO> selectTopMenuList(CO201001IN inParam) {
        return session.selectList("CO2010.selectTopMenuList", inParam);
    }

    /**
     * @brief 메뉴 목록 조회
     * @details 메뉴 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201004IN
     * @return List<CO201003DTO>
     */
    public List<CO201003DTO> selectMenuList(CO201004IN inParam) {
        return session.selectList("CO2010.selectMenuList", inParam);
    }

    /**
     * @brief 메뉴정보 조회
     * @details 메뉴정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param sessionVo
     * @return List<CO201004DTO>
     */
    public List<CO201004DTO> selectMenuInfo(SessionVO sessionVo) {
        return session.selectList("CO2010.selectMenuInfo", sessionVo);
    }

    /**
     * @brief 메뉴 갯수 조회
     * @details 메뉴 갯수 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001DTO
     * @return int
     */
    public int selectMenuCnt(CO201001DTO dvoSel) {
        int iResult = session.selectOne("CO2010.selectMenuCnt", dvoSel);
        return iResult;
    }

    /**
     * @brief 메뉴 조회
     * @details 메뉴 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return List<CO201001DTO>
     */
    public List<CO201001DTO> selectMenu(CO201001IN inParam) {
        return session.selectList("CO2010.selectMenu", inParam);
    }

    /**
     * @brief 메뉴 레벨 조회
     * @details 메뉴 레벨 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201002IN
     * @return CO201001DTO
     */
    public CO201001DTO selectMenuLevel(CO201002IN inParam) {
        CO201001DTO arrList = session.selectOne("CO2010.selectMenuLevel", inParam);
        return arrList;
    }

    /**
     * @brief 메뉴 등록
     * @details 메뉴 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201002IN
     * @return int
     */
    public int insertMenu(CO201002IN inParam) {
        int iResult = session.insert("CO2010.insertMenu", inParam);
        return iResult;
    }


    /**
     * @brief 메뉴 수정
     * @details 메뉴 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201002IN
     * @return int
     */
    public int updateMenu(CO201002IN inParam) {
        int iResult = session.update("CO2010.updateMenu", inParam);
        return iResult;
    }


    /**
     * @brief 메뉴 삭제
     * @details 메뉴 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201003IN
     * @return 메뉴 삭제
     */
    public int deleteMenu(CO201003IN inParam) {
        return session.delete("CO2010.deleteMenu", inParam);
    }

    /**
     * @brief 그룹 메뉴 삭제
     * @details 그룹 메뉴 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201003IN
     * @return int
     */
    public int deleteMpgMenu(CO201003IN inParam) {
        return session.delete("CO2010.deleteMpgMenu", inParam);
    }

    /**
     * @brief 메뉴 정보 조회
     * @details 메뉴 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return List<CO201001DTO>
     */
    public List<CO201001DTO> selectMenuScrList(CO201001IN inParam) {
        return session.selectList("CO2010.selectMenuScrList", inParam);
    }

    /**
     * @brief 메뉴 정보 조회
     * @details 메뉴 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return List<CO201001DTO>
     */
    public List<CO201001DTO> selectMenuScrListEAM(CO201001IN inParam) {
        return session.selectList("CO2010.selectMenuScrListEAM", inParam);
    }

    /**
     * @brief 메뉴 정보 조회
     * @details 메뉴 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return CO201001DTO
     */
    public CO201001DTO selectMenuScrInfo(CO201001IN inParam) {
        return session.selectOne("CO2010.selectMenuScrInfo", inParam);
    }

    /**
     * @brief 메뉴 정보 조회
     * @details 메뉴 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return CO201001DTO
     */
    public CO201001DTO selectScreenInfo(CO201001IN inParam) {
        return session.selectOne("CO2010.selectScreenInfo", inParam);
    }

}
