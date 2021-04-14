/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW2020.java
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.fw.service.svo.FW202001IN;
import com.encocns.fw.service.svo.FW202001OUT;

/**
 * @brief Service Management Service
 * @details Service Management Service
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 10. 31.
 * @version : 1.0.0
 */
@Service
public class FW2020 {

	private static final Logger LOGGER = LoggerFactory.getLogger(FW2020.class);

	@Autowired
	private ServiceComponent serviceComponent;

    /**
     * @brief Service List inquiry
     * @details Service List inquiry
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 10. 31.
     * @version : 1.0.0
     * @param inSvo
     * @return ArrayList List of translations
     */
	public FW202001OUT insertAttachFile( FW202001IN inSvo ) throws EnfraBusinessException, Exception
	{
	    FW202001OUT out = new FW202001OUT();
	    
        out.setCompId(inSvo.getCompId());
        out.setUploadList(serviceComponent.getFileComponent().getAttachFileList("FW2020", inSvo.getCompId()) );

		return out;
	}

}
