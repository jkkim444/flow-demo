/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2110.java
 * @brief 대손충당금 집계내역 관리 Service
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

import java.math.BigDecimal;
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
import com.encocns.ip.dao.IP2110DAO;
import com.encocns.ip.dto.IP211001DTO;
import com.encocns.ip.dto.IP211002DTO;
import com.encocns.ip.dto.IP211003DTO;
import com.encocns.ip.service.svo.IP211001IN;
import com.encocns.ip.service.svo.IP211001OUT;
import com.encocns.ip.service.svo.IP211002IN;
import com.encocns.ip.service.svo.IP211002OUT;

/**
 * @brief 대손충당금 집계내역 관리 Service
 * @details 대손충당금 집계내역 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2110 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2110.class);

	@Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2110DAO daoIP2110;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 대손충당금 집계내역 조회
     * @details 대손충당금 집계내역 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211001IN
     * @return IP211001OUT
     */
	public IP211001OUT selectListLsrsrvTotl(IP211001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLsrsrvTotl -----");

		IP211001OUT outParamList = new IP211001OUT();

	    List<IP211001DTO> list = null;
	    if("1".equals(inParam.getLsrsrvTotlIqryCd()) ) {   //*pd 조회인 경우
	    	list =  daoIP2110.selectListPdLsrsrvTotl(inParam);
	    }
	    else if("2".equals(inParam.getLsrsrvTotlIqryCd())) {
	    	list =  daoIP2110.selectListlgdLsrsrvTotl(inParam);   //*lgd 조회인 경우
	    }
	    else if("3".equals(inParam.getLsrsrvTotlIqryCd())) {
	    	list =  daoIP2110.selectListStgLsrsrvTotl(inParam);   //*stg 조회인 경우
	    }
	    else if("4".equals(inParam.getLsrsrvTotlIqryCd())) {
	    	list =  daoIP2110.selectListGdsLsrsrvTotl(inParam);   //*gds 조회인 경우
	    }
	    else if("5".equals(inParam.getLsrsrvTotlIqryCd())) {
	    	list =  daoIP2110.selectListStgSegLsrsrvTotl(inParam);   //*변동분금액 조회인 경우
	    }
	    else if("6".equals(inParam.getLsrsrvTotlIqryCd())) {
	    	list = daoIP2110.selectListGdsPdLgd(inParam); 			//*Pd+Lgd 조회인 경우
	    }
	    outParamList.setList01(list);

	   	// 마감정보 표시
	   	IA900002IN    inIA900002IN  =  new IA900002IN();

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
     * @brief 대손충당금 집계내역 엑셀다운로드
     * @details 대손충당금 집계내역 엑셀다운로드합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211001IN
     * @return IP211001OUT
     */
	public IP211001OUT selectListLsrsrvClclExcl(IP211001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListLsrsrvClclExcl -----");

		IP211001OUT outParamList = new IP211001OUT();

	    List<IP211002DTO> list = null;

	    list =  daoIP2110.selectListLsrsrvClclExcl(inParam);

	    outParamList.setList02(list);
		return outParamList;

	}

    /**
     * @brief 대손충당금 Life PD 산출
     * @details 대손충당금 Life PD 산출합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return IP211002OUT
     */
	public IP211002OUT calcJrlzTrgtAmtPd(IP211002IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

		inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

		IP211002OUT outParam = new IP211002OUT();

		// Parameter validation
		RuleSet ruleSet = new RuleSet();
		ruleSet.addRule("stdrYm", new RequiredRule(true));
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
         * 01. LifetimePD산출내역 삭제
         *
         * 02. 대손충당금 산출내역 삭제
		 *
		***/

		iResult = daoIP2110.deleteLtpdclclhistAll(inParam); //01
	    iResult = daoIP2110.deleteLsrsrvclclhistAll(inParam); //02

		/**
		 *
		 * 01. LifeTime PD 산출 생성
		 *
		 * 02. 충당금/미수충당금  산출 근거 생성
		 *
		***/

		//01
		iResult = daoIP2110.updateRsrvMdumClcl(inParam);
		//02
		iResult = daoIP2110.updateRsrvLastClclBass(inParam);

		iResult = 1;

		outParam.setiResult(iResult);

		return outParam;

	}
	/**
     * @brief 대손충당금 산출, 분개처리
     * @details The 대손충당금, 산출 분개처리합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP211002IN
     * @return IP211002OUT
     */
	public IP211002OUT calcJrlzTrgtAmt(IP211002IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

		inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

		IP211002OUT outParam = new IP211002OUT();

		// Parameter validation
		RuleSet ruleSet = new RuleSet();
		ruleSet.addRule("stdrYm", new RequiredRule(true));
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
		 * 01. 충당금/미수충당금  산출 생성
		 *
		 * 02. 개별 충당금/미수충당금  산출 생성
		 *
		***/

		//01
		iResult = daoIP2110.updateRsrvLastClcl(inParam);

		iResult = daoIP2110.updateRsrvLastClclIndv(inParam);

		/**
		 * 01. 건별 요약 삭제
		 *
		 * 02. 산출 전 건별 요약 등록
		 *
		 */

		iResult = daoIP2110.deleteBadlnrsrvpcsebrf(inParam); //01

		iResult = daoIP2110.insertBadlnrsrvpcsebrf(inParam); //02

		/**
		 * 제각회수  전입금액 계산
		 *
		 **/
		IP211003DTO inIP211003DTO = new IP211003DTO() ;
        inIP211003DTO.setFrtrYm(inParam.getFrtrYm());  /** 전기년월 **/
        inIP211003DTO.setStdrYm(inParam.getStdrYm());  /** 당기년월 **/
        inIP211003DTO.setUsrId(serviceComponent.getSessionVO().getUserId()); /* 사용자 */

        IP211003DTO  outIP211003DTO = daoIP2110.selectMvinRetnAmt(inIP211003DTO);

        if(outIP211003DTO == null ) {
        	inIP211003DTO.setBfCnsdMvinAmt(BigDecimal.ZERO);
        	inIP211003DTO.setBfCnsdRetnAmt(BigDecimal.ZERO);
        }else {
        	inIP211003DTO.setBfCnsdMvinAmt(outIP211003DTO.getBfCnsdMvinAmt());
        	inIP211003DTO.setBfCnsdRetnAmt(outIP211003DTO.getBfCnsdRetnAmt());

        }
        //제각회수 금액 업데이트
        daoIP2110.updateDprnRtrv(inIP211003DTO);

		/**
		 *  ( 대손충당금 산출 )
		 *
		 * 01. 분개데이터대상내역 삭제 처리
		 *
		 * 02. 분개데이터대상내역 등록 처리
		 *
		 * 03. 분개상세 삭제
		 *
		 * 04. 분개상세 등록
		**/

		//01
		iResult = daoIP2110.deleteCalcJrlzTrgtAmt(inParam);
		//02
		iResult = daoIP2110.insertCalcJrlzTrgtAmt(inParam);
		//03
		iResult = daoIP2110.deletejrlzDtlProcs(inParam);
		//04
		iResult = daoIP2110.insertjrlzDtlProcs(inParam);
		iResult = 1;
		outParam.setiResult(iResult);

		return outParam;

	}

	/**
     * @brief 마감여부 검증
     * @details 마감여부 검증합니다.
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

