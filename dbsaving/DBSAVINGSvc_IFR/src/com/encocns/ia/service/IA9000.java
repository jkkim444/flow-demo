/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA9000.java
 * @brief 재무회계 공통 모듈 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 10. 05.
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service
 * @brief Common Service Package
 */
package com.encocns.ia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.dao.IA9000DAO;
import com.encocns.ia.dto.IA900001DTO;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 재무회계 공통 모듈 Service
 * @details 재무회계 공통 모듈 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 10. 05.
 * @version : 1.0.0
 */
@Service
public class IA9000 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA9000.class);

    @Autowired
	private IA9000DAO daoIA9000;
    /**
     * @brief 정산 공시 마감 내용  조회 
     * @details 정산 공시 마감 내용  조회 
     * @author : 이동겸
     * @date : 2020. 10. 07.
     * @version : 1.0.0
     * @param IA900002IN
     * @return IA900002OUT
     */
	public IA900002OUT selectClsnCtntInq(IA900002IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClsnYnIqry -----");


		IA900002OUT outParam = daoIA9000.selectClsnCtntInq(inParam);


		return outParam;
	}
    /**
     * @brief 마감여부 조회 
     * @details 마감여부 조회 
     * @author : 이동겸
     * @date : 2020. 10. 07.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */
	public boolean selectPbnfClsnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClsnYnIqry -----");

		boolean outParam = true ;

		IA900001DTO iA900001DTO = daoIA9000.selectClsnInfoMgmtBASS(inParam);

		if(null == iA900001DTO  ) {
			outParam = false ;

		}else {
			/* 공시 마감여부 확인 */
			if(null != iA900001DTO.getPbnfClsnDtm() ) {
				outParam = false ;
			}

			LOGGER.info("##### 공시보고서검증  : {}", iA900001DTO.getPbnfClsnDtm());

		}

		return outParam;
	}


    /**
     * @brief 마감여부 조회 
     * @details 마감여부 조회
     * @author : 이동겸
     * @date : 2020. 10. 07.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */
	public boolean selectClsnYnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClsnYnIqry -----");

		boolean outParam = true ;

		IA900001DTO iA900001DTO = daoIA9000.selectClsnInfoMgmtBASS(inParam);

		if(null == iA900001DTO  ) {
			outParam = false ;
		}else {
			/* 정산표 마감여부 확인 */
			if(null != iA900001DTO.getAdjsClsnDtm()) {
				outParam = false ;
			}

			LOGGER.info("##### 정산표 마감  : {}", iA900001DTO.getAdjsClsnDtm());
			LOGGER.info("##### 재무제표 : {}", iA900001DTO.getFnstClsnDtm());
			LOGGER.info("##### 포괄손익  : {}", iA900001DTO.getIcsClsnDtm());
			LOGGER.info("##### 공시보고서검증  : {}", iA900001DTO.getPbnfClsnDtm());
			LOGGER.info("##### outParam     : {}", outParam);

		}

		return outParam;
	}

    /**
     * @brief 마감여부 조회 
     * @details 정산표, 재무상태표, 포괄손익 마감여부 조회 
     * @author : 이동겸
     * @date : 2020. 11. 05.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */
	public boolean selectClsnYnIqryOn(IA900001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClsnYnIqry -----");

		boolean outParam = true ;

		IA900001DTO iA900001DTO = daoIA9000.selectClsnInfoMgmtBASS(inParam);

		if(null == iA900001DTO  ) {
			outParam = false ;
		}else {
			/* 정산표 마감여부 확인 */
			if(null == iA900001DTO.getAdjsClsnDtm()) {
				outParam = false ;
			}
			else if("IA5040".equals(inParam.getScrNo() )) {
				if(null != iA900001DTO.getFnstClsnDtm()) {
					outParam = false ;
				}
			}
			else if("IA5060".equals(inParam.getScrNo() )) {
				if(null != iA900001DTO.getIcsClsnDtm()) {
					outParam = false ;
				}
			}

			LOGGER.info("##### 정산표 마감  : {}", iA900001DTO.getAdjsClsnDtm());
			LOGGER.info("##### 재무제표 : {}", iA900001DTO.getFnstClsnDtm());
			LOGGER.info("##### 포괄손익  : {}", iA900001DTO.getIcsClsnDtm());
			LOGGER.info("##### 공시보고서검증  : {}", iA900001DTO.getPbnfClsnDtm());
			LOGGER.info("##### outParam     : {}", outParam);

		}

		return outParam;
	}




  /**
     * @brief 마감/기초 생성여부 등록 
     * @details 마감/기초 생성여부 등록 
     * @author : 이동겸
     * @date : 2020. 10. 07.
     * @version : 1.0.0
     * @param IA900001IN
     * @return int
     */
	public int insertClsnYnReg(IA900001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertClsnYnReg -----");

		int outParam = 0 ;
		outParam = daoIA9000.updateClsnInfoMgmtBASS(inParam);

		return outParam;
	}
	 /**
     * @brief 기초 생성 여부 조회 
     * @details 기초 생성 여부 조회 
     * @author : 이동겸
     * @date : 2020. 10. 07.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */
	public boolean selectBassCrtnYnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectBassCrtnYnIqry -----");

		boolean outParam = true ;

		IA900001DTO iA900001DTO = daoIA9000.selectClsnInfoMgmtBASS(inParam);

		if(iA900001DTO  == null ) {
			return outParam = false ;
		}

		LOGGER.info("##### 기초생성여부 : {}", iA900001DTO.getBassCrtn1Yn());
		/*기초생성 처리여부*/
		if("IA5130".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn1Yn())) {
				return outParam = false ;
			}
		}

		if("IA5150".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn2Yn())) {
				return outParam = false ;
			}
		}

		if("IA5200".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn3Yn())) {
				return outParam = false ;
			}

		}
		if("IA5230".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn4Yn())) {
				return outParam = false ;
			}

		}
		if("IA5030".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn5Yn())) {
				return outParam = false ;
			}

		}
		if("IP2080".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn6Yn())) {
				return outParam = false ;
			}

		}
		if("IA5280".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn7Yn())) {
				return outParam = false ;
			}

		}
		if("IA5260".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn8Yn())) {
				return outParam = false ;
			}

		}
		if("IA5300".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn9Yn())) {
				return outParam = false ;
			}

		}
		if("IA5310".equals(inParam.getScrNo())) {
			if("Y".equals(iA900001DTO.getBassCrtn10Yn())) {
				return outParam = false ;
			}

		}

		return outParam;

	}
}
