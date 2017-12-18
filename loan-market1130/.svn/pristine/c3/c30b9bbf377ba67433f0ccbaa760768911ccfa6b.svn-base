package com.fuhui.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.annoation.LoginCheck;
import com.fuhui.mybatis.generator.dao.FhUserMapper;
import com.fuhui.service.ApiService;
import com.fuhui.service.PlatformBrowsingHistoryService;
import com.fuhui.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : xufanglong
 * @Description:这是app接口的逻辑部分展示
 * @Date: create in 14:47 2017/12/11
 * @Modified By:
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;
    @Autowired
    private UserService userService;
    @Autowired
    private PlatformBrowsingHistoryService platformBrowsingHistoryService;



    /**
     * 获取用户的详情信息
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/userinfo")
    @LoginCheck
    public JSONObject userDetails(HttpServletRequest request,HttpServletResponse response){
        return userService.getUserInfo(request,response);
    }

    @PostMapping("/browhis")
    @LoginCheck
    public JSONObject userBrowseHis(HttpServletRequest  request,HttpServletResponse response){
        return  platformBrowsingHistoryService.getUserBrowseHis(request,response);
    }

    /**
     * 用户添加详情信息
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/add")
    @LoginCheck
    public JSONObject userAddInfo(HttpServletRequest request,HttpServletResponse response){
        return userService.addUserInfo(request,response);
    }

    /**
     * 增加浏览次数
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/addtimes")
    @LoginCheck
    public JSONObject addBrowseTimes(HttpServletRequest request,HttpServletResponse response){
        return platformBrowsingHistoryService.addBrowseTimes(request,response);
    }


    /**
     * 首页展示贷款平台，显示后台勾选“在首页展示”的借款平台
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/homedisplay")
    public JSONObject homeDisPlay(HttpServletRequest request, HttpServletResponse response){
        return apiService.getHomeDisplays(request,response);
    }


    /**
     * 用户现金贷列表的信息
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/showlist")
    public JSONObject showLoanList(HttpServletRequest request,HttpServletResponse  response){
        return apiService.getLoanList(request,response);
    }


    /**
     * 获取借款的详情的信息
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/loandetails")
    public JSONObject loanGetDetails(HttpServletRequest request,HttpServletResponse response){
        return  apiService.getLoanDetail(request,response);
    }



}
