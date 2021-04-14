/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IA515001OUT.java
 * @brief 수익용 부동산 보유 현황 management OUT
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

import com.encocns.ia.dto.IA515001DTO;

/**
 * @brief 수익용 부동산 보유 현황 management OUT
 * @details 수익용 부동산 보유 현황 management OUT
 * @author : 이동겸
 * @date : 2020. 8. 10.
 * @version : 1.0.0
 */
public class IA521001OUT {

    private int totalCount;				/* 총 건수 */
    private int currentPageNo;			/* 페이지 번호 */
    private List<IA515001DTO> arrList;	/* 조회 내용 */

    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getCurrentPageNo() {
        return currentPageNo;
    }
    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }
    public List<IA515001DTO> getArrList() {
        return arrList;
    }
    public void setArrList(List<IA515001DTO> arrList) {
        this.arrList = arrList;
    }
}
