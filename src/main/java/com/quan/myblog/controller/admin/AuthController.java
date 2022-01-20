package com.quan.myblog.controller.admin;

import com.quan.myblog.contants.WebConst;
import com.quan.myblog.pojo.User;
import com.quan.myblog.service.user.UserService;
import com.quan.myblog.utils.DataProcessUtils;
import com.quan.myblog.utils.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @ClassName: AuthController
 * @Description: 登录与注销模块
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 10:52
 */

@RequestMapping("/admin")
@Controller
public class AuthController {

    // 日志输出
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserService userService;

    // 处理get请求
    @GetMapping("/login")
    public String userLoggin() {
        return "admin/login";
    }


    /**
     * @Author Hilda
     * @Description //TODO 登录模块
     * @Date 14:00 2022/1/18
     * @Param [request, response, username, password, remember_me]
     * @returnValue com.quan.myblog.utils.Response
     **/
    @PostMapping("/login")
    @ResponseBody
    public Response userLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            @Param("username") String username,
            @Param("password") String password,
            @Param("remember_me") String remember_me
    ) {

        try {
            User user = userService.login(username, password);
            // 添加Session信息
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);

            // 设置‘记住我’功能
            if (!StringUtils.isBlank(remember_me)) {
                DataProcessUtils.setCookie(response, user.getUid());
            }

        } catch (Exception e) {
            // 登录失败
            LOGGER.error(e.getMessage());
            return Response.fail();
        }

        return Response.success();
    }


    /**
     * @Author Hilda
     * @Description //TODO 注销模块
     * @Date 17:04 2022/1/19
     * @Param [session, request]
     * @returnValue com.quan.myblog.utils.Response
     **/
    @RequestMapping("/logout")
    public void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        // 移除session
        request.removeAttribute(WebConst.LOGIN_SESSION_KEY);
        // 移除cookie
        Cookie cookie = new Cookie(WebConst.USER_COOKIE, "");
        cookie.setValue(null);
        cookie.setMaxAge(0);  // 立即消耗cookie
        cookie.setPath("/");
        response.addCookie(cookie);  // 相应给客户端

        // 进行路径跳转
        try {
            response.sendRedirect("/admin/login");
        } catch (IOException e) {
            // 跳转失败
            e.printStackTrace();
            LOGGER.error("注销失败", e);
        }

    }

}
