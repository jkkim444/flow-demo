/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5210.java
 * @brief 임차시설물 복구비용 발생이력 관리 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
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
import com.encocns.ia.dao.IA5210DAO;
import com.encocns.ia.dto.IA521001DTO;
import com.encocns.ia.service.svo.IA521001IN;
import com.encocns.ia.service.svo.IA521001OUT;
import com.encocns.ia.service.svo.IA521002IN;
import com.encocns.ia.service.svo.IA521002OUT;
import com.encocns.ia.service.svo.IA521003IN;
import com.encocns.ia.service.svo.IA521003OUT;

/**
 * @brief 임차시설물 복구비용 발생이력 관리  Service
 * @details It is 임차시설물 복구비용 발생이력 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5210 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5210.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5210DAO daoIA5210;

    /**
     * @brief 임차시설물 복구비용 발생이력 조회
     * @details 임차시설물 복구비용 발생이력 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA521001IN
     * @return IA521001OUT
     */
	public IA521001OUT selectListLnrnGrmnPsvl(IA521001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLnrnGrmnPsvl -----");

		//ArrayList<IA521001DTO> arrList = daoIA5210.selectListLnrnGrmnPsvl(inParam);

		IA521001OUT outParamList = new IA521001OUT();

		/**
		 * 1.페이징 처리시 총 건수 산출
		 */
	    int totalCount = daoIA5210.selectTotalCount(inParam);

	    List<IA521001DTO> arrList = null;

	    /**
	     * 2.
	     * getSelectPage = -1 인 경우 전체 건수 조회
	     * 안닌 경우 페이징 처리 건수만 조회됨.
	     *
	     * */
	    if( inParam.getSelectPage()==-1 ) {
	    	arrList =  daoIA5210.selectListRentRcvrCost(inParam);
	    }
	    else {
	    	arrList =  daoIA5210.selectPaging(inParam);
	    }

	    outParamList.setCurrentPageNo(inParam.getSelectPage());
	    outParamList.setTotalCount(totalCount);
//	    outParamList.setArrList(arrList);  //todo

		return outParamList;

	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 등록 및 수정
     * @details 임대차보증금 현재가치 산출내역 등록 및 수정
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA521002IN
     * @return IA521002OUT
     */
	public IA521002OUT mergeEarnRlesHold(IA521002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeEarnRlesHold -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0;
        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getAcqsDt())) {  //todo(getAcqsDt==> getCrgdCd)
        	try {
            	// 등록 처리
        		iResult = daoIA5210.insertRentRcvrCost(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getAcqsDt())) {
        		//업데이트 처리
        		iResult = daoIA5210.updateRentRcvrCost(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }



		IA521002OUT outParam = new IA521002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 삭제
     * @details 임대차보증금 현재가치 산출내역 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA521003IN
     * @return IA521003OUT
     */
	public IA521003OUT deleteEarnRlesHold(IA521003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteEarnRlesHold -----");


		IA521003OUT outParam = new IA521003OUT();
		outParam.setiResult(daoIA5210.deleteRentRcvrCost(inParam));

		return outParam;
	}

}
