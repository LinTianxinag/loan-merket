package com.fuhui.common.config;

/**
 * 常量表
 */
public final class Constants {
	/**
	 * 异常信息统一头信息<br>
	 * 非常遗憾的通知您,程序发生了异常
	 */
	public static final String Exception_Head = "OH,MY GOD! SOME ERRORS OCCURED! AS FOLLOWS :";
	/** 客户端语言 */
	public static final String USERLANGUAGE = "userLanguage";
	/** 客户端主题 */
	public static final String WEBTHEME = "webTheme";
	/** 当前用户 */
	public static final String CURRENT_USER = "CURRENT_USER";
	/** 在线用户数量 */
	public static final String ALLUSER_NUMBER = "ALLUSER_NUMBER";
	/** 登录用户数量 */
	public static final String USER_NUMBER = "USER_NUMBER";

	public static final String PREREQUEST = "PREREQUEST";

	public static final String PREREQUEST_TIME = "PREREQUEST_TIME";

	public static final String PREREQUEST_RESULT = "PREREQUEST_RESULT";

	public static final String MALICIOUS_REQUEST_TIMES = "MALICIOUS_REQUEST_TIMES";
	/** pc端session */
	public static final String WEB_SESSION = "web_session:id";
	/** app端session */
	public static final String APP_SESSION = "app_session";
	/** 目前量不大，暂时不区分储存短信类型 */
	public static final String SMS_CODE = "sms_code";
	/** 验证码下发次数（浏览器session） */
	public static final String SEND_SMS_SESSION_COUNT = "send_sms_session_count";
	/** 验证码下发次数（ip） */
	public static final String SEND_SMS_IP_COUNT = "send_sms_ip_count";
	/** 验证码下发次数（userid） */
	public static final String SEND_SMS_USERID_COUNT = "send_sms_userid_count";
	/**获取验证码时存入手机号*/
	public static final String PHONE_NUMBER="phone_number";

}
