package com.fuhui.aspect;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.common.util.LocalDateUtils;
import com.fuhui.common.util.WebUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author : xufanglong
 * @Description:
 * @Date: create in 18:52 2017/11/30
 * @Modified By:
 */
public class ControllerLogAspect {
    static final Logger logger = LogManager.getLogger("Error");
    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间
    private StringBuffer bf = null;

    /**
     *
     * @Title：doBeforeInServiceLayer
     * @Description: 方法调用前触发 记录开始时间
     * @author
     * @date
     * @param joinPoint
     *
     * 			@Before("execution(* com.xinhua.data.controller..*.*(..))")
     */
    public void doBeforeInServiceLayer(JoinPoint joinPoint) {
        startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
    }

    /**
     *
     * @Title：doAfterInServiceLayer
     * @Description: 方法调用后触发 记录结束时间
     * @author
     * @date
     * @param joinPoint
     */
    public void doAfterInServiceLayer(JoinPoint joinPoint) {
        endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        this.printOptLog();
    }

    /**
     *
     * @Title：doAround
     * @Description: 环绕触发
     * @author
     * @date
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        try {
            result = pjp.proceed();// result的值就是被拦截方法的返回值;
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();
            // 获取请求地址
            // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
            bf = new StringBuffer();
            bf.append("\n\r");
            bf.append("[------START------][C-S]["+ LocalDateUtils.timeByFormat(null)+"]["+ WebUtil.getHost(request)+"]").append("\n\r");
            bf.append("[客户端-服务器][C-S|请求地址]->" + request.getRequestURL().append(StringUtils.isBlank(request.getQueryString()) ? "" : "?" + request.getQueryString())).append("\n\r");
            bf.append("[服务器-客户端][S-C|返回结果]->" + result).append("\n\r");
        } catch (Exception e) {

        }

        return result;
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @Before("execution(* com.anganglicai.data.controller..*.*(..))")
     *
     * @param joinPoint
     * @param e
     */
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // HttpSession session = request.getSession();
        // 读取session中的用户
        // User user = (User) session.getAttribute(WebConstants.CURRENT_USER);
        // 获取请求ip
        String ip = request.getRemoteAddr();
        // 获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                try {
                    params += JSONObject.toJSONString(joinPoint.getArgs()[i]) + ";";
                } catch (Exception exs) {}
            }
        }
        try {
            logger.error("X-ES->" + LocalDateUtils.timeByFormat(null) + "=====异常通知开始=====");
            logger.error("异常URL:" + request.getRequestURL().append(StringUtils.isBlank(request.getQueryString()) ? "" : "?" + request.getQueryString()));
            logger.error("异常代码:" + e.getClass().getName());
            logger.error("异常信息:" + e.getMessage());
            logger.error("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            logger.error("方法描述:" + getServiceMthodDescription(joinPoint));
            logger.error("请求IP:" + ip);
            logger.error("请求参数:" + params);
            logger.error("X-EE->" + LocalDateUtils.timeByFormat(null) + "=====异常通知结束=====");
			/* ==========记录本地异常日志========== */
        } catch (Exception ex) {
            // 记录本地异常日志
            logger.error("==异常通知异常==");
            logger.error("本地方法异常信息:{}", ex.getMessage());
        }

    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint
     *            切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint
     *            切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    break;
                }
            }
        }
        return description;
    }

    /**
     *
     * @Title：printOptLog
     * @Description: 输出日志
     * @author
     * @date
     */
    private void printOptLog() {
        bf.append("[服务器-客户端][S-C|处理时间]->" + (endTimeMillis - startTimeMillis) + "ms").append("\n\r");
        bf.append("[------END------][C-S]["+ LocalDateUtils.timeByFormat(null)+"]").append("\n\r");
        logger.info(bf.toString());
    }
}
