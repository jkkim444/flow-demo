/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW202001OUT.java
 * @brief Service Management OUT
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 10. 31. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.service.svo
 * @brief Common SVO Package
 */
package com.encocns.fw.service.svo;

import java.util.ArrayList;

import com.encocns.enfra.core.component.vo.FileVO;

/**
 * @brief Service Management OUT
 * @details Service Management OUT
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 10. 31.
 * @version : 1.0.0
 */
public class FW202001OUT {
    
    private String compId;
    private ArrayList<FileVO> uploadList;

    /**
     * @return the compId
     */
    public String getCompId() {
        return compId;
    }

    /**
     * @param compId the compId to set
     */
    public void setCompId(String compId) {
        this.compId = compId;
    }

    /**
     * @return the uploadList
     */
    public ArrayList<FileVO> getUploadList() {
        return uploadList;
    }

    /**
     * @param uploadList the uploadList to set
     */
    public void setUploadList(ArrayList<FileVO> uploadList) {
        this.uploadList = uploadList;
    }

}
