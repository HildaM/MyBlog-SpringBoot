package com.quan.myblog.service.user;

import com.quan.myblog.dao.UserDao;
import com.quan.myblog.pojo.User;
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
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByName(String username) {
        User user = userDao.getUserByName(username);
        if (user != null) return user;

        return null;
    }

    // 登录业务
    @Override
    public User login(String username, String password) {
        return null;
    }
}
