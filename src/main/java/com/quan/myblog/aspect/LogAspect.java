package com.quan.myblog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @ClassName: LogAspect
 * @Description: 网站请求日志aop
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/20 15:52
 */

@Aspect
@Component
public class LogAspect {

    // 日志生成类
    private static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    // ThreadLocal
    /**
     * 由于这个是Web博客未来是要放到服务器上的，所以有多人同时访问的需求
     * 同一个请求在不同时间进行访问，开始访问的时间肯定是不同的。如何记录该请求的持续时间呢？
     * 所以这里需要使用到 ThreadLocal，为每一个请求单独设立一个独立的进程，往该进程里面存放该请求的访问时间。
     * 由于ThreadLocal对其他线程不可见，所以每一个不同的请求都可以单独保存自己独一无二的访问时间，所以就可以正确记录该请求的持续时间了！
     **/
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    // 将切面抽离出来
    @Pointcut("execution(public * com.quan.myblog.controller..*.*(..))")
    public void webLog() {}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录该请求的开始时间
        startTime.set(System.currentTimeMillis());

        // 接受到请求，并记录请求的信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();

        // 日志记录请求的内容
        // 访问地址
        LOGGER.info("URL: " + request.getRequestURI());
        // HTTP请求方法
        LOGGER.info("HTTP_METHOD: " + request.getMethod());
        // 访问的真实IP地址
        LOGGER.info("IP: " + request.getRemoteAddr());
        // 准备执行的类的类名和名字
        LOGGER.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // 类的参数列表
        LOGGER.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        LOGGER.info("RESPONSE: " + ret);
        LOGGER.info("SPEND TIME: " + (System.currentTimeMillis() - startTime.get()));
        // 用完后就清除threadLocal
        startTime.remove();
    }

}
