/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file SIFCG04000602DTO.java
 * @brief Source Generator Column List DTO
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
 * @brief Source Generator Column List DTO
 * @details Source Generator Column List DTO
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 7. 24.
 * @version : 1.0.0
 */
public class FW204102DTO {

    private String name;
    private String comments;
    private String type;
    private String typeSize;
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
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return the typeSize
     */
    public String getTypeSize() {
        return typeSize;
    }
    /**
     * @param typeSize the typeSize to set
     */
    public void setTypeSize(String typeSize) {
        this.typeSize = typeSize;
    }
    
    
}
