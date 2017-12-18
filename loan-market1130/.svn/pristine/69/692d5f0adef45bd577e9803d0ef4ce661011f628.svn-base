package com.fuhui.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * package name:com.fuhui.controller
 *
 * @author:panwang
 * @description: ${todo}(用一句话描述该文件做什么)
 * @date:2017/11/27
 * @version:V1.0
 * @see:jdk8 Copyright (c) 2017, mikuismywifu@gmail.com All Rights Reserved.
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/test")
    public JSONObject test () {
        JSONObject object =new JSONObject();
        object.put("dasd","11");
        object.put("113",2131);
        return object;
    }


}
