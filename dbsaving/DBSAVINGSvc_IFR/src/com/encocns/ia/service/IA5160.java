/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5160.java
 * @brief 퇴직금 지급 현황 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 14. | First Created
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
import com.encocns.ia.dao.IA5160DAO;
import com.encocns.ia.dto.IA516001DTO;
import com.encocns.ia.dto.IA516002DTO;
import com.encocns.ia.service.svo.IA516001IN;
import com.encocns.ia.service.svo.IA516001OUT;
import com.encocns.ia.service.svo.IA516002IN;
import com.encocns.ia.service.svo.IA516002OUT;
import com.encocns.ia.service.svo.IA516003IN;
import com.encocns.ia.service.svo.IA516003OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 퇴직금 지급 현황  Service
 * @details 퇴직금 지급 현황 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 9. 14.
 * @version : 1.0.0
 */
@Service
public class IA5160 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5160.class);

	@Autowired
	private IA9000 iA9000;

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5160DAO daoIA5160;

    /**
     * @brief 퇴직금 지급 현황 조회 
     * @details The 퇴직금 지급 현황 조회
     * @author : 이동겸
     * @date : 2020. 9. 14.
     * @version : 1.0.0
     * @param IA516001IN
     * @return IA516001OUT
     */
	public IA516001OUT selectListRetmPrvsPres(IA516001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListRetmPrvsPres -----");

		IA516001OUT outParamList = new IA516001OUT();

	    List<IA516001DTO> list = null;

	    /* 페이징 처리 없음...엑셀 업로드 처리를 위해 */
	    list =  daoIA5160.selectListRetmPrvsPres(inParam);

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
     * @brief 퇴직금 지급 현황 저장 
     * @details 퇴직금 지급 현황 저장
     * @author : 이동겸
     * @date : 2020. 9. 14.
     * @version : 1.0.0
     * @param IA516002IN
     * @return IA516002OUT
     */
	public IA516002OUT mergeRetmPrvsPres(IA516002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeRetmPrvsPres -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("yrThtrWorkPmcs", new RequiredRule(true));
        ruleSet.addRule("yrRetmSlryRsrv", new RequiredRule(true));
        ruleSet.addRule("yrInstlAsetIntEarn", new RequiredRule(true));
        ruleSet.addRule("yrFrmRetmSlry", new RequiredRule(true));
        ruleSet.addRule("arrGridData", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        int iResult = 0;

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /* 기준일자에 해당하는 데이타 삭제 처리*/

        iResult = daoIA5160.deleteRetmPrvsPres(inParam);

        for(IA516002DTO row : inParam.getArrGridData()) {
        	IA516001DTO iA516001DTO = new IA516001DTO();
        	iA516001DTO = new IA516001DTO();

        	iA516001DTO.setUsrId(serviceComponent.getSessionVO().getUserId());
        	iA516001DTO.setStdrYm(inParam.getStdrYm());
        	iA516001DTO.setQtrDivCd(row.getQtrDivCd());

        	iA516001DTO.setYrThtrWorkPmcs(inParam.getYrThtrWorkPmcs());
        	iA516001DTO.setYrRetmSlryRsrv(inParam.getYrRetmSlryRsrv());
        	iA516001DTO.setYrInstlAsetIntEarn(inParam.getYrInstlAsetIntEarn());
        	iA516001DTO.setYrFrmRetmSlry(inParam.getYrFrmRetmSlry());

        	iA516001DTO.setQtrRetmAprpDecAmt(row.getQtrRetmAprpDecAmt());

        	iA516001DTO.setQtrThtrWorkPmcs(inParam.getYrThtrWorkPmcs());
        	iA516001DTO.setQtrRetmSlryRsrv(inParam.getYrRetmSlryRsrv());
        	iA516001DTO.setQtrInstlAsetIntEarn(inParam.getYrInstlAsetIntEarn());

        	iA516001DTO.setQtrInstlAsetPrvs(row.getQtrInstlAsetPrvs());

        	iA516001DTO.setQtrFrmSlryDebtChg(iA516001DTO.getQtrThtrWorkPmcs().add(iA516001DTO.getQtrRetmSlryRsrv().add(iA516001DTO.getQtrRetmAprpDecAmt())));

        	iA516001DTO.setQtrInstlAsetChg(iA516001DTO.getQtrInstlAsetPrvs().add(iA516001DTO.getQtrInstlAsetIntEarn()));

        	iResult += daoIA5160.insertRetmPrvsPres(iA516001DTO);

        }

		IA516002OUT outParam = new IA516002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 분개 대상 검증 데이타 생성 
     * @details 분개 대상 저장 
     * @author : 이동겸
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA516003IN
     * @return IA516003OUT
     */
	public IA516003OUT calcJrlzTrgtAmt(IA516003IN inParam) throws EnfraBusinessException {
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
        iResult += daoIA5160.deleteCalcJrlzTrgtAmt(inParam); //01
        iResult += daoIA5160.insertCalcJrlzTrgtAmt(inParam); //02
        iResult += daoIA5160.deletejrlzDtlProcs(inParam); //03
        iResult += daoIA5160.insertjrlzDtlProcs(inParam); //04

        IA516003OUT outParam = new IA516003OUT();
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
