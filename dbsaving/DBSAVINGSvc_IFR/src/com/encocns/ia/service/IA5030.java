/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5030.java
 * @brief 정산표 산출 Service
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 9. 24. | First Created
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

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.dao.IA5030DAO;
import com.encocns.ia.dto.IA503001DTO;
import com.encocns.ia.dto.IA503002DTO;
import com.encocns.ia.service.svo.IA503001IN;
import com.encocns.ia.service.svo.IA503001OUT;
import com.encocns.ia.service.svo.IA503002IN;
import com.encocns.ia.service.svo.IA503002OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief IFRS 정산표 산출 내역 Service
 * @details IFRS 정산표 산출 내역 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 9. 24.
 * @version : 1.0.0
 */
@Service
public class IA5030 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5030.class);
    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5030DAO daoIA5030;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief IFRS 정산표 산출 내역 조회
     * @details IFRS 정산표 산출 내역을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503001IN
     * @return IA503001OUT
     */
	public IA503001OUT selectListAdjsHistIqry(IA503001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListAdjsHistIqry -----");

		IA503001OUT outParam = new IA503001OUT();

	    List<IA503001DTO> list = null;

	    inParam.setUsrId(serviceComponent.getSessionVO().getUsr_id());

	   	// 마감정보 표시
	   	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchStdrYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setClsnCtnt("미마감");
	   	}else {
	   		outParam.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}

	   	/**
        *
        * 01. 정산표 산출TEMP 테이블 삭제
        *
        * 02. 정산표 산출TEMP 테이블 등록
        *
        * */

	   	daoIA5030.deleteIfrsAdjsClclHistTemp(inParam);	//01

	   	daoIA5030.insertIfrsAdjsClclHistTemp(inParam);	//02

	   	/**
        *
        * 01. 영업이익(손실)9030000000
        *
        * 02. 법인세차감전순이익(순손실)9060000000
        *
        * 03. 계속사업이익(손실)9080000000
        *
        * 04. 당기순이익9100000000
        *
        *
        */

	   	daoIA5030.insertHistTemp01(inParam); //01
	   	daoIA5030.insertHistTemp02(inParam); //02
	   	daoIA5030.insertHistTemp03(inParam); //03
	   	daoIA5030.insertHistTemp04(inParam); //04


	   	/**
        *
        * 01. 자본 당기순이익 구하기 전 합산 금액 차감
        *
        * 02. 자본당기순이익8210136200
        *
        * 03. 자본 당기순이익 구한 후 금액 재합산
        *
        * */


	   	daoIA5030.insertHistTempAmtIfrsSub(inParam); //01
	   	daoIA5030.insertHistTemp06(inParam); //02
	   	daoIA5030.insertHistTempAmtIfrsAdd(inParam); //03


	   	/**
        *
        * 01. 부채와자본총계 8999999999
        *
        * */
	   	daoIA5030.insertHistTemp05(inParam); //01

	   	// 정산표 산출TEMP 테이블 조회
	    list =  daoIA5030.selectListAdjsHistIqry(inParam);

	    IA503002DTO iA503002DTO_CHK01 = new IA503002DTO();
	    iA503002DTO_CHK01 = daoIA5030.selectChkIfrs01(inParam);
	    IA503002DTO iA503002DTO_CHK02 = new IA503002DTO();
	    iA503002DTO_CHK02 = daoIA5030.selectChkIfrs02(inParam);
	   	//검증식 1중 하나라도 false 이면
	   	if("N".equals(iA503002DTO_CHK01.getChkKgaap())	|| "N".equals(iA503002DTO_CHK01.getChkSpus())
	   		|| "N".equals(iA503002DTO_CHK01.getChkLnkn())){
	   		outParam.setChkAmt01("N");
	   	}
	   	//검증식 2중 하나라도 false 이면
	   	if("N".equals(iA503002DTO_CHK02.getChkKgaap()) || "N".equals(iA503002DTO_CHK02.getChkSpus())) {
	   		outParam.setChkAmt02("N");
	   	}

	    outParam.setList(list);

		return outParam;

	}

    /**
     * @brief IFRS 정산표 저장 
     * @details IFRS 정산표 저장
	 * @author : 이동겸
	 * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return IA503002OUT
     */
	public IA503002OUT mergeAdjsHistIqry(IA503002IN inParam) throws EnfraBusinessException, Exception {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeAdjsHistIqry -----");
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());


        int iResult =0 ;

        /**
        *
        * IFRS 정산표 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        inIA900001IN.setUsrId(inParam.getUsrId());

        calliA9000selectClsnYnIqry(inIA900001IN);


		iResult = daoIA5030.deleteIfrsAdjsClclHist(inParam);    //IFRS정산산출내역 삭제
		iResult = daoIA5030.deleteIfrstotacc(inParam);          //IFRS정산표 삭제

		iResult = daoIA5030.insertIfrsAdjsClclHist(inParam);  //IFRS정산산출내역 insert  처리
		iResult = daoIA5030.insertIfrstotacc(inParam); 		 //IFRS정산표 insert  처리

		/**
        *
        * IFRS 정산표 산출 마감 정보 저장
        *
        * */
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id()+ "02"); //마감처리 할때는 IA503002 로 입력
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
		iResult += calliA9000insertClsnYnReg(inIA900001IN);

		IA503002OUT outIfrs = new IA503002OUT();
		outIfrs.setiResult(iResult);

		return outIfrs;
	}


    /**
     * @brief  01.정산표 기초 자료생성 
     * @details 정산표 기초자료 생성
     * @author : 이동겸
     * @date : 2020. 9. 24.
     * @version : 1.0.0
     * @param IA503002IN
     * @return IA503002OUT
     */

	public IA503002OUT insertIfrstotaccBass(IA503002IN inParam) throws Exception
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertIfrstotaccBass -----");

        /*
         * 1.기준년월 + 등록자('9999')  가 존재 하는 경우 기초 자료 생성 오류 처리
         *
         * 특정 사번인 경우 무시 하고 처리(일단 송아영)(todo)
         *         *
         * */
        int iResult = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        /**
        *
        * IFRS 정산표 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /**
        *
        * IFRS 정산표 기초생성 정보 조회
        *
        * */
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        calliA9000selectBassCrtnYnIqry(inIA900001IN);

        IA503002OUT outEtc = new IA503002OUT();

        /* 기존 자료 삭제 처리 후 반영 */
        iResult += daoIA5030.deleteIfrstotaccBass(inParam); //K-GAAP 총계정원장 삭제
        iResult = daoIA5030.deleteKgaapacntAmt(inParam);    //K-GAAP 금액계정 삭제
        iResult = daoIA5030.deleteIfrstotacc(inParam);      //IFRS정산표 삭제
        /**
        *
        * 01. K-GAAP 총계정원장 등록
        *
        * 02. K-GAAP금액계정 등록
        *
        * 03. 정산표에 K-GAAP금액 등록
        *
        * */

        try {
        	iResult += daoIA5030.insertIfrstotaccBass(inParam);// 01
        }
        	catch (DataIntegrityViolationException e) {
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}

        try {
        	iResult += daoIA5030.insertKgaapacntAmt(inParam); // 02
        }
        	catch (DataIntegrityViolationException e) {
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}

        try {
        	iResult += daoIA5030.insertIfrsTotaccKgaapAmt(inParam); // 03
        }
        	catch (DataIntegrityViolationException e) {
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}
		/**
        *
        * IFRS 정산표 산출 마감 정보 저장
        *
        * */

		iResult += calliA9000insertClsnYnReg(inIA900001IN);

        outEtc.setiResult(iResult);
		return outEtc;
	}

    /**
     * @brief IFRS 정산표 기초생성/마감 정보 등록
     * @details IFRS 정산표 기초생성/마감 정보 등록
	 * @author : 이동겸
	 * @date : 2020. 10. 26.
     * @version : 1.0.0
     * @param IA900001IN
     * @return int
     */
	private int calliA9000insertClsnYnReg(IA900001IN inParam) throws EnfraBusinessException, Exception {

		//스크린ID가 IA503001로 들어오면 기초, IA503002로 들어오면 마감으로 처리
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
	 * @date : 2020. 10. 26.
     * @version : 1.0.0
     * @param IA900001IN
     * @return boolean
     */
	private boolean calliA9000selectBassCrtnYnIqry(IA900001IN inParam) throws EnfraBusinessException, Exception {
		boolean outParam = false;

		outParam = iA9000.selectBassCrtnYnIqry(inParam);

		if(!outParam) {
			throw new EnfraBusinessException("E000034"); // 마감정보 확인바랍니다.
		}
		return outParam;
	}

}
