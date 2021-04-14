/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO204001DTO.java
 * @brief 부서별 메뉴관리 DTO
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.dto
 * @brief Common DTO Package
 */
package com.encocns.co.dto;

/**
 * @brief 부서별 메뉴관리 DTO
 * @details 부서별 메뉴관리 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO204001DTO {

	private String grpId;                            /* 그룹ID */
	private String grpNm;                            /* 그룹명 */
	private int childrenCnt;                      	 /* 하위그룹갯수 */

    public String getGrpId() {
        return grpId;
    }
    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }
    public String getGrpNm() {
        return grpNm;
    }
    public void setGrpNm(String grpNm) {
        this.grpNm = grpNm;
    }
    public int getChildrenCnt() {
        return childrenCnt;
    }
    public void setChildrenCnt(int childrenCnt) {
        this.childrenCnt = childrenCnt;
    }

}
