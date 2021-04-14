/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW207001DTO.java
 * @brief Create Annotation Query DTO
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 6. 20. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dto
 * @brief Common DTO Package
 */
package com.encocns.fw.dto;

/**
 * @brief column name List Query DTO
 * @details column name List Query DTO
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 11.
 * @version : 1.0.0
 */
public class FW207001DTO {

	private String code;    
	private String name;
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
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
}
