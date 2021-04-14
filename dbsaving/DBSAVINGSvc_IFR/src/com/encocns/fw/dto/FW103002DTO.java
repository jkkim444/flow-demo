/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file FW103001DTO.java
 * @brief Batch Operation Status List Query DTO
 * @section Major History
 * <pre>
 *   - CHA, SANG-GIL | 2019. 7. 22. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.dto
 * @brief Common DTO Package
 */
package com.encocns.fw.dto;

/**
 * @brief Batch Operation Status List Query DTO
 * @details Batch Operation Status List Query DTO
 * @author : CHA, SANG-GIL
 * @date : 2019. 7. 22.
 * @version : 1.0.0
 */
public class FW103002DTO {

	private String optionValue;                      /* selectBox 값 */
	private String optionText;                       /* selectBox 명칭 */

    public String getOptionValue() {
        return optionValue;
    }
    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
    public String getOptionText() {
        return optionText;
    }
    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

}
