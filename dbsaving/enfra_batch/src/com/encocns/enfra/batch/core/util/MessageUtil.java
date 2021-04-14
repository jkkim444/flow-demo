/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file MessageUtil.java
 * @brief
 */
/**
 * @namespace com.encocns.batch.core.util
 * @brief
 */
package com.encocns.enfra.batch.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

public class MessageUtil {

	private static MessageSourceAccessor messageSourceAccessor = null;

	@Autowired
	public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
		MessageUtil.messageSourceAccessor = messageSourceAccessor;
	}

	/**
	 * KEY에 해당하는 메세지 반환
	 *
	 * @param key
	 * @return
	 */
	public static String getMessage(String key) {
		return messageSourceAccessor.getMessage(key, LocaleContextHolder.getLocale());
	}

	/**
	 * KEY에 해당하는 메세지 반환
	 *
	 * @param key
	 * @param objs
	 * @return
	 */
	public static String getMessage(String key, Object[] objs) {
		return messageSourceAccessor.getMessage(key, objs, LocaleContextHolder.getLocale());
	}

	public static String getMessage(String key, String message) {
		return messageSourceAccessor.getMessage(key, new Object[] {message}, LocaleContextHolder.getLocale());
	}
}
