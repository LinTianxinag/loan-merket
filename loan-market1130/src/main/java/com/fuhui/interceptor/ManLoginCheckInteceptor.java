package com.fuhui.interceptor;


import com.fuhui.annoation.ManLoginCheck;
import com.fuhui.common.config.Constants;
import com.fuhui.common.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :Ren
 * @Description:管理后台的登陆认证
 * @Date: create in 14:45 2017/12/4
 * @Modified By:
 */
public class ManLoginCheckInteceptor extends HandlerInterceptorAdapter {

    /**
     * 在Controller被调用前，先执行，可以在这里执行一些安全检查
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            ManLoginCheck loginCheck=((HandlerMethod) handler).getMethodAnnotation(ManLoginCheck.class);
            if (loginCheck == null || loginCheck.validate() == false) {
                return true;
            } else {
                //根据session获取redis中用户id
                String userid = RedisUtil.get(Constants.WEB_SESSION + request.getSession().getId());
                //用户未登录
                if (userid == null || StringUtils.isBlank(userid)) {
                    response.sendRedirect("index");
                }else {
                    return true;
                }
                return false;
            }
        }
        return true;

    }

    /**
     * 在Controller调用全部完成后执行，如果ex变量不为空，表示有异常了，这里可以记录异常日志
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * Controller调用后执行，这时，可以修改ModelAndView，比如转到其它view之类
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        super.postHandle(request, response, handler, modelAndView);
    }


}
