package com.fuhui.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HttpUtils {

	private static Log log = LogFactory.getLog(HttpUtils.class);

	/**
	 * 定义编码格式 UTF-8
	 */
	public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";

	/**
	 * 定义编码格式 GBK
	 */
	public static final String URL_PARAM_DECODECHARSET_GBK = "GBK";

	private static final String URL_PARAM_CONNECT_FLAG = "&";

	private static final String EMPTY = "";

	private static MultiThreadedHttpConnectionManager connectionManager = null;

	private static int connectionTimeOut = 60000;

	private static int socketTimeOut = 60000;

	private static int maxConnectionPerHost = 20;

	private static int maxTotalConnections = 20;

	private static HttpClient client;

	static {
		connectionManager = new MultiThreadedHttpConnectionManager();
		connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
		connectionManager.getParams().setSoTimeout(socketTimeOut);
		connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
		connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
		client = new HttpClient(connectionManager);
	}

	/**
	 * POST方式提交数据
	 * 
	 * @param url
	 *            待请求的URL
	 * @param params
	 *            要提交的数据
	 * @param enc
	 *            编码
	 * @return 响应结果
	 * @throws IOException
	 *             IO异常
	 */
	public static String URLPost(String url, Map<String, String> params, String enc) {

		String response = EMPTY;
		PostMethod postMethod = null;
		try {
			System.out.println(url);
			postMethod = new PostMethod(url);
			if (org.apache.commons.lang3.StringUtils.isBlank(enc))
				enc = "UTF-8";
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
			if (params != null && params.size() > 0) {
				// 将表单的值放入postMethod中
				Set<String> keySet = params.keySet();
				for (String key : keySet) {
					String value = params.get(key);
					postMethod.addParameter(key, value);
				}
			}
			// 执行postMethod
			int statusCode = client.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK) {
				response = postMethod.getResponseBodyAsString();
			} else {
				log.error("响应状态码 = " + postMethod.getStatusCode());
			}
		} catch (HttpException e) {
			log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("发生网络异常", e);
			e.printStackTrace();
		} finally {
			if (postMethod != null) {
				postMethod.releaseConnection();
				postMethod = null;
			}
		}

		return response;
	}
	/**
	 * GET方式提交数据
	 * 
	 * @param url
	 *            待请求的URL
	 * @param params
	 *            要提交的数据
	 * @param enc
	 *            编码
	 * @return 响应结果
	 * @throws IOException
	 *             IO异常
	 */
	public static String URLGet(String url, Map<String, String> params, String enc) {

		String response = EMPTY;
		GetMethod getMethod = null;
		StringBuffer strtTotalURL = new StringBuffer(EMPTY);
		if (org.apache.commons.lang3.StringUtils.isBlank(enc))
			enc = "UTF-8";
		if (params != null && params.size() > 0) {
			if (strtTotalURL.indexOf("?") == -1) {
				strtTotalURL.append(url).append("?").append(getUrl(params, enc));
			} else {
				strtTotalURL.append(url).append("&").append(getUrl(params, enc));
			}
		}
//		System.out.println("GET请求URL = \n" + strtTotalURL.toString());
		log.info("GET请求URL = \n" + strtTotalURL.toString());

		try {
			getMethod = new GetMethod(strtTotalURL.toString());
			getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
			getMethod.setRequestHeader("Cookies", "Cookie: __jsluid=a2167f290379dd757cace6089462b307; JSESSIONID=YhZ2X6RGbMh5Fl8yL1jhJqg2JvdyNTGWWbjL77gl2W11kLdvkhJL!1864892220");
			// 执行getMethod
			int statusCode = client.executeMethod(getMethod);
			if (statusCode == HttpStatus.SC_OK) {
				response = getMethod.getResponseBodyAsString();
			} else {
				log.debug("响应状态码 = " + getMethod.getStatusCode());
			}
		} catch (HttpException e) {
			log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("发生网络异常", e);
			e.printStackTrace();
		} finally {
			if (getMethod != null) {
				getMethod.releaseConnection();
				getMethod = null;
			}
		}
		log.info(response);
		return response;
	}
	/**
	 * 据Map生成URL字符串
	 * 
	 * @param map
	 *            Map
	 * @param valueEnc
	 *            URL编码
	 * @return URL
	 */
	private static String getUrl(Map<String, String> map, String valueEnc) {

		if (null == map || map.keySet().size() == 0) {
			return (EMPTY);
		}
		StringBuffer url = new StringBuffer();
		Set<String> keys = map.keySet();
		for (Iterator<String> it = keys.iterator(); it.hasNext();) {
			String key = it.next();
			if (map.containsKey(key)) {
				String val = map.get(key);
				if (org.apache.commons.lang3.StringUtils.isBlank(val) || val.equals("null")||"undefined".equals(val))
					continue;
				try {
					val = URLEncoder.encode(val, valueEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				url.append(key).append("=").append(val).append(URL_PARAM_CONNECT_FLAG);
			}
		}
		String strURL = EMPTY;
		strURL = url.toString();
		if (URL_PARAM_CONNECT_FLAG.equals(EMPTY + strURL.charAt(strURL.length() - 1))) {
			strURL = strURL.substring(0, strURL.length() - 1);
		}
		return (strURL);
	}

	/**
	 * 创建一个简单json串
	 */
	public static String createSimpleJson(Integer code,String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", code);
		map.put("message", message);
		return JSON.toJSONString(map).toString();
	}

	/**
	 * 创建一个简单json串
	 */
	public static String createSimpleJson(Integer code,String message,String result) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", code);
		map.put("message", message);
		map.put("result", result);
		return JSON.toJSONString(map).toString();
	}

	public static void main(String[] args) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("userid", "404311");
		System.out.println(URLGet("http://114.215.207.144:8085/midx/user/getInvestAccount", map, null));
	}
}