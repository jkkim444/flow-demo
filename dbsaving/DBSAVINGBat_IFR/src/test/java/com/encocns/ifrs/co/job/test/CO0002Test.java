/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file CO0002Test.java
 * @brief
 * \~english Batch template test
 * \~korean Batch template test
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 11. 29. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ifrs.co.job.test
 * @brief Common Job Test Package
 */
package com.encocns.ifrs.co.job.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.encocns.enfra.batch.core.launch.BatchRunner;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "/com/encocns/ifrs/co/base/job-CO.xml" })

/**
 * @brief
 * \~english Batch template test
 * \~korean Batch template test
 * @details
 * <pre>
 * \~english Batch template test
 * \~korean Batch template test
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 11. 29.
 * @version : 1.0.0
 */
public class CO0002Test {

    @Autowired
    @Qualifier("batchRunner")
    private BatchRunner batchRunner;

    /**
     * @brief Batch template test
     * @details Batch template test
     * @author : CHOI, YOUNG-HWAN
     * @date : 2018. 3. 13.
     * @throws Exception
     */
    @Test
    public void CO0002Test() throws Exception {
        String jobName = "CO0002";

        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addLong("timestamp", new Date().getTime());

        // input parameter
        jobParametersBuilder.addString("col1", "2");

        String jobParameters = batchRunner.convertJobParametersToString(jobParametersBuilder.toJobParameters());

        long executionId = batchRunner.start(jobName, jobParameters);

        assertEquals(BatchStatus.COMPLETED, batchRunner.getJobExecution(executionId).getStatus());
    }

}
