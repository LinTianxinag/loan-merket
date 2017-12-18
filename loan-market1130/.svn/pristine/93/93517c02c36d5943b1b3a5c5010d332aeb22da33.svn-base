package com.fuhui.common.eunm;

import java.util.stream.Stream;

/**
 * @author : xufanglong
 * @Description:这是沃动短信的发送的模板
 * @Date: create in 13:41 2017/12/1
 * @Modified By:
 */
public enum  WodongEunm implements EnumMessage{

    WD_REGISTER(0,"尊敬的用户，您申请的注册验证码是: #code#，如非本人操作，请忽略本短信。"),
    WD_FORGET(1,"尊敬的用户，本次密码找回，您的验证码是: #code#，请勿告知他人"),
    WD_MANLOGIN(5,"尊敬的管理员，您的登录验证码是：#code#，有效期为两分钟，请尽快使用")
    ;

    private final Integer _code;
    private final String _message;

    WodongEunm(Integer code, String message) {
        _code = code;
        _message = message;
    }

    @Override
    public Integer getValue() {
        return _code;
    }

    @Override
    public String getMessage() {
        return _message;
    }

    public static boolean booleanMessage(Integer code) {
        return Stream.of(WodongEunm.values()).anyMatch((s -> s.getValue().equals(code)));
    }


    public static String getMessage(Integer code) {
        for (WodongEunm status : WodongEunm.values()) {
            if (status.getValue().equals(code)) {
                return status.getMessage();
            }
        }
        return code + "";
    }
}
