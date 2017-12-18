package com.fuhui.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class CommonUtil {


    public static Map<String, String> parseMap(Object a) {
        Map<String, String> map = new HashMap<String, String>();
        JSONObject json = JSON.parseObject(JSON.toJSONString(a));
        for (Entry<String, Object> entry : json.entrySet()) {
            if (entry.getValue() != null)
                map.put(entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    public static <T> T parseObject(Map<String, String> map, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }

    public static String md5PWD(String pwd) {
        if (pwd == null) return null;
        return DigestUtils.md5DigestAsHex(pwd.getBytes()).substring(10, 20);
    }

}
