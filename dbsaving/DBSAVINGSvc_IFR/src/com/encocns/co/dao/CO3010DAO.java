/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO3010DAO.java
 * @brief 공통 코드 관리 DAO
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

import com.encocns.co.dto.CO301001DTO;
import com.encocns.co.dto.CO301002DTO;
import com.encocns.co.service.svo.CO301001IN;
import com.encocns.co.service.svo.CO301002IN;
import com.encocns.co.service.svo.CO301003IN;
import com.encocns.co.service.svo.CO301005IN;
import com.encocns.co.service.svo.CO301006IN;
import com.encocns.fw.config.db.SqlMapClient;

/**
 * @brief 공통 코드 관리 DAO
 * @details 공통 코드 관리 DAO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Repository
public class CO3010DAO {

    @Autowired
    private SqlMapClient session;

    /**
     * @brief 공통 코드 도메인 조회
     * @details 공통 코드 도메인 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO301001IN
     * @return List<CO301001DTO>
     */
    public List<CO301001DTO> selectCodeDomainList( CO301001IN inParam ){
        return session.selectList( "CO3010.selectCodeDomainList", inParam );
    }

    /**
     * @brief 공통 코드 조회
     * @details 공통 코드 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO301002IN
     * @return List<CO301002DTO>
     */
    public List<CO301002DTO> selectCodeDtlList( CO301002IN inParam ){
        return session.selectList( "CO3010.selectCodeDtlList", inParam );
    }

    /**
     * @brief 공통 코드 도메인 갯수 조회
     * @details  공통 코드 도메인 갯수 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param CO301003IN
     * @return int
     */
    public int selectDomainCnt( CO301003IN inParam ){
        return session.selectOne( "CO3010.selectDomainCnt", inParam );
    }

    /**
     * @brief 도메인 등록 및 수정
     * @details 도메인 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param CO301003IN
     * @return int
     */
    public int mergeCodeDomain( CO301003IN inParam ){
        return session.update( "CO3010.mergeCodeDomain", inParam );
    }

    /**
     * @brief 공통코드 도메인 삭제여부 업데이트
     * @details 공통코드 도메인 삭제여부 업데이트
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param CO301005IN
     * @return int
     */
    public int updateCodeDomainDelYn( CO301005IN inParam ){
        return session.update( "CO3010.updateCodeDomainDelYn", inParam );
    }

    /**
     * @brief 공통코드 삭제여부 업데이트
     * @details 공통코드 삭제여부 업데이트
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param CO301005IN
     * @return int
     */
    public int updateCodeDomainDtlDelYn( CO301005IN inParam ){
        return session.update( "CO3010.updateCodeDomainDtlDelYn", inParam );
    }

    /**
     * @brief 공통코드 등록 및 수정
     * @details 공통코드 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param CO301002DTO
     * @return int
     */
    public int mergeCd( CO301002DTO inParam ){
        return session.update( "CO3010.mergeCd", inParam );
    }

    /**
     * @brief 공통코드 삭제 여부 업데이트
     * @details 공통코드 삭제 여부 업데이트
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @param CO301006IN
     * @return int
     */
    public int updateCdYn( CO301006IN inParam ){
        return session.update( "CO3010.updateCdYn", inParam );
    }

    /**
     * @brief 코드 정렬순서 재정렬
     * @details 코드 정렬순서 재정렬
     * @author : 이동겸
     * @date : 2020 11. 18.
     * @param CO301002DTO
     * @return CO301002DTO
     */
    public CO301002DTO selectReSortSeq(CO301002DTO inParam ){
    	return session.selectOne("CO3010.selectReSortSeq", inParam );
    }
}
