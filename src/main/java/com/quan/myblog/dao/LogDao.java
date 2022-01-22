package com.quan.myblog.dao;

import com.quan.myblog.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @ClassName: LogDao
 * @Description: 日志模块Dao层
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/20 14:02
 */

@Mapper
public interface LogDao {
    // 添加日志
    public int addLog(Log log);

    // 删除日志
    public int deleteLog(Integer id);

    // 获取所有日志
    public List<Log> getAllLogs();
}
