package com.fuhui.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.common.config.Constants;
import com.fuhui.common.util.RedisUtil;
import com.fuhui.mybatis.generator.dao.FhUserMapper;
import com.fuhui.mybatis.generator.model.FhUser;
import com.fuhui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : xufanglong
 * @Description:
 * @Date: create in 10:24 2017/12/12
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private FhUserMapper fhUserMapper;
    /**
     * 获取用户详情的信息
     * @return
     */
    @Override
    public JSONObject getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        JSONObject object=new JSONObject();
        String userid = RedisUtil.get(Constants.APP_SESSION + request.getSession().getId());
        FhUser fhUser=fhUserMapper.selectByPrimaryKey(Integer.parseInt(userid));

        if(null == fhUser || "".equals(fhUser)){
            object.put("status",100);
            object.put("msg","暂无用户的详情");
        }else{
            FhUser fhUsernew=new FhUser();
            fhUsernew.setId(fhUser.getId());
            fhUsernew.setName(fhUser.getName());
            fhUsernew.setIdcard(fhUser.getIdcard());
            fhUsernew.setLoginTimes(fhUser.getLoginTimes());
            fhUsernew.setMobile(fhUser.getMobile());
            fhUsernew.setCreateTime(fhUser.getCreateTime());
            object.put("status",200);
            object.put("msg","成功");
            object.put("info",fhUsernew);
        }
        return  object;
    }

    /**
     * 添加完善用户的信息
     * @return
     */
    @Override
    public JSONObject addUserInfo(HttpServletRequest request, HttpServletResponse response) {
        JSONObject object=new JSONObject();
        String name=request.getParameter("name");
        String idcard=request.getParameter("idcard");
        //姓名的检测
        String regExp = "^([a-zA-Z0-9\\u4e00-\\u9fa5\\·]{1,10})$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(name);
        if(!m.matches()){
            object.put("status",100);
            object.put("msg","姓名不合法");
        }
        //身份证的检测
        String regExpid = "^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|[xX])$";
        Pattern pi = Pattern.compile(regExpid);
        Matcher mi = pi.matcher(idcard);
        if(!mi.matches()){
            object.put("status",100);
            object.put("msg","身份证不合法");
        }
        String userid = RedisUtil.get(Constants.APP_SESSION + request.getSession().getId());
        FhUser fhUser=fhUserMapper.selectByPrimaryKey(Integer.parseInt(userid));
        fhUser.setName(name);
        fhUser.setIdcard(idcard);
        fhUserMapper.updateByPrimaryKeySelective(fhUser);
        object.put("status",200);
        object.put("msg","成功");
        return object;
    }



}
