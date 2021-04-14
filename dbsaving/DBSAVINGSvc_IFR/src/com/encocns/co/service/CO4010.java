/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO4010.java
 * @brief 공지사항관리 Service
 * @section Major History
 * <pre>
 *   - 최호연 | 2020. 10. 19. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service
 * @brief Common Service Package
 */
package com.encocns.co.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO4010DAO;
import com.encocns.co.dto.CO401001DTO;
import com.encocns.co.service.svo.CO401001IN;
import com.encocns.co.service.svo.CO401001OUT;
import com.encocns.co.service.svo.CO401002IN;
import com.encocns.co.service.svo.CO401002OUT;
import com.encocns.co.service.svo.CO401003IN;
import com.encocns.co.service.svo.CO401003OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.component.vo.FileVO;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;

/**
 * @brief 공지사항관리 Service
 * @details It is 공지사항관리 service.
 * @author : 최호연
 * @date : 2020. 10. 19.
 * @version : 1.0.0
 */
@Service
public class CO4010 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO4010.class);

    @Autowired
    private ServiceComponent serviceComponent;

	@Autowired
	private CO4010DAO daoCO4010;

    /**
     * @brief 공지사항관리 조회
     * @details 공지사항관리 조회
	 * @author : 최호연
	 * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401001IN
     * @return CO401001OUT
     */
	public CO401001OUT selectListCmknMtr(CO401001IN inParam) throws EnfraBusinessException, Exception
	{
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectListCmknMtr -----");

		CO401001OUT outParamList = new CO401001OUT();

		int totalCount = daoCO4010.selectTotalCount(inParam);

	    List<CO401001DTO> arrList = null;

	    if( inParam.getSelectPage()==-1 ) {
	    	arrList =  daoCO4010.selectListCmknMtr(inParam);
	    }
	    else {
	    	arrList =  daoCO4010.selectPaging(inParam);
	    }

	    outParamList.setCurrentPageNo(inParam.getSelectPage());
    	outParamList.setTotalCount(totalCount);
	    outParamList.setArrList(arrList);


		return outParamList;

	}


    /**
     * @brief 공지사항관리 등록 및 수정
     * @details 공지사항관리 등록 및 수정
	 * @author : 최호연
	 * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401002IN
     * @return CO401002OUT
     * @throws EnfraBusinessException
     */
	public CO401002OUT mergeCmknMtr(CO401002IN inParam) throws EnfraBusinessException {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- mergeCmknMtr -----");

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

		int iResult = 0;

		String noticeYn = inParam.getNoticeYn();

		// 중요(상단노출) 체크시 "Y"값 반환 해제시 "N"값 반환
		if(noticeYn == "true") {
			inParam.setNoticeYn("Y");
		}else if(noticeYn == "false") {
			inParam.setNoticeYn("N");
		}
		/**
         * I : 등록 처리 한다
         * U : 수정 처리 한다
         * */

        if("I".equals(inParam.getJobDivCd())) {

        	try {
            	// 등록 처리
        		iResult = daoCO4010.insertCmknMtr(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }else if("U".equals(inParam.getJobDivCd())) {
    		//업데이트 처리
        	iResult = daoCO4010.mergeCmknMtr(inParam);
        }else {
        	// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

		CO401002OUT outParam = new CO401002OUT();
		outParam.setiResult(iResult);

		return outParam;
	}

    /**
     * @brief 공지사항 삭제
     * @details 공지사항 삭제
	 * @author : 최호연
	 * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401003IN
     * @return CO401003OUT
     */
	public CO401003OUT deleteCmknMtr(CO401003IN inParam) {
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- deleteCmknMtr -----");

        System.out.println(inParam.getRegDt());
		CO401003OUT outParam = new CO401003OUT();
		outParam.setiResult(daoCO4010.deleteCmknMtr(inParam));

		return outParam;
	}

	/**
     * @brief 공지사항 조회수 증가
     * @details 공지사항 조회수 증가
	 * @author : 최호연
	 * @date : 2020. 10. 19.
     * @version : 1.0.0
     * @param CO401003IN
     * @return CO401003OUT
     */
	public CO401003OUT updateCmknMtrViews(CO401003IN inParam)throws EnfraBusinessException
	{
        if(LOGGER.isDebugEnabled()) LOGGER.debug("----- updateCmknMtrViews -----");

        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("iqryTmcnt", new RequiredRule(true));
        ruleSet.addRule("regDt", new RequiredRule(true));
        ruleSet.addRule("regSeqno", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        int iResult = 0 ;


        iResult = daoCO4010.updateCmknMtrViews(inParam);


        ArrayList<FileVO> fileList = serviceComponent.getFileComponent().getAttachFileList("CO4010", inParam.getFileCpntId());

        CO401003OUT outEtc = new CO401003OUT();
		outEtc.setiResult(iResult);
		outEtc.setFileList(fileList);
		return outEtc;
	}

}
