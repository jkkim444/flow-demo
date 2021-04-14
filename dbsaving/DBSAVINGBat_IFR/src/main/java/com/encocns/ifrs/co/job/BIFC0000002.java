/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file BIFC0000002.java
 * @brief
 * \~english Batch template2
 * \~korean Batch template2
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2018. 2. 20. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ifrs.co.job
 * @brief Template Job Package
 */
package com.encocns.ifrs.co.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.repeat.RepeatStatus;

import com.encocns.enfra.batch.core.item.database.EnfraItemReader;
import com.encocns.enfra.batch.core.item.database.EnfraItemWriter;
import com.encocns.enfra.batch.core.listener.repository.EnfraJobRepository;
import com.encocns.enfra.batch.core.tasklet.EnfraTasklet;

import com.encocns.ifrs.co.bvo.BIFC000000201IN;
import com.encocns.ifrs.co.dto.BIFC000000101DTO;

/**
 * @brief
 * \~english Batch template2
 * \~korean Batch template2
 * @details
 * <pre>
 * Examples of simultaneous parallelization of batches.
 * See BIFC0000002.xml (JOB XML).
 * For example, set 1, 2 and 3 using the stepParameter to process the row of the table by quarter with the corresponding key.
 * Caution: The number of flow steps cannot exceed maxPoolSize in common.properties, so be careful.
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2018. 2. 20.
 * @version : 1.0.0
 */
public class BIFC0000002 extends EnfraTasklet {

    private static final Logger LOGGER = LoggerFactory.getLogger(BIFC0000002.class);

    /**
     * @brief
     * \~english batch execute process
     * \~korean batch execute process
     * @details
     * <pre>
     * \~english batch execute process
     * \~korean batch execute process
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2018. 3. 13.
     * @param jobRepository
     * @return RepeatStatus
     * @throws Exception
     */
    @Override
    public RepeatStatus execute(EnfraJobRepository jobRepository) throws Exception {
        ////////////////////////////////////////////////////////////////////////////////
        //@Step 1. Base Variables and Default Settings
        ////////////////////////////////////////////////////////////////////////////////
        
        JobParameters jobParameters = jobRepository.getJobParameter();
        
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Setting the base variable and default values");
        }
 
        //Reader, Writer Object declaration
        EnfraItemReader<?> readerUser = this.getReader();
        EnfraItemWriter writerUser = this.getWriter();
 
        //Parameter Setting
        BIFC000000201IN inUser = new BIFC000000201IN();
        inUser.setBaseDt(jobParameters.getString("baseDt"));
 
        ////////////////////////////////////////////////////////////////////////////////
        // @Step 2. Business Logic
        ////////////////////////////////////////////////////////////////////////////////
 
        //Declares the Row Mapping class as a result of the query, declares the query ID, sets the parameters for the query, and performs the query.
        readerUser.setQueryId("BIFC0000002.selectUserList");
        readerUser.setParameter(inUser);
        readerUser.loadSQL();
 
        //Start of transaction.
        this.beginTransaction();
        
        BIFC000000101DTO dtoUser = new BIFC000000101DTO();
 
        //Commit Interval Setting (Default : BatchConsts.DEFAULT_COMMIT_INTERVAL --> 10000);
        this.setCommitInterval(1000);
 
        while ((dtoUser = (BIFC000000101DTO) readerUser.read()) != null) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(jobRepository.getStepParameter().get("partition"));
                LOGGER.debug(dtoUser.toString());
            }
            
            writerUser.update("BIFC0000002.updateUser");
            writerUser.update("BIFC0000002.updateMessage");
            
            //Commit processing
            this.checkCommit();
        }

        return RepeatStatus.FINISHED;
    }
}
