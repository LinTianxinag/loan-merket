package com.fuhui.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.common.util.*;
import com.fuhui.mybatis.sys.dao.SysUserMapper;
import com.fuhui.mybatis.sys.model.SysUser;
import com.fuhui.service.ManLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : xufanglong
 * @Description:后台管理的方法
 * @Date: create in 16:22 2017/12/2
 * @Modified By:
 */
@Service
public class ManLoginServiceImpl implements ManLoginService {

    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 验证登陆
     * @return
     */
    @Override
    public Object checkAdmin(HttpServletRequest req, HttpServletResponse res, ModelAndView model, SysUser sysUser) {
        JSONObject object=new JSONObject();
        JSONObject results = checkSysUser(req,sysUser);
        if(Integer.parseInt(results.get("status").toString())!=200){
            return results;
        }
        sysUser.setUserPwd(MD5.GetMD5Code(MD5.GetMD5Code(sysUser.getUserPwd())+sysUser.getMobile()));
        List<SysUser> users = sysUserMapper.selectUsers(sysUser);
        SysUser user = null;
        if(users.size() == 1){user = users.get(0);}
        if(user != null){

            if(user.getUserStatus()==0){
                object.put("status",103);
                object.put("msg","该账户已被禁用，请联系管理员");
                return object;
            }
            //更新用户当前的物理位置
            String ip=getIpUtil.getIP(req);
            user.setLastIp(ip);
            sysUserMapper.updateByPrimaryKey(user);

            RedisUtil.set(Constants.WEB_SESSION + req.getSession().getId(),24 * 60 * 60,sysUser.getUserId());
            RedisUtil.set(Constants.ADMIN_MOBILE + req.getSession().getId(),24 * 60 * 60,Long.parseLong(sysUser.getMobile()));
            try{
                res.sendRedirect("/home");
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            object.put("status",100);
            object.put("msg","账号未注册");
            return object;
        }
        return null;
    }

    @Override
    public SysUser adminRegister(HttpServletRequest req, ModelAndView model, SysUser sysUser) {
        return null;
    }

    /**
     * 退出登录
     * @param req
     */
    @Override
    public void logout(HttpServletRequest req) {
        RedisUtil.del(Constants.APP_SESSION + req.getSession().getId());
        return;
    }

    /**
     * 获取管理员列表
     * @param sysUser
     * @return
     */
    @Override
    public List<SysUser> getAdminList(SysUser sysUser) {

        return null;
    }

    /**
     * 通过手机号获取管理员的信息
     * @param mobile
     * @return
     */
    @Override
    public SysUser getAdminByMobile(String mobile) {
        SysUser user=sysUserMapper.selectByMobile(mobile);
        return user;
    }


    private JSONObject checkSysUser(HttpServletRequest req,SysUser sysUser){

        JSONObject object=new JSONObject();
        String code=req.getParameter("code");
        String checkcode = RedisUtil.get(Constants.SMS_CODE + req.getSession().getId());

        if(sysUser.getMobile() == null || !RegExpUtil.checkMobileType(sysUser.getMobile())) {
            object.put("status",101);
            object.put("msg","账户格式不正确");
        }
        else if(sysUser.getUserPwd() == null || !RegExpUtil.checkPwdType(sysUser.getUserPwd())) {
            object.put("status",101);
            object.put("msg","密码格式不正确");
        }
//        else if(checkcode == null || !checkcode.equals('"'+code+'"')){
//            object.put("status",102);
//            object.put("msg","验证码错误");
//        }
        else{
            object.put("status",200);
            object.put("msg","成功");
        }
        return object;

    }
}
