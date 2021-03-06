package com.fuhui.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.annoation.ApiCheck;
import com.fuhui.annoation.LoginCheck;
import com.fuhui.common.config.Constants;
import com.fuhui.common.eunm.ErrorStatusEunm;
import com.fuhui.common.util.RedisUtil;
import com.fuhui.common.util.ResultUtil;
import com.fuhui.mybatis.generator.dao.FhUserMapper;
import com.fuhui.mybatis.generator.model.FhUser;
import com.fuhui.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : xufanglong
 * @Description:登录，登出，注册，获取验证码等功能写在此处
 * @Date: create in 16:22 2017/11/30
 * @Modified By:
 */
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private FhUserMapper fhUserMapper;

    /**
     * 这是APP的验签错误的返回信息
     * @param request
     * @param response
     * @return
     */
    @GetMapping ("/err")
    public JSONObject errResult(HttpServletRequest request,HttpServletResponse response){
        JSONObject object =new JSONObject();
        object.put("status", 100);
        object.put("msg","APP验签不通过");
        return object;
    }


    /**
     * 登陆注解验证，不通过返回以下错误
     * @param request
     * @return
     */
    @GetMapping("/relogin")
    public JSONObject pleaseReLogin(HttpServletRequest request,HttpServletResponse response){
        JSONObject object=new JSONObject();
        object.put("status", 100);
        object.put("msg","登录已过期，请重新登陆");
        return object;
    }


    /**
     * 判断号码是否已经注册
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/isexist")
    public String mobileISExist(HttpServletRequest request,HttpServletResponse response){
        String mobile=request.getParameter("mobile");
        FhUser fhUser=fhUserMapper.selectByMobile(mobile);
        if(null !=fhUser ){
            return ResultUtil.getJsonResult(ErrorStatusEunm.HAVEREG.getValue(),ErrorStatusEunm.HAVEREG.getMessage());
        }else{
            return ResultUtil.getJsonResult(ErrorStatusEunm.SUCCESS_CODE.getValue(),ErrorStatusEunm.SUCCESS_CODE.getMessage());
        }
    }



    /**
     * app请求，注册方法，并带app验签
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/regist")
//    @ApiCheck
    public String appRegister(HttpServletRequest request, HttpServletResponse response){
        JSONObject obj=new JSONObject();
        String mobile=request.getParameter("mobile");
        String password=request.getParameter("password");
        String code=request.getParameter("code");
        return loginService.checkRegist(request,mobile,password,code);

    }
    /**
     * app登陆
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
//    @ApiCheck
    public String appLogin(HttpServletRequest request, HttpServletResponse response){
        return loginService.checkLogin(request,response);
    }


    @PostMapping("/resetpwd")
//    @ApiCheck
    public String appResetPwd(HttpServletRequest request,HttpServletResponse response){
        return loginService.reSetPwd(request,response);
    }

    /**
     * app退出登录
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/logout")
//    @ApiCheck
//    @LoginCheck
    public JSONObject appLogOut(HttpServletRequest request,HttpServletResponse response){
        JSONObject obj=new JSONObject();
        RedisUtil.del(Constants.APP_SESSION + request.getSession().getId());
        obj.put("status",200);
        obj.put("msg","退出登录成功");
        return obj;
    }


}
