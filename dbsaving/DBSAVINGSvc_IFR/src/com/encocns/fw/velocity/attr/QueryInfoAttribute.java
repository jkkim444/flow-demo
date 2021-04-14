/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file QueryInfoAttribute.java
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
public class QueryInfoAttribute {
    
    private String pkg;
    private String id;
    private ClassInfoAttribute dto;
    private ClassInfoAttribute inSvo;
    
    public String getPkg() {
        return pkg;
    }
    public void setPkg(String pkg) {
        this.pkg = pkg;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ClassInfoAttribute getDto() {
        return dto;
    }
    public void setDto(ClassInfoAttribute dto) {
        this.dto = dto;
    }
	public ClassInfoAttribute getInSvo() {
		return inSvo;
	}
	public void setInSvo(ClassInfoAttribute inSvo) {
		this.inSvo = inSvo;
	}
    

}
