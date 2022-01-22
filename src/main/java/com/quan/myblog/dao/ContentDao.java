package com.quan.myblog.dao;

import com.quan.myblog.pojo.Contents;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: ContentDao
 * @Description: 文章Dao
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/22 15:51
 */

@Mapper
public interface ContentDao {
    // 获取所有文章
    public List<Contents> getAllContents();
}
