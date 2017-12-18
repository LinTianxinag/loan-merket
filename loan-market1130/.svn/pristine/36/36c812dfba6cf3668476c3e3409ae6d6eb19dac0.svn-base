/**
 * Project Name:aalc
 * File Name:Resources
 * Package:com.anganglicai.core.config
 *
 * @author:panwang
 * @description: 加载配置配置文件
 * @date:2017/5/15
 * @version:V1.0
 * @see:jdk7 Copyright (c) 2017, mikuismywifu@gmail.com All Rights Reserved.
 */
package com.fuhui.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@PropertySource(value = { "classpath:config/config.properties，classpath:config/wodong.properties"})
public final class Resources {
	/** SSH服务器配置 */
	public static final ResourceBundle CONFIG = ResourceBundle.getBundle("config/config");
		/** 沃动短信的配置*/
	public static final ResourceBundle  WODONG= ResourceBundle.getBundle("config/wodong");
	/** 邮箱服务器配置 */

	/** 国际化信息 */
	private static final Map<String, ResourceBundle> MESSAGES = new HashMap<String, ResourceBundle>();

	
	
	/** 国际化信息 */
	public static String getMessage(String key, Object... params) {
		Locale locale = LocaleContextHolder.getLocale();
		ResourceBundle message = MESSAGES.get(locale.getLanguage());
		if (message == null) {
			synchronized (MESSAGES) {
				message = MESSAGES.get(locale.getLanguage());
				if (message == null) {
					message = ResourceBundle.getBundle("i18n/messages", locale);
					MESSAGES.put(locale.getLanguage(), message);
				}
			}
		}
		if (params != null) {
			return String.format(message.getString(key), params);
		}
		return message.getString(key);
	}

	/** 清除国际化信息 */
	public static void flushMessage() {
		MESSAGES.clear();
	}
}
