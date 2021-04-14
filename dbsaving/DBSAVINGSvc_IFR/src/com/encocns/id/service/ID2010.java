/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file ID2010.java
 * @brief 공시보고서목록관리 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.id.service
 * @brief ID Service Package
 */
package com.encocns.id.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.service.handler.ExcelDownloadHandler;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.service.IA9000;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;
import com.encocns.id.dao.ID2010DAO;
import com.encocns.id.dto.ID201001DTO;
import com.encocns.id.dto.ID201002DTO;
import com.encocns.id.service.svo.ID201001IN;
import com.encocns.id.service.svo.ID201001OUT;
import com.encocns.id.service.svo.ID201002IN;
import com.encocns.id.service.svo.ID201002OUT;
import com.encocns.id.service.svo.ID201003IN;
import com.encocns.id.service.svo.ID201003OUT;
import com.encocns.id.service.svo.ID201004IN;
import com.encocns.id.service.svo.ID201004OUT;


/**
 * @brief 공시보고서목록관리 Service
 * @details 공시보고서목록관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID2010 extends ExcelDownloadHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(ID2010.class);

	@Autowired
	private ID2010DAO daoID2010;

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private IA9000 iA9000;


    /**
     * @brief 공시보고서 목록 조회
     * @details 공시보고서 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201001IN
     * @return ID201001OUT
     */
	public ID201001OUT selectRptbsList(ID201001IN inParam) throws EnfraBusinessException {

		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectRptbsList -----");
		ID201001OUT outParam = new ID201001OUT();
		outParam.setArrList(daoID2010.selectRptbsList(inParam));

    	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(inParam.getBaseYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		outParam.setPbnfCtnt("미마감");
	   	}else {
	   		outParam.setPbnfCtnt(outIA900002OUT.getPbnfCtnt());
	   	}

		return outParam;
	}

    /**
     * @brief 공시보고서 상세 조회
     * @details 공시보고서 상세 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201002IN
     * @return ID201002OUT
     */
	public ID201002OUT selectRptbsDtl(ID201002IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectRptbsDtl -----");

		ID201002OUT outParam = new ID201002OUT();

		// 보고서 양식 조회
		outParam.setArrList(daoID2010.selectHeader(inParam));
		// 보고서 머지 조회
		outParam.setArrListMerge(daoID2010.selectMergeCell(inParam));

		return outParam;
	}

    /**
     * @brief 공시보고서 산출
     * @details 공시보고서 산출
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201004IN
     * @return ID201004OUT
     */
	public ID201004OUT calcJrlzTrgtAmt(ID201004IN inParam) throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- calcJrlzTrgtAmt -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

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


        int iResult = 1;

        // 1. 산출 기준 및 산출 정보 초기화
        daoID2010.updateCalcJrlzTrgtAmt(inParam); // TB_ID_M_CLCBA(공시보고서산출기준) 처리
        daoID2010.deleteCalcJrlzTrgtAmt(inParam); // TB_ID_I_CLCL(공시보고서산출명세) 처리
