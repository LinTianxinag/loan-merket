package com.fuhui.common.util;

import java.util.regex.Pattern;

/**
 * 正则工具类
 * Created by Ren
 * time:2017/6/27.10:59
 */
public final class RegExpUtil {
    private RegExpUtil(){
    }
    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     *<p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
     *、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
     *<p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
     *<p>电信的号段：133、153、180（未启用）、189</p>
     * */
    public static final String CHECKMOBILETYPE = "(\\+\\d+)?1[34578]\\d{9}$";

    /**
     * 密码长度需要大于或等于6位
     */
    public static final String CHECKPWD = "\\S{6,}";

    /**
     * 身份证长度验证
     */
    public static final String IDCARDSIZE15 = "\\d{15}";
    public static final String IDCARDSIZE17 = "\\d{17}\\w";
    /**
     * 银行卡号长度验证
     */
    public static final String BANKCARDSIZE = "\\d{12,19}";
    /**
     * 姓名格式认证
     */
//    public static final String REALNAME = "^([\\u4e00-\\u9fa5]+|([a-z]+\\s?)+)$";
    public static final String REALNAME = "[\\u4E00-\\u9FA5]{2,5}(?:·[\\u4E00-\\u9FA5]{2,5})*";

    /**
     * 姓名格式认证
     * @param realname
     * @return
     */
    public static boolean checkRealname(String realname){return Pattern.matches(REALNAME,realname);}
    /**
     * @param pwd   验证密码长度
     * @return
     */
    public static boolean checkPwdType(String pwd) {
        return Pattern.matches(CHECKPWD,pwd);
    }
    /**
     * @param mobile 移动、联通、电信运营商的号码段
     * @return
     */
    public static boolean checkMobileType(String mobile) {
        return Pattern.matches(CHECKMOBILETYPE,mobile);
    }

    /**
     *
     * @param idCard 验证身份证长度
     * @return
     */
    public static boolean checkIdCardSize(String idCard) {
        return (Pattern.matches(IDCARDSIZE15,idCard)||Pattern.matches(IDCARDSIZE17,idCard));
    }

    /**
     *
     * @param bankCard 银行卡号
     * @return
     */
    public static boolean checkBankCardSize(String bankCard){
        return Pattern.matches(BANKCARDSIZE,bankCard);
    }
}
