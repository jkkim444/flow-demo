/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6060.java
 * @brief 임대차보증금 현재가치 산출내역 관리 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service
 * @brief Common Service Package
 */
package com.encocns.ia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.dao.IA6060DAO;
import com.encocns.ia.dto.IA606001DTO;
import com.encocns.ia.service.svo.IA606001IN;
import com.encocns.ia.service.svo.IA606001OUT;
import com.encocns.ia.service.svo.IA606002IN;
import com.encocns.ia.service.svo.IA606002OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 임대차보증금 현재가치 산출내역 관리 Service
 * @details 임대차보증금 현재가치 산출내역 관리 서비스입니다.
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA6060 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6060.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA6060DAO daoIA6060;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 임대차보증금 현재가치 산출내역 조회
     * @details 임대차보증금 현재가치 산출내역 조회
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA606001IN
     * @return IA606001OUT
     */
	public IA606001OUT selectCrtxcostcmpsList(IA606001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectCrtxcostcmpsList -----");

	    List<IA606001DTO> arrList = daoIA6060.selectCrtxcostcmpsList(inParam);

		IA606001OUT outParam = new IA606001OUT();

    	outParam.setArrList(arrList);

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
     * @brief 법인세비용구성관리 기초 생성
     * @details 법인세비용구성관리 기초 생성
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA606002IN
     * @return IA606002OUT
     */
	public IA606002OUT insertCrtxcostBass(IA606002IN inParam) throws Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertCrtxcostBass -----");

        int iResult = 0 ;

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

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // 기초 정보 삭제
        iResult = daoIA6060.deleteCrtxcostBass(inParam);
        try {
            // 기초 정보 등록
            iResult += daoIA6060.insertCrtxcostBass(inParam);
        }
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}



		IA606002OUT outParam = new IA606002OUT();
		outParam.setiResult(iResult);

		/**
        *
        * 대손충당금 기초생성 정보 저장
        *
        * */

		iResult += calliA9000insertClsnYnReg(inIA900001IN);

		return outParam;
	}

    /**
     * @brief 법인세비용구성관리 저장
     * @details 법인세비용구성관리 저장
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA606002IN
     * @return IA606002OUT
     */
	public IA606002OUT updateCrtxcostcmps(IA606002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateCrtxcostcmps -----");

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

        int iResult = 0 ;

        for(IA606001DTO dtoTemp : inParam.getArrList()) {
        	dtoTemp.setUsrId(serviceComponent.getSessionVO().getUserId());
            iResult = daoIA6060.updateCrtxcostcmps(dtoTemp);
        }

		IA606002OUT outParam = new IA606002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}


    /**
     * @brief 법인세비용구성관리 마감 정보 등록
     * @details 법인세비용구성관리 마감 정보 등록
	 * @author : 이동겸
	 * @date : 2020. 10. 26.
     * @version : 1.0.0
     * @param IA900001IN
     * @return int
     */
	private int calliA9000insertClsnYnReg(IA900001IN inParam) throws EnfraBusinessException, Exception {

		int outParam = iA9000.insertClsnYnReg(inParam);

		return outParam;
	}

    /**
     * @brief 마감여부  검증
     * @details 마감여부 확인 검증
	 * @author : 이동겸
	 * @date : 2020. 10. 26.
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
