package com.quan.myblog.controller;

import com.quan.myblog.dao.UserDao;
import com.quan.myblog.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: TestController
 * @Description: 控制层测试类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/18 15:19
 */

@Controller
public class TestController {
// 页面测试
    @RequestMapping("/article_edit")
    public String test01() {
        return "admin/article_edit";
    }

    @RequestMapping("/article_list")
    public String test02() {
        return "admin/article_list";
    }

    @RequestMapping("/attach")
    public String test03() {
        return "admin/attach";
    }

    @RequestMapping("/category")
    public String test04() {
        return "admin/category";
    }

    @RequestMapping("/comment_list")
    public String testt05() {
        return "admin/comment_list";
    }

    @RequestMapping("/footer")
    public String test06() {
        return "admin/footer";
    }

    @RequestMapping("/header")
    public String test07() {
        return "admin/header";
    }

    @RequestMapping("/admin/index")
    public String test08() {
        return "admin/index";
    }

    @RequestMapping("/links")
    public String test09() {
        return "admin/links";
    }

    @RequestMapping("/login")
    public String test10() {
        return "admin/login";
    }

    @RequestMapping("/page_edit")
    public String test11() {
        return "admin/page_edit";
    }

    @RequestMapping("/page_list")
    public String test12() {
        return "admin/page_list";
    }

    @RequestMapping("/profile")
    public String test13() {
        return "admin/profile";
    }

    @RequestMapping("/setting")
    public String test14() {
        return "admin/setting";
    }


// dao测试
    @Autowired
    private UserDao userDao;

    @RequestMapping("/testdao")
    public void testdao() {
        List<User> allUsers = userDao.getAllUsers();
        for (User u : allUsers) System.out.println(u);
    }
}
