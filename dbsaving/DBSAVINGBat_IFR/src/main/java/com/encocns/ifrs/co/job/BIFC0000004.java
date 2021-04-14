/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file BIFC0000004.java
 * @brief
 * \~english Batch template4
 * \~korean Batch template4
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

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.repeat.RepeatStatus;

import com.encocns.enfra.batch.core.item.database.EnfraItemReader;
import com.encocns.enfra.batch.core.item.database.EnfraItemWriter;
import com.encocns.enfra.batch.core.listener.repository.EnfraJobRepository;
import com.encocns.enfra.batch.core.tasklet.EnfraTasklet;

import com.encocns.ifrs.co.bvo.BIFC000000401IN;
import com.encocns.ifrs.co.dto.BIFC000000101DTO;

/**
 * @brief
 * \~english Batch template4
 * \~korean Batch template4
 * @details
 * <pre>
 * Compare the execution result processing speed of Writer's ExecutorType.
 *
 * ExecutorType.SIMPLE: This type of implementer does nothing. Create a new PreparatedStatement for each syntax run.
 * ExecutorType.BATCH: This ExecutorType.BATCH: This Executor will batch all update syntax and, if necessary, indicate boundaries if a select is executed in the middle. This process is to make the behavior more understandable.
 * For BATCH TYPE, there is a method of flushing (executing) the layout modification syntax stored in the JDBC Driver class at some point. This method is available if ExecutorType is set to ExecutorType.BATCH.
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2018. 2. 20.
 * @version : 1.0.0
 */
public class BIFC0000004 extends EnfraTasklet {

    private static final Logger LOGGER = LoggerFactory.getLogger(BIFC0000004.class);

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
    @SuppressWarnings({ "unchecked", "rawtypes" })
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
        //※ ExecutorType : SIMPLE
        EnfraItemReader<?> readerUser = this.getReader();
        EnfraItemWriter writerUser = this.getWriter();
        
        //※ ExecutorType : BATCH
        EnfraItemReader<?> readerUserBatch = this.getReader(true);
        EnfraItemWriter writerUserBatch = this.getWriter(true);
        
        int iMaxUpdate = 10;

        //Parameter Setting
        BIFC000000401IN inUser = new BIFC000000401IN();
        inUser.setBaseDt(jobParameters.getString("baseDt"));

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Compare UPDATE time in 2 tables by inquiring [N] times.");
            LOGGER.info("Performance Time Comparison of ExecutorType SIMPLE, BATCH");
        }

        ////////////////////////////////////////////////////////////////////////////////
        //@Step 2. Business Logic
        ////////////////////////////////////////////////////////////////////////////////
        long startTimeMilli = System.currentTimeMillis();

        ArrayList<BIFC000000101DTO> listUser1 = (ArrayList) readerUser.selectList("BIFC0000004.selectUserList", inUser);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("List1 User size : {}", listUser1.size());
        }

        //Declares the Row Mapping class as a result of the query, declares the query ID, sets the parameters for the query, and performs the query.
        readerUser.setQueryId("BIFC0000004.selectUserList");
        readerUser.setParameter(inUser);
        readerUser.loadSQL();

        //Start of transaction.
        this.beginTransaction();
        
        BIFC000000101DTO dtoUser = new BIFC000000101DTO();

        while ((dtoUser = (BIFC000000101DTO) readerUser.read()) != null) {
            for(int i=0; i<iMaxUpdate; i++) {
                writerUser.update("BIFC0000004.updateMessage");
            }
            
            // interval commit!
            this.checkCommit();
        }
        
        //End of transaction.
        this.endTransaction();

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>>>> ExecutorType [ SIMPLE ] Total time(sec) : {}", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTimeMilli));
        }

        //----------------------------------------------------------------------------------------------------------------------------
        
        ////////////////////////////////////////////////////////////////////////////////
        //@Step 3. ExecutorType BATCH
        ////////////////////////////////////////////////////////////////////////////////
        long startTimeMilli2 = System.currentTimeMillis();

        ArrayList<BIFC000000101DTO> listUser2 = (ArrayList) readerUser.selectList("BIFC0000004.selectUserList", inUser);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("List2 User size : {}", listUser2.size());
        }

        //Declares the Row Mapping class as a result of the query, declares the query ID, sets the parameters for the query, and performs the query.
        readerUserBatch.setQueryId("BIFC0000004.selectUserList");
        readerUserBatch.setParameter(inUser);
        readerUserBatch.loadSQL();
        
        //Start of transaction.
        this.beginTransaction();

        BIFC000000101DTO dtoUser2 = new BIFC000000101DTO();

        while ((dtoUser2 = (BIFC000000101DTO) readerUserBatch.read()) != null) {
            for(int i=0; i<iMaxUpdate; i++) {
                writerUserBatch.update("BIFC0000004.updateMessage");
            }
            
            //interval commit!
            this.checkCommit();
        }
        
        //End of transaction.
        this.endTransaction();

        if (LOGGER.isInfoEnabled())
            LOGGER.info(">>>>> ExecutorType [ BATCH ] Total time(sec) : {}", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTimeMilli2));

        return RepeatStatus.FINISHED;
    }
}
