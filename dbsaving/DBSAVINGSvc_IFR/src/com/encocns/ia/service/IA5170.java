/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5170.java
 * @brief 계리보고서 정보 관리 Service
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
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.dao.IA5170DAO;
import com.encocns.ia.dto.IA517001DTO;
import com.encocns.ia.dto.IA517002DTO;
import com.encocns.ia.service.svo.IA517001IN;
import com.encocns.ia.service.svo.IA517001OUT;
import com.encocns.ia.service.svo.IA517002IN;
import com.encocns.ia.service.svo.IA517002OUT;
import com.encocns.ia.service.svo.IA517003IN;
import com.encocns.ia.service.svo.IA517003OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 계리보고서 정보 관리 Service
 * @details 계리보고서 정보 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5170 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5170.class);

	@Autowired
	private IA9000 iA9000;

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5170DAO daoIA5170;

    /**
     * @brief 계리보고서 정보 조회
     * @details 계리보고서 정보 조회
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517001IN
     * @return IA517001OUT
     */
	public IA517001OUT selectListAconRpt(IA517001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListAconRpt -----");

		IA517001OUT outParamList = new IA517001OUT();

	    /* 페이징 처리 없음...엑셀 업로드 처리를 위해 */
	    List<IA517001DTO> list =  daoIA5170.selectListAconRpt(inParam);

	    outParamList.setList(list);

	   	// 마감정보 표시
	   	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParamList.setClsnCtnt("미마감");
	   	}else {
	   		outParamList.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}

		return outParamList;

	}

    /**
     * @brief 계리보고서 저장
     * @details 계리보고서 저장
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517002IN
     * @return IA517002OUT
     */
	public IA517002OUT mergeAconRpt(IA517002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeAconRpt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("arrGridData", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        int iResult = 0;

        /**
         *
         * 기준일자 및 계리보고서코드 해당하는 데이터 삭제 처리
         *
         * */
        iResult = daoIA5170.deleteAconRpt(inParam);

        /**
         * 01.그리드 건 반영
         */
        for(IA517002DTO row : inParam.getArrGridData()) {
        	IA517001DTO iA517001DTO = new IA517001DTO();
        	iA517001DTO.setStdrYm(inParam.getStdrYm());
        	iA517001DTO.setAconRptItemDivCd(row.getAconRptItemDivCd());
        	iA517001DTO.setAconRptItemDivVal(row.getAconRptItemDivVal());
        	iA517001DTO.setFrmRetmSlry(inParam.getFrmRetmSlry());
        	iA517001DTO.setUsrId(serviceComponent.getSessionVO().getUserId());

        	iResult += daoIA5170.insertAconRpt(iA517001DTO);
        }


		IA517002OUT outParam = new IA517002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 분개 대상 검증 데이타 생성 
     * @details 계리보고서 저장
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA517003IN
     * @return IA517003OUT
     */
	public IA517003OUT calcJrlzTrgtAmt(IA517003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        int iResult = 0;

        /**
         *  (예측단위적립방식에 따른 DBO 및 사외적립자산 인식 Conversion_10 )
         *
         * 01. 분개데이터대상내역 삭제 처리
         *
         * 02. 분개데이터대상내역 등록 처리
         *
         * 03. 분개데이터 상세 삭제 처리
         *
         * 04. 분개데이터 상세 등록 처리
         * */

//
        iResult += daoIA5170.deleteCalcJrlzTrgtAmt(inParam); //01
        iResult += daoIA5170.insertCalcJrlzTrgtAmt(inParam); //02
        iResult += daoIA5170.deletejrlzDtlProcs(inParam); //03
        iResult += daoIA5170.insertjrlzDtlProcs(inParam); //04



        IA517003OUT outParam = new IA517003OUT();
		outParam.setiResult(iResult);

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

	private boolean calliA9000selectClsnYnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		boolean outParam = false;

		outParam = iA9000.selectClsnYnIqry(inParam);

		if(!outParam) {
			throw new EnfraBusinessException("E000033"); // 마감정보 확인바랍니다.

		}

		return outParam;

	}

}
