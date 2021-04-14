/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW1010.java
 * @brief 서비스 관리 Service
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service
 * @brief FW Service Package
 */
package com.encocns.fw.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.MaxLengthRule;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;
import com.encocns.fw.dao.FW1010DAO;
import com.encocns.fw.dto.FW101001DTO;
import com.encocns.fw.service.svo.FW101001IN;
import com.encocns.fw.service.svo.FW101001OUT;
import com.encocns.fw.service.svo.FW101002IN;
import com.encocns.fw.service.svo.FW101002OUT;
import com.encocns.fw.service.svo.FW101003IN;
import com.encocns.fw.service.svo.FW101003OUT;

/**
 * @brief 서비스 관리 Service
 * @details 서비스 관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class FW1010 {

    private static final Logger LOGGER = LoggerFactory.getLogger(FW1010.class);

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
    private FW1010DAO daoFW1010;

    @Resource(name = "txManagerIFRS")
    protected DataSourceTransactionManager txManagerIFRS;

    /**
     * @brief 서비스 목록 조회
     * @details 서비스 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW101001IN
     * @return FW101001OUT
     */
    public FW101001OUT selectServiceList( FW101001IN inParam ) throws EnfraBusinessException
    {
        if(LOGGER.isDebugEnabled()) LOGGER.debug(inParam.getBizLclsCd());

        List<FW101001DTO> arrList = daoFW1010.selectServiceList(inParam);

        //Instance OSVO
        FW101001OUT outParam = new FW101001OUT();
        outParam.setArrList(arrList);

        return outParam;
    }

    /**
     * @brief 서비스 등록 및 수정
     * @details 서비스 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW101002IN
     * @return FW101002OUT
     */
    public FW101002OUT mergeService( FW101002IN inParam )
    {
        //Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("bizLclsCd", new RequiredRule(true));
        ruleSet.addRule("svcId", new RequiredRule(true));
        ruleSet.addRule("mthId", new RequiredRule(true));
        ruleSet.addRule("mthNm", new RequiredRule(), new MaxLengthRule(200));
        ruleSet.addRule("svcPathCntn", new RequiredRule(), new MaxLengthRule(200));
        ruleSet.addRule("isvoPathCntn", new RequiredRule(), new MaxLengthRule(200));
        ruleSet.addRule("osvoPathCntn", new RequiredRule(), new MaxLengthRule(200));

        Validator.validation(inParam, ruleSet);

        //Instance OSVO
        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        int iResult = daoFW1010.mergeService(inParam);

        FW101002OUT outParam = new FW101002OUT();
        outParam.setiResult(iResult);

        return outParam;
    }

    /**
     * @brief 서비스 삭제
     * @details 서비스 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param FW101003IN
     * @return FW101003OUT
     */
    public FW101003OUT deleteService( FW101003IN inParam )
    {
        int iResult = daoFW1010.deleteService(inParam);

        //Instance OSVO
        FW101003OUT outParam = new FW101003OUT();
        outParam.setiResult(iResult);

        return outParam;
    }
}
