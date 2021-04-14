/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file ID1020.java
 * @brief 양식관리 Service
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
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.ia.service.IA9000;
import com.encocns.ia.service.svo.IA900001IN;
import com.encocns.ia.service.svo.IA900002IN;
import com.encocns.ia.service.svo.IA900002OUT;
import com.encocns.id.dao.ID1020DAO;
import com.encocns.id.dto.ID102002DTO;
import com.encocns.id.dto.ID102003DTO;
import com.encocns.id.service.svo.ID102001IN;
import com.encocns.id.service.svo.ID102001OUT;
import com.encocns.id.service.svo.ID102002IN;
import com.encocns.id.service.svo.ID102002OUT;

/**
 * @brief 양식관리 Service
 * @details 양식관리 서비스입니다.
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class ID1020 {

	private static final Logger LOGGER = LoggerFactory.getLogger(ID1020.class);

	@Autowired
	private ID1020DAO daoID1020;

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private IA9000 iA9000;

    /**
     * @brief 보고서 양식 조회
     * @details 보고서 양식 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID102001IN
     * @return ID102001OUT
     */
	public ID102001OUT selectHeader(ID102001IN in) throws EnfraBusinessException {

		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectHeader -----");

		if(daoID1020.isExistPbnfRpt(in) == 0) {
			throw new EnfraBusinessException("E000060");
		}

		ID102001OUT out = new ID102001OUT();

		out.setPbnfRptNm(daoID1020.selectOnePbnfRptNm(in));
		out.setArrList(daoID1020.selectHeader(in));
		out.setArrListMerge(daoID1020.selectMergeCell(in));

    	IA900002IN    inIA900002IN  =  new IA900002IN() ;

	   	inIA900002IN.setBaseYm(in.getBaseYm());

	   	IA900002OUT outIA900002OUT =  iA9000.selectClsnCtntInq(inIA900002IN);

	   	if(outIA900002OUT == null) {
	   		out.setPbnfCtnt("미마감");
	   	}else {
	   		out.setPbnfCtnt(outIA900002OUT.getPbnfCtnt());
	   	}

		return out;
	}

    /**
     * @brief 보고서 양식 등록 및 수정
     * @details 보고서 양식 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param ID102002IN
     * @return ID102002OUT
     */
	public ID102002OUT insertHeaderData(ID102002IN inParam) throws EnfraBusinessException {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- insertHeaderData -----");

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

		// delete cell data
		daoID1020.deleteHeaderMergeCellData(inParam);
		daoID1020.deleteHeaderData(inParam);

		int iResult = 0;
		String usrId = serviceComponent.getSessionVO().getUserId();
		List<ID102002DTO> dtoList = new ArrayList<ID102002DTO>();

		// 양식 등록 ( 기존 항목 )
		for(ID102002DTO dto : inParam.getArrList()) {

			if(null == dto.getCellId() || "".equals(dto.getCellId())) {
				dtoList.add(dto);
			}
			else {
				dto.setUsrId(usrId);
				iResult += daoID1020.insertHeaderCellData(dto);
			}

		}

		// 양식 등록 ( 추가 항목 )
		if(null != dtoList) {
			for(ID102002DTO dto : dtoList) {
				dto.setUsrId(usrId);
				iResult += daoID1020.insertHeaderCellData(dto);
			}
		}

		// 머지 등록
		for(ID102003DTO dto : inParam.getMergeList()) {

			dto.setUsrId(usrId);
			daoID1020.insertHeaderMergeCellData(dto);
		}

		// 병합된 셀중 미입력 처리되어 헤더지정이 되지 않은 항목 업데이트
		daoID1020.mergeHeaderMergeCell(inParam);


		ID102002OUT outParam = new ID102002OUT();
		outParam.setiResult(iResult);

		return outParam;
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

}
