/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file CommandLineUtil.java
 * @brief 
 * \~english CommandLine Util
 * \~korean 명령어 실행 유틸리티
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2019. 11. 21. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ifrs.co.util
 * @brief Common Utility Package
 */
package com.encocns.ifrs.co.util;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * @brief 
 * \~english CommandLine Utility
 * \~korean CommandLine Utility
 * @details 
 * <pre>
 * \~english CommandLine Utility
 * \~korean CommandLine Utility
 * </pre>
 * @author : CHOI, YOUNG-HWAN
 * @date : 2019. 11. 21.
 * @version : 1.0.0
 */
public class CommandLineUtil {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineUtil.class);
    
    /**
     * @brief 
     * \~english CommandLine Utility
     * \~korean CommandLine Utility
     * @details 
     * <pre>
     * \~english CommandLine Utility
     * \~korean CommandLine Utility
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2019. 11. 21.
     * @param commandLine
     * @param lnTimeOut
     * @return boolean isSuccess
     */
    public static boolean execute( CommandLine commandLine, long lnTimeOut  ) {
        if(commandLine == null) {
            Assert.notNull(commandLine, "[Assertion failed] - this argument is required; it must not be null");
        } 
        
        DefaultExecutor executor = new DefaultExecutor();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(baos);
        
        executor.setStreamHandler(streamHandler);
        executor.setExitValue(1);
        
        ExecuteWatchdog watchdog = new ExecuteWatchdog(lnTimeOut);
        
        executor.setWatchdog(watchdog);
        
        if (LOGGER.isInfoEnabled()) {
            for (String arg : commandLine.getArguments()) {
                LOGGER.info("##### Argument : {}", arg);
            }
        }
        
        int iExitValue = 1;

        try {
            iExitValue = executor.execute(commandLine);
        } catch (ExecuteException e) {
            if(e.getExitValue() > 0) {
                return false;
            } else {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("##### ExitValue : {}", iExitValue);
            LOGGER.info("##### Execute!");
        }
        
        if(iExitValue > 0) {
            return false;
        }
        
        return true;
    }
    
}
