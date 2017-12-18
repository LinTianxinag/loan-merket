package com.fuhui.common.util;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private HashMap map;

    public Result() {

        map = new HashMap();
    }

    public Result Add(String key, Object value) {
        map.put(key, value);
        return this;
    }
    public Result Add(JSONObject object) {
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public Result Add(HashMap<String, Object> result) {
        if(result!=null)
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public HashMap Success() {
        return map;
    }

    public HashMap Error(String msg) {
        map.put("error", msg);
        return map;
    }

    public HashMap Error(int code, String msg) {
        map.put("error", msg);
        map.put("errorcode", code);
        return map;
    }


    public Result page(PageInfo page) {
        map.put("pageno", page.getPageNum());
        map.put("pagesize", page.getPageSize());
        map.put("total", page.getTotal());
        map.put("list", page.getList());
        return this;
    }

    public Object notNullResult(Object result){
        return result==null?"{}":result;
    }

}
