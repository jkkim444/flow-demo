/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA5300.java
 * @brief IFRS 수정분개관리 management Service
 * @section Major History
 * <pre>
 *   - 이미래 | 2020. 10. 28. | First Created
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
import com.encocns.ia.dao.IA5300DAO;
import com.encocns.ia.dto.IA530001DTO;
import com.encocns.ia.service.svo.IA530001IN;
import com.encocns.ia.service.svo.IA530001OUT;
import com.encocns.ia.service.svo.IA530002IN;
import com.encocns.ia.service.svo.IA530002OUT;
import com.encocns.ia.service.svo.IA530003IN;
import com.encocns.ia.service.svo.IA530003OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 수정분개관리 Service
 * @details IFRS 수정분개관리 서비스입니다.
 * @author : 이미래
 * @date : 2020.10. 28. 
 * @version : 1.0.0
 */
@Service
public class IA5300 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA5300.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA5300DAO daoIA5300;
	
	@Autowired
	private IA9000 iA9000;

    /**
     * @brief IFRS 수정분개관리 조회
     * @details The IFRS 수정분개관리 조회
	 * @author : 이미래
	 * @date : 2020.10. 28. 
	 * @version : 1.0.0
     * @param IA530001IN
     * @return IA530001OUT
     */
	public IA530001OUT selectListAmndJrlzHist(IA530001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListIfrsAccd -----");

		IA530001OUT outParam = new IA530001OUT();

	    List<IA530001DTO> list = null;

	    list =  daoIA5300.selectListAmndJrlzHist(inParam);
	    outParam.setList(list);

	    /* 마감 여부 검증 */
		IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getSearchJlzYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setClsnCtnt("미마감");
	   	}else {
	   		outParam.setClsnCtnt(outIA900002OUT.getClsnCtnt());
	   	}
	   	
		return outParam;
	}


    /**
     * @brief IFRS 수정분개관리 등록 및 수정
     * @details IFRS 수정분개관리 등록 및 수정
	 * @author : 이미래
	 * @date : 2020.10. 28. 
	 * @version : 1.0.0
	 * @param IA530001IN
     * @return IA530002OUT
     */
	public IA530002OUT mergeAmndJrlzHist(IA530002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeIfrsAccd -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        
        int iResult = 0;
        
        /**
        *
        * 수정 분개 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getJlzYm());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		inParam.setJrlzBzwkCd("S13");
                inParam.setJrlzBzwkDtlCd("S1311");
        		iResult += daoIA5300.insertAmndJrlzHist(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
        		iResult += daoIA5300.updateAmndJrlzHist(inParam); // 업데이트
        }else {
        	// 오류 메시지 출력
        	throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		IA530002OUT outParam = new IA530002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief IFRS 수정분개관리 삭제
     * @details IFRS 수정분개관리 삭제
     * @author : 이미래
	 * @date : 2020.10. 28.
	 * @version : 1.0.0
     * @param IA530003IN
     * @return IA530003OUT
     */
	public IA530003OUT deleteAmndJrlzHist(IA530003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteAmndJrlzHist -----");

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getJlzYm());
        calliA9000selectClsnYnIqry(inIA900001IN);
        
        IA530003OUT outParam = new IA530003OUT();
		outParam.setiResult(daoIA5300.deleteAmndJrlzHist(inParam));

		return outParam;
	}
	
	
	/**
     * @brief IFRS 수정분개 기초 생성
     * @details IFRS 수정분개 기초 생성
     * @author : 이미래
	 * @date : 2020.10. 28.
	 * @version : 1.0.0
     * @param IA530001IN
     * @return IA530003OUT
     */
	public IA530003OUT insertAmndJrlzHistBass(IA530001IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteAmndJrlzHist -----");

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getSearchJlzYm());
        calliA9000selectClsnYnIqry(inIA900001IN);


        /**
        *
        * 기초생성 여부 검증
        *
        * */
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        calliA9000selectBassCrtnYnIqry(inIA900001IN);
        
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        int iResult = 0;
        IA530003OUT outParam = new IA530003OUT();
        iResult += daoIA5300.deleteAmndJrlzHistBass(inParam); /* 기초 삭제 */
		iResult += daoIA5300.insertAmndJrlzHistBass(inParam); /* 기초 생성 */

		/**
        *
        * 수정 분개 기초생성 정보 저장
        *
        * */
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
		iResult += calliA9000insertClsnYnReg(inIA900001IN);
		
		outParam.setiResult(iResult);
		return outParam;
	}
	
	
	/**
     * @brief IFRS 수정분개 산출
     * @details IFRS 수정분개상세 처리한다.
     * @author : 이미래
	 * @date : 2020.10. 28.
	 * @version : 1.0.0
     * @param IA530002IN
     * @return IA530003OUT
     */
	public IA530003OUT calcJrlzTrgtAmt(IA530002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteAmndJrlzHist -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        inParam.setJrlzBzwkCd("S13");
        int iResult = 0;
        IA530003OUT outParam = new IA530003OUT();
        
        /**
        *
        * 수정 분개 마감여부  검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getJlzYm());
        calliA9000selectClsnYnIqry(inIA900001IN);
        
        iResult += daoIA5300.deletejrlzDtlProcs(inParam); /* 분개상세 삭제 */
		iResult += daoIA5300.insertjrlzDtlProcs(inParam); /* 분개 생성 */
		inParam.setJrlzBzwkCd("S14");
		iResult += daoIA5300.insertjrlzDtlProcs_1(inParam); /* 분개 생성 */
		iResult += daoIA5300.insertjrlzDtlProcs_2(inParam); /* 분개 생성 */
		
		
		outParam.setiResult(iResult);
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
     * @brief 수기 분개 기초생성 정보 등록
     * @details 수기 분개 기초생성 정보 등록
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
