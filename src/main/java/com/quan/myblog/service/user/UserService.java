package com.quan.myblog.service.user;

import com.quan.myblog.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserService
 * @Description: UserService接口
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 11:11
 */

@Service
public interface UserService {

    // 登录业务
    public User login(@Param("username") String username, @Param("password") String password);

}
