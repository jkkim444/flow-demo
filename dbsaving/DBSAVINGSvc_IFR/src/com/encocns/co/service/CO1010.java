/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO1010.java
 * @brief 사용자 관리 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 09. 03. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service
 * @brief Common Service Package
 */
package com.encocns.co.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO1010DAO;
import com.encocns.co.dto.CO101001DTO;
import com.encocns.co.service.svo.CO101001IN;
import com.encocns.co.service.svo.CO101001OUT;
import com.encocns.co.service.svo.CO101002IN;
import com.encocns.co.service.svo.CO101002OUT;
import com.encocns.co.service.svo.CO101003IN;
import com.encocns.co.service.svo.CO101003OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.core.service.handler.ExcelDownloadHandler;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.fw.util.EncryptionUtil;

/**
 * @brief 사용자 관리 Service
 * @details 사용자 관리 서비스입니다.
 * @author : 차상길
 * @date : 2020. 09. 03.
 * @version : 1.0.0
 */
@Service
public class CO1010 extends ExcelDownloadHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO1010.class);

	@Autowired
	private CO1010DAO daoCO1010;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 사용자 목록 조회
     * @details 사용자 목록을 조회합니다.
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param CO101001IN
     * @return CO101001OUT
     */
	public CO101001OUT selectUserList(CO101001IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectUserList -----");

		List<CO101001DTO> arrList = null;
		arrList = daoCO1010.selectUserList(inParam);

		if(0 < arrList.size()) {
			for(int i=0; i<arrList.size(); i++) {
				arrList.get(i).setPswd(EncryptionUtil.decrypt(arrList.get(i).getPswd()));
			}
		}

		CO101001OUT outParam = new CO101001OUT();
		outParam.setArrList(arrList);

		return outParam;
	}

    /**
     * @brief 사용자 등록 및 수정
     * @details 사용자를 등록 및 수정합니다.
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param CO101002IN
     * @return CO101002OUT
     */
    public CO101002OUT mergeUser(CO101002IN inParam) throws EnfraBusinessException {
        // Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("empno", new RequiredRule(true));
        ruleSet.addRule("deptCd", new RequiredRule(true));
        ruleSet.addRule("pswd", new RequiredRule(true));
        Validator.validation(inParam, ruleSet);

        inParam.setUserId(serviceComponent.getSessionVO().getUserId());

        // 패스워드 암호화
        inParam.setPswd(EncryptionUtil.encrypt(inParam.getPswd()));

        // 처리 건수 초기화
        int iResult = 0;

        // insert
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
                iResult = daoCO1010.insertUser(inParam);

                // 그룹사용자 등록 ( 2020.10.08 차상길 수정 / 그룹을 부서로 대체 )
                daoCO1010.insertGroupUser(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }
        // update
        else if("U".equals(inParam.getJobDivCd())) {
        	// 업데이트 처리
            iResult = daoCO1010.updateUser(inParam);
        }
        else {
    		// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

        CO101002OUT outParam = new CO101002OUT();
        outParam.setiResult(iResult);

        return outParam;
    }

    /**
     * @brief 사용자 정보 삭제
     * @details 사용자 정보 삭제
     * @author : 차상길
     * @date : 2020. 09. 03.
     * @version : 1.0.0
     * @param CO101003IN
     * @return CO101003OUT
     */
    public CO101003OUT deleteUser(CO101003IN inParam) {
    	// 사용자 삭제 처리
        int iResult = daoCO1010.deleteUser(inParam);

        // 그룹 사용자 삭제
        daoCO1010.deleteGroupUser(inParam);

        CO101003OUT outParam = new CO101003OUT();
        outParam.setiResult(iResult);
        return outParam;
    }

}
