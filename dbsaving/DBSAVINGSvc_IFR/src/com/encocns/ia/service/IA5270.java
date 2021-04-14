/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5270.java
 * @brief 유가증권처분내역 Service
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 05.
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
import com.encocns.ia.dao.IA5270DAO;
import com.encocns.ia.dto.IA527001DTO;
import com.encocns.ia.dto.IA527002DTO;
import com.encocns.ia.service.svo.IA527001IN;
import com.encocns.ia.service.svo.IA527001OUT;
import com.encocns.ia.service.svo.IA527003IN;
import com.encocns.ia.service.svo.IA527003OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 유가증권처분내역 관리 Service
 * @details 유가증권처분내역 관리 서비스입니다.
 * @author : 이미래
 * @date : 2020. 10. 05.
 * @version : 1.0.0
 */
@Service
public class IA5270 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5270.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5270DAO daoIA5270;

	@Autowired
	private IA9000 iA9000;
	
    /**
     * @brief 유가증권처분요약 조회 
     * @details 유가증권처분요약 조회 
     * @author : 이미래
     * @date : 2020. 10. 07.
     * @version : 1.0.0
     * @param IA527001IN
     * @return IA527001OUT
     */
	public IA527001OUT selectListMkstDspslBrf(IA527001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListMkstDspslBrf -----");

		IA527001OUT outParam = new IA527001OUT();

		List<IA527001DTO> arrList = null;

	    arrList =  daoIA5270.selectListMkstDspslBrf(inParam);

	    outParam.setBrfArrList(arrList);
	    /* 마감 처리 여부 검사 */
	    IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setClsnCtnt("미마감");
	   	}else {
	   		outParam.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}
	    

		return outParam;
	}
	  

    /**
     * @brief KGAPP 유가증권처분 건별 내역 저장
     * @details KGAPP 유가증권처분 건별 내역 저장
     * @author : 이미래
     * @date : 2020. 10. 07.
     * @version : 1.0.0
     * @param IA527003IN
     * @return IA527003OUT
     */
	public IA527003OUT mergeMkstDspslHistExcl(IA527003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeMkstDspslHist -----");

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getInsertExelList().get(0).getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);
        
        /**
        *
        * 기초생성 여부 검증
        *
        * */
        calliA9000selectBassCrtnYnIqry(inIA900001IN);
        
        int iResult=0;
        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("insertExelList", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        /**
         *  기준일자에 해당하는 데이터 삭제 처리
         **/
        IA527002DTO iA527002inParam = new IA527002DTO();
        iA527002inParam = inParam.getInsertExelList().get(1);
        iA527002inParam.setAcngBaseCd("01");
        daoIA5270.deleteMkstDspslHist(iA527002inParam);
        iA527002inParam.setAcngBaseCd("02");
        daoIA5270.deleteMkstDspslHist(iA527002inParam);

        /**
         *  엑셀 업로드로 여러건 받아서 loop 돌려서 처리한다.
         **/

        for(IA527002DTO IA527002IN : inParam.getInsertExelList()) {

        	/**
             *  1.유가증권 기초 존재 여부 검증
             *    입력 계정과목코드 검증
             *  2.유가증권 기초 존재시 저장처리한다.
             **/

//        	IA527002param.setAcngBaseCd("01");
//        	IA527002DTO IA527004out = daoIA5270.selectMkstBassExisYn(IA527002param);
//        	if(IA527004out == null) {
//        		throw new EnfraBusinessException("E000028"); // 미등록계정입니다.
//            }else {

//            }

        	IA527002IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        	iResult += daoIA5270.insertMkstDspslHistKgaap(IA527002IN);
        }

        /**
        /* 처분내역 요약(K-G)
        **/
        iA527002inParam.setAcngBaseCd("01");
        daoIA5270.insertMkstDspslBrf(iA527002inParam);

        IA527003OUT outParam = new IA527003OUT();
        outParam.setiResult(iResult);
        
        /**
        *
        * 유가증권 KGAAP 기초생성 정보 저장
        *
        * */

        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
		iResult += calliA9000insertClsnYnReg(inIA900001IN);

		return outParam;
	}

	
	/**
     * @brief 마감여부  검증
     * @details 마감여부 확인 검증
	 * @author : 이동겸
	 * @date : 2020. 10. 15.
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
	
	/**
     * @brief 기초 생성 여부 검증
     * @details 기초 생성 확인 검증
	 * @author : 이동겸
	 * @date : 2020. 10. 15.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */

	private boolean calliA9000selectBassCrtnYnIqry(IA900001IN inParam) throws EnfraBusinessException
	{
		boolean outParam = false;

		outParam = iA9000.selectBassCrtnYnIqry(inParam);

		if(!outParam) {
			throw new EnfraBusinessException("E000034"); // 마감정보 확인바랍니다.

		}

		return outParam;

	}
	
	/**
     * @brief 기타유형자산의 감가상각 기초생성 정보 등록
     * @details 기타유형자산의 감가상각 기초생성 정보 등록
	 * @author : 이동겸
	 * @date : 2020. 10. 15.
     * @version : 1.0.0
     * @param IA900001IN
     * @return int
     */
	private int calliA9000insertClsnYnReg(IA900001IN inParam) throws EnfraBusinessException
	{
		System.out.println(inParam.getBaseYm());
		System.out.println(inParam.getScrNo());
		System.out.println(inParam.getUsrId());
		int outParam = iA9000.insertClsnYnReg(inParam);

		return outParam;

	}

}
