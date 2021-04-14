/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file BaseStepExecutionListener.java
 * @brief Step Execution Listener
 */
/**
 * @namespace com.encocns.batch.core.listener
 * @brief Core Listener Package
 */
package com.encocns.enfra.batch.core.listener;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.encocns.enfra.batch.core.listener.repository.EnfraJobRepository;

/**
 * @brief Step Execution Listener
 * @details Step Execution Listener이다.
 * @author : joy
 * @date : 2017. 2. 2.
 * @version : 1.0.0
 */
@SuppressWarnings("unused")
public class EnfraStepExecutionListener implements StepExecutionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnfraStepExecutionListener.class);
	
	private DataSource dataSource;
	private DataSourceTransactionManager txManager;
	private EnfraJobRepository enfraJobRepository;
	private Map<String, String> stepParameter;
	private Map<String, String> coreStepParameter;

	protected long startTimeMilli;

	protected long elapsedTime() {
		return System.currentTimeMillis() - startTimeMilli;
	}
	
	/**
	 * @brief Step Execution 실행 전처리
	 * @details Step Execution 실행 전처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.springframework.batch.core.StepExecutionListener#beforeStep(org.springframework.batch.core.StepExecution)
	 * @param stepexecution
	 */
	@Override
    public void beforeStep(StepExecution stepexecution) {
		this.startTimeMilli = System.currentTimeMillis();
		
        if(LOGGER.isInfoEnabled()) LOGGER.info("##### beforeStep Listener JobName : " + stepexecution.getJobExecution().getJobInstance().getJobName() + ", stepName : " + stepexecution.getStepName() + ", jobExecutionId : "+stepexecution.getJobExecution().getJobInstance().getId());
        if(LOGGER.isInfoEnabled()) LOGGER.info("##### JobParameters : {}", stepexecution.getJobParameters().toString());
        
    }

	/**
	 * @brief Step Execution 실행 후처리
	 * @details Step Execution 실행 후처리한다.
	 * @author : joy
	 * @date : 2017. 2. 2.
	 * @see org.springframework.batch.core.StepExecutionListener#afterStep(org.springframework.batch.core.StepExecution)
	 * @param stepexecution
	 * @return
	 */
	@Override
    public ExitStatus afterStep(StepExecution stepexecution) {
		if(LOGGER.isInfoEnabled()) LOGGER.info("##### afterStep(ms) : " + elapsedTime());
		if(LOGGER.isInfoEnabled()) LOGGER.info("##### afterStep(s) : " + TimeUnit.MILLISECONDS.toSeconds(elapsedTime()));
		
        if(LOGGER.isInfoEnabled()) LOGGER.info("##### afterStep Listener JobName : " + stepexecution.getJobExecution().getJobInstance().getJobName() + ", stepName : " + stepexecution.getStepName() + ", jobExecutionId : " + stepexecution.getJobExecutionId() + ", result : " + stepexecution.getExitStatus());

        return stepexecution.getExitStatus();
    }
	
	/**
	 * @brief DataSource SET
	 * @details DataSource를 SET한다.
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * @brief EnfraJobRepository SET
	 * @details EnfraJobRepository를 SET한다. 
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param enfraJobRepository
	 */
	public void setEnfraJobRepository(EnfraJobRepository enfraJobRepository) {
		this.enfraJobRepository = enfraJobRepository;
	}

	/**
	 * @brief CoreStepParameter SET
	 * @details CoreStepParameter를 SET한다. 
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param coreStepParameter
	 */
	public void setCoreStepParameter(Map<String, String> coreStepParameter) {
		this.coreStepParameter = coreStepParameter;
	}
	
	/**
	 * @brief Step Parameter SET 
	 * @details Step Parameter를 SET한다.
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param stepParameter
	 */
	public void setStepParameter(Map<String, String> stepParameter) {
		this.stepParameter = stepParameter;
	}
	
	/**
	 * @brief Transaction Manager SET
	 * @details Transaction Manager를 SET한다. 
	 * @author : joy
	 * @date : 2018. 2. 26.
	 * @param txManager
	 */
	public void setTxManager(DataSourceTransactionManager txManager) {
		this.txManager = txManager;
	}
	
}