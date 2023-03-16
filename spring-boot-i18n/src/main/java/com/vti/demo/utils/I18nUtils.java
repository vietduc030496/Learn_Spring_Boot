package com.vti.demo.utils;

import java.util.Locale;

import org.springframework.context.MessageSource;

import com.vti.demo.config.BeanConfiguration;

public class I18nUtils {

	/**
	 * @see BeanConfiguration
	 */
	private static MessageSource messageSource;

	public static void init(MessageSource inject) {
		messageSource = inject;
	}

	public static String getMessage(String code, Locale locale) {
		return messageSource.getMessage(code, null, locale);
	}

}
