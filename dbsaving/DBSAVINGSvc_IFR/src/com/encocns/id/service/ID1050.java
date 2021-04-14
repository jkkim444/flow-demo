/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1050.java
 * @brief 검증기준관리 Service
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
import com.encocns.id.dao.ID1050DAO;
import com.encocns.id.dto.ID105003DTO;
import com.encocns.id.service.svo.ID105001IN;
import com.encocns.id.service.svo.ID105001OUT;
import com.encocns.id.service.svo.ID105002IN;
import com.encocns.id.service.svo.ID105002OUT;
import com.encocns.id.service.svo.ID105003IN;
import com.encocns.id.service.svo.ID105003OUT;

/**
 * @brief 검증기준관리 Service
 * @details 검증기준관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID1050 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1050.class);

	@Autowired
	private ID1050DAO daoID1050;

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private IA9000 iA9000;


    /**
     * @brief 보고서목록 조회
     * @details 보고서목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105001IN
     * @return ID105001OUT
     */
	public ID105001OUT selectHeaderList(ID105001IN inParam) throws EnfraBusinessException {

		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeaderList -----");

		ID105001OUT outParam = new ID105001OUT();
		// 보고서 명 조회
		outParam.setPbnfRptNm(daoID1050.selectOnePbnfRptNm(inParam));
		// 보고서 양식 조회
		outParam.setArrList(daoID1050.selectHeader(inParam));
		// 보고서 머지 조회
		outParam.setArrListMerge(daoID1050.selectMergeCell(inParam));

		if(null == outParam.getPbnfRptNm()) {
			throw new EnfraBusinessException("E000061");
		}

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
     * @brief 검증기준 조회
     * @details 검증기준 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105002IN
     * @return ID105002OUT
     */
	public ID105002OUT selectValbaList(ID105002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectValbaList -----");

		ID105002OUT outParam = new ID105002OUT();
		// 검증 내역 조회
		outParam.setArrList(daoID1050.selectValbaList(inParam));
		return outParam;
	}

    /**
     * @brief 검증기준 등록 및 수정
     * @details 검증기준 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID105003IN
     * @return ID105003OUT
     */
	public ID105003OUT mergeValba(ID105003IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeValba -----");

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

		int iResult = 0;

		String usrId = serviceComponent.getSessionVO().getUserId();

		// 셀ID 조회
		String strCellId = daoID1050.selectCellId(inParam);
		inParam.setCellId(strCellId);

		// 검증기준 삭제
		daoID1050.deleteValba(inParam);

		// 검증기준 등록
		for(ID105003DTO dtoTemp : inParam.getArrList()) {
			dtoTemp.setCellId(strCellId);
			dtoTemp.setUsrId(usrId);

			// 검증정보 등록
			iResult += daoID1050.insertValba(dtoTemp);
		}

		ID105003OUT outParam = new ID105003OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 마감정보 조회
     * @details 마감정보 조회
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
