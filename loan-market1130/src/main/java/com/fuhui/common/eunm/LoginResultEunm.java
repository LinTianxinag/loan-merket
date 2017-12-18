package com.fuhui.common.eunm;

/**
 * Created by Ren on 2017/6/6.
 */
public enum LoginResultEunm implements EnumMessage {

    success(0, "登录成功"),
    mobileError(1,"请输入正确的手机号"),
    passwordFormatError(2,"密码格式不正确"),
    mobileOrPasswordError(3,"手机号或密码错误"),
    LOGOUT_SUCCESS(4,"退出登录成功"),
    LOGIN_USER_NULL(5,"您暂未登录"),
    COMMIT_IS_NULL(6,"提交的内容不能为空"),
    COMMIT_SUCCESS(7,"提交成功"),
    COMMIT_ERROR(8,"系统繁忙"),
    SESSION_LOST(9,"登录已过期"),
    PWD_HAVE_OTHER(10,"请输入6位数字密码")

    ;

    private final Integer _code;
    private final String _message;

    LoginResultEunm(Integer code, String message) {
        _code = code;
        _message = message;
    }

    @Override
    public Integer getValue()
    {
        return _code;
    }

    @Override
    public String getMessage()
    {
        return _message;
    }

    public String getJsonMessage() {
        return "{\"result_code\":" + _code + ",\"result\":{\"message\":\"" + _message + "\"}}";
    }

    public static String getMessage(Integer code) {
        for (RequestGateWayStatus status : RequestGateWayStatus.values()) {
            if (status.getValue().equals(code)) {
                return status.getMessage();
            }
        }
        return code + "";
    }
}
