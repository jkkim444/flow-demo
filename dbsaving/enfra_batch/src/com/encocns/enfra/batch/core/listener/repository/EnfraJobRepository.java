package com.encocns.enfra.batch.core.listener.repository;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;

public class EnfraJobRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnfraJobRepository.class);
	
	private String jobId;
	private String stepId;
	private String jobName;
	private String stepName;
	private JobParameters jobParameter;
	private Map<String,String> stepParameter;
	private StepContext stepContext;
	private Map<String, String> coreStepParameter;
	
	public void init( ChunkContext chunkContext, Map<String, String> coreStepParameter, Map<String, String> stepParameter)
	{
		this.stepContext = chunkContext.getStepContext();
		
		setJobId(String.valueOf(stepContext.getStepExecution().getJobExecutionId()));
		setJobName(stepContext.getJobName());
		setStepId(String.valueOf(stepContext.getStepExecution().getId()));  
		setStepName(stepContext.getStepName());
		setJobParameter(chunkContext.getStepContext().getStepExecution().getJobParameters());
		setCoreStepParameter(coreStepParameter);
		setStepParameter(stepParameter);
		print();
	}
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public JobParameters getJobParameter() {
		return jobParameter;
	}
	public void setJobParameter(JobParameters jobParameter) {
		this.jobParameter = jobParameter;
	}
	public Map<String, String> getStepParameter() {
		return stepParameter;
	}
	public void setStepParameter(Map<String, String> stepParameter) {
		this.stepParameter = stepParameter;
	}
	
	public void print()
	{
		if(LOGGER.isInfoEnabled()) 
		{
			LOGGER.info("============ JobDescription ============");
			LOGGER.info("JOB_ID         : " + jobId );
			LOGGER.info("JOB_NAME       : " + jobName );
			LOGGER.info("STEP_ID        : " + stepId );
			LOGGER.info("STEP_NAME      : " + stepName );
			LOGGER.info("JOB_PARAMETER  : " + jobParameter );
			LOGGER.info("STEP_PARAMETER : " + stepParameter );
			LOGGER.info("CORE_PARAMETER : " + coreStepParameter );
			LOGGER.info("============ \\JobDescription ============");
		}
	}

	public Map<String, String> getCoreStepParameter() {
		return coreStepParameter;
	}
	
	public void setCoreStepParameter(Map<String, String> coreStepParameter) {
		this.coreStepParameter = coreStepParameter;
	}
}
