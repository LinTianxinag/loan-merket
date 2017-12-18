package com.fuhui.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ren
 * time:2017/12/1.16:00
 * 登录、注册、忘记密码
 */
public interface LoginService {

    /**
     * 注册的验证
     * @param request
     * @param mobile
     * @param password
     * @param code
     * @return
     */
    String checkRegist(HttpServletRequest request,String mobile, String password, String code);


    /**
     * 登陆的验证
     * @param request
     * @param response
     * @return
     */
    String checkLogin(HttpServletRequest request, HttpServletResponse response);

    /**
     * 重设密码
     * @param request
     * @param response
     * @return
     */
    String reSetPwd(HttpServletRequest request, HttpServletResponse response);
}
