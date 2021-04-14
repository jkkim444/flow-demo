/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file Masking.java
 * @brief 
 * \~english 영어로 상세 설명을 작성한다.
 * \~korean 한글로 상세 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 9. 9. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.enfra.core.annotation
 * @brief 
 */
package com.encocns.enfra.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @brief 
 * \~english 영어로 상세 설명을 작성한다.
 * \~korean 한글로 상세 설명을 작성한다.
 * @details 
 * <pre>
 * \~english 영어로 상세 설명을 작성한다.
 * \~korean 한글로 상세 설명을 작성한다.
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 9. 9.
 * @version : 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Masking {

    public String policy() default "";
    
}
