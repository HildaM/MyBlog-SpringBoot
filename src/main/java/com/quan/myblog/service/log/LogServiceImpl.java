package com.quan.myblog.service.log;

import com.quan.myblog.contants.ErrorContants;
import com.quan.myblog.dao.LogDao;
import com.quan.myblog.exception.BlogException;
import com.quan.myblog.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
