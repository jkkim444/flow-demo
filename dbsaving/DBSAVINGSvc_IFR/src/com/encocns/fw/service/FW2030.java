/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CTP5002.java
 * @brief Service Management Service
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 10. 31. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service
 * @brief Common Service Package
 */
package com.encocns.fw.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.fw.dao.FW2030DAO;
import com.encocns.fw.dto.FW203001DTO;
import com.encocns.fw.service.svo.FW203001IN;
import com.encocns.fw.service.svo.FW203001OUT;
import com.encocns.fw.service.svo.FW203002IN;
import com.encocns.fw.service.svo.FW203002OUT;

/**
 * @brief Service Management Service
 * @details Service Management Service
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 10. 31.
 * @version : 1.0.0
 */
@Service
public class FW2030 {

	private static final Logger LOGGER = LoggerFactory.getLogger(FW2030.class);

	@Autowired
	private ServiceComponent serviceComponent;

	@Autowired
	private FW2030DAO dao;

    /**
     * @brief Service List inquiry
     * @details Service List inquiry
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 31.
     * @version : 1.0.0
     * @param inSvo
     * @return ArrayList List of translations
     */
	public FW203001OUT selectGridPage( FW203001IN inSvo ) throws EnfraBusinessException, Exception
	{
	    FW203001OUT out = new FW203001OUT();

	    int totalCount = dao.selectTotalCount(inSvo);


	    List<FW203001DTO> arrList = null;

	    if( inSvo.getSelectPage()==-1 ) {
	    	arrList =  dao.selectList(inSvo);
	    }
	    else {
	    	arrList =  dao.selectPaging(inSvo);
	    }

	    out.setCurrentPageNo(inSvo.getSelectPage());
	    out.setTotalCount(totalCount);
	    out.setArrList(arrList);

		return out;
	}

	public FW203002OUT uploadGrid( FW203002IN inSvo ) throws EnfraBusinessException, Exception
	{
	    FW203002OUT out = new FW203002OUT();

	    //초기화
	    dao.deleteTemplate();

	    List<FW203001DTO> arrList = inSvo.getArrList();

	    int i=0;
	    for( FW203001DTO row : arrList ) {
	    	if( i%100==0 ) dao.flush();
	    	dao.insertTemplate(row);
	    	i++;

	    	if( i==559 ) Thread.sleep(5000);
	    }



	    dao.flush();

		return out;
	}


}
