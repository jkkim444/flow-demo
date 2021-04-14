/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO204002DTO.java
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

import java.util.HashMap;

/**
 * @brief 부서별 메뉴관리 DTO
 * @details 부서별 메뉴관리 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO204002DTO {

	private String tp;
	private String grpId;                         /* 그룹ID */
	private String grpNm;                         /* 그룹명 */
	private String hgrkGrpId;                     /* 그룹ID */
	private String id;                            /* ID */
	private String parent;                        /* 상위 */
	private String text;                          /* TEXT */
	private String empno;                         /* 사번 */
	private String regYn;                         /* 등록여부 */
	private String userId;                        /* 사용자ID */
	private String bizLclsCd;                     /* 업무대분류코드 */
	private int childrenCnt;                      /* 하위 갯수 */

    private HashMap<String, Boolean> state;
    private HashMap<String, String> data;

    public String getTp() {
        return tp;
    }
    public void setTp(String tp) {
        this.tp = tp;
    }
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
    public String getHgrkGrpId() {
        return hgrkGrpId;
    }
    public void setHgrkGrpId(String hgrkGrpId) {
        this.hgrkGrpId = hgrkGrpId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getRegYn() {
        return regYn;
    }
    public void setRegYn(String regYn) {
        this.regYn = regYn;
    }
    public HashMap<String, Boolean> getState() {
        return state;
    }
    public void setState(HashMap<String, Boolean> state) {
        this.state = state;
    }
    public HashMap<String, String> getData() {
        return data;
    }
    public void setData(HashMap<String, String> data) {
        this.data = data;
    }
    public String getEmpno() {
        return empno;
    }
    public void setEmpno(String empno) {
        this.empno = empno;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getBizLclsCd() {
        return bizLclsCd;
    }
    public void setBizLclsCd(String bizLclsCd) {
        this.bizLclsCd = bizLclsCd;
    }
    public int getChildrenCnt() {
        return childrenCnt;
    }
    public void setChildrenCnt(int childrenCnt) {
        this.childrenCnt = childrenCnt;
    }

}
