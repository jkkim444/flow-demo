/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file CO0002.java
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
import com.encocns.ifrs.co.bvo.CO000201IN;
import com.encocns.ifrs.co.dto.CO000201DTO;

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
public class CO0002 extends EnfraTasklet {

    private static final Logger LOGGER = LoggerFactory.getLogger(CO0002.class);

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
        EnfraItemReader<?> readerParam = this.getReader();
        EnfraItemWriter writerParam = this.getWriter();

        // ???????????? ??????
        CO000201IN inParam = new CO000201IN();
        // ?????? ?????? ????????? ????????? ???????????? ??????????????? ??????.
        inParam.setCol1(jobParameters.getString("col1"));

        ////////////////////////////////////////////////////////////////////////////////
        // @Step 2. Business Logic
        ////////////////////////////////////////////////////////////////////////////////

        // ?????? ????????? ?????? ??? ?????? ??????
        readerParam.setQueryId("CO0002.selectTemplate"); // ?????? ???????????? ????????? ??????
        readerParam.setParameter(inParam); // ???????????? ??????
        readerParam.loadSQL(); // sql ??????

        this.beginTransaction(); // ???????????? ?????? ( lock )

        CO000201DTO dtoParam = (CO000201DTO) readerParam.read(); // CO000201DTO ???????????? ?????? ( sql ??????????????? ?????? )

        // ???????????? ??????
        writerParam.update("CO0002.updateTemplate", dtoParam);

        this.endTransaction(); // ???????????? ?????? ( commit )

        return RepeatStatus.FINISHED;
    }

}
