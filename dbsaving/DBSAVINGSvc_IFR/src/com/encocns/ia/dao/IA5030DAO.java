/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5030DAO.java
 * @brief 정산표 산출 DAO
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 24. | First Created
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
import com.encocns.ia.dto.IA503001DTO;
import com.encocns.ia.dto.IA503002DTO;
import com.encocns.ia.service.svo.IA503001IN;
import com.encocns.ia.service.svo.IA503002IN;

/**
 * @brief IFRS 정산표 산출 내역 DAO
 * @details IFRS 정산표 산출 내역 DAO
 * @author : 이동겸
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
@Repository
public class IA5030DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5030DAO.class);

	@Autowired
    private SqlMapClient session;

    /**
     * @brief IFRS 정산표 산출 내역
     * @details IFRS 정산표 산출 내역
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return List<IA503001DTO>
     */
    public List<IA503001DTO> selectListAdjsHistIqry(IA503001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListAdjsHistIqry -----");
        return session.selectList("IA5030.selectListAdjsHistIqry", inParam);
    }

    /**
     * @brief IFRS 정산표 생성
     * @details IFRS 정산표 생성
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return int
     */
	public int insertIfrstotacc(IA503002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertRcLgdRflc -----");
		return session.insert("IA5030.insertIfrstotacc", inParam);
	}
	/**
     * @brief IFRS 정산표 삭제
     * @details IFRS 정산표 삭제
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return int
     */
	public int deleteIfrstotacc(IA503002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIfrstotacc -----");
		return session.delete("IA5030.deleteIfrstotacc", inParam);
	}

	/**
     * @brief IFRS정산산출내역 등록
     * @details IFRS정산산출내역 등록
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return int
     */
	public int insertIfrsAdjsClclHist(IA503002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsAdjsClclHist -----");
		return session.insert("IA5030.insertIfrsAdjsClclHist", inParam);
	}
	/**
     * @brief IFRS정산산출TEMP 등록
     * @details IFRS정산산출TEMP 등록
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int insertIfrsAdjsClclHistTemp(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsAdjsClclHistTemp -----");
		return session.insert("IA5030.insertIfrsAdjsClclHistTemp", inParam);
	}
	/**
     * @brief K-GAAP금액계정 테이블 등록
     * @details K-GAAP금액계정 테이블 등록
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return int
     */
	public int insertKgaapacntAmt(IA503002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertKgaapacntAmt -----");
		return session.insert("IA5030.insertKgaapacntAmt", inParam);
	}
	/**
     * @brief 정산표에 K-GAAP금액계정 등록
     * @details 정산표에 K-GAAP금액계정 등록
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return int
     */
	public int insertIfrsTotaccKgaapAmt(IA503002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrsTotaccKgaapAmt -----");
		return session.insert("IA5030.insertIfrsTotaccKgaapAmt", inParam);
	}

	/**
     * @brief IFRS정산산출내역 삭제
     * @details IFRS정산산출내역 삭제
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return int
     */
	public int deleteIfrsAdjsClclHist(IA503002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIfrsAdjsClclHist -----");
		return session.delete("IA5030.deleteIfrsAdjsClclHist", inParam);
	}

	/**
     * @brief IFRS기초 삭제
     * @details IFRS기초 삭제
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return int
     */
	public int deleteIfrstotaccBass(IA503002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIfrstotaccBass -----");
		return session.delete("IA5030.deleteIfrstotaccBass", inParam);
	}

	/**
     * @brief IFRS기초 생성
     * @details IFRS기초 생성
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return int
     */
	public int insertIfrstotaccBass(IA503002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrstotaccBass -----");
		return session.delete("IA5030.insertIfrstotaccBass", inParam);
	}

	/**
     * @brief K-GAAP 계정코드 금액계정 테이블 삭제
     * @details K-GAAP 계정코드 금액계정 테이블 삭제
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return int
     */
	public int deleteKgaapacntAmt(IA503002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteKgaapacntAmt -----");
		return session.delete("IA5030.deleteKgaapacntAmt", inParam);
	}

	/**
     * @brief 정산표 산출TEMP 테이블 삭제
     * @details 정산표 산출TEMP 테이블 삭제
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int deleteIfrsAdjsClclHistTemp(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteIfrsAdjsClclHistTemp -----");
		return session.delete("IA5030.deleteIfrsAdjsClclHistTemp", inParam);
	}

	/**
     * @brief 영업이익(손실)9030000000 //01
     * @details 영업이익(손실)9030000000 //01
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int insertHistTemp01(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHistTemp01 -----");
		return session.insert("IA5030.insertHistTemp01", inParam);
	}
	/**
     * @brief 법인세차감전순이익(순손실)9060000000 //02
     * @details 법인세차감전순이익(순손실)9060000000 //02
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int insertHistTemp02(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHistTemp02 -----");
		return session.insert("IA5030.insertHistTemp02", inParam);
	}
	/**
     * @brief 계속사업이익(손실)9080000000 //03
     * @details 계속사업이익(손실)9080000000 //03
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int insertHistTemp03(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHistTemp03 -----");
		return session.insert("IA5030.insertHistTemp03", inParam);
	}
	/**
     * @brief 당기순이익9100000000 //04
     * @details 당기순이익9100000000 //04
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int insertHistTemp04(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHistTemp04 -----");
		return session.insert("IA5030.insertHistTemp04", inParam);
	}
	/**
     * @brief 부채와자본총계8999999999 //05
     * @details 부채와자본총계8999999999 //05
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int insertHistTemp05(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHistTemp05 -----");
		return session.insert("IA5030.insertHistTemp05", inParam);
	}
	/**
     * @brief 당기순이익 구하기 전 더해진 K-GAAP,연결,별도 차감
     * @details 당기순이익 구하기 전 더해진 K-GAAP,연결,별도 차감
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int insertHistTempAmtIfrsSub(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHistTempAmtIfrsSub -----");
		return session.insert("IA5030.insertHistTempAmtIfrsSub", inParam);
	}
	/**
     * @brief 당기순이익 구한 후 K-GAAP,연결,별도 계산
     * @details 당기순이익 구한 후 K-GAAP,연결,별도 계산
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int insertHistTempAmtIfrsAdd(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHistTempAmtIfrsAdd -----");
		return session.insert("IA5030.insertHistTempAmtIfrsAdd", inParam);
	}

	/**
     * @brief 자본당기순이익 //06
     * @details 자본당기순이익 //06
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return int
     */
	public int insertHistTemp06(IA503001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHistTemp06 -----");
		return session.insert("IA5030.insertHistTemp06", inParam);
	}

	/**
     * @brief IFRS 정산표 검증 자산총계 01
     * @details IFRS 정산표 검증 자산총계 01
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return IA503002DTO
     */
    public IA503002DTO selectChkIfrs01(IA503001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectChkIfrs01 -----");
        return session.selectOne("IA5030.selectChkIfrs01", inParam);
    }

    /**
     * @brief IFRS 정산표 검증 당기순이익 02
     * @details IFRS 정산표 검증 당기순이익 02
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param inParam
     * @return IA503002DTO
     */
    public IA503002DTO selectChkIfrs02(IA503001IN inParam) {
    	if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectChkIfrs02 -----");
    	return session.selectOne("IA5030.selectChkIfrs02", inParam);
    }

}
