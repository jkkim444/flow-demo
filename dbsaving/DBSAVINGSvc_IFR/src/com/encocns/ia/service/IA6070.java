/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA6070.java
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

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.dao.IA6070DAO;
import com.encocns.ia.dto.IA607001DTO;
import com.encocns.ia.dto.IA607002DTO;
import com.encocns.ia.dto.IA607003DTO;
import com.encocns.ia.service.svo.IA607001IN;
import com.encocns.ia.service.svo.IA607001OUT;
import com.encocns.ia.service.svo.IA607002IN;
import com.encocns.ia.service.svo.IA607002OUT;
import com.encocns.ia.service.svo.IA607003IN;
import com.encocns.ia.service.svo.IA607003OUT;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;

/**
 * @brief 임대차보증금 현재가치 산출내역 관리 Service
 * @details 임대차보증금 현재가치 산출내역 관리 서비스입니다.
 * @author : 차상길
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
@Service
public class IA6070 {

	private static final Logger LOGGER = LoggerFactory.getLogger(IA6070.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private IA6070DAO daoIA6070;

	@Autowired
	private IA9000 iA9000;


    /**
     * @brief 법인세효과적용관리 조회
     * @details 법인세효과적용관리 조회
     * @author : 차상길
     * @date : 2020. 11. 20.
     * @version : 1.0.0
     * @param IA607001IN
     * @return IA607001OUT
     */
	public IA607001OUT selectCrtxcostList(IA607001IN inParam) throws EnfraBusinessException
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectCrtxcostList -----");

		IA607001OUT outParam = new IA607001OUT();

		// 적용세율에 따른 법인세비용 구간별 계산 조회
		List<IA607001DTO> arrList1 = daoIA6070.selectPsectCrtxCostList(inParam);

		// 조회 값이 없는 경우 기초데이터 조회
		if(0 == arrList1.size()) {
			arrList1 = daoIA6070.selectPsectCrtxCostBassList(inParam);
		}

		BigDecimal clclTxamSum = new BigDecimal("0");

		// 구간별 산출 총액 산출
		for(IA607001DTO dtoTemp : arrList1) {
			clclTxamSum = clclTxamSum.add(dtoTemp.getClclTxam());
		}
		inParam.setCrtxCostAmt(clclTxamSum);

		// 구간별 산출 세액 총금액 및 적용세율 조회
		IA607002DTO dtoParam = daoIA6070.selectCrtxAplyTxrt(inParam);

		// 비과세수익 및 비공제비용 조회
		List<IA607003DTO> arrList2 = daoIA6070.selectCrtxcostList(inParam);

		// out 셋팅
		outParam.setArrList1(arrList1);
		outParam.setArrList2(arrList2);
		if(null != dtoParam) {
		    outParam.setAplyTxrt(dtoParam.getAplyTxrt());
		    outParam.setCrtxCostAmt(dtoParam.getCrtxCostAmt());
		    outParam.setNtprAmt(dtoParam.getNtprAmt());
		    outParam.setLnknIfrsAccAmt(dtoParam.getLnknIfrsAccAmt());
		}

    	IA900002IN inIA900002IN = new IA900002IN();

	   	inIA900002IN.setBaseYm(inParam.getBaseYm());

	   	IA900002OUT outIA900002OUT = iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setPbnfCtnt("미마감");
	   	}else {
	   		outParam.setPbnfCtnt(outIA900002OUT.getPbnfCtnt());
	   	}

		return outParam;

	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 저장 처리 한다
     * @details 임대차보증금 현재가치 산출내역 저장 처리 한다
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA607002IN
     * @return IA607002OUT
     */
	public IA607002OUT mergeCrtxcost(IA607002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeCrtxcost -----");

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
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // 적용세율에 따른 법인세비용 구간별 계산 삭제
        IA607003IN delParam = new IA607003IN();
        delParam.setBaseYm(inParam.getBaseYm());
        daoIA6070.deletePsectCrtxCost(delParam);

        // 적용세율에 따른 법인세비용 구간별 계산 등록
        for(IA607001DTO dtoTemp : inParam.getArrList1()) {
        	dtoTemp.setUsrId(serviceComponent.getSessionVO().getUserId());
        	daoIA6070.insertPsectCrtxCost(dtoTemp);
        }

        // 세무조정계산서 및 법인세금액 등록
        for(IA607003DTO dtoTemp : inParam.getArrList2()) {
        	dtoTemp.setUsrId(serviceComponent.getSessionVO().getUserId());
            iResult = daoIA6070.insertCrtxcost(dtoTemp);
        }

        // 적용세율 및 구간별법인세비용 총금액 등록
        daoIA6070.insertCrtxAplyTxrt(inParam);

		IA607002OUT outParam = new IA607002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 임대차보증금 현재가치 산출내역 삭제
     * @details 임대차보증금 현재가치 산출내역 삭제
     * @author : 차상길
     * @date : 2020. 8. 10.
     * @version : 1.0.0
     * @param IA607003IN
     * @return IA607003OUT
     */
	public IA607003OUT deleteCrtxcost(IA607003IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCrtxcost -----");

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

        int iResult = 0;

        // 적용세율에 따른 법인세비용 구간별 계산 삭제
        iResult += daoIA6070.deletePsectCrtxCost(inParam);

        // 비과세수익 및 비공제비용 삭제
        iResult += daoIA6070.deleteCrtxcost(inParam);

        // 구간별 산출 세액 총금액 및 적용세율 삭제
        iResult += daoIA6070.deleteCrtxAplyTxrt(inParam);

		IA607003OUT outParam = new IA607003OUT();
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
