package com.fuhui.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.annoation.ManLoginCheck;
import com.fuhui.common.eunm.ErrorStatusEunm;
import com.fuhui.common.util.*;
import com.fuhui.mybatis.generator.model.Platform;
import com.fuhui.mybatis.sys.model.SysUser;
import com.fuhui.service.ManLoginService;
import com.fuhui.service.ManPlaService;
import com.fuhui.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : xufanglong
 * @Description:后台管理 登录、注册、登出
 * @Date: create in 16:25 2017/11/30
 * @Modified By:
 */
@RestController
public class ManLoginController {
    @Autowired
    private ManLoginService loginService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private ManPlaService manPlaService;

    /**
     * 后台管理的首页展示
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView ManageIndex(HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }


    /**
     * 后台管理的发短信的验证，有注册用户才能发
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/mansms")
    public JSONObject IndexSendSmsCheck(HttpServletRequest request,HttpServletResponse response){
        JSONObject object=new JSONObject();
        String mobile=request.getParameter("mobile");

        String type=request.getParameter("type");
        SysUser sysUser=loginService.getAdminByMobile(mobile);
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(mobile);
        if(!m.matches()){
            object.put("status",105);
            object.put("msg","手机号码错误了");
            return object;
        }
        if(null==sysUser || "".equals(sysUser)){
            object.put("status",106);
            object.put("msg","暂无该管理员");
            return object;
        }else{
            //发送成功，则内部跳转
            try {
                String returninfo= smsService.SmsCheck(request,response);
                JSONObject object1= JSONObject.parseObject(returninfo);
                return object1;
            }catch(Exception e){
                e.printStackTrace();
                object.put("status",-1);
                object.put("msg","系统错误，稍后重试");
                return object;
            }
        }
    }



    /**
     * 后台管理加载后的管理页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/home")
    @ManLoginCheck
    public ModelAndView ManageHome(HttpServletRequest request,HttpServletResponse response,ModelAndView modelAndView){
        String userId=RedisUtil.get(Constants.WEB_SESSION + request.getSession().getId());
        String mobile=RedisUtil.get(Constants.ADMIN_MOBILE + request.getSession().getId());
        if(null==mobile){
             modelAndView=new ModelAndView("index");
        }else{
             modelAndView=new ModelAndView("home");
            modelAndView.addObject("mobile",mobile);
        }
        return modelAndView;
    }

    /**
     * 后台管理加载后的管理页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/platformList")
    @ManLoginCheck
    public ModelAndView platformList(HttpServletRequest request,HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("platformList");
        String mobile=RedisUtil.get(Constants.ADMIN_MOBILE + request.getSession().getId());
        modelAndView.addObject("mobile",mobile);
        return modelAndView;
    }


    /**
     * 平台新增的页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/addplat")
    @ManLoginCheck
    public ModelAndView ManagePlatformAdd(HttpServletRequest request,HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("platformadd");
        String mobile=RedisUtil.get(Constants.ADMIN_MOBILE + request.getSession().getId());
        modelAndView.addObject("mobile",mobile);
        return modelAndView;
    }

    /**
     * 平台详情
     * @return
     */
    @RequestMapping("/platdetails")
    @ManLoginCheck
    public ModelAndView platFormDetails(HttpServletRequest request,HttpServletResponse response){
        String mobile=RedisUtil.get(Constants.ADMIN_MOBILE + request.getSession().getId());
        String platid=request.getParameter("platid");
        Platform platform=manPlaService.getPlatFormById(Integer.parseInt(platid));
        ModelAndView modelAndView=new ModelAndView("platdetails");
        modelAndView.addObject("platform",platform);
        modelAndView.addObject("mobile",mobile);
        return modelAndView;
    }

    /**
     * 平台详情
     * @return
     */
    @RequestMapping("/platcheck")
    @ManLoginCheck
    public ModelAndView platFormChecks(HttpServletRequest request,HttpServletResponse response){
        String mobile=RedisUtil.get(Constants.ADMIN_MOBILE + request.getSession().getId());
        String platid=request.getParameter("platid");
        Platform platform=manPlaService.getPlatFormById(Integer.parseInt(platid));
        ModelAndView modelAndView=new ModelAndView("platchecks");
        modelAndView.addObject("platform",platform);
        modelAndView.addObject("mobile",mobile);
        return modelAndView;
    }




    /**
     * 后台管理的登陆
     * @param req
     * @param res
     * @return
     */
    @PostMapping("/login")
    public Object ManageLogin(HttpServletRequest req, HttpServletResponse res, SysUser sysUser,RedirectAttributes attr,ModelAndView modelAndView) throws IOException {
       return loginService.checkAdmin(req,res,modelAndView,sysUser);
    }

    /**
     * 管理后台退出登录
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    @ManLoginCheck
    public String ManLogOut(HttpServletRequest req,HttpServletResponse res){
        loginService.logout(req);
        return ResultUtil.getJsonResult("200","已退出");
    }
    @RequestMapping("/register")
    public ModelAndView ManRegister(HttpServletRequest req,HttpServletResponse res,SysUser sysUser){
        ModelAndView model = new ModelAndView();
        /** 手机号码格式判断 */
        if(sysUser.getMobile() == null || !RegExpUtil.checkMobileType(sysUser.getMobile())) {

        }
//        loginService
        return model;
    }

}
