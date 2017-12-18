package com.fuhui.interceptor;

import com.fuhui.annoation.ApiCheck;
import com.fuhui.common.config.Resources;
import com.fuhui.common.util.BASE64Encoder;
import com.fuhui.common.util.SecurityUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

/**
 * @author : xufanglong
 * @Description:APi请求的验证
 * @Date: create in 21:36 2017/11/30
 * @Modified By:
 */
public class ApICheckInteceptor extends HandlerInterceptorAdapter {
    private final Logger Logger = LogManager.getLogger();
    String result="不正确";

    final Base64.Decoder decoder = Base64.getDecoder();
    final Base64.Encoder encoder = Base64.getEncoder();


    /**
     * 在Controller被调用前，先执行，可以在这里执行一些安全检查
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            ApiCheck apiCheck=((HandlerMethod) handler).getMethodAnnotation(ApiCheck.class);
            // 没有声明需要权限,或者声明不验证权限
            if (apiCheck == null || apiCheck.validate() == false) {
                return true;
            } else {
                String pub_key=Resources.CONFIG.getString("app.pub_key");
                String private_key= Resources.CONFIG.getString("app.private_key");
                String standard=Resources.CONFIG.getString("app.standard");
                String token=Resources.CONFIG.getString("app.token");

                //  获取传入的sign值
                String sign=request.getParameter("sign");
                if(sign==null ||"".equals(sign)){
                    Logger.info("Api请求的结果验签>>>>>>>>"+result);
                    response.sendRedirect("/api/err");
                    return false;
                }

                try{
                    byte[] asBytes = Base64.getDecoder().decode(sign);
                    // 输出为: 拼接的结果
                    String result=new String(asBytes, "utf-8");

                    String part1=result.substring(0,8);
                    String part2=result.substring(8,21);
                    String part3=result.substring(21);
                    if(!part1.equals(standard)){
                        Logger.info("Api请求的结果验签>>>>>>>>"+result);
                        response.sendRedirect("/api/err");
                        return false;
                    }
                    if(!part2.equals(token)){
                        Logger.info("Api请求的结果验签>>>>>>>>"+result);
                        response.sendRedirect("/api/err");
                        return false;
                    }
                    long xsad=System.currentTimeMillis() - Long.parseLong(part3);
                    if(xsad >120000){
                        Logger.info("Api请求的结果验签>>>>>>>>"+result);
                        response.sendRedirect("/api/err");
                        return false;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Logger.info("Api请求的结果验签>>>>>>>>"+result);
                    response.sendRedirect("/api/err");
                    return false;
                }
                return true;
            }
        } else{
            return true;
        }

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

    public static void main(String[] args){
        String finali=null;

        String part1="STANDARD";
        String part2="GGC%FVH=&7Fd9";
        String part3=String.valueOf(System.currentTimeMillis());
        finali=part1+part2+part3;

        try{
            String asB64 = Base64.getEncoder().encodeToString(finali.getBytes("utf-8"));
            System.out.println("编码结果: " + new String(asB64));
        } catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }

        try{
            byte[] asBytes = Base64.getDecoder().decode("U1RBTkRBUkRHR0MlRlZIPSY3RmQ5MTUxMjM3Nzc2MDM2MQ==");
            // 输出为: 拼接的结果
            String result=new String(asBytes, "utf-8");
            System.out.println(result);


        }catch (Exception e){
            e.printStackTrace();
        }







    }



}
