/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID2030.java
 * @brief 공시보고서검증 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.service
 * @brief ID Service Package
 */
package com.encocns.id.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.service.IA9000;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;
import com.encocns.id.dao.ID2030DAO;
import com.encocns.id.service.svo.ID203001IN;
import com.encocns.id.service.svo.ID203001OUT;
import com.encocns.id.service.svo.ID203002IN;
import com.encocns.id.service.svo.ID203002OUT;
import com.encocns.id.service.svo.ID203003IN;
import com.encocns.id.service.svo.ID203003OUT;
import com.encocns.id.service.svo.ID203004IN;
import com.encocns.id.service.svo.ID203004OUT;


/**
 * @brief 공시보고서검증 Service
 * @details 공시보고서검증 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID2030 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID2030.class);

	@Autowired
	private ID2030DAO daoID2030;

	@Autowired
	private ServiceComponent serviceComponent;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 공시보고서 목록 조회
     * @details 공시보고서 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID203001IN
     * @return ID203001OUT
     */
	public ID203001OUT selectRptbsList(ID203001IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectRptbsList -----");

		ID203001OUT outParam = new ID203001OUT();
		outParam.setArrList(daoID2030.selectRptbsList(inParam));

    	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getBaseYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setPbnfCtnt("미마감");
	   	}else {
	   		outParam.setPbnfCtnt(outIA900002OUT.getPbnfCtnt());
	   	}

		return outParam;
	}

    /**
     * @brief 공시보고서 양식 조회
     * @details 공시보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID203002IN
     * @return ID203002OUT
     */
	public ID203002OUT selectRpthdr(ID203002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectRpthdr -----");

		ID203002OUT outParam = new ID203002OUT();

		// 보고서 양식 조회
		outParam.setArrList(daoID2030.selectHeader(inParam));
		// 보고서 머지 조회
		outParam.setArrListMerge(daoID2030.selectMergeCell(inParam));
		// 보고서 검증 성공여부
		outParam.setArrListValdtnYn(daoID2030.selectValbaYnCell(inParam));

		return outParam;
	}

    /**
     * @brief 공시보고서 검증 상세 조회
     * @details 공시보고서 검증 상세 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID203003IN
     * @return ID203003OUT
     */
	public ID203003OUT selectValbaList(ID203003IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectValbaList -----");

		ID203003OUT outParam = new ID203003OUT();
		// 산출 내역 조회
		outParam.setArrList(daoID2030.selectValbaList(inParam));

		return outParam;
	}

    /**
     * @brief 보고서 마감
     * @details 보고서 마감
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID203004IN
     * @return ID203004OUT
     */
	public ID203004OUT insertPbnfClsn(ID203004IN inParam) throws EnfraBusinessException	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertPbnfClsn -----");

		ID203004OUT outParam = new ID203004OUT();
        int iResult = 0;

		// 산출 내역 조회
        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getBaseYm());
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        calliA9000selectPbnfClsnIqry(inIA900001IN);

		iResult = iA9000.insertClsnYnReg(inIA900001IN);

		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 마감 정보 조회
     * @details 마감 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */
	private boolean calliA9000selectPbnfClsnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		boolean outParam = false;

		outParam = iA9000.selectPbnfClsnIqry(inParam);

		if(!outParam) {
			throw new EnfraBusinessException("E000033"); // 마감정보 확인바랍니다.
		}
		return outParam;
	}
}
