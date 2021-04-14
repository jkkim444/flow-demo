package com.encocns.enfra.batch.exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

public class EnfraMessage {

	/**
	 * MessageSourceAccessor
	 */
	private static MessageSourceAccessor messageSourceAccessor = null;
	
	private Locale locale;

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

    /**
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
