/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file BIFC0000001.java
 * @brief
 * \~english Batch template1
 * \~korean Batch template1
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2018. 2. 20. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ifrs.co.job
 * @brief Common Job Package
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
import com.encocns.ifrs.co.bvo.BIFC000000101IN;
import com.encocns.ifrs.co.dto.BIFC000000101DTO;

import aescrypto.EncryptionUtil;

/**
 * @brief
 * \~english Batch template1
 * \~korean Batch template1
 * @details
 * \~english Batch template1
 * \~korean Batch template1
 * @author : CHOI, YOUNG-HWAN
 * @date : 2018. 2. 20.
 * @version : 1.0.0
 */
public class BIFC0000001 extends EnfraTasklet {

    private static final Logger LOGGER = LoggerFactory.getLogger(BIFC0000001.class);

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
        BIFC000000101IN inUser = new BIFC000000101IN();
        inUser.setBaseDt(jobParameters.getString("baseDt"));

        ////////////////////////////////////////////////////////////////////////////////
        // @Step 2. Business Logic
        ////////////////////////////////////////////////////////////////////////////////

        //Declares the Row Mapping class as a result of the query, declares the query ID, sets the parameters for the query, and performs the query.
        readerUser.setQueryId("BIFC0000001.selectUserList");
        readerUser.setParameter(inUser);
        readerUser.loadSQL();

        this.beginTransaction();
        //Commit Interval Setting (Default : BatchConsts.DEFAULT_COMMIT_INTERVAL --> 10000);
        this.setCommitInterval(88);

        BIFC000000101DTO dtoUser = null;

        while ((dtoUser = (BIFC000000101DTO) readerUser.read()) != null) {
//            LOGGER.debug(dtoUser.toString());

            dtoUser.setCol2("test");
            writerUser.update("BIFC0000001.updateUser", dtoUser);

            this.checkCommit();
        }
//        this.localRollback();
        this.endTransaction();

        EnfraItemReader<?> readerUser2 = this.getReader();

        readerUser2.setQueryId("BIFC0000001.selectUserList");
        readerUser2.setParameter(inUser);
        readerUser2.loadSQL();

        this.beginTransaction();
        //Commit Interval Setting (Default : BatchConsts.DEFAULT_COMMIT_INTERVAL --> 10000);
        this.setCommitInterval(77);

        while ((dtoUser = (BIFC000000101DTO) readerUser2.read()) != null) {
//            LOGGER.debug(dtoUser.toString());

            dtoUser.setCol3("test");
            writerUser.update("BIFC0000001.updateUser2", dtoUser);

            this.checkCommit();
        }

//        this.localRollback();

        this.endTransaction();
        
        return RepeatStatus.FINISHED;
    }


    public static void main(String[] args) {

        System.out.println(EncryptionUtil.encrypt("1234"));
    }

}
