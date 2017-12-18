package com.fuhui.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Name:dubbo-aalc
 * File Name:${FILE_NAME}
 * Package:com.anganglicai.core.util
 *
 * @author:panwang
 * @description: ${todo}(用一句话描述该文件做什么)
 * @date:2017/6/6
 * @version:V1.0
 * @see:jdk7 Copyright (c) 2017, mikuismywifu@gmail.com All Rights Reserved.
 */
public class ResultUtil {

    /**
     * @title 定义基础返回值
     * @description
     * @author:panwang
     * @email:mikuismywifu@gmail.com
     * @see:jdk7
     *
     * @param res 返回code
     * @param msg 返回详情
     * @return
     */
    public static String getJsonResult(Object res, Object msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", res);
        map.put("msg", msg);
        return JSON.toJSONString(map);
    }



    public static String getJsonResult(Object res, Object msg,Object session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", res);
        map.put("message", msg);
        map.put("session",session);
        return JSON.toJSONString(map);
    }

    public static String getJsonResult(Object res, Object msg,Object session,String url) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", res);
        map.put("message", msg);
        map.put("session",session);
        map.put("url",url);
        return JSON.toJSONString(map);
    }
//    public static String Add(JSONObject object) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        for (Map.Entry<String, Object> entry : object.entrySet()) {
//            map.put(entry.getKey(), entry.getValue());
//        }
//        return "";
//    }
}
