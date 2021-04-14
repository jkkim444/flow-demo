package com.encocns.enfra.batch.core.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;


public final class LoggerUtil {

    /**
     * <h3> HashMap 의 내용을 로그로 남기는 역활 메소드</h3>
     * <ul>
     * <li> LogUtil.log4DebugMap(logger, HashMap) </li>
     * </ul>
     * @param logger
     * @param message
     */
    public static void log4DebugMap(Logger logger, HashMap<String, ?> map_log) {
        if (logger.isDebugEnabled()) {
            String str_key = "";
            Iterator<String> iter_key = map_log.keySet().iterator();
            logger.debug("------------------------------------------------------------------------");
            while (iter_key.hasNext()) {
                str_key = (String) iter_key.next();
                logger.debug(MessageFormat.format(" {0} : {1} ", new Object[]{str_key, map_log.get(str_key)}));
            }
            logger.debug("------------------------------------------------------------------------");
        }
    }

	/**
	 * <h3> Debug 로그를 남기는 역활 메소드</h3>
	 * <ul>
	 * <li> LogUtil.log4Debug(logger, "테스트") </li>
	 * </ul>
	 * @param logger
	 * @param message
	 */
	public static void log4Debug(Logger logger, String message) {
		if (logger.isDebugEnabled()) logger.debug(message);
	}

	/**
	 * <h3> Debug 로그를 남기는 역활 메소드 </h3>
	 * <ul>
	 * <li> Object[] arguments = {"A", "B", "C"} </li>
	 * <li> LogUtil.log4Debug(logger, "테스트 {0} - {1} - {2}", arguments) </li>
	 * </ul>
	 * @param logger
	 * @param message_pattern
	 * @param arguments
	 */
	public static void log4Debug(Logger logger, String message_pattern, Object[] arguments) {
		if (logger.isDebugEnabled()) logger.debug(MessageFormat.format(message_pattern, arguments));
	}

	/**
	 * <h3> Debug 로그를 남기는 역활 메소드</h3>
	 * <ul>
	 * <li> LogUtil.log4Debug(logger, "테스트에러", e) </li>
	 * </ul>
	 * @param logger
	 * @param message
	 * @param e
	 */
	public static void log4Debug(Logger logger, String message, Exception e) {
		if (logger.isDebugEnabled()) {
			Object[] arguments = { message, e.getStackTrace()[0].getClassName(), e.getStackTrace()[0].getMethodName(), e.getMessage() };
			LoggerUtil.log4Debug(logger, "{0} [ Class : {1} ] [ Method : {2} ] [ Message : {3} ]", arguments);
		}
	}

	/**
	 * <h3> Info 로그를 남기는 역활 메소드</h3>
	 * <ul>
	 * <li> LogUtil.log4Debug(logger, "테스트") </li>
	 * </ul>
	 * @param logger
	 * @param message
	 */
	public static void log4Info(Logger logger, String message) {
		logger.info(message);
	}

	/**
	 * <h3> Info 로그를 남기는 역활 메소드 </h3>
	 * <ul>
	 * <li> Object[] arguments = {"A", "B", "C"} </li>
	 * <li> LogUtil.log4Debug(logger, "테스트 {0} - {1} - {2}", arguments) </li>
	 * </ul>
	 * @param logger
	 * @param message_pattern
	 * @param arguments
	 */
	public static void log4Info(Logger logger, String message_pattern, Object[] arguments) {
		logger.info(MessageFormat.format(message_pattern, arguments));
	}

	/**
	 * <h3> Info 로그를 남기는 역활 메소드</h3>
	 * <ul>
	 * <li> LogUtil.log4Info(logger, "테스트에러", e) </li>
	 * </ul>
	 * @param logger
	 * @param message
	 * @param e
	 */
	public static void log4Info(Logger logger, String message, Exception e) {
		Object[] arguments = { message, e.getStackTrace()[0].getClassName(), e.getStackTrace()[0].getMethodName(), e.getMessage() };
		LoggerUtil.log4Info(logger, "{0} [ Class : {1} ] [ Method : {2} ] [ Message : {3} ]", arguments);
	}

	/**
	 * <h3> Error 로그를 남기는 역활 메소드</h3>
	 * <ul>
	 * <li> LogUtil.log4Error(logger, "테스트에러") </li>
	 * </ul>
	 * @param logger
	 * @param message
	 */
	public static void log4Error(Logger logger, String message) {
		logger.error(message);
	}

	/**
	 * <h3> Error 로그를 남기는 역활 메소드</h3>
	 * <ul>
	 * <li> Object[] arguments = {"A", "B", "C"} </li>
	 * <li> LogUtil.log4Error(logger, "테스트 {0} - {1} - {2}", arguments) </li>
	 * </ul>
	 * @param logger
	 * @param message_pattern
	 * @param arguments
	 */
	public static void log4Error(Logger logger, String message_pattern, Object[] arguments) {
		logger.error(MessageFormat.format(message_pattern, arguments));
	}

	/**
	 * <h3> Error 로그를 남기는 역활 메소드</h3>
	 * <ul>
	 * <li> LogUtil.log4Error(logger, "테스트 로그", e) </li>
	 * </ul>
	 * @param logger
	 * @param message
	 * @param e
	 */
	public static void log4Error(Logger logger, String message, Exception e) {
		Object[] arguments = { message, e.getStackTrace()[0].getClassName(), e.getStackTrace()[0].getMethodName(), e.getMessage() };
		LoggerUtil.log4Error(logger, "{0} [ Class : {1} ] [ Method : {2} ] [ Message : {3} ]", arguments);
		StackTraceElement[] elements = e.getStackTrace();
		StringBuffer sbLog = new StringBuffer();
		int elementLen = elements.length;
		for (int i = 0; i < elementLen; i++) {
		    sbLog.append( MessageFormat.format("[ Class : {0} ] [ Method : {1} ] [ Line : {2} ]", new Object[]{ elements[i].getClassName(), elements[i].getMethodName(), elements[i].getLineNumber() }) ).append("\n");
	        if (elements[i].getClassName().indexOf(logger.getName()) >=0 ) break;
        }
		logger.error(sbLog.toString());
	}
}
