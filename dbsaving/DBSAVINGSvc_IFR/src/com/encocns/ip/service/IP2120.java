/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2120.java
 * @brief 대손충당금 요약 관리 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service
 * @brief Common Service Package
 */
package com.encocns.ip.service;

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
import com.encocns.ia.service.IA9000;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;
import com.encocns.ip.dao.IP2120DAO;
import com.encocns.ip.dto.IP212001DTO;
import com.encocns.ip.service.svo.IP212001IN;
import com.encocns.ip.service.svo.IP212001OUT;
import com.encocns.ip.service.svo.IP212002IN;
import com.encocns.ip.service.svo.IP212002OUT;
import com.encocns.ip.service.svo.IP212003IN;
import com.encocns.ip.service.svo.IP212003OUT;

/**
 * @brief 대손충당금 요약 관리 Service
 * @details 대손충당금 요약 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2120 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2120.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2120DAO daoIP2120;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 대손충당금 요약 조회
     * @details 대손충당금 요약을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212001IN
     * @return IP212001OUT
     */
	public IP212001OUT selectListLsrsrvBrf(IP212001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLsrsrvBrf -----");

		IP212001OUT outParamList = new IP212001OUT();

	    List<IP212001DTO> list = null;

	    list =  daoIP2120.selectListLsrsrvBrf(inParam);

	    outParamList.setCurrentPageNo(inParam.getSelectPage());
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
     * @brief 대손충당금 요약 생성
     * @details 대손충당금 요약 생성합니다.
	 * @author : 이동겸
	 * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP212002IN
     * @return IP212002OUT
     */
	public IP212002OUT mergeLsrsrvBrf(IP212002IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeLsrsrvBrf -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("chgAmtDivCd", new RequiredRule(true));
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

        iResult += daoIP2120.deleteMtprMgmt(inParam);   /*요약 삭제 */

    	iResult += daoIP2120.insertLsrsrvBrfBal(inParam);          /*요약 생성 대출잔액*/
        iResult += daoIP2120.insertLsrsrvBrfRtrvBal(inParam);      /*요약 생성(대출잔액 회수) */
        
        iResult += daoIP2120.insertLsrsrvBrf(inParam);   	       /*요약 생성 대손충당금*/
        iResult += daoIP2120.insertLsrsrvBrfRtrv(inParam);         /*요약 생성(대손 충당금 회수) */
        
        iResult += daoIP2120.insertLsrsrvBrfBal_V1(inParam);   	   /*요약 생성 대출잔액_V1*/
        iResult += daoIP2120.insertLsrsrvBrfRtrvBal_V1(inParam);   /*요약 생성(대출잔액_V1 회수) */
        iResult += daoIP2120.updateLsrsrvBrfBal_1(inParam);        /*요약 생성(대출잔액_V1 A02) */
        iResult += daoIP2120.updateLsrsrvBrfBal_2(inParam);        /*요약 생성(대출잔액_V1 A03) */
        iResult += daoIP2120.updateLsrsrvBrfBal_3(inParam);        /*요약 생성(대출잔액_V1 A03) */
        iResult += daoIP2120.updateLsrsrvBrfBal_4(inParam);        /*요약 생성(대출잔액_V1 A04) */
        iResult += daoIP2120.updateLsrsrvBrfBal_5(inParam);        /*요약 생성(대출잔액_V1 A04) */

        IP212002OUT outParam = new IP212002OUT();
		outParam.setiResult(iResult);
		return outParam;
	}

    /**
     * @brief 대손충당금 요약 저장
     * @details 대손충당금 요약을 저장합니다.
     * @author : CHOI, HO-YEON
     * @date : 2020. 11. 12.
     * @version : 1.0.0
     * @param IP212003IN
     * @return IP212003OUT
     */
    public IP212003OUT insertListLsrsrvBrf(IP212003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertLsrsrvBrf -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("frtrYm", new RequiredRule(true));
        ruleSet.addRule("arrGridData", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;

        /* 기준일자에 해당하는 데이타 삭제 처리*/
        iResult = daoIP2120.deleteMtprMgmt(inParam);

        /* 그리드의 입력된 값으로 저장 처리한다. */

        for(IP212001DTO iP212001DTO : inParam.getArrGridData()) {
            iP212001DTO.setUsrId(serviceComponent.getSessionVO().getUserId());
            iP212001DTO.setStdrYm(inParam.getStdrYm());
            iP212001DTO.setFrtrYm(inParam.getFrtrYm());
            iP212001DTO.setChgAmtDivCd(inParam.getChgAmtDivCd());
            iResult += daoIP2120.insertListLsrsrvBrf(iP212001DTO);
        }

        IP212003OUT outParam = new IP212003OUT();
        outParam.setiResult(iResult);

        return outParam;
    }

	 /**
     * @brief 마감여부 검증
     * @details 마감여부를 검증합니다.
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

