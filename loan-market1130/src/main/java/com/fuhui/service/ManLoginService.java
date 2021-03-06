package com.fuhui.service;

import com.fuhui.mybatis.sys.model.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author : xufanglong
 * @Description:
 * @Date: create in 16:22 2017/12/2
 * @Modified By:
 */
public interface ManLoginService {

    /**
     * 检查登录
     * @param req
     * @param model
     * @param sysUser
     * @return
     */
    Object checkAdmin(HttpServletRequest req, HttpServletResponse res, ModelAndView modelAndView, SysUser sysUser);

    /**
     * 退出登录
     * @param req
     * @return
     */
    void logout(HttpServletRequest req);

    /**
     * 管理员注册
     * @param req
     * @param model
     * @param sysUser
     * @return
     */
    SysUser adminRegister(HttpServletRequest req, ModelAndView model, SysUser sysUser);

    /**
     * 多条件查询管理员
     * @param sysUser
     * @return
     */
    List<SysUser> getAdminList(SysUser sysUser);

    /**
     * 通过手机号获取管理员的信息
     * @param mobile
     * @return
     */
    SysUser getAdminByMobile(String mobile);

}
