/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file BaseJobExecutionListener.java
 * @brief Job Execution Listener
 */
/**
 * @namespace com.encocns.batch.core.listener
 * @brief Core Listener Package
 */
package com.encocns.enfra.batch.core.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @brief Job Execution Listener
 * @details Job Execution Listener이다.
 * @author : joy
 * @date : 2017. 2. 2.
 * @version : 1.0.0
 */
public class EnfraJobExecutionListener implements JobExecutionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnfraJobExecutionListener.class);

	/**
	 * @brief Job Execution 실행 전처리
	 * @details Job Execution 실행 전처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.springframework.batch.core.JobExecutionListener#beforeJob(org.springframework.batch.core.JobExecution)
	 * @param jobExecution
	 */
	@Override
    public void beforeJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        
//        jobExecution.getJobInstance().getId()
        
        MDC.put("fileName", jobName);
        
        if(LOGGER.isInfoEnabled()) LOGGER.info("##### beforeJob Listener JobName : {} ", jobName);
    }

	/**
	 * @brief Job Execution 실행 후처리
	 * @details Job Execution 실행 후처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.springframework.batch.core.JobExecutionListener#afterJob(org.springframework.batch.core.JobExecution)
	 * @param jobExecution
	 */
	@Override
    public void afterJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        if(LOGGER.isInfoEnabled()) LOGGER.info("##### afterJob Listener JobName : {} , result : {}", jobName, jobExecution.getExitStatus());
    }

}
