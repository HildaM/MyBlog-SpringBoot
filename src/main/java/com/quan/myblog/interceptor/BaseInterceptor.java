package com.quan.myblog.interceptor;

import com.quan.myblog.contants.WebConst;
import com.quan.myblog.pojo.User;
import com.quan.myblog.utils.DataProcessUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: BaseInterceptor
 * @Description: 通用拦截器
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 17:42
 */

@Component
public class BaseInterceptor implements HandlerInterceptor {
    // 日志类
    private static final Logger LOGGE = LoggerFactory.getLogger(BaseInterceptor.class);
    // 用户登录设备：网络报文中的 user-agent 字段
    private static final String USER_AGENT = "user-agent";




    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 输出日志，记录登录者的ip和设备
        String uri = request.getRequestURI();

        LOGGE.info("UserAgent: {}", request.getHeader(USER_AGENT));
        LOGGE.info("用户来访地址: {}", uri);


        // 请求拦截处理
        User user = DataProcessUtils.getUserSession(request);

        // 如果user==null，即使没有Session，因为设置了”记住我“选项的话，本地会存留有cookie，也可以进行登录
        if (null == user) {
            // TODO
        }

        // 其他处理:
        // 手动进行连接的过滤
        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && null == user
                && !uri.startsWith("/admin/css") && !uri.startsWith("/admin/images")
                && !uri.startsWith("/admin/js") && !uri.startsWith("/admin/plugins")
                && !uri.startsWith("/admin/editormd")) {
            // 重定向
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
