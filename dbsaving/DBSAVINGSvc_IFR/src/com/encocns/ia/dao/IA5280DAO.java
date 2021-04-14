/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5280DAO.java
 * @brief 유가증권기초내역 DAO
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 14.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.dao
 * @brief Common DAO Package
 */
package com.encocns.ia.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encocns.fw.config.db.SqlMapClient;
import com.encocns.ia.dto.IA528001DTO;
import com.encocns.ia.service.svo.IA528001IN;

/**
 * @brief 유가증권기초내역 DAO
 * @details 유가증권기초내역 DAO
 * @author : 이미래
 * @date : 2020. 10. 14.
 * @version : 1.0.0
 */
@Repository
public class IA5280DAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5280DAO.class);

	@Autowired
    private SqlMapClient session;

	/**
     * @brief 유가증권기초내역  요약 내역 조회
     * @details 유가증권기초내역  요약 내역 조회 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return ArrayList<IA528001DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<IA528001DTO> selecListtMkstBrfHist(IA528001IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selecListtMkstBrfHist -----");
        return (ArrayList)session.selectList("IA5280.selecListtMkstBrfHist", inParam);
    }
    
    /**
     * @brief 유가증권기초내역 등록 처리(kgaap 내역 생성)
     * @details 유가증권기초내역 등록 처리(kgaap 내역 생성) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001DTO
     * @return int
     */
	public int insertMkstBassHistKgaap(IA528001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstBassHistKgaap -----");
		return session.insert("IA5280.insertMkstBassHistKgaap", inParam);
	}

	/**
     * @brief 유가증권기초내역 삭제 처리
     * @details 유가증권기초내역 삭제 처리 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001DTO
     * @return int
     */
	public int deleteMkstBassHist(IA528001DTO inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteMkstBassHist -----");
		return session.delete("IA5280.deleteMkstBassHist", inParam);
	}

	/**
     * @brief 유가증권기초내역 등록 처리(ifrs 내역 생성 case1)
     * @details 유가증권기초내역 등록 처리(ifrs 내역 생성 case1) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertMkstBassHistIfrs_1(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstBassHistIfrs_1 -----");
		return session.insert("IA5280.insertMkstBassHistIfrs_1", inParam);
	}
	
	/**
     * @brief 유가증권기초내역 등록 처리(ifrs 내역 생성 case2)
     * @details 유가증권기초내역 등록 처리(ifrs 내역 생성 case2) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertMkstBassHistIfrs_2(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstBassHistIfrs_2 -----");
		return session.insert("IA5280.insertMkstBassHistIfrs_2", inParam);
	}
	
	/**
     * @brief 유가증권기초내역 등록 처리(ifrs 내역 생성 case3)
     * @details 유가증권기초내역 등록 처리(ifrs 내역 생성 case3) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertMkstBassHistIfrs_3(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstBassHistIfrs_3 -----");
		return session.insert("IA5280.insertMkstBassHistIfrs_3", inParam);
	}
	
	/**
     * @brief 유가증권기초내역 등록 처리(ifrs 내역 생성 case4)
     * @details 유가증권기초내역 등록 처리(ifrs 내역 생성 case4) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertMkstBassHistIfrs_4(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstBassHistIfrs_4 -----");
		return session.insert("IA5280.insertMkstBassHistIfrs_4", inParam);
	}
	
	/**
     * @brief 유가증권기초내역 등록 처리(ifrs 내역 생성 case5)
     * @details 유가증권기초내역 등록 처리(ifrs 내역 생성 case5) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertMkstBassHistIfrs_5(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstBassHistIfrs_5 -----");
		return session.insert("IA5280.insertMkstBassHistIfrs_5", inParam);
	}
	
	/**
     * @brief 유가증권기초내역 등록 처리(ifrs 내역 생성 case6)
     * @details 유가증권기초내역 등록 처리(ifrs 내역 생성 case6) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertMkstBassHistIfrs_6(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstBassHistIfrs_6 -----");
		return session.insert("IA5280.insertMkstBassHistIfrs_6", inParam);
	}
	
	/**
     * @brief 유가증권기초내역 등록 처리(ifrs 내역 생성 case7)
     * @details 유가증권기초내역 등록 처리(ifrs 내역 생성 case7) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertMkstBassHistIfrs_7(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstBassHistIfrs_7 -----");
		return session.insert("IA5280.insertMkstBassHistIfrs_7", inParam);
	}
	
	/**
     * @brief 유가증권처분내역 등록 처리(ifrs등가처분차수,수량,장부가액,OCI금액 내역 생성)
     * @details 유가증권처분내역 등록 처리(ifrs등가처분차수,수량,장부가액,OCI금액 내역 생성) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
     public int insertMkstDspslHistIfrs(IA528001IN inParam) {
     	 if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstDspslHistIfrs -----");
     	 return session.insert("IA5280.insertMkstDspslHistIfrs", inParam);
    }

    /**
     * @brief 유가증권처분내역 등록 처리(ifrs 등가처분이익금액, 등가처분손실금액 내역 생성)
     * @details 유가증권처분내역 등록 처리(ifrs 등가처분이익금액, 등가처분손실금액 내역 생성) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
     public int updateMkstDspslHistIfrs_1(IA528001IN inParam) {
     	 if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateMkstDspslHistIfrs_1 -----");
     	 return session.update("IA5280.updateMkstDspslHistIfrs_1", inParam);
    }
     
    /**
     * @brief 유가증권처분내역 등록 처리(ifrs 등가처분이익금액, 등가처분손실금액 내역 생성)
     * @details 유가증권처분내역 등록 처리(ifrs 등가처분이익금액, 등가처분손실금액 내역 생성) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
      public int updateMkstDspslHistIfrs_2(IA528001IN inParam) {
      	 if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateMkstDspslHistIfrs_2 -----");
      	 return session.update("IA5280.updateMkstDspslHistIfrs_2", inParam);
     }

     /**
      * @brief 유가증권 일람표 KIFRS 등록 처리(kifrs 기말PL,OCI 손익,손실 내역 반영)
      * @details 유가증권 일람표 KIFRS 등록 처리(kifrs 기말PL,OCI 손익,손실 내역 반영) 
      * @author : 이미래
      * @date : 2020. 10. 14.
      * @version : 1.0.0
      * @param IA528001IN
      * @return int
      */
     public int insertMkstEdtmlHistIfrs(IA528001IN inParam) {
     	 if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstEdtmlHistIfrs -----");
     	 return session.insert("IA5280.insertMkstEdtmlHistIfrs", inParam);
    }
     
     /**
      * @brief 유가증권 일람표 KIFRS 등록 처리(kifrs 기말장부가액 반영)
      * @details 유가증권 일람표 KIFRS 등록 처리(kifrs 기말장부가액 반영) 
      * @author : 이미래
      * @date : 2020. 12. 10.
      * @version : 1.0.0
      * @param IA528001IN
      * @return int
      */
     public int mergeMkstEdtmAcbkAmtIfrs(IA528001IN inParam) {
     	 if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeMkstEdtmAcbkAmtIfrs -----");
     	 return session.insert("IA5280.mergeMkstEdtmAcbkAmtIfrs", inParam);
    }

     /**
      * @brief KGAPP / KIFRS 유가증권일괄내역 요약 등록 처리
      * @details KGAPP / KIFRS 유가증권일괄내역 요약 등록 처리 
      * @author : 이미래
      * @date : 2020. 10. 14.
      * @version : 1.0.0
      * @param IA528001IN
      * @return int
      */     
	public int insertMkstBrfHist(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertMkstBrfHist -----");
		return session.insert("IA5280.insertMkstBrfHist", inParam);
	}
	
	/**
     * @brief 유가증권기초 당기처분내역 등록 처리(KGAAP 당기처분내역 )
     * @details 유가증권기초 당기처분내역 등록 처리(KGAAP 당기처분내역 ) 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int updateCaclMkstBassHist(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateCaclMkstBassHist -----");
		return session.update("IA5280.updateCaclMkstBassHist", inParam);
	}

	/**
     * @brief 분개데이터대상내역  삭제 처리
     * @details 분개데이터대상내역  삭제 처리 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int deleteCalcJrlzTrgtAmt(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCalcJrlzTrgtAmt -----");
		return session.delete("IA5281.deleteCalcJrlzTrgtAmt", inParam);
	}

	/**
     * @brief 분개데이터대상내역  등록 처리
     * @details 분개데이터대상내역  등록 처리 CASE 2 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmtC2(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmtC2 -----");
		return session.insert("IA5281.insertCalcJrlzTrgtAmtC2", inParam);
	}
	
	/**
     * @brief 분개데이터대상내역  등록 처리
     * @details 분개데이터대상내역  등록 처리 CASE 3 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmtC3(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmtC3 -----");
		return session.insert("IA5282.insertCalcJrlzTrgtAmtC3", inParam);
	}
	
	/**
     * @brief 분개데이터대상내역  등록 처리
     * @details 분개데이터대상내역  등록 처리 CASE 4 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmtC4(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmtC4 -----");
		return session.insert("IA5283.insertCalcJrlzTrgtAmtC4", inParam);
	}
	
	/**
     * @brief 분개데이터대상내역  등록 처리
     * @details 분개데이터대상내역  등록 처리 CASE 5-1 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmtC5_1(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmtC5_1 -----");
		return session.insert("IA5284.insertCalcJrlzTrgtAmtC5_1", inParam);
	}
	
	/**
     * @brief 분개데이터대상내역  등록 처리
     * @details 분개데이터대상내역  등록 처리 CASE 5-2 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertCalcJrlzTrgtAmtC5_2(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCalcJrlzTrgtAmtC5_2 -----");
		return session.insert("IA5285.insertCalcJrlzTrgtAmtC5_2", inParam);
	}
	
	/**
     * @brief 분개상세처리  삭제 처리
     * @details 분개상세처리  삭제 처리 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int deletejrlzDtlProcs(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deletejrlzDtlProcs -----");
		return session.delete("IA5281.deletejrlzDtlProcs", inParam);
	}

	/**
     * @brief 분개상세처리  등록 처리
     * @details 분개상세처리  등록 처리 CASE2 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertjrlzDtlProcsC2(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcsC2 -----");
		return session.insert("IA5281.insertjrlzDtlProcsC2", inParam);
	}
	
	
	/**
     * @brief 분개상세처리  등록 처리
     * @details 분개상세처리  등록 처리 CASE 3 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertjrlzDtlProcsC3(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcsC3 -----");
		return session.insert("IA5282.insertjrlzDtlProcsC3", inParam);
	}
	
	/**
     * @brief 분개상세처리  등록 처리
     * @details 분개상세처리  등록 처리 CASE 4 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertjrlzDtlProcsC4(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcsC4 -----");
		return session.insert("IA5283.insertjrlzDtlProcsC4", inParam);
	}
	
	/**
     * @brief 분개상세처리  등록 처리
     * @details 분개상세처리  등록 처리 CASE 5-1 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertjrlzDtlProcsC5_1(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcsC5_1 -----");
		return session.insert("IA5284.insertjrlzDtlProcsC5_1", inParam);
	}
	
	/**
     * @brief 분개상세처리  등록 처리
     * @details 분개상세처리  등록 처리 CASE 5-2 
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return int
     */
	public int insertjrlzDtlProcsC5_2(IA528001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertjrlzDtlProcsC5_2 -----");
		return session.insert("IA5285.insertjrlzDtlProcsC5_2", inParam);
	}
}
