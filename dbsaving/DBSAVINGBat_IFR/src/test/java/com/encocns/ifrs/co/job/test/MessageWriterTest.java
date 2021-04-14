/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file MessageWriterTest.java
 * @brief 
 * \~english Message Writer JUnit Test
 * \~korean Message Writer JUnit Test
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 10. 30. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ifrs.co.job.test
 * @brief Common Job Test Package
 */
package com.encocns.ifrs.co.job.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.encocns.ifrs.co.message.MessageWriter;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "/com/encocns/ifrs/co/base/job-IFC.xml" })

/**
 * @brief 
 * \~english Message Writer JUnit Test
 * \~korean Message Writer JUnit Test
 * @details 
 * <pre>
 * \~english Message Writer JUnit Test
 * \~korean Message Writer JUnit Test
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 10. 30.
 * @version : 1.0.0
 */
public class MessageWriterTest {

    
    /**
     * @brief 
     * \~english Message Writer JUnit Test
     * \~korean Message Writer JUnit Test
     * @details 
     * <pre>
     * \~english Message Writer JUnit Test
     * \~korean Message Writer JUnit Test
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 12. 6.
     * @version : 1.0.0
     * @throws Exception
     */
    @Test
    public void messageWriterTest() throws Exception {
        MessageWriter.main(null);
    }
    
}
