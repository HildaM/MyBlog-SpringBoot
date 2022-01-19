package com.quan.myblog.controller.admin;

import com.quan.myblog.pojo.User;
import com.quan.myblog.service.user.UserService;
import com.quan.myblog.utils.Response;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * @ClassName: AuthController
 * @Description: 登录与注销模块
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 10:52
 */

@RequestMapping("/admin")
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String userLoggin() {
        return "admin/login";
    }

    // 登录模块
    @PostMapping("/login")
    @ResponseBody
    public Response userLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            @Param("username") String username,
            @Param("password") String password,
            @Param("remember_me") String remember_me

    ) {

        try {
            // 登录验证
            User user = userService.getUserByName(username);

            if (user != null && user.getPassword().equals(password)) {
                return Response.success();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.fail();
    }

}
