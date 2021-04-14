/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SIFCG04000601DTO.java
 * @brief Source Generator Table List DTO
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 7. 24. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dto
 * @brief Common DTO Package
 */
package com.encocns.fw.dto;

/**
 * @brief Source Generator Table List DTO
 * @details Source Generator Table List DTO
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 7. 24.
 * @version : 1.0.0
 */
public class FW204101DTO {
    
    private String name;
    private String comments;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
