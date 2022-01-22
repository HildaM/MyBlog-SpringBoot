package com.quan.myblog.service.log;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quan.myblog.contants.ErrorContants;
import com.quan.myblog.dao.LogDao;
import com.quan.myblog.exception.BlogException;
import com.quan.myblog.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: LogServiceImpl
 * @Description: 日志模块Service实现类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/20 14:35
 */

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private LogDao logDao;

    /**
     * @Author Hilda
     * @Description //TODO 添加日志
     * @Date 14:40 2022/1/20
     * @Param [ip, authorId, action, data]
     * @returnValue void
     **/
    @Override
    public void addLog(String ip, Integer authorId, String action, String data) {
        Log log = new Log();
        log.setIp(ip);
        log.setAuthorId(authorId);
        log.setAction(action);
        log.setData(data);
        // Created自己生成
        logDao.addLog(log);
    }

    /**
     * @Author Hilda
     * @Description //TODO 删除指定日志
     * @Date 15:14 2022/1/20
     * @Param [id]
     * @returnValue void
     **/
    @Override
    public void deleteLog(Integer id) {
        if (null == id)
            throw BlogException.withErrorCode(ErrorContants.Common.PARAM_IS_EMPTY);
        logDao.deleteLog(id);
    }


    /**
     * @Author Hilda
     * @Description //TODO 获取所有日志记录
     * @Date 9:46 2022/1/22
     * @Param []
     * @returnValue java.util.List<com.quan.myblog.pojo.Log>
     **/
    @Override
    public PageInfo<Log> getLogs(int pageNums, int pageSize) {
        // 设置分页
        PageHelper.startPage(pageNums, pageSize);
        // 获取日志
        List<Log> allLogs = logDao.getAllLogs();
        // 封装
        PageInfo<Log> logPageInfo = new PageInfo<>(allLogs);

        return logPageInfo;
    }
}
