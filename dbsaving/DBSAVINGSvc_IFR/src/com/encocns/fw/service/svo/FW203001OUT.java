/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW203001OUT.java
 * @brief 
 * \~english 영어로 간략 설명을 작성한다.
 * \~korean 한글로 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - HONG, GIL-DONG | 2019. 9. 20. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief 
 */
package com.encocns.fw.service.svo;

import java.util.List;

import com.encocns.fw.dto.FW203001DTO;

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
 * @date : 2019. 9. 20.
 * @version : 1.0.0
 */
public class FW203001OUT {
    
    
    private int totalCount;
    
    private int currentPageNo;
    
    private List<FW203001DTO> arrList;
    
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
    public List<FW203001DTO> getArrList() {
        return arrList;
    }
    public void setArrList(List<FW203001DTO> arrList) {
        this.arrList = arrList;
    }
    
}
