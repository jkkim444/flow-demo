/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO2010.java
 * @brief 메뉴 관리 Service
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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.encocns.co.dao.CO2010DAO;
import com.encocns.co.dto.CO201001DTO;
import com.encocns.co.dto.CO201002DTO;
import com.encocns.co.service.svo.CO201001IN;
import com.encocns.co.service.svo.CO201001OUT;
import com.encocns.co.service.svo.CO201002IN;
import com.encocns.co.service.svo.CO201002OUT;
import com.encocns.co.service.svo.CO201003IN;
import com.encocns.co.service.svo.CO201003OUT;
import com.encocns.co.service.svo.CO201004IN;
import com.encocns.co.service.svo.CO201004OUT;
import com.encocns.enfra.core.component.ServiceComponent;
import com.encocns.enfra.exception.EnfraBusinessException;
import com.encocns.enfra.util.StringUtils;
import com.encocns.enfra.validator.Validator;
import com.encocns.enfra.validator.rule.MaxLengthRule;
import com.encocns.enfra.validator.rule.RequiredRule;
import com.encocns.enfra.validator.ruleset.RuleSet;

/**
 * @brief 메뉴 관리 Service
 * @details 메뉴 관리 Service
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
@Service
public class CO2010 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CO2010.class);

    @Autowired
    private ServiceComponent serviceComponent;

    @Autowired
    private CO2010DAO daoCO2010;

    @Resource(name = "txManagerIFRS")
    protected DataSourceTransactionManager txManagerIFRS;

    /**
     * @brief 상위 메뉴 조회
     * @details 상위 메뉴 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param
     * @return List<CO201002DTO>
     */
    public List<CO201002DTO> selectTopMenuList() {
        if (LOGGER.isDebugEnabled()) LOGGER.debug("----- selectTopMenuList -----");

        CO201001IN inMenuList = new CO201001IN();

        inMenuList.setUsrId(serviceComponent.getSessionVO().getUserId());
        inMenuList.setEmpno(serviceComponent.getSessionVO().getEmpno());

        return daoCO2010.selectTopMenuList(inMenuList);
    }

    /**
     * @brief 메뉴 정보 조회
     * @details 메뉴 정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201004IN
     * @return CO201004OUT
     */
    public CO201004OUT selectMenuList(CO201004IN inParam) {
        if (LOGGER.isDebugEnabled()) LOGGER.debug("----- selectMenuList -----");
        CO201004OUT outParam = new CO201004OUT();

        inParam.setLclCd(LocaleContextHolder.getLocale().toString());

        outParam.setOutMenuList(daoCO2010.selectMenuList(inParam));

        return outParam;
    }

    /**
     * @brief 메뉴 목록 조회
     * @details 메뉴 목록 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return CO201001OUT
     */
    public CO201001OUT selectMenu(CO201001IN inParam) {
        CO201001OUT outParam = new CO201001OUT();

        outParam.setArrList((ArrayList<CO201001DTO>)daoCO2010.selectMenu(inParam));

        return outParam;
    }

    /**
     * @brief 메뉴 등록 및 수정
     * @details 메뉴 등록 및 수정
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201002IN
     * @return CO201002OUT
     */
    public CO201002OUT mergeMenu(CO201002IN inParam) throws EnfraBusinessException {
        //Parameter validation
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule("bizLclsCd", new RequiredRule(true));
        ruleSet.addRule("menuId", new RequiredRule(true));
        ruleSet.addRule("menuNm", new RequiredRule(), new MaxLengthRule(60));
        ruleSet.addRule("menuSeq", new RequiredRule());
        ruleSet.addRule("scrMrkYn", new RequiredRule(true));

        Validator.validation(inParam, ruleSet);

        CO201001DTO dtoMer = new CO201001DTO();
        if (!StringUtils.isEmpty(inParam.getHgrkMenuId())) {
            dtoMer.setBizLclsCd(inParam.getBizLclsCd());
            dtoMer.setMenuId(inParam.getHgrkMenuId());

            int cnt = daoCO2010.selectMenuCnt(dtoMer);

            if (cnt == 0) {
                throw new EnfraBusinessException("E000018"); //Unregistered upper menu ID.
            }
            dtoMer = daoCO2010.selectMenuLevel(inParam);

            if ("3".equals(String.valueOf(dtoMer.getMenuLev()))) {
                throw new EnfraBusinessException("E000019"); //Only 1 to 2 level menus are allowed for the upper menu specification.
            }
        }

        inParam.setUsrId(serviceComponent.getSessionVO().getUserId());

        // 처리 건수 초기화
        int iResult = 0;

        // insert
        if("I".equals(inParam.getJobDivCd())) {
        	try {
            	// 등록 처리
        		iResult = daoCO2010.insertMenu(inParam);
        	}
        	catch (DataIntegrityViolationException e) { // 중복 데이터 insert 오류
        		// 중복 코드 에러 메시지 출력
                throw new EnfraBusinessException("E000025"); // 중복되는 항목이 존재합니다.
			}
        }
        // update
        else if("U".equals(inParam.getJobDivCd())) {
        	// 업데이트 처리
    		iResult = daoCO2010.updateMenu(inParam);
        }
        else {
    		// 오류 메시지 출력
            throw new EnfraBusinessException("E000026"); // 등록 및 수정만 가능합니다.
        }

        CO201002OUT outParam = new CO201002OUT();
        outParam.setiResult(iResult);

        return outParam;
    }

    /**
     * @brief 메뉴 삭제
     * @details 메뉴 삭제
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201003IN
     * @return CO201003OUT
     */
    public CO201003OUT deleteMenu(CO201003IN inParam) {
        CO201003OUT outParam = new CO201003OUT();
        int iResult = daoCO2010.deleteMenu(inParam);
        daoCO2010.deleteMpgMenu(inParam);
        outParam.setiResult(iResult);
        return outParam;
    }

    /**
     * @brief 메뉴 목록 관리 조회
     * @details 메뉴 목록 관리 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return ArrayList<CO201001DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Cacheable(value = "menuScrCache", key = "{#inSearchText.searchText, #inSearchText.lclCd}")
    public ArrayList<CO201001DTO> selectMenuScrList(CO201001IN inSearchText) {
        ArrayList<CO201001DTO> arrMenuScrList = (ArrayList) daoCO2010.selectMenuScrList(inSearchText);
        return arrMenuScrList;
    }

    /**
     * @brief 메뉴 관리 조회
     * @details 메뉴 관리 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return List<CO201001DTO>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Cacheable(value = "menuScrCache", key = "{#inSearchText.biz_lcls_cd, #inSearchText.search_text, #inSearchText.arrScrIdList}")
    public List<CO201001DTO> selectMenuScrListEAM(CO201001IN inSearchText) {
        List<CO201001DTO> list = (ArrayList) daoCO2010.selectMenuScrListEAM(inSearchText);
        return list;
    }

    /**
     * @brief 메뉴 화면정보 조회
     * @details 메뉴 화면정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return CO201001DTO
     */
    @Cacheable(value = "menuScrCache", key = "{#inSearchText.menuId}")
    public CO201001DTO selectMenuScrInfo(CO201001IN inSearchText) {
        inSearchText.setLclCd(LocaleContextHolder.getLocale().toString());

        CO201001DTO dtoMenuScrInfo = daoCO2010.selectMenuScrInfo(inSearchText);
        return dtoMenuScrInfo;
    }

    /**
     * @brief 메뉴 화면정보 조회
     * @details 메뉴 화면정보 조회
     * @author : 차상길
     * @date : 2020. 11. 26.
     * @version : 1.0.0
     * @param CO201001IN
     * @return CO201001DTO
     */
    @Cacheable(value = "scrCache", key = "{#inScreenInfo.scrId}")
    public CO201001DTO selectScreenInfo(CO201001IN inScreenInfo) {
        CO201001DTO dtoMenuScrInfo = daoCO2010.selectScreenInfo(inScreenInfo);
        return dtoMenuScrInfo;
    }
}
