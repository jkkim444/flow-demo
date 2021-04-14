/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1040.java
 * @brief 산출기준관리 Service
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
import com.encocns.id.dao.ID1040DAO;
import com.encocns.id.dto.ID104003DTO;
import com.encocns.id.service.svo.ID104001IN;
import com.encocns.id.service.svo.ID104001OUT;
import com.encocns.id.service.svo.ID104002IN;
import com.encocns.id.service.svo.ID104002OUT;
import com.encocns.id.service.svo.ID104003IN;
import com.encocns.id.service.svo.ID104003OUT;

/**
 * @brief 산출기준관리 Service
 * @details 산출기준관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID1040 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1040.class);

	@Autowired
	private ID1040DAO daoID1040;

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 보고서 양식 조회
     * @details 보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104001IN
     * @return ID104001OUT
     */
	public ID104001OUT selectHeaderList(ID104001IN inParam) throws EnfraBusinessException{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeaderList -----");

		ID104001OUT outParam = new ID104001OUT();

		// 보고서 명 조회
		outParam.setPbnfRptNm(daoID1040.selectOnePbnfRptNm(inParam));
		// 보고서 양식 조회
		outParam.setArrList(daoID1040.selectHeader(inParam));
		// 보고서 머지 조회
		outParam.setArrListMerge(daoID1040.selectMergeCell(inParam));

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
     * @brief 산출 기준 조회
     * @details 산출 기준 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104002IN
     * @return ID104002OUT
     */
	public ID104002OUT selectClcbaList(ID104002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClcbaList -----");

		ID104002OUT outParam = new ID104002OUT();

		// 산출 내역 조회
		outParam.setArrList(daoID1040.selectClcbaList(inParam));

		return outParam;
	}

    /**
     * @brief 산출기준 등록 및 수정
     * @details 산출기준 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID104003IN
     * @return ID104003OUT
     */
	public ID104003OUT mergeClcba(ID104003IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeClcba -----");

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
		String strCellId = daoID1040.selectCellId(inParam);

		inParam.setCellId(strCellId);

		// 산출기준 삭제
		daoID1040.deleteClcba(inParam);

		// 산출기준 등록
		for(ID104003DTO dtoTemp : inParam.getArrList()) {
			dtoTemp.setCellId(strCellId);
			dtoTemp.setUsrId(usrId);

			// 산출정보 등록
			iResult += daoID1040.insertClcba(dtoTemp);
		}

		ID104003OUT outParam = new ID104003OUT();
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
