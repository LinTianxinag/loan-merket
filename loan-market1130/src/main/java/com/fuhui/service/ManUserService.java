package com.fuhui.service;

import com.fuhui.common.entity.QueryCondition;
import com.fuhui.mybatis.generator.model.FhUser;
import com.fuhui.mybatis.generator.model.PlatformBrowsingHistory;
import com.fuhui.mybatis.sys.model.SysUser;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 *  用户信息业务操作
 * Created by Ren
 * time:2017/12/4.13:17
 */
public interface ManUserService {
    /**
     * 获取用户列表
     * @param req
     * @param model
     * @param queryCondition
     * @return
     * @throws ParseException
     */
    List<FhUser> getFhUserList(HttpServletRequest req, ModelAndView model, QueryCondition queryCondition) throws ParseException;


    /**
     * 获取用户分页数据，用于页面局部刷新
     * @param req
     * @param queryCondition
     * @return
     * @throws ParseException
     */
    Map getFhUserListPager(HttpServletRequest req,  QueryCondition queryCondition) throws ParseException;

    /**
     * 获取用户列表
     * @param req
     * @param model
     * @param queryCondition
     * @return
     * @throws ParseException
     */
    List<FhUser> getFhSysUserList(HttpServletRequest req, ModelAndView model, QueryCondition queryCondition) throws ParseException;


    /**
     * 获取用户分页数据，用于页面局部刷新
     * @param req
     * @param queryCondition
     * @return
     * @throws ParseException
     */
    Map getFhSysUserListPager(HttpServletRequest req,  QueryCondition queryCondition) throws ParseException;


    /**
     * 获取用户分页数据，用于页面局部刷新
     * @param req
     * @param queryCondition
     * @return
     * @throws ParseException
     */
    Object editSysUser(HttpServletRequest req, QueryCondition queryCondition) throws ParseException;

    /**
     * 用户浏览详情
     * @param req
     * @param model
     * @param qc
     * @return
     * @throws ParseException
     */
    List<PlatformBrowsingHistory> getFhUserBrowseDetailsList(HttpServletRequest req, ModelAndView model, QueryCondition qc) throws ParseException ;

    Map addSysUser(SysUser sysUser);

}
