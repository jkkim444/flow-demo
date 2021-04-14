/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file IP202001OUT.java
 * @brief LGD 관리 OUT
 * @section Major History
 * <pre>
 *   - 이동겸 | 2020. 09. 01. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ip.service.svo
 * @brief Common SVO Package
 */
package com.encocns.ip.service.svo;

import java.util.List;

import com.encocns.ip.dto.IP202001DTO;

/**
 * @brief LGD 관리 management OUT
 * @details LGD 관리 management OUT
 * @author : 이동겸
 * @date : 2020. 09. 01.
 * @version : 1.0.0
 */
public class IP202001OUT {
    private int totalCount;				/* 총 건수 */
    private int currentPageNo;			/* 페이지번호 */
    private List<IP202001DTO> list;		/* 조회내용 */

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
	public List<IP202001DTO> getList() {
		return list;
	}
	public void setList(List<IP202001DTO> list) {
		this.list = list;
	}

}
