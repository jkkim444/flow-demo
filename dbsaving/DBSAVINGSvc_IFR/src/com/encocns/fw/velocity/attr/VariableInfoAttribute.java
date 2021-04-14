/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file VariableInfoAttribute.java
 * @brief 
 * \~english 영어로 간략 설명을 작성한다.
 * \~korean 한글로 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - HONG, GIL-DONG | 2019. 9. 26. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.fw.velocity.attr
 * @brief 
 */
package com.encocns.fw.velocity.attr;

/**
 * @brief 
 * \~english 영어로 간략 설명을 작성한다.
 * \~korean 한글로 간략 설명을 작성한다.
 * @details 
 * <pre>
 * \~english 영어로 상세 설명을 작성한다.
 * \~korean 한글로 상세 설명을 작성한다.
 * </pre>
 * @author : HONG, GIL-DONG
 * @date : 2019. 9. 26.
 * @version : 1.0.0
 */
public class VariableInfoAttribute {

    private String type;
    private String name;
    private String uppername;
    private String comment;
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUppername() {
        return uppername;
    }
    public void setUppername(String uppername) {
        this.uppername = uppername;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
