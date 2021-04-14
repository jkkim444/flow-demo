/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2040.java
 * @brief 부서 메뉴 관리 Service
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

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO2040DAO;
import com.encocns.co.dto.CO204001DTO;
import com.encocns.co.dto.CO204002DTO;
import com.encocns.co.service.svo.CO204001IN;
import com.encocns.co.service.svo.CO204001OUT;
import com.encocns.co.service.svo.CO204002IN;
import com.encocns.co.service.svo.CO204002OUT;
import com.encocns.co.service.svo.CO204003IN;
import com.encocns.co.service.svo.CO204003OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;

/**
 * @brief 부서 메뉴 관리 Service
 * @details 부서 메뉴 관리 Service
 * @author : 차상길
 * @date : 2019. 7 15.
 * @version : 1.0.0
 */
@Service
public class CO2040 {

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private CO2040DAO daoCO2040;

    /**
     * @brief 부서 조회
     * @details 부서 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO204001IN
     * @return CO204001OUT
     */
	public CO204001OUT selectGroupList( CO204001IN inParam ) throws EnfraBusinessException
	{
		List<CO204001DTO> arrList = daoCO2040.selectGroupList(inParam);

		//Instance OSVO
		CO204001OUT outParam = new CO204001OUT();
		outParam.setArrList(arrList);

		return outParam;
	}

    /**
     * @brief 부서별 메뉴 조회
     * @details 부서별 메뉴 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO204002IN
     * @return CO204002OUT
     */
    public CO204002OUT selectGroupMenuList( CO204002IN inParam ) throws EnfraBusinessException
    {
        List<CO204002DTO> arrList = daoCO2040.selectGroupMenuList(inParam);

        HashMap<String, Boolean> state;
        HashMap<String, String> data;

        for( CO204002DTO authMenu : arrList ) {
            state = new HashMap<String, Boolean>();
            data = new HashMap<String, String>();

            data.put("bizLclsCd", authMenu.getBizLclsCd());

            if( authMenu.getChildrenCnt()==0 && "Y".equals(authMenu.getRegYn()) ) {
                state.put("opened", true);
                state.put("selected", true);

            }else {
                state.put("opened", false);
                state.put("selected", false);
            }

            authMenu.setData(data);
            authMenu.setState(state);
        }

        //Instance OSVO
        CO204002OUT outParam = new CO204002OUT();
        outParam.setArrList(arrList);

        return outParam;
    }


    /**
     * @brief 부서메뉴메뉴 등록 및 수정
     * @details 부서메뉴메뉴 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO204003IN
     * @return CO204003OUT
     */
    public CO204003OUT mergeGroupMenu( CO204003IN inParam ) throws EnfraBusinessException
    {
        int iResult = 0;

        // delete GorupMenu
        iResult = daoCO2040.deleteGroupMenu(inParam);

        // insert GroupMenu
        if( inParam.getArrList()!=null && inParam.getArrList().size()>0 ) {
            for(CO204002DTO dtoGroupMenu : inParam.getArrList()){
                dtoGroupMenu.setGrpId(inParam.getGrpId());
                dtoGroupMenu.setBizLclsCd(dtoGroupMenu.getData().get("bizLclsCd"));
                dtoGroupMenu.setUserId(serviceComponent.getSessionVO().getUserId());
                iResult += daoCO2040.insertGroupMenu(dtoGroupMenu);
            }
        }

        //Instance OSVO
        CO204003OUT outParam = new CO204003OUT();
        outParam.setGrpId(inParam.getGrpId());
        outParam.setiResult(iResult);

        return outParam;
    }

}
