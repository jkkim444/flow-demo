/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2050.java
 * @brief 그룹사용자관리 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service
 * @brief Common Service Package
 */
package com.encocns.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO2050DAO;
import com.encocns.co.dto.CO205001DTO;
import com.encocns.co.service.svo.CO205001IN;
import com.encocns.co.service.svo.CO205001OUT;
import com.encocns.co.service.svo.CO205002IN;
import com.encocns.co.service.svo.CO205002OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;

/**
 * @brief 그룹사용자관리 Service
 * @details 그룹사용자관리
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class CO2050 {

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private CO2050DAO daoCO2050;

    /**
     * @brief 그룹 조회
     * @details 그룹 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO205001IN
     * @return CO205001OUT
     */
	public CO205001OUT selectGroupUserList( CO205001IN inParam ) throws EnfraBusinessException
	{
		List<CO205001DTO> arrList = daoCO2050.selectGroupUserList(inParam);

		//Instance OSVO
		CO205001OUT outParam = new CO205001OUT();
		outParam.setArrList(arrList);

		return outParam;
	}


    /**
     * @brief 그룹사용자 등록
     * @details 그룹사용자 등록
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO205002IN
     * @return CO205002OUT
     */
    public CO205002OUT mergeGroupUser( CO205002IN inParam ) throws EnfraBusinessException
    {
        int iResult = 0;

        // delete GorupUser
        iResult = daoCO2050.deleteGroupUser(inParam);

        // insert GroupUser
        if( inParam.getArrList()!=null && inParam.getArrList().size()>0 ) {
            for(CO205001DTO dtoGroupUser : inParam.getArrList()){
                dtoGroupUser.setGrpId(inParam.getGrpId());
                dtoGroupUser.setUserId(serviceComponent.getSessionVO().getUserId());
                iResult += daoCO2050.insertGroupUser(dtoGroupUser);
            }
        }

        //Instance OSVO
        CO205002OUT outParam = new CO205002OUT();
        outParam.setGrpId(inParam.getGrpId());
        outParam.setiResult(iResult);

        return outParam;
    }

}
