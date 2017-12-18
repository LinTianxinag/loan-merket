package com.fuhui.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.annoation.ManLoginCheck;
import com.fuhui.common.entity.QueryCondition;
import com.fuhui.common.util.Constants;
import com.fuhui.common.util.RedisUtil;
import com.fuhui.common.util.ResultUtil;
import com.fuhui.mybatis.sys.model.SysUser;
import com.fuhui.service.ManLoginService;
import com.fuhui.service.ManUserService;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Ren
 * @Description:后台管理——用户管理
 * @Date: create in 16:25 2017/12/4
 * @Modified By:
 */
@RestController
public class ManUserController {
    @Autowired
    private ManUserService manUserService;

    private final static org.slf4j.Logger log = LoggerFactory.getLogger("RollingFile");
//    private static Logger logger = Logger.getLogger(Test.class);

    /**
     * 用户的列表的展示页面
     * @param req
     * @param res
     * @param queryCondition
     * @return
     */
    @RequestMapping("/userlist")
    public ModelAndView ManangeUserList(HttpServletRequest req,HttpServletResponse res, QueryCondition queryCondition) throws ParseException {
        ModelAndView model=new ModelAndView("userlist");
        manUserService.getFhUserList(req,model,queryCondition);
        String mobile= RedisUtil.get(Constants.ADMIN_MOBILE + req.getSession().getId());
        model.addObject("mobile",mobile);
        return model;
    }

    /**
     * 用户的列表的展示页面(条件筛选查询)
     * @param req
     * @param res
     * @param queryCondition
     * @return
     */
    @RequestMapping("/finduserlist")
    @ManLoginCheck
    @ResponseBody
    public Object FindManangeUserList(HttpServletRequest req,HttpServletResponse res, QueryCondition queryCondition) throws ParseException {
        ModelAndView model = new ModelAndView();
        JSONObject obj = new JSONObject();
        manUserService.getFhUserList(req,model,queryCondition);
        obj.put("err",model.getModel().get("err"));
        obj.put("errcode",model.getModel().get("errcode"));
        obj.put("size",model.getModel().get("size"));
        obj.put("total",model.getModel().get("total"));
        obj.put("count",model.getModel().get("count"));
        obj.put("currentPage",model.getModel().get("currentPage"));
        obj.put("list",model.getModel().get("list"));
        return obj;
    }
    /**
     * 用户的平台浏览记录的展示页面
     * @param req
     * @param res
     * @param queryCondition
     * @return
     */
    @RequestMapping("/userdetails")
    public ModelAndView ManangeUserDetails(HttpServletRequest req,HttpServletResponse res, QueryCondition queryCondition) throws ParseException {
        ModelAndView model=new ModelAndView("userdetails");
        manUserService.getFhUserBrowseDetailsList(req,model,queryCondition);
        String mobile= RedisUtil.get(Constants.ADMIN_MOBILE + req.getSession().getId());
        model.addObject("mobile",mobile);
        return model;
    }

    /**
     * 用户的平台浏览记录的展示页面(条件筛选查询)
     * @param req
     * @param res
     * @param queryCondition
     * @return
     */
    @RequestMapping("/finduserdetails")
    @ResponseBody
    public Object FindManangeUserDetails(HttpServletRequest req,HttpServletResponse res, QueryCondition queryCondition) throws ParseException {
        ModelAndView model = new ModelAndView();
        JSONObject obj = new JSONObject();
        manUserService.getFhUserBrowseDetailsList(req,model,queryCondition);
        obj.put("total",model.getModel().get("total"));
        obj.put("list",model.getModel().get("list"));
        obj.put("page",model.getModel().get("page"));
        obj.put("user",model.getModel().get("user"));
        return obj;
    }


    /**
     * 管理用户的列表的展示页面
     * @param req
     * @param res
     * @param queryCondition
     * @return
     */
    @RequestMapping("/admincenter")
    @ManLoginCheck
    public ModelAndView ManSysUserList(HttpServletRequest req,HttpServletResponse res, QueryCondition queryCondition) throws ParseException {
        ModelAndView model=new ModelAndView("admincenter");
        manUserService.getFhSysUserList(req,model,queryCondition);
        String mobile= RedisUtil.get(Constants.ADMIN_MOBILE + req.getSession().getId());
        model.addObject("mobile",mobile);
        return model;
    }
    /**
     * 管理用户的列表的展示页面
     * @param req
     * @param res
     * @param sysUser
     * @return
     */
    @RequestMapping("/addSysUser")
    @ManLoginCheck
    public ModelAndView addManSysUserView(HttpServletRequest req, HttpServletResponse res, SysUser sysUser) throws ParseException {
        ModelAndView model=new ModelAndView("addsysuser");
        String mobile= RedisUtil.get(Constants.ADMIN_MOBILE + req.getSession().getId());
        model.addObject("mobile",mobile);
        return model;
    }
    /**
     * 管理用户的列表的展示页面
     * @param req
     * @param res
     * @param sysUser
     * @return
     */
    @RequestMapping("/addSysUserDate")
    @ManLoginCheck
    public Object addManSysUser(HttpServletRequest req, HttpServletResponse res, SysUser sysUser) throws ParseException {
        String roleId=req.getParameter("roleId");
        sysUser.setRoleId(Integer.parseInt(roleId));
        sysUser.setLastIp(req.getRemoteAddr());
        ModelAndView model = new ModelAndView("redirect:admincenter");
        String mobile= RedisUtil.get(Constants.ADMIN_MOBILE + req.getSession().getId());
        Map map = manUserService.addSysUser(sysUser);
        if((int)map.get("status")==1){
            return model;
        }else{
            model = new ModelAndView("addsysuser");
            model.addObject("status",0);
            return model;
        }

    }

    /**
     *管理用户的列表的展示页面(条件筛选查询)
     * @param req
     * @param res
     * @param queryCondition
     * @returneditSysUser
     */
    @RequestMapping("/FindSysUserList")
    @ResponseBody
    public Object FindManSysUserList(HttpServletRequest req,HttpServletResponse res, QueryCondition queryCondition) throws ParseException {
        return manUserService.getFhSysUserListPager(req, queryCondition);
    }

    /**
     *管理用户的列表的展示页面(条件筛选查询)
     * @param req
     * @param res
     * @param queryCondition
     * @returneditSysUser
     */
    @RequestMapping("/editSysUser")
    @ManLoginCheck
    public Object editSysUser(HttpServletRequest req,HttpServletResponse res, QueryCondition queryCondition) throws ParseException {
        return manUserService.editSysUser(req, queryCondition);

    }


}
