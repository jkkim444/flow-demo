package com.encocns.enfra.batch.core.launch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import com.encocns.enfra.batch.core.launch.CommandLineRunner;

public class JobRunner {
	protected static final Log logger = LogFactory.getLog(JobRunner.class);
	
	public static void main(String[] args) {
		/*
		 * CommandLine상에서 실행하기 위해서는 jobPath와 jobIdentifier을 인수로 받아야 한다. 
		 * jobPath: Batch Job 실행에 필요한 context 정보가 기술된 xml
		 * jobIdentifier: 실행할 Batch Job의 이름
		 * 
		 * 실행예시) 'java JobRunner jobPath jobIdentifier jobParamter1 ...'
		 * jobPath: /spring/batch/context-commandline.xml
		 * jobIdentifier: sampleJob
		 */
		CommandLineRunner command = new CommandLineRunner();

		List<String> newargs = new ArrayList<String>(Arrays.asList(args));
		newargs.add("timestamp=" + new Date().getTime());
		
		try {
			if (System.in.available() > 0) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String line = " ";
				while (StringUtils.hasLength(line)) {
					if (!line.startsWith("#") && StringUtils.hasText(line)) {
						logger.debug("Stdin arg: " + line);
						newargs.add(line);
					}
					line = reader.readLine();
				}
			}
		}
		catch (IOException e) {
			logger.warn("Could not access stdin (maybe a platform limitation)");
			if (logger.isDebugEnabled()) {
				logger.debug("Exception details", e);
			}
		}

		Set<String> opts = new HashSet<String>();
		List<String> params = new ArrayList<String>();

		int count = 0;
		String jobPath = null;
		String jobIdentifier = null;

		for (String arg : newargs) {
			if (arg.startsWith("-")) {
				opts.add(arg);
			}
			else {
				switch (count) {
				case 0:
					jobPath = arg;
					break;
				case 1:
					jobIdentifier = arg;
					break;
				default:
					params.add(arg);
					break;
				}
				count++;
			}
		}

		if (jobPath == null || jobIdentifier == null) {
			String message = "At least 2 arguments are required: JobPath and jobIdentifier.";
			logger.error(message);
			command.setMessage(message);
			command.exit(1);
		}

		String[] parameters = params.toArray(new String[params.size()]);

		int result = command.start(jobPath, jobIdentifier, parameters, opts);
		command.exit(result);
	}

}
