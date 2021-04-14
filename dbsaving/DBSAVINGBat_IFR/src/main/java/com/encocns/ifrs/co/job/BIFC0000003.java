/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file BIFC0000003.java
 * @brief
 * \~english Batch template3
 * \~korean Batch template3
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

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.transaction.TransactionStatus;

import com.encocns.enfra.batch.core.item.database.EnfraItemWriter;
import com.encocns.enfra.batch.core.listener.repository.EnfraJobRepository;
import com.encocns.enfra.batch.core.tasklet.EnfraTasklet;
import com.encocns.enfra.batch.exception.EnfraBusinessException;

import com.encocns.ifrs.co.bvo.BIFC000000301IN;

/**
 * @brief
 * \~english Batch template3
 * \~korean Batch template3
 * @details
 * \~english Batch template3
 * \~korean Batch template3
 * @author : CHOI, YOUNG-HWAN
 * @date : 2018. 2. 20.
 * @version : 1.0.0
 */
public class BIFC0000003 extends EnfraTasklet {

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
     * @date : 2018. 3. 14.
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
        
        //Reader, Writer Object declaration
        EnfraItemWriter writerUser = this.getWriter();

        //Parameter Setting
        BIFC000000301IN inUser = new BIFC000000301IN();
        inUser.setBaseDt(jobParameters.getString("baseDt"));

        ////////////////////////////////////////////////////////////////////////////////
        //@Step 2. Business Logic
        ////////////////////////////////////////////////////////////////////////////////
        
        //----------------------------------------------------------------------
        //Example of creating an internal transaction to process commit or rollback
        TransactionStatus txStatus = this.createTransaction();
        
        try {
            writerUser.update("BIFC0000003.updateUser");
            writerUser.update("BIFC0000003.updateMessage");

            this.getTxManager().commit(txStatus);
        } catch (Exception e) {
            this.getTxManager().rollback(txStatus);
            throw new EnfraBusinessException("E000003", "An error occurred while updating user");
        }
        
        //----------------------------------------------------------------------

        return RepeatStatus.FINISHED;
    }
}
