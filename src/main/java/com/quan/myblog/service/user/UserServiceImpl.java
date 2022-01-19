package com.quan.myblog.service.user;

import com.quan.myblog.contants.ErrorContants;
import com.quan.myblog.dao.UserDao;
import com.quan.myblog.exception.BlogException;
import com.quan.myblog.pojo.User;
import com.quan.myblog.utils.DataProcessUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName: UserServiceImpl
 * @Description: UserService 实现类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 11:16
 */

@Service
public class UserServiceImpl implements UserService{
    // 日志Logger


    @Autowired
    private UserDao userDao;


    // 登录业务
    @Override
    public User login(String username, String password) {
        // 数据验证
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            // 还有非法的空格字符
            throw new BlogException(ErrorContants.Auth.USERNAME_PASSWORD_IS_EMPTY);
        }

        // 对密码进行加密处理
        String pwd = DataProcessUtils.getMD5Code(username + password);

        // 检查是否存在这个用户
        User user = userDao.getUserByNameAndPwd(username, pwd);
        if (null == user)
            throw new BlogException(ErrorContants.Auth.USERNAME_PASSWORD_ERROR);


        return user;
    }
}
