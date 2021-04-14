/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file GenericDTO.java
 * @brief 
 * 간략 설명을 작성한다.
 * @section Major History
 * <pre>
 *   - 홍길동 | 2019. 12. 4. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.enfra.core.component
 * @brief 
 */
package com.encocns.enfra.core.component;

import java.math.BigDecimal;

/**
 * @brief 
 * 간략 설명을 작성한다.
 * @details 
 * <pre>
 * 상세 설명을 작성한다.
 * </pre>
 * @author : 홍길동
 * @date : 2019. 12. 4.
 * @version : 1.0.0
 */
public class GenericDTO {
    
    private String a1;
    private String a2;
    private BigDecimal a3;
    private int a4;
    private float a5;
    private long a6;
    private double a7;
    
    private boolean yn;
    
    
    
    public boolean isYn() {
        return yn;
    }
    public void setYn(boolean yn) {
        this.yn = yn;
    }
    public String getA1() {
        return a1;
    }
    public void setA1(String a1) {
        this.a1 = a1;
    }
    public String getA2() {
        return a2;
    }
    public void setA2(String a2) {
        this.a2 = a2;
    }
    public BigDecimal getA3() {
        return a3;
    }
    public void setA3(BigDecimal a3) {
        this.a3 = a3;
    }
    public int getA4() {
        return a4;
    }
    public void setA4(int a4) {
        this.a4 = a4;
    }
    public float getA5() {
        return a5;
    }
    public void setA5(float a5) {
        this.a5 = a5;
    }
    public long getA6() {
        return a6;
    }
    public void setA6(long a6) {
        this.a6 = a6;
    }
    public double getA7() {
        return a7;
    }
    public void setA7(double a7) {
        this.a7 = a7;
    }

    
}
