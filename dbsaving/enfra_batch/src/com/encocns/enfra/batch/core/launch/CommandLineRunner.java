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
	 * JobLauncher를 설정한다.
	 *
	 * @param launcher
	 */
	public void setLauncher(JobLauncher launcher) {
		this.launcher = launcher;
	}

	/**
	 * JobRepository를 설정한다.
	 *
	 * @param jobRepository
	 */
	public void setJobRepository(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	/**
	 * JobExplorer를 설정한다.
	 *
	 * @param jobExplorer
	 */
	public void setJobExplorer(JobExplorer jobExplorer) {
		this.jobExplorer = jobExplorer;
	}

	/**
	 * ExitCodeMapper를 설정한다.
	 *
	 * @param exitCodeMapper
	 */
	public void setExitCodeMapper(ExitCodeMapper exitCodeMapper) {
		this.exitCodeMapper = exitCodeMapper;
	}

	/**
	 * SystemExiter를 설정한다.
	 */
	public static void presetSystemExiter(SystemExiter systemExiter) {
		CommandLineRunner.systemExiter = systemExiter;
	}

	/**
	 * 에러 message를 가져온다.
	 *
	 * @return message
	 */
	public static String getErrorMessage() {
		return message;
	}

	/**
	 * SystemExiter를 설정한다.
	 */
	public void setSystemExiter(SystemExiter systemExiter) {
		CommandLineRunner.systemExiter = systemExiter;
	}

	/**
	 * 에러 message를 설정한다.
	 *
	 * @param message
	 */
	public void setMessage(String message) {
		CommandLineRunner.message = message;
	}

	/**
	 * JobParameters 생성에 사용되는 JobParametersConverter를 등록한다.
	 *
	 * @param jobParametersConverter
	 */
	public void setJobParametersConverter(JobParametersConverter jobParametersConverter) {
		this.jobParametersConverter = jobParametersConverter;
	}

	/**
	 * CommandLineRunner를 종료한다.
	 *
	 * @param status
	 */
	public void exit(int status) {
		systemExiter.exit(status);
	}

	/**
	 * JobLocator를 등록한다.
	 *
	 * @param jobLocator
	 */
	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	/**
	 * Batch Job을 실행한다.
	 * 실행을 위해서 , Job 이름 / JobExecutionID, Job Parameter
	 * 그리고 CommandLineRunner Option가 지정되어야 한다.
	 *
	 * @param jobPath : Job Context가 저장된 XML 파일 경로
	 * @param jobIdentifier : Job 이름 /JobExecutionID
	 * @param parameters : Job Parameter
	 * @param opts : CommandLineRunner 옵션(-restart, -next, -stop, -abandon)
	 */
	public int start(String jobPath, String jobIdentifier, String[] parameters, Set<String> opts) {

		ConfigurableApplicationContext context = null;

		try {
			// 새로운 ApplicationContext를 생성한다.
			context = new ClassPathXmlApplicationContext(jobPath);
			context.getAutowireCapableBeanFactory().autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);

			Assert.state(launcher != null, "A JobLauncher must be provided.  Please add one to the configuration.");
			// 기존의 Batch Job을 재시작하거나, 다음 Batch Job을 실행하기 전에 JobExplorer가 있는지 체크한다.
			if (opts.contains("-restart") || opts.contains("-next")) {
				Assert.state(jobExplorer != null,
						"A JobExplorer must be provided for a restart or start next operation.  Please add one to the configuration.");
			}

			// Job의 이름을 세팅한다.
			String jobName = jobIdentifier;

			// JobName을 파라미터에 추가로 전달한다.
			String[] arrParameters = new String[parameters.length+1];

			for(int i=0; i<arrParameters.length; i++) {
				if(i < parameters.length) {
					arrParameters[i] = parameters[i];
				}
			}

			arrParameters[arrParameters.length-1] = "jobName=" + jobName;

			// JobParameters를 생성한다.
			JobParameters jobParameters = jobParametersConverter.getJobParameters(StringUtils
					.splitArrayElementsIntoProperties(arrParameters, "="));
			Assert.isTrue(arrParameters == null || arrParameters.length == 0 || !jobParameters.isEmpty(),
					"Invalid JobParameters " + Arrays.asList(arrParameters)
							+ ". If parameters are provided they should be in the form name=value (no whitespace).");

			// Batch Job을 정지한다.
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

			// 정지된 Batch Job의 상태를 abandon으로 변경한다.
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

			// Batch Job을 재시작한다.
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

			// JobLocator가 있으면 Job을 가져오고 null이면 ApplicationContext에서 Job을 가져온다.
			if (jobLocator != null) {
				job = jobLocator.getJob(jobName);
			}
			else {
				job = (Job) context.getBean(jobName);
			}

			// 다음 Batch Job을 실행하기 위한 Job Parameters를 생성한다.
			if (opts.contains("-next")) {
				JobParameters nextParameters = getNextJobParameters(job);
				Map<String, JobParameter> map = new HashMap<String, JobParameter>(nextParameters.getParameters());
				map.putAll(jobParameters.getParameters());
				jobParameters = new JobParameters(map);
			}

			// Batch Job을 실행한다.
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
	 * 특정 BatchStatus의 값보다 큰 BatchStatus를 지닌 JobExecution을 조회한다.
	 * @param jobIdentifier
	 * @param minStatus
	 * @return List<JobExecution> : JobExecution 목록
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
	 * 실행에 실패한 가장 최근의 JobExecution을 검색한다.
	 *
	 * @param jobIdentifier
	 * @return jobExecution : 실행에 실패한 JobExecution
	 */
	private JobExecution getLastFailedJobExecution(String jobIdentifier) {
		List<JobExecution> jobExecutions = getJobExecutionsWithStatusGreaterThan(jobIdentifier, BatchStatus.STOPPING);
		if (jobExecutions.isEmpty()) {
			return null;
		}
		return jobExecutions.get(0);
	}

	/**
	 * 정지한 JobExecution 목록을 검색한다.
	 *
	 * @param jobIdentifier
	 * @return List<JobExecution> : 정지한 JobExecution 목록
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
	 * 실행 중인 JobExecution 목록을 검색한다.
	 *
	 * @param jobIdentifier
	 * @return List<JobExecution> : 실행 중인 JobExecution 목록
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
	 * JobIdentifier에 JobName 대신 String 형태의 JobExecutionId가 들어올 경우 Long으로 변환한다.
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
	 * 다음 실행 될 Batch Job의 Job Parameter를 생성한다.
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
