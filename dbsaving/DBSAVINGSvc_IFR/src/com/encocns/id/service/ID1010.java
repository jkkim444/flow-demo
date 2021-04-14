/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID1010.java
 * @brief 기본정보관리 Service
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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.service.IA9000;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.id.dao.ID1010DAO;
import com.encocns.id.dto.ID101001DTO;
import com.encocns.id.service.svo.ID101001IN;
import com.encocns.id.service.svo.ID101001OUT;
import com.encocns.id.service.svo.ID101002IN;
import com.encocns.id.service.svo.ID101002OUT;

/**
 * @brief 기본정보관리 Service
 * @details 기본정보관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID1010 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1010.class);

	@Autowired
	private ID1010DAO daoID1010;

	@Autowired
	private IA9000 iA9000;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 보고서 목록 조회
     * @details 보고서 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101001IN
     * @return ID101001OUT
     */
	public ID101001OUT selRptList(ID101001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selRptList -----");
		List<ID101001DTO> arrList = daoID1010.selRptList(inParam);

		ID101001OUT out = new ID101001OUT();
		out.setArrList(arrList);

		return out;
	}

    /**
     * @brief 보고서 기초 생성
     * @details 보고서 기초 생성
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID101002IN
     * @return ID101002OUT
     */
	public ID101002OUT insertPbnfMgmtBass(ID101002IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertPbnfMgmtBass -----");

		inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
		int iResult = 1 ;

		// 마감 여부 확인
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getBaseYm());
        calliA9000selectPbnfClsnIqry(inIA900001IN);

        // 삭제
		daoID1010.deleteTbIdMHdrmgBass(inParam);
		daoID1010.deleteTbIdMRpthdrBass(inParam);
		daoID1010.deleteTbIdMValbaBass(inParam);
		daoID1010.deleteTbIdMClcbaBass(inParam);
		daoID1010.deleteTbIdIClclBass(inParam);
		daoID1010.deleteRptFinHist(inParam);


		// 등록
		daoID1010.insertTbIdMHdrmgBass(inParam);
		daoID1010.insertTbIdMRpthdrBass(inParam);
		daoID1010.insertTbIdMValbaBass(inParam);
		daoID1010.insertTbIdMClcbaBass(inParam);

		ID101002OUT out = new ID101002OUT();
		out.setiResult(iResult);

		return out;
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
