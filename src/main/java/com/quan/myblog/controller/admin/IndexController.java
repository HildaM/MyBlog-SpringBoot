package com.quan.myblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: IndexController
 * @Description: 后台首页
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/20 17:07
 */

@Controller
@RequestMapping("/admin")
public class IndexController {

    // 进入首页
    @GetMapping("/index")
    public String intoIndex() {
        // TODO
        /***
         * 1. 日志记录
         * 2. 展示index.html上面相关的数据
         **/

        return "admin/index";
    }
}
