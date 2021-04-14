/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO103001DTO.java
 * @brief 부서 조회 DTO
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
import java.util.Map;

/**
 * @brief 부서 조회 DTO
 * @details 부서 조회 DTO
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000301DTO {

	private String tp;
	private String parent;                        /* 상위 */
	private String id;                            /* ID */
	private String text;                          /* TEXT */
	private String regYn;                         /* 등록여부 */
	private String deptNm;                        /* 부서코드 */
	private String deptCd;                        /* 부서코드 */
	private String cd;                            /* 코드 */
	private String nm;                            /* 명 */

    private HashMap<String, Boolean> state;
    private HashMap<String, String> data;

    public String getTp() {
        return tp;
    }
    public void setTp(String tp) {
        this.tp = tp;
    }
    public String getParent() {
        return parent;
    }
    public void setParent(String parent) {
        this.parent = parent;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public Map<String, Boolean> getState() {
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
    public String getDeptNm() {
        return deptNm;
    }
    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }
    public String getDeptCd() {
        return deptCd;
    }
    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }
    public String getCd() {
        return cd;
    }
    public void setCd(String cd) {
        this.cd = cd;
    }
    public String getNm() {
        return nm;
    }
    public void setNm(String nm) {
        this.nm = nm;
    }


}
