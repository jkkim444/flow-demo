/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW204101IN.java
 * @brief 
 * \~english 영어로 간략 설명을 작성한다.
 * \~korean 한글로 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - HONG, GIL-DONG | 2019. 9. 23. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief 
 */
package com.encocns.fw.service.svo;

import java.util.List;

import com.encocns.fw.dto.FW204101DTO;

/**
 * @brief 
 * \~english 영어로 간략 설명을 작성한다.
 * \~korean 한글로 간략 설명을 작성한다.
 * @details 
 * <pre>
 * \~english 영어로 상세 설명을 작성한다.
 * \~korean 한글로 상세 설명을 작성한다.
 * </pre>
 * @author : HONG, GIL-DONG
 * @date : 2019. 9. 23.
 * @version : 1.0.0
 */
public class FW204101OUT {
    
    private List<FW204101DTO> arrList;

    /**
     * @return the arrList
     */
    public List<FW204101DTO> getArrList() {
        return arrList;
    }

    /**
     * @param arrList the arrList to set
     */
    public void setArrList(List<FW204101DTO> arrList) {
        this.arrList = arrList;
    }

}
