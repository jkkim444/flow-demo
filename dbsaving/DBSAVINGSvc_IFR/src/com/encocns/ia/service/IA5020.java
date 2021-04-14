/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5020.java
 * @brief 제무제표 양식 Service
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

import com.encocns.ia.dao.IA5020DAO;
import com.encocns.ia.dto.IA502001DTO;
import com.encocns.ia.service.svo.IA502001IN;
import com.encocns.ia.service.svo.IA502001OUT;
import com.encocns.ia.service.svo.IA502002IN;
import com.encocns.ia.service.svo.IA502002OUT;
import com.encocns.ia.service.svo.IA502003IN;
import com.encocns.ia.service.svo.IA502003OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;

/**
 * @brief 제무제표 양식 관리 Service
 * @details 제무제표 양식 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA5020 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5020.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5020DAO daoIA5020;

    /**
     * @brief 제무제표 양식 조회
     * @details 제무제표 양식 조회합니다.
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA502001IN
     * @return IA502001OUT
     */
	public IA502001OUT selectListFnstFxfr(IA502001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListFnstFxfr -----");

		IA502001OUT outEtcList = new IA502001OUT();

	    List<IA502001DTO> list = null;

	    list =  daoIA5020.selectListFnstFxfr(inParam);

	    outEtcList.setList(list);

		return outEtcList;

	}


    /**
     * @brief 제무제표 양식 등록 및 수정
     * @details 제무제표 양식 등록 및 수정합니다.
	 * @author : 이동겸
	 * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA502002IN
     * @return IA502002OUT
     */
	public IA502002OUT mergeFnstFxfr(IA502002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeFnstFxfr -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("ifrsAccCd", new RequiredRule(true));
        ruleSet.addRule("ifrsAccNm", new RequiredRule(true));
        ruleSet.addRule("toacLvel", new RequiredRule(true));

        ruleSet.addRule("scrnIndcOrd", new RequiredRule(true));
        ruleSet.addRule("ecalTpCd", new RequiredRule(true));

//        ruleSet.addRule("lvelIfrsAccNm", new RequiredRule(true));
//        ruleSet.addRule("uprIfrsAccCd", new RequiredRule(true));
//        ruleSet.addRule("aplcStrtDt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        //계정코드 정합성 검사
      	if(inParam.getIfrsAccCd().length() < 10)  throw new EnfraBusinessException("E000036");

        int iResult = 0 ;

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */

        if("I".equals(inParam.getJobDivCd())) {

    		/* 계정코드가 존재 하는 경우 "U" , 미존재시 I */
    		if(iResult !=  0 ) {
    			iResult = daoIA5020.updateFnstFxfrEnd(inParam);
    		}
    		else {
    			//원래 있던 화면표시번호를 +1씩 증가
    			daoIA5020.updateScrnIndcOrd(inParam);

    		}
        	try {
            	// 등록 처리
        		iResult = daoIA5020.insertFnstFxfr(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}


        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
        	iResult = daoIA5020.updateFnstFxfr(inParam);

        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IA502002OUT outEtc = new IA502002OUT();
		outEtc.setiResult(iResult);

		return outEtc;
	}

    /**
     * @brief 재무제표 양식 정보 삭제
     * @details 재무제표 양식 정보 삭제
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA502003IN
     * @return IA502003OUT
     */
	public IA502003OUT deleteFnstFxfr(IA502003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteFnstFxfr -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("ecalTpCd", new RequiredRule(true));
        ruleSet.addRule("ifrsAccCd", new RequiredRule(true));
        ruleSet.addRule("aplcStrtDt", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0 ;
        int iResult2 = 0;
		int iResult3 = 0;

		iResult2 = daoIA5020.selectAplcEndDt(inParam);			  /* 삭제하려는 항목의 종료일자가 9999-12-31인지 확인 */

		iResult +=  daoIA5020.deleteFnstFxfr(inParam);            /* 삭제처리 */

		iResult3 += daoIA5020.updateFnstFxfrDel(inParam);         /* 최종계정과목코드 변경처리 */

    	//종료일자가 9999-12-31인 경우에만
		if(iResult2 != 0 && iResult3 == 0){
			iResult +=  daoIA5020.deleteScrnIndcOrd(inParam);            /* 화면표시순서 -1 */
		}

		IA502003OUT outEtc = new IA502003OUT();
		outEtc.setiResult(iResult);

		return outEtc;
	}

}
