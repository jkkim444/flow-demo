/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO000102OUT.java
 * @brief 로그인 OUT
 * @section Major History
 * <pre>
 *   - 차상길 | 2020. 11. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.service.svo
 * @brief Common SVO Package
 */
package com.encocns.co.service.svo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * @brief 로그인 OUT
 * @details 로그인 OUT
 * @author : 차상길
 * @date : 2020. 11. 26.
 * @version : 1.0.0
 */
public class CO000102OUT {

    private Vector role;

    private ArrayList<HashMap<String,Object>> epInfoList;
    private ArrayList<HashMap<String,Object>> assignList;
    private ArrayList<HashMap<String,Object>> idlDeptList;

    public Vector getRole() {
        return role;
    }

    public void setRole(Vector role) {
        this.role = role;
    }

    public ArrayList<HashMap<String, Object>> getEpInfoList() {
        return epInfoList;
    }

    public void setEpInfoList(ArrayList<HashMap<String, Object>> epInfoList) {
        this.epInfoList = epInfoList;
    }


    public ArrayList<HashMap<String, Object>> getAssignList() {
        return assignList;
    }

    public void setAssignList(ArrayList<HashMap<String, Object>> assignList) {
        this.assignList = assignList;
    }


    public ArrayList<HashMap<String, Object>> getIdlDeptList() {
        return idlDeptList;
    }

    public void setIdlDeptList(ArrayList<HashMap<String, Object>> idlDeptList) {
        this.idlDeptList = idlDeptList;
    }



}
