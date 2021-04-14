/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID2020.java
 * @brief 공시보고서수기관리 Service
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
import com.encocns.id.dao.ID2020DAO;
import com.encocns.id.dto.ID202003DTO;
import com.encocns.id.service.svo.ID202001IN;
import com.encocns.id.service.svo.ID202001OUT;
import com.encocns.id.service.svo.ID202002IN;
import com.encocns.id.service.svo.ID202002OUT;

/**
 * @brief 공시보고서수기관리 Service
 * @details 공시보고서수기관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID2020 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID2020.class);

	@Autowired
	private ID2020DAO daoID2020;

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private IA9000 iA9000;


    /**
     * @brief 보고서 양식 및 산출정보 조회
     * @details 보고서 양식 및 산출정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID202001IN
     * @return ID202001OUT
     */
	public ID202001OUT selectClclVal(ID202001IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectClclVal -----");
		ID202001OUT outParam = new ID202001OUT();

		// 보고서 명 조회
		outParam.setPbnfRptNm(daoID2020.selectOnePbnfRptNm(inParam));

		// 보고서 완료 여부 조회
		outParam.setRptFinText(daoID2020.selectRptFin(inParam));

		// 보고서 양식 조회
		outParam.setArrList(daoID2020.selectHeader(inParam));
		// 보고서 머지 조회
		outParam.setArrListMerge(daoID2020.selectMergeCell(inParam));

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
     * @brief 보고서 수기 등록
     * @details 보고서 수기 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID202002IN
     * @return ID202002OUT
     */
	public ID202002OUT mergeClclVal(ID202002IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeClclVal -----");

		int iResult = 0;
		String usrId = serviceComponent.getSessionVO().getUserId();

        /**
        *
        * 마감 여부 검증
        *
        * */
		String a = inParam.getBaseYm();
		System.out.println(a);
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getBaseYm());
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        calliA9000selectPbnfClsnIqry(inIA900001IN);

		for(ID202003DTO dtoTemp : inParam.getArrList()) {

			dtoTemp.setUsrId(usrId);
			// 수기 데이터 업데이트
			iResult += daoID2020.mergeClcl(dtoTemp);

			// 수기 데이터 로그 기록
			daoID2020.insertRptLog(dtoTemp);

			// 수기 데이터가 숫자인 경우
			String pattern = "^[0-9]*$";
			if(false == pattern.matches(dtoTemp.getBchnVal()) || false == pattern.matches(dtoTemp.getAchnVal())) {
				// 수기 데이터가 속한 합계 업데이트
				daoID2020.mergeClclSum(dtoTemp);
				daoID2020.mergeValbaSum(dtoTemp);


				// 36.4 보고서 세율 계산
				if("36040".equals(dtoTemp.getPbnfRptId())) {
					daoID2020.updateClclCustom(dtoTemp);
				}
			}

			// 변경 셀 검증 데이터 수정
			iResult += daoID2020.updateValba(dtoTemp);

		}

		ID202002OUT outParam = new ID202002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}


    /**
     * @brief 보고서 확인 등록
     * @details 보고서 확인 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID202002IN
     * @return ID202002OUT
     */
	public ID202002OUT mergeRptFin(ID202002IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRptFin -----");

		int iResult = 0;
		String usrId = serviceComponent.getSessionVO().getUserId();
		inParam.setUsrId(usrId);

        /**
        *
        * 마감 여부 검증
        *
        * */
		String a = inParam.getBaseYm();
		System.out.println(a);
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getBaseYm());
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        calliA9000selectPbnfClsnIqry(inIA900001IN);

        // 보고서 완료 처리
		iResult += daoID2020.mergeRptFin(inParam);

		ID202002OUT outParam = new ID202002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 보고서 확인 해제
     * @details 보고서 확인 해제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID202002IN
     * @return ID202002OUT
     */
	public ID202002OUT deleteRptFin(ID202002IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteRptFin -----");

		int iResult = 0;
		String usrId = serviceComponent.getSessionVO().getUserId();
		inParam.setUsrId(usrId);

        /**
        *
        * 마감 여부 검증
        *
        * */
		String a = inParam.getBaseYm();
		System.out.println(a);
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getBaseYm());
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        calliA9000selectPbnfClsnIqry(inIA900001IN);

        // 보고서 완료 처리
		iResult += daoID2020.deleteRptFin(inParam);

		ID202002OUT outParam = new ID202002OUT();
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