//        daoID2010.deleteRptFin(inParam); 		  // TB_ID_M_RPTFINHIST 완료여부 초기화

        // 2. 개별 산출
        // 2.1 custom 산출
        daoID2010.deleteNdrprExprCf(inParam); // 예수부채 만기에 따른 현금흐름 삭제
        daoID2010.insertNdrprExprCf(inParam); // 예수부채 만기에 따른 현금흐름 등록
        daoID2010.updateClcbaCustom(inParam); // 보고서 산출

        // 2.2 계정 산출 (기말)
        daoID2010.updateClcbaAccd1(inParam);

        // 2.2 계정 산출 (기말 - KGAAP)
        daoID2010.updateClcbaAccdKgaap1(inParam);

        // 2.3 계정 산출 (기초)
        daoID2010.updateClcbaAccd2(inParam);

        // 2.4 소계 산출
        daoID2010.updateClcbaSum(inParam);

        // 2.6.1 타공시 보고서 ( 해당 공시보고서 셀을 산출정보로 가지고있는 항목 모두 업데이트)
        daoID2010.updateClcbaAnother(inParam);

        // 2.6.1 타공시를 포함한 합계 재산출
        daoID2010.updateClcbaAnotherSum(inParam);

        // 2.7 최종 산출 데이터 생성
        daoID2010.insertClcl(inParam);

        // 2.8 별도 로직 추가 (36.4 보고서) - 22% 세율 계산
        daoID2010.updateClclCustom(inParam);

        // 3. 검증 데이터 생성
        // 3.1 계정 데이터 산출
        daoID2010.updateValbaAccd(inParam);

        // 3.2 계정 데이터 산출 (기초)
        daoID2010.updateValbaAccd2(inParam);

        // 3.3 셀 데이터 산출
        daoID2010.updateValbaCell(inParam);

        ID201004OUT outParam = new ID201004OUT();
		outParam.setiResult(iResult);

		return outParam;


	}

    /**
     * @brief 보고서 다운로드
     * @details 보고서 다운로드
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID201003IN
     * @return ID201003OUT
     */
	public ID201003OUT selectRptDown(ID201003IN inParam) {

		ArrayList<HashMap<String, Object>> reportList = new ArrayList<HashMap<String, Object>>();

		// 보고서 출력
		for(ID201001DTO dtoTemp : inParam.getArrList()) {

			// 보고서 마지막 컬럼
			int maxColNum = 0;

			maxColNum = daoID2010.selectMaxColNum(dtoTemp);

			// 보고서 데이터 조회
			List<ID201002DTO> rptDataList = daoID2010.selectHeaderExcel(dtoTemp);

			// 엑셀 출력용 데이터로 변환
			ArrayList<ArrayList<Object>> dataList = new ArrayList<ArrayList<Object>>();
			ArrayList<Object> datas = new ArrayList<Object>();

			// 컬럼 넓이
			ArrayList<Integer> widthList = new ArrayList<Integer>();

			// merge
			List<ID201002DTO> dataMergeList = daoID2010.selectMergeCellExcel(dtoTemp);
			ArrayList<HashMap<String,Double>> merges = new ArrayList<HashMap<String,Double>>();

			int dataCnt = 0;

			// 데이터 생성
			for(ID201002DTO dtoTempDtl : rptDataList){

				int iWidth = dtoTempDtl.getCellCtnt().length()*15;

				if( 100 > iWidth ) {
					iWidth = 100;
				}

				// 첫행인 경우
				if(0 == dtoTempDtl.getRowNo()) {
					widthList.add(iWidth);
				}
				else {
					if(iWidth > widthList.get(dtoTempDtl.getColNo()).intValue()) {
						widthList.set(dtoTempDtl.getColNo(), iWidth);
					}
				}

				// 데이터 배열 생성
				String[] str = {"value","color","bold","align","type"};

				// 초기 데이터 생성
				Object[] sot = {dtoTempDtl.getCellCtnt(),"white",false,"left","str"};

				// 스타일 변경
				if("Y".equals(dtoTempDtl.getHdrYn())){
					sot[1] = "grey25";
					sot[2] = true;
					sot[4] = "str";
				}
				// 오른쪽 정렬
				else if("2".equals(dtoTempDtl.getAlignDvcd())){
					sot[3] = "right";
					sot[4] = "num";
				}
				// 가운데 정렬
				else if("3".equals(dtoTempDtl.getAlignDvcd())){
					sot[3] = "center";
					sot[4] = "num";
				}

				// 데이터 추가
				datas.add(dataMapPut(str, sot));
				dataCnt++;

				// 마지막 컬럼 체크
				if(dataCnt% maxColNum == 0){
					dataList.add(datas);
					datas = new ArrayList<Object>();
				}
			}

			// merge 처리
			for(ID201002DTO mergeDto : dataMergeList){
				merges.add(putMerge(mergeDto.getStartRowNo(), mergeDto.getStartColNo(), mergeDto.getEndRowNo(), mergeDto.getEndColNo()));
			}

			HashMap<String, Object> report = new HashMap<String, Object>();
			report.put("sheetName", dtoTemp.getPbnfRptNm());
			report.put("width", widthList);
			report.put("data", dataList);
			report.put("mergeData", merges);
			reportList.add(report);
		}

		ID201003OUT out = new ID201003OUT();
		out.setMapList(reportList);

		super.setReportName(inParam.getBaseYm() + "_공시보고서.xlsx");
		super.addData(0, reportList);

		return out;
	}


    /**
     * @brief 마감정보 조회
     * @details 마감정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
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

	public HashMap<String, Double> putMerge(int fri, int fci, int tri, int tci){
		HashMap<String, Double> data = new HashMap<String, Double>();

		data.put("fromRow", Double.valueOf(fri));
		data.put("fromColumn", Double.valueOf(fci));
		data.put("toRow", Double.valueOf(tri));
		data.put("toColumn", Double.valueOf(tci));
		return data;
	}

	public Object dataMapPut(String name, Object value){
		Object result = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		result = map;

		return result;
	}

	public Object dataMapPut(String[] name, Object[] value){
		Object result = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		for(int i=0;i<name.length;i++){
			map.put(name[i], value[i]);
		}
		result = map;

		return result;
	}

}
