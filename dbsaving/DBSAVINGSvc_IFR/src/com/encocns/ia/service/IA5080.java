/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5080.java
 * @brief 연결자본변동표관리 산출 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 16. | First Created
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
import com.encocns.ia.dao.IA5080DAO;
import com.encocns.ia.dto.IA508001DTO;
import com.encocns.ia.dto.IA508002DTO;
import com.encocns.ia.service.svo.IA508001IN;
import com.encocns.ia.service.svo.IA508001OUT;
import com.encocns.ia.service.svo.IA508002IN;
import com.encocns.ia.service.svo.IA508002OUT;
import com.encocns.ia.service.svo.IA508004IN;
import com.encocns.ia.service.svo.IA508004OUT;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 연결자본변동표관리 내역 Service
 * @details 연결자본변동표관리 내역 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 9. 16.
 * @version : 1.0.0
 */
@Service
public class IA5080 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5080.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5080DAO daoIA5080;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 연결자본변동표관리 내역 조회
     * @details 연결자본변동표관리 내역 조회
     * @author : 이동겸
     * @date : 2020. 9. 16.
     * @version : 1.0.0
     * @param IA508001IN
     * @return IA508001OUT
     */
	public IA508001OUT selectListlnknCaptChg(IA508001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListlnknCaptChg -----");

		IA508001OUT outEtcList = new IA508001OUT();

	    List<IA508001DTO> list = null;

	   	list =  daoIA5080.selectListlnknCaptChg(inParam);

	    outEtcList.setList(list);

	   	// 마감정보 표시
	   	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outEtcList.setClsnCtnt("미마감");
	   	}else {
	   		outEtcList.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}

		return outEtcList;

	}

    /**
     * @brief 연결자본변동표생성
     * @details 연결자본변동표생성
     * @author : 이동겸
	 * @date : 2020. 11. 03.
     * @version : 1.0.0
     * @param IA508002IN
     * @return IA508002OUT
     */
	public IA508002OUT insertspusCaptChgBal(IA508002IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertspusCaptChgBal -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("frtrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        /**
        *
        * 기준년월의 K-GAAP 제외한 연결자본변동표 삭제
        *
        * */
        iResult  += daoIA5080.deletelnknCaptChg(inParam);

        /**
        *
        * 01. 별도자본변동표 생성
        *
        * 02. 별도자본변동표 기초 수정 후 합계 산출
        *
        * 03. 별도자본변동표 기말 합계 산출
        *
        * */

        iResult  +=  daoIA5080.insertspusCaptChgBal(inParam); //01
        iResult  +=  daoIA5080.insertspusCaptChgBalCacl3(inParam); //02
        iResult  +=  daoIA5080.insertspusCaptChgBalCacl9(inParam); //03

        /**
        *
        * 01. 연결자본변동표 생성
        *
        * 02. 연결자본변동표 기초 수정 후 합계 산출
        *
        * 03. 연결자본변동표 기말 합계 산출
        *
        * */

        iResult  +=  daoIA5080.insertlnknCaptChgBal(inParam); //01
        iResult  +=  daoIA5080.insertlnknCaptChgBalCacl3(inParam); //02
        iResult  +=  daoIA5080.insertlnknCaptChgBalCacl9(inParam); //03

		IA508002OUT outParam = new IA508002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 연결자본변동표관리 K-GAAP 엑셀 업로드
     * @details 연결자본변동표관리 K-GAAP 엑셀 업로드
     * @author : 이동겸
	 * @date : 2020. 12. 15.
     * @version : 1.0.0
     * @param IA508004IN
     * @return IA508004OUT
     */
	public IA508004OUT insertlnknCaptChgExcl(IA508004IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertlnknCaptChgExcl -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("arrExcelData", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        inParam.setStdrYm(inParam.getArrExcelData().get(0).getStdrYm());
        // 연결자본변동표 K-GAAP 삭제
        iResult += daoIA5080.deletelnknCaptChgKgaap(inParam);

        int seqno = 19; // K-GAAP일 경우 순번 19부터 시작
		for(IA508002DTO iA508002DTO : inParam.getArrExcelData()) {
			iA508002DTO.setUsrId(serviceComponent.getSessionVO().getUserId());
			iA508002DTO.setSeqno(seqno);
			iA508002DTO.setSpusLnknDivCd("K");
			iResult += daoIA5080.insertlnknCaptChgExcl(iA508002DTO);
			seqno++;
		}

        IA508004OUT outParam = new IA508004OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

}
