package com.quan.myblog.dao;

import com.quan.myblog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: UserDao
 * @Description: 用户dao接口
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 10:21
 */


@Mapper
public interface UserDao {
    // 查询所有用户
    public List<User> getAllUsers();

    // 根据姓名查找用户
    public User getUserByName(@Param("username") String username);
}
