/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA602001OUT.java
 * @brief IFRS 계정코드 management OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 8. 10. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ia.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ia.service.svo;

import java.util.List;

import com.encocns.ia.dto.IA602001DTO;

/**
 * @brief IFRS 계정코드 management OUT
 * @details IFRS 계정코드 management OUT
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA602001OUT {
    private List<IA602001DTO> arrList;		/* 조회 내용 */

    public List<IA602001DTO> getArrList() {
        return arrList;
    }
    public void setArrList(List<IA602001DTO> arrList) {
        this.arrList = arrList;
    }
}
