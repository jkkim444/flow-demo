/*
 * Copyright ENCOCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ENCOCNS.,LTD. ("Confidential Information").
 */
/**
 * @file CO3010Test.java
 * @brief Common Code 
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 7. 11. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.co.test
 * @brief Common Test Package
 */
package com.encocns.co.test;

import org.junit.Test;

import com.encocns.co.service.svo.CO301001IN;
import com.encocns.co.service.svo.CO301002IN;
import com.encocns.junit.EnfraJUnit;

/**
 * @brief  Common code management service Test
 * @details  Common code management service Test
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 7. 11.
 * @version : 1.0.0
 */
public class CO3010Test extends EnfraJUnit {

    /**
     * @brief Common Code Domain List Test
     * @details Common Code Domain List Test
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 7. 11.
     * @version : 1.0.0
     * @throws Exception
     */
    @Test
    public void selectCodeDomainListTest() throws Exception {
        this.setSvc("CO3010");
        this.setMethod("selectCodeDomainList");
        this.setScrId("CO3010");
        
        CO301001IN inCodeDomain = new CO301001IN();
        
        inCodeDomain.setLclCd("all");
        inCodeDomain.setSysCdYn("all");
        
        this.setParameter(inCodeDomain);
        
        this.test();
    }
    
    /**
     * @brief Common code detail list Test
     * @details Common code detail list Test 
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 7. 15.
     * @version : 1.0.0
     * @throws Exception
     */
    @Test
    public void selectCodeDtlListTest() throws Exception {
        this.setSvc("CO3010");
        this.setMethod("selectCodeDtlList");
        this.setScrId("CO3010");
        
        CO301002IN inCodeDomain = new CO301002IN();
        
        inCodeDomain.setCdDmnId("LCL_CD");
        inCodeDomain.setLclCd("en_US");
        
        this.setParameter(inCodeDomain);
        
        this.test();
    }
    
}
