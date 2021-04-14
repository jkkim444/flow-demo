/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6030.java
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
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.dao.IA6030DAO;
import com.encocns.ia.dto.IA603001DTO;
import com.encocns.ia.service.svo.IA603001IN;
import com.encocns.ia.service.svo.IA603001OUT;
import com.encocns.ia.service.svo.IA603002IN;
import com.encocns.ia.service.svo.IA603002OUT;
import com.encocns.ia.service.svo.IA603003IN;
import com.encocns.ia.service.svo.IA603003OUT;
import com.encocns.ia.service.svo.IA603004IN;
import com.encocns.ia.service.svo.IA603004OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 무형자산 변동내역 관리 Service
 * @details 무형자산 변동내역 관리 서비스입니다.
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA6030 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6030.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA6030DAO daoIA6030;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 무형자산 변동내역 조회
     * @details 무형자산 변동내역 조회
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA603001IN
     * @return IA603001OUT
     */
	public IA603001OUT selectItgastchgList(IA603001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectItgastchgList -----");

	    List<IA603001DTO> arrList = daoIA6030.selectItgastchgList(inParam);

		IA603001OUT outParam = new IA603001OUT();

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
     * @brief 무형자산 변동내역 저장 
     * @details 무형자산 변동내역 저장
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA603002IN
     * @return IA603002OUT
     */
	public IA603002OUT mergeItgastchg(IA603002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeItgastchg -----");

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

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("itgastDivCd", new RequiredRule(true));
        ruleSet.addRule("asetNm", new RequiredRule(true));
        ruleSet.addRule("acqsDt", new RequiredRule(true));
        ruleSet.addRule("acqsAmt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0 ;

        if("".equals(inParam.getAsetCd())) {
            iResult = daoIA6030.insertItgastchg(inParam);
        }
        else {
    		iResult = daoIA6030.updateItgastchg(inParam);
        }

		IA603002OUT outParam = new IA603002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 무형자산 변동내역 기초생성 
     * @details 무형자산 변동내역 기초생성 
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA603001IN
     * @return IA603001OUT
     */
	public IA603001OUT selectItgastchgBass(IA603001IN inParam) throws Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectItgastchgBass -----");

	    List<IA603001DTO> arrList = daoIA6030.selectItgastchgBass(inParam);

	    IA603001OUT outParam = new IA603001OUT();
	    outParam.setArrList(arrList);

		return outParam;
	}


    /**
     * @brief 무형자산 변동내역 저장
     * @details 무형자산 변동내역 저장
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA603004IN
     * @return IA603004OUT
     */
	public IA603004OUT insertItgastchgExcel(IA603004IN inParam) throws Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertItgastchgExcel -----");
        String usrId = serviceComponent.getSessionVO().getUserId();

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

        // 기존 데이터 삭제
        daoIA6030.deleteItgastchgBass(inParam);

        // 엑셀 업로드 파일 등록
        for(IA603001DTO dtoTemp : inParam.getArrList()) {
        	dtoTemp.setUsrId(usrId);
        	dtoTemp.setBaseYm(inParam.getBaseYm());
        	iResult += daoIA6030.insertItgastchgExcel(dtoTemp);
        }

		IA603004OUT outParam = new IA603004OUT();
		outParam.setiResult(iResult);

		/**
		 *
		 * 무형자산 변동내역 정보 저장
		 *
		 * */
		calliA9000insertClsnYnReg(inIA900001IN);

		return outParam;
	}


    /**
     * @brief 무형자산 변동내역 삭제 
     * @details 무형자산 변동내역 삭제
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA603003IN
     * @return IA603003OUT
     */
	public IA603003OUT deleteItgastchg(IA603003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteItgastchg -----");

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

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("itgastDivCd", new RequiredRule(true));
        ruleSet.addRule("asetCd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IA603003OUT outParam = new IA603003OUT();
		outParam.setiResult(daoIA6030.deleteItgastchg(inParam));

		return outParam;
	}

    /**
     * @brief 무형자산 변동내역 마감 정보 등록
     * @details 무형자산 변동내역 마감 정보 등록
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
