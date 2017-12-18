/**
 * Project Name:aalc
 * File Name:BaseInterceptor
 * Package:com.anganglicai.core.interceptor
 *
 * @author:panwang
 * @description: 拦截器基类
 * @date:2017/5/15
 * @version:V1.0
 * @see:jdk7 Copyright (c) 2017, mikuismywifu@gmail.com All Rights Reserved.
 */
package com.fuhui.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器基类
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {
	protected final Logger logger = LogManager.getLogger();
	private BaseInterceptor[] nextInterceptor;

	public void setNextInterceptor(BaseInterceptor... nextInterceptor) {
		this.nextInterceptor = nextInterceptor;
	}

	protected boolean nextInterceptor(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (nextInterceptor == null) {
			return true;
		}
		for (int i = 0; i < nextInterceptor.length; i++) {
			if (!nextInterceptor[i].preHandle(request, response, handler)) {
				return false;
			}
		}
		return true;
	}
}
