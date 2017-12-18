package com.fuhui.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : xufanglong
 * @Description:
 * @Date: create in 10:23 2017/12/12
 * @Modified By:
 */
public interface UserService {

    /**
     * 获取用户的详情的信息
     * @return
     */
    JSONObject getUserInfo(HttpServletRequest request, HttpServletResponse response);

    /**
     * 添加完善用户的信息
     * @return
     */
    JSONObject addUserInfo(HttpServletRequest request, HttpServletResponse response);
}
