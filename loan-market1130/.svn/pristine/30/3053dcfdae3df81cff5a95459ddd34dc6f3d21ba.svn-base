package com.fuhui.service;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.common.entity.QueryCondition;
import com.fuhui.mybatis.generator.model.Platform;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

/**
 *  平台操作（平台的添加及变更）
 * Created by Ren
 * time:2017/12/4.13:17
 */
public interface ManPlaService {

    /**
     * 获取平台列表
     * @param req
     * @param model
     * @param queryCondition
     * @return
     * @throws ParseException
     */
    List<Platform> getPlaList(HttpServletRequest req, ModelAndView model, QueryCondition queryCondition) throws ParseException;


    int cancelPla(HttpServletRequest req, ModelAndView model, Platform platform);
    /**
     * 增加平台信息
     * @param request
     * @param response
     * @return
     */
    boolean addPlatForm(HttpServletRequest request, HttpServletResponse response);

    /**
     * 平台的名称的检测
     * @param request
     * @param response
     * @return
     */
    JSONObject checkPlatName(HttpServletRequest request, HttpServletResponse response);

    /**
     * 获取平台的详情信息
     * @param i
     * @return
     */
    Platform getPlatFormById(int i);

    /**
     * 获取平台的计数
     * @param request
     * @param response
     * @return
     */
    JSONObject getPlaListCount(HttpServletRequest request, HttpServletResponse response);


    /**
     * 更新平台的信息
     * @param request
     * @param response
     * @return
     */
    boolean updatePlatForm(HttpServletRequest request, HttpServletResponse response);

    /**
     * 平台下架的方法
     * @param request
     * @param response
     * @return
     */
    JSONObject doPlatDown(HttpServletRequest request, HttpServletResponse response);

    /**
     * 平台上架的方法
     * @param request
     * @param response
     * @return
     */
    JSONObject doPlatUpIt(HttpServletRequest request, HttpServletResponse response);
}
