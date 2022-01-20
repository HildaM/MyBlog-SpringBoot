package com.quan.myblog.service.log;


/**
 * @ClassName: LogService
 * @Description: 日志模块业务层
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/20 14:33
 */


public interface LogService {

    /**
     * @Author Hilda
     * @Description //TODO 添加日志
     * @Date 14:39 2022/1/20
     * @Param [ip, authorId, action, data]
     * @returnValue void
     **/
    public void addLog(String ip, Integer authorId, String action, String data);


    /**
     * @Author Hilda
     * @Description //TODO 删除指定日志
     * @Date 15:13 2022/1/20
     * @Param [id]
     * @returnValue void
     **/
    public void deleteLog(Integer id);

}
