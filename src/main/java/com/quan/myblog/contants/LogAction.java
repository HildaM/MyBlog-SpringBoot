package com.quan.myblog.contants;

/**
 * @Author Hilda
 * @Description //TODO 日志表action字段
 * @Date 14:54 2022/1/20
 * @Param
 * @returnValue
 **/

public enum LogAction {
    LOGIN("登录后台"),
    UP_PWD("修改密码"),
    UP_INFO("修改个人信息");

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    LogAction(String action) {
        this.action = action;
    }
}
