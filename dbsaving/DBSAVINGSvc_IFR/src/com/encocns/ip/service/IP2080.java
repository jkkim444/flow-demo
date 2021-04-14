/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP2080.java
 * @brief 대손충당금대상 관리 Service
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.service.handler.ExcelDownloadHandler;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.ia.service.IA9000;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;
import com.encocns.ip.dao.IP2080DAO;
import com.encocns.ip.dto.IP208001DTO;
import com.encocns.ip.dto.IP208002DTO;
import com.encocns.ip.dto.IP208003DTO;
import com.encocns.ip.service.svo.IP208001IN;
import com.encocns.ip.service.svo.IP208001OUT;
import com.encocns.ip.service.svo.IP208002IN;
import com.encocns.ip.service.svo.IP208002OUT;
import com.encocns.ip.service.svo.IP208003IN;
import com.encocns.ip.service.svo.IP208003OUT;

/**
 * @brief 대손충당금대상 관리 Service
 * @details 대손충당금대상 관리 서비스입니다.
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
@Service
public class IP2080 extends ExcelDownloadHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(IP2080.class);

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private IP2080DAO daoIP2080;

    @Autowired
	private IA9000 iA9000;

    /**
     * @brief 대손충당금대상 목록 조회
     * @details 대손충당금대상 목록을 조회합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208001IN
     * @return IP208001OUT
     */
	public IP208001OUT selectListBadlnRsrv(IP208001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBadlnRsrv -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("searchStdrYm", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

		IP208001OUT outParamList = new IP208001OUT();

	    int totalCount = daoIP2080.selectTotalCount(inParam);

	    List<IP208001DTO> list = null;

	    // 페이징 없는 조회
	    if( inParam.getSelectPage()==-1 ) {
	    	list =  daoIP2080.selectListBadlnRsrv(inParam);
	    }
	    // 페이징 있는 조회
	    else {
	    	list =  daoIP2080.selectPaging(inParam);
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
     * @brief 대손충당금대상 기초 생성
     * @details 대손충당금대상 기초를 생성합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208002IN
     * @return IP208002OUT
     */
	public IP208002OUT insertBadlnRsrvBass(IP208002IN inParam) throws Exception
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertEtcTypAsetDprcBass -----");

        /*
         * 1.기준년월 + 등록자('9999')  가 존재 하는 경우 기초 자료 생성 오류 처리(중복 등록 방지)
         * 2.기준년월 + 계좌번호+ 고객번호 대출금액이 동일 한 경우 검증 오류 처리(중복 등록 방지)
         *
         * 1번 기준잉 경우만  특정 사번인 경우 무시 하고 처리(일단 송아영)(todo)
         *
         * */
        int iResult = 0 ;
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());
        IP208002OUT outParam = new IP208002OUT();

        /**
        *
        * 마감 여부 검증
        *
        * */
        IA900001IN inIA900001IN  = new IA900001IN();
        inIA900001IN.setBaseYm(inParam.getStdrYm());
        inIA900001IN.setScrNo(serviceComponent.getSessionVO().getScrn_id());
        inIA900001IN.setUsrId(serviceComponent.getSessionVO().getUserId());
        calliA9000selectClsnYnIqry(inIA900001IN);

        /**
        *
        * 대손충당금 기초생성 정보 조회
        *
        * */
        calliA9000selectBassCrtnYnIqry(inIA900001IN);


        /** 기존 자료 삭제 처리 후 반영
         *
         * 01. 대손충당금 기본 삭제
         *
         * 02. 타사연체 자료 삭제 처리
         *
         * 03. LifetimePD산출내역 삭제
         *
         * 04. 대손충당금 산출내역 삭제
         *
         * 05. 대손충당금건별요약 삭제
         *
         * 06. 대손충당금요약 삭제
         *
         * */
        iResult += daoIP2080.deleteBadlnRsrvAll(inParam);
        iResult += daoIP2080.deleteOtcpOvrdAll(inParam);
        iResult += daoIP2080.deleteLtpdclclhistAll(inParam);
        iResult += daoIP2080.deleteLsrsrvclclhistAll(inParam);
        iResult += daoIP2080.deleteBadlnrsrvpcsebrfAll(inParam);
        iResult += daoIP2080.deleteBadlnrsrvbrfAll(inParam);


        /** 대손충당금 기본 생성  */

        try {

        	iResult += daoIP2080.insertBadlnRsrvBass(inParam);
        }
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}


        /** 타사연체 자료 생성   */

        try {

        	iResult += daoIP2080.insertOtcpOvrdBass(inParam);
        }
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
    		// 중복 코드 에러 메시지 출력
            throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
		}


        /** 대손충당금 오류 내역 검증    */
       	iResult += daoIP2080.updateBadlnRsrvErr(inParam);



        /** 타사 연체 여부 처리    */
       	iResult += daoIP2080.updatetOtcpOvrdYn(inParam);

       	/** 개별 평가 여부 처리    */
       	iResult += daoIP2080.updateIndvTrevYn(inParam);


		/**
        *
        * 대손충당금 기초생성 정보 저장
        *
        * */

		iResult += calliA9000insertClsnYnReg(inIA900001IN);

        outParam.setiResult(iResult);
		return outParam;
	}

    /**
     * @brief 타사연체 여부 엑셀업로드
     * @details 타사연체 여부를 엑셀업로드합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208003IN
     * @return IP208003OUT
     */
	public IP208003OUT insertOtinovrdExcl(IP208003IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertOtinovrdExcl -----");

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

        /*loop 반영 */

        int iResult = 0 ;

        for(IP208003DTO IP208003DTO : inParam.getArrGridData()){



            IP208003DTO.setUsrId(serviceComponent.getSessionVO().getUserId());

        	iResult += daoIP2080.updatetOtinovrdhist(IP208003DTO);

        }

        IP208002IN iP208002IN = new IP208002IN();
        iP208002IN.setStdrYm(inParam.getArrGridData().get(0).getStdrYm());
        /** 타사 연체 여부 처리    */
       	iResult += daoIP2080.updatetOtcpOvrdYn(iP208002IN);

        IP208003OUT outEtc = new IP208003OUT();
		outEtc.setiResult(iResult);
		return outEtc;
	}

    /**
     * @brief 대손충당금대상 엑셀다운로드
     * @details 대손충당금대상 엑셀다운로드합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IP208001IN
     * @return IP208001OUT
     */
	public IP208001OUT selectListBadlnRsrvExcl(IP208001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListBadlnRsrvExcl -----");

		IP208001OUT outParamList = new IP208001OUT();

	    List<IP208002DTO> list = null;

	    list =  daoIP2080.selectListBadlnRsrvExcl(inParam);

		ArrayList<HashMap<String, Object>> reportList = new ArrayList<HashMap<String, Object>>();
		ArrayList<ArrayList<Object>> dataList = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> datas = new ArrayList<Object>();
		HashMap<String, Object> report = new HashMap<String, Object>();

		int iRowIdx = 0;

		for(IP208002DTO dtoTemp : list) {
			// 최초 헤더 생성
			if(0 == iRowIdx) {
				iRowIdx++;

				datas.add(dataMapPut("value","순번"));
				datas.add(dataMapPut("value","기준년월"));
				datas.add(dataMapPut("value","일련번호"));
				datas.add(dataMapPut("value","대출계좌번호"));
				datas.add(dataMapPut("value","고객번호"));
				datas.add(dataMapPut("value","고객명"));
				datas.add(dataMapPut("value","개인기업구분코드"));
				datas.add(dataMapPut("value","개인기업구분명"));
				datas.add(dataMapPut("value","상품명"));
				datas.add(dataMapPut("value","PDSegment코드"));
				datas.add(dataMapPut("value","PDSegment코드명"));
				datas.add(dataMapPut("value","LGDSegment코드"));
				datas.add(dataMapPut("value","LGDSegment코드명"));
				datas.add(dataMapPut("value","개별평가대상여부"));
				datas.add(dataMapPut("value","타기관연체여부"));
				datas.add(dataMapPut("value","대출일자"));
				datas.add(dataMapPut("value","만기일자"));
				datas.add(dataMapPut("value","대출금액"));
				datas.add(dataMapPut("value","대출잔액"));
				datas.add(dataMapPut("value","대출이율"));
				datas.add(dataMapPut("value","연체회차"));
				datas.add(dataMapPut("value","미수이자금액"));
				datas.add(dataMapPut("value","자산건전성분류코드"));
				datas.add(dataMapPut("value","대상검증코드"));
				dataList.add(datas);
				datas = new ArrayList<Object>();

			}

			datas.add(dataMapPut("value",dtoTemp.getrNum()));
			datas.add(dataMapPut("value",dtoTemp.getStdrYm()));
			datas.add(dataMapPut("value",dtoTemp.getSeqno()));
			datas.add(dataMapPut("value",dtoTemp.getLoanAcno()));
			datas.add(dataMapPut("value",dtoTemp.getCstno()));
			datas.add(dataMapPut("value",dtoTemp.getCustNm()));
			datas.add(dataMapPut("value",dtoTemp.getIdvdCorpDvcd()));
			datas.add(dataMapPut("value",dtoTemp.getIdvdCorpDvcdNm()));
			datas.add(dataMapPut("value",dtoTemp.getGdsNm()));
			datas.add(dataMapPut("value",dtoTemp.getPdSgmtCd()));
			datas.add(dataMapPut("value",dtoTemp.getPdSgmtNm()));
			datas.add(dataMapPut("value",dtoTemp.getLgdSgmtCd()));
			datas.add(dataMapPut("value",dtoTemp.getLgdSgmtNm()));
			datas.add(dataMapPut("value",dtoTemp.getIndvTrevYn()));
			datas.add(dataMapPut("value",dtoTemp.getOtinOvrdYn()));
			datas.add(dataMapPut("value",dtoTemp.getLoanDt()));
			datas.add(dataMapPut("value",dtoTemp.getExprDt()));
			datas.add(dataMapPut("value",dtoTemp.getLnam()));
			datas.add(dataMapPut("value",dtoTemp.getLoanBal()));
			datas.add(dataMapPut("value",dtoTemp.getLoanRt()));
			datas.add(dataMapPut("value",dtoTemp.getOvrdNth()));
			datas.add(dataMapPut("value",dtoTemp.getUcinAmt()));
			datas.add(dataMapPut("value",dtoTemp.getAsqlClcd()));
			datas.add(dataMapPut("value",dtoTemp.getTrgtValdtnCd()));
			dataList.add(datas);

			datas = new ArrayList<Object>();
		}

		report.put("sheetName", "대손충당금대상관리");
		report.put("data", dataList);
		reportList.add(report);

		outParamList.setMapList(reportList);

		super.setReportName("대손충당금대상관리.xlsx");
		super.addData(0, reportList);
		return outParamList;

	}

    /**
     * @brief 대손충당금대상 기초생성 정보 등록
     * @details 대손충당금대상 기초생성 정보를 등록합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
     * @version : 1.0.0
     * @param IA900001IN
     * @return int
     */
	private int calliA9000insertClsnYnReg(IA900001IN inParam) throws EnfraBusinessException, Exception {

		int outParam = iA9000.insertClsnYnReg(inParam);

		return outParam;

	}

    /**
     * @brief 기초 생성 여부 검증
     * @details 기초 생성 여부를 검증합니다.
     * @author : 이동겸
     * @date : 2020. 09. 01.
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
     * @brief 마감 여부 검증
     * @details 마감 여부를 검증합니다.
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

	public Object dataMapPut(String name, Object value){
		Object result = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		result = map;

		return result;
	}

}

