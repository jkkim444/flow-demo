/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5280.java
 * @brief 유가증권기초내역 Service
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 12.
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
import com.encocns.ia.dao.IA5280DAO;
import com.encocns.ia.dto.IA527002DTO;
import com.encocns.ia.dto.IA528001DTO;

import com.encocns.ia.service.svo.IA528001IN;
import com.encocns.ia.service.svo.IA528002OUT;
import com.encocns.ia.service.svo.IA528003IN;
import com.encocns.ia.service.svo.IA528003OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 유가증권 기초 관리 Service
 * @details 유가증권 기초 관리 서비스입니다.
 * @author : 이미래
 * @date : 2020. 10. 12.
 * @version : 1.0.0
 */
@Service
public class IA5280 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5280.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5280DAO daoIA5280;

	@Autowired
	private IA5270DAO daoIA5270;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 유가증권기초 내역 조회
     * @details 유가증권기초 내역 조회 
     * @author : 이미래
     * @date : 2020. 10. 12.
     * @version : 1.0.0
     * @param IA528001IN
     * @return IA528002OUT
     */
	public IA528002OUT selecListtMkstBrfHist(IA528001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListMkstDspslHist -----");

		IA528002OUT outParam = new IA528002OUT();

		List<IA528001DTO> arrList = null;

		arrList =  daoIA5280.selecListtMkstBrfHist(inParam);

		outParam.setArrList(arrList);
	    
	    /* 마감 여부 검증 */
		IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setClsnCtnt("미마감");
	   	}else {
	   		outParam.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}
	    
		return outParam;
	}

    /**
     * @brief KGAPP 유가증권일괄 내역 저장
     * @details KGAPP 유가증권일괄 내역 엑셀 업로드 
     * @author : 이미래
     * @date : 2020. 10. 12.
     * @version : 1.0.0
     * @param IA528003IN
     * @return IA528003OUT
     */
	public IA528003OUT mergeMkstBassHistExcl(IA528003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeMkstDspslHist -----");
        
        /**
        *
        * 유가증권 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getInsertExelList().get(0).getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /**
        *
        * 기초생성 여부 검증
        *
        * */
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        calliA9000selectBassCrtnYnIqry(inIA900001IN);
        
        int iResult=0;
        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("insertExelList", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        /**
         *  유가증권 기초(기준년월 삭제 처리)
         **/
        IA528001DTO iA528002DTO = new IA528001DTO();
        iA528002DTO = inParam.getInsertExelList().get(0);
        daoIA5280.deleteMkstBassHist(iA528002DTO);   /* 유가증권 기초 테이블의 내역을 삭제 */

        /**
         *  유가증권_K-I 처분내역 삭제 처리
         **/
        IA527002DTO iA527002inParam = new IA527002DTO();
        iA527002inParam.setStdrYm(iA528002DTO.getStdrYm());
        iA527002inParam.setAcngBaseCd("02");
        daoIA5270.deleteMkstDspslHist(iA527002inParam); /* 유가증권 당기 처분 테이블의 IFRS 내역 삭제 */


        /**
         *  엑셀 업로드로 여러건 받아서 loop 돌려서 처리한다.
         **/

        for(IA528001DTO iA528001DTO : inParam.getInsertExelList()) {


        	iA528001DTO.setUsrId(serviceComponent.getSessionVO().getUserId());


       		iResult += daoIA5280.insertMkstBassHistKgaap(iA528001DTO);
        }
        
        IA528003OUT outParam = new IA528003OUT();
        outParam.setiResult(iResult);
        

		return outParam;
	}

	   /**
     * @brief 유가증권기초 요약 생성
     * @details 유가증권일관 및 유가증권처분 자료 생성 및 요약
     * @author : 이미래
     * @date : 2020. 10. 14.
     * @version : 1.0.0
     * @param IA528001IN
     * @return IA528003OUT
     */

	public IA528003OUT insertMkstBassHistBass(IA528001IN inParam) throws Exception
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEtcTypAsetDprcBass -----");


        int iResult = 0 ;
        IA528003OUT outParam = new IA528003OUT();
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
        *
        * 유가증권 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /**
        *
        * 기초생성 여부 검증
        *
        * */
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        calliA9000selectBassCrtnYnIqry(inIA900001IN);
        
        
       /**
        *  1. 유가증권 기초_K-G 변경 (당기처분 반영)
       **/
        inParam.setAcngBaseCd("01");
        iResult += daoIA5280.updateCaclMkstBassHist(inParam);

       /**
        * 2. 유가증권 기초_K-I 틀 생성 (당기처분, 기말정보 제외)
       **/
        iResult += daoIA5280.insertMkstBassHistIfrs_1(inParam);
        iResult += daoIA5280.insertMkstBassHistIfrs_2(inParam);
        iResult += daoIA5280.insertMkstBassHistIfrs_3(inParam);
        iResult += daoIA5280.insertMkstBassHistIfrs_4(inParam);
        iResult += daoIA5280.insertMkstBassHistIfrs_5(inParam);
        iResult += daoIA5280.insertMkstBassHistIfrs_6(inParam);
        iResult += daoIA5280.insertMkstBassHistIfrs_7(inParam);

       /**
        * 3. 유가증권 처분_K-I 생성 (당기처분장부가액,당기처분OCI 반영)
       **/

        iResult += daoIA5280.insertMkstDspslHistIfrs(inParam);

       /**
        * 4. 유가증권 처분_K-I 생성 (당기처분이익,당기처분손실 반영)
       **/

        iResult += daoIA5280.updateMkstDspslHistIfrs_1(inParam);
        iResult += daoIA5280.updateMkstDspslHistIfrs_2(inParam);

        /**
        /* 처분내역 요약(K-I)
        **/
        IA527002DTO iA527002inParam = new IA527002DTO();
        iA527002inParam.setStdrYm(inParam.getStdrYm());  //**기준일자
        iA527002inParam.setAcngBaseCd("02");             //**회계기준코드
        iA527002inParam.setUsrId(inParam.getUsrId());    //**사용자번호
        daoIA5270.insertMkstDspslBrf(iA527002inParam);


       /**
        * 5. 유가증권 기초_K-I 생성(당기처분 반영)
       **/
        inParam.setAcngBaseCd("02");
        iResult += daoIA5280.updateCaclMkstBassHist(inParam);

       /**
        * 6. 유가증권 기초_K-I 생성 (기말정보 반영)
       **/

        iResult += daoIA5280.insertMkstEdtmlHistIfrs(inParam);
        iResult += daoIA5280.mergeMkstEdtmAcbkAmtIfrs(inParam);

       /**
        * 7. 유가증권 기초_KIFRS Summary 생성 (금융상품구분과 범주및측정 6가지 CASE별 정보 생성)
       **/
        inParam.setAcngBaseCd("02");  /* K-I  */
        iResult += daoIA5280.insertMkstBrfHist(inParam);

       /**
        * 8. 유가증권 기초_KGAAP Summary 생성 (금융상품구분과 범주및측정 6가지 CASE별 정보 생성)
       **/
        inParam.setAcngBaseCd("01"); /* K-G */
        iResult += daoIA5280.insertMkstBrfHist(inParam);

        
        /**
        *
        * 유가증권 기초생성 정보 저장
        *
        * */

        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
		iResult += calliA9000insertClsnYnReg(inIA900001IN);

        outParam.setiResult(iResult);
		return outParam;
	}

	/**
     * @brief 분개 대상 검증 데이타 생성 
     * @details 유가증권기초 산출 
     * @author : 이미래
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA528001IN
     * @return IA528003OUT
     */
	public IA528003OUT calcJrlzTrgtAmt(IA528001IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = 0;
        
        /**
        *
        * 유가증권기초 마감여부  검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /**
         *  (  사업목적 및 현금흐름에 따른 금융상품 분류 및 측정 (별도) → 정액법 Conversion_2 (S10))
         *
         *
         * 02. 분개데이터대상내역 삭제 처리
         *
         * 03. 분개데이터대상내역 등록 처리
         *
         * 04. IFRS분개전표상세  삭제
         *
         * 05. IFRS분개전표상세  등록
         * */

        //02
        iResult += daoIA5280.deleteCalcJrlzTrgtAmt(inParam);
        //03
        iResult += daoIA5280.insertCalcJrlzTrgtAmtC2(inParam);
        iResult += daoIA5280.insertCalcJrlzTrgtAmtC3(inParam);
        iResult += daoIA5280.insertCalcJrlzTrgtAmtC4(inParam);
        iResult += daoIA5280.insertCalcJrlzTrgtAmtC5_1(inParam);
        iResult += daoIA5280.insertCalcJrlzTrgtAmtC5_2(inParam);
        //04
        iResult += daoIA5280.deletejrlzDtlProcs(inParam);
        //05
        iResult += daoIA5280.insertjrlzDtlProcsC2(inParam);
        iResult += daoIA5280.insertjrlzDtlProcsC3(inParam);
        iResult += daoIA5280.insertjrlzDtlProcsC4(inParam);
        iResult += daoIA5280.insertjrlzDtlProcsC5_1(inParam);
        iResult += daoIA5280.insertjrlzDtlProcsC5_2(inParam);

        IA528003OUT outParam = new IA528003OUT();
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

