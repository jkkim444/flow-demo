/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO0002.java
 * @brief 계정 코드 service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 4. 21. | First Created
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
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO0002DAO;
import com.encocns.co.dto.CO000201DTO;
import com.encocns.co.service.svo.CO000201IN;
import com.encocns.co.service.svo.CO000201OUT;
import com.encocns.enfra.core.component.ServiceComponent;

/**
 * @brief 계정 코드 Service
 * @details 계정 코드 Service
 * @author : 차상길
 * @date : 2020. 4. 21.
 * @version : 1.0.0
 */
@Service
public class CO0002 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CO0002.class);

	@Autowired
	private CO0002DAO daoCO0002;

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief 계정 코드를 조회한다.
     * @details 계정 코드를 조회한다.
     * @author : 차상길
     * @date : 2020. 4. 21.
     * @version : 1.0.0
     * @param CO000201IN
     * @return CO000201OUT
     */
	public CO000201OUT selectIfrsAcc(CO000201IN inParam) {
		if(LOGGER.isDebugEnabled()) LOGGER.debug("----- selectIfrsAcc -----");

		List<CO000201DTO> arrList = null;

		//Instance OSVO
		CO000201OUT outParam = new CO000201OUT();

		//메인화면에서 실행된 것이니 확인
		if("2".equals(inParam.getScnProcsDvcd())) {
			//조회 겟수
			int iCount = 0;

			//조회된 결과값 갯수 저장
			iCount = daoCO0002.selectIfrsAcc2(inParam);

			//조회 결과가 1건이 아니면 팝업창 호출
			if(iCount == 0 || iCount > 1) {
				outParam.setsIqryRslt("N");
				return outParam;
			}
		}

		//조회
		arrList = daoCO0002.selectIfrsAcc1(inParam);

		outParam.setArrList(arrList);

		return outParam;
	}

}
