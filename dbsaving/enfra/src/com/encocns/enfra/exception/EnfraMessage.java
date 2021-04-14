package com.encocns.enfra.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;

public class EnfraMessage {

	/**
	 * MessageSourceAccessor
	 */
	private static MessageSourceAccessor messageSourceAccessor = null;

	@Autowired
	public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
		EnfraMessage.messageSourceAccessor = messageSourceAccessor;
	}

	/**
	 * KEY에 해당하는 메세지 반환
	 *
	 * @param key
	 * @return
	 */
	public static String getMessage(String key) {
	    return messageSourceAccessor.getMessage(key);
	}

	/**
	 * KEY에 해당하는 메세지 반환
	 *
	 * @param key
	 * @param objs
	 * @return
	 */
	public static String getMessage(String key, Object[] objs) {
	    return messageSourceAccessor.getMessage(key, objs);
	}

}
