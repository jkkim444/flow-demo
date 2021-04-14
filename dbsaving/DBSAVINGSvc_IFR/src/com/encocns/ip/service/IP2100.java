/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2100.java
 * @brief 담보가액 관리 Service
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
import org.springframework.dao.DataIntegrityViolationException;
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
import com.encocns.ip.dao.IP2100DAO;
import com.encocns.ip.dto.IP210001DTO;
import com.encocns.ip.dto.IP210002DTO;
import com.encocns.ip.service.svo.IP210001IN;
import com.encocns.ip.service.svo.IP210001OUT;
import com.encocns.ip.service.svo.IP210002IN;
import com.encocns.ip.service.svo.IP210002OUT;
import com.encocns.ip.service.svo.IP210003IN;
import com.encocns.ip.service.svo.IP210003OUT;
import com.encocns.ip.service.svo.IP210005IN;
import com.encocns.ip.service.svo.IP210005OUT;

/**
 * @brief 담보가액 관리 Service
 * @details 담보가액 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2100 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2100.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IP2100DAO daoIP2100;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 담보가액 목록 조회
     * @details 담보가액 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210001IN
     * @return IP210001OUT
     */
	public IP210001OUT selectListMtprHist(IP210001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListMtprHist -----");

		IP210001OUT outParamList = new IP210001OUT();
        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

	    int totalCount = daoIP2100.selectTotalCount(inParam);

	    List<IP210001DTO> list = null;
	    // 페이징 없는 조회
	    if( inParam.getSelectPage()==-1 ) {
	    	list =  daoIP2100.selectListMtprMgmt(inParam);
	    }
	    // 페이징 있는 조회
	    else {
	    	list =  daoIP2100.selectPaging(inParam);
	    }

	    outParamList.setCurrentPageNo(inParam.getSelectPage());
	    outParamList.setTotalCount(totalCount);
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
     * @brief 담보가액 정보 등록 및 수정
     * @details 담보가액 정보를 등록 및 수정합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210002IN
     * @return IP210002OUT
     */
	public IP210002OUT mergeMtprHist(IP210002IN inParam)throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeMtprHist -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("loanAcno", new RequiredRule(true));
        ruleSet.addRule("mtpr", new RequiredRule(true));
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
         * 대손충당금 기본에 등록 되어있는 계좌번호인지 조회
         * */

        iResult = daoIP2100.selectChkLnrnlsrsrvtrgtbsic(inParam);
        if(daoIP2100.selectChkLnrnlsrsrvtrgtbsic(inParam) == 0) {
        	throw new EnfraBusinessException("E000035"); // 미존재 대출계좌번호 입니다.
        }

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoIP2100.insertMtprMgmt(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
        		//업데이트 처리
        		iResult = daoIP2100.updateMtprMgmt(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IP210002OUT outParam = new IP210002OUT();
		outParam.setiResult(iResult);
		return outParam;
	}

    /**
     * @brief 담보가액 정보 삭제
     * @details 담보가액 정보를 삭제합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP210003IN
     * @return IP210003OUT
     */
	public IP210003OUT deleteMtprHist(IP210003IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteMtprHist -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("stdrYm", new RequiredRule(true));
        ruleSet.addRule("loanAcno", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


		IP210003OUT outParam = new IP210003OUT();
		outParam.setiResult(daoIP2100.deleteMtprMgmt(inParam));

		return outParam;
	}

    /**
     * @brief 담보가액 정보 엑셀업로드
     * @details 담보가액 정보를 엑셀업로드합니다.
     * @author : 이동겸
     * @date : 2020. 09. 24.
     * @version : 1.0.0
     * @param IP210005IN
     * @return IP210005OUT
     */
	public IP210005OUT insertMtprHistExcl(IP210005IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeEtcTypAsetDprc -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("arrGridData", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getArrGridData().get(0).getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        int iResult = 0;
        IP210002IN ip210002IN = new IP210002IN();
        ip210002IN.setStdrYm(inParam.getArrGridData().get(0).getStdrYm());
        iResult= daoIP2100.deleteMtprMgmtAll(ip210002IN);

        /*loop 반영 */

        for(IP210002DTO iP210002DTO : inParam.getArrGridData()){

        	IP210002IN iP210002IN = new IP210002IN();

        	iP210002IN.setStdrYm(iP210002DTO.getStdrYm());
        	iP210002IN.setLoanAcno(iP210002DTO.getLoanAcno().trim());
        	iP210002IN.setMtpr(iP210002DTO.getMtpr());
        	iP210002IN.setUsrId(inParam.getUsrId());
            /**
             * 대손충당금 기본에 등록 되어있는 계좌번호인지 조회
             * */

            iResult = daoIP2100.selectChkLnrnlsrsrvtrgtbsic(iP210002IN);
            if(daoIP2100.selectChkLnrnlsrsrvtrgtbsic(iP210002IN) == 0) {
            	throw new EnfraBusinessException("E000035"); // 미존재 대출계좌번호 입니다.
            }

        	try {
            	// 등록 처리
        		iResult += daoIP2100.insertMtprMgmt(iP210002IN);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }

        IP210005OUT outParam = new IP210005OUT();
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

