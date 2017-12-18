/**
 * Project Name:aalc
 * File Name:MaliciousRequestInterceptor
 * Package:com.anganglicai.core.interceptor
 *
 * @author:panwang
 * @description: 恶意请求拦截器
 * @date:2017/5/15
 * @version:V1.0
 * @see:jdk7 Copyright (c) 2017, mikuismywifu@gmail.com All Rights Reserved.
 */
package com.fuhui.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 恶意请求拦截器
 */
public class MaliciousRequestInterceptor extends BaseInterceptor {
	private Boolean allRequest = false; // 拦截所有请求,否则拦截相同请求
	private Long minRequestIntervalTime; // 允许的最小请求间隔
	private Integer maxMaliciousTimes; // 允许的最大恶意请求次数

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// String url = request.getServletPath();
		//
		// HttpSession session = request.getSession();
		//
		// // 获取当前key
		// String key = (String) request.getParameter("key") == null ? "" :
		// request.getParameter("key");
		//
		// // 上次请求
		// String preRequest = (String)
		// session.getAttribute(Constants.PREREQUEST);
		// // 上次请求时间
		// Long preRequestTime = (Long)
		// session.getAttribute(Constants.PREREQUEST_TIME);
		//
		// // 上次返回结果 是否是result 不为 0
		// boolean preRequestResult = false;
		//
		// preRequestResult = (Boolean) session.getAttribute(url) == null ?
		// false : (Boolean) session.getAttribute(url);
		// System.out.println("----是否存在记录恶意刷--------------：" +
		// preRequestResult);
		// System.out.println("----请求URL-------------------" + url);
		// 暂时不用
		// if (preRequestTime != null && preRequest != null)
		// { // 过滤频繁操作
		// // if ((url.equals(preRequest) || allRequest) &&
		// // System.currentTimeMillis() - preRequestTime <
		// // minRequestIntervalTime)
		// if (System.currentTimeMillis() - preRequestTime <
		// minRequestIntervalTime)
		// {
		// logger.warn("超过恶意请求间隔时间");
		// Integer maliciousRequestTimes = (Integer)
		// session.getAttribute(Constants.MALICIOUS_REQUEST_TIMES + key + url);
		// if (maliciousRequestTimes == null)
		// {
		// maliciousRequestTimes = 1;
		// } else
		// {
		// ++maliciousRequestTimes;
		// }
		// session.setAttribute(Constants.MALICIOUS_REQUEST_TIMES + key + url,
		// maliciousRequestTimes);
		// // 如果上次返回错误代码，请求次数一分钟超过6次就直接拒绝
		// if (preRequestResult && maliciousRequestTimes > maxMaliciousTimes)
		// {
		// response.setStatus(HttpCode.LOCKED.value());
		// logger.warn("------------To intercept a malicious request : {}",
		// url);
		// return false;
		// }
		// } else
		// {
		// session.setAttribute(Constants.MALICIOUS_REQUEST_TIMES, 0);
		// }
		// }
		// session.setAttribute(Constants.PREREQUEST, url);
		// session.setAttribute(Constants.PREREQUEST_TIME,
		// System.currentTimeMillis());
		return nextInterceptor(request, response, handler);
	}

	public void setAllRequest(Boolean allRequest)
	{
		this.allRequest = allRequest;
	}

	public void setMinRequestIntervalTime(Long minRequestIntervalTime) {
		this.minRequestIntervalTime = minRequestIntervalTime;
	}

	public void setMaxMaliciousTimes(Integer maxMaliciousTimes)
	{
		this.maxMaliciousTimes = maxMaliciousTimes;
	}
}
