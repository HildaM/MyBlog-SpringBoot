package com.quan.myblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.quan.myblog.pojo.Log;
import com.quan.myblog.service.log.LogService;
import com.quan.myblog.utils.Commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: IndexController
 * @Description: 后台首页
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/20 17:07
 */

@Controller
@RequestMapping("/admin")
public class IndexController {

    // 日志输出
    public static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private LogService logService;

    // 进入首页
    @GetMapping("/index")
    public String intoIndex(HttpServletRequest request) {
        LOGGER.info("Enter admin: intoIndex method");

        // 加载页面公共工具类
        Commons commons = new Commons();
        request.setAttribute("commons", commons);


        // TODO
        /***
         * 1. 日志记录
         * 2. 展示index.html上面相关的数据
         **/

        // 获取所有日志:
        PageInfo<Log> logPageInfo = logService.getLogs(1, 5); // 1页，5条记录
        // 转换为List
        List<Log> logList = logPageInfo.getList();
        // 将日志list返回给前端
        request.setAttribute("logs", logList);

        LOGGER.info("Exit admin: intoIndex method");
        return "admin/index";
    }
}
