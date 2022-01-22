package com.quan.myblog.service.log;


import com.github.pagehelper.PageInfo;
import com.quan.myblog.pojo.Log;

import java.util.List;

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
    
    
    /**
     * @Author Hilda
     * @Description //TODO 获取日志记录
     * @Date 11:05 2022/1/22
     * @Param [pageNums, pageSize]
     * @returnValue com.github.pagehelper.PageInfo<com.quan.myblog.pojo.Log>
     **/
    public PageInfo<Log> getLogs(int pageNums, int pageSize);

}
