package com.quan.myblog.contants;

/**
 * @ClassName: ErrorContants
 * @Description: 统一的错误代码提示
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 15:51
 */
public interface ErrorContants {
    interface Auth {
        static final String USERNAME_PASSWORD_IS_EMPTY = "用户名和密码不可为空";
        static final String USERNAME_PASSWORD_ERROR = "用户名不存在或密码错误";
        static final String NOT_LOGIN = "用户未登录";
    }

    interface Common {
        static final String PARAM_IS_EMPTY = "参数为空";
        static final String IVALID_PARAM = "无效的参数";
        static final String CAN_NOT_FIND_PARAM_TO_CONTINUE = "找不到参数继续运行";
    }
}
