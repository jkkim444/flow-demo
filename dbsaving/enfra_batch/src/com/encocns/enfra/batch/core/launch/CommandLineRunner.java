package com.encocns.enfra.batch.core.launch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.converter.DefaultJobParametersConverter;
import org.springframework.batch.core.converter.JobParametersConverter;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobExecutionNotFailedException;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobExecutionNotStoppedException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobParametersNotFoundException;
import org.springframework.batch.core.launch.support.ExitCodeMapper;
import org.springframework.batch.core.launch.support.JvmSystemExiter;
import org.springframework.batch.core.launch.support.SimpleJvmExitCodeMapper;
import org.springframework.batch.core.launch.support.SystemExiter;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private ExitCodeMapper exitCodeMapper = new SimpleJvmExitCodeMapper();
	private JobLauncher launcher;
	private JobLocator jobLocator;
	private static SystemExiter systemExiter = new JvmSystemExiter();
	private static String message = "";
	private JobParametersConverter jobParametersConverter = new DefaultJobParametersConverter();
	private JobExplorer jobExplorer;
	private JobRepository jobRepository;

	/**
	 * JobLauncher??? ????????????.
	 *
	 * @param launcher
	 */
	public void setLauncher(JobLauncher launcher) {
		this.launcher = launcher;
	}

	/**
	 * JobRepository??? ????????????.
	 *
	 * @param jobRepository
	 */
	public void setJobRepository(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	/**
	 * JobExplorer??? ????????????.
	 *
	 * @param jobExplorer
	 */
	public void setJobExplorer(JobExplorer jobExplorer) {
		this.jobExplorer = jobExplorer;
	}

	/**
	 * ExitCodeMapper??? ????????????.
	 *
	 * @param exitCodeMapper
	 */
	public void setExitCodeMapper(ExitCodeMapper exitCodeMapper) {
		this.exitCodeMapper = exitCodeMapper;
	}

	/**
	 * SystemExiter??? ????????????.
	 */
	public static void presetSystemExiter(SystemExiter systemExiter) {
		CommandLineRunner.systemExiter = systemExiter;
	}

	/**
	 * ?????? message??? ????????????.
	 *
	 * @return message
	 */
	public static String getErrorMessage() {
		return message;
	}

	/**
	 * SystemExiter??? ????????????.
	 */
	public void setSystemExiter(SystemExiter systemExiter) {
		CommandLineRunner.systemExiter = systemExiter;
	}

	/**
	 * ?????? message??? ????????????.
	 *
	 * @param message
	 */
	public void setMessage(String message) {
		CommandLineRunner.message = message;
	}

	/**
	 * JobParameters ????????? ???????????? JobParametersConverter??? ????????????.
	 *
	 * @param jobParametersConverter
	 */
	public void setJobParametersConverter(JobParametersConverter jobParametersConverter) {
		this.jobParametersConverter = jobParametersConverter;
	}

	/**
	 * CommandLineRunner??? ????????????.
	 *
	 * @param status
	 */
	public void exit(int status) {
		systemExiter.exit(status);
	}

	/**
	 * JobLocator??? ????????????.
	 *
	 * @param jobLocator
	 */
	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	/**
	 * Batch Job??? ????????????.
	 * ????????? ????????? , Job ?????? / JobExecutionID, Job Parameter
	 * ????????? CommandLineRunner Option??? ??????????????? ??????.
	 *
	 * @param jobPath : Job Context??? ????????? XML ?????? ??????
	 * @param jobIdentifier : Job ?????? /JobExecutionID
	 * @param parameters : Job Parameter
	 * @param opts : CommandLineRunner ??????(-restart, -next, -stop, -abandon)
	 */
	public int start(String jobPath, String jobIdentifier, String[] parameters, Set<String> opts) {

		ConfigurableApplicationContext context = null;

		try {
			// ????????? ApplicationContext??? ????????????.
			context = new ClassPathXmlApplicationContext(jobPath);
			context.getAutowireCapableBeanFactory().autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);

			Assert.state(launcher != null, "A JobLauncher must be provided.  Please add one to the configuration.");
			// ????????? Batch Job??? ??????????????????, ?????? Batch Job??? ???????????? ?????? JobExplorer??? ????????? ????????????.
			if (opts.contains("-restart") || opts.contains("-next")) {
				Assert.state(jobExplorer != null,
						"A JobExplorer must be provided for a restart or start next operation.  Please add one to the configuration.");
			}

			// Job??? ????????? ????????????.
			String jobName = jobIdentifier;

			// JobName??? ??????????????? ????????? ????????????.
			String[] arrParameters = new String[parameters.length+1];

			for(int i=0; i<arrParameters.length; i++) {
				if(i < parameters.length) {
					arrParameters[i] = parameters[i];
				}
			}

			arrParameters[arrParameters.length-1] = "jobName=" + jobName;

			// JobParameters??? ????????????.
			JobParameters jobParameters = jobParametersConverter.getJobParameters(StringUtils
					.splitArrayElementsIntoProperties(arrParameters, "="));
			Assert.isTrue(arrParameters == null || arrParameters.length == 0 || !jobParameters.isEmpty(),
					"Invalid JobParameters " + Arrays.asList(arrParameters)
							+ ". If parameters are provided they should be in the form name=value (no whitespace).");

			// Batch Job??? ????????????.
			if (opts.contains("-stop")) {
				List<JobExecution> jobExecutions = getRunningJobExecutions(jobIdentifier);
				if (jobExecutions == null) {
					throw new JobExecutionNotRunningException("No running execution found for job=" + jobIdentifier);
				}
				for (JobExecution jobExecution : jobExecutions) {
					jobExecution.setStatus(BatchStatus.STOPPING);
					jobRepository.update(jobExecution);
				}
				return exitCodeMapper.intValue(ExitStatus.COMPLETED.getExitCode());
			}

			// ????????? Batch Job??? ????????? abandon?????? ????????????.
			if (opts.contains("-abandon")) {
				List<JobExecution> jobExecutions = getStoppedJobExecutions(jobIdentifier);
				if (jobExecutions == null) {
					throw new JobExecutionNotStoppedException("No stopped execution found for job=" + jobIdentifier);
				}
				for (JobExecution jobExecution : jobExecutions) {
					jobExecution.setStatus(BatchStatus.ABANDONED);
					jobRepository.update(jobExecution);
				}
				return exitCodeMapper.intValue(ExitStatus.COMPLETED.getExitCode());
			}

			// Batch Job??? ???????????????.
			if (opts.contains("-restart")) {
				JobExecution jobExecution = getLastFailedJobExecution(jobIdentifier);
				if (jobExecution == null) {
					throw new JobExecutionNotFailedException("No failed or stopped execution found for job="
							+ jobIdentifier);
				}
				jobParameters = jobExecution.getJobInstance().getJobParameters();
				jobName = jobExecution.getJobInstance().getJobName();
			}

			Job job;

			// JobLocator??? ????????? Job??? ???????????? null?????? ApplicationContext?????? Job??? ????????????.
			if (jobLocator != null) {
				job = jobLocator.getJob(jobName);
			}
			else {
				job = (Job) context.getBean(jobName);
			}

			// ?????? Batch Job??? ???????????? ?????? Job Parameters??? ????????????.
			if (opts.contains("-next")) {
				JobParameters nextParameters = getNextJobParameters(job);
				Map<String, JobParameter> map = new HashMap<String, JobParameter>(nextParameters.getParameters());
				map.putAll(jobParameters.getParameters());
				jobParameters = new JobParameters(map);
			}

			// Batch Job??? ????????????.
			JobExecution jobExecution = launcher.run(job, jobParameters);
			logger.warn("CommandLineRunner's Job Information");
			logger.warn("jobName=" + jobExecution.getJobInstance().getJobName());
			logger.warn("jobParamters=" + jobParameters.toString());
			logger.warn("jobExecutionTime=" + (jobExecution.getEndTime().getTime() - jobExecution.getStartTime().getTime())/1000f + "s");

			return exitCodeMapper.intValue(jobExecution.getExitStatus().getExitCode());
		}
		catch (Throwable e) {
			String message = "Job Terminated in error: " + e.getMessage();
			logger.error(message, e);
			CommandLineRunner.message = message;
			return exitCodeMapper.intValue(ExitStatus.FAILED.getExitCode());
		}
		finally {
			if (context != null) {
				context.close();
			}
		}
	}

	/**
	 * ?????? BatchStatus??? ????????? ??? BatchStatus??? ?????? JobExecution??? ????????????.
	 * @param jobIdentifier
	 * @param minStatus
	 * @return List<JobExecution> : JobExecution ??????
	 */
	private List<JobExecution> getJobExecutionsWithStatusGreaterThan(String jobIdentifier, BatchStatus minStatus) {

		Long executionId = getLongIdentifier(jobIdentifier);
		if (executionId != null) {
			JobExecution jobExecution = jobExplorer.getJobExecution(executionId);
			if (jobExecution.getStatus().isGreaterThan(minStatus)) {
				return Arrays.asList(jobExecution);
			}
			return Collections.emptyList();
		}

		int start = 0;
		int count = 100;
		List<JobExecution> executions = new ArrayList<JobExecution>();
		List<JobInstance> lastInstances = jobExplorer.getJobInstances(jobIdentifier, start, count);

		while (!lastInstances.isEmpty()) {

			for (JobInstance jobInstance : lastInstances) {
				List<JobExecution> jobExecutions = jobExplorer.getJobExecutions(jobInstance);
				if (jobExecutions == null || jobExecutions.isEmpty()) {
					continue;
				}
				for (JobExecution jobExecution : jobExecutions) {
					if (jobExecution.getStatus().isGreaterThan(minStatus)) {
						executions.add(jobExecution);
					}
				}
			}

			start += count;
			lastInstances = jobExplorer.getJobInstances(jobIdentifier, start, count);

		}

		return executions;

	}

	/**
	 * ????????? ????????? ?????? ????????? JobExecution??? ????????????.
	 *
	 * @param jobIdentifier
	 * @return jobExecution : ????????? ????????? JobExecution
	 */
	private JobExecution getLastFailedJobExecution(String jobIdentifier) {
		List<JobExecution> jobExecutions = getJobExecutionsWithStatusGreaterThan(jobIdentifier, BatchStatus.STOPPING);
		if (jobExecutions.isEmpty()) {
			return null;
		}
		return jobExecutions.get(0);
	}

	/**
	 * ????????? JobExecution ????????? ????????????.
	 *
	 * @param jobIdentifier
	 * @return List<JobExecution> : ????????? JobExecution ??????
	 */
	private List<JobExecution> getStoppedJobExecutions(String jobIdentifier) {
		List<JobExecution> jobExecutions = getJobExecutionsWithStatusGreaterThan(jobIdentifier, BatchStatus.STARTED);
		if (jobExecutions.isEmpty()) {
			return null;
		}
		List<JobExecution> result = new ArrayList<JobExecution>();
		for (JobExecution jobExecution : jobExecutions) {
			if (jobExecution.getStatus() != BatchStatus.ABANDONED) {
				result.add(jobExecution);
			}
		}
		return result.isEmpty() ? null : result;
	}

	/**
	 * ?????? ?????? JobExecution ????????? ????????????.
	 *
	 * @param jobIdentifier
	 * @return List<JobExecution> : ?????? ?????? JobExecution ??????
	 */
	private List<JobExecution> getRunningJobExecutions(String jobIdentifier) {
		List<JobExecution> jobExecutions = getJobExecutionsWithStatusGreaterThan(jobIdentifier, BatchStatus.COMPLETED);
		if (jobExecutions.isEmpty()) {
			return null;
		}
		List<JobExecution> result = new ArrayList<JobExecution>();
		for (JobExecution jobExecution : jobExecutions) {
			if (jobExecution.isRunning()) {
				result.add(jobExecution);
			}
		}
		return result.isEmpty() ? null : result;
	}

	/**
	 * JobIdentifier??? JobName ?????? String ????????? JobExecutionId??? ????????? ?????? Long?????? ????????????.
	 *
	 * @param jobIdentifier
	 * @return
	 */
	private Long getLongIdentifier(String jobIdentifier) {
		try {
			return Long.valueOf(jobIdentifier);
		}
		catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * ?????? ?????? ??? Batch Job??? Job Parameter??? ????????????.
	 *
	 * @param job
	 * @return JobParameters
	 * @throws JobParametersNotFoundException
	 */
	private JobParameters getNextJobParameters(Job job) throws JobParametersNotFoundException {
		String jobIdentifier = job.getName();
		JobParameters jobParameters;
		List<JobInstance> lastInstances = jobExplorer.getJobInstances(jobIdentifier, 0, 1);

		JobParametersIncrementer incrementer = job.getJobParametersIncrementer();
		if (incrementer == null) {
			throw new JobParametersNotFoundException("No job parameters incrementer found for job=" + jobIdentifier);
		}

		if (lastInstances.isEmpty()) {
			jobParameters = incrementer.getNext(new JobParameters());
			if (jobParameters == null) {
				throw new JobParametersNotFoundException("No bootstrap parameters found from incrementer for job="
						+ jobIdentifier);
			}
		}
		else {
			jobParameters = incrementer.getNext(lastInstances.get(0).getJobParameters());
		}
		return jobParameters;
	}
}
